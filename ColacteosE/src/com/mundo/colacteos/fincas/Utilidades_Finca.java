package com.mundo.colacteos.fincas;

import com.bd.colacteos.SQLiteHelper;
import com.bd.colacteos.fincaDao;
import com.mundo.colacteos.Modicar_Usuario;
import com.mundo.colacteos.R;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Utilidades_Finca extends Activity {
	// -----------------------------------------------------------
	// atributos de la clase Utilidades Asociado
	// -----------------------------------------------------------
	private Button adicionar_finca;
	ListView lv;
	


	TextView codigo, ciudad,nombreFinca, ubicacion, hectareas,latitud, longitud, 
	 nitPropietario,  manoObra, tipoOrdeno, departamento ; 


	// -----------------------------------------------------------------------
	// metodo que permite crear la instancia de la clase utilidades asociado
	// -----------------------------------------------------------------------


		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.utilidades_fincas);
			
			
			
			// ------------------------------------------------------------------
			// action del boton adicionar finca
			// ------------------------------------------------------------------


			adicionar_finca=(Button)findViewById(R.id.btn_regisFinca);
			adicionar_finca.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					Intent in= new Intent(Utilidades_Finca.this,Registrar_Finca.class);
					startActivity(in);


				}
			});

			//---------------------------------------------------------------------
			//lista de fincas
			//---------------------------------------------------------------------
			fincaDao	dbcon= new fincaDao(this);
			dbcon.abrir();
			lv=(ListView)findViewById(R.id.listaFincas);
			Cursor cursor=dbcon.listaFincas();
			SQLiteHelper SqlHelper;
			SqlHelper=new SQLiteHelper(this);
			String[] from = new String[] {  SqlHelper.codigo_finca, SqlHelper.nombre_finca, 
					SqlHelper.nit_propietario, SqlHelper.ciudad, SqlHelper.ubicacion,
					SqlHelper.hectareas, SqlHelper.latitud, SqlHelper.longitud, 
					SqlHelper.mano_obra, SqlHelper.codigo_tipo_ordeno, SqlHelper.departamento}; 
			int[] to = new int[] { 
					R.id.txt_codigo_finca,
					R.id.txt_nombreFinca,
					R.id.txt_nitPropietarios,
					R.id.txt_ciudadFinca, 
					R.id.txtubicacionFinca,
					R.id.txt_hectareasFinca, 
					R.id.txt_latitudFinca,
					R.id.txt_longitudFinca, 
					R.id.txt_manoObra, 
					R.id.txt_tipoOrdeno,
					R.id.txt_departaFinca};
			SimpleCursorAdapter adapter= new SimpleCursorAdapter(Utilidades_Finca.this, R.layout.adaptador_fincas, cursor, from, to);	
			adapter.notifyDataSetChanged();
			lv.setAdapter(adapter);


			// OnCLickListiner For List Items
			lv.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					
					codigo = (TextView) view.findViewById(R.id.txt_codigo_finca);
					nombreFinca = (TextView) view.findViewById(R.id.txt_nombreFinca);
					nitPropietario = (TextView) view.findViewById(R.id.txt_nitPropietarios);
					ciudad = (TextView) view.findViewById(R.id.txt_ciudadFinca);
					ubicacion= (TextView) view.findViewById(R.id.txtubicacionFinca);
					hectareas = (TextView) view.findViewById(R.id.txt_hectareasFinca);
					latitud = (TextView) view.findViewById(R.id.txt_latitudFinca);
					longitud = (TextView) view.findViewById(R.id.txt_longitudFinca);
					manoObra= (TextView) view.findViewById(R.id.txt_manoObra);
					tipoOrdeno= (TextView) view.findViewById(R.id.txt_tipoOrdeno);
					departamento= (TextView) view.findViewById(R.id.txt_departaFinca);
					

					String cod_val = codigo.getText().toString();
					String nombre_val = nombreFinca.getText().toString();
					String propietario_val = nitPropietario.getText().toString();
					String ciudad_val = ciudad.getText().toString();
					String ubicacion_val = ubicacion.getText().toString();
					String hectareas_val = hectareas.getText().toString();
					String latitud_val = latitud.getText().toString();
					String longi_val = longitud.getText().toString();
					String manoObra_val = manoObra.getText().toString();
					String tipoOrdeno_val =tipoOrdeno.getText().toString();
					String departa_val = departamento.getText().toString();



					Intent modify_intent = new Intent(getApplicationContext(),
							Modificar_Finca.class);
					modify_intent.putExtra("codigo", cod_val);
					modify_intent.putExtra("nombre", nombre_val);
					modify_intent.putExtra("propietario", propietario_val);					
					modify_intent.putExtra("ciudad", ciudad_val);
					modify_intent.putExtra("ubicacion", ubicacion_val);
					modify_intent.putExtra("hectareas", hectareas_val);
					modify_intent.putExtra("latitud", latitud_val);
					modify_intent.putExtra("longitud", longi_val);					
					modify_intent.putExtra("mano obra", manoObra_val);
					modify_intent.putExtra("tipo ordeño", tipoOrdeno_val);
					modify_intent.putExtra("departamento", departa_val);
					startActivity(modify_intent);
				}
			});

			
			
			
			
			
			
			
		}

		
		
}

