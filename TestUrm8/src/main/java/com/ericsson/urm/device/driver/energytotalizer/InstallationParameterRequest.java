package com.ericsson.urm.device.driver.energytotalizer;

import java.io.Serializable;

public class InstallationParameterRequest implements Serializable {
	
	
	private static final long serialVersionUID = -1L;
	private String numeroPresa = null;
	private String tipoInstallazione = null;
	private String tipoUtente = null;
	
	public String getNumeroPresa() {
		return numeroPresa;
	}
	public void setNumeroPresa(String numeroPresa) {
		this.numeroPresa = numeroPresa;
	}
	public String getTipoInstallazione() {
		return tipoInstallazione;
	}
	public void setTipoInstallazione(String tipoInstallazione) {
		this.tipoInstallazione = tipoInstallazione;
	}
	public String getTipoUtente() {
		return tipoUtente;
	}
	public void setTipoUtente(String tipoUtente) {
		this.tipoUtente = tipoUtente;
	}
		

}
