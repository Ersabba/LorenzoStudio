package com.ericsson.mgse.persistence.dto;

import java.io.Serializable;
import java.util.Date;

public class Lock implements Serializable {
	private static final long serialVersionUID = -1;
	
	private LockId id;
	private String owner;
	private Date leaseTime;
	
	public Lock() {
		super();
		
	}

	public Lock(LockId id, String owner, Date leaseTime) {
		this.id = id;
		this.owner = owner;
		this.leaseTime = leaseTime;
	}

	public LockId getId() {
		return id;
	}

	public void setId(LockId id) {
		this.id = id;
	}
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Date getLeaseTime() {
		return leaseTime;
	}

	public void setLeaseTime(Date leaseTime) {
		this.leaseTime = leaseTime;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((leaseTime == null) ? 0 : leaseTime.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Lock other = (Lock) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (leaseTime == null) {
			if (other.leaseTime != null)
				return false;
		} else if (!leaseTime.equals(other.leaseTime))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}

	
	
}
