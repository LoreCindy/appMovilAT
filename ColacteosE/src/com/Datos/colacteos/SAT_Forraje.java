package com.Datos.colacteos;

public class SAT_Forraje {
	
	
	public  String codigo_forraje;
	public  String nombre_forraje;
	
	public SAT_Forraje(String codigo_forraje,String nombre_forraje ){
		
		this.setCodigo_forraje(codigo_forraje);
		this.setNombre_forraje(nombre_forraje);
		
	}

	public String getCodigo_forraje() {
		return codigo_forraje;
	}

	public String getNombre_forraje() {
		return nombre_forraje;
	}

	public void setCodigo_forraje(String codigo_forraje) {
		this.codigo_forraje = codigo_forraje;
	}

	public void setNombre_forraje(String nombre_forraje) {
		this.nombre_forraje = nombre_forraje;
	}

	@Override
	public String toString() {
		return "SAT_Forraje [codigo_forraje=" + codigo_forraje
				+ ", nombre_forraje=" + nombre_forraje + "]";
	}
	
	

	
}
