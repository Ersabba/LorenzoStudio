package com.ericsson.urm.persistence.dto.mds;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;


public class AcqFileCcs implements Serializable {
	private final static long serialVersionUID = -1;
	
	private AcqFileCcsId id = null;
	private String insertTime = null;
	private String errorType = null;
	private int partitionId;
	
	
	public AcqFileCcs() {
	}
	
	public AcqFileCcs(AcqFileCcsId id) {
		setId(id);
	}
	
	public AcqFileCcs(AcqFileCcsId id, String insertTime, String errorType) {
		setId(id);
		this.insertTime = insertTime;
		this.errorType = errorType;
	}

	public AcqFileCcsId getId() {
		return id;
	}
	
	public void setId(AcqFileCcsId id) {
		this.id = id;
		
		if(id!=null) {
			this.partitionId = getMonth(id.getAcquisitionDate());
		}
		else {
			this.partitionId = 0;
		}
	}	
	
	public String getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(String insertTime) {
		this.insertTime = insertTime;
	}

	public String getErrorType() {
		return errorType;
	}
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	
	private int getMonth (Date date)
	{
		if(date!=null) {
			GregorianCalendar calendar = new GregorianCalendar ();
			calendar.setTime(date);
			return calendar.get (GregorianCalendar.MONTH);
		}
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((errorType == null) ? 0 : errorType.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((insertTime == null) ? 0 : insertTime.hashCode());
		result = prime * result + partitionId;
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
		AcqFileCcs other = (AcqFileCcs) obj;
		if (errorType == null) {
			if (other.errorType != null)
				return false;
		} else if (!errorType.equals(other.errorType))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (insertTime == null) {
			if (other.insertTime != null)
				return false;
		} else if (!insertTime.equals(other.insertTime))
			return false;
		if (partitionId != other.partitionId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AcqFileCcs{" +
				"id=" + id +
				", insertTime='" + insertTime + '\'' +
				", errorType='" + errorType + '\'' +
				", partitionId=" + partitionId +
				'}';
	}
}
