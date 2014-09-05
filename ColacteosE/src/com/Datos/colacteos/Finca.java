package com.Datos.colacteos;

public class Finca {

	private String codigo_finca;
	private String  nombre_finca;
	private String nit_propietario;
	private String  ciudad;
	private String ubicacion;
	private String  hectareas;
	private String  latitud;
	private String  longitud;
	private String  mano_obra;
	private String  codigo_tipo_ordeno;
	
	private String  departamento;
	
	public Finca(String codigo_finca,String  nombre_finca,String nit_propietario,String  ciudad,String ubicacion,
	String  hectareas, String  latitud, String  longitud, String  mano_obra,
	String  codigo_tipo_ordeno,  String  departamento ){
		
		this.setCodigo_finca(codigo_finca);
		this.setNombre_finca(nombre_finca);
		this.setNit_propietario(nit_propietario);
		this.setCiudad(ciudad);
		this.setUbicacion(ubicacion);
		this.setHectareas(hectareas);
		this.setLatitud(latitud);
		this.setLongitud(longitud);
		this.setMano_obra(mano_obra);
		this.setCodigo_tipo_ordeno(codigo_tipo_ordeno);
		this.setDepartamento(departamento);
	}

	public String getCodigo_finca() {
		return codigo_finca;
	}

	public String getNombre_finca() {
		return nombre_finca;
	}

	public String getNit_propietario() {
		return nit_propietario;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public String getHectareas() {
		return hectareas;
	}

	public String getLatitud() {
		return latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public String getMano_obra() {
		return mano_obra;
	}

	public String getCodigo_tipo_ordeno() {
		return codigo_tipo_ordeno;
	}

	

	public String getDepartamento() {
		return departamento;
	}

	public void setCodigo_finca(String codigo_finca) {
		this.codigo_finca = codigo_finca;
	}

	public void setNombre_finca(String nombre_finca) {
		this.nombre_finca = nombre_finca;
	}

	public void setNit_propietario(String nit_propietario) {
		this.nit_propietario = nit_propietario;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public void setHectareas(String hectareas) {
		this.hectareas = hectareas;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public void setMano_obra(String mano_obra) {
		this.mano_obra = mano_obra;
	}

	public void setCodigo_tipo_ordeno(String codigo_tipo_ordeno) {
		this.codigo_tipo_ordeno = codigo_tipo_ordeno;
	}

	

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	
}
