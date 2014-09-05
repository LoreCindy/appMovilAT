package com.mundo.colacteos.profesional;
import com.bd.colacteos.SQLiteHelper;
import com.bd.colacteos.Sat_profesionalDao;
import com.bd.colacteos.usuarioDao;
import com.mundo.colacteos.ListaUsuario;
import com.mundo.colacteos.Modicar_Usuario;
import com.mundo.colacteos.R;
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

public class Utilidades_Profesional extends Activity {

	// -----------------------------------------------------------
	// atributos de la clase Utilidades Profesional
	// -----------------------------------------------------------
	private Button adicionar_prof;
	ListView lv;
	Sat_profesionalDao dbcon;
	TextView Nit, Nombres, Apellidos, Titulo, Institucion;
	SQLiteHelper dbHelper;
	

	// -----------------------------------------------------------------------
	// metodo que permite crear la instancia de la clase utilidades profesional
	// -----------------------------------------------------------------------

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.utilidades_profesional);
		
		
		
		//----------------------------------------------------
		//lista de porfesionales
		//----------------------------------------------------
				
		dbcon= new Sat_profesionalDao(this);
		dbcon.abrir();

		lv=(ListView)findViewById(R.id.listProfesional);
		Cursor cursor=dbcon.readProfesionales();
		SQLiteHelper SqlHelper;
		SqlHelper=new SQLiteHelper(this);
		String[] from = new String[] { SqlHelper.Nit, SqlHelper.Nombres, SqlHelper.Apellidos,  SqlHelper.Titulo,  SqlHelper.Institucion}; 
				//SqlHelper.apellidos,SqlHelper.usuario, SqlHelper.password};
		int[] to = new int[] { R.id.txtnitPro, R.id.txtNomPro, R.id.txtapeProd, R.id.txttitPro, R.id.txtInsPro};
		SimpleCursorAdapter adapter= new SimpleCursorAdapter(Utilidades_Profesional.this, R.layout.adaptador_profesional, cursor, from, to);	
		adapter.notifyDataSetChanged();
		lv.setAdapter(adapter);
		
		
	
				
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Nit = (TextView) view.findViewById(R.id.txtnitPro);
				Nombres = (TextView) view.findViewById(R.id.txtNomPro);
				Apellidos = (TextView) view.findViewById(R.id.txtapeProd);
				Titulo = (TextView) view.findViewById(R.id.txttitPro);
				Institucion= (TextView) view.findViewById(R.id.txtInsPro);

				String id_val = Nit.getText().toString();
				String nombre_val = Nombres.getText().toString();
				String apellido_val = Apellidos.getText().toString();
				String titulo_val = Titulo.getText().toString();
				String institucion_val = Institucion.getText().toString();
				
				

				Intent modify_intent = new Intent(getApplicationContext(),
						Modificar_Profesional.class);
				modify_intent.putExtra("nombres", nombre_val);
				modify_intent.putExtra("apellidos", apellido_val);
				modify_intent.putExtra("nit", id_val);
				modify_intent.putExtra("titulo", titulo_val);
				modify_intent.putExtra("institucion", institucion_val);
				startActivity(modify_intent);
			}
		});
	
				
				
			
		
		

		// ------------------------------------------------------------------
		// action del boton adicionar porfesional
		// ------------------------------------------------------------------
		adicionar_prof = (Button) findViewById(R.id.btn_adicionPro);
		adicionar_prof.setOnClickListener(new View.OnClickListener() {
			

			@Override
			public void onClick(View v) {
				Intent in= new Intent(Utilidades_Profesional.this,Registrar_Profesional.class);
				startActivity(in);
				

			}
		});

		

		

		
	}

}
