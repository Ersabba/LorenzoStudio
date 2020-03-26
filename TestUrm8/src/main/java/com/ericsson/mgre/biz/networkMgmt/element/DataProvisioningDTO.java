package com.ericsson.mgre.biz.networkMgmt.element;

import java.io.Serializable;
import java.util.Date;

public class DataProvisioningDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	/* GIS_PROVISIONING */
	private Long idES;
	private String codCabina;
	private String codConcentratore;
	private Date dataInstallazione;
	private Date dataAttivazione;
	private String flagSospesi;
	private String statoConcentratore;
	private String zonaUrbanistica;
	private String indirizzoCompleto;
	
	public Long getIdES() {
		return idES;
	}
	public void setIdES(Long idES) {
		this.idES = idES;
	}
	public String getCodCabina() {
		return codCabina;
	}
	public void setCodCabina(String codCabina) {
		this.codCabina = codCabina;
	}
	public String getCodConcentratore() {
		return codConcentratore;
	}
	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}
	public Date getDataInstallazione() {
		return dataInstallazione;
	}
	public void setDataInstallazione(Date dataInstallazione) {
		this.dataInstallazione = dataInstallazione;
	}
	public Date getDataAttivazione() {
		return dataAttivazione;
	}
	public void setDataAttivazione(Date dataAttivazione) {
		this.dataAttivazione = dataAttivazione;
	}
	public String getFlagSospesi() {
		return flagSospesi;
	}
	public void setFlagSospesi(String flagSospesi) {
		this.flagSospesi = flagSospesi;
	}
	public String getStatoConcentratore() {
		return statoConcentratore;
	}
	public void setStatoConcentratore(String statoConcentratore) {
		this.statoConcentratore = statoConcentratore;
	}
	public String getZonaUrbanistica() {
		return zonaUrbanistica;
	}
	public void setZonaUrbanistica(String zonaUrbanistica) {
		this.zonaUrbanistica = zonaUrbanistica;
	}
	public String getIndirizzoCompleto() {
		return indirizzoCompleto;
	}
	public void setIndirizzoCompleto(String indirizzoCompleto) {
		this.indirizzoCompleto = indirizzoCompleto;
	}
	
	@Override
	public String toString() {
		return "DataProvisioningDTO [idES=" + idES + ", codCabina=" + codCabina + ", codConcentratore="
				+ codConcentratore + ", dataInstallazione=" + dataInstallazione + ", dataAttivazione=" + dataAttivazione
				+ ", flagSospesi=" + flagSospesi + ", statoConcentratore=" + statoConcentratore + ", zonaUrbanistica="
				+ zonaUrbanistica + ", indirizzoCompleto=" + indirizzoCompleto + "]";
	}
}