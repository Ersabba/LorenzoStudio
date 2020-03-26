package com.ericsson.mgre.datatypes.quality;

import java.io.Serializable;
import java.util.Date;

public class PhaseMetersResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String UNMODIFIED = "0295";

	private String  meterId;
	private String  phase;
	private Date	datePhase;
	

	public PhaseMetersResponse() {
		
	}
		

	public PhaseMetersResponse(String meterId, String phase, Date datePhase) {
		this.meterId = meterId;
		this.phase = phase;
		this.datePhase = datePhase;
	}

	public String getMeterId() {
		return meterId;
	}
	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public Date getDatePhase() {
		return datePhase;
	}
	public void setDatePhase(Date datePhase) {
		this.datePhase = datePhase;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((datePhase == null) ? 0 : datePhase.hashCode());
		result = prime * result + ((meterId == null) ? 0 : meterId.hashCode());
		result = prime * result + ((phase == null) ? 0 : phase.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final PhaseMetersResponse other = (PhaseMetersResponse) obj;
		if (datePhase == null) {
			if (other.datePhase != null)
				return false;
		} else if (!datePhase.equals(other.datePhase))
			return false;
		if (meterId == null) {
			if (other.meterId != null)
				return false;
		} else if (!meterId.equals(other.meterId))
			return false;
		if (phase == null) {
			if (other.phase != null)
				return false;
		} else if (!phase.equals(other.phase))
			return false;
		return true;
	}

	
	
}
