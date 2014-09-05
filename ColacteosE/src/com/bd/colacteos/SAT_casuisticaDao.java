package com.bd.colacteos;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SAT_casuisticaDao {
	
	
	
	private  SQLiteDatabase bd;
	private  SQLiteHelper dbHelper;


	//-------------------------------------------------
	//constructor de la clase
	//-------------------------------------------------


	public SAT_casuisticaDao(Context contexto){
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
		
	
	/*public long agregarCasuistica(String cod_casuistica,String enfermedad, String cod_sistema)	{	
		
		
		dbHelper.getWritableDatabase();
	long estado=0;
	try{
		ContentValues valores =new  ContentValues();
		valores.put("cod_casuistica", cod_casuistica);
		valores.put("enfermedad",enfermedad);
		valores.put("cod_sistema",cod_sistema);
		
		
		
		estado= bd.insert(SQLiteHelper.SAT_casuistica, null, valores);
	}
	catch(Exception e){
		
		estado=0;
	}
	return estado;
}
	*/
	
	public void agregarCasuistica(String cod_casuistica,String enfermedad, String cod_sistema)	{
		
	    SQLiteDatabase db = dbHelper.getWritableDatabase();
	    if(db != null){
	        ContentValues valores = new ContentValues();
	        valores.put("cod_casuistica", cod_casuistica);
	        valores.put("enfermedad", enfermedad);
	        valores.put("cod_sistema", cod_sistema);
	  
	        db.insert(SQLiteHelper.SAT_casuistica, null, valores);
	        db.close();   
	    }

		
	}
	
	
	
	
	public Cursor listarCasuistica() {
		String[] allColumns = new String[] { "rowid AS _id",dbHelper.cod_casuistica, dbHelper.enfermedad, dbHelper.cod_sistema};
		Cursor c = bd.query(SQLiteHelper.SAT_casuistica, allColumns, null,
				null, null, null, null);
		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}
		
	
	//--------------------------------------------------------------------------------
	// metodo de actualizar casuistica
	//--------------------------------------------------------------------------------
	public int actualizarCasuistica(long cod_casuistica, String enfermedad, String cod_sistema) {
		ContentValues c = new ContentValues();
		c.put(dbHelper.enfermedad, enfermedad);
		c.put(dbHelper.cod_sistema, cod_sistema);
		int i = bd.update(SQLiteHelper.SAT_casuistica, c,
				dbHelper.cod_casuistica + " = " + cod_casuistica, null);
		return i;
	}

	//--------------------------------------------------------------------------------
	// metodo de Eliminar casuistica
	//--------------------------------------------------------------------------------

	public void eliminarCasuistica(long cod_casuistica) {
		bd.delete(SQLiteHelper.SAT_casuistica, dbHelper.cod_casuistica + "="
				+ cod_casuistica, null);
	}


}
