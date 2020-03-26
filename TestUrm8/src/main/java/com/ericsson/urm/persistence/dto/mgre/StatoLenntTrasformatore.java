package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

public class StatoLenntTrasformatore implements Serializable {
	private static final long serialVersionUID = -1;
	
	private StatoLenntTrasformatoreId id;
	private Date dataRil;
	private int position;
	private Integer valore;
	
	public StatoLenntTrasformatore() {}


	public StatoLenntTrasformatore(StatoLenntTrasformatoreId id, Date dataRil,
			int position, Integer valore) {
		super();
		this.id = id;
		this.dataRil = dataRil;
		this.position = position;
		this.valore = valore;
	}


	public StatoLenntTrasformatoreId getId() {
		return id;
	}

	public void setId(StatoLenntTrasformatoreId id) {
		this.id = id;
	}

	public Date getDataRil() {
		return dataRil;
	}

	public void setDataRil(Date dataRil) {
		this.dataRil = dataRil;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Integer getValore() {
		return valore;
	}

	public void setValore(Integer valore) {
		this.valore = valore;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataRil == null) ? 0 : dataRil.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + position;
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
		final StatoLenntTrasformatore other = (StatoLenntTrasformatore) obj;
		if (dataRil == null) {
			if (other.dataRil != null)
				return false;
		} else if (!dataRil.equals(other.dataRil))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (position != other.position)
			return false;
		if (valore == null) {
			if (other.valore != null)
				return false;
		} else if (!valore.equals(other.valore))
			return false;
		return true;
	}


}
