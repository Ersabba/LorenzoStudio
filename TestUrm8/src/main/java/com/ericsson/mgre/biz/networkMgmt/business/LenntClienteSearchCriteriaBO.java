package com.ericsson.mgre.biz.networkMgmt.business;

import java.io.Serializable;

public class LenntClienteSearchCriteriaBO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String[] matricolaLenntCliente;
	private String codConcentratore=null;
	
	
	public String[] getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}
	public void setMatricolaLenntCliente(String[] matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}
	public String getCodConcentratore() {
		return codConcentratore;
	}
	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}
	
	

}
