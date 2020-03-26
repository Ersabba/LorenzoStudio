package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ericsson.urm.db.MgdbDto;


public class TotReattAss implements java.io.Serializable, MgdbDto {
	
	private static final long serialVersionUID = 1L;
	
	private String matricolaLenntCliente;
	private Date dataRil;
	private String esito;	
	private Long reattIndAss;
	private Long reattIndAssT1;
	private Long reattIndAssT2;
	private Long reattIndAssT3;
	private Long reattIndAssT4;	
	private Long reattCapAss=null;
	private String provenienza=null;
	private Date dataAcq;	
	private String codConcentratore;
	
	public Object clone() {
		try {
			TotReattAss ret = (TotReattAss) super.clone();
			if (dataRil != null) {
				ret.dataRil = (Date) dataRil.clone();
			}
			if (dataAcq != null)
				ret.dataAcq = (Date) dataAcq.clone();
			return ret;
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	public void applyAllProperties(MgdbDto srcDto) {
		TotReattAss other = (TotReattAss)srcDto;
		if (other.dataRil != null)
			this.dataRil = (Date)other.dataRil.clone();
		else
			this.dataRil = null;
		
		if (other.dataAcq != null)
			this.dataAcq = (Date)other.dataAcq.clone();
		else
			this.dataAcq = null;

		this.matricolaLenntCliente = other.matricolaLenntCliente;
		this.esito = other.esito;
		this.reattIndAss = other.reattIndAss;
		this.reattIndAssT1 = other.reattIndAssT1;
		this.reattIndAssT2 = other.reattIndAssT2;
		this.reattIndAssT3 = other.reattIndAssT3;
		this.reattIndAssT4 = other.reattIndAssT4;
		this.reattCapAss = other.reattCapAss;
		this.provenienza = other.provenienza;
		this.codConcentratore = other.codConcentratore;
	}
	
	public Serializable retrievePrimaryKey() {
		return getMatricolaLenntCliente();
	}
	
	public TotReattAss(){
		
	}
	
	public TotReattAss(String matricolaLenntCliente){
		this.matricolaLenntCliente = matricolaLenntCliente;
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

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public Long getReattIndAss() {
		return reattIndAss;
	}

	public void setReattIndAss(Long reattIndAss) {
		this.reattIndAss = reattIndAss;
	}

	public Long getReattIndAssT1() {
		return reattIndAssT1;
	}

	public void setReattIndAssT1(Long reattIndAssT1) {
		this.reattIndAssT1 = reattIndAssT1;
	}

	public Long getReattIndAssT2() {
		return reattIndAssT2;
	}

	public void setReattIndAssT2(Long reattIndAssT2) {
		this.reattIndAssT2 = reattIndAssT2;
	}

	public Long getReattIndAssT3() {
		return reattIndAssT3;
	}

	public void setReattIndAssT3(Long reattIndAssT3) {
		this.reattIndAssT3 = reattIndAssT3;
	}

	public Long getReattIndAssT4() {
		return reattIndAssT4;
	}

	public void setReattIndAssT4(Long reattIndAssT4) {
		this.reattIndAssT4 = reattIndAssT4;
	}

	public Long getReattCapAss() {
		return reattCapAss;
	}

	public void setReattCapAss(Long reattCapAss) {
		this.reattCapAss = reattCapAss;
	}
	
	public String getDataRilToString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		
		return sdf.format(dataRil);
	}

	public String getProvenienza() {
		return provenienza;
	}

	public void setProvenienza(String provenienza) {
		this.provenienza = provenienza;
	}

	public Date getDataAcq() {
		return dataAcq;
	}

	public void setDataAcq(Date dataAcq) {
		this.dataAcq = dataAcq;
	}

	public String getCodConcentratore() {
		return codConcentratore;
	}

	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}

	@Override
	public String toString() {
		return "TotReattAss [matricolaLenntCliente=" + matricolaLenntCliente
				+ ", dataRil=" + dataRil + ", esito=" + esito
				+ ", reattIndAss=" + reattIndAss + ", reattIndAssT1="
				+ reattIndAssT1 + ", reattIndAssT2=" + reattIndAssT2
				+ ", reattIndAssT3=" + reattIndAssT3 + ", reattIndAssT4="
				+ reattIndAssT4 + ", reattCapAss=" + reattCapAss
				+ ", provenienza=" + provenienza + ", dataAcq=" + dataAcq
				+ ", codConcentratore=" + codConcentratore + "]";
	}
	
}