package com.mundo.colacteos.fincas;


import com.bd.colacteos.fincaDao;
import com.mundo.colacteos.R;
import com.mundo.colacteos.profesional.Utilidades_Profesional;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Modificar_Finca extends Activity implements OnClickListener {
	
	
	
	//-------------------------------------------------
	// atributos de la clase
	//---------------------------------------------------
	EditText codigo, ciudad,nombreFinca, ubicacion, hectareas,latitud, longitud, 
	nitPropietario,  manoObra, tipoOrdeno, departamento ; 
	Button editar, eliminar, cultivo;
	long id;
	fincaDao dbcon;
	
	//----------------------ivo-----------------------------------
	//instacia a la clase modificar
	//--------------------------------------------------------
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modificar_finca);
		
		
		//------------------------------------------------------
		// clase dao
		//--------------------------------------------------------
		dbcon = new fincaDao(this);
		dbcon.abrir();
		//--------------------------------------------------------
		// asignacion de los id
		//--------------------------------------------------------
		codigo=(EditText)findViewById(R.id.id_finca);
		nombreFinca = (EditText) findViewById(R.id.edt_nomFinca);
		ciudad = (EditText) findViewById(R.id.edt_ciuFinca);
		ubicacion = (EditText) findViewById(R.id.edt_ubicFinca);
		nitPropietario = (EditText) findViewById(R.id.edt_propi);
		hectareas= (EditText) findViewById(R.id.edt_hectFinca);
		latitud=(EditText)findViewById(R.id.edt_latiFinca);
		longitud = (EditText) findViewById(R.id.edt_longFinca);
		manoObra = (EditText) findViewById(R.id.edt_manoObraFin);
		tipoOrdeno = (EditText) findViewById(R.id.edt_tipoOrdFinca);
		departamento = (EditText) findViewById(R.id.edt_departFinca);
		editar= (Button) findViewById(R.id.btn_actuFinca);
		eliminar = (Button) findViewById(R.id.btn_elimFinca);
		cultivo=(Button)findViewById(R.id.btn_editCulti);
		
		
		Intent i = getIntent();
		String memCod = i.getStringExtra("codigo");
		String memberNom = i.getStringExtra("nombre");
		String memberProp = i.getStringExtra("propietario");
		String memberCiud = i.getStringExtra("ciudad");
		String memberUbica = i.getStringExtra("ubicacion");
		String memHect = i.getStringExtra("hectareas");
		String memberLatit = i.getStringExtra("latitud");
		String memberLong = i.getStringExtra("longitud");
		String memberManoObra = i.getStringExtra("mano obra");
		String memberTipoOrdeno = i.getStringExtra("tipo ordeño");
		String memberDepar= i.getStringExtra("departamento");
		
		
		id = Long.parseLong(memCod);
		codigo.setText(memCod);
		nombreFinca.setText(memberNom);
		nitPropietario.setText(memberProp);
		ciudad.setText(memberCiud);
		ubicacion.setText(memberUbica);
		hectareas.setText(memHect);
		latitud.setText(memberLatit);
		longitud.setText(memberLong);
		manoObra.setText(memberManoObra);
		tipoOrdeno.setText(memberTipoOrdeno);
		departamento.setText(memberDepar);	
		
		

		editar.setOnClickListener(this);
		eliminar.setOnClickListener(this);


		cultivo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				
			}
		});
		
		
	}

	
	//-----------------------------------------------------
	// ocpiones de los botones
	//------------------------------------------------------
	
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_actuFinca:
			
			//String cod = codigo.getText().toString();
			String nombre = nombreFinca.getText().toString();
			String propietario = nitPropietario.getText().toString();
			String ciudade = ciudad.getText().toString();
			String ubicacione= ubicacion.getText().toString();
			String hectarea = hectareas.getText().toString();
			String latitude = latitud.getText().toString();
			String longi = longitud.getText().toString();
			String manoObras = manoObra.getText().toString();
			String tipoOrdenos =tipoOrdeno.getText().toString();
			String departa = departamento.getText().toString();
			
			dbcon.modificarFinca(id, nombre, propietario, ciudade, ubicacione, hectarea, latitude, longi, manoObras, tipoOrdenos, departa);
			Toast.makeText(getApplicationContext(), "Se han actualizado los datos", 1000).show();

			this.returnHome();
			break;

		case R.id.btn_elimFinca:
			// Objetos. 
			AlertDialog.Builder mensaje_dialogo = new AlertDialog.Builder(this);  	

			// Variables.
			final Long m = id;

			mensaje_dialogo.setTitle("Importante");  
			mensaje_dialogo.setMessage("Esta seguro de eliminar Finca?");            
			mensaje_dialogo.setCancelable(false);  
			mensaje_dialogo.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {  
				public void onClick(DialogInterface dialogo1, int id) {  
					try{  


						dbcon.eliminarFinca(m);
						Toast.makeText(getApplicationContext(), "Registro Eliminado", 1000).show();

						returnHome();


					}catch(Exception e){
						Toast.makeText(getApplicationContext(), "Error al eliminar!!!", Toast.LENGTH_LONG).show();
						e.printStackTrace();
					}finally{
						dbcon.cerrar();

					}
				}  
			});  
			mensaje_dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {  
				public void onClick(DialogInterface dialogo1, int id) {  
					returnHome();
				}  
			});            
			mensaje_dialogo.show();  }




	}
		
		
		public void returnHome() {

			Intent home_intent = new Intent(getApplicationContext(),
					Utilidades_Finca.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

			startActivity(home_intent);
		}
	

}


