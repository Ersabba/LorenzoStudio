package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.db.MgdbDto;


public class StorTotEr implements java.io.Serializable, MgdbDto {
	
	private static final long serialVersionUID = 1L;
	
	private StorTotErId id=null;
	private String esito;	
	private Long attEr;
	private Long attErT1;
	private Long attErT2;
	private Long attErT3;
	private Long attErT4;	
	private Long reattIndEr=null;
	private Long reattCapEr=null;
	private String provenienza=null;
	private Date dataAcq;
	private String codConcentratore;
	
	public Object clone() {
		try {
			StorTotEr ret = (StorTotEr) super.clone();
			if (id != null)
				ret.id = (StorTotErId) id.clone();
			if (dataAcq != null)
				ret.dataAcq = (Date) dataAcq.clone();
			return ret;
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	public void applyAllProperties(MgdbDto srcDto) {
		StorTotEr other = (StorTotEr)srcDto;
		if (other.id != null)
			this.id = (StorTotErId)other.id.clone();
		else
			this.id = null;
		

		if (other.dataAcq != null)
			this.dataAcq = (Date)other.dataAcq.clone();
		else
			this.dataAcq = null;

		this.esito = other.esito;
		this.attEr = other.attEr;
		this.attErT1 = other.attErT1;
		this.attErT2 = other.attErT2;
		this.attErT3 = other.attErT3;
		this.attErT4 = other.attErT4;
		this.reattIndEr = other.reattIndEr;
		this.reattCapEr = other.reattCapEr;
		this.provenienza = other.provenienza;
		this.codConcentratore = other.codConcentratore;
	}
	
	public Serializable retrievePrimaryKey() {
		return getId();
	}
	
	public StorTotEr(){
		
	}
	
	public StorTotEr(StorTotErId id){
		this.id=id;
	}

	public StorTotErId getId() {
		return id;
	}

	public void setId(StorTotErId id) {
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
	
	public String getMatricolaLenntCliente() {
		if(id!=null)
			return id.getMatricolaLenntCliente();
		else return null;
	}

	public Date getDataRil() {
		if(id!=null)
			return id.getDataRil();
		else return null;
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
		return "StorTotEr [id=" + id + ", esito=" + esito + ", attEr=" + attEr
				+ ", attErT1=" + attErT1 + ", attErT2=" + attErT2
				+ ", attErT3=" + attErT3 + ", attErT4=" + attErT4
				+ ", reattIndEr=" + reattIndEr + ", reattCapEr=" + reattCapEr
				+ ", provenienza=" + provenienza + ", dataAcq=" + dataAcq
				+ ", codConcentratore=" + codConcentratore + "]";
	}


		
}