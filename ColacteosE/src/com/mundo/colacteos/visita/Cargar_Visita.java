package com.mundo.colacteos.visita;

import java.sql.Date;

import com.bd.colacteos.SAT_VisitaDao;
import com.bd.colacteos.Sat_profesionalDao;
import com.bd.colacteos.UGG_informacionDao;
import com.mundo.colacteos.Listado;
import com.mundo.colacteos.R;
import com.mundo.colacteos.Utilidades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Cargar_Visita  extends Activity{
	
	
	//--------------------------------------------------
		//creacion de atributos
		//--------------------------------------------------
		EditText  fecha_vista;
		EditText hora_ingreso ;
		Spinner finca,profesional, clase_viista, asociado, tipoVisita ;
		private Button guardar, cancelar;
		 private Bundle bundle;
		

		// -----------------------------------------------------------------------
		// metodo que permite crear la instancia de la clase
		// -----------------------------------------------------------------------
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.programacion_visita);
			
			fecha_vista=(EditText)findViewById(R.id.editFechaVisita);
			hora_ingreso=(EditText)findViewById(R.id.editHoraVisita);
			
			finca=(Spinner)findViewById(R.id.spnFinca);
			profesional=(Spinner)findViewById(R.id.spnProfesional);
			clase_viista=(Spinner)findViewById(R.id.spnClaseVisita);
			asociado=(Spinner)findViewById(R.id.spnAsociado);
			tipoVisita=(Spinner)findViewById(R.id.spnTipoVisita);
			
			SAT_VisitaDao ob=new SAT_VisitaDao(this);
			ob.abrir();
			
			ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.ClaseVisita,android.R.layout.simple_spinner_item);
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			clase_viista.setAdapter(adapter);
			bundle = getIntent().getExtras();
			
			guardar=(Button)findViewById(R.id.btnAceptarVisita);
			cancelar=(Button)findViewById(R.id.btnCancelarProgramacion);
			
			
			
			
			
			
			
			
			
			//---------------------------------------------------------------
			//fincion del boton guardar
			//---------------------------------------------------------------
			
			
			guardar.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
				}
			});

			//---------------------------------------------------------------
			//fincion del boton cancelar
			//---------------------------------------------------------------
			cancelar.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent i= new Intent(Cargar_Visita.this, Listado.class);
					startActivity(i);
					
				}
			});
			
			
			
			
		}
}
