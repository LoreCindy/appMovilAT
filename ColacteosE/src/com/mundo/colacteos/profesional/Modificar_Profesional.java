package com.mundo.colacteos.profesional;

import com.bd.colacteos.Sat_profesionalDao;
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

public class Modificar_Profesional extends Activity  implements OnClickListener {
	
	
	EditText et,nit, nombre,apellido, titulo, institucion;
	Button editar, eliminar;
	long id;
	Sat_profesionalDao dbcon;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modificar_profesional);
		
		
		
		dbcon = new Sat_profesionalDao(this);
		dbcon.abrir();
		et=(EditText)findViewById(R.id.id_Profesional);
		nit = (EditText) findViewById(R.id.edt_nitp);
		nombre = (EditText) findViewById(R.id.edt_nomp);
		apellido = (EditText) findViewById(R.id.edt_apep);
		titulo = (EditText) findViewById(R.id.edt_titp);
		institucion= (EditText) findViewById(R.id.edt_instp);
		editar= (Button) findViewById(R.id.btn_actpro);
		eliminar = (Button) findViewById(R.id.btn_elmip);

		Intent i = getIntent();
		String memberID = i.getStringExtra("nit");
		String memberName = i.getStringExtra("nombres");
		String memberApe = i.getStringExtra("apellidos");
		String memberTit = i.getStringExtra("titulo");
		String memberInst = i.getStringExtra("institucion");

		id = Long.parseLong(memberID);
		nit.setText(memberID);
		nombre.setText(memberName);
		apellido.setText(memberApe);
		titulo.setText(memberTit);
		institucion.setText(memberInst);		

		editar.setOnClickListener(this);
		eliminar.setOnClickListener(this);

		
	}



	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_actpro:
			//id=nit.getText().toString();
			//String nits=nit.getText().toString();
			String nom = nombre.getText().toString();
			String ape= apellido.getText().toString();
			String tit = titulo.getText().toString();
			String inst = institucion.getText().toString();
			dbcon.updateProfesional(id, nom, ape, tit, inst);
			Toast.makeText(getApplicationContext(), "Se han actualizado los datos", 1000).show();

			this.returnHome();
			break;

		case R.id.btn_elmip:
			// Objetos. 
			AlertDialog.Builder mensaje_dialogo = new AlertDialog.Builder(this);  	

			// Variables.
			final Long m = id;

			mensaje_dialogo.setTitle("Importante");  
			mensaje_dialogo.setMessage("Esta seguro de eliminar profesional?");            
			mensaje_dialogo.setCancelable(false);  
			mensaje_dialogo.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {  
				public void onClick(DialogInterface dialogo1, int id) {  
					try{  


						dbcon.eliminarProfesional(m);
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
					Utilidades_Profesional.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

			startActivity(home_intent);
		}

	}
	
	
	
	
	


