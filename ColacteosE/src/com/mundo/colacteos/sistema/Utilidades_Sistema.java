package com.mundo.colacteos.sistema;

import com.bd.colacteos.SAT_SistemaDao;
import com.bd.colacteos.SAT_forrajeDao;
import com.bd.colacteos.SQLiteHelper;
import com.mundo.colacteos.R;
import com.mundo.colacteos.forraje.Utilidades_Forraje;
import com.mundo.colacteos.profesional.Modificar_Profesional;

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
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Utilidades_Sistema extends Activity {
	
	
	
	//---------------------------------------
	//atributos
	//----------------------------------------
	
	ListView lv;
	Button nuevoSistemas;
	TextView cod, nombre;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.utilidades_sistema);
		
		
		
		
		//---------------------------------------------------------------------
		//lista de usuarios
		//---------------------------------------------------------------------
		SAT_SistemaDao	dbcon= new SAT_SistemaDao(this);
		dbcon.abrir();
		lv=(ListView)findViewById(R.id.listaSistema);
		Cursor cursor=dbcon.listarSistemas();
		SQLiteHelper SqlHelper;
		SqlHelper=new SQLiteHelper(this);
		String[] from = new String[] { SqlHelper.cod_sistema, SqlHelper.nom_sistema}; 
		int[] to = new int[] { R.id.txtcodsi, R.id.txtNomSis};
		SimpleCursorAdapter adapter= new SimpleCursorAdapter(Utilidades_Sistema.this, R.layout.adaptador_sistema, cursor, from, to);	
		adapter.notifyDataSetChanged();
		lv.setAdapter(adapter);


		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				cod = (TextView) view.findViewById(R.id.txtcodsi);
				nombre = (TextView) view.findViewById(R.id.txtNomSis);
				
				String id_val = cod.getText().toString();
				String nombre_val = nombre.getText().toString();
				

				Intent modify_intent = new Intent(getApplicationContext(),
						Modificar_Sistema.class);
				modify_intent.putExtra("nombre", nombre_val);
				modify_intent.putExtra("codigo", id_val);
				
				startActivity(modify_intent);
			}
		});
		
		
		nuevoSistemas=(Button)findViewById(R.id.btn_registrarSistema);
		nuevoSistemas.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			Intent i= new Intent(Utilidades_Sistema.this, Registrar_Sistema.class);
			startActivity(i);
				
			}
		});
	}
	
	
	

}
