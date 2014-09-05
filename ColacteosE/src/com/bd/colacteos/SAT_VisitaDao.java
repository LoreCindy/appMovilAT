package com.bd.colacteos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SAT_VisitaDao {
	
	private  SQLiteDatabase bd;
	private  SQLiteHelper dbHelper;
	
	
	//-------------------------------------------------
	//constructor de la clase
	//-------------------------------------------------

	public  SAT_VisitaDao(Context context){
		dbHelper= new SQLiteHelper(context);
	}

	//---------------------------------------------------
	//abre la conexion  a la base de datos
	//----------------------------------------------------

	public void abrir()
	{
		bd= dbHelper.getWritableDatabase();
	}

	//--------------------------------------------------
	//cerrar la conexion de la base de datos
	//-------------------------------------------------

	public void cerrar(){
		dbHelper.close();
	}

	//--------------------------------------------------
	//metodo que permite agregar una nueva visita
	//-------------------------------------------------

	public void agregarVisita( String cod_fincas,  String fecha_visita, 
			String hora_ingreso,  String clase_visita, String cumple,String num_recetario,
			String nit_profesional,String tipo_visita,String observaciones,String identificacion_asociado)
	{

		dbHelper.getWritableDatabase();
		ContentValues valores =new  ContentValues();
		valores.put("cod_fincas", cod_fincas);
		valores.put("fecha_visita",fecha_visita);
		valores.put("hora_ingreso ", hora_ingreso);
		valores.put("clase_visita", clase_visita);
		valores.put("cumple",cumple);
		valores.put("num_recetario ", num_recetario);
		valores.put("nit_profesional", nit_profesional);
		valores.put("tipo_visita",tipo_visita);
		valores.put("observaciones ",observaciones);
		valores.put(" identificacion_asociado",  identificacion_asociado);


		bd.insert(SQLiteHelper.SAT_visita, null, valores);
		bd.close();
	}
	
	//--------------------------------------------------
	//metodo que permite eliminar una visita
	//-------------------------------------------------

	public void eliminarVisita(long id_visita) {
		bd.delete(SQLiteHelper.SAT_visita, dbHelper.id_visita + "="
				+ id_visita, null);
	}

	
	//--------------------------------------------------
	//metodo que permite actualizar la visita
	//-------------------------------------------------

	public int actualizarVisita(long id_visita,String cod_fincas,  String fecha_visita, 
			String hora_ingreso,  String clase_visita, String cumple,String num_recetario,
			String nit_profesional,String tipo_visita,String observaciones,String identificacion_asociado) {
		
		ContentValues valores =new  ContentValues();
		valores.put(dbHelper.id_visita, id_visita);
		valores.put(dbHelper.cod_fincas, cod_fincas);
		valores.put(dbHelper.fecha_visita,fecha_visita);
		valores.put(dbHelper.hora_ingreso, hora_ingreso);
		valores.put(dbHelper.clase_visita, clase_visita);
		valores.put(dbHelper.cumple,cumple);
		valores.put(dbHelper.num_recetario, num_recetario);
		valores.put(dbHelper.nit_profesional, nit_profesional);
		valores.put(dbHelper.tipo_visita,tipo_visita);
		valores.put(dbHelper.observaciones,observaciones);
		valores.put(dbHelper.identificacion_asociado,  identificacion_asociado);
		
		int i = bd.update(SQLiteHelper.SAT_visita, valores,
				dbHelper.id_visita + " = " +id_visita, null);
		return i;
	}
	
	//--------------------------------------------------
	//metodo que permite devolver una lista de visitas
	//-------------------------------------------------

	public Cursor listarVisitas() {
		String[] allColumns = new String[] { "rowid AS _id",dbHelper.id_visita,dbHelper.cod_fincas,
				dbHelper.fecha_visita,dbHelper.hora_ingreso,dbHelper.clase_visita, 
				dbHelper.cumple,dbHelper.num_recetario,dbHelper.nit_profesional,dbHelper.tipo_visita,
				dbHelper.observaciones, dbHelper.identificacion_asociado};
		Cursor c = bd.query(SQLiteHelper.SAT_actividad, allColumns, null,
				null, null, null, null);
		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}
				


}
