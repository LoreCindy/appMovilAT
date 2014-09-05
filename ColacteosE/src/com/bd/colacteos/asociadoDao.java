package com.bd.colacteos;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class asociadoDao {

	
	private  SQLiteDatabase bd;
	private  SQLiteHelper dbHelper;
	Context con;
	
	
	
	//-------------------------------------------------
	//constructor de la clase
	//-------------------------------------------------
	

	public asociadoDao(Context contexto){
		dbHelper= new SQLiteHelper(contexto);
	}
	

	//---------------------------------------------------
	//abre la conexion  a la base de datos
	//----------------------------------------------------
		
		public void abrir()
		  {
			bd= dbHelper.getWritableDatabase();
		  }
		/*public asociadoDao abrir() throws SQLException {
			 SQLiteHelper dbhelper = new SQLiteHelper(con);
			bd = dbhelper.getWritableDatabase();
			return this;

		}*/
		
		//--------------------------------------------------
		  //cerrar la conexion de la base de datos
		  //-------------------------------------------------
		
		public void cerrar(){
			dbHelper.close();
		  }
		
		//-----------------------------------------
		//metodo para agregar un asociado
		//---------------------------------------------------------
		
		public void crearAsociado(String nit_asociado,String cod_finca, String nombre_Completo, String Direccion , String telefono, String Tipo_identificacion)
		{	

			dbHelper.getWritableDatabase();

			ContentValues valores =new  ContentValues();
			valores.put("nit_asociado", nit_asociado);
			valores.put("cod_finca",cod_finca);
			valores.put("nombre_Completo",nombre_Completo);
			valores.put("Direccion", Direccion);
			valores.put("telefono", telefono);
			valores.put("Tipo_identificacion", Tipo_identificacion);
			


			bd.insert(SQLiteHelper.SAT_terceros_asociados, null, valores);

			//bd.close();
	}
		//--------------------------------------------------------------------------
		// metodo que permite  leer datos de asociado
		//--------------------------------------------------------------------------
		
		public Cursor leerAsociados() {
			String[] allColumns = new String[] {"rowid AS _id", dbHelper.nit_asociado, dbHelper.nombre_Completo, dbHelper.Direccion, dbHelper.telefono, dbHelper.Tipo_identificacion };
			Cursor c = bd.query(SQLiteHelper.SAT_terceros_asociados, allColumns, null, null, null,null, null);
			if (c != null) {
				c.moveToFirst();
			}
			return c;
		}
		
		//------------------------------------------------------------------------
		//metodo para eliminar un asociado
		//------------------------------------------------------------------------
		public void eliminarAsociado(long nit_asociado){
			 bd.delete(SQLiteHelper.SAT_terceros_asociados,dbHelper.nit_asociado+ "="+ nit_asociado, null);
		 }
		
		 
		//----------------------------------------------------
		 //metodo  que sirve para buscar un asociado
		 //---------------------------------------------------
		 
		 
		 public Cursor buscarUsuario(String nit){
			 String[] columnas= new  String[]{dbHelper.nit_asociado,dbHelper.cod_finca, dbHelper.nombre_Completo, dbHelper.Direccion, dbHelper.Tipo_identificacion};
			 return bd.query(SQLiteHelper.SAT_terceros_asociados, columnas, dbHelper.nit_asociado+"?",new String[]{nit},  null,  null,  null,  null);
		 }
		 
		//----------------------------------------------------
		 //metodo  que sirve para actualizar un asociado
		 //---------------------------------------------------
		 
		 public int actualizarAsociado(long nit_asociado,String cod_finca, String nombre_Completo, String Direccion,String Tipo_identificacion ) {
				
					ContentValues valores = new ContentValues();
					valores.put("nit_asociado", nit_asociado);
					valores.put("cod_finca",cod_finca);
					valores.put("nombre_Completo",nombre_Completo);
					valores.put("Direccion", Direccion);
					valores.put("Tipo_identificacion", Tipo_identificacion);
					
					int i= bd.update(SQLiteHelper.SAT_terceros_asociados, valores, dbHelper.nit_asociado+"="+ nit_asociado, null);
									
				
				return i;
			}
		 
		
		 
		 
}

