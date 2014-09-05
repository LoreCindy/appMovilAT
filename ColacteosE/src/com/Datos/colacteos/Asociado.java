package com.Datos.colacteos;

public class Asociado {

	
	private String nit;
  	private String cod_finca;
	private String nombre_Completo;
	private  String Direccion;
	private  String telefono;
	private String Tipo_identificacion;
	
	
	public Asociado(String nit,String cod_finca, String nombre_Completo, String Direccion,String Tipo_identificacion){
		this.setNit(nit);
	}


	public String getNit() {
		return nit;
	}


	public String getCod_finca() {
		return cod_finca;
	}


	public String getNombre_Completo() {
		return nombre_Completo;
	}


	public String getDireccion() {
		return Direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public String getTipo_identificacion() {
		return Tipo_identificacion;
	}


	public void setNit(String nit) {
		this.nit = nit;
	}


	public void setCod_finca(String cod_finca) {
		this.cod_finca = cod_finca;
	}


	public void setNombre_Completo(String nombre_Completo) {
		this.nombre_Completo = nombre_Completo;
	}


	public void setDireccion(String direccion) {
		Direccion = direccion;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public void setTipo_identificacion(String tipo_identificacion) {
		Tipo_identificacion = tipo_identificacion;
	}
	
}
