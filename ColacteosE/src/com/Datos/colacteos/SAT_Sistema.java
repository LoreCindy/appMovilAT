package com.Datos.colacteos;

public class SAT_Sistema {
	
	private String cod_sistema;
	private String nom_sistema;
	
	
	public SAT_Sistema(){}
	
	public SAT_Sistema(String cod_sistema,String nom_sistema ){
		this.setCod_sistema(cod_sistema);
		this.setNom_sistema(nom_sistema);
		
	}


	public String getCod_sistema() {
		return cod_sistema;
	}


	public String getNom_sistema() {
		return nom_sistema;
	}


	public void setCod_sistema(String cod_sistema) {
		this.cod_sistema = cod_sistema;
	}


	public void setNom_sistema(String nom_sistema) {
		this.nom_sistema = nom_sistema;
	}
	
	

}
