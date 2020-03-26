package com.ericsson.mgre.biz.networkMgmt.element;

import java.io.Serializable;

public class TrasformatoreDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private long codTrasformatore;
	private String codCabinaSecondaria;
	private String idRelCabinaSecondaria;
	private String tensioneMTIngresso;
	private String tensioneUscita;
	private int potenzaTrasformatore;
	private String marcaTrasformatore;
	private String matricolaTrasformatore;
	private long numSbarre;
	private long numSbarreGuaste;
	private String statoGuasto;

	public TrasformatoreDTO() {
		super();
	}
	
	public long getCodTrasformatore() {
		return codTrasformatore;
	}
	public void setCodTrasformatore(long codTrasformatore) {
		this.codTrasformatore = codTrasformatore;
	}
	public String getCodCabinaSecondaria() {
		return codCabinaSecondaria;
	}
	public void setCodCabinaSecondaria(String codCabinaSecondaria) {
		this.codCabinaSecondaria = codCabinaSecondaria;
	}
	public String getIdRelCabinaSecondaria() {
		return idRelCabinaSecondaria;
	}
	public void setIdRelCabinaSecondaria(String idRelCabinaSecondaria) {
		this.idRelCabinaSecondaria = idRelCabinaSecondaria;
	}
	public String getTensioneMTIngresso() {
		return tensioneMTIngresso;
	}
	public void setTensioneMTIngresso(String tensioneMTIngresso) {
		this.tensioneMTIngresso = tensioneMTIngresso;
	}
	public String getTensioneUscita() {
		return tensioneUscita;
	}
	public void setTensioneUscita(String tensioneUscita) {
		this.tensioneUscita = tensioneUscita;
	}
	public int getPotenzaTrasformatore() {
		return potenzaTrasformatore;
	}
	public void setPotenzaTrasformatore(int potenzaTrasformatore) {
		this.potenzaTrasformatore = potenzaTrasformatore;
	}
	public String getMarcaTrasformatore() {
		return marcaTrasformatore;
	}
	public void setMarcaTrasformatore(String marcaTrasformatore) {
		this.marcaTrasformatore = marcaTrasformatore;
	}
	public String getMatricolaTrasformatore() {
		return matricolaTrasformatore;
	}
	public void setMatricolaTrasformatore(String matricolaTrasformatore) {
		this.matricolaTrasformatore = matricolaTrasformatore;
	}
	public long getNumSbarre() {
		return numSbarre;
	}
	public void setNumSbarre(long numSbarre) {
		this.numSbarre = numSbarre;
	}
	public long getNumSbarreGuaste() {
		return numSbarreGuaste;
	}
	public void setNumSbarreGuaste(long numSbarreGuaste) {
		this.numSbarreGuaste = numSbarreGuaste;
	}
	public String getStatoGuasto() {
		return statoGuasto;
	}
	public void setStatoGuasto(String statoGuasto) {
		this.statoGuasto = statoGuasto;
	}
	
	@Override
	public String toString() {
		return "TrasformatoreDTO [codTrasformatore=" + codTrasformatore + ", codCabinaSecondaria=" + codCabinaSecondaria
				+ ", idRelCabinaSecondaria=" + idRelCabinaSecondaria + ", tensioneMTIngresso=" + tensioneMTIngresso
				+ ", tensioneUscita=" + tensioneUscita + ", potenzaTrasformatore=" + potenzaTrasformatore
				+ ", marcaTrasformatore=" + marcaTrasformatore + ", matricolaTrasformatore=" + matricolaTrasformatore
				+ ", numSbarre=" + numSbarre + ", numSbarreGuaste=" + numSbarreGuaste + ", statoGuasto=" + statoGuasto
				+ "]";
	}
}