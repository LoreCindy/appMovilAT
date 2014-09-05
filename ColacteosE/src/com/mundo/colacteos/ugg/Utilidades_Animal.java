package com.mundo.colacteos.ugg;

import com.bd.colacteos.SAT_SistemaDao;
import com.bd.colacteos.SQLiteHelper;
import com.bd.colacteos.UGG_informacionDao;
import com.mundo.colacteos.R;
import com.mundo.colacteos.sistema.Utilidades_Sistema;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Utilidades_Animal  extends Activity{

	// -----------------------------------------------------------
	// atributos de la clase Utilidades Asociado
	// -----------------------------------------------------------
			private Button adicionar_animal;
		
			ListView lv;
		
			
			TextView cod, nombre, fecha_nacimiento, peso_UGG, raza, fecha_venta,
			fecha_muerte,motivo_muerte,genero, codigo_finca,cantidad_abortos,
			servicio_toro,  tipo_animal, numero_partos;
			
			
	// -----------------------------------------------------------------------
	// metodo que permite crear la instancia de la clase utilidades de animal
	// -----------------------------------------------------------------------
			
			@Override
			protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.utilidades_animales);
				
				
				

				//---------------------------------------------------------------------
				//lista de animales
				//---------------------------------------------------------------------
				UGG_informacionDao	dbcon= new UGG_informacionDao(this);
				dbcon.abrir();
				lv=(ListView)findViewById(R.id.listaUGG);
				Cursor cursor=dbcon.listaAnimales();
				SQLiteHelper SqlHelper;
				SqlHelper=new SQLiteHelper(this);
				String[] from = new String[] {
						SqlHelper.codigo_UGG, 
						SqlHelper.nombre_UGG,
						SqlHelper.fecha_nacimiento,
						SqlHelper.peso_UGG,
						SqlHelper.raza_UGG,
						SqlHelper.fecha_venta,
						SqlHelper.fecha_muerte, 
						SqlHelper.motivo_muerte, 
						SqlHelper.genero,
						SqlHelper.codigo_finca,
						SqlHelper.cantidad_abortos,
						SqlHelper.servicio_toro,
						SqlHelper.tipo_animal,
						SqlHelper.numero_partos	}; 
				int[] to = new int[] { 
					R.id.txt_codigoAnimal,
					R.id.txt_nombreAnimal,
					R.id.txt_fechaNacimiento,
					R.id.txt_pesoAnimal,
					R.id.txt_razaAnimal,
					R.id.txt_fechaVenta,
					R.id.txt_fechaMuerte,
					R.id.txt_motivoMuerte,
					R.id.txt_generoAnimal,
					R.id.txt_codigoFincaAnimal,
					R.id.txt_cantidadAbortos,
					R.id.txt_servicioToro,
					R.id.txt_tipoAnimal,
					R.id.txt_numPartoss,
					
						};
				SimpleCursorAdapter adapter= new SimpleCursorAdapter(Utilidades_Animal.this, R.layout.adaptador_ugg, cursor, from, to);	
				adapter.notifyDataSetChanged();
				lv.setAdapter(adapter);
				
				

	// ------------------------------------------------------------------
	// accion del boton adicionar animal
	// ------------------------------------------------------------------
			
				adicionar_animal=(Button)findViewById(R.id.btn_regisAnimal);
				adicionar_animal.setOnClickListener(new View.OnClickListener() {
					
					@Override
			public void onClick(View v) {
						
						Intent ini= new Intent(Utilidades_Animal.this,Registrar_Ugg.class);
						startActivity(ini);
						
							
						
						}
						

			
		});

		
				
				
				
	}
			
			
			

}