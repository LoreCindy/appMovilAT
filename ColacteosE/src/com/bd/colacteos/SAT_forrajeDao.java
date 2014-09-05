/**
 * 
 */
package com.bd.colacteos;

import java.util.ArrayList;

import com.Datos.colacteos.SAT_Forraje;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * @author cindy
 *
 */
public class SAT_forrajeDao {


	private  SQLiteDatabase bd;
	private  SQLiteHelper dbHelper;

	//-------------------------------------------------
	//constructor de la clase
	//-------------------------------------------------


	public SAT_forrajeDao(Context contexto){
		dbHelper= new SQLiteHelper(contexto);
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
	
	
	/**
	 * Metodo para agregar un nuevo forraje
	 * @param String codigo forraje
	 * @param String nombre forraje
	 * @return BOOLEAN TRUE si tuvo exito FALSE caso contrario
	 * */
		
public long agregarForraje( String codigo_forraje, String nombre_forraje  )throws Exception
	{
	ArrayList<SAT_Forraje>lista= new ArrayList<SAT_Forraje>();
	
	if(lista.equals(codigo_forraje)&& lista.equals(nombre_forraje))
	{
		new  Exception("este registro ya existe");
	}
	else
		
	dbHelper.getWritableDatabase();
	long estado=0;
	try{
		ContentValues valores =new  ContentValues();
		valores.put("codigo_forraje",codigo_forraje);
		valores.put("nombre_forraje",nombre_forraje);
					
		
		
		estado= bd.insert(SQLiteHelper. SAT_forraje, null, valores);
	}
	catch(Exception e){
		
		estado=0;
	}
	return estado;
}

/**
 * Metodo para eliminar un  forraje
 * @param String codigo Codigo forraje
 * */

//--------------------------------------------------------------------------------
// metodo de Eliminar casuistica
//--------------------------------------------------------------------------------

public void eliminarForraje(long codigo_forraje) {
	bd.delete(SQLiteHelper.SAT_forraje, dbHelper.codigo_forraje + "="
			+ codigo_forraje, null);
}




/**
 * Metodo para actualizar un  registro de forraje
 * @param String nombre forraje
 * @param String codigo forraje
 * */


//--------------------------------------------------------------------------------
// metodo de actualizar casuistica
//--------------------------------------------------------------------------------
public int actualizarForraje(long codigo_forraje, String nombre_forraje) {
	ContentValues c = new ContentValues();
	c.put(dbHelper.codigo_forraje, codigo_forraje);
	c.put(dbHelper.nombre_forraje, nombre_forraje);
	int i = bd.update(SQLiteHelper.SAT_forraje, c,
			dbHelper.codigo_forraje + " = " + codigo_forraje, null);
	return i;
}






//-------------------------------------------------------
// listar registro de forraje
//-------------------------------------------------------
public Cursor leerForraje() {
	String[] allColumns = new String[] { "rowid AS _id",dbHelper.codigo_forraje, dbHelper.nombre_forraje};
	Cursor c = bd.query(SQLiteHelper.SAT_forraje, allColumns, null,
			null, null, null, null);
	if (c != null) {
		c.moveToFirst();
	}
	return c;
}

		
}


