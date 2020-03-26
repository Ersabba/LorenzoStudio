package com.ericsson.urm.persistence.dto.mgre;

import java.util.Date;


public class StatoConcentratore implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private StatoConcentratoreId id;
	private String descrValore;
	private String valore;
	private Date dataRil=null;
	
	public StatoConcentratore() {}

	public StatoConcentratore(StatoConcentratoreId id, String descrInterna,
			String valore, Date dataRil) {
		this.id = id;
		this.descrValore = descrInterna;
		this.valore = valore;
		this.dataRil = dataRil;
	}

	public StatoConcentratoreId getId() {
		return id;
	}

	public void setId(StatoConcentratoreId id) {
		this.id = id;
	}

	public String getDescrValore() {
		return descrValore;
	}

	public void setDescrValore(String descrValore) {
		this.descrValore = descrValore;
	}

	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

	public Date getDataRil() {
		return dataRil;
	}

	public void setDataRil(Date dataRil) {
		this.dataRil = dataRil;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataRil == null) ? 0 : dataRil.hashCode());
		result = prime * result
				+ ((descrValore == null) ? 0 : descrValore.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((valore == null) ? 0 : valore.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final StatoConcentratore other = (StatoConcentratore) obj;
		if (dataRil == null) {
			if (other.dataRil != null)
				return false;
		} else if (!dataRil.equals(other.dataRil))
			return false;
		if (descrValore == null) {
			if (other.descrValore != null)
				return false;
		} else if (!descrValore.equals(other.descrValore))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (valore == null) {
			if (other.valore != null)
				return false;
		} else if (!valore.equals(other.valore))
			return false;
		return true;
	}
	
}