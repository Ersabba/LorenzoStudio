package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

public class LenntConcentratoreId implements Serializable {
	private final static long serialVersionUID = -1;
	
	private String concentratorId=null;
	private String meterId=null;
	private Date dateBinding;
	

	public LenntConcentratoreId() {}
	
	public LenntConcentratoreId(String concentratorId, String meterId,
			Date dateBinding) {
		
		this.concentratorId = concentratorId;
		this.meterId = meterId;
		this.dateBinding = dateBinding;
	}

	public String getConcentratorId() {
		return concentratorId;
	}
	public void setConcentratorId(String concentratorId) {
		this.concentratorId = concentratorId;
	}
	public String getMeterId() {
		return meterId;
	}
	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}
	public Date getDateBinding() {
		return dateBinding;
	}
	public void setDateBinding(Date dateBinding) {
		this.dateBinding = dateBinding;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((concentratorId == null) ? 0 : concentratorId.hashCode());
		result = prime * result
				+ ((dateBinding == null) ? 0 : dateBinding.hashCode());
		result = prime * result + ((meterId == null) ? 0 : meterId.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final LenntConcentratoreId other = (LenntConcentratoreId) obj;
		if (concentratorId == null) {
			if (other.concentratorId != null)
				return false;
		} else if (!concentratorId.equals(other.concentratorId))
			return false;
		if (dateBinding == null) {
			if (other.dateBinding != null)
				return false;
		} else if (!dateBinding.equals(other.dateBinding))
			return false;
		if (meterId == null) {
			if (other.meterId != null)
				return false;
		} else if (!meterId.equals(other.meterId))
			return false;
		return true;
	}
	
	
}
