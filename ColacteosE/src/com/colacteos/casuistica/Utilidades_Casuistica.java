package com.colacteos.casuistica;

import com.bd.colacteos.SAT_casuisticaDao;
import com.bd.colacteos.SQLiteHelper;
import com.bd.colacteos.Sat_profesionalDao;
import com.mundo.colacteos.R;
import com.mundo.colacteos.profesional.Utilidades_Profesional;
import com.mundo.colacteos.sistema.Modificar_Sistema;

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

public class Utilidades_Casuistica  extends Activity{
	
	
	/*
	 * atributos de la clase
	 *
	 */
private Button nuevo;
private ListView lv;
	
	

	/*
	 * constructor de la clase Utilidades casuistica
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.utilidades_casuistica);
		
		
		//----------------------------------------------------
		//lista casuistica
		//----------------------------------------------------

		SAT_casuisticaDao dbcon= new SAT_casuisticaDao(this);
		dbcon.abrir();

		lv=(ListView)findViewById(R.id.listaCasuistica);
		Cursor cursor=dbcon.listarCasuistica();
		SQLiteHelper SqlHelper;
		SqlHelper=new SQLiteHelper(this);
		String[] from = new String[] { SqlHelper.cod_casuistica, SqlHelper.enfermedad, SqlHelper.cod_sistema}; 
		int[] to = new int[] { R.id.codigocas, R.id.enferCas, R.id.sistema};
		SimpleCursorAdapter adapter= new SimpleCursorAdapter(Utilidades_Casuistica.this, R.layout.adaptador_casuistica, cursor, from, to,1);	
		adapter.notifyDataSetChanged();
		lv.setAdapter(adapter);
		
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				TextView cod = (TextView) view.findViewById(R.id.codigocas);
				TextView nombre = (TextView) view.findViewById(R.id.enferCas);
				TextView sistema=(TextView)view.findViewById(R.id.sistema);
				
				
				String id_val = cod.getText().toString();
				String nombre_val = nombre.getText().toString();
				String siste_val = sistema.getText().toString();
				

				Intent modify_intent = new Intent(getApplicationContext(),
						Modificar_Casuistica.class);
				modify_intent.putExtra("codigo", id_val);
				modify_intent.putExtra("enfermedad", nombre_val);				
				modify_intent.putExtra("sistema", siste_val); // modificar valor
				
				startActivity(modify_intent);
			}
		});
		
		
		
		
		

		/*
		 * opcion del boton nuevo
		 */
		
		nuevo=(Button)findViewById(R.id.btn_regisCasuistica);
		nuevo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			Intent i= new Intent(Utilidades_Casuistica.this, Registrar_Casuistica.class);
			startActivity(i);
			}
		});
		
	}
	
	
	
	
}
