package com.colacteos.casuistica;

import java.util.ArrayList;

import com.Datos.colacteos.SAT_Sistema;
import com.bd.colacteos.SAT_SistemaDao;
import com.bd.colacteos.SAT_casuisticaDao;
import com.bd.colacteos.SQLiteHelper;
import com.mundo.colacteos.R;
import com.mundo.colacteos.sistema.Utilidades_Sistema;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class Registrar_Casuistica extends Activity{

	/*
	 * atributos de la clase
	 */
	private EditText codigo, nombre;
	private Spinner sistema;
	private Button aceptar, cancelar;
	
	
	SAT_casuisticaDao ob= new SAT_casuisticaDao(this);
	
	
	
	/*
	 * constructor de la clase
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registrar_casuistica);
		
		codigo=(EditText)findViewById(R.id.edt_codCasu);
		nombre=(EditText)findViewById(R.id.edt_nomCasu);
		
		
		
		//---------------------------------------------------------------------
		//spinner
		//---------------------------------------------------------------------
				SAT_SistemaDao	dbcon= new SAT_SistemaDao(this);
				dbcon.abrir();
				sistema=(Spinner)findViewById(R.id.spn_sisCasu);//id del spinner
				Cursor cursor=dbcon.getLista();
				SQLiteHelper SqlHelper;
				SqlHelper=new SQLiteHelper(this);
				String[] from = new String[] { SqlHelper.cod_sistema}; 
				//SqlHelper.cod_sistema, 
				int[] to = new int[] { android.R.id.text1 };
						//android.R.id.text2};
				SimpleCursorAdapter adapter= new SimpleCursorAdapter(Registrar_Casuistica.this, android.R.layout.simple_list_item_1, cursor, from, to);	
				adapter.notifyDataSetChanged();
				sistema.setAdapter(adapter);

		
		/*
		 * funcion del spinner
		 */
		/*
		SAT_SistemaDao obj= new SAT_SistemaDao(this);
			
		ArrayList<SAT_Sistema>lista=obj.darSistema();
		
		sistema=(Spinner)findViewById(R.id.spn_sisCasu);//id del spinner
		ArrayAdapter<SAT_Sistema>adaptadorSistema=new ArrayAdapter<SAT_Sistema>(this, android.R.layout.simple_list_item_1, lista);
		sistema.setAdapter(adaptadorSistema);*/
		
		/*SQLiteDatabase bd;
		bd=null;
	
		
		//Creamos el cursor
		Cursor c = bd.rawQuery("select cod_sistema, nom_sistema from SAT_sistema", null);
		sistema=(Spinner)findViewById(R.id.spn_sisCasu);//id del spinner
		//Creamos el adaptador
		SimpleCursorAdapter adapter2 = new SimpleCursorAdapter(this,android.R.layout.simple_spinner_item,c,new String[] {"nombre"},    new int[] {android.R.id.text1}); 
		//Añadimos el layout para el menú
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//Le indicamos al spinner el adaptador a usar
		sistema.setAdapter(adapter2);

		
		/*
		
		sistema=(Spinner)findViewById(R.id.spn_sisCasu);//id del spinner
        Cursor cur = bd.rawQuery ("SELECT  nom_sistema FROM SAT_sistema", null);
        startManagingCursor(cur);

        String[] from = new String[] { "nombre" };
        int[] to = new int[] { android.R.id.text1 };

        SimpleCursorAdapter mAdapter =  new SimpleCursorAdapter (this,android.R.layout.simple_spinner_item, cur, from, to);
        mAdapter.setDropDownViewResource
        (android.R.layout.simple_spinner_dropdown_item);
        sistema.setAdapter(mAdapter);*/

		
		
		
		
		/*
		 * funcion de boton guardar
		 */
		aceptar=(Button)findViewById(R.id.btn_guardarCasu);
		aceptar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Cursor codSistema=(Cursor)sistema.getSelectedItem();
				String codigo_casuistica=codigo.getText().toString();
				String enfermedad= nombre.getText().toString();
				String cod_sistema= codSistema.getString(codSistema.getColumnIndex("cod_sistema"));
				
				ob.agregarCasuistica(codigo_casuistica, enfermedad, cod_sistema);
				
				if(ob==null){
					Toast.makeText(getApplicationContext(), "casuistica No Registrada", 1000).show();

				}
				else{
					
					Toast.makeText(getApplicationContext(), "casuistica  Registrada con Exito", 1000).show();
					codigo.setText("");
					nombre.setText("");
					sistema.getSelectedItem();
					
				}
			
				
				
			}
		});
		
		
		/*
		 * funcion del boton cancelar
		 */
		cancelar=(Button)findViewById(R.id.btn_cancelCasu);
		cancelar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i= new Intent(Registrar_Casuistica.this, Utilidades_Casuistica.class);
				startActivity(i);
				
			}
		});
	}
	
	
	

}
