package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;

public class MeterFault implements Serializable {
	private final static long serialVersionUID = -1;
	
	private MeterFaultId id;
	private int partitionId;
	

	public MeterFault() {
		
	}
		
	public MeterFault(MeterFaultId id) {
		this.id = id;
		if(id!=null) {
			partitionId = (id.getYear() & 1);
		}
	}

	public MeterFaultId getId() {
		return id;
	}
	
	public void setId(MeterFaultId id) {
		this.id = id;
		if(id!=null) {
			partitionId = (id.getYear() & 1);
		}
	}

	public int getPartitionId() {
		return partitionId;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + partitionId;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final MeterFault other = (MeterFault) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (partitionId != other.partitionId)
			return false;
		return true;
	}
	
}
