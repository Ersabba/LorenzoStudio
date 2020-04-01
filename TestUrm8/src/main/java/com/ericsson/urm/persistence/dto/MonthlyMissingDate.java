package com.ericsson.urm.persistence.dto;

import java.io.Serializable;
import java.util.Date;

public class MonthlyMissingDate implements Serializable {

	private static final long serialVersionUID = -1L;
	
	private String meterId		= null;
	private Date missingMonth	= null;
	private String energyType	= null;
	
	
	public MonthlyMissingDate() {
		super();
	}

	/**
	 * @param meterId
	 * @param missingMonth
	 * @param energyType
	 */
	public MonthlyMissingDate(String meterId, Date missingMonth, String energyType) {
		super();
		this.meterId = meterId;
		this.missingMonth = missingMonth;
		this.energyType = energyType;
	}

	public String getMeterId() {
		return meterId;
	}

	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}

	public Date getMissingMonth() {
		return missingMonth;
	}

	public void setMissingMonth(Date missingMonth) {
		this.missingMonth = missingMonth;
	}

	public String getEnergyType() {
		return energyType;
	}

	public void setEnergyType(String energyType) {
		this.energyType = energyType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((energyType == null) ? 0 : energyType.hashCode());
		result = prime * result + ((meterId == null) ? 0 : meterId.hashCode());
		result = prime * result + ((missingMonth == null) ? 0 : missingMonth.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonthlyMissingDate other = (MonthlyMissingDate) obj;
		if (energyType == null) {
			if (other.energyType != null)
				return false;
		} else if (!energyType.equals(other.energyType))
			return false;
		if (meterId == null) {
			if (other.meterId != null)
				return false;
		} else if (!meterId.equals(other.meterId))
			return false;
		if (missingMonth == null) {
			if (other.missingMonth != null)
				return false;
		} else if (!missingMonth.equals(other.missingMonth))
			return false;
		return true;
	}
	
}
