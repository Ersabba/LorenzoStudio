package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public class ClusterInterruttore implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	private Long idClusterInterruttore;
	private String codInterruttore;
	private String oraInterrProvoc;
	private Integer secondiDurataInterruzione;
	private String statoInterrutore;
	private Integer tensioneInVolt;
	private String primoSportello;
	private String formazioneCavo;	
	private String tipo;
	private ClusterCcs clusterCcs;
	private Set<ClusterLennt> clusterLenntSet = new HashSet<ClusterLennt>(0);
	
	private Long volatileTimestamp = null; // non mappato
	private int volatileHashOraData = 0; // non mappato
	
	public static final int CODICE_FITTIZIO = 99;
	
	public static enum ErroreRecordCsv {
		CCS_ERRATO("CCS_ERRATO"),
		ORA_INTERR_ERRATA("ORA_INTERR_ERRATA"),
		ORA_INTERR_DUPLICATA("ORA_INTERR_DUPLICATA");
		
		private String error;

		private ErroreRecordCsv(String error) {
			this.error = error;
		}
		
		public String getError() {
			return error;
		}
		
		public static ErroreRecordCsv parse(String error)	{
			for (ErroreRecordCsv curr : ErroreRecordCsv.values()) {
				if(curr.error.equalsIgnoreCase(error)) { return curr; }
			}
		
			throw new IllegalArgumentException ("ErroreRecordCsv: unsupported error: " + error);
		}
	}
	
	public static enum TipoInterruttore {
		STANDARD("STANDARD"), 
		FITTIZIO("FITTIZIO"),
		APERTO("APERTO");
		
		private String value;
		
		private TipoInterruttore(String value) {
			this.value = value;
		}
		
		public String value() {
			return this.value;
		}
	}
	
	public ClusterInterruttore() {}

	public ClusterInterruttore(Long idClusterInterruttore, String codInterruttore,
			String oraInterrProvoc, ClusterCcs clusterCcs,
			Set<ClusterLennt> clusterLenntSet) {
		super();
		this.idClusterInterruttore = idClusterInterruttore;
		this.codInterruttore = codInterruttore;
		this.oraInterrProvoc = oraInterrProvoc;
		this.clusterCcs = clusterCcs;
		this.clusterLenntSet = clusterLenntSet;
	}
	
	public boolean isFittizio() {
		return TipoInterruttore.FITTIZIO.equals(this.getTipo());
	}

	public Long calcolaTimestampInterruzione() {
		if (oraInterrProvoc == null || clusterCcs == null || clusterCcs.getClusterCabina() == null || clusterCcs.getClusterCabina().getDataInterruzione() == null)
			return null;
		int nuovoHash = ("" + oraInterrProvoc + clusterCcs.getClusterCabina().getDataInterruzione()).hashCode();
		if (volatileHashOraData == nuovoHash)
			return volatileTimestamp;
		volatileHashOraData = nuovoHash;
		String[] hhmm = oraInterrProvoc.split(":");
		Calendar cal = new GregorianCalendar();
		cal.setTimeInMillis(clusterCcs.getClusterCabina().getDataInterruzione().getTime());
		cal.setLenient(false);
		cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hhmm[0]));
		cal.set(Calendar.MINUTE, Integer.parseInt(hhmm[1]));
		volatileTimestamp = cal.getTimeInMillis();
		return volatileTimestamp;
	}	

	public Long getIdClusterInterruttore() {
		return idClusterInterruttore;
	}

	public void setIdClusterInterruttore(Long idClusterInterruttore) {
		this.idClusterInterruttore = idClusterInterruttore;
	}

	public String getCodInterruttore() {
		return codInterruttore;
	}

	public void setCodInterruttore(String codInterruttore) {
		this.codInterruttore = codInterruttore;
	}

	public String getOraInterrProvoc() {
		return oraInterrProvoc;
	}

	public void setOraInterrProvoc(String oraInterrProvoc) {
		this.oraInterrProvoc = oraInterrProvoc;
	}
	
	public TipoInterruttore getTipo() {
		for (TipoInterruttore t : TipoInterruttore.values())
			if (t.value.equals(this.tipo))
				return t;
		throw new IllegalArgumentException("Tipo interruttore non supportato:" + this.tipo);
	}
	
	public void setTipo(TipoInterruttore tipo) {
		this.tipo = tipo.value;
	}

	public ClusterCcs getClusterCcs() {
		return clusterCcs;
	}

	public void setClusterCcs(ClusterCcs clusterCcs) {
		this.clusterCcs = clusterCcs;
	}

	public Set<ClusterLennt> getClusterLenntSet() {
		return clusterLenntSet;
	}

	public void setClusterLenntSet(Set<ClusterLennt> clusterLenntSet) {
		this.clusterLenntSet = clusterLenntSet;
	}
	
	public Integer getSecondiDurataInterruzione() {
		return secondiDurataInterruzione;
	}

	public void setSecondiDurataInterruzione(Integer secondiDurataInterruzione) {
		this.secondiDurataInterruzione = secondiDurataInterruzione;
	}

	public String getStatoInterrutore() {
		return statoInterrutore;
	}

	public void setStatoInterrutore(String statoInterrutore) {
		this.statoInterrutore = statoInterrutore;
	}

	public Integer getTensioneInVolt() {
		return tensioneInVolt;
	}

	public void setTensioneInVolt(Integer tensioneInVolt) {
		this.tensioneInVolt = tensioneInVolt;
	}

	public String getPrimoSportello() {
		return primoSportello;
	}

	public void setPrimoSportello(String primoSportello) {
		this.primoSportello = primoSportello;
	}

	public String getFormazioneCavo() {
		return formazioneCavo;
	}

	public void setFormazioneCavo(String formazioneCavo) {
		this.formazioneCavo = formazioneCavo;
	}
	
	public Long getVolatileTimestamp() {
		return volatileTimestamp;
	}

	public void setVolatileTimestamp(Long volatileTimestamp) {
		this.volatileTimestamp = volatileTimestamp;
	}

	public int getVolatileHashOraData() {
		return volatileHashOraData;
	}

	public void setVolatileHashOraData(int volatileHashOraData) {
		this.volatileHashOraData = volatileHashOraData;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codInterruttore == null) ? 0 : codInterruttore.hashCode());
		result = prime * result + ((formazioneCavo == null) ? 0 : formazioneCavo.hashCode());
//		result = prime * result + ((idClusterInterruttore == null) ? 0 : idClusterInterruttore.hashCode());
		result = prime * result + ((oraInterrProvoc == null) ? 0 : oraInterrProvoc.hashCode());
		result = prime * result + ((primoSportello == null) ? 0 : primoSportello.hashCode());
		result = prime * result + ((secondiDurataInterruzione == null) ? 0 : secondiDurataInterruzione.hashCode());
		result = prime * result + ((statoInterrutore == null) ? 0 : statoInterrutore.hashCode());
		result = prime * result + ((tensioneInVolt == null) ? 0 : tensioneInVolt.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		ClusterInterruttore other = (ClusterInterruttore) obj;
		if (codInterruttore == null) {
			if (other.codInterruttore != null)
				return false;
		}
		else if (!codInterruttore.equals(other.codInterruttore))
			return false;
		if (formazioneCavo == null) {
			if (other.formazioneCavo != null)
				return false;
		}
		else if (!formazioneCavo.equals(other.formazioneCavo))
			return false;
//		if (idClusterInterruttore == null) {
//			if (other.idClusterInterruttore != null)
//				return false;
//		}
//		else if (!idClusterInterruttore.equals(other.idClusterInterruttore))
//			return false;
		if (oraInterrProvoc == null) {
			if (other.oraInterrProvoc != null)
				return false;
		}
		else if (!oraInterrProvoc.equals(other.oraInterrProvoc))
			return false;
		if (primoSportello == null) {
			if (other.primoSportello != null)
				return false;
		}
		else if (!primoSportello.equals(other.primoSportello))
			return false;
		if (secondiDurataInterruzione == null) {
			if (other.secondiDurataInterruzione != null)
				return false;
		}
		else if (!secondiDurataInterruzione.equals(other.secondiDurataInterruzione))
			return false;
		if (statoInterrutore == null) {
			if (other.statoInterrutore != null)
				return false;
		}
		else if (!statoInterrutore.equals(other.statoInterrutore))
			return false;
		if (tensioneInVolt == null) {
			if (other.tensioneInVolt != null)
				return false;
		}
		else if (!tensioneInVolt.equals(other.tensioneInVolt))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		}
		else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClusterInterruttore [idClusterInterruttore=" + idClusterInterruttore + ", codInterruttore=" + codInterruttore + ", oraInterrProvoc="
				+ oraInterrProvoc + ", secondiDurataInterruzione=" + secondiDurataInterruzione + ", statoInterrutore=" + statoInterrutore
				+ ", tensioneInVolt=" + tensioneInVolt + ", primoSportello=" + primoSportello + ", formazioneCavo=" + formazioneCavo 
				+ ", tipo=" + tipo + ", clusterCcs=" + clusterCcs + ", clusterLenntSet=" + clusterLenntSet + ", volatileTimestamp="
				+ volatileTimestamp + ", volatileHashOraData=" + volatileHashOraData + "]";
	}
}
