package com.mundo.colacteos.sistema;

import com.bd.colacteos.SAT_SistemaDao;
import com.bd.colacteos.Sat_profesionalDao;
import com.mundo.colacteos.R;
import com.mundo.colacteos.profesional.Utilidades_Profesional;

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

public class Modificar_Sistema extends Activity implements OnClickListener{
	
	
	//-----------------------------------------
	//atributos
	//-----------------------------------------
	
	EditText et, codigo, nombre;
	Button editar, eliminar;
	
	long id;
	
	//----------------------------------------------
	//clase DAO
	//----------------------------------------------
	
	SAT_SistemaDao dbcon;
	
	
	//---------------------------------------------
	//
	//---------------------------------------------
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modificar_sistema);
		
		
		dbcon = new SAT_SistemaDao(this);
		dbcon.abrir();
		//et=(EditText)findViewById(R.id.id_Profesional);
		et = (EditText) findViewById(R.id.edt_codSiste);
		nombre = (EditText) findViewById(R.id.edt_nomSist);
		editar= (Button) findViewById(R.id.btn_actuSis);
		eliminar = (Button) findViewById(R.id.btn_elimiSis);
		
		
		
		Intent i = getIntent();
		String memberID = i.getStringExtra("codigo");
		String memberName = i.getStringExtra("nombre");
		
		id = Long.parseLong(memberID);
		et.setText(memberID);
		nombre.setText(memberName);
		
		
		editar.setOnClickListener(this);
		eliminar.setOnClickListener(this);

	}
	

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_actuSis:
			
			String nom = nombre.getText().toString();
			
			dbcon.actualizarSistema(id, nom);
			Toast.makeText(getApplicationContext(), "Se han actualizado los datos", 1000).show();

			this.returnHome();
			break;

		case R.id.btn_elimiSis:
			// Objetos. 
			AlertDialog.Builder mensaje_dialogo = new AlertDialog.Builder(this);  	

			// Variables.
			final Long m = id;

			mensaje_dialogo.setTitle("Importante");  
			mensaje_dialogo.setMessage("Esta seguro de eliminar Sistema?");            
			mensaje_dialogo.setCancelable(false);  
			mensaje_dialogo.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {  
				public void onClick(DialogInterface dialogo1, int id) {  
					try{  


						dbcon.eliminarSistema(m);
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
				Utilidades_Sistema.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

		startActivity(home_intent);
	}



	

}
