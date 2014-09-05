package com.bd.colacteos;

import java.util.ArrayList;
import java.util.List;

import com.Datos.colacteos.Finca;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class fincaDao {

	
	private  SQLiteDatabase bd;
	private  SQLiteHelper dbHelper;
	

	//-------------------------------------------------
	//constructor de la clase
	//-------------------------------------------------
	

	public fincaDao(Context contexto){
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

		//-----------------------------------------
		//metodo para agregar finca
		//---------------------------------------------------------

		public void insertarFinca(String  nombre_finca,String nit_propietario,
				String  ciudad,String ubicacion,
				String  hectareas, String  latitud, String  longitud, String  mano_obra,
				String  codigo_tipo_ordeno,  String  departamento ) 
		{
			

			SQLiteDatabase db =dbHelper.getWritableDatabase();

			ContentValues valores =new  ContentValues();
			//valores.put("codigo_finca", codigo_finca);
			valores.put("nombre_finca",nombre_finca);
			valores.put("nit_propietario",nit_propietario);
			valores.put("ciudad", ciudad);
			valores.put("ubicacion", ubicacion);
			valores.put("hectareas", hectareas);
			valores.put("latitud", latitud);
			valores.put("longitud",longitud);
			valores.put("mano_obra",mano_obra);
			valores.put("codigo_tipo_ordeno", codigo_tipo_ordeno);
			valores.put("departamento", departamento);


			bd.insert(SQLiteHelper.SAT_terceros_fincas, null, valores);

			db.close();   

		}


		public long agregarfinca(String codigo_finca,String  nombre_finca,String nit_propietario,
				String  ciudad,String ubicacion,
				String  hectareas, String  latitud, String  longitud, String  mano_obra,
				String  codigo_tipo_ordeno,  String  departamento )
		{	


			dbHelper.getWritableDatabase();
			long estado=0;
			try{
				ContentValues valores =new  ContentValues();
				valores.put("codigo_finca", codigo_finca);
				valores.put("nombre_finca",nombre_finca);
				valores.put("nit_propietario",nit_propietario);
				valores.put("ciudad", ciudad);
				valores.put("ubicacion", ubicacion);
				valores.put("hectareas", hectareas);
				valores.put("latitud", latitud);
				valores.put("longitud",longitud);
				valores.put("mano_obra",mano_obra);
				valores.put("codigo_tipo_ordeno", codigo_tipo_ordeno);
				valores.put("departamento", departamento);


				estado= bd.insert(SQLiteHelper.SAT_terceros_fincas, null, valores);
			}
			catch(Exception e){

				estado=0;
			}
			return estado;
		}
		
		
		//---------------------------------------------
		//modificar finca
		//--------------------------------------------
		public int modificarFinca(long codigo_finca,String  nombre_finca,String nit_propietario,
				String  ciudad,String ubicacion,
				String  hectareas, String  latitud, String  longitud, String  mano_obra,
				String  codigo_tipo_ordeno,  String  departamento){
			// SQLiteDatabase db = dbHelper.getWritableDatabase();

			ContentValues valores =new  ContentValues();
			valores.put("codigo_finca", codigo_finca);
			valores.put("nombre_finca",nombre_finca);
			valores.put("nit_propietario",nit_propietario);
			valores.put("ciudad", ciudad);
			valores.put("ubicacion", ubicacion);
			valores.put("hectareas", hectareas);
			valores.put("latitud", latitud);
			valores.put("longitud",longitud);
			valores.put("mano_obra",mano_obra);
			valores.put("codigo_tipo_ordeno", codigo_tipo_ordeno);
			valores.put("departamento", departamento);
			int i= bd.update(SQLiteHelper.SAT_terceros_fincas, valores, 
					dbHelper.codigo_finca + " = " + codigo_finca, null);
			return i;  
		}
				
		//------------------------------------------------------------------------
		//metodo para eliminar una finca
		//------------------------------------------------------------------------
		public void eliminarFinca(long codigo_finca){
			//SQLiteDatabase db = dbHelper.getWritableDatabase();
			bd.delete(SQLiteHelper.SAT_terceros_fincas,dbHelper.codigo_finca+ "="+ codigo_finca,null);

			
		}

		//----------------------------------------
		// leer un registro
		//---------------------------------------


		public Finca recuperarFinca(String id) {
			SQLiteDatabase db = dbHelper.getReadableDatabase();

			String[] valores_recuperar = {"_id", "codigo_finca", "nombre_finca", "nit_propietario",
					"ciudad", "ubicacion", "hectareas", "latitud", "longitud", "mano_obra", "codigo_tipo_ordeno",
			"departamento"};
			Cursor c = db.query(SQLiteHelper.SAT_terceros_fincas, valores_recuperar, "_id=" + id, 
					null, null, null, null, null);
			if(c != null) {
				c.moveToFirst();
			}
			Finca finca = new Finca(c.getString(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5), c.getString(6), c.getString(7), c.getString(8), c.getString(9), c.getString(10));

			db.close();
			c.close();
			return finca;
		}


		//----------------------------------------------------
		//metodo  que sirve para buscar un asociado
		//---------------------------------------------------


		public Cursor buscarFinca(String codigo_finca){
			String[] columnas= new  String[]{dbHelper.codigo_finca,dbHelper.nombre_finca, dbHelper.nit_propietario, dbHelper.ciudad, dbHelper.ubicacion, 
					dbHelper.ubicacion, dbHelper.latitud, dbHelper.longitud, dbHelper.mano_obra,
					dbHelper.codigo_tipo_ordeno,dbHelper.departamento};
			return bd.query(SQLiteHelper.SAT_terceros_fincas, columnas, dbHelper.codigo_finca+"?",new String[]{codigo_finca},  null,  null,  null,  null);
		}

		//----------------------------------------------------
		//metodo  que sirve para actualizar datos de finca
		//---------------------------------------------------

		public int actualizarAsociado(String codigo_finca, String nombre_finca,String nit_propietario,
				String  ciudad, String ubicacion,
				String  hectareas, String  latitud, String  longitud, String  mano_obra,
				String  codigo_tipo_ordeno, String  codd_cultivo,  String  departamento) {
			int filas = 0;
			bd= dbHelper.getWritableDatabase();
			if(bd!=null){
				ContentValues valores = new ContentValues();
				valores.put("codigo_finca", codigo_finca);
				valores.put("nombre_finca",nombre_finca);
				valores.put("nit_propietario",nit_propietario);
				valores.put("ciudad", ciudad);
				valores.put("ubicacion", ubicacion);
				valores.put("hectareas", hectareas);
				valores.put("latitud", latitud);
				valores.put("longitud", longitud);
				valores.put("mano_obra", mano_obra);
				valores.put("codigo_tipo_ordeno", codigo_tipo_ordeno);
				valores.put("codd_cultivo", codd_cultivo);
				valores.put("departamento", departamento);
				filas=(int) bd.update(SQLiteHelper.SAT_terceros_fincas, valores, "codigo_finca=?", new String []{String.valueOf(codigo_finca)});
				//return bd.update(SQLiteHelper.SAT_terceros_asociados, valores, dbHelper.nit + " = " + nit, null);
			}
			bd.close();
			return filas;
		}

		//--------------------------------------------------------------------------
		// metodo que permite  leer datos de finca
		//--------------------------------------------------------------------------

		public Cursor leerFinca() {
			String[] allColumns = new String[] { dbHelper.codigo_finca,dbHelper.nombre_finca, dbHelper.nit_propietario, dbHelper.ciudad, dbHelper.ubicacion, 
					dbHelper.ubicacion, dbHelper.latitud, dbHelper.longitud, dbHelper.mano_obra,
					dbHelper.codigo_tipo_ordeno,dbHelper.departamento };
			Cursor c = bd.query(SQLiteHelper.SAT_terceros_fincas, allColumns, null, null, null,null, null);
			if (c != null) {
				c.moveToFirst();
			}
			return c;
		}



		//-------------------------------------------
		// devuelve codigo de finca
		//------------------------------------

		public Cursor darCodigoFinca() throws SQLException
		{
			String[] columns = new String[] { "rowid AS _id", dbHelper.codigo_finca};
			Cursor c = bd.query( true, SQLiteHelper.SAT_terceros_fincas, columns, null, null, null, null, null, null);
			return c;
		}


		//-------------------------------------------
		// devuelve lista de fincas
		//------------------------------------

		public List<Finca> listarFincas() {
			SQLiteDatabase db = dbHelper.getReadableDatabase();
			List<Finca> lista_contactos = new ArrayList<Finca>();
			String[] valores_recuperar = {"_id", "codigo_finca", "nombre_finca"};
			Cursor c = db.query(dbHelper.SAT_terceros_fincas, valores_recuperar, 
					null, null, null, null, null, null);
			c.moveToFirst();
			do {
				Finca finca = new Finca(c.getString(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5), c.getString(6), c.getString(7), c.getString(8), c.getString(9), c.getString(10));

			} while (c.moveToNext());
			db.close();
			c.close();
			return lista_contactos;
		} 


		public Cursor listaFincas() throws SQLException
		{
			String[] columns = new String[] { "rowid AS _id", dbHelper.codigo_finca, dbHelper.nombre_finca, dbHelper.nit_propietario, dbHelper.ciudad, dbHelper.ubicacion, dbHelper.hectareas, dbHelper.latitud, dbHelper.longitud, dbHelper.mano_obra, dbHelper.codigo_tipo_ordeno, dbHelper.departamento};
			Cursor c = bd.query( true, SQLiteHelper.SAT_terceros_fincas, columns, null, null, null, null, null, null);
			if (c != null) {
				c.moveToFirst();
			}
			return c;
		}







		/*		public ArrayList<Finca>darFincas(){
						ArrayList<Finca> lista= new ArrayList<Finca>();
						SQLiteDatabase d=dbHelper.getWritableDatabase();
						d.execSQL("INSERT INTO SAT_terceros_fincas VALUES(1,'la pradera', '1085909452','pasto', 'chachagui', 10, 12,30, 'contratada', 1,2,'Nariño')");

						SQLiteDatabase db= dbHelper.getReadableDatabase();

						Cursor cr=db.rawQuery("select * from  SAT_terceros_fincas order by cod_finca", null);
						Finca ob;
						while(cr.moveToNext()){
							ob= new Finca(null, null, null, null, null, null, null, null, null, null, null, null);
							ob.setCodigo_finca(cr.getString(0));
							ob.setNombre_finca(cr.getString(1));
							ob.setNit_propietario(cr.getString(3));
							ob.setCiudad(cr.getString(4));
							ob.setUbicacion(cr.getString(5));
							ob.setHectareas(cr.getString(6));
							ob.setLatitud(cr.getString(7));
							ob.setLongitud(cr.getString(8));
							ob.setMano_obra(cr.getString(9));
							ob.setCodigo_tipo_ordeno(cr.getString(10));
							ob.setCodd_cultivo(cr.getString(11));
							ob.setDepartamento(cr.getString(12));

							lista.add(ob);
						}
						return lista;
				}

		 */



}
