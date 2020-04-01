package com.ericsson.urm.core.datatypes;

import java.io.Serializable;

public class LenntSettingsFileRecord implements Serializable{
	
	private static final long serialVersionUID = -1L;
	
	private String matricolaLennt = null;
	private String simNumber = null;
	private String tipoUtenza = null;
	
	public LenntSettingsFileRecord() {
		super();

	}
	
	public LenntSettingsFileRecord(String matricolaLennt, String simNumber,
			String tipoUtenza) {
		super();
		this.matricolaLennt = matricolaLennt;
		this.simNumber = simNumber;
		this.tipoUtenza = tipoUtenza;
	}

	public String getMatricolaLennt() {
		return matricolaLennt;
	}

	public void setMatricolaLennt(String matricolaLennt) {
		this.matricolaLennt = matricolaLennt;
	}

	public String getSimNumber() {
		return simNumber;
	}

	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}

	public String getTipoUtenza() {
		return tipoUtenza;
	}

	public void setTipoUtenza(String tipoUtenza) {
		this.tipoUtenza = tipoUtenza;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricolaLennt == null) ? 0 : matricolaLennt.hashCode());
		result = prime * result
				+ ((simNumber == null) ? 0 : simNumber.hashCode());
		result = prime * result
				+ ((tipoUtenza == null) ? 0 : tipoUtenza.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LenntSettingsFileRecord other = (LenntSettingsFileRecord) obj;
		if (matricolaLennt == null) {
			if (other.matricolaLennt != null)
				return false;
		} else if (!matricolaLennt.equals(other.matricolaLennt))
			return false;
		if (simNumber == null) {
			if (other.simNumber != null)
				return false;
		} else if (!simNumber.equals(other.simNumber))
			return false;
		if (tipoUtenza == null) {
			if (other.tipoUtenza != null)
				return false;
		} else if (!tipoUtenza.equals(other.tipoUtenza))
			return false;
		return true;
	}
	
}
