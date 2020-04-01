package com.ericsson.urm.persistence.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GRE_LENNT_REGISTRI_STORICI")
public class RecuperoLenntRegistriStorici implements Serializable {

	private static final long serialVersionUID = -1L;
	
	@Id
	@Column(name = "MATRICOLA_LENNT_CLIENTE")
	private String meterId = null;

	@Column(name = "DATA_INSERIMENTO")
	private Date dataInserimento = null;

	
	@Column(name = "DATA_LAVORAZIONE")
	private Date dataLavorazione = null;

	
	public RecuperoLenntRegistriStorici() {
		super();
	}


	public String getMeterId() {
		return meterId;
	}


	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}


	public Date getDataInserimento() {
		return dataInserimento;
	}


	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}


	public Date getDataLavorazione() {
		return dataLavorazione;
	}


	public void setDataLavorazione(Date dataLavorazione) {
		this.dataLavorazione = dataLavorazione;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataInserimento == null) ? 0 : dataInserimento.hashCode());
		result = prime * result + ((dataLavorazione == null) ? 0 : dataLavorazione.hashCode());
		result = prime * result + ((meterId == null) ? 0 : meterId.hashCode());
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
		RecuperoLenntRegistriStorici other = (RecuperoLenntRegistriStorici) obj;
		if (dataInserimento == null) {
			if (other.dataInserimento != null)
				return false;
		} else if (!dataInserimento.equals(other.dataInserimento))
			return false;
		if (dataLavorazione == null) {
			if (other.dataLavorazione != null)
				return false;
		} else if (!dataLavorazione.equals(other.dataLavorazione))
			return false;
		if (meterId == null) {
			if (other.meterId != null)
				return false;
		} else if (!meterId.equals(other.meterId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "RecuperoLenntRegistriStoriciExt [meterId=" + meterId + ", dataInserimento=" + dataInserimento
				+ ", dataLavorazione=" + dataLavorazione + "]";
	}

}
