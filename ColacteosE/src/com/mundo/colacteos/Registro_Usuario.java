package com.mundo.colacteos;

import java.util.ArrayList;

import com.Datos.colacteos.Usuario;
import com.bd.colacteos.usuarioDao;
import com.bd.colacteos.SQLiteHelper;
import com.mundo.colacteos.R;
import com.mundo.colacteos.R.id;
import com.mundo.colacteos.R.layout;




import android.R.string;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.Trace;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro_Usuario extends Activity  {



	private  usuarioDao objusuariodao;
	ArrayList<Usuario> lista= null;
	//---------------------------------------------------------------------------------
	// se crea un boton
	//---------------------------------------------------------------------------------
	EditText  editNombre, editApellidos, usuario, Password;
	private Button btnGuardar, listado;
	private Button btnCancelar;
	//private String user,pass, ape, nom;
	//private usuarioDao sqlite;
	//-----------------------------------------------------------------------
	@SuppressLint("WrongViewCast")
	//metodo que permite crear la instancia de la clase
	//-----------------------------------------------------------------------
	@Override
	protected void  onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registro_usuario);

		//------------------------------------------------------------------------
		//inicializa atributos
		//------------------------------------------------------------------------
		editNombre= (EditText)findViewById(R.id.txt_nombres);
		editApellidos= (EditText)findViewById(R.id.txt_apellidos);
		usuario= (EditText)findViewById(R.id.txt_nick);
		Password= (EditText)findViewById(R.id.txt_password);
		objusuariodao= new  usuarioDao(this);
		objusuariodao.abrir();

		//------------------------------------------------------------------------
		//boton que permite salir de la ventana
		//------------------------------------------------------------------------

		btnCancelar= (Button)findViewById(R.id.btn_cancelar_registro);
		btnCancelar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				setResult(RESULT_OK);
				finish();

			}
		});

		//------------------------------------------------------------------------
		//boton que permite guardar los datos del usuario a registrar
		//------------------------------------------------------------------------


	btnGuardar= (Button) findViewById(R.id.btn_guardar_Registro);
		btnGuardar.setOnClickListener(new View.OnClickListener() {


			@Override
			public void onClick(View v) {

				String nombre=editNombre.getText().toString();
				String apellido= editApellidos.getText().toString();
				String user= usuario.getText().toString();
				String pass= Password.getText().toString();
				
				

				//long i=0;
				//i= 
					
					objusuariodao.addRegistro(nombre, apellido, user, pass);
					
					
					if(objusuariodao==null){
						Toast.makeText(getApplicationContext(), "Registro No insertado", 1000).show();
					}
					else{
						Toast.makeText(getApplicationContext(), "Registro Insertado", 1000).show();
						editNombre.setText("");
						editApellidos.setText("");
						usuario.setText("");
						Password.setText("");
						editNombre.requestFocus();

					}}
				
			

		});
	listado=(Button)findViewById(R.id.btn_op_cultivo);
		listado.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i= new Intent(Registro_Usuario.this,ListaUsuario.class );
				startActivity(i);
			}
		});

	}
	
	public void toast(String msg) {
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
	}

	private void trace(String msg) {
		toast(msg);}
}
	//@Override
	/*public void onClick(View v) {
		switch (v.getId()) {
		/*case R.id.btn_guardar_Registro:

			String nombre=editNombre.getText().toString();
			String apellido= editApellidos.getText().toString();
			String user= usuario.getText().toString();
			String pass= Password.getText().toString();
			try {
				objusuariodao.addRegistro(nombre, apellido, user, pass);
				Intent main = new Intent(Registro_Usuario.this, ListaUsuario.class)
				.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(main);
		
		break;

			} catch (Exception e) {
				trace("Error : " + e.getMessage());
			}
			
			
		default:
			break;
		}
		
	}
		 
	public void toast(String msg) {
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
	}

	private void trace(String msg) {
		toast(msg);
	}*/
	
