package com.Datos.colacteos;

public class SAT_Visita {
	
private long id_visita;
private String cod_fincas;
private  String fecha_visita;
private String hora_ingreso;
private String clase_visita;
private String cumple;
private String num_recetario;
private String nit_profesional;
private String tipo_visita;
private String observaciones;
private String identificacion_asociado;


public SAT_Visita(long id_visita,String cod_fincas,  String fecha_visita, 
		String hora_ingreso,  String clase_visita, String cumple,String num_recetario,
		String nit_profesional,String tipo_visita,String observaciones,String identificacion_asociado){
	
	
	this.setId_visita(id_visita);
	this.setCod_fincas(cod_fincas);
	this.setFecha_visita(fecha_visita);
	this.setHora_ingreso(hora_ingreso);
	this.setClase_visita(clase_visita);
	this.setCumple(cumple);
	this.setNum_recetario(num_recetario);
	this.setNit_profesional(nit_profesional);
	this.setTipo_visita(tipo_visita);
	this.setObservaciones(observaciones);
	this.setIdentificacion_asociado(identificacion_asociado);
}


public long getId_visita() {
	return id_visita;
}


public String getCod_fincas() {
	return cod_fincas;
}


public String getFecha_visita() {
	return fecha_visita;
}


public String getHora_ingreso() {
	return hora_ingreso;
}


public String getClase_visita() {
	return clase_visita;
}


public String getCumple() {
	return cumple;
}


public String getNum_recetario() {
	return num_recetario;
}


public String getNit_profesional() {
	return nit_profesional;
}


public String getTipo_visita() {
	return tipo_visita;
}


public String getObservaciones() {
	return observaciones;
}


public String getIdentificacion_asociado() {
	return identificacion_asociado;
}


public void setId_visita(long id_visita) {
	this.id_visita = id_visita;
}


public void setCod_fincas(String cod_fincas) {
	this.cod_fincas = cod_fincas;
}


public void setFecha_visita(String fecha_visita) {
	this.fecha_visita = fecha_visita;
}


public void setHora_ingreso(String hora_ingreso) {
	this.hora_ingreso = hora_ingreso;
}


public void setClase_visita(String clase_visita) {
	this.clase_visita = clase_visita;
}


public void setCumple(String cumple) {
	this.cumple = cumple;
}


public void setNum_recetario(String num_recetario) {
	this.num_recetario = num_recetario;
}


public void setNit_profesional(String nit_profesional) {
	this.nit_profesional = nit_profesional;
}


public void setTipo_visita(String tipo_visita) {
	this.tipo_visita = tipo_visita;
}


public void setObservaciones(String observaciones) {
	this.observaciones = observaciones;
}


public void setIdentificacion_asociado(String identificacion_asociado) {
	this.identificacion_asociado = identificacion_asociado;
}




}
