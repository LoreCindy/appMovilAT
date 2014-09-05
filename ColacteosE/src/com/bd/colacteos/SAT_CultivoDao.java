package com.bd.colacteos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SAT_CultivoDao {
	
	
	private  SQLiteDatabase bd;
	private  SQLiteHelper dbHelper;
	
	
	//-------------------------------------------------
	//constructor de la clase
	//-------------------------------------------------

	public SAT_CultivoDao(Context context){
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
	//metodo que permite agregar un cultivo
	//-------------------------------------------------

	public void agregarCultivo( String cod_cultivo, String  nom_cultivo, String  promedio_hectarea,  String codigo_fincas )
	{
			
	dbHelper.getWritableDatabase();
		ContentValues valores =new  ContentValues();
		valores.put("cod_cultivo", cod_cultivo);
		valores.put("nom_cultivo",nom_cultivo);
		valores.put("promedio_hectarea", promedio_hectarea);
		valores.put("codigo_fincas", codigo_fincas);
		
		
		
		bd.insert(SQLiteHelper.SAT_cultivo, null, valores);
		bd.close();
	}
	
	
	//--------------------------------------------------
	//metodo que permite eliminar un cultivo
	//-------------------------------------------------

	/**
	 * Metodo para eliminar un  registro de cultivo
	 * @param Long id id  del cultivo
	 * */


	public void eliminarActividad(long cod_cultivo) {
		bd.delete(SQLiteHelper.SAT_cultivo, dbHelper.cod_cultivo + "="
				+ cod_cultivo, null);
	}

		
		/**
		 * Metodo para actualizar un  registro de cultivo
		 * @param Long id id cultivo
		 *  @param String nombre cultivo
		 *  @param String promedio hectarea
		 *  @param String codigo finca
		 *   
		 * */
		
			
		public int actualizarActividad(long cod_cultivo,  String  nom_cultivo, String  promedio_hectarea,  String codigo_fincas) {
			ContentValues cvUpdate = new ContentValues();
			cvUpdate.put(dbHelper.cod_cultivo, cod_cultivo);
			cvUpdate.put(dbHelper.nom_cultivo,nom_cultivo);
			cvUpdate.put(dbHelper.promedio_hectarea, promedio_hectarea);
			cvUpdate.put(dbHelper.codigo_fincas, codigo_fincas);
			
			int i = bd.update(SQLiteHelper.SAT_cultivo, cvUpdate,
					dbHelper.cod_cultivo + " = " + cod_cultivo, null);
			return i;
		}

		//--------------------------------------------------
		//metodo que permite devolver una lista de cultivos
		//-------------------------------------------------

		 public Cursor listaCultivos() {
				String[] allColumns = new String[] { "rowid AS _id",dbHelper.cod_cultivo, dbHelper.nom_cultivo, dbHelper.promedio_hectarea, dbHelper.codigo_fincas};
				Cursor c = bd.query(SQLiteHelper.SAT_cultivo, allColumns, null,
						null, null, null, null);
				if (c != null) {
					c.moveToFirst();
				}
				return c;
			}
				
	

}
