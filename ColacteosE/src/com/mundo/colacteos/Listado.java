package com.mundo.colacteos;

import java.util.ArrayList;

import com.mundo.colacteos.visita.Cargar_Visita;
import com.mundo.colacteos.visita.Ejecutar_visitas;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Listado  extends Activity{
	
	// --------------------------------------------------------------------------
	//
	// --------------------------------------------------------------------------
	private Button rutero;
	private Button programacionVisita;
	private Button consultar_visita;
	private Button visita_por_solicitud;
	private Button utilidades;
	// ---------------------------------------------------------------------------------
	// se crea un boton
	// ---------------------------------------------------------------------------------
	private Button boton;
	// --------------------------------------------------------------------------
	// se crea una lista
	// --------------------------------------------------------------------------
	ListView lista;

	ArrayAdapter<String> adaptador;
	ArrayList<String> datos;

	// -----------------------------------------------------------------------
	// metodo que permite crear la instancia de la clase listado
	// -----------------------------------------------------------------------
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listado);
		// -----------------------------------------------------------------
		// ingresar al boton rutero
		// -------------------------------------------------------------
		rutero = (Button) findViewById(R.id.btn_Rute);
		rutero.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent in = new Intent(Listado.this, Rutero.class);
				startActivity(in);

			}
		});

		// -----------------------------------------------------------------
		// ingresar al boton programacion visita
		// -------------------------------------------------------------

		programacionVisita = (Button) findViewById(R.id.btn_programVisita);
		programacionVisita.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent inte= new Intent(Listado.this,Ejecutar_visitas.class );
				startActivity(inte);
			}
		});
		// -----------------------------------------------------------------
		// ingresar al boton consulta visita
		// -------------------------------------------------------------

		consultar_visita = (Button) findViewById(R.id.btn_salir_rutero);
		consultar_visita.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i= new Intent(Listado.this, Consultar_Visita.class);
				startActivity(i);
				
			}
		});
		
		
		// -----------------------------------------------------------------
		// ingresar al boton utilidades
		// -------------------------------------------------------------

		utilidades = (Button) findViewById(R.id.btn_utilidades);
		utilidades.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			Intent i= new Intent(Listado.this, Utilidades.class);
			startActivity(i);startActivity(i);startActivity(i);
				
			}
		});
		// ------------------------------------------------------------------------
		// boton que permite salir de la clase
		// ------------------------------------------------------------------------

		boton = (Button) findViewById(R.id.btnSalir);
		boton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				setResult(RESULT_OK);
				finish();

			}
		});

		// ---------------------------------------------------------------------
		// se agrega una lista
		// ----------------------------------------------------------------------

		datos = new ArrayList<String>();
		llenarLista();
		lista = (ListView) findViewById(R.id.listaSimple);

		adaptador = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, datos);
		lista.setAdapter(adaptador);
		lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View vista,
					int position, long arg3) {
				Toast.makeText(getApplicationContext(),
						"" + (String) ((TextView) vista).getText(),
						Toast.LENGTH_LONG).show();
			}

		});

	}

	// ----------------------------------------------------------
	// metodo que permite adicionar una descripcion a la lista
	// -----------------------------------------------------------
	public void llenarLista() {
		datos.add("Bienvenido");

	}

}
