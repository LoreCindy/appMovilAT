package com.bd.colacteos;

import com.Datos.colacteos.UGG_informacion;
import com.Datos.colacteos.Usuario;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UGG_informacionDao {

	
	private  SQLiteDatabase bd;
	private  SQLiteHelper dbHelper;
	
	
	//-------------------------------------------------
	//constructor de la clase
	//-------------------------------------------------
	
	public UGG_informacionDao(Context context) {
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
	
	
	/**
	 * Metodo para agregar un nuevo animal
	 * @param Long codgo animal
	 * @param String nombre animal
	 * @param String fecha naciemiento
	 * @param String peso
	 * @param String numero partos
	 * @param String raza
	 * @param String fecha venta
	 * @param String fecha vmuerte
	 * @param String motivo muerte
	 * @param String genero
	 * @param String cantidad abortos
	 * @param String servicios toro
	 * @param String codigo finca
	 * */
	
	
	public void  registrarAnimal( String codigo_UGG,String nombre_UGG,
			String fecha_nacimiento,String peso_UGG,String raza_UGG,
			String fecha_venta, String fecha_muerte,String motivo_muerte,String genero, String codigo_finca,
			String cantidad_abortos,String servicio_toro, String tipo_animal,  String numero_partos)
	{	dbHelper.getWritableDatabase();
	
		ContentValues valores =new  ContentValues();
		valores.put("codigo_UGG", codigo_UGG);
		valores.put("nombre_UGG", nombre_UGG);
		valores.put("fecha_nacimiento",fecha_nacimiento);
		valores.put("peso_UGG", peso_UGG);
		valores.put("raza_UGG", raza_UGG);
		valores.put("fecha_venta", fecha_venta);
		valores.put("fecha_muerte", fecha_muerte);
		valores.put("motivo_muerte", motivo_muerte);
		valores.put("genero", genero);
		valores.put("codigo_finca", codigo_finca);
		valores.put("cantidad_abortos", cantidad_abortos);
		valores.put("servicio_toro", servicio_toro);
		valores.put("tipo_animal", tipo_animal);		
		valores.put("numero_partos", numero_partos);

				
		bd.insert(SQLiteHelper.UGG_informacion , null, valores);
		bd.close();
	
	}
		//-----------------------------------------------------
		//metodo eliminar animal 
		//------------------------------------------------------
		
		public void eliminarAnimal(long codigo_UGG) {
			
			bd.delete(SQLiteHelper.UGG_informacion, dbHelper.codigo_UGG + "="
					+ codigo_UGG, null);
		}
		
		//-----------------------------------------------------------
		// actualizar animal
		//-----------------------------------------------------------
		
		
		public int actualizarAnimal(String codigo_UGG,String nombre_UGG,
				String fecha_nacimiento,String peso_UGG,String raza_UGG,
				String fecha_venta, String fecha_muerte,String motivo_muerte,String genero, String codi_finca,
				String cantidad_abortos,String servicio_toro, String tipo_animal,  String numero_partos)
		
		 {
			ContentValues valores =new  ContentValues();
			valores.put(dbHelper.codigo_UGG, codigo_UGG);
			valores.put(dbHelper.nombre_UGG, nombre_UGG);
			valores.put(dbHelper.fecha_nacimiento,fecha_nacimiento);
			valores.put(dbHelper.peso_UGG, peso_UGG);
			valores.put(dbHelper.raza_UGG, raza_UGG);
			valores.put(dbHelper.fecha_venta, fecha_venta);
			valores.put(dbHelper.fecha_muerte, fecha_muerte);
			valores.put(dbHelper.motivo_muerte, motivo_muerte);
			valores.put(dbHelper.genero, genero);
			valores.put(dbHelper.codigo_finca, codi_finca);
			valores.put(dbHelper.cantidad_abortos, cantidad_abortos);
			valores.put(dbHelper.servicio_toro, servicio_toro);
			valores.put(dbHelper.tipo_animal, numero_partos);
			valores.put(dbHelper.numero_partos, numero_partos);
			
			
			int i = bd.update(SQLiteHelper.UGG_informacion, valores,
					dbHelper.codigo_UGG + " = " +codigo_UGG, null);
			return i;
		}
	
		//--------------------------------------------------------
		// lista de animales
		//-------------------------------------------------------
	
		public Cursor listaAnimales() {
			String[] allColumns = new String[] { "rowid AS _id",
					dbHelper.codigo_UGG,//cambiar dbHelper
					dbHelper.nombre_UGG,
					dbHelper.fecha_nacimiento,
					dbHelper.peso_UGG,
					dbHelper.raza_UGG,
					dbHelper.fecha_venta,
					dbHelper.fecha_muerte,
					dbHelper.motivo_muerte,
					dbHelper.genero,
					dbHelper.codigo_finca,
					dbHelper.cantidad_abortos, 
					dbHelper.servicio_toro,
					dbHelper.tipo_animal,
					dbHelper.numero_partos };
			Cursor c = bd.query(SQLiteHelper.UGG_informacion, allColumns, null,
					null, null, null, null);
			if (c != null) {
				c.moveToFirst();
			}
			return c;
		}
		
		
		//-------------------------------------------------
		 // metodo que permite buscar un animal
		 //------------------------------------------------
		 public UGG_informacion buscarAnimal(long codigo_UGG ){
			 dbHelper.getReadableDatabase();
			 String[] valores={ "rowid AS _id",dbHelper.codigo_UGG, dbHelper.nombre_UGG,
						dbHelper.fecha_nacimiento,dbHelper.peso_UGG,dbHelper.numero_partos, dbHelper.raza_UGG,
						dbHelper.fecha_venta,dbHelper.fecha_muerte, dbHelper.motivo_muerte,dbHelper.genero,
						dbHelper.cantidad_abortos, dbHelper.servicio_toro, dbHelper.codigo_finca};
			 Cursor c= bd.query(SQLiteHelper.UGG_informacion,  valores, dbHelper.codigo_UGG+"=" + codigo_UGG, null, null, null, null, null);
			 if(c != null) {
			        c.moveToFirst();
			    }
			 UGG_informacion ugg = new UGG_informacion(
					 c.getString(0), 
					 c.getString(1),
					 c.getString(2), 
					 c.getString(3), 
					 c.getString(4),
			 		c.getString(5), 
			 		c.getString(6),
			 		c.getString(7), 
			 		c.getString(8), 
			 		c.getString(9),
			 		c.getString(10), 
			 		c.getString(11),
			 		c.getString(12),
			 		c.getString(13));
			 		
			   bd.close();
			    c.close();
			    return ugg;
		 }
		 
}
	

