package com.mundo.colacteos;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bd.colacteos.usuarioDao;
//import com.bd.colacteos.SQLiteHelper;
//import android.database.sqlite.SQLiteOpenHelper;

public class MainActivity extends Activity {

	//--------------------------------------------------
	//creacion de atributos
	//--------------------------------------------------

	 private EditText usu;
	 private EditText pass;
	 private Button btnRegistrar;
	 private Button btnCancelar;
	 private Button btnLogin;
	 private  usuarioDao objusuariodao;
	//-------------------------
	//>/ private usuarioDao sqlite;
	 //--------------------------
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//SQLiteOpenHelper helper=  new SQLiteHelper(this);
		
		usu = (EditText) findViewById(R.id.edUsuario);
		pass = (EditText) findViewById(R.id.edPassword);
		objusuariodao= new  usuarioDao(this);
		  objusuariodao.abrir();
		btnLogin = (Button) findViewById(R.id.btnIngresaL);
		btnLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				
			
				InputMethodManager ini = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE); 
				ini.hideSoftInputFromWindow(usu.getWindowToken(), 0);
				ini.hideSoftInputFromWindow(pass.getWindowToken(), 0);
				String usuario = usu.getText().toString();
				String password = pass.getText().toString();
				
							
				if (objusuariodao.Login(usuario, password))
						//usuario.equals("c")&& password.equals("1"))
				{
					Intent i=new Intent(MainActivity.this, Listado.class);
					startActivity(i);
					
				}
				else {
					Toast.makeText(getBaseContext(), "Error: Compruebe que los datos sean correctos", Toast.LENGTH_SHORT).show();
				}
				
				}
			});

		
		btnCancelar = (Button) findViewById(R.id.btnSalirLogin);
		btnCancelar.setOnClickListener(new OnClickListener() {
			
			
			
			@Override
			public void onClick(View v) {
				finish();
				
			}
		});
		
		btnRegistrar = (Button) findViewById(R.id.btn_registrarAso);
		btnRegistrar.setOnClickListener(new OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
			Intent intent= new Intent(MainActivity.this, Registro_Usuario.class);
			startActivity(intent);
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	
	}

	
}