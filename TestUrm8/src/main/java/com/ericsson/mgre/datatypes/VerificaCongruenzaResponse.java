package com.ericsson.mgre.datatypes;

import java.io.Serializable;
import java.util.Date;

public class VerificaCongruenzaResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public VerificaCongruenzaResponse(String matricolaLennt,
			String codConcentratore, String cp1, String cp2, String cp3, String cp4,
			String gu, Date dataAttivazione, Date dataScadenza) {
		super();
		this.matricolaLennt = matricolaLennt;
		this.codConcentratore = codConcentratore;
		this.cp1 = cp1;
		this.cp2 = cp2;
		this.cp3 = cp3;
		this.cp4 = cp4;
		this.gu = gu;
		this.dataAttivazione = dataAttivazione;
		this.dataScadenza = dataScadenza;
	}
	
	private String matricolaLennt=null;
	private String codConcentratore=null;
	private Date dataAcq=null;
	private Long listaAzioni=null;	
	private String cp1=null;
	private String cp2=null;
	private String cp3=null;
	private String cp4=null;
	private Long par=null;
	private String ip=null;
	private String gu=null;
	private String k1=null;
	private String k2=null;
	private Date dataAttivazione=null;
	private Date dataScadenza=null;
	public String getMatricolaLennt() {
		return matricolaLennt;
	}
	public void setMatricolaLennt(String matricolaLennt) {
		this.matricolaLennt = matricolaLennt;
	}
	public String getCodConcentratore() {
		return codConcentratore;
	}
	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}
	public Date getDataAcq() {
		return dataAcq;
	}
	public void setDataAcq(Date dataAcq) {
		this.dataAcq = dataAcq;
	}
	public Long getListaAzioni() {
		return listaAzioni;
	}
	public void setListaAzioni(Long listaAzioni) {
		this.listaAzioni = listaAzioni;
	}
	public String getCp1() {
		return cp1;
	}
	public void setCp1(String cp1) {
		this.cp1 = cp1;
	}
	public String getCp2() {
		return cp2;
	}
	public void setCp2(String cp2) {
		this.cp2 = cp2;
	}
	public String getCp3() {
		return cp3;
	}
	public void setCp3(String cp3) {
		this.cp3 = cp3;
	}
	public String getCp4() {
		return cp4;
	}
	public void setCp4(String cp4) {
		this.cp4 = cp4;
	}
	public Long getPar() {
		return par;
	}
	public void setPar(Long par) {
		this.par = par;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getGu() {
		return gu;
	}
	public void setGu(String gu) {
		this.gu = gu;
	}
	public String getK1() {
		return k1;
	}
	public void setK1(String k1) {
		this.k1 = k1;
	}
	public String getK2() {
		return k2;
	}
	public void setK2(String k2) {
		this.k2 = k2;
	}
	public Date getDataAttivazione() {
		return dataAttivazione;
	}
	public void setDataAttivazione(Date dataAttivazione) {
		this.dataAttivazione = dataAttivazione;
	}
	public Date getDataScadenza() {
		return dataScadenza;
	}
	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	

}
