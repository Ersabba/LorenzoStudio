package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.db.MgdbDto;

public class TotAttAss implements java.io.Serializable, TotAttAssInterface, MgdbDto {
	
	private static final long serialVersionUID = 1L;
	
	private String matricolaLenntCliente;
	private Date dataRil;
	private String esito;
	private Long attAss;
	private Long attAssT1;
	private Long attAssT2;
	private Long attAssT3;
	private Long attAssT4;
	private String codConcentratore;
	private String provenienza=null;
	private Date dataAcq;
	
	public Object clone() {
		try {
			TotAttAss ret = (TotAttAss)super.clone();
			if (dataRil != null)
				ret.dataRil = (Date) dataRil.clone();
			if (dataAcq != null)
				ret.dataAcq = (Date) dataAcq.clone();
			return ret;
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	public void applyAllProperties(MgdbDto srcDto) {
		TotAttAss other = (TotAttAss)srcDto;
		this.matricolaLenntCliente = other.matricolaLenntCliente;
		
		if (other.dataRil != null)
			this.dataRil = (Date)other.dataRil.clone();
		else
			this.dataRil = null;
		
		if (other.dataAcq != null)
			this.dataAcq = (Date)other.dataAcq.clone();
		else
			this.dataAcq = null;
		
		this.esito = other.esito;
		this.attAss = other.attAss;
		this.attAssT1 = other.attAssT1;
		this.attAssT2 = other.attAssT2;
		this.attAssT3 = other.attAssT3;
		this.attAssT4 = other.attAssT4;
		this.codConcentratore = other.codConcentratore;
		this.provenienza = other.provenienza;
	}
	
	public Serializable retrievePrimaryKey() {
		return getMatricolaLenntCliente();
	}
	
	public TotAttAss(){
		
	}
	
	public TotAttAss(String matricolaLenntCliente){
		this.matricolaLenntCliente=matricolaLenntCliente;
	}

	public TotAttAss(String matricolaLenntCliente, Date dataRil, Long attAss,
			String esito, Long attAssT1, Long attAssT2, Long attAssT3,
			Long attAssT4, String codConcentratore) {
		this.matricolaLenntCliente = matricolaLenntCliente;
		this.dataRil = dataRil;
		this.attAss = attAss;
		this.esito = esito;
		this.attAssT1 = attAssT1;
		this.attAssT2 = attAssT2;
		this.attAssT3 = attAssT3;
		this.attAssT4 = attAssT4;
		this.codConcentratore = codConcentratore;
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

	public String getProvenienza() {
		return provenienza;
	}

	public void setProvenienza(String provenienza) {
		this.provenienza = provenienza;
	}

	@Override
	public Date getDataAcq() {
		return dataAcq;
	}

	public void setDataAcq(Date dataAcq) {
		this.dataAcq = dataAcq;
	}

	@Override
	public String toString() {
		return "TotAttAss [matricolaLenntCliente=" + matricolaLenntCliente
				+ ", dataRil=" + dataRil + ", esito=" + esito + ", attAss="
				+ attAss + ", attAssT1=" + attAssT1 + ", attAssT2=" + attAssT2
				+ ", attAssT3=" + attAssT3 + ", attAssT4=" + attAssT4
				+ ", codConcentratore=" + codConcentratore + ", provenienza="
				+ provenienza + ", dataAcq=" + dataAcq + "]";
	}
}