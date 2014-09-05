package com.bd.colacteos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ActividadDao {
	
	private  SQLiteDatabase bd;
	private  SQLiteHelper dbHelper;
	
	
	//-------------------------------------------------
	//constructor de la clase
	//-------------------------------------------------

	public  ActividadDao(Context context){
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
	//metodo que permite agregar una nueva actividad
	//-------------------------------------------------

	public void agregarActividad( String id_actividad, String  nom_actividad, String  costo_actividad  )
	{
			
	dbHelper.getWritableDatabase();
		ContentValues valores =new  ContentValues();
		valores.put("id_actividad", id_actividad);
		valores.put("nom_actividad",nom_actividad);
		valores.put("costo_actividad ", costo_actividad );
		
		
		bd.insert(SQLiteHelper.SAT_actividad, null, valores);
		bd.close();
	}
	
	

	//--------------------------------------------------
	//metodo que permite eliminar una actividad
	//-------------------------------------------------

	/**
	 * Metodo para eliminar un  registro de actividad
	 * @param Long id id  de la actividad
	 * */

	
	public void eliminarActividad(long id_actividad) {
		bd.delete(SQLiteHelper.SAT_actividad, dbHelper.id_actividad + "="
				+ id_actividad, null);
	}

	
	/**
	 * Metodo para actualizar un  registro de actividad
	 * @param Long id id actividad
	 *  @param String nombre actividad
	 *  @param String costo de actividad
	 *   
	 * */
	
		
	public int actualizarActividad(long id_actividad , String  nom_actividad, String  costo_actividad) {
		ContentValues cvUpdate = new ContentValues();
		cvUpdate.put(dbHelper.id_actividad, id_actividad);
		cvUpdate.put(dbHelper.nom_actividad,nom_actividad);
		cvUpdate.put(dbHelper.costo_actividad, costo_actividad);
		
		int i = bd.update(SQLiteHelper.SAT_actividad, cvUpdate,
				dbHelper.id_actividad + " = " +id_actividad, null);
		return i;
	}

	//--------------------------------------------------
	//metodo que permite devolver una lista de actividades
	//-------------------------------------------------

	 public Cursor listaActividades() {
			String[] allColumns = new String[] { "rowid AS _id",dbHelper.id_actividad, dbHelper.nom_actividad, dbHelper.costo_actividad};
			Cursor c = bd.query(SQLiteHelper.SAT_actividad, allColumns, null,
					null, null, null, null);
			if (c != null) {
				c.moveToFirst();
			}
			return c;
		}
			



}
