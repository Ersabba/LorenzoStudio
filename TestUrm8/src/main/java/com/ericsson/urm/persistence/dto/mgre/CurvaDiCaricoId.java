package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

public class CurvaDiCaricoId implements Serializable, Cloneable {
	private static final long serialVersionUID = -1;
	
	private String	matricolaLenntCliente;
	private long 	numPeriodo;	           
	private Date 	dataCurva;
	
	public CurvaDiCaricoId() {
		
	}

	public Object clone() {
		try {
			return super.clone();
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	public CurvaDiCaricoId(String matricolaLenntCliente, int numPeriodo,
			Date dataCurva) {
		super();
		this.matricolaLenntCliente = matricolaLenntCliente;
		this.numPeriodo = numPeriodo;
		this.dataCurva = dataCurva;
	}

	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}

	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
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

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataCurva == null) ? 0 : dataCurva.hashCode());
		result = prime
				* result
				+ ((matricolaLenntCliente == null) ? 0 : matricolaLenntCliente
						.hashCode());
		result = prime * result + (int)numPeriodo;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final CurvaDiCaricoId other = (CurvaDiCaricoId) obj;
		if (dataCurva == null) {
			if (other.dataCurva != null)
				return false;
		} else if (!dataCurva.equals(other.dataCurva))
			return false;
		if (matricolaLenntCliente == null) {
			if (other.matricolaLenntCliente != null)
				return false;
		} else if (!matricolaLenntCliente.equals(other.matricolaLenntCliente))
			return false;
		if (numPeriodo != other.numPeriodo)
			return false;
		return true;
	}

	
	public String toString() {
		return "CurvaDiCaricoId [dataCurva=" + dataCurva
				+ ", matricolaLenntCliente=" + matricolaLenntCliente
				+ ", numPeriodo=" + numPeriodo + "]";
	}
	
}
