package com.ericsson.mgse.persistence.dto;

import java.io.Serializable;

import com.ericsson.mgse.persistence.dto.datatypes.LockTypeName;
import com.ericsson.urm.util.ArgumentsCheckerUtil;

public class LockType implements Serializable {
	private static final long serialVersionUID = -1;
	
	private int id;
	private String name;
	
	public LockType() {
	
	}

	public LockType(int id, LockTypeName lockTypeName) {
		ArgumentsCheckerUtil.checkNull(lockTypeName);

		this.id = id;
		this.name = lockTypeName.toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LockTypeName getName() {
		return LockTypeName.parse(name);
	}

	public void setName(LockTypeName lockTypeName) {
		ArgumentsCheckerUtil.checkNull(lockTypeName);
		this.name = lockTypeName.toString();
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		final LockType other = (LockType) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
