package com.Datos.colacteos;



public class Usuario {
	
	
	public  String id_usuario;
	public  String nombres;
	public  String apellidos;
	public  String usuario;
	public  String password;

	public Usuario(){}
	
	
	public Usuario(String id_usuario,  String nombres, String apellidos, String usuario, String Password){
		this.setId_usuario(id_usuario);
	}



	public String getId_usuario() {
		return id_usuario;
	}



	public String getNombres() {
		return nombres;
	}



	public String getApellidos() {
		return apellidos;
	}



	public String getUsuario() {
		return usuario;
	}



	public String getPassword() {
		return password;
	}



	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}



	public void setNombres(String nombres) {
		this.nombres = nombres;
	}



	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "Id: " + id_usuario + "\n"+ 
	           "Nombres: " + nombres + "\n"+ 
	           "Apellidos: " + apellidos + "\n"+ 
	           "Usuario: " + usuario  + "\n" ;
	}
	
	
}