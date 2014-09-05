package com.colacteos.actividades;

import com.bd.colacteos.ActividadDao;
import com.mundo.colacteos.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Modificar_Actividad extends Activity  implements OnClickListener{

	//-----------------------------------------
	//atributos
	//-----------------------------------------

	EditText  codigo, actividad, costo;
	Button editar, eliminar;

	long id;

	//----------------------------------------------
	//clase DAO
	//----------------------------------------------

	ActividadDao dbcon;

	//---------------------------------------------
	// Instancia de la clase 
	//---------------------------------------------
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modificar_actividad);
		
		
		
		dbcon = new ActividadDao(this);
		dbcon.abrir();
		
		codigo = (EditText) findViewById(R.id.edt_idActi);
		actividad = (EditText) findViewById(R.id.edt_activi);
		costo=(EditText)findViewById(R.id.edt_cosActi);
		editar= (Button) findViewById(R.id.btn_actuAct);
		eliminar = (Button) findViewById(R.id.btn_elimActi);
		
		
		
		Intent i = getIntent();
		String memberID = i.getStringExtra("codigo");
		String memberName = i.getStringExtra("actividad");
		String memberCos = i.getStringExtra("costo");
		
		id = Long.parseLong(memberID);
		codigo.setText(memberID);
		actividad.setText(memberName);
		costo.setText(memberCos);

		
		
		editar.setOnClickListener(this);
		eliminar.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
			
		switch (v.getId()) {
		case R.id.btn_actuAct:
			
			String acti = actividad.getText().toString();
			String costoA = costo.getText().toString();
			
			dbcon.actualizarActividad(id, acti, costoA);
			Toast.makeText(getApplicationContext(), "se han actualizado los datos", 1000).show();
			
			this.returnHome();
			break;

		case R.id.btn_elimActi:
			
			// Objetos. 
			AlertDialog.Builder mensaje_dialogo = new AlertDialog.Builder(this);  	

			// Variables.
			final Long m = id;

			mensaje_dialogo.setTitle("Importante");  
			mensaje_dialogo.setMessage("Esta seguro de eliminar la actividad?");            
			mensaje_dialogo.setCancelable(false);  
			mensaje_dialogo.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {  
				public void onClick(DialogInterface dialogo1, int id) {  
					try{  


						dbcon.eliminarActividad(m);
						Toast.makeText(getApplicationContext(), "Registro Eliminado", 1000).show();

						returnHome();


					}catch(Exception e){
						Toast.makeText(getApplicationContext(), "Error al eliminar!!!", Toast.LENGTH_LONG).show();
						e.printStackTrace();
					}finally{
						dbcon.cerrar();

					}
				}  
			});  
			mensaje_dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {  
				public void onClick(DialogInterface dialogo1, int id) {  
					returnHome();
				}  
			});            
			mensaje_dialogo.show();  }


								
								
		}
	
	
	public void returnHome() {

		Intent home_intent = new Intent(getApplicationContext(),
				Utilidades_Actividades.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

		startActivity(home_intent);
	}

	

}
