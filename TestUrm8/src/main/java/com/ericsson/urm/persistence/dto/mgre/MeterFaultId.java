package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;

public class MeterFaultId implements Serializable {
	private final static long serialVersionUID = -1;
	
	private String idMeter;
	private int year;
	
		
	public MeterFaultId() {
		
	}


	public MeterFaultId(String idMeter, int year) {
		this.idMeter = idMeter;
		this.year = year;
	}


	public String getIdMeter() {
		return idMeter;
	}


	public void setIdMeter(String idMeter) {
		this.idMeter = idMeter;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMeter == null) ? 0 : idMeter.hashCode());
		result = prime * result + year;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final MeterFaultId other = (MeterFaultId) obj;
		if (idMeter == null) {
			if (other.idMeter != null)
				return false;
		} else if (!idMeter.equals(other.idMeter))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
   
	
}
