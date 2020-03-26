package com.ericsson.urm.persistence.dto.mgre;

import java.util.Date;

public class StoricoTotAttAssCompleto implements java.io.Serializable{

//private static final long serialVersionUID = 1L;
	
	private Long attAss;
	private String esito;
	private Long attAssT1;
	private Long attAssT2;
	private Long attAssT3;
	private Long attAssT4;
	private String codConcentratore;
	private Long attAssFraz;
	private Long attAssT1Fraz;
	private Long attAssT2Fraz;
	private Long attAssT3Fraz;
	private Long attAssT4Fraz;
	
	private String matricolaLenntCliente;
	private Date dataRil;
	
	public StoricoTotAttAssCompleto(){
	
	}
	
	public StoricoTotAttAssCompleto(StorTotAttAss totAttass, FrazStorTotAttAss frazTotAttAss){
		if(totAttass!=null) 
		{
			this.matricolaLenntCliente = totAttass.getMatricolaLenntCliente();
			this.dataRil = totAttass.getDataRil();
			this.attAss = totAttass.getAttAss();
			this.attAssT1 = totAttass.getAttAssT1();
			this.attAssT2 = totAttass.getAttAssT2();
			this.attAssT3 = totAttass.getAttAssT3();
			this.attAssT4 = totAttass.getAttAssT4();
			this.codConcentratore = totAttass.getCodConcentratore();
			this.esito = totAttass.getEsito();
			
			if(frazTotAttAss!=null) {
				this.attAssFraz = frazTotAttAss.getAttAssFraz();
				this.attAssT1Fraz = frazTotAttAss.getAttAssT1Fraz();
				this.attAssT2Fraz = frazTotAttAss.getAttAssT2Fraz();
				this.attAssT3Fraz = frazTotAttAss.getAttAssT3Fraz();
				this.attAssT4Fraz = frazTotAttAss.getAttAssT4Fraz();
			}
		}
		
	}

	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}

	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}

	public Date getDataRil() {
		return dataRil;
	}

	public void setDataRil(Date dataRil) {
		this.dataRil = dataRil;
	}

	public Long getAttAss() {
		return attAss;
	}

	public void setAttAss(Long attAss) {
		this.attAss = attAss;
	}

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public Long getAttAssT1() {
		return attAssT1;
	}

	public void setAttAssT1(Long attAssT1) {
		this.attAssT1 = attAssT1;
	}

	public Long getAttAssT2() {
		return attAssT2;
	}

	public void setAttAssT2(Long attAssT2) {
		this.attAssT2 = attAssT2;
	}

	public Long getAttAssT3() {
		return attAssT3;
	}

	public void setAttAssT3(Long attAssT3) {
		this.attAssT3 = attAssT3;
	}

	public Long getAttAssT4() {
		return attAssT4;
	}

	public void setAttAssT4(Long attAssT4) {
		this.attAssT4 = attAssT4;
	}

	public String getCodConcentratore() {
		return codConcentratore;
	}

	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}

	public Long getAttAssFraz() {
		return attAssFraz;
	}

	public void setAttAssFraz(Long attAssFraz) {
		this.attAssFraz = attAssFraz;
	}

	public Long getAttAssT1Fraz() {
		return attAssT1Fraz;
	}

	public void setAttAssT1Fraz(Long attAssT1Fraz) {
		this.attAssT1Fraz = attAssT1Fraz;
	}

	public Long getAttAssT2Fraz() {
		return attAssT2Fraz;
	}

	public void setAttAssT2Fraz(Long attAssT2Fraz) {
		this.attAssT2Fraz = attAssT2Fraz;
	}

	public Long getAttAssT3Fraz() {
		return attAssT3Fraz;
	}

	public void setAttAssT3Fraz(Long attAssT3Fraz) {
		this.attAssT3Fraz = attAssT3Fraz;
	}

	public Long getAttAssT4Fraz() {
		return attAssT4Fraz;
	}

	public void setAttAssT4Fraz(Long attAssT4Fraz) {
		this.attAssT4Fraz = attAssT4Fraz;
	}

	@Override
	public String toString() {
		return "StoricoTotAttAssCompleto [attAss=" + attAss + ", esito="
				+ esito + ", attAssT1=" + attAssT1 + ", attAssT2=" + attAssT2
				+ ", attAssT3=" + attAssT3 + ", attAssT4=" + attAssT4
				+ ", codConcentratore=" + codConcentratore + ", attAssFraz="
				+ attAssFraz + ", attAssT1Fraz=" + attAssT1Fraz
				+ ", attAssT2Fraz=" + attAssT2Fraz + ", attAssT3Fraz="
				+ attAssT3Fraz + ", attAssT4Fraz=" + attAssT4Fraz
				+ ", matricolaLenntCliente=" + matricolaLenntCliente
				+ ", dataRil=" + dataRil + "]";
	}

	
	
}
