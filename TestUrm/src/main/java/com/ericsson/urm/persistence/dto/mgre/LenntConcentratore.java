package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;

public class LenntConcentratore implements Serializable {
	private final static long serialVersionUID = -1;
	
	private LenntConcentratoreId id = null;

	public LenntConcentratore() {}

	public LenntConcentratore(LenntConcentratoreId id) {
		this.id = id;
	}

	public LenntConcentratoreId getId() {
		return id;
	}

	public void setId(LenntConcentratoreId id) {
		this.id = id;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof LenntConcentratore))
			return false;
		final LenntConcentratore other = (LenntConcentratore) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
