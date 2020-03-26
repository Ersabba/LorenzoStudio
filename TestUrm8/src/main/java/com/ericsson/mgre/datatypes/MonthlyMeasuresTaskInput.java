package com.ericsson.mgre.datatypes;

import java.io.Serializable;
import java.util.Date;

public class MonthlyMeasuresTaskInput implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Date dataAcquisizione;
	private Date inizioUltimoCicloRaccolta;
	
	public MonthlyMeasuresTaskInput() {
		super();
	}

	public MonthlyMeasuresTaskInput(Date dataAcquisizione,
			Date inizioUltimoCicloRaccolta) {
		super();
		this.dataAcquisizione = dataAcquisizione;
		this.inizioUltimoCicloRaccolta = inizioUltimoCicloRaccolta;
	}

	public Date getDataAcquisizione() {
		return dataAcquisizione;
	}

	public void setDataAcquisizione(Date dataAcquisizione) {
		this.dataAcquisizione = dataAcquisizione;
	}

	public Date getInizioUltimoCicloRaccolta() {
		return inizioUltimoCicloRaccolta;
	}

	public void setInizioUltimoCicloRaccolta(Date inizioUltimoCicloRaccolta) {
		this.inizioUltimoCicloRaccolta = inizioUltimoCicloRaccolta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((dataAcquisizione == null) ? 0 : dataAcquisizione.hashCode());
		result = prime
				* result
				+ ((inizioUltimoCicloRaccolta == null) ? 0
						: inizioUltimoCicloRaccolta.hashCode());
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
		MonthlyMeasuresTaskInput other = (MonthlyMeasuresTaskInput) obj;
		if (dataAcquisizione == null) {
			if (other.dataAcquisizione != null)
				return false;
		} else if (!dataAcquisizione.equals(other.dataAcquisizione))
			return false;
		if (inizioUltimoCicloRaccolta == null) {
			if (other.inizioUltimoCicloRaccolta != null)
				return false;
		} else if (!inizioUltimoCicloRaccolta
				.equals(other.inizioUltimoCicloRaccolta))
			return false;
		return true;
	}
	
	
}
