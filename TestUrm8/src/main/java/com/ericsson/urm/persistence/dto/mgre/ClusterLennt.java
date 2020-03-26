package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

public class ClusterLennt implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	
	private Long idClusterLennt;
	private String matricolaLenntCliente;
	private Date timestampInterrRil;
	private Date timestampInserimento;
	private int confidenzaAssociazione;
	private ClusterInterruttore interruttore;
	
	public static enum Confidenza {
		ASSOCIATO_CORRISPONDENZA_TEMPORALE(1), 
		ASSOCIATO_CORRISPONDENZA_DISTANZE(2),
		ASSOCIATO_STESSO_GEO_MONOLINEA(3), 
		ASSOCIATO_STESSO_GEO_MULTILINEA(4), 
		NON_ASSOCIABILE(5); /*
							 * Comprende LENNT presenti nelle rilevate e per cui esiste una lettura recente ma non associabili (A),
							 * insieme a quei lennt elettromeccanici e mai letti, che hanno lo stesso codice GEO di quelli (A)
							 */

		private int	value;

		private Confidenza(int value) {
			this.value = value;
		}

		public int value() {
			return value;
		}
	}
	
	public ClusterLennt() {}

	public ClusterLennt(Long idClusterLennt, String matricolaLenntCliente,
			Date timestampInterrRil, Date timestampInserimento, int confidenzaAssociazione,
			ClusterInterruttore interruttore) {
		super();
		this.idClusterLennt = idClusterLennt;
		this.matricolaLenntCliente = matricolaLenntCliente;
		this.timestampInterrRil = timestampInterrRil;
		this.timestampInserimento = timestampInserimento;
		this.confidenzaAssociazione = confidenzaAssociazione;
		this.interruttore = interruttore;
	}

	
	public Long getIdClusterLennt() {
		return idClusterLennt;
	}

	public void setIdClusterLennt(Long idClusterLennt) {
		this.idClusterLennt = idClusterLennt;
	}

	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}

	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}

	public Date getTimestampInterrRil() {
		return timestampInterrRil;
	}

	public void setTimestampInterrRil(Date timestampInterrRil) {
		this.timestampInterrRil = timestampInterrRil;
	}

	public Date getTimestampInserimento() {
		return timestampInserimento;
	}

	public void setTimestampInserimento(Date timestampInserimento) {
		this.timestampInserimento = timestampInserimento;
	}

	public Confidenza getConfidenzaAssociazione() {
		for (Confidenza c : Confidenza.values())
			if (c.value == confidenzaAssociazione)
				return c;
		throw new IllegalArgumentException("Confidenza di valore " + confidenzaAssociazione + " non riconosciuta");
	}

	public void setConfidenzaAssociazione(Confidenza confidenzaAssociazione) {
		this.confidenzaAssociazione = confidenzaAssociazione.value;
	}

	public ClusterInterruttore getInterruttore() {
		return interruttore;
	}

	public void setInterruttore(ClusterInterruttore interruttore) {
		this.interruttore = interruttore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + confidenzaAssociazione;
//		result = prime * result + ((idClusterLennt == null) ? 0 : idClusterLennt.hashCode());
		result = prime * result + ((matricolaLenntCliente == null) ? 0 : matricolaLenntCliente.hashCode());
		result = prime * result + ((timestampInserimento == null) ? 0 : timestampInserimento.hashCode());
		result = prime * result + ((timestampInterrRil == null) ? 0 : timestampInterrRil.hashCode());
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
		ClusterLennt other = (ClusterLennt) obj;
		if (confidenzaAssociazione != other.confidenzaAssociazione)
			return false;
//		if (idClusterLennt == null) {
//			if (other.idClusterLennt != null)
//				return false;
//		}
//		else if (!idClusterLennt.equals(other.idClusterLennt))
//			return false;
		if (matricolaLenntCliente == null) {
			if (other.matricolaLenntCliente != null)
				return false;
		}
		else if (!matricolaLenntCliente.equals(other.matricolaLenntCliente))
			return false;
		if (timestampInserimento == null) {
			if (other.timestampInserimento != null)
				return false;
		}
		else if (!timestampInserimento.equals(other.timestampInserimento))
			return false;
		if (timestampInterrRil == null) {
			if (other.timestampInterrRil != null)
				return false;
		}
		else if (!timestampInterrRil.equals(other.timestampInterrRil))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClusterLennt [id=" + idClusterLennt + ", matrLenntCliente=" + matricolaLenntCliente + ", timestampInterrRil="
				+ timestampInterrRil + ", confidenza=" + confidenzaAssociazione + "]";
	}
}
