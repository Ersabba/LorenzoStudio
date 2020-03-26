package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.persistence.dto.mgre.datatype.StatoClusterCabina;

public class ClusterCcsInterruttore implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 1L;
	
	private long idClusterInterruttore;
	private String codInterruttore;
	private String codConcentratore;
	private String idClusterCabina;
	private String codCabinaSecondaria;
	private String orarioInterruzione;
	private Date dataInterruzione;
	private StatoClusterCabina stato;
	
	public String getIdClusterCabina() {
		return idClusterCabina;
	}
	public void setIdClusterCabina(String idClusterCabina) {
		this.idClusterCabina = idClusterCabina;
	}
	public void setStatoAsEnum(StatoClusterCabina stato) {
		this.stato = stato;
	}
	public long getIdClusterInterruttore() {
		return idClusterInterruttore;
	}
	public void setIdClusterInterruttore(long idClusterCcs) {
		this.idClusterInterruttore = idClusterCcs;
	}
	public String getCodInterruttore() {
		return codInterruttore;
	}
	public void setCodInterruttore(String codInterruttore) {
		this.codInterruttore = codInterruttore;
	}
	public String getCodConcentratore() {
		return codConcentratore;
	}
	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}
	public String getCodCabinaSecondaria() {
		return codCabinaSecondaria;
	}
	public void setCodCabinaSecondaria(String codCabinaSecondaria) {
		this.codCabinaSecondaria = codCabinaSecondaria;
	}
	public String getOrarioInterruzione() {
		return orarioInterruzione;
	}
	public void setOrarioInterruzione(String orarioInterruzione) {
		this.orarioInterruzione = orarioInterruzione;
	}
	public Date getDataInterruzione() {
		return dataInterruzione;
	}
	public void setDataInterruzione(Date dataInterruzione) {
		this.dataInterruzione = dataInterruzione;
	}
	public StatoClusterCabina getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = StatoClusterCabina.valueOf(stato);
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
				+ ((codConcentratore == null) ? 0 : codConcentratore.hashCode());
		result = prime * result
				+ ((codInterruttore == null) ? 0 : codInterruttore.hashCode());
		result = prime
				* result
				+ ((dataInterruzione == null) ? 0 : dataInterruzione.hashCode());
		result = prime * result
				+ ((idClusterCabina == null) ? 0 : idClusterCabina.hashCode());
		result = prime
				* result
				+ (int) (idClusterInterruttore ^ (idClusterInterruttore >>> 32));
		result = prime
				* result
				+ ((orarioInterruzione == null) ? 0 : orarioInterruzione
						.hashCode());
		result = prime * result + ((stato == null) ? 0 : stato.hashCode());
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
		ClusterCcsInterruttore other = (ClusterCcsInterruttore) obj;
		if (codCabinaSecondaria == null) {
			if (other.codCabinaSecondaria != null)
				return false;
		} else if (!codCabinaSecondaria.equals(other.codCabinaSecondaria))
			return false;
		if (codConcentratore == null) {
			if (other.codConcentratore != null)
				return false;
		} else if (!codConcentratore.equals(other.codConcentratore))
			return false;
		if (codInterruttore == null) {
			if (other.codInterruttore != null)
				return false;
		} else if (!codInterruttore.equals(other.codInterruttore))
			return false;
		if (dataInterruzione == null) {
			if (other.dataInterruzione != null)
				return false;
		} else if (!dataInterruzione.equals(other.dataInterruzione))
			return false;
		if (idClusterCabina == null) {
			if (other.idClusterCabina != null)
				return false;
		} else if (!idClusterCabina.equals(other.idClusterCabina))
			return false;
		if (idClusterInterruttore != other.idClusterInterruttore)
			return false;
		if (orarioInterruzione == null) {
			if (other.orarioInterruzione != null)
				return false;
		} else if (!orarioInterruzione.equals(other.orarioInterruzione))
			return false;
		if (stato != other.stato)
			return false;
		return true;
	}
	
}
