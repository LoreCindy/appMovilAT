package com.mundo.colacteos;


import com.colacteos.actividades.Utilidades_Actividades;
import com.colacteos.casuistica.Utilidades_Casuistica;
import com.colacteos.cultivo.Utilidades_Cultivo;
import com.mundo.colacteos.asociado.Utilidades_Asociado;
import com.mundo.colacteos.fincas.Registrar_Finca;
import com.mundo.colacteos.fincas.Utilidades_Finca;
import com.mundo.colacteos.forraje.Utilidades_Forraje;
import com.mundo.colacteos.profesional.Registrar_Profesional;
import com.mundo.colacteos.profesional.Utilidades_Profesional;
import com.mundo.colacteos.sistema.Utilidades_Sistema;
import com.mundo.colacteos.ugg.Registrar_Ugg;
import com.mundo.colacteos.ugg.Utilidades_Animal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Utilidades extends Activity {

	// --------------------------------------------------------------------------
	//
	// --------------------------------------------------------------------------
	private Button opProfesional;
	private Button opAsociado;
	private Button opFincas;
	private Button opAnimales;
	private Button cultivo;
	private Button opForraje;
	private Button casuistica;
	private Button sistema;
	private Button actividades;
	private Button atrasUtil;

	// -----------------------------------------------------------------------
	// metodo que permite crear la instancia de la clase
	// -----------------------------------------------------------------------
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.utilidades);

		// --------------------------------------------------------------------------
		// funcion del boton opciones de profesional
		// ------------------------------------------------------------------------
		opProfesional = (Button) findViewById(R.id.btn_op_prof);
		opProfesional.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent in = new Intent(Utilidades.this,	Utilidades_Profesional.class);
				startActivity(in);

			}
		});

		// --------------------------------------------------------------------------
		// funcion del boton opciones de Asociado
		// ------------------------------------------------------------------------

		opAsociado = (Button) findViewById(R.id.btn_op_as);
		opAsociado.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent in= new Intent(Utilidades.this, Utilidades_Asociado.class);
				startActivity(in);

			}
		});

		// --------------------------------------------------------------------------
		// funcion del boton opciones de Fincas
		// ------------------------------------------------------------------------
		opFincas = (Button) findViewById(R.id.btn_op_finc);
		opFincas.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent in= new Intent(Utilidades.this, Utilidades_Finca.class);
				startActivity(in);
			}
		});

		// --------------------------------------------------------------------------
		// funcion del boton opciones de Animales
		// ------------------------------------------------------------------------

		opAnimales = (Button) findViewById(R.id.btn_op_ani);
		opAnimales.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent in=new Intent(Utilidades.this, Utilidades_Animal.class);
				startActivity(in);
			}
		});
		
		// --------------------------------------------------------------------------
		// funcion del boton opciones de Cultivos
		// ------------------------------------------------------------------------

		cultivo=(Button)findViewById(R.id.btn_op_cultivo);
		cultivo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent n=new Intent(Utilidades.this, Utilidades_Cultivo.class);
				startActivity(n);
				
			}
		});
		// --------------------------------------------------------------------------
		// funcion del boton opciones de forraje
		// ------------------------------------------------------------------------
		opForraje=(Button)findViewById(R.id.btn_op_forraje);
		opForraje.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent n=new Intent(Utilidades.this, Utilidades_Forraje.class);
				startActivity(n);
				
			}
		});
		
		// --------------------------------------------------------------------------
		// funcion del boton opciones de  casuistica
		// ------------------------------------------------------------------------
		casuistica=(Button)findViewById(R.id.btn_op_casuistica);
		casuistica.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
			}
		});

		// --------------------------------------------------------------------------
		// funcion del boton opciones de sistema
		// ------------------------------------------------------------------------
		sistema=(Button)findViewById(R.id.btn_op_solicitud);
		sistema.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent n=new Intent(Utilidades.this, Utilidades_Sistema.class);
				startActivity(n);
				
			}
		});
		// --------------------------------------------------------------------------
		// funcion del boton opciones de casuistica
		// ------------------------------------------------------------------------
		casuistica=(Button)findViewById(R.id.btn_op_casuistica);
		casuistica.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent n=new Intent(Utilidades.this, Utilidades_Casuistica.class);
				startActivity(n);
				
				
			}
		});
		// --------------------------------------------------------------------------
		// funcion del boton opciones de actividades
		// ------------------------------------------------------------------------
		actividades=(Button)findViewById(R.id.btn_op_actividades);
		actividades.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent n=new Intent(Utilidades.this, Utilidades_Actividades.class);
				startActivity(n);
				
			}
		});
		
	}
}
