package com.ericsson.mgre.datatypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ericsson.urm.persistence.dto.mgre.ClusterCcs.StatoFileInterruzioni;

public class InterruzioneConcentratore implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String codConcentratore;
	private String codTrasformatore;
	private String matrTrasformatore;
	private StatoFileInterruzioni statoFileInterruzioni;
	private List<Interruttore> interruttori;
	
	public InterruzioneConcentratore() {}
	
	public InterruzioneConcentratore(String codConcentratore, StatoFileInterruzioni statoFileInterruzioni, List<Interruttore> interruttori) {
		super();
		this.codConcentratore = codConcentratore;
		this.interruttori = interruttori;
		this.statoFileInterruzioni = statoFileInterruzioni;
	}

	public String getCodConcentratore() {
		return codConcentratore;
	}

	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}
	
	public StatoFileInterruzioni getStatoFileInterruzioni() {
		return statoFileInterruzioni;
	}

	public void setStatoFileInterruzioni(StatoFileInterruzioni statoFileInterruzioni) {
		this.statoFileInterruzioni = statoFileInterruzioni;
	}

	public List<Interruttore> getInterruttori() {
		if(interruttori == null){
			interruttori = new ArrayList<Interruttore>();
		}
		return interruttori;
	}

	public void setInterruttori(List<Interruttore> interruttori) {
		this.interruttori = interruttori;
	}

	public String getCodTrasformatore() {
		return codTrasformatore;
	}

	public void setCodTrasformatore(String codTrasformatore) {
		this.codTrasformatore = codTrasformatore;
	}

	public String getMatrTrasformatore() {
		return matrTrasformatore;
	}

	public void setMatrTrasformatore(String matrTrasformatore) {
		this.matrTrasformatore = matrTrasformatore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((codConcentratore == null) ? 0 : codConcentratore.hashCode());
		result = prime
				* result
				+ ((codTrasformatore == null) ? 0 : codTrasformatore.hashCode());
		result = prime * result
				+ ((interruttori == null) ? 0 : interruttori.hashCode());
		result = prime
				* result
				+ ((matrTrasformatore == null) ? 0 : matrTrasformatore
						.hashCode());
		result = prime
				* result
				+ ((statoFileInterruzioni == null) ? 0 : statoFileInterruzioni
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
		InterruzioneConcentratore other = (InterruzioneConcentratore) obj;
		if (codConcentratore == null) {
			if (other.codConcentratore != null)
				return false;
		} else if (!codConcentratore.equals(other.codConcentratore))
			return false;
		if (codTrasformatore == null) {
			if (other.codTrasformatore != null)
				return false;
		} else if (!codTrasformatore.equals(other.codTrasformatore))
			return false;
		if (interruttori == null) {
			if (other.interruttori != null)
				return false;
		} else if (!interruttori.equals(other.interruttori))
			return false;
		if (matrTrasformatore == null) {
			if (other.matrTrasformatore != null)
				return false;
		} else if (!matrTrasformatore.equals(other.matrTrasformatore))
			return false;
		if (statoFileInterruzioni != other.statoFileInterruzioni)
			return false;
		return true;
	}
	
	
}
