package com.ericsson.urm.persistence.dto.mgre;



public class StatoConcentratoreId implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private String codConcentratore;
	private String nomeParametro;
	
	
	public StatoConcentratoreId() {}

	public StatoConcentratoreId(String codConcentratore, String nomeParametro) {
		this.codConcentratore = codConcentratore;
		this.nomeParametro = nomeParametro;
	}

	public String getCodConcentratore() {
		return codConcentratore;
	}

	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}

	public String getNomeParametro() {
		return nomeParametro;
	}

	public void setNomeParametro(String nomeParametro) {
		this.nomeParametro = nomeParametro;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((codConcentratore == null) ? 0 : codConcentratore.hashCode());
		result = prime * result
				+ ((nomeParametro == null) ? 0 : nomeParametro.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final StatoConcentratoreId other = (StatoConcentratoreId) obj;
		if (codConcentratore == null) {
			if (other.codConcentratore != null)
				return false;
		} else if (!codConcentratore.equals(other.codConcentratore))
			return false;
		if (nomeParametro == null) {
			if (other.nomeParametro != null)
				return false;
		} else if (!nomeParametro.equals(other.nomeParametro))
			return false;
		return true;
	}
}