package com.ericsson.mgre.datatypes;

import java.io.Serializable;

public class CaricamentoAnagraficaLenntCMRecord implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String matricolaLenntCliente;
	private String eei;
	private String eua;
	private String ipm;
	
	
	private String eea;
	private String eec;
	private String euc;
	private String eui;
	
	
	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}
	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}
	public String getEei() {
		return eei;
	}
	public void setEei(String eei) {
		this.eei = eei;
	}
	public String getEua() {
		return eua;
	}
	public void setEua(String eua) {
		this.eua = eua;
	}
	public String getIpm() {
		return ipm;
	}
	public void setIpm(String ipm) {
		this.ipm = ipm;
	}
	
	
	
	
	public String getEea() {
		return eea;
	}
	public void setEea(String eea) {
		this.eea = eea;
	}
	public String getEec() {
		return eec;
	}
	public void setEec(String eec) {
		this.eec = eec;
	}
	public String getEuc() {
		return euc;
	}
	public void setEuc(String euc) {
		this.euc = euc;
	}
	public String getEui() {
		return eui;
	}
	public void setEui(String eui) {
		this.eui = eui;
	}
	
	
	
	@Override
	public String toString() {
		return "CaricamentoAnagraficaLenntCMRecord [matricolaLenntCliente="
				+ matricolaLenntCliente + ", eei=" + eei + ", eua=" + eua
				+ ", ipm=" + ipm + ", eea=" + eea + ", eec=" + eec + ", euc="
				+ euc + ", eui=" + eui + "]";
	}
	
	

}
