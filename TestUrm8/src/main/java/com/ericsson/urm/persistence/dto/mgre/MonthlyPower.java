package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

public class MonthlyPower implements Serializable, Cloneable {
	private static final long serialVersionUID = -1;
	
	private MonthlyPowerId id=null;
	private String codConcentratore=null;
	private Date dataAcq=null;
	private Date regDataRil=null;
	private Long componentValue;
	
	public MonthlyPower() {}
	

	public MonthlyPowerId getId() {
		return id;
	}
	public void setId(MonthlyPowerId id) {
		this.id = id;
	}
	public String getCodConcentratore() {
		return codConcentratore;
	}
	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}
	public Date getDataAcq() {
		return dataAcq;
	}
	public void setDataAcq(Date dataAcq) {
		this.dataAcq = dataAcq;
	}
	public Date getRegDataRil() {
		return regDataRil;
	}
	public void setRegDataRil(Date regDataRil) {
		this.regDataRil = regDataRil;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((regDataRil == null) ? 0 : regDataRil.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final MonthlyPower other = (MonthlyPower) obj;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (regDataRil == null) {
			if (other.regDataRil != null)
				return false;
		} else if (!regDataRil.equals(other.regDataRil))
			return false;
		return true;
	}


	public Object clone() {
		MonthlyPower ret = new MonthlyPower();
		
		ret.id = (MonthlyPowerId)id.clone();
		ret.codConcentratore = codConcentratore;
		ret.dataAcq = dataAcq;
		ret.regDataRil = regDataRil;
		ret.componentValue = componentValue;
		return ret;
	}
}
