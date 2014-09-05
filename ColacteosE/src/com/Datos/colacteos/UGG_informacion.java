package com.Datos.colacteos;

public class UGG_informacion {

	
	private String codigo_UGG;
	private String nombre_UGG;
	private String fecha_nacimiento;
	private String peso_UGG;
	private String numero_partos;
	private String raza_UGG;
	private String fecha_venta;
	private String fecha_muerte;
	private String motivo_muerte;
	private String genero;
	private String cantidad_abortos;
	private String servicio_toro;
	private String tipo_animal;
	private String codi_finca;
	
	public UGG_informacion(String codigo_UGG,String nombre_UGG,
			String fecha_nacimiento,String peso_UGG,String raza_UGG,
			String fecha_venta, String fecha_muerte,String motivo_muerte,String genero, String codi_finca,
			String cantidad_abortos,String servicio_toro, String tipo_animal,  String numero_partos){
		
		this.setCodigo_UGG(codigo_UGG);
		this.setNombre_UGG(nombre_UGG);
		this.setFecha_nacimiento(fecha_nacimiento);
		this.setPeso_UGG(peso_UGG);
		this.setRaza_UGG(raza_UGG);
		this.setFecha_venta(fecha_venta);
		this.setFecha_muerte(fecha_muerte);
		this.setMotivo_muerte(motivo_muerte);
		this.setGenero(genero);
		this.setCantidad_abortos(cantidad_abortos);
		this.setServicio_toro(servicio_toro);
		this.setTipo_animal(tipo_animal);
		this.setNumero_partos(numero_partos);
				
		
	}


	public String getCodi_finca() {
		return codi_finca;
	}


	public void setCodi_finca(String codi_finca) {
		this.codi_finca = codi_finca;
	}


	public String getTipo_animal() {
		return tipo_animal;
	}


	public void setTipo_animal(String tipo_animal) {
		this.tipo_animal = tipo_animal;
	}


	public String getCodigo_UGG() {
		return codigo_UGG;
	}


	public void setCodigo_UGG(String codigo_UGG) {
		this.codigo_UGG = codigo_UGG;
	}


	public String getNombre_UGG() {
		return nombre_UGG;
	}


	public void setNombre_UGG(String nombre_UGG) {
		this.nombre_UGG = nombre_UGG;
	}


	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}


	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}


	public String getPeso_UGG() {
		return peso_UGG;
	}


	public void setPeso_UGG(String peso_UGG) {
		this.peso_UGG = peso_UGG;
	}


	public String getNumero_partos() {
		return numero_partos;
	}


	public void setNumero_partos(String numero_partos) {
		this.numero_partos = numero_partos;
	}


	public String getRaza_UGG() {
		return raza_UGG;
	}


	public void setRaza_UGG(String raza_UGG) {
		this.raza_UGG = raza_UGG;
	}


	public String getFecha_venta() {
		return fecha_venta;
	}


	public void setFecha_venta(String fecha_venta) {
		this.fecha_venta = fecha_venta;
	}


	public String getFecha_muerte() {
		return fecha_muerte;
	}


	public void setFecha_muerte(String fecha_muerte) {
		this.fecha_muerte = fecha_muerte;
	}


	public String getMotivo_muerte() {
		return motivo_muerte;
	}


	public void setMotivo_muerte(String motivo_muerte) {
		this.motivo_muerte = motivo_muerte;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getCantidad_abortos() {
		return cantidad_abortos;
	}


	public void setCantidad_abortos(String cantidad_abortos) {
		this.cantidad_abortos = cantidad_abortos;
	}


	public String getServicio_toro() {
		return servicio_toro;
	}


	public void setServicio_toro(String servicio_toro) {
		this.servicio_toro = servicio_toro;
	}
	
	
}
