package com.mundo.colacteos.forraje;


import com.bd.colacteos.SAT_forrajeDao;
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

public class Modificar_Forraje extends Activity implements OnClickListener{

	//-----------------------------------------
	//atributos
	//-----------------------------------------

	EditText et, codigo, forraje;
	Button editar, eliminar;

	long id;

	//----------------------------------------------
	//clase DAO
	//----------------------------------------------

	SAT_forrajeDao dbcon;
	
	
	//---------------------------------------------
	// Instancia de la clase 
	//---------------------------------------------

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modificar_forraje);
		
		
		dbcon = new SAT_forrajeDao(this);
		dbcon.abrir();
		//et=(EditText)findViewById(R.id.id_Profesional);
		et = (EditText) findViewById(R.id.edt_codForr);
		forraje = (EditText) findViewById(R.id.edt_nomForr);
		
		editar= (Button) findViewById(R.id.btn_actForr);
		eliminar = (Button) findViewById(R.id.btn_elimForr);
		
		
		Intent i = getIntent();
		String memberID = i.getStringExtra("codigo");
		String memberName = i.getStringExtra("forraje");
		
		id = Long.parseLong(memberID);
		et.setText(memberID);
		forraje.setText(memberName);
		
		
		editar.setOnClickListener(this);
		eliminar.setOnClickListener(this);
	}

	

	
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_actForr:
			
			String forr = forraje.getText().toString();
			
			
			dbcon.actualizarForraje(id, forr);
			Toast.makeText(getApplicationContext(), "Se han Actualizado los datos", 1000).show();
			this.returnHome();
			break;

		case R.id.btn_elimForr:
			// Objetos. 
			AlertDialog.Builder mensaje_dialogo = new AlertDialog.Builder(this);  	

			// Variables.
			final Long m = id;

			mensaje_dialogo.setTitle("Importante");  
			mensaje_dialogo.setMessage("Esta seguro de eliminar el Forraje?");            
			mensaje_dialogo.setCancelable(false);  
			mensaje_dialogo.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {  
				public void onClick(DialogInterface dialogo1, int id) {  
					try{  
						
					
			dbcon.eliminarForraje(m);
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
				Utilidades_Forraje.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

		startActivity(home_intent);
	}


}
