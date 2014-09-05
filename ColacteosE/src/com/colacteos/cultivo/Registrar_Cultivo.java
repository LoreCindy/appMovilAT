package com.colacteos.cultivo;


import com.bd.colacteos.SAT_CultivoDao;
import com.bd.colacteos.SQLiteHelper;
import com.bd.colacteos.fincaDao;
import com.mundo.colacteos.R;
import com.mundo.colacteos.Utilidades;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class Registrar_Cultivo extends Activity {
	


	//----------------------------------------------------
	//atributos
	//----------------------------------------------------

	EditText codigoCultivo, nombreCultivo, promHectarea;
	Spinner codigoFinca;
	private Button agregar, cancelar;




	//--------------------------------------------
	//enlace a la clase CultivoDao
	//-------------------------------------------------
	
	SAT_CultivoDao ob= new SAT_CultivoDao(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registrar_cultivo);
		codigoCultivo=(EditText)findViewById(R.id.edCodCul);
		nombreCultivo=(EditText)findViewById(R.id.edNomCul);
		promHectarea=(EditText)findViewById(R.id.edPromHec);

		
		

		//---------------------------------------------------------------------
		//spinner
		//---------------------------------------------------------------------
		/*fincaDao	dbcon= new fincaDao(this);
		dbcon.abrir();
		codigoFinca=(Spinner)findViewById(R.id.edCodFincas);//id del spinner
		Cursor cursor=dbcon.getLista();
		SQLiteHelper SqlHelper;
		SqlHelper=new SQLiteHelper(this);
		String[] from = new String[] { SqlHelper.codigo_finca}; 
		//SqlHelper.cod_sistema, 
		int[] to = new int[] { android.R.id.text1 };
		//android.R.id.text2};
		SimpleCursorAdapter adapter= new SimpleCursorAdapter(Registrar_Cultivo.this, android.R.layout.simple_list_item_1, cursor, from, to,1);	
		adapter.notifyDataSetChanged();
		codigoFinca.setAdapter(adapter);*/

		
		
		

		agregar=(Button)findViewById(R.id.btn_regUGG);
		agregar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				String codCultivo=codigoCultivo.getText().toString();
				String nombreCul=nombreCultivo.getText().toString();
				String promedioHect=promHectarea.getText().toString();
				String codFinca=codigoFinca.getSelectedItem().toString();
				
				
				ob.agregarCultivo(codCultivo, nombreCul, promedioHect, codFinca);
				
				if(ob==null){
					Toast.makeText(getApplicationContext(), "Cultivo No Registrado", 1000).show();

				}
				else{
					
					Toast.makeText(getApplicationContext(), "Cultivo Registrado con Exito", 1000).show();
					codigoCultivo.setText("");
					nombreCultivo.setText("");
					promHectarea.setText("");
					codigoFinca.getSelectedItem();
					
				}
			
			}
		});

		cancelar=(Button)findViewById(R.id.btn_cancelarC);
		cancelar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i=new Intent(Registrar_Cultivo.this, Utilidades.class);
				startActivity(i);

			}
		});
	}



}
