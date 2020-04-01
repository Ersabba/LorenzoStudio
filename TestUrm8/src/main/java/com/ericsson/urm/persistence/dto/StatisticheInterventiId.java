package com.ericsson.urm.persistence.dto;

import java.io.Serializable;
import java.util.Date;


public class StatisticheInterventiId implements Serializable {

	private static final long	serialVersionUID	= -1L;

	private String	idIntervento;
	private Date	executionTimestamp;
	private String  nomeAttivita;
	private String  tipoIntervento;
	
	public static enum TipoIntervento {
		LETTURA, INTERVENTO;
		
		public String getDBCode() {
			return toString().substring(0,1);
		}
		
		public static TipoIntervento parse(String tipoIntervento) {
			for(TipoIntervento j : TipoIntervento.values()) {
				if(j.toString().equalsIgnoreCase(tipoIntervento)) {
					return j;
				}
				else
				if(j.getDBCode().equalsIgnoreCase(tipoIntervento)) {
					return j;
				}
			}
			throw new IllegalArgumentException("Esito 'TipoIntervento' sconosciuto, ricevuto :"+tipoIntervento);
		}
	}
	
	public StatisticheInterventiId() {
		
	}


	public StatisticheInterventiId(String idIntervento,
			Date executionTimestamp, String nomeAttivita, TipoIntervento tipoIntervento) {
		super();
		this.idIntervento = idIntervento;
		this.executionTimestamp = executionTimestamp;
		this.nomeAttivita = nomeAttivita;
		
		setTipoIntervento(tipoIntervento);
	}

	public String getIdIntervento() {
		return idIntervento;
	}

	public void setIdIntervento(String idIntervento) {
		this.idIntervento = idIntervento;
	}

	public Date getExecutionTimestamp() {
		return executionTimestamp;
	}

	public void setExecutionTimestamp(Date executionTimestamp) {
		this.executionTimestamp = executionTimestamp;
	}
	
	public TipoIntervento getTipoIntervento() {
		return tipoIntervento !=null ? TipoIntervento.parse(tipoIntervento) : null;
	}

	public void setTipoIntervento(TipoIntervento tipoIntervento) {
		this.tipoIntervento = tipoIntervento != null ? tipoIntervento.getDBCode() : null;
	}
	
	public String getNomeAttivita() {
		return nomeAttivita;
	}


	public void setNomeAttivita(String nomeAttivita) {
		this.nomeAttivita = nomeAttivita;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((executionTimestamp == null) ? 0 : executionTimestamp
						.hashCode());
		result = prime * result
				+ ((idIntervento == null) ? 0 : idIntervento.hashCode());
		result = prime * result
				+ ((nomeAttivita == null) ? 0 : nomeAttivita.hashCode());
		result = prime * result
				+ ((tipoIntervento == null) ? 0 : tipoIntervento.hashCode());
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
		StatisticheInterventiId other = (StatisticheInterventiId) obj;
		if (executionTimestamp == null) {
			if (other.executionTimestamp != null)
				return false;
		} else if (!executionTimestamp.equals(other.executionTimestamp))
			return false;
		if (idIntervento == null) {
			if (other.idIntervento != null)
				return false;
		} else if (!idIntervento.equals(other.idIntervento))
			return false;
		if (nomeAttivita == null) {
			if (other.nomeAttivita != null)
				return false;
		} else if (!nomeAttivita.equals(other.nomeAttivita))
			return false;
		if (tipoIntervento == null) {
			if (other.tipoIntervento != null)
				return false;
		} else if (!tipoIntervento.equals(other.tipoIntervento))
			return false;
		return true;
	}

}
