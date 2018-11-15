package com.ericsson.mgse.persistence.dto;

import java.io.Serializable;

public class SubSystemId implements Serializable {
	private static final long serialVersionUID = -1;
	
	private int id;
	private int idEs;
	
	public SubSystemId() {
		super();
		
	}

	public SubSystemId(int id, int idEs) {
		super();
		this.id = id;
		this.idEs = idEs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdEs() {
		return idEs;
	}

	public void setIdEs(int idEs) {
		this.idEs = idEs;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + idEs;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final SubSystemId other = (SubSystemId) obj;
		if (id != other.id)
			return false;
		if (idEs != other.idEs)
			return false;
		return true;
	}

	
}
