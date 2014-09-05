package com.mundo.colacteos;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Paint.FontMetrics;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Lista  extends Activity{

	
	private Spinner listaE;
	private Button guardar;
	
	
	  ArrayAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista);
		
		listaE=(Spinner)findViewById(R.id.sp_ejemplo);
		guardar=(Button)findViewById(R.id.btn_cargar_lista);
		
		adapter = new ArrayAdapter (this, android.R.layout.simple_spinner_item, darElementos());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.add("uno");
        adapter.add("Dos");
       adapter.add("Tres");
        listaE.setAdapter(adapter);

	}
		
	public String[]darElementos(){
	String[] lista= new String [5];
	for(int i=0; i<5; i++){
		lista[i]="valor "+ i;
		
	}
	return lista;
}
	
	
}
