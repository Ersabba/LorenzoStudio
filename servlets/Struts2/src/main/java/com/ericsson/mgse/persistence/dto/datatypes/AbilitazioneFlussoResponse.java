package com.ericsson.mgse.persistence.dto.datatypes;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.List;

public class AbilitazioneFlussoResponse  implements Serializable {
	private static final long serialVersionUID = -1;
	
	
	public enum FLowResponse{
		SUCCESS("SUCCESS"),
		PARTIAL_SUCCESS("PARTIAL_SUCCESS"),
		FAILED("FAILED");
		
		private String responseType;
		private FLowResponse(String responseType){
			this.responseType = responseType;
		}
		public String getResponseType() {
			return responseType;
		}
		
		public FLowResponse parse(String responseType){
			if (responseType == null)
				return null;
			for (FLowResponse tu : FLowResponse.values())
				if (tu.responseType.equalsIgnoreCase(responseType))
					return tu;
			
			throw new IllegalArgumentException("Invalid response:" + responseType);
	}
		
		
	}
	
	public class SistemaEsterno implements Serializable {
		private static final long serialVersionUID = -1;
		
		private String nomeSistemaEsterno;
		private PollerStatus statoFlusso;
		private FLowResponse esitoFlusso;
		
		public SistemaEsterno() {}

		public SistemaEsterno(String nomeSistemaEsterno, PollerStatus statoFlusso, FLowResponse esitoFlusso) {
			super();
			this.nomeSistemaEsterno = nomeSistemaEsterno;
			this.statoFlusso = statoFlusso;
			this.esitoFlusso = esitoFlusso;
		}

		public String getNomeSistemaEsterno() {
			return nomeSistemaEsterno;
		}

		public void setNomeSistemaEsterno(String nomeSistemaEsterno) {
			this.nomeSistemaEsterno = nomeSistemaEsterno;
		}

		public PollerStatus getStatoFlusso() {
			return statoFlusso;
		}

		public void setStatoFlusso(PollerStatus statoFlusso) {
			this.statoFlusso = statoFlusso;
		}

		public FLowResponse getEsitoFlusso() {
			return esitoFlusso;
		}

		public void setEsitoFlusso(FLowResponse esitoFlusso) {
			this.esitoFlusso = esitoFlusso;
		}

		@Override
		public String toString() {
			return "SistemaEsterno [nomeSistemaEsterno=" + nomeSistemaEsterno + ", statoFlusso=" + statoFlusso
					+ ", esitoFlusso=" + esitoFlusso + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((esitoFlusso == null) ? 0 : esitoFlusso.hashCode());
			result = prime * result + ((nomeSistemaEsterno == null) ? 0 : nomeSistemaEsterno.hashCode());
			result = prime * result + ((statoFlusso == null) ? 0 : statoFlusso.hashCode());
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
			SistemaEsterno other = (SistemaEsterno) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (esitoFlusso != other.esitoFlusso)
				return false;
			if (nomeSistemaEsterno == null) {
				if (other.nomeSistemaEsterno != null)
					return false;
			} else if (!nomeSistemaEsterno.equals(other.nomeSistemaEsterno))
				return false;
			if (statoFlusso != other.statoFlusso)
				return false;
			return true;
		}

		private AbilitazioneFlussoResponse getOuterType() {
			return AbilitazioneFlussoResponse.this;
		}

	}

	private FLowResponse esito;
	private String idFlusso;
	private SistemaEsterno sistemaEsternoCorrente;
	private Hashtable<FLowResponse, List<SistemaEsterno>> esFlussiReplicati;
	
	public AbilitazioneFlussoResponse() {
		super();
	}

	public FLowResponse getEsito() {
		return esito;
	}

	public void setEsito(FLowResponse esito) {
		this.esito = esito;
	}

	public String getIdFlusso() {
		return idFlusso;
	}

	public void setIdFlusso(String idFlusso) {
		this.idFlusso = idFlusso;
	}

	public SistemaEsterno getSistemaEsternoCorrente() {
		return sistemaEsternoCorrente;
	}

	public void setSistemaEsternoCorrente(SistemaEsterno sistemaEsternoCorrente) {
		this.sistemaEsternoCorrente = sistemaEsternoCorrente;
	}

	public Hashtable<FLowResponse, List<SistemaEsterno>> getEsFlussiReplicati() {
		return esFlussiReplicati;
	}

	public void setEsFlussiReplicati(Hashtable<FLowResponse, List<SistemaEsterno>> esFlussiReplicati) {
		this.esFlussiReplicati = esFlussiReplicati;
	}

	@Override
	public String toString() {
		return "AbilitazioneFlussoResponse [esito=" + esito + ", idFlusso=" + idFlusso + ", sistemaEsternoCorrente="
				+ sistemaEsternoCorrente + ", esFlussiReplicati=" + esFlussiReplicati + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((esFlussiReplicati == null) ? 0 : esFlussiReplicati.hashCode());
		result = prime * result + ((esito == null) ? 0 : esito.hashCode());
		result = prime * result + ((idFlusso == null) ? 0 : idFlusso.hashCode());
		result = prime * result + ((sistemaEsternoCorrente == null) ? 0 : sistemaEsternoCorrente.hashCode());
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
		AbilitazioneFlussoResponse other = (AbilitazioneFlussoResponse) obj;
		if (esFlussiReplicati == null) {
			if (other.esFlussiReplicati != null)
				return false;
		} else if (!esFlussiReplicati.equals(other.esFlussiReplicati))
			return false;
		if (esito != other.esito)
			return false;
		if (idFlusso == null) {
			if (other.idFlusso != null)
				return false;
		} else if (!idFlusso.equals(other.idFlusso))
			return false;
		if (sistemaEsternoCorrente == null) {
			if (other.sistemaEsternoCorrente != null)
				return false;
		} else if (!sistemaEsternoCorrente.equals(other.sistemaEsternoCorrente))
			return false;
		return true;
	}
	
	
}
