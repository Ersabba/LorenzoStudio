package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

public class LenntTrasformatore implements Serializable {
	private final static long serialVersionUID = -1;
	
	private String matricolaLennt=null;
	private String codConcentratore=null;
	private String statoLennt=null;
	private String raggiungLennt;
	
	private Long codSbarraBT=null;
	
	private Date ultimoContatto = null;

	public String getMatricolaLennt() {
		return matricolaLennt;
	}

	public void setMatricolaLennt(String matricolaLennt) {
		this.matricolaLennt = matricolaLennt;
	}

	public String getCodConcentratore() {
		return codConcentratore;
	}

	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}

	public String getStatoLennt() {
		return statoLennt;
	}

	public void setStatoLennt(String statoLennt) {
		this.statoLennt = statoLennt;
	}

	public String getRaggiungLennt() {
		return raggiungLennt;
	}

	public void setRaggiungLennt(String raggiungLennt) {
		this.raggiungLennt = raggiungLennt;
	}

	public Long getCodSbarraBT() {
		return codSbarraBT;
	}

	public void setCodSbarraBT(Long codSbarraBT) {
		this.codSbarraBT = codSbarraBT;
	}

	public Date getUltimoContatto() {
		return ultimoContatto;
	}

	public void setUltimoContatto(Date ultimoContatto) {
		this.ultimoContatto = ultimoContatto;
	}

	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((codConcentratore == null) ? 0 : codConcentratore.hashCode());
		result = prime * result
				+ ((codSbarraBT == null) ? 0 : codSbarraBT.hashCode());
		result = prime * result
				+ ((matricolaLennt == null) ? 0 : matricolaLennt.hashCode());
		result = prime * result
				+ ((raggiungLennt == null) ? 0 : raggiungLennt.hashCode());
		result = prime * result
				+ ((statoLennt == null) ? 0 : statoLennt.hashCode());
		result = prime * result
				+ ((ultimoContatto == null) ? 0 : ultimoContatto.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final LenntTrasformatore other = (LenntTrasformatore) obj;
		if (codConcentratore == null) {
			if (other.codConcentratore != null)
				return false;
		} else if (!codConcentratore.equals(other.codConcentratore))
			return false;
		if (codSbarraBT == null) {
			if (other.codSbarraBT != null)
				return false;
		} else if (!codSbarraBT.equals(other.codSbarraBT))
			return false;
		if (matricolaLennt == null) {
			if (other.matricolaLennt != null)
				return false;
		} else if (!matricolaLennt.equals(other.matricolaLennt))
			return false;
		if (raggiungLennt == null) {
			if (other.raggiungLennt != null)
				return false;
		} else if (!raggiungLennt.equals(other.raggiungLennt))
			return false;
		if (statoLennt == null) {
			if (other.statoLennt != null)
				return false;
		} else if (!statoLennt.equals(other.statoLennt))
			return false;
		if (ultimoContatto == null) {
			if (other.ultimoContatto != null)
				return false;
		} else if (!ultimoContatto.equals(other.ultimoContatto))
			return false;
		return true;
	}

	

	
	
	
}
