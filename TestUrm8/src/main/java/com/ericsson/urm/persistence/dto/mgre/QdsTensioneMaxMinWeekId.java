package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

public class QdsTensioneMaxMinWeekId implements Serializable {
	private static final long serialVersionUID = -1;
	
	private String	matricolaLennt;
	private Date 	dataRil;
	
	public QdsTensioneMaxMinWeekId() {
		
	}

	public QdsTensioneMaxMinWeekId(String matricolaLennt, Date dataRil) {
		super();
		this.matricolaLennt = matricolaLennt;
		this.dataRil = dataRil;
	}

	public String getMatricolaLennt() {
		return matricolaLennt;
	}

	public void setMatricolaLennt(String matricolaLennt) {
		this.matricolaLennt = matricolaLennt;
	}

	public Date getDataRil() {
		return dataRil;
	}

	public void setDataRil(Date dataRil) {
		this.dataRil = dataRil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataRil == null) ? 0 : dataRil.hashCode());
		result = prime * result
				+ ((matricolaLennt == null) ? 0 : matricolaLennt.hashCode());
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
		QdsTensioneMaxMinWeekId other = (QdsTensioneMaxMinWeekId) obj;
		if (dataRil == null) {
			if (other.dataRil != null)
				return false;
		} else if (!dataRil.equals(other.dataRil))
			return false;
		if (matricolaLennt == null) {
			if (other.matricolaLennt != null)
				return false;
		} else if (!matricolaLennt.equals(other.matricolaLennt))
			return false;
		return true;
	}


	
}
