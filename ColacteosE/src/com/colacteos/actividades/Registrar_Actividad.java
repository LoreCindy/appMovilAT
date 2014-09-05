package com.colacteos.actividades;

import com.bd.colacteos.ActividadDao;
import com.colacteos.cultivo.Registrar_Cultivo;
import com.mundo.colacteos.R;
import com.mundo.colacteos.Utilidades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.VideoView;

public class Registrar_Actividad  extends Activity{
	
	//----------------------------------------------------
	//atributos
	//----------------------------------------------------

	EditText codigo, actividad, costo;
	private Button agregar, cancelar;
	
	ActividadDao ob;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registrar_actividad);
		
		
		
		codigo=(EditText)findViewById(R.id.edt_idActividad);
		actividad=(EditText)findViewById(R.id.edt_actividadDes);
		costo=(EditText)findViewById(R.id.edt_costoActividad);
		
		ob= new ActividadDao(this);
		ob.abrir();
		
		agregar=(Button)findViewById(R.id.btn_regsitrarActividad);
		agregar.setOnClickListener(new  View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String codigoA=codigo.getText().toString();
				String nombre= actividad.getText().toString();
				String costoA= costo.getText().toString();
				

				//long i=0;
				//i= 
					
						ob.agregarActividad(codigoA, nombre, codigoA);
					
					
					if(ob==null){
						Toast.makeText(getApplicationContext(), "Registro No insertado", 1000).show();
					}
					else{
						Toast.makeText(getApplicationContext(), "Registro Insertado", 1000).show();
						codigo.setText("");
						actividad.setText("");
						costo.setText("");
						
						actividad.requestFocus();

					}}
				
				
			
		});
		
		cancelar=(Button)findViewById(R.id.btn_canceActi);
		cancelar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i=new Intent(Registrar_Actividad.this, Utilidades.class);
				startActivity(i);

			}
		});
	}
	
	

}
