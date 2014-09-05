package com.mundo.colacteos.forraje;


import com.bd.colacteos.SAT_forrajeDao;
import com.bd.colacteos.usuarioDao;
import com.mundo.colacteos.R;
import com.mundo.colacteos.Utilidades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registrar_Forraje extends Activity{
	
	
	/*
	 * atributos de la clase
	 */
	private SAT_forrajeDao forrajeDao;
	
	private Button aceptar, cancelar;
	private EditText codigo, nombre;
	
	
	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registrar_forraje);
		
		codigo=(EditText)findViewById(R.id.edt_codSistema);
		nombre=(EditText)findViewById(R.id.edt_nomSistema);
		forrajeDao= new SAT_forrajeDao(this);
		forrajeDao.abrir();
		
		
		/*
		 * funcion del boton cancelar registro forraje
		 */
		cancelar=(Button)findViewById(R.id.btn_cancelarRegistroSistema);
		cancelar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			Intent i= new Intent(Registrar_Forraje.this, Utilidades.class);
			startActivity(i);
				
			}
		});
		
		/*
		 * funcion del boton guaradar registro forraje
		 */
		
		aceptar=(Button)findViewById(R.id.btn_guardaForraje);
		aceptar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				String codigo_forraje=codigo.getText().toString();
				String nombre_forraje= nombre.getText().toString();
				
				
				long i=0;
				try {
					i= forrajeDao.agregarForraje(codigo_forraje, nombre_forraje);
					
					
					if(i==1){
						Toast.makeText(getApplicationContext(), "Forraje No insertado", 1000).show();
					}
					else{
						Toast.makeText(getApplicationContext(), "Forraje Insertado", 1000).show();
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
		
	}

	

}
