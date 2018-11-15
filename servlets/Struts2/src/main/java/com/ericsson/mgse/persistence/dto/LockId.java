package com.ericsson.mgse.persistence.dto;

import java.io.Serializable;

public class LockId implements Serializable {
	private static final long serialVersionUID = -1;
	
	private String idLock;
	private int idLockType;
	private int idEs;
	private int idSs;
	
	public LockId() {
		super();
		
	}

	public LockId(String idLock, int idLockType, int idEs, int idSs) {
		super();
		this.idLock = idLock;
		this.idLockType = idLockType;
		this.idEs = idEs;
		this.idSs = idSs;
	}

	public String getIdLock() {
		return idLock;
	}

	public void setIdLock(String idLock) {
		this.idLock = idLock;
	}

	public int getIdLockType() {
		return idLockType;
	}

	public void setIdLockType(int idLockType) {
		this.idLockType = idLockType;
	}

	public int getIdEs() {
		return idEs;
	}

	public void setIdEs(int idEs) {
		this.idEs = idEs;
	}

	public int getIdSs() {
		return idSs;
	}

	public void setIdSs(int idSs) {
		this.idSs = idSs;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEs;
		result = prime * result + ((idLock == null) ? 0 : idLock.hashCode());
		result = prime * result + idLockType;
		result = prime * result + idSs;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final LockId other = (LockId) obj;
		if (idEs != other.idEs)
			return false;
		if (idLock == null) {
			if (other.idLock != null)
				return false;
		} else if (!idLock.equals(other.idLock))
			return false;
		if (idLockType != other.idLockType)
			return false;
		if (idSs != other.idSs)
			return false;
		return true;
	}
	
}
