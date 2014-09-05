package com.colacteos.actividades;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.Datos.colacteos.Actividad;
import com.bd.colacteos.ActividadDao;
import com.bd.colacteos.SAT_casuisticaDao;
import com.bd.colacteos.SQLiteHelper;
import com.colacteos.casuistica.Modificar_Casuistica;
import com.colacteos.casuistica.Registrar_Casuistica;
import com.colacteos.casuistica.Utilidades_Casuistica;
import com.mundo.colacteos.R;

public class Utilidades_Actividades  extends Activity{
	
	/*
	 * atributos de la clase
	 *
	 */
	private Button nuevo;
	private ListView lv;
	
	/*
	 * constructor de la clase Utilidades actividades
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.utilidades_actividades);
		
		

		//----------------------------------------------------
		//lista casuistica
		//----------------------------------------------------

		ActividadDao dbcon= new ActividadDao(this);
		dbcon.abrir();


		//-------------------------------------------
		// lista de actividades
		//-----------------------------------------------

		lv=(ListView)findViewById(R.id.listaActividades);
		Cursor cursor=dbcon.listaActividades();
		SQLiteHelper SqlHelper;
		SqlHelper=new SQLiteHelper(this);
		String[] from = new String[] { SqlHelper.id_actividad, SqlHelper.nom_actividad, SqlHelper.costo_actividad}; 
		int[] to = new int[] { R.id.txt_idActi, R.id.txt_act, R.id.txt_costoA};
		SimpleCursorAdapter adapter= new SimpleCursorAdapter(Utilidades_Actividades.this, R.layout.adaptador_actividad, cursor, from, to,1);	
		adapter.notifyDataSetChanged();
		lv.setAdapter(adapter);
		
		
		
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				TextView cod = (TextView) view.findViewById(R.id.txt_idActi);
				TextView nombre = (TextView) view.findViewById(R.id.txt_act);
				TextView costo=(TextView)view.findViewById(R.id.txt_costoA);
				
				
				String id_val = cod.getText().toString();
				String nombre_val = nombre.getText().toString();
				String costo_val = costo.getText().toString();
				

				Intent modify_intent = new Intent(getApplicationContext(),
						Modificar_Actividad.class);
				modify_intent.putExtra("codigo", id_val);
				modify_intent.putExtra("actividad", nombre_val);				
				modify_intent.putExtra("costo", costo_val); 
				
				startActivity(modify_intent);
			}
		});
		
		
		
		nuevo=(Button)findViewById(R.id.btn_agreNuevaActi);
		nuevo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			Intent i= new Intent(Utilidades_Actividades.this, Registrar_Actividad.class);
			startActivity(i);
			}
		});
	}



	
	

}
