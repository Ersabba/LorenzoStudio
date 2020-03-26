package com.ericsson.mgre.datatypes;

import java.io.Serializable;

public class FileLedClusteringRecord implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String matricolaLenntCliente;
	private String codConcentratore;
	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}
	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}
	public String getCodConcentratore() {
		return codConcentratore;
	}
	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}
	@Override
	public String toString() {
		return "FileLedClusteringRecord [matricolaLenntCliente=" + matricolaLenntCliente + ", codConcentratore="
				+ codConcentratore + "]";
	}

	
}
