package com.mundo.colacteos.ugg;

import com.mundo.colacteos.R;
import com.mundo.colacteos.Utilidades;
import com.mundo.colacteos.asociado.Registrar_Asociado;
import com.bd.colacteos.SQLiteHelper;
import com.bd.colacteos.UGG_informacionDao;
import com.bd.colacteos.fincaDao;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Registrar_Ugg extends Activity{
	
	
	 private  UGG_informacionDao objUggdao;
	 
	 
	// -----------------------------------------------------------
	// atributos de la clase Utilidades Profesional
	// -----------------------------------------------------------
	  EditText codigo_UGG, nombre_UGG,fecha_nacimiento,  peso_UGG,numero_partos,
		 fecha_venta,  fecha_muerte,motivo_muerte,cantidad_abortos,servicio_toro;
	 private Spinner raza_UGG, genero, codFinca, tipoAnimal;
	 private Button registrarUgg, cancelar;
	 
	 private Bundle bundle;
	 
	 
	// -----------------------------------------------------------------------
	// metodo que permite crear la instancia de la clase
	// -----------------------------------------------------------------------
		 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	setContentView(R.layout.registrar_ugg);
		

		//------------------------------------------------------------------------
		// inicializacion de atributos
		// --------------------------------------------------------------------------

	codigo_UGG=(EditText)findViewById(R.id.edCodigoUGG);
	nombre_UGG=(EditText)findViewById(R.id.edNomUGG);
	fecha_nacimiento=(EditText)findViewById(R.id.edFeNA);
	peso_UGG=(EditText)findViewById(R.id.edPeso);
	numero_partos=(EditText)findViewById(R.id.edNumPartos);
	raza_UGG=(Spinner)findViewById(R.id.spnRaza);
	fecha_venta=(EditText)findViewById(R.id.edFeVen);
	fecha_muerte=(EditText)findViewById(R.id.edFeMu);
	motivo_muerte=(EditText)findViewById(R.id.edMoMu);
	genero=(Spinner)findViewById(R.id.spnGeneroAnimal);
	cantidad_abortos=(EditText)findViewById(R.id.edCanAborto);
	servicio_toro=(EditText)findViewById(R.id.edServicioToro);
	tipoAnimal=(Spinner)findViewById(R.id.spnTipoAn);
	codFinca=(Spinner)findViewById(R.id.spnCodFin);
	objUggdao=new UGG_informacionDao(this);
	objUggdao.abrir();
	registrarUgg=(Button)findViewById(R.id.btn_regisAnimal);
	
	//---------------------------------------------------------------------
	// spinner  de la raza de una animal
	//----------------------------------------------------------------------
	
	ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.SpinnerRazaUgg,android.R.layout.simple_spinner_item);
	adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	raza_UGG.setAdapter(adapter);
	bundle = getIntent().getExtras();
	
	//---------------------------------------------------------------------
	// spinner del genero de un animal
	//----------------------------------------------------------------------


	ArrayAdapter adapte = ArrayAdapter.createFromResource(this, R.array.SpinnerGenero,android.R.layout.simple_spinner_item);
	adapte.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	genero.setAdapter(adapte);
	bundle = getIntent().getExtras();
	
	//---------------------------------------------------------------------
	// spinner tipo  de un animal
	//----------------------------------------------------------------------

	ArrayAdapter adapt = ArrayAdapter.createFromResource(this, R.array.SpinnerTipoAnimal,android.R.layout.simple_spinner_item);
	adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	tipoAnimal.setAdapter(adapt);
	bundle = getIntent().getExtras();
	
	
	//------------------------------------------------------------------------
	//spiner codigo finca
	//------------------------------------------------------------------------
	fincaDao	dbcon= new fincaDao(this);
	dbcon.abrir();
	codFinca=(Spinner)findViewById(R.id.spnCodFin);//id del spinner
	Cursor cursor=dbcon.darCodigoFinca();
	SQLiteHelper SqlHelper;
	SqlHelper=new SQLiteHelper(this);
	String[] from = new String[] { SqlHelper.codigo_finca}; 
	//SqlHelper.cod_sistema, 
	int[] to = new int[] { android.R.id.text1 };
	//android.R.id.text2};
	SimpleCursorAdapter a= new SimpleCursorAdapter(Registrar_Ugg.this, android.R.layout.simple_list_item_1, cursor, from, to);	
	a.notifyDataSetChanged();
	codFinca.setAdapter(a);


	//---------------------------------------------------------------------
	// Opcion guradar del boton
	//----------------------------------------------------------------------

	
	registrarUgg=(Button)findViewById(R.id.btn_regUGG);
	registrarUgg.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			Cursor fincas=(Cursor)codFinca.getSelectedItem();
			
			String codigo=codigo_UGG.getText().toString();
		    String nombre=nombre_UGG.getText().toString();
		    String fechaNa=fecha_nacimiento.getText().toString();
		    String peso=peso_UGG.getText().toString();
		    String raza=raza_UGG.getSelectedItem().toString();
		    String fechaVen=fecha_venta.getText().toString();
		    String fechaMuert=fecha_nacimiento.getText().toString();
		    String generos=genero.getSelectedItem().toString();
		    String motiMuerte=motivo_muerte.getText().toString();
		    
		    
		    //String finca=codFinca.getSelectedItem().toString();
		    String finca=fincas.getString(fincas.getColumnIndex("codigo_finca"));
		    String abortos=cantidad_abortos.getText().toString();
		    String servicios=servicio_toro.getText().toString();
		    String tipoAnimales=tipoAnimal.getSelectedItem().toString();
		    String partos=numero_partos.getText().toString();
		    
		    objUggdao.registrarAnimal(codigo, nombre, fechaNa, peso, raza, fechaVen, fechaMuert, motiMuerte, generos, finca, abortos, servicios, tipoAnimales, partos);
		    
		    if(objUggdao==null){
				Toast.makeText(getApplicationContext(), "Animal  No Registrado", 1000).show();
			}
			else{
				
				Toast.makeText(getApplicationContext(), "Animal Registrado con Exito", 1000).show();
				codigo_UGG.setText("");
				nombre_UGG.setText("");
				fecha_nacimiento.setText("");
				peso_UGG.setText("");
				raza_UGG.getSelectedItem();
				fecha_venta.setText("");
				fecha_muerte.setText("");
				motivo_muerte.setText("");
				genero.getSelectedItem();
				codFinca.getSelectedItem();
				cantidad_abortos.setText("");
				servicio_toro.setText("");
				tipoAnimal.getSelectedItem();
				numero_partos.setText("");
			}
			
			
		}
	});
	cancelar=(Button)findViewById(R.id.btnCancelarUgg);
	cancelar.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent i=new Intent(Registrar_Ugg.this, Utilidades.class);
			startActivity(i);
			
		}
	});
	
	}
	
}
