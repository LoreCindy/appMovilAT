package com.Datos.colacteos;

public class SAT_Profesional {
	
	private String Nit;
	public  String Nombres;
	public String Apellidos;
	public  String Titulo;
	public String Institucion;
	
	
	
	public SAT_Profesional(String Nit, String Nombres, String Apellidos, String Titulo, String Institucion){
	this.Nit=Nit;
	this.Apellidos=Apellidos;
	this.Apellidos=Apellidos;
	this.Titulo=Titulo;
	this.Institucion= Institucion;
	}



	public String getApellidos() {
		return Apellidos;
	}



	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}



	public String getNit() {
		return Nit;
	}



	public void setNit(String nit) {
		Nit = nit;
	}



	public String getNombres() {
		return Nombres;
	}



	public void setNombres(String nombres) {
		Nombres = nombres;
	}



	

	public String getTitulo() {
		return Titulo;
	}



	public void setTitulo(String titulo) {
		Titulo = titulo;
	}



	public String getInstitucion() {
		return Institucion;
	}



	public void setInstitucion(String institucion) {
		Institucion = institucion;
	}

}
