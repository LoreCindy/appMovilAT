package com.colacteos.cultivo;

import com.mundo.colacteos.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Utilidades_Cultivo  extends Activity{

	//-------------------------------------------------
	//atributos de la clase
	//------------------------------------------------
	private Button registrarCultivo;
	

	//-------------------------------------------------
	//instancia de la clase utilidades cultivo
	//------------------------------------------------
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.utilidades_cultivo);
	
	registrarCultivo=(Button)findViewById(R.id.btn_RegistrarC);
	registrarCultivo.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent i=new Intent(Utilidades_Cultivo.this, Registrar_Cultivo.class);
			startActivity(i);
			
		}
	});
	}

	
	
	
}
