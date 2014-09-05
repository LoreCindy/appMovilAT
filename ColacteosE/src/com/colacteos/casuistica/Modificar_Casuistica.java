package com.colacteos.casuistica;

import com.bd.colacteos.SAT_SistemaDao;
import com.bd.colacteos.SAT_casuisticaDao;
import com.mundo.colacteos.R;
import com.mundo.colacteos.sistema.Utilidades_Sistema;

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

public class Modificar_Casuistica extends Activity implements OnClickListener{

	//-----------------------------------------
	//atributos
	//-----------------------------------------

	EditText et, codigo, sistema, enfermedad;
	Button editar, eliminar;

	long id;

	//----------------------------------------------
	//clase DAO
	//----------------------------------------------

	SAT_casuisticaDao dbcon;



	//---------------------------------------------
	// Instancia de la clase 
	//---------------------------------------------
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modificar_casuistica);
		
		
		
		dbcon = new SAT_casuisticaDao(this);
		dbcon.abrir();
		//et=(EditText)findViewById(R.id.id_Profesional);
		et = (EditText) findViewById(R.id.edt_codCasuistica);
		enfermedad = (EditText) findViewById(R.id.edt_enferCas);
		sistema=(EditText)findViewById(R.id.edt_sisst);
		editar= (Button) findViewById(R.id.btn_actuCas);
		eliminar = (Button) findViewById(R.id.btn_elimCasu);
		
		
		
		Intent i = getIntent();
		String memberID = i.getStringExtra("codigo");
		String memberName = i.getStringExtra("enfermedad");
		String memberSis = i.getStringExtra("sistema");
		
		id = Long.parseLong(memberID);
		et.setText(memberID);
		enfermedad.setText(memberName);
		sistema.setText(memberSis);

		
		
		editar.setOnClickListener(this);
		eliminar.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_actuCas:
			
			String enfer = enfermedad.getText().toString();
			String sistemas = sistema.getText().toString();
			
			dbcon.actualizarCasuistica(id, enfer, sistemas);
			Toast.makeText(getApplicationContext(), "se han actualizado los datos", 1000).show();
			
			this.returnHome();
			break;

		case R.id.btn_elimCasu:
			
			// Objetos. 
						AlertDialog.Builder mensaje_dialogo = new AlertDialog.Builder(this);  	

						// Variables.
						final Long m = id;

						mensaje_dialogo.setTitle("Importante");  
						mensaje_dialogo.setMessage("Esta seguro de eliminar Casuistica?");            
						mensaje_dialogo.setCancelable(false);  
						mensaje_dialogo.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {  
							public void onClick(DialogInterface dialogo1, int id) {  
								try{  
									
								
						dbcon.eliminarCasuistica(m);
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
				Utilidades_Casuistica.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

		startActivity(home_intent);
	}


}
