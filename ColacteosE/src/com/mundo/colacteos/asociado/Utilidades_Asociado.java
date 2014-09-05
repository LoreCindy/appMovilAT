package com.mundo.colacteos.asociado;

import java.nio.ByteOrder;

import com.bd.colacteos.SQLiteHelper;
import com.bd.colacteos.asociadoDao;
import com.mundo.colacteos.R;
import com.mundo.colacteos.R.id;
import com.mundo.colacteos.R.layout;
import com.mundo.colacteos.profesional.Registrar_Profesional;
import com.mundo.colacteos.profesional.Utilidades_Profesional;
import com.mundo.colacteos.sistema.Utilidades_Sistema;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Utilidades_Asociado extends Activity{
	
	// -----------------------------------------------------------
	// atributos de la clase Utilidades Asociado
	// -----------------------------------------------------------
	private Button adicionar_aso;
	private Button buscar_aso;
	
	
	

	// -----------------------------------------------------------------------
	// metodo que permite crear la instancia de la clase utilidades asociado
	// -----------------------------------------------------------------------
	

	
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.utilidades_asociado);
	
	
	
	//-------------------------------------------------------------
	// lista asociados
	//-------------------------------------------------------------
			
			/*asociadoDao	obj= new asociadoDao(this);
			obj.abrir();
			ListView lv=(ListView)findViewById(R.id.lista_asociados);
			Cursor c=obj.leerAsociados();
			SQLiteHelper SqlHelper1=new SQLiteHelper(this);
			String[] f = new String[] { SqlHelper1.nombre_Completo, SqlHelper1.nit_asociado}; 
			int[] t = new int[] { R.id.txtNomAs, R.id.txtNitaso };
			SimpleCursorAdapter adapter= new SimpleCursorAdapter(Utilidades_Asociado.this, R.layout.adaptador_asociado, c, f, t);	
			adapter.notifyDataSetChanged();
			lv.setAdapter(adapter);*/
	
	// ------------------------------------------------------------------
	// action del boton adicionar asociado
	// ------------------------------------------------------------------
	
	adicionar_aso= (Button)findViewById(R.id.btn_op_cultivo);
	adicionar_aso.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent in= new Intent(Utilidades_Asociado.this,Registrar_Asociado.class);
			startActivity(in);
			
		}
	});
	
	

	
	
	
		
	
	}

}