package com.ericsson.mgse.persistence.dto;

import java.io.Serializable;

public class SubSystem implements Serializable {
	private static final long serialVersionUID = -1;
	
	private SubSystemId id;
	private String name;
	
	public SubSystem() {
		super();
		
	}

	public SubSystem(SubSystemId id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public SubSystemId getId() {
		return id;
	}

	public void setId(SubSystemId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final SubSystem other = (SubSystem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
