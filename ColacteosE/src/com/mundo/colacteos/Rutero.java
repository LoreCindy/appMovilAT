package com.mundo.colacteos;

import com.mundo.colacteos.visita.Cargar_Visita;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Rutero extends Activity {
	
	
	//--------------------------------------------------
	//creacion de atributos
	//--------------------------------------------------

	Button  solicitud;
	private Button salida;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rutero);
	

		//--------------------------------------------------------------------------
		//inicializacion y metodo del boton salir de rutero
		//--------------------------------------------------------------------------
		solicitud=(Button)findViewById(R.id.btn_op_solicitud);
		solicitud.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intt= new Intent(Rutero.this, Cargar_Visita.class);
				startActivity(intt);

			}
		});


	
	//--------------------------------------------------------------------------
	//inicializacion y metodo del boton salir de rutero
	//--------------------------------------------------------------------------
	salida= (Button)findViewById(R.id.btn_salir_rutero);
	salida.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intt= new Intent(Rutero.this, Listado.class);
			startActivity(intt);
			
		}
	});
	
	}

	

}
