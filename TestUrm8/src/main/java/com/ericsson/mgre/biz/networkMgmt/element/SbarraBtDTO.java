package com.ericsson.mgre.biz.networkMgmt.element;

import java.io.Serializable;

public class SbarraBtDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private long codSbarraBT;
	private String codConcentratore;
	private String tensioneSbarra;
	private String idRelTrasformatore;
	private String statoGuasto;
	private long numLinee;
	private long numLineeGuaste;
	private long codTrasformatore;
	
	public SbarraBtDTO() {
		super();
	}
	
	public long getCodSbarraBT() {
		return codSbarraBT;
	}
	public void setCodSbarraBT(long codSbarraBT) {
		this.codSbarraBT = codSbarraBT;
	}
	public String getCodConcentratore() {
		return codConcentratore;
	}
	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}
	public String getTensioneSbarra() {
		return tensioneSbarra;
	}
	public void setTensioneSbarra(String tensioneSbarra) {
		this.tensioneSbarra = tensioneSbarra;
	}
	public String getIdRelTrasformatore() {
		return idRelTrasformatore;
	}
	public void setIdRelTrasformatore(String idRelTrasformatore) {
		this.idRelTrasformatore = idRelTrasformatore;
	}
	public String getStatoGuasto() {
		return statoGuasto;
	}
	public void setStatoGuasto(String statoGuasto) {
		this.statoGuasto = statoGuasto;
	}
	public long getNumLinee() {
		return numLinee;
	}
	public void setNumLinee(long numLinee) {
		this.numLinee = numLinee;
	}
	public long getNumLineeGuaste() {
		return numLineeGuaste;
	}
	public void setNumLineeGuaste(long numLineeGuaste) {
		this.numLineeGuaste = numLineeGuaste;
	}
	public long getCodTrasformatore() {
		return codTrasformatore;
	}
	public void setCodTrasformatore(long codTrasformatore) {
		this.codTrasformatore = codTrasformatore;
	}
	
	@Override
	public String toString() {
		return "SbarraBtDTO [codSbarraBT=" + codSbarraBT + ", codConcentratore=" + codConcentratore
				+ ", tensioneSbarra=" + tensioneSbarra + ", idRelTrasformatore=" + idRelTrasformatore + ", statoGuasto="
				+ statoGuasto + ", numLinee=" + numLinee + ", numLineeGuaste=" + numLineeGuaste + ", codTrasformatore="
				+ codTrasformatore + "]";
	}
}