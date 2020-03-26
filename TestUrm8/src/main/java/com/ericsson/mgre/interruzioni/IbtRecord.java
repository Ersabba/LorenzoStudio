package com.ericsson.mgre.interruzioni;

import java.io.Serializable;

public class IbtRecord implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long idClusterCabina;
	private String codCabinaSecondaria;
	private String dataInterruzione;
	private String codiceTrasformatore;
	private String matricolaTrasformatore;
	private String codConcentratore;
	private String codInterruttore;
	private String oraInterruzione;
	private String durataInterruzione;
	private String statoInterruttore;
	private String tensione;
	private String primoSportello;
	private String formazioneCavo;
	
	public Long getIdClusterCabina() {
		return idClusterCabina;
	}
	public void setIdClusterCabina(Long idClusterCabina) {
		this.idClusterCabina = idClusterCabina;
	}
	public String getCodCabinaSecondaria() {
		return codCabinaSecondaria;
	}
	public void setCodCabinaSecondaria(String codCabinaSecondaria) {
		this.codCabinaSecondaria = codCabinaSecondaria;
	}
	public String getDataInterruzione() {
		return dataInterruzione;
	}
	public void setDataInterruzione(String dataInterruzione) {
		this.dataInterruzione = dataInterruzione;
	}
	public String getCodiceTrasformatore() {
		return codiceTrasformatore;
	}
	public void setCodiceTrasformatore(String codiceTrasformatore) {
		this.codiceTrasformatore = codiceTrasformatore;
	}
	public String getMatricolaTrasformatore() {
		return matricolaTrasformatore;
	}
	public void setMatricolaTrasformatore(String matricolaTrasformatore) {
		this.matricolaTrasformatore = matricolaTrasformatore;
	}
	public String getCodConcentratore() {
		return codConcentratore;
	}
	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}
	public String getCodInterruttore() {
		return codInterruttore;
	}
	public void setCodInterruttore(String codInterruttore) {
		this.codInterruttore = codInterruttore;
	}
	public String getOraInterruzione() {
		return oraInterruzione;
	}
	public void setOraInterruzione(String oraInterruzione) {
		this.oraInterruzione = oraInterruzione;
	}
	public String getDurataInterruzione() {
		return durataInterruzione;
	}
	public void setDurataInterruzione(String durataInterruzione) {
		this.durataInterruzione = durataInterruzione;
	}
	public String getStatoInterruttore() {
		return statoInterruttore;
	}
	public void setStatoInterruttore(String statoInterruttore) {
		this.statoInterruttore = statoInterruttore;
	}
	public String getTensione() {
		return tensione;
	}
	public void setTensione(String tensione) {
		this.tensione = tensione;
	}
	public String getPrimoSportello() {
		return primoSportello;
	}
	public void setPrimoSportello(String primoSportello) {
		this.primoSportello = primoSportello;
	}
	public String getFormazioneCavo() {
		return formazioneCavo;
	}
	public void setFormazioneCavo(String formazioneCavo) {
		this.formazioneCavo = formazioneCavo;
	}
	@Override
	public String toString() {
		return "IbtRecord [idClusterCabina=" + idClusterCabina + ", codCabinaSecondaria=" + codCabinaSecondaria + ", dataInterruzione="
				+ dataInterruzione + ", codiceTrasformatore=" + codiceTrasformatore + ", matricolaTrasformatore=" + matricolaTrasformatore
				+ ", codConcentratore=" + codConcentratore + ", codInterruttore=" + codInterruttore + ", oraInterruzione=" + oraInterruzione
				+ ", durataInterruzione=" + durataInterruzione + ", statoInterruttore=" + statoInterruttore + ", tensione=" + tensione
				+ ", primoSportello=" + primoSportello + ", formazioneCavo=" + formazioneCavo + "]";
	}
}
