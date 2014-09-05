package com.Datos.colacteos;

public class SAT_Cultivo {

	private Long cod_cultivo;
	private String nom_cultivo;
	private String promedio_hectaria;
	private String codigo_fincas;
	
	
	
	public SAT_Cultivo(Long cod_cultivo,String nom_cultivo,String promedio_hectaria, String codigo_fincas){
		this.setCod_cultivo(cod_cultivo);
		this.setNom_cultivo(nom_cultivo);
		this.setPromedio_hectaria(promedio_hectaria);
		this.setCodigo_fincas(codigo_fincas);
		
	}



	public Long getCod_cultivo() {
		return cod_cultivo;
	}



	public String getNom_cultivo() {
		return nom_cultivo;
	}



	public String getPromedio_hectaria() {
		return promedio_hectaria;
	}



	public String getCodigo_fincas() {
		return codigo_fincas;
	}



	public void setCod_cultivo(Long cod_cultivo) {
		this.cod_cultivo = cod_cultivo;
	}



	public void setNom_cultivo(String nom_cultivo) {
		this.nom_cultivo = nom_cultivo;
	}



	public void setPromedio_hectaria(String promedio_hectaria) {
		this.promedio_hectaria = promedio_hectaria;
	}



	public void setCodigo_fincas(String codigo_fincas) {
		this.codigo_fincas = codigo_fincas;
	}
	
	
	
}
