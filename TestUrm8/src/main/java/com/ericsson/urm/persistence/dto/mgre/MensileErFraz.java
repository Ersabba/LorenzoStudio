package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.db.MgdbDto;


public class MensileErFraz implements java.io.Serializable, MgdbDto {
	
	private static final long serialVersionUID = 1L;
	
	private MensileErFrazId id=null;
	private String esito;	
	private java.util.Date dataRil=null;
	private Long attErFraz;
	private Long attErT1Fraz;
	private Long attErT2Fraz;
	private Long attErT3Fraz;
	private Long attErT4Fraz;	
	private Long reattIndErFraz=null;
	private Long reattCapErFraz=null;
	private String codConcentratore=null;
	private Date dataAcquisizione=null;
	
	public Object clone() {
		try {
			MensileErFraz ret = (MensileErFraz) super.clone();
			if (id != null)
				ret.id = (MensileErFrazId) id.clone();
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
		MensileErFraz other = (MensileErFraz)srcDto;
		if (other.id != null)
			this.id = (MensileErFrazId)other.id.clone();
		else
			this.id = null;
		this.esito = other.esito;
		this.dataRil = other.dataRil;
		this.attErFraz = other.attErFraz;
		this.attErT1Fraz = other.attErT1Fraz;
		this.attErT2Fraz = other.attErT2Fraz;
		this.attErT3Fraz = other.attErT3Fraz;
		this.attErT4Fraz = other.attErT4Fraz;
		this.reattIndErFraz = other.reattIndErFraz;
		this.reattCapErFraz = other.reattCapErFraz;
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

	public Long getReattIndErFraz() {
		return reattIndErFraz;
	}

	public void setReattIndErFraz(Long reattIndErFraz) {
		this.reattIndErFraz = reattIndErFraz;
	}

	public Long getReattCapErFraz() {
		return reattCapErFraz;
	}

	public void setReattCapErFraz(Long reattCapErFraz) {
		this.reattCapErFraz = reattCapErFraz;
	}

	public MensileErFraz(){
		
	}
	
	public MensileErFraz(MensileErFrazId id){
			this.setId(id);
	}
		
	public MensileErFrazId getId() {
		return id;
	}

	public void setId(MensileErFrazId id) {
		this.id = id;
	}

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public Long getAttErFraz() {
		return attErFraz;
	}

	public void setAttErFraz(Long attErFraz) {
		this.attErFraz = attErFraz;
	}

	public Long getAttErT1Fraz() {
		return attErT1Fraz;
	}

	public void setAttErT1Fraz(Long attErT1Fraz) {
		this.attErT1Fraz = attErT1Fraz;
	}

	public Long getAttErT2Fraz() {
		return attErT2Fraz;
	}

	public void setAttErT2Fraz(Long attErT2Fraz) {
		this.attErT2Fraz = attErT2Fraz;
	}

	public Long getAttErT3Fraz() {
		return attErT3Fraz;
	}

	public void setAttErT3Fraz(Long attErT3Fraz) {
		this.attErT3Fraz = attErT3Fraz;
	}

	public Long getAttErT4Fraz() {
		return attErT4Fraz;
	}

	public void setAttErT4Fraz(Long attErT4Fraz) {
		this.attErT4Fraz = attErT4Fraz;
	}

	public Date getDataAcquisizione() {
		return dataAcquisizione;
	}

	public void setDataAcquisizione(Date dataAcquisizione) {
		this.dataAcquisizione = dataAcquisizione;
	}

	public String toString() {
		return "MensileErFraz [attErFraz=" + attErFraz + ", attErT1Fraz=" + attErT1Fraz + ", attErT2Fraz=" + attErT2Fraz + ", attErT3Fraz=" + attErT3Fraz
				+ ", attErT4Fraz=" + attErT4Fraz + ", codConcentratore=" + codConcentratore + ", dataAcquisizione=" + dataAcquisizione
				+ ", dataRil=" + dataRil + ", esito=" + esito + ", id=" + id + ", reattCapErFraz=" + reattCapErFraz + ", reattIndErFraz="
				+ reattIndErFraz + "]";
	}

	

		
}