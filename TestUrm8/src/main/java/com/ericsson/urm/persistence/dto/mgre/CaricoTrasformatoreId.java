package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

public class CaricoTrasformatoreId implements Serializable {
	private static final long serialVersionUID = -1;

	private long codTrasformatore;
	private long numPeriodo;
	private Date dataCurva;

	public CaricoTrasformatoreId() {

	}

	

	public CaricoTrasformatoreId(long codTrasformatore, long numPeriodo, Date dataCurva) {
		super();
		this.codTrasformatore = codTrasformatore;
		this.numPeriodo = numPeriodo;
		this.dataCurva = dataCurva;
	}



	public long getNumPeriodo() {
		return numPeriodo;
	}

	public void setNumPeriodo(long numPeriodo) {
		this.numPeriodo = numPeriodo;
	}

	public Date getDataCurva() {
		return dataCurva;
	}

	public void setDataCurva(Date dataCurva) {
		this.dataCurva = dataCurva;
	}

	public long getCodTrasformatore() {
		return codTrasformatore;
	}

	public void setCodTrasformatore(long codTrasformatore) {
		this.codTrasformatore = codTrasformatore;
	}



	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (codTrasformatore ^ (codTrasformatore >>> 32));
		result = prime * result
				+ ((dataCurva == null) ? 0 : dataCurva.hashCode());
		result = prime * result + (int) (numPeriodo ^ (numPeriodo >>> 32));
		return result;
	}



	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final CaricoTrasformatoreId other = (CaricoTrasformatoreId) obj;
		if (codTrasformatore != other.codTrasformatore)
			return false;
		if (dataCurva == null) {
			if (other.dataCurva != null)
				return false;
		} else if (!dataCurva.equals(other.dataCurva))
			return false;
		if (numPeriodo != other.numPeriodo)
			return false;
		return true;
	}
	
	

}
