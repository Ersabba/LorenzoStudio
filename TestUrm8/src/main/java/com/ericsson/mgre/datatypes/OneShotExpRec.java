package com.ericsson.mgre.datatypes;

import java.io.Serializable;
import java.sql.Clob;
import java.util.Arrays;
import java.util.Date;

public class OneShotExpRec implements Serializable {
	
	private static final long	serialVersionUID	= -1L;
	
	Date referenceDate;
	int  fCounter;
	Clob xml;
	
	public OneShotExpRec() {
		super();
	}
	
	public OneShotExpRec(Date referenceDate, int fCounter, Clob  xml) {
		super();
		this.referenceDate = referenceDate;
		this.fCounter = fCounter;
		this.xml = xml;
	}

	public Date getReferenceDate() {
		return referenceDate;
	}

	public void setReferanceDate(Date referenceDate) {
		this.referenceDate = referenceDate;
	}

	public int getfCounter() {
		return fCounter;
	}

	public void setfCounter(int fCounter) {
		this.fCounter = fCounter;
	}

	public Clob  getXml() {
		return xml;
	}

	public void setXml(Clob xml) {
		this.xml = xml;
	}

	@Override
	public String toString() {
		return "OneShotExpRec [referenceDate=" + referenceDate + ", fCounter=" + fCounter + ", xml=" + xml + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fCounter;
		result = prime * result + ((referenceDate == null) ? 0 : referenceDate.hashCode());
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
		OneShotExpRec other = (OneShotExpRec) obj;
		if (fCounter != other.fCounter)
			return false;
		if (referenceDate == null) {
			if (other.referenceDate != null)
				return false;
		} else if (!referenceDate.equals(other.referenceDate))
			return false;
		return true;
	}

	
}
