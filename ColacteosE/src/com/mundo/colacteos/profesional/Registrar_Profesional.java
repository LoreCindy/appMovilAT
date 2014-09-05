package com.mundo.colacteos.profesional;

import com.bd.colacteos.Sat_profesionalDao;
import com.bd.colacteos.usuarioDao;
import com.mundo.colacteos.R;
import com.mundo.colacteos.R.id;
import com.mundo.colacteos.R.layout;
import com.mundo.colacteos.Utilidades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrar_Profesional extends Activity {
	
	
	 private  Sat_profesionalDao objprofesionaldao;
	// -----------------------------------------------------------
	// atributos de la clase Utilidades Profesional
	// -----------------------------------------------------------

	 EditText nombres,  apellidos, nit,	 titulo, institucion;
	 private Button registrarPro, cancelar;

	// -----------------------------------------------------------------------
	// metodo que permite crear la instancia de la clase
	// -----------------------------------------------------------------------
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.registrar_profesional);

	
	//------------------------------------------------------------------------
	// inicializacion de atributos
	// --------------------------------------------------------------------------
	
	nombres= (EditText)findViewById(R.id.txt_nombrepro);
	apellidos=(EditText)findViewById(R.id.txt_apepro);
	nit=(EditText)findViewById(R.id.txt_nitpro);
	titulo=(EditText)findViewById(R.id.txt_titupro);
	institucion=(EditText)findViewById(R.id.txt_institucion);
	objprofesionaldao= new  Sat_profesionalDao(this);
	objprofesionaldao.abrir();
	  
	
	// funcion del boton registrar de profesional
	// ------------------------------------------------------------------------
	registrarPro=(Button)findViewById(R.id.btn_registrarpro);
	registrarPro.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			String nombre=nombres.getText().toString();
			String apellido= apellidos.getText().toString();
			String nits= nit.getText().toString();
			String titulos =titulo.getText().toString();
			String institu =institucion.getText().toString();
			
			long i=0;
			try {
				i= objprofesionaldao.addRegistroProfesional(nits, nombre, apellido, titulos, institu);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			if(i==0){
				Toast.makeText(getApplicationContext(), "Profesional No Registrado", 1000).show();
			}
			else{
				Toast.makeText(getApplicationContext(), "Profesional Registrado con Exito", 1000).show();
				nombres.setText("");
				apellidos.setText("");
				nit.setText("");
				titulo.setText("");
				institucion.setText("");
				nombres.requestFocus();
			}
		}
	});
	
	cancelar=(Button)findViewById(R.id.btnCanPro);
	cancelar.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent i=new Intent(Registrar_Profesional.this, Utilidades.class);
			startActivity(i);
			
		}
	});
	
	}
	
	
}
