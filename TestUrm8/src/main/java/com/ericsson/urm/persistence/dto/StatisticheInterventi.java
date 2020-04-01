package com.ericsson.urm.persistence.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StatisticheInterventi implements Serializable {

	private static final long	serialVersionUID	= -1L;
	
	private StatisticheInterventiId id;
	private String  comandiDaEseguire;
	private String  comandiEseguiti;
	private int     cmdBTSuccess;
	private String  esitoIntervento;
	
		
	public static enum EsitoIntervento {
		SUCCESSFUL("ESEGUITO_CON_SUCCESSO"),
		FAILED("FALLITO"),
		PARTIALLY_FAILED("PARZIALMENTE_FALLITO");
		
		private String localizedResult = null;

		private EsitoIntervento(String localizedResult) {
			this.localizedResult = localizedResult;
		}
		
		public static EsitoIntervento parse(String localizedResult) {
			for(EsitoIntervento curr : EsitoIntervento.values()) {
				if(curr.localizedResult.equalsIgnoreCase(localizedResult)) {
					return curr;
				}
			}
			throw new IllegalArgumentException("Unknown 'EsitoIntervento' with localized result:"+localizedResult);
		}

		public String getLocalizedResult() {
			return localizedResult;
		}
	}
	
	public StatisticheInterventi() {
		
	}

	public StatisticheInterventi(StatisticheInterventiId id,
								 List<String> comandiDaEseguire,
								 List<String> comandiEseguiti,
								 EsitoIntervento esitoIntervento) {
		super();
		
		this.id = id;
		
		setComandiDaEseguire(comandiDaEseguire);
		setComandiEseguiti(comandiEseguiti);
		setEsitoIntervento(esitoIntervento);
	}
	
	private static String formatListToCsv(List<String> list) {
		StringBuffer sb = new StringBuffer();
		if(list!=null) {
			for(String cmd : list) {
				if(sb.length()>0) {
					sb.append(",");
				}
				sb.append(cmd);
			}
		}
		return sb.toString();
	}
	
	private static List<String> formatCsvToList(String csv) {
		List<String> list = new ArrayList<String>();
		if(csv!=null) {
			String[] aValues = csv.split("[,]");
			for(String value: aValues) {
				list.add(value.trim());
			}
		}
		return list;
	}

	public StatisticheInterventiId getId() {
		return id;
	}

	public void setId(StatisticheInterventiId id) {
		this.id = id;
	}

	public List<String> getComandiDaEseguire() {
		return formatCsvToList(comandiDaEseguire);
	}

	public void setComandiDaEseguire(List<String> comandiDaEseguire) {
		this.comandiDaEseguire = formatListToCsv(comandiDaEseguire);
	}

	public List<String> getComandiEseguiti() {
		return formatCsvToList(comandiEseguiti);
	}

	public void setComandiEseguiti(List<String> comandiEseguiti) {
		cmdBTSuccess = 0;
		if(comandiEseguiti!=null && !comandiEseguiti.isEmpty()) {
			for(String s : comandiEseguiti) {
				if(s.contains("S")) {
					cmdBTSuccess++;
				}
			}
		}
		
		this.comandiEseguiti = formatListToCsv(comandiEseguiti);
	}
	
	public int getCmdBTSuccess() {
		return cmdBTSuccess;
	}

	public void setCmdBTSuccess(int cmdBTSuccess) {
		this.cmdBTSuccess = cmdBTSuccess;
	}

	public void setEsitoIntervento(String esitoIntervento) {
		this.esitoIntervento = esitoIntervento;
	}
	
	public void setEsitoIntervento(EsitoIntervento esitoIntervento) {
		this.esitoIntervento = esitoIntervento != null ? esitoIntervento.getLocalizedResult() : null;
	}
	
	public EsitoIntervento getEsitoIntervento() {
		return esitoIntervento!=null ? EsitoIntervento.parse(esitoIntervento) : null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cmdBTSuccess;
		result = prime
				* result
				+ ((comandiDaEseguire == null) ? 0 : comandiDaEseguire
						.hashCode());
		result = prime * result
				+ ((comandiEseguiti == null) ? 0 : comandiEseguiti.hashCode());
		result = prime * result
				+ ((esitoIntervento == null) ? 0 : esitoIntervento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		StatisticheInterventi other = (StatisticheInterventi) obj;
		if (cmdBTSuccess != other.cmdBTSuccess)
			return false;
		if (comandiDaEseguire == null) {
			if (other.comandiDaEseguire != null)
				return false;
		} else if (!comandiDaEseguire.equals(other.comandiDaEseguire))
			return false;
		if (comandiEseguiti == null) {
			if (other.comandiEseguiti != null)
				return false;
		} else if (!comandiEseguiti.equals(other.comandiEseguiti))
			return false;
		if (esitoIntervento == null) {
			if (other.esitoIntervento != null)
				return false;
		} else if (!esitoIntervento.equals(other.esitoIntervento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
