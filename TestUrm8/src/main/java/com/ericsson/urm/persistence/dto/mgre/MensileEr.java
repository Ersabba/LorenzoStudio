package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.db.MgdbDto;


public class MensileEr implements java.io.Serializable, MgdbDto {
	
	private static final long serialVersionUID = 1L;
	
	private MensileErId id=null;
	private String esito;	
	private java.util.Date dataRil=null;
	private Long attEr;
	private Long attErT1;
	private Long attErT2;
	private Long attErT3;
	private Long attErT4;	
	private Long reattIndEr=null;
	private Long reattCapEr=null;
	private String codConcentratore=null;
	private Date dataAcquisizione=null;
	String provenienza;
	
	public Object clone() {
		try {
			MensileEr ret = (MensileEr) super.clone();
			if (id != null)
				ret.id = (MensileErId) id.clone();
			if (dataRil != null)
				ret.dataRil = (Date) dataRil.clone();
			if (dataAcquisizione != null)
				ret.dataAcquisizione = (Date) dataAcquisizione.clone();
			return ret;
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	public void applyAllProperties(MgdbDto srcDto) {
		MensileEr other = (MensileEr)srcDto;
		if (other.id != null)
			this.id = (MensileErId)other.id.clone();
		else
			this.id = null;
		this.esito = other.esito;
		this.dataRil = other.dataRil;
		this.attEr = other.attEr;
		this.attErT1 = other.attErT1;
		this.attErT2 = other.attErT2;
		this.attErT3 = other.attErT3;
		this.attErT4 = other.attErT4;
		this.reattIndEr = other.reattIndEr;
		this.reattCapEr = other.reattCapEr;
		this.codConcentratore = other.codConcentratore;
		this.dataAcquisizione = other.dataAcquisizione;
	}
	
	public Serializable retrievePrimaryKey() {
		return getId();
	}
	
	public String getCodConcentratore() {
		return codConcentratore;
	}

	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}

	public java.util.Date getDataRil() {
		return dataRil;
	}

	public void setDataRil(java.util.Date dataRil) {
		this.dataRil = dataRil;
	}

	public Long getReattIndEr() {
		return reattIndEr;
	}

	public void setReattIndEr(Long reattIndEr) {
		this.reattIndEr = reattIndEr;
	}

	public Long getReattCapEr() {
		return reattCapEr;
	}

	public void setReattCapEr(Long reattCapEr) {
		this.reattCapEr = reattCapEr;
	}

	public MensileEr(){
		
	}
		
	public MensileErId getId() {
		return id;
	}

	public void setId(MensileErId id) {
		this.id = id;
	}

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public Long getAttEr() {
		return attEr;
	}

	public void setAttEr(Long attEr) {
		this.attEr = attEr;
	}

	public Long getAttErT1() {
		return attErT1;
	}

	public void setAttErT1(Long attErT1) {
		this.attErT1 = attErT1;
	}

	public Long getAttErT2() {
		return attErT2;
	}

	public void setAttErT2(Long attErT2) {
		this.attErT2 = attErT2;
	}

	public Long getAttErT3() {
		return attErT3;
	}

	public void setAttErT3(Long attErT3) {
		this.attErT3 = attErT3;
	}

	public Long getAttErT4() {
		return attErT4;
	}

	public void setAttErT4(Long attErT4) {
		this.attErT4 = attErT4;
	}

	public Date getDataAcquisizione() {
		return dataAcquisizione;
	}

	public void setDataAcquisizione(Date dataAcquisizione) {
		this.dataAcquisizione = dataAcquisizione;
	}

	public String getProvenienza() {
		return provenienza;
	}

	public void setProvenienza(String provenienza) {
		this.provenienza = provenienza;
	}

	@Override
	public String toString() {
		return "MensileEr [id=" + id + ", esito=" + esito + ", dataRil="
				+ dataRil + ", attEr=" + attEr + ", attErT1=" + attErT1
				+ ", attErT2=" + attErT2 + ", attErT3=" + attErT3
				+ ", attErT4=" + attErT4 + ", reattIndEr=" + reattIndEr
				+ ", reattCapEr=" + reattCapEr + ", codConcentratore="
				+ codConcentratore + ", dataAcquisizione=" + dataAcquisizione
				+ ", provenienza=" + provenienza + "]";
	}



	

		
}