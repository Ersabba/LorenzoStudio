package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.db.MgdbDto;


public class MensileReattAss implements java.io.Serializable, MgdbDto {
	
	private static final long serialVersionUID = 1L;
	
	private MensileReattAssId id=null;
	private java.util.Date dataRil=null;
	private String esito;	
	private Long reattIndAss;
	private Long reattIndAssT1;
	private Long reattIndAssT2;
	private Long reattIndAssT3;
	private Long reattIndAssT4;	
	private Long reattCapAss=null;
	private String codConcentratore=null;
	private Date dataAcquisizione=null;
	String provenienza;
	
	public Object clone() {
		try {
			MensileReattAss ret = (MensileReattAss) super.clone();
			if (id != null)
				ret.id = (MensileReattAssId) id.clone();
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
		MensileReattAss other = (MensileReattAss)srcDto;
		if (other.id != null)
			this.id = (MensileReattAssId)other.id.clone();
		else
			this.id = null;

		this.dataRil = other.dataRil;
		this.esito = other.esito;
		this.reattIndAss = other.reattIndAss;
		this.reattIndAssT1 = other.reattIndAssT1;
		this.reattIndAssT2 = other.reattIndAssT2;
		this.reattIndAssT3 = other.reattIndAssT3;
		this.reattIndAssT4 = other.reattIndAssT4;
		this.reattCapAss = other.reattCapAss;
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

	public MensileReattAss(){
		
	}
	
	public MensileReattAss(MensileReattAssId id){
		this.id=id;
	}

	public MensileReattAssId getId() {
		return id;
	}

	public void setId(MensileReattAssId id) {
		this.id = id;
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
	

	public java.util.Date getDataRil() {
		return dataRil;
	}

	public void setDataRil(java.util.Date dataRil) {
		this.dataRil = dataRil;
	}

	public Long getReattCapAss() {
		return reattCapAss;
	}

	public void setReattCapAss(Long reattCapAss) {
		this.reattCapAss = reattCapAss;
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
		return "MensileReattAss [id=" + id + ", dataRil=" + dataRil
				+ ", esito=" + esito + ", reattIndAss=" + reattIndAss
				+ ", reattIndAssT1=" + reattIndAssT1 + ", reattIndAssT2="
				+ reattIndAssT2 + ", reattIndAssT3=" + reattIndAssT3
				+ ", reattIndAssT4=" + reattIndAssT4 + ", reattCapAss="
				+ reattCapAss + ", codConcentratore=" + codConcentratore
				+ ", dataAcquisizione=" + dataAcquisizione + ", provenienza="
				+ provenienza + "]";
	}

	
	
}