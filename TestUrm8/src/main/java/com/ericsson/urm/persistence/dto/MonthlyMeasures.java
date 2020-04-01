package com.ericsson.urm.persistence.dto;

import java.io.Serializable;


public class MonthlyMeasures implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private String codConcentratore=null;
	private String matricolaLenntCliente;
	
	
	public MonthlyMeasures() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MonthlyMeasures(String codConcentratore, String matricolaLenntCliente) {
		super();
		this.codConcentratore = codConcentratore;
		this.matricolaLenntCliente = matricolaLenntCliente;
	}

	public String getCodConcentratore() {
		return codConcentratore;
	}

	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}

	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}

	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}
	
	
}
