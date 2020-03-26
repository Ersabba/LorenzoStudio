package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.db.MgdbDto;

public class MensileAttAssFraz implements java.io.Serializable, MgdbDto {
	
	private static final long serialVersionUID = 1L;
	
	private MensileAttAssFrazId id=null;
	private Long attAssFraz;

	private java.util.Date dataRil=null;
	private Long attAssT1Fraz;
	private Long attAssT2Fraz;
	private Long attAssT3Fraz;
	private Long attAssT4Fraz;
	private Date dataAcquisizione=null;
	private String codConcentratore=null;
	private String esito;
	
	public MensileAttAssFraz(){
		
	}
	
	public Object clone() {
		try {
			MensileAttAssFraz ret = (MensileAttAssFraz) super.clone();
			if (id != null)
				ret.id = (MensileAttAssFrazId) id.clone();
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
		MensileAttAssFraz other = (MensileAttAssFraz)srcDto;
		if (other.id != null)
			this.id = (MensileAttAssFrazId)other.id.clone();
		else
			other.id = null;
		this.attAssFraz = other.attAssFraz;
	
		this.dataRil = other.dataRil;
		this.attAssT1Fraz = other.attAssT1Fraz;
		this.attAssT2Fraz = other.attAssT2Fraz;
		this.attAssT3Fraz = other.attAssT3Fraz;
		this.attAssT4Fraz = other.attAssT4Fraz;
		this.dataAcquisizione = other.dataAcquisizione;
		this.esito = other.esito;
		this.codConcentratore = other.codConcentratore;
		
	}
	
	public Serializable retrievePrimaryKey() {
		return getId();
	}
	
	public MensileAttAssFraz(MensileAttAssFrazId id){
		this.id=id;
	}

	public MensileAttAssFrazId getId() {
		return id;
	}

	public void setId(MensileAttAssFrazId id) {
		this.id = id;
	}

	
	public java.util.Date getDataRil() {
		return dataRil;
	}

	public void setDataRil(java.util.Date dataRil) {
		this.dataRil = dataRil;
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

	public Date getDataAcquisizione() {
		return dataAcquisizione;
	}

	public void setDataAcquisizione(Date dataAcquisizione) {
		this.dataAcquisizione = dataAcquisizione;
	}

 	public String getCodConcentratore() {
		return codConcentratore;
	}

	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}
 
  	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	@Override
	public String toString() {
		return "MensileAttAssFraz [id=" + id + ", attAssFraz=" + attAssFraz + ", dataRil=" + dataRil + ", attAssT1Fraz="
				+ attAssT1Fraz + ", attAssT2Fraz=" + attAssT2Fraz + ", attAssT3Fraz=" + attAssT3Fraz + ", attAssT4Fraz="
				+ attAssT4Fraz + ", dataAcquisizione=" + dataAcquisizione + ", codConcentratore=" + codConcentratore
				+ ", esito=" + esito + "]";
	}
}