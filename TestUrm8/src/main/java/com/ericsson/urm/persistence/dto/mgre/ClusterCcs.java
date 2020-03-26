package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

public class ClusterCcs implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	
	public enum StatoFileInterruzioni {
		FILE_DA_ACQUISIRE("FILE_DA_ACQUISIRE"),
		FILE_TROVATO("FILE_TROVATO"),
		FILE_NON_TROVATO("FILE_NON_TROVATO"),
		FILE_ELABORATO("FILE_ELABORATO");
		
		private String state;

		private StatoFileInterruzioni(String state) {
			this.state = state;
		}
		
		public String getState() {
			return state;
		}
		
		public static StatoFileInterruzioni parse(String state)	{
			for (StatoFileInterruzioni curr : StatoFileInterruzioni.values()) {
				if(curr.state.equalsIgnoreCase(state)) { return curr; }
			}
		
			throw new IllegalArgumentException ("StatoFileInterruzioni: unsupported state: " + state);
		}
	}
	
	public enum StatoFileLogInterruzioni {
		A,	//ACQUISIZIONE effettuata con successo
		N,	//ACQUISIZIONE TERMINATA ( FILE_NOT_FOUND)
		F,	//ACQUISIZIONE da effettuare o fallita
		E;	//elaborazione TERMINATA
		
		public static StatoFileLogInterruzioni parse(char typeName) {	
			return parse(Character.toString(typeName));
		}
		
		public static StatoFileLogInterruzioni parse(String typeName)	{	
			for (StatoFileLogInterruzioni curr : StatoFileLogInterruzioni.values()) {
				if(curr.toString().equalsIgnoreCase(typeName)) { return curr; }
			}
			
			throw new IllegalArgumentException ("Status: unsupported type name " + typeName);
		}		
	}
	
	private Long idClusterCcs;
	private String codConcentratore;
	private String statoFileInterruzioni;
	private String statoFileLogInterruzioni;
	
	private String codTrasformatore;
	private String matricolaTrasformatore;
	
	private ClusterCabina clusterCabina;	
	private Set<ClusterInterruttore> interruttori = new LinkedHashSet<ClusterInterruttore>(0);
	
	public ClusterCcs() {}

	
	public Long getIdClusterCcs() {
		return idClusterCcs;
	}

	public void setIdClusterCcs(Long idClusterCcs) {
		this.idClusterCcs = idClusterCcs;
	}

	public String getCodConcentratore() {
		return codConcentratore;
	}

	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}

	public StatoFileInterruzioni getStatoFileInterruzioni() {
		return statoFileInterruzioni != null ? StatoFileInterruzioni.parse(statoFileInterruzioni) : null;
	}
	
	public void setStatoFileInterruzioni(String statoFileInterruzioni) {
		this.statoFileInterruzioni = statoFileInterruzioni;
	}

	public void setStatoFileInterruzioni(StatoFileInterruzioni statoFileInterruzioni) {
		this.statoFileInterruzioni = statoFileInterruzioni !=null ? statoFileInterruzioni.getState() : null;
	}

	public ClusterCabina getClusterCabina() {
		return clusterCabina;
	}

	public void setClusterCabina(ClusterCabina clusterCabina) {
		this.clusterCabina = clusterCabina;
	}

	public Set<ClusterInterruttore> getInterruttori() {
		return interruttori;
	}

	public void setInterruttori(Set<ClusterInterruttore> interruttori) {
		this.interruttori = interruttori;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCodTrasformatore() {
		return codTrasformatore;
	}

	public void setCodTrasformatore(String codTrasformatore) {
		this.codTrasformatore = codTrasformatore;
	}

	public String getMatricolaTrasformatore() {
		return matricolaTrasformatore;
	}

	public void setMatricolaTrasformatore(String matricolaTrasformatore) {
		this.matricolaTrasformatore = matricolaTrasformatore;
	}
	
	public ClusterCcs.StatoFileLogInterruzioni[] getStatoFileLogInterruzioni() {
		return strToStatus(statoFileLogInterruzioni);
	}

	public void setStatoFileLogInterruzioni(ClusterCcs.StatoFileLogInterruzioni[] aStatus) {
		this.statoFileLogInterruzioni = statusToString(aStatus);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codConcentratore == null) ? 0 : codConcentratore.hashCode());
		result = prime * result + ((codTrasformatore == null) ? 0 : codTrasformatore.hashCode());
//		result = prime * result + ((idClusterCcs == null) ? 0 : idClusterCcs.hashCode());
		result = prime * result + ((matricolaTrasformatore == null) ? 0 : matricolaTrasformatore.hashCode());
		result = prime * result + ((statoFileInterruzioni == null) ? 0 : statoFileInterruzioni.hashCode());
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
		ClusterCcs other = (ClusterCcs) obj;
		if (codConcentratore == null) {
			if (other.codConcentratore != null)
				return false;
		}
		else if (!codConcentratore.equals(other.codConcentratore))
			return false;
		if (codTrasformatore == null) {
			if (other.codTrasformatore != null)
				return false;
		}
		else if (!codTrasformatore.equals(other.codTrasformatore))
			return false;
//		if (idClusterCcs == null) {
//			if (other.idClusterCcs != null)
//				return false;
//		}
//		else if (!idClusterCcs.equals(other.idClusterCcs))
//			return false;
		if (matricolaTrasformatore == null) {
			if (other.matricolaTrasformatore != null)
				return false;
		}
		else if (!matricolaTrasformatore.equals(other.matricolaTrasformatore))
			return false;
		if (statoFileInterruzioni == null) {
			if (other.statoFileInterruzioni != null)
				return false;
		}
		else if (!statoFileInterruzioni.equals(other.statoFileInterruzioni))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClusterCcs [idClusterCcs=" + idClusterCcs + ", codConcentratore=" + codConcentratore + ", statoFileInterruzioni="
				+ statoFileInterruzioni + ", codTrasformatore=" + codTrasformatore + ", matricolaTrasformatore=" + matricolaTrasformatore + "]";
	}
	
	private static ClusterCcs.StatoFileLogInterruzioni[] strToStatus(String status) {
		ClusterCcs.StatoFileLogInterruzioni[] aStatus = null;
		if(status!=null) {
			aStatus = new ClusterCcs.StatoFileLogInterruzioni[status.length()];
			int j=0;
			for(char ch : status.toCharArray()) {
				aStatus[j++] = ClusterCcs.StatoFileLogInterruzioni.parse(ch);
			}
		}
		return aStatus;
	}
	
	private static String statusToString(ClusterCcs.StatoFileLogInterruzioni[] aStatus) {
		String status = null;
		if(aStatus!=null) {
			status = "";
			for(ClusterCcs.StatoFileLogInterruzioni curr : aStatus) {
				status += curr.toString();
			}
		}
		return status;
	}
}
