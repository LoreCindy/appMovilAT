package com.Datos.colacteos;

public class Actividad {
	
	private Long id_actividad ;
	private  String  nom_actividad;
	private  String  costo_actividad ;
	
	public Actividad(Long id_actividad, String  nom_actividad, String  costo_actividad ) {
		
		this.setId_actividad(id_actividad);
		this.setNom_actividad(nom_actividad);
		this.setCosto_actividad(costo_actividad);
		
	}

	public long getId_actividad() {
		return id_actividad;
	}

	public String getNom_actividad() {
		return nom_actividad;
	}

	public String getCosto_actividad() {
		return costo_actividad;
	}

	public void setId_actividad(long id_actividad) {
		this.id_actividad = id_actividad;
	}

	public void setNom_actividad(String nom_actividad) {
		this.nom_actividad = nom_actividad;
	}

	public void setCosto_actividad(String costo_actividad) {
		this.costo_actividad = costo_actividad;
	} 
	
	
	

}
