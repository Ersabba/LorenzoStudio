package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.db.MgdbDto;


public class MensileReattAssFraz implements java.io.Serializable, MgdbDto {
	
	private static final long serialVersionUID = 1L;
	
	private MensileReattAssFrazId id=null;
	private java.util.Date dataRil=null;
	private String esito;	
	private Long reattIndAssFraz;
	private Long reattIndAssT1Fraz;
	private Long reattIndAssT2Fraz;
	private Long reattIndAssT3Fraz;
	private Long reattIndAssT4Fraz;	
	private Long reattCapAssFraz=null;
	private String codConcentratore=null;
	private Date dataAcquisizione=null;
	
	public Object clone() {
		try {
			MensileReattAssFraz ret = (MensileReattAssFraz) super.clone();
			if (id != null)
				ret.id = (MensileReattAssFrazId) id.clone();
			if (dataRil != null)
				ret.dataRil = (Date) dataRil.clone();
			if (dataAcquisizione != null)
				ret.dataAcquisizione = (Date) dataAcquisizione;
			return ret;
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	public void applyAllProperties(MgdbDto srcDto) {
		MensileReattAssFraz other = (MensileReattAssFraz)srcDto;
		if (other.id != null)
			this.id = (MensileReattAssFrazId)other.id.clone();
		else
			this.id = null;

		this.dataRil = other.dataRil;
		this.esito = other.esito;
		this.reattIndAssFraz = other.reattIndAssFraz;
		this.reattIndAssT1Fraz = other.reattIndAssT1Fraz;
		this.reattIndAssT2Fraz = other.reattIndAssT2Fraz;
		this.reattIndAssT3Fraz = other.reattIndAssT3Fraz;
		this.reattIndAssT4Fraz = other.reattIndAssT4Fraz;
		this.reattCapAssFraz = other.reattCapAssFraz;
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

	public MensileReattAssFraz(){
		
	}
	
	public MensileReattAssFraz(MensileReattAssFrazId id){
		this.id=id;
	}

	public MensileReattAssFrazId getId() {
		return id;
	}

	public void setId(MensileReattAssFrazId id) {
		this.id = id;
	}

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public java.util.Date getDataRil() {
		return dataRil;
	}

	public void setDataRil(java.util.Date dataRil) {
		this.dataRil = dataRil;
	}
	
	public Date getDataAcquisizione() {
		return dataAcquisizione;
	}

	public void setDataAcquisizione(Date dataAcquisizione) {
		this.dataAcquisizione = dataAcquisizione;
	}
	
	public Long getReattIndAssFraz() {
		return reattIndAssFraz;
	}

	public void setReattIndAssFraz(Long reattIndAssFraz) {
		this.reattIndAssFraz = reattIndAssFraz;
	}

	public Long getReattIndAssT1Fraz() {
		return reattIndAssT1Fraz;
	}

	public void setReattIndAssT1Fraz(Long reattIndAssT1Fraz) {
		this.reattIndAssT1Fraz = reattIndAssT1Fraz;
	}

	public Long getReattIndAssT2Fraz() {
		return reattIndAssT2Fraz;
	}

	public void setReattIndAssT2Fraz(Long reattIndAssT2Fraz) {
		this.reattIndAssT2Fraz = reattIndAssT2Fraz;
	}

	public Long getReattIndAssT3Fraz() {
		return reattIndAssT3Fraz;
	}

	public void setReattIndAssT3Fraz(Long reattIndAssT3Fraz) {
		this.reattIndAssT3Fraz = reattIndAssT3Fraz;
	}

	public Long getReattIndAssT4Fraz() {
		return reattIndAssT4Fraz;
	}

	public void setReattIndAssT4Fraz(Long reattIndAssT4Fraz) {
		this.reattIndAssT4Fraz = reattIndAssT4Fraz;
	}

	public Long getReattCapAssFraz() {
		return reattCapAssFraz;
	}

	public void setReattCapAssFraz(Long reattCapAssFraz) {
		this.reattCapAssFraz = reattCapAssFraz;
	}

	public String toString() {
		return "MensileReattAssFraz [codConcentratore=" + codConcentratore
				+ ", dataAcquisizione=" + dataAcquisizione + ", dataRil="
				+ dataRil + ", esito=" + esito + ", id=" + id
				+ ", reattCapAssFraz=" + reattCapAssFraz + ", reattIndAssFraz="
				+ reattIndAssFraz + ", reattIndAssT1Fraz=" + reattIndAssT1Fraz
				+ ", reattIndAssT2Fraz=" + reattIndAssT2Fraz + ", reattIndAssT3Fraz="
				+ reattIndAssT3Fraz + ", reattIndAssT4Fraz=" + reattIndAssT4Fraz + "]";
	}
	
}