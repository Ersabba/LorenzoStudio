package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;

public class StatoLenntTrasformatoreId implements Serializable {
	private static final long serialVersionUID = -1;
	
	private String matricolaLennt;
	private String descrInterna;
	
	
	public StatoLenntTrasformatoreId() {}


	public StatoLenntTrasformatoreId(String matricolaLennt, String descrInterna) {
		this.matricolaLennt = matricolaLennt;
		this.descrInterna = descrInterna;
	}


	public String getMatricolaLennt() {
		return matricolaLennt;
	}


	public void setMatricolaLennt(String matricolaLennt) {
		this.matricolaLennt = matricolaLennt;
	}


	public String getDescrInterna() {
		return descrInterna;
	}


	public void setDescrInterna(String descrInterna) {
		this.descrInterna = descrInterna;
	}


	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descrInterna == null) ? 0 : descrInterna.hashCode());
		result = prime * result
				+ ((matricolaLennt == null) ? 0 : matricolaLennt.hashCode());
		return result;
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof StatoLenntTrasformatoreId))
			return false;
		final StatoLenntTrasformatoreId other = (StatoLenntTrasformatoreId) obj;
		if (descrInterna == null) {
			if (other.descrInterna != null)
				return false;
		} else if (!descrInterna.equals(other.descrInterna))
			return false;
		if (matricolaLennt == null) {
			if (other.matricolaLennt != null)
				return false;
		} else if (!matricolaLennt.equals(other.matricolaLennt))
			return false;
		return true;
	}


	
	
}
