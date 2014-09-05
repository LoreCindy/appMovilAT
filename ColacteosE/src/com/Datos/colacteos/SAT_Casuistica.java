package com.Datos.colacteos;

public class SAT_Casuistica {
	
	
	
	private String cod_casuistica;
  	private String enfermedad;
	private String cod_sistema;
	
	public SAT_Casuistica(){}
	
	public SAT_Casuistica(String cod_casuistica,String enfermedad, String cod_sistema){
		
		this.setCod_casuistica(cod_casuistica);
		this.setCod_sistema(cod_sistema);
		this.setEnfermedad(enfermedad);
	}

	public String getCod_casuistica() {
		return cod_casuistica;
	}

	public String getEnfermedad() {
		return enfermedad;
	}

	public String getCod_sistema() {
		return cod_sistema;
	}

	public void setCod_casuistica(String cod_casuistica) {
		this.cod_casuistica = cod_casuistica;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	public void setCod_sistema(String cod_sistema) {
		this.cod_sistema = cod_sistema;
	}
	
	

}
