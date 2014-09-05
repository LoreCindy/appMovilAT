package com.bd.colacteos;

import java.util.ArrayList;
import com.Datos.colacteos.SAT_Sistema;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SAT_SistemaDao {


	private  SQLiteDatabase bd;
	private  SQLiteHelper dbHelper;


	//-------------------------------------------------
	//constructor de la clase
	//-------------------------------------------------

	public SAT_SistemaDao(Context context){
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

	
	public long crearSistema(String cod_sistema, String nom_sistema)
	{
					
		bd=	dbHelper.getWritableDatabase();
			long estado=0;
			try{
				ContentValues values = new ContentValues();

				values.put("cod_sistema",cod_sistema );
				values.put("nom_sistema", nom_sistema);
				
				return bd.insert(SQLiteHelper.SAT_sistema, null, values);
			}
			catch(Exception e){
				
				estado=0;
			}
			return estado;
		
		
		
	}
	
	
	 public Cursor listarSistemas() {
			String[] columns = new String[] { "rowid AS _id", dbHelper.cod_sistema, dbHelper.nom_sistema};
			Cursor c = bd.query(SQLiteHelper.SAT_sistema, columns, 	null, null, null, null, null);
			if (c != null) {
				c.moveToFirst();
			}
			return c;
		}
	 
	 public  ArrayList<SAT_Sistema>darSistema(){
		 
		 ArrayList<SAT_Sistema>lista=new ArrayList<SAT_Sistema>();
		abrir();
		 bd=dbHelper.getReadableDatabase();
		 Cursor c=bd.rawQuery("select  rowid AS id, nom_sistema from SAT_sistema", null);
		 SAT_Sistema ob;
		  
		while(c.moveToNext()){ob= new SAT_Sistema();
		ob.setCod_sistema(c.getString(0));
		ob.setNom_sistema(c.getString(1));
		
		
		lista.add(ob);
		}
		return lista;
		 
	 }
	 
	 public Cursor getLista() throws SQLException
	 {
		 String[] columns = new String[] { "rowid AS _id", dbHelper.cod_sistema};
	 Cursor c = bd.query( true, SQLiteHelper.SAT_sistema, columns, null, null, null, null, null, null);
	 return c;
	 }
// dbHelper.cod_sistema,
	 
	 //-------------------------------------------------------------------
	 // metodo que actualiza el sistema
	 //-------------------------------------------------------------------
	 
	 public int actualizarSistema(long cod_sistema, String nom_sistema) {
			ContentValues valores = new ContentValues();
			valores.put(dbHelper.nom_sistema, nom_sistema);
			int i = bd.update(SQLiteHelper.SAT_sistema, valores,
					dbHelper.cod_sistema + " = " + cod_sistema, null);
			return i;
		}
	 //--------------------------------------------------------------------
	 // metodo que elimina sistema
	 //---------------------------------------------------------------------

		public void eliminarSistema(long cod_sistema) {
			bd.delete(SQLiteHelper.SAT_sistema, dbHelper.cod_sistema + "="
					+ cod_sistema, null);
		}

}
