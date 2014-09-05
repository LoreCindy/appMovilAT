package com.mundo.colacteos;

import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.Datos.colacteos.Usuario;
import com.bd.colacteos.SQLiteHelper;
import com.bd.colacteos.usuarioDao;



/**
 * @author cindy
 *
 */
public class ListaUsuario extends Activity {
	
		
	int posicion = 0;
	List<Usuario> usuarios;		
	ListView lv;
	usuarioDao dbcon;
	boolean blnShort = false;
	//-----------------------
	
	
	TextView  member_id, nombres,apellidos, usuario, pasword;

     //----------------------------------------------------------
	//atributos de la clase
	//-------------------------------------------------------------
	
	private Button nuevo;
	

	//----------------------------------------------------------
	//instancia de la clase
	//----------------------------------------------------------
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_usuario);
		
		
		//---------------------------------------------------------------------
		//lista de usuarios
		//---------------------------------------------------------------------
		dbcon= new usuarioDao(this);
		dbcon.abrir();
		lv=(ListView)findViewById(R.id.lisUsuarios);
		Cursor cursor=dbcon.readData();
		SQLiteHelper SqlHelper;
		SqlHelper=new SQLiteHelper(this);
		String[] from = new String[] { SqlHelper.id_usuario, SqlHelper.nombres, SqlHelper.apellidos, SqlHelper.usuario, SqlHelper.password}; 
				//SqlHelper.apellidos,SqlHelper.usuario, SqlHelper.password};
		int[] to = new int[] { R.id.member_id, R.id.member_name , R.id.apellidos,R.id.usuario, R.id.password};
		//int[] to = new int[] { R.id.txtId_usuario, R.id.txtNomUsuario, R.id.txtApeUsuarios, R.id.txtUsuUsuarios, R.id.txtPassusuarios};
		SimpleCursorAdapter adapter= new SimpleCursorAdapter(ListaUsuario.this, R.layout.view_member_entry, cursor, from, to);	
		adapter.notifyDataSetChanged();
		lv.setAdapter(adapter);
	
		

			
		
		
		
		// OnCLickListiner For List Items
			lv.setOnItemClickListener(new OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						member_id = (TextView) view.findViewById(R.id.member_id);
						nombres = (TextView) view.findViewById(R.id.member_name);
						apellidos = (TextView) view.findViewById(R.id.apellidos);
						usuario = (TextView) view.findViewById(R.id.usuario);
						pasword= (TextView) view.findViewById(R.id.password);

						String id_val = member_id.getText().toString();
						String nombre_val = nombres.getText().toString();
						String apellido_val = apellidos.getText().toString();
						String usuario_val = usuario.getText().toString();
						String pass_val = pasword.getText().toString();
						
						

						Intent modify_intent = new Intent(getApplicationContext(),
								Modicar_Usuario.class);
						modify_intent.putExtra("Nombre", nombre_val);
						modify_intent.putExtra("apellido", apellido_val);
						modify_intent.putExtra("id", id_val);
						modify_intent.putExtra("usuario", usuario_val);
						modify_intent.putExtra("pass", pass_val);
						startActivity(modify_intent);
					}
				});

			

		
		nuevo=(Button)findViewById(R.id.btnNuevoUsuario);
		nuevo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i=new Intent(ListaUsuario.this, Registro_Usuario.class);
				startActivity(i);
				
			}
		});
		
		
		
		}
	
	
		
}
