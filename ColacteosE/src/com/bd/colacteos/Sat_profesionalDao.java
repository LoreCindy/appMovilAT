package com.bd.colacteos;

import com.Datos.colacteos.SAT_Profesional;
import com.Datos.colacteos.Usuario;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class Sat_profesionalDao {

	private  SQLiteDatabase bd;
	private  SQLiteHelper dbHelper;
	
	
	
	//-------------------------------------------------
	//constructor de la clase
	//-------------------------------------------------
	

	public Sat_profesionalDao(Context contexto){
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
		 * Metodo para agregar porgramacion de visita
		 * @param float nit del profesional
		 * @param String nombre Nombre completo del profesional
		 * @param String apellido Apellidos  del profesional
		 * @param String Titulo
		 * @param String Institucion
		 * @return BOOLEAN TRUE si tuvo exito FALSE caso contrario
		 * */
		
		
		public long addRegistroProfesional( String Nit, String Nombres, String Apellidos, String Titulo, String Institucion )throws Exception
		{	
			
if(Nit.equals("Nit")){
				throw new Exception("ya existe");
			}
			
			dbHelper.getWritableDatabase();
		long estado=0;
		try{
			ContentValues valores =new  ContentValues();
			valores.put("Nit", Nit);
			valores.put("Nombres", Nombres);
			valores.put("Apellidos", Apellidos);
			valores.put("Titulo", Titulo);
			valores.put("Institucion", Institucion);
			
			
			estado= bd.insert(SQLiteHelper.SAT_profesional, null, valores);
		}
		catch(Exception e){
			
			estado=0;
		}
		return estado;
	}
		
			
		
		/**
		 * Metodo para eliminar un  registro de profesional
		 * @param Long Nit del profesional
		 * */
	
		
		public void eliminarProfesional(long Nit) {
			bd.delete(SQLiteHelper.SAT_profesional, dbHelper.Nit + "="
					+ Nit, null);
		}

		
		/**
		 * Metodo para actualizar un  registro de profesionales
		 * @param String Nit
		 * @param String nombre Nombre completo
		 * @param String apellidos
		 * @param String Titulo
		 * @param String Institucion
		 * */
		
			
		public int updateProfesional(long Nit, String Nombres, String Apellidos, String Titulo, String Institucion) {
			ContentValues cvUpdate = new ContentValues();
			cvUpdate.put(dbHelper.Nombres, Nombres);
			cvUpdate.put(dbHelper.Apellidos, Apellidos);
			cvUpdate.put(dbHelper.Titulo, Titulo);
			cvUpdate.put(dbHelper.Institucion, Institucion);
			int i = bd.update(SQLiteHelper.SAT_profesional, cvUpdate,
					dbHelper.Nit + " = " +Nit, null);
			return i;
		}


			
		//_-------------------------------------------------------------
		// leer profesionales
		//-----------------------------------------------------------------
		
		public Cursor readProfesionales() {
			String[] allColumns = new String[] { "rowid AS _id", dbHelper.Nit,dbHelper.Nombres, dbHelper.Apellidos, dbHelper.Titulo, dbHelper.Institucion };
			Cursor c = bd.query(SQLiteHelper.SAT_profesional, allColumns, null,	null, null, null, null);
			if (c != null) {
				c.moveToFirst();
			}
			return c;
		}
		
		//-------------------------------------------------
		 // metodo que devuelve un usuario
		 //------------------------------------------------
		 public SAT_Profesional buscarProfesional(Long Nit ){
			 dbHelper.getReadableDatabase();
			 String[] valores={"rowid AS _id",dbHelper.Nit, dbHelper.nombres, dbHelper.Nit,dbHelper.Nombres, dbHelper.Apellidos, dbHelper.Titulo, dbHelper.Institucion };
			 Cursor c= bd.query(SQLiteHelper.SAT_profesional,  valores, "Nit=" + Nit, null, null, null, null, null);
			 if(c != null) {
			        c.moveToFirst();
			    }
			  SAT_Profesional profesional = new SAT_Profesional(c.getString(0), c.getString(1), c.getString(2), c.getString(3),  c.getString(4));
			   bd.close();
			    c.close();
			    return profesional;
		 }
		 
		 
		
		
		
		
		/*	public List<SAT_Profesional>recuperarDatos() {
				
				 String []columns ={dbHelper.Nit, dbHelper.Nombres, dbHelper.Apellidos, dbHelper.Titulo, dbHelper.Institucion};
				 List<SAT_Profesional> users = new ArrayList<SAT_Profesional>();
				Cursor cursor =bd.query(SQLiteHelper.SAT_profesional, columns, null, null, null, null, null);
				if  (cursor.moveToFirst()) {
					while(cursor.isAfterLast()) {
						SAT_Profesional user = new SAT_Profesional( cursor.getString(0),
								cursor.getString(1),
								cursor.getString(2),
								cursor.getString(3),
								cursor.getString(4));
						users.add(user);
						cursor.moveToNext();
					}
				}
				cursor.close();
				return users;
			}
			*/
			
		}
		

