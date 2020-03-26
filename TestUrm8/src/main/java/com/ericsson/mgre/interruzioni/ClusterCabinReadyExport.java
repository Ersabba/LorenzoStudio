package com.ericsson.mgre.interruzioni;

import java.io.Serializable;
import java.util.Date;


public class ClusterCabinReadyExport implements Serializable {

	private static final long	serialVersionUID	= -1L;
	
	private Date				timestampInterruzione;      // not null
	private String				codCabinaSecondaria;		// not null

	
	
	public ClusterCabinReadyExport() {
		super();
		
	}

	public ClusterCabinReadyExport(Date timestampInterruzione, String codCabinaSecondaria) {
		super();
		this.codCabinaSecondaria = codCabinaSecondaria;
		this.timestampInterruzione = timestampInterruzione;
	}

	public String getCodCabinaSecondaria() {
		return codCabinaSecondaria;
	}

	public void setCodCabinaSecondaria(String codCabinaSecondaria) {
		this.codCabinaSecondaria = codCabinaSecondaria;
	}

	public Date getTimestampInterruzione() {
		return timestampInterruzione;
	}

	public void setTimestampInterruzione(Date timestampInterruzione) {
		this.timestampInterruzione = timestampInterruzione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((codCabinaSecondaria == null) ? 0 : codCabinaSecondaria
						.hashCode());
		result = prime
				* result
				+ ((timestampInterruzione == null) ? 0 : timestampInterruzione
						.hashCode());
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
		ClusterCabinReadyExport other = (ClusterCabinReadyExport) obj;
		if (codCabinaSecondaria == null) {
			if (other.codCabinaSecondaria != null)
				return false;
		} else if (!codCabinaSecondaria.equals(other.codCabinaSecondaria))
			return false;
		if (timestampInterruzione == null) {
			if (other.timestampInterruzione != null)
				return false;
		} else if (!timestampInterruzione.equals(other.timestampInterruzione))
			return false;
		return true;
	}
		
}
