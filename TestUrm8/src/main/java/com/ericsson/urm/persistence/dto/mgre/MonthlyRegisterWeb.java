package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

public class MonthlyRegisterWeb implements Serializable, Cloneable {
	private static final long serialVersionUID = -1;
	
	private MonthlyRegisterWebId id=null;
	private String codConcentratore=null;
	private String esito=null;
	private Date dataRil=null;
	private Date dataAcq=null;
	private Long componentValue;
	
	public MonthlyRegisterWeb() {}

	public MonthlyRegisterWebId getId() {
		return id;
	}
	public void setId(MonthlyRegisterWebId id) {
		this.id = id;
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
	public Date getDataRil() {
		return dataRil;
	}
	public void setDataRil(Date dataRil) {
		this.dataRil = dataRil;
	}
	public Date getDataAcq() {
		return dataAcq;
	}
	public void setDataAcq(Date dataAcq) {
		this.dataAcq = dataAcq;
	}
	public Long getComponentValue() {
		return componentValue;
	}
	public void setComponentValue(Long componentValue) {
		this.componentValue = componentValue;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((codConcentratore == null) ? 0 : codConcentratore.hashCode());
		result = prime * result
				+ ((componentValue == null) ? 0 : componentValue.hashCode());
		result = prime * result + ((dataAcq == null) ? 0 : dataAcq.hashCode());
		result = prime * result + ((dataRil == null) ? 0 : dataRil.hashCode());
		result = prime * result + ((esito == null) ? 0 : esito.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonthlyRegisterWeb other = (MonthlyRegisterWeb) obj;
		if (codConcentratore == null) {
			if (other.codConcentratore != null)
				return false;
		} else if (!codConcentratore.equals(other.codConcentratore))
			return false;
		if (componentValue == null) {
			if (other.componentValue != null)
				return false;
		} else if (!componentValue.equals(other.componentValue))
			return false;
		if (dataAcq == null) {
			if (other.dataAcq != null)
				return false;
		} else if (!dataAcq.equals(other.dataAcq))
			return false;
		if (dataRil == null) {
			if (other.dataRil != null)
				return false;
		} else if (!dataRil.equals(other.dataRil))
			return false;
		if (esito == null) {
			if (other.esito != null)
				return false;
		} else if (!esito.equals(other.esito))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Object clone() {
		MonthlyRegisterWeb ret = new MonthlyRegisterWeb();
		
		ret.id = (MonthlyRegisterWebId)id.clone();
		ret.codConcentratore = codConcentratore;
		ret.esito = esito;
		ret.dataRil = dataRil;
		ret.dataAcq = dataAcq;
		ret.componentValue = componentValue;
		
		return ret;
	}
}
