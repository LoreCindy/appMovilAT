package com.bd.colacteos;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import com.bd.colacteos.SQLiteHelper;


import android.database.Cursor;
import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Message;
import com.Datos.colacteos.*;

public class usuarioDao  {

	
	private  SQLiteDatabase bd;
	private  SQLiteHelper dbHelper;
	
	//-------------------------------------------------
	//constructor de la clase
	//-------------------------------------------------
	
	public usuarioDao(Context context){
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
		 * Metodo para agregar un nuevo registro de usuario
		 * @param String nombre Nombre completo
		 * @param String apellido Apellidos
		 * @param String user usuario
		 * @param String pass password
		 * */
			
	
	
		public void addRegistro( String nombres, String apellidos, String usuario, String password )
		{
				
		dbHelper.getWritableDatabase();
			ContentValues valores =new  ContentValues();
			valores.put("nombres", nombres);
			valores.put("apellidos",apellidos);
			valores.put("usuario", usuario);
			valores.put("password", password);
			
			bd.insert(SQLiteHelper.tabla_usuario, null, valores);
			bd.close();
		}
		
		

		/**
		 * Metodo para eliminar un  registro de usuario
		 * @param Long id id del usuario
		 * */


		public void deleteUsurio(long id_usuario) {
			bd.delete(SQLiteHelper.tabla_usuario, dbHelper.id_usuario + "="
					+ id_usuario, null);
		}

		
		/**
		 * Metodo para actualizar un  registro de usuario
		 * @param Long id id usuario
		 *  @param String nombres Nombres usuario
		 *  @param String apellidos apellidos usuario
		 *  @param String usuario 
		 *  @param String password usuario
		 * 
		 * */
		
			
		public int updateUsuario(long id_usuario, String nombres, String apellidos, String usuario, String password) {
			ContentValues cvUpdate = new ContentValues();
			cvUpdate.put(dbHelper.nombres, nombres);
			cvUpdate.put(dbHelper.apellidos, apellidos);
			cvUpdate.put(dbHelper.usuario, usuario);
			cvUpdate.put(dbHelper.password, password);
			int i = bd.update(SQLiteHelper.tabla_usuario, cvUpdate,
					dbHelper.id_usuario + " = " +id_usuario, null);
			return i;
		}
		/**
		 * Obtiene todos los registros de la unica tabla de la base de datos
		 * @return Cursor
		 * */
		/*public Cursor cargarUsuarios(){
			String[] columnas= new String[]{dbHelper.nombres, dbHelper.apellidos, dbHelper.usuario, dbHelper.password};
			return bd.query(false, SQLiteHelper.tabla_usuario, columnas,null,null, null, null, null, null);
			
		}*/
		//------------------------------------------------------------------------
		//metodo para ingresar con usuario y contraseña
		//-----------------------------------------------------------------------
		public boolean Login(String usuario, String password) throws SQLException
		{
			try{
				//String clave=md5(password);
				Cursor mCursor = bd.rawQuery( "SELECT * FROM "+SQLiteHelper.tabla_usuario +  " WHERE usuario=? AND password=?", new String[]{usuario,password});
		if (mCursor != null) {
		if(mCursor.getCount() > 0)
		{
		return true;
		}
		}
		return false;
		}
		catch(Exception e){
			e.getMessage();
			return false;
		}
			//Cursor m= bd.rawQuery("SELECT * FROM ", selectionArgs)
		}
		
		
		//funcion para encriptar md5
		 public static String md5(String clear) throws Exception {
		     MessageDigest md = MessageDigest.getInstance("MD5");
		     byte[] b = md.digest(clear.getBytes());
		     int size = b.length;
		     StringBuffer h = new StringBuffer(size);
		     //algoritmo y arreglo md5
		         for (int i = 0; i < size; i++) {
		             int u = b[i] & 255;
		                 if (u < 16) {
		                     h.append("0" + Integer.toHexString(u));
		                 }
		                else {
		                     h.append(Integer.toHexString(u));
		                }
		            }
		       //clave encriptada
		       return h.toString();
		     }
		
		//--------------------------------------------------------------
		// metodo que permite hacer la lista de usuario
		//--------------------------------------------------------------
		
		 public Cursor readData() {
				String[] allColumns = new String[] { "rowid AS _id",dbHelper.id_usuario, dbHelper.nombres, dbHelper.apellidos, dbHelper.usuario, dbHelper.password};
				Cursor c = bd.query(SQLiteHelper.tabla_usuario, allColumns, null,
						null, null, null, null);
				if (c != null) {
					c.moveToFirst();
				}
				return c;
			}
		 
		 //-------------------------------------------------
		 // metodo que devuelve un usuario
		 //------------------------------------------------
		 public Usuario buscarUsuario(String nombre ){
			 dbHelper.getReadableDatabase();
			 String[] valores={"rowid AS _id",dbHelper.id_usuario, dbHelper.nombres, dbHelper.apellidos, dbHelper.usuario, dbHelper.password};
			 Cursor c= bd.query(SQLiteHelper.tabla_usuario,  valores, "nombres=" + nombre, null, null, null, null, null);
			 if(c != null) {
			        c.moveToFirst();
			    }
			   Usuario usuarios = new Usuario(c.getString(0), c.getString(1), c.getString(2), c.getString(3),  c.getString(4));
			   bd.close();
			    c.close();
			    return usuarios;
		 }
		 
		 
		 
		 public Usuario read(String nombre) {
			 String[] valores={"rowid AS _id",dbHelper.id_usuario, dbHelper.nombres, dbHelper.apellidos, dbHelper.usuario, dbHelper.password};
			 Cursor c= bd.query(SQLiteHelper.tabla_usuario,  valores, ".nombres=" + nombre, null, null, null, null, null);
				Usuario user = new Usuario();
				if  (c.moveToFirst()) {
					user.setId_usuario(c.getString(0));
					user.setNombres(c.getString(1));
					user.setApellidos(c.getString(2));
					user.setUsuario(c.getString(3));
					user.setPassword(c.getString(4));
				}
				c.close();
				return user;
			}
		 

		
	
		
		
		
	}
		

