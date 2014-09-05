package com.mundo.colacteos.fincas;

import com.bd.colacteos.fincaDao;
import com.colacteos.cultivo.Utilidades_Cultivo;
import com.mundo.colacteos.R;
import com.mundo.colacteos.Utilidades;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Registrar_Finca  extends Activity  {


	//--------------------------------------------
	//enlace a la clase asociadoDao
	//-------------------------------------------------
	
	private  fincaDao fincaDao;
	
	
	// -----------------------------------------------------------
	// atributos de la clase  Registrar asociado
	// -----------------------------------------------------------
	EditText codigoFinca, ciudad,nombreFinca, ubicacion, hectareas,latitud, longitud;
	Spinner nitPropietario,  manoObra, tipoOrdeno, departamento ; 
	private Button registrar, cancelar, cultivos;
	Bundle bundle;
	int seleccion;
	// -----------------------------------------------------------------------
	// metodo que permite instanciar  la clase 
	// -----------------------------------------------------------------------

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registrar_finca);
		
		
		//------------------------------------------------------------------------
		// inicializacion de atributos
		// --------------------------------------------------------------------------
		codigoFinca=(EditText)findViewById(R.id.edTCodFinca);
		nombreFinca=(EditText)findViewById(R.id.edTNomFinca);
		ubicacion=(EditText)findViewById(R.id.edHubica);
		hectareas=(EditText)findViewById(R.id.edtHecta);
		latitud=(EditText)findViewById(R.id.edtLati);
		longitud=(EditText)findViewById(R.id.edLongi);
		
		nitPropietario=(Spinner)findViewById(R.id.spnNitPrio);
		ciudad=(EditText)findViewById(R.id.edCiudad);
		manoObra=(Spinner)findViewById(R.id.spnManObra);
		tipoOrdeno=(Spinner)findViewById(R.id.spnTipoOrden);
		departamento=(Spinner)findViewById(R.id.spnDeparta);
		
		fincaDao= new fincaDao(this);
		fincaDao.abrir();
		
		fincaDao.agregarfinca("1", "las palmas", "108591876","pasto","chachagui", "12", "10", "30", "contratada", "1", "Nariño");
		
		

		//--------------------------------------------------------------------------------
		// spinner de departamentos
		//------------------------------------------------------------------------------
		
		
		ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.spinnerDepartamentos,android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		departamento.setAdapter(adapter);
		bundle = getIntent().getExtras();
		

		//--------------------------------------------------------------------------------
		// spinner de tipo ordeño
		//------------------------------------------------------------------------------
		
		
		ArrayAdapter ad = ArrayAdapter.createFromResource(this, R.array.TipoOrdeno,android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		tipoOrdeno.setAdapter(ad);
		bundle = getIntent().getExtras();
		
		//--------------------------------------------------------------------------------
		// spinner de mano de obra
		//------------------------------------------------------------------------------
		ArrayAdapter adap = ArrayAdapter.createFromResource(this, R.array.spinnerManoObra,android.R.layout.simple_spinner_item);
		adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		manoObra.setAdapter(adap);
		bundle = getIntent().getExtras();
		
		//------------------------------------------------------------------------
		// opcion del boton que me lleva a los cultivos
		//-------------------------------------------------------------------------
		
		cultivos=(Button)findViewById(R.id.btn_lcultivos);
		cultivos.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i= new Intent(Registrar_Finca.this,Utilidades_Cultivo.class );
				startActivity(i);
				
			}
		});
		
		//------------------------------------------------------------------------
		// opcion del boton registrar
		//-------------------------------------------------------------------------

		
		registrar=(Button)findViewById(R.id.btn_guardFinca);
		registrar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Cursor propietario=(Cursor)nitPropietario.getSelectedItem();
				
				//String fnca= codigoFinca.getText().toString();
				String nombreF=nombreFinca.getText().toString();
				//String nitProp=nitPropietario.getSelectedItem().toString();
				String nittProp=propietario.getString(propietario.getColumnIndex("nit_propietario"));
				//....
				String ciudades=ciudad.getText().toString();
				String ubicaciones=ubicacion.getText().toString();					
				String hectarea=hectareas.getText().toString();
				String latitudes=latitud.getText().toString();
				String longitudd=longitud.getText().toString();
				//-------------------------------------------------
				String manoDeObra=manoObra.getSelectedItem().toString();
				//--------------------------------------------------
				String tipoDeOrdeno=tipoOrdeno.getSelectedItem().toString();
				String departamentos=departamento.getSelectedItem().toString();
				
				
				fincaDao.insertarFinca(nombreF, nittProp, ciudades, ubicaciones, hectarea, latitudes, longitudd, manoDeObra, tipoDeOrdeno, departamentos);
				
				if(fincaDao==null){
					Toast.makeText(getApplicationContext(), "La finca No se ha Registrado", 1000).show();

				}else
				{
					Toast.makeText(getApplicationContext(), "Registro Insertado", 1000).show();
					codigoFinca.setText("");
					nombreFinca.setText("");
					nitPropietario.getSelectedItem();
					ciudad.setText("");
					ubicacion.setText("");
					hectareas.setText("");
					latitud.setText("");
					longitud.setText("");
					manoObra.getSelectedItem();
					tipoOrdeno.getSelectedItem();
					departamento.getSelectedItem();

				}
				
			}
		});
		
		cancelar=(Button)findViewById(R.id.btnCanFinca);
		cancelar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i= new Intent(Registrar_Finca.this, Utilidades.class);
				startActivity(i);
				
			}
		});
		
		
	}

	
	
	
}
