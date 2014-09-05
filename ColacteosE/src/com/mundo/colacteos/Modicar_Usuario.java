package com.mundo.colacteos;

import com.bd.colacteos.usuarioDao;
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

public class Modicar_Usuario extends Activity implements OnClickListener  {

	

	EditText et, nombre, apellido, usuario, password;
	Button editar, eliminar;
	long id;
	usuarioDao dbcon;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modificar_usuario);
		
		
		dbcon = new usuarioDao(this);
		dbcon.abrir();
		et=(EditText)findViewById(R.id.edt_id);
		nombre = (EditText) findViewById(R.id.edt_nom);
		apellido = (EditText) findViewById(R.id.edt_ape);
		usuario = (EditText) findViewById(R.id.edt_usu);
		password = (EditText) findViewById(R.id.edt_pass);
		editar= (Button) findViewById(R.id.btn_actuUs);
		eliminar = (Button) findViewById(R.id.btn_elimUsu);

		Intent i = getIntent();
		String memberID = i.getStringExtra("id");
		String memberName = i.getStringExtra("Nombre");
		String memberApe = i.getStringExtra("apellido");
		String memberUsu = i.getStringExtra("usuario");
		String memberPass = i.getStringExtra("pass");

		id = Long.parseLong(memberID);
		
		nombre.setText(memberName);
		apellido.setText(memberApe);
		usuario.setText(memberUsu);
		password.setText(memberPass);		

		editar.setOnClickListener(this);
		eliminar.setOnClickListener(this);

		
		
	}

	

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_actuUs:
			String nom = nombre.getText().toString();
			String ape= apellido.getText().toString();
			String usu = usuario.getText().toString();
			String pass = password.getText().toString();
			dbcon.updateUsuario(id, nom, ape, usu, pass);
			Toast.makeText(getApplicationContext(), "Se han Actualizado los datos", 1000).show();
			this.returnHome();
			break;

		case R.id.btn_elimUsu:
			// Objetos. 
			AlertDialog.Builder mensaje_dialogo = new AlertDialog.Builder(this);  	
			
			// Variables.
			final Long m = id;
			    
			mensaje_dialogo.setTitle("Importante");  
			mensaje_dialogo.setMessage("Esta seguro de eliminar el usuario?");            
			mensaje_dialogo.setCancelable(false);  
			mensaje_dialogo.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {  
		        public void onClick(DialogInterface dialogo1, int id) {  
		            try{    		
			
			dbcon.deleteUsurio(m);
			Toast.makeText(getApplicationContext(), "Registro Eliminado", 1000).show();
			
			returnHome();
			
			//break;
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
				ListaUsuario.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

		startActivity(home_intent);
	}



}
