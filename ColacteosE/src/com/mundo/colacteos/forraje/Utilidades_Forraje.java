package com.mundo.colacteos.forraje;

import com.bd.colacteos.SAT_forrajeDao;
import com.bd.colacteos.SQLiteHelper;
import com.bd.colacteos.usuarioDao;
import com.colacteos.casuistica.Modificar_Casuistica;
import com.mundo.colacteos.ListaUsuario;
import com.mundo.colacteos.R;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Utilidades_Forraje extends Activity {

	
	/*
	 * atributos de la clase
	 */
	private Button agregarForraje;
	private ListView listaForraje;
	
	
	
	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.utilidades_forraje);
		
		
		//---------------------------------------------------------------------
		//lista de usuarios
		//---------------------------------------------------------------------
			SAT_forrajeDao	dbcon= new SAT_forrajeDao(this);
				dbcon.abrir();
			ListView lv=(ListView)findViewById(R.id.listaForraje);
				Cursor cursor=dbcon.leerForraje();
				SQLiteHelper SqlHelper;
				SqlHelper=new SQLiteHelper(this);
				String[] from = new String[] { SqlHelper.codigo_forraje, SqlHelper.nombre_forraje}; 
						//SqlHelper.apellidos,SqlHelper.usuario, SqlHelper.password};
				int[] to = new int[] { R.id.txt_codForraje, R.id.txtNomForraje};
				//int[] to = new int[] { R.id.txtId_usuario, R.id.txtNomUsuario, R.id.txtApeUsuarios, R.id.txtUsuUsuarios, R.id.txtPassusuarios};
				SimpleCursorAdapter adapter= new SimpleCursorAdapter(Utilidades_Forraje.this, R.layout.adaptador_forraje, cursor, from, to);	
				adapter.notifyDataSetChanged();
				lv.setAdapter(adapter);
				
				
				lv.setOnItemClickListener(new OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						TextView cod = (TextView) view.findViewById(R.id.txt_codForraje);
						TextView nombre = (TextView) view.findViewById(R.id.txtNomForraje);
						
						
						String id_val = cod.getText().toString();
						String nombre_val = nombre.getText().toString();
						
						

						Intent modify_intent = new Intent(getApplicationContext(),
								Modificar_Forraje.class);
						modify_intent.putExtra("codigo", id_val);
						modify_intent.putExtra("forraje", nombre_val);				
						
						startActivity(modify_intent);
					}
				});
				
			
		
		
		agregarForraje=(Button)findViewById(R.id.btn_RegisNuevoForraje);
		agregarForraje.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i= new Intent(Utilidades_Forraje.this, Registrar_Forraje.class);
				startActivity(i);
			}
		});
	}

	
	
}
