package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;


public class StatusAcqWeekly implements Serializable {
	private static final long serialVersionUID = -1;
	
	public enum Status {
		A,	//ACQUISIZIONE effettuata con successo
		N,	//ACQUISIZIONE TERMINATA ( FILE_NOT_FOUND)
		F,	//ACQUISIZIONE da effettuare o fallita
		E;	//elaborazione TERMINATA
		
		public static Status parse(String typeName)	{	
			for (Status curr : Status.values()) {
				if(curr.toString().equalsIgnoreCase(typeName)) { return curr; }
			}
			
			throw new IllegalArgumentException ("Status: unsupported type name " + typeName);
		}
		
		public static Status parse(char typeName) {	
			return parse(Character.toString(typeName));
		}
	}
	
	private String ccsId;
	private String status = null;
	private Date acqDate=null;

	public StatusAcqWeekly() {

	}

	public StatusAcqWeekly(String ccsId, StatusAcqWeekly.Status[] aStatus, Date acqDate) {
		super();
		this.ccsId = ccsId;
		this.acqDate = acqDate;
		this.status = statusToString(aStatus);
	}
	
	public StatusAcqWeekly(String ccsId, String status, Date acqDate) {
		super();
		this.ccsId = ccsId;
		this.acqDate = acqDate;
		this.status = status;
	}

	public String getCcsId() {
		return ccsId;
	}

	public void setCcsId(String ccsId) {
		this.ccsId = ccsId;
	}

	public StatusAcqWeekly.Status[] getStatusAsArray() {
		return strToStatus(status);
	}

	public void setStatusAsArray(StatusAcqWeekly.Status[] aStatus) {
		this.status = statusToString(aStatus);
	}

	public Date getAcqDate() {
		return acqDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setAcqDate(Date acqDate) {
		this.acqDate = acqDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acqDate == null) ? 0 : acqDate.hashCode());
		result = prime * result + ((ccsId == null) ? 0 : ccsId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		StatusAcqWeekly other = (StatusAcqWeekly) obj;
		if (acqDate == null) {
			if (other.acqDate != null)
				return false;
		} else if (!acqDate.equals(other.acqDate))
			return false;
		if (ccsId == null) {
			if (other.ccsId != null)
				return false;
		} else if (!ccsId.equals(other.ccsId))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}


	public static StatusAcqWeekly.Status[] strToStatus(String status) {
		StatusAcqWeekly.Status[] aStatus = null;
		if(status!=null) {
			aStatus = new StatusAcqWeekly.Status[status.length()];
			int j=0;
			for(char ch : status.toCharArray()) {
				aStatus[j++] = StatusAcqWeekly.Status.parse(ch);
			}
		}
		return aStatus;
	}
	
	public static String statusToString(StatusAcqWeekly.Status[] aStatus) {
		String status = null;
		if(aStatus!=null) {
			status = "";
			for(StatusAcqWeekly.Status curr : aStatus) {
				status += curr.toString();
			}
		}
		return status;
	}
	
}
