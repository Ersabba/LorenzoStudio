package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.db.MgdbDto;

public class MensileAttAss implements java.io.Serializable, MgdbDto {
	
	private static final long serialVersionUID = 1L;
	
	private MensileAttAssId id=null;
	private Long attAss;
	private String esito;
	private java.util.Date dataRil=null;
	private Long attAssT1;
	private Long attAssT2;
	private Long attAssT3;
	private Long attAssT4;	
	private String codConcentratore=null;
	private Date dataAcquisizione=null;
	private String provenienza;
	
	public MensileAttAss(){
		
	}
	
	public Object clone() {
		try {
			MensileAttAss ret = (MensileAttAss) super.clone();
			if (id != null)
				ret.id = (MensileAttAssId) id.clone();
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
		MensileAttAss other = (MensileAttAss)srcDto;
		if (other.id != null)
			this.id = (MensileAttAssId)other.id.clone();
		else
			other.id = null;
		this.attAss = other.attAss;
		this.esito = other.esito;
		this.dataRil = other.dataRil;
		this.attAssT1 = other.attAssT1;
		this.attAssT2 = other.attAssT2;
		this.attAssT3 = other.attAssT3;
		this.attAssT4 = other.attAssT4;
		this.codConcentratore = other.codConcentratore;
		this.dataAcquisizione = other.dataAcquisizione;
	}
	
	public Serializable retrievePrimaryKey() {
		return getId();
	}
	
	public MensileAttAss(MensileAttAssId id){
		this.id=id;
	}

	public MensileAttAssId getId() {
		return id;
	}

	public void setId(MensileAttAssId id) {
		this.id = id;
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

	public java.util.Date getDataRil() {
		return dataRil;
	}

	public void setDataRil(java.util.Date dataRil) {
		this.dataRil = dataRil;
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
		return "MensileAttAss [id=" + id + ", attAss=" + attAss + ", esito="
				+ esito + ", dataRil=" + dataRil + ", attAssT1=" + attAssT1
				+ ", attAssT2=" + attAssT2 + ", attAssT3=" + attAssT3
				+ ", attAssT4=" + attAssT4 + ", codConcentratore="
				+ codConcentratore + ", dataAcquisizione=" + dataAcquisizione
				+ ", provenienza=" + provenienza + "]";
	}

	
	
}