package com.ericsson.mgre.biz.networkMgmt.element;

import java.io.Serializable;

public class CabSecondariaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codCabinaSecondaria;
	private String nomeCabina;
	private String codDensita;
	private String codZona;
	private String indirizzoCabina;
	private String note;
	private String statoGuasto;

	public CabSecondariaDTO() {
		super();
	}
	
	public String getCodCabinaSecondaria() {
		return codCabinaSecondaria;
	}
	public void setCodCabinaSecondaria(String codCabinaSecondaria) {
		this.codCabinaSecondaria = codCabinaSecondaria;
	}
	public String getNomeCabina() {
		return nomeCabina;
	}
	public void setNomeCabina(String nomeCabina) {
		this.nomeCabina = nomeCabina;
	}
	public String getCodDensita() {
		return codDensita;
	}
	public void setCodDensita(String codDensita) {
		this.codDensita = codDensita;
	}
	public String getCodZona() {
		return codZona;
	}
	public void setCodZona(String codZona) {
		this.codZona = codZona;
	}
	public String getIndirizzoCabina() {
		return indirizzoCabina;
	}
	public void setIndirizzoCabina(String indirizzoCabina) {
		this.indirizzoCabina = indirizzoCabina;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getStatoGuasto() {
		return statoGuasto;
	}
	public void setStatoGuasto(String statoGuasto) {
		this.statoGuasto = statoGuasto;
	}
	
	@Override
	public String toString() {
		return "CabSecondariaDTO [codCabinaSecondaria=" + codCabinaSecondaria + ", nomeCabina=" + nomeCabina
				+ ", codDensita=" + codDensita + ", codZona=" + codZona + ", indirizzoCabina=" + indirizzoCabina
				+ ", note=" + note + ", statoGuasto=" + statoGuasto + "]";
	}
}