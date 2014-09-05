package com.mundo.colacteos.sistema;

import com.bd.colacteos.SAT_SistemaDao;
import com.mundo.colacteos.R;
import com.mundo.colacteos.Utilidades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrar_Sistema extends Activity{

	//------------------------
	//atributos
	//----------------------------------
	Button aceptar, cancelar;
	EditText codigo, nombre;
	
	private SAT_SistemaDao obj;
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registrar_sistema);
		
		codigo=(EditText)findViewById(R.id.edt_codSistema);
		nombre=(EditText)findViewById(R.id.edt_nomSistema);
		aceptar=(Button)findViewById(R.id.btn_op_solicitud);
		cancelar=(Button)findViewById(R.id.btn_cancelarRegistroSistema);
		obj= new SAT_SistemaDao(this);
		obj.abrir();
		
		
		
		//----------------------------------
		// funciond del boton aceptar
		//----------------------------------
		aceptar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				String codigo_sistema=codigo.getText().toString();
				String nombre_sistema= nombre.getText().toString();
				
				
				long i=0;
				try {
					i= obj.crearSistema(codigo_sistema, nombre_sistema);
					
					
					if(i==0){
						Toast.makeText(getApplicationContext(), "Sistema No insertado", 1000).show();
					}
					else{
						Toast.makeText(getApplicationContext(), "Sistema Insertado", 1000).show();
						codigo.setText("");
						nombre.setText("");
						nombre.requestFocus();
						

					}
				}
				
				catch (Exception e) {
					
					e.getMessage();
					
				}
				}
				
			
		});
		
		cancelar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			Intent  i= new Intent(Registrar_Sistema.this, Utilidades.class);
				
			}
		});
		
		
	}
	
	
	
	
	

}
