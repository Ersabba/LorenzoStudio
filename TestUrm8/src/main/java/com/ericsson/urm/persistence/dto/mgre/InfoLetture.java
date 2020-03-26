package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;


public class InfoLetture implements Serializable {

	private static final long	serialVersionUID	= -1L;
	
	private InfoLettureId  id;	
	private Date           dataExport;
	private String         nomeExportFile;
	private Date           dataAcqRegInt;
	private Date		   dataAcqIpm;
	private Date           dataAcqDecimalGeneral;	
	private Date           dataAcqDecimalTariff;	
	private String 		   modLetturaRegInt;
	private String 		   modLetturaIpm;
	private String 		   modLetturaDecimalGeneral;
	private String 		   modLetturaDecimalTariff;
	private String 		   provenienza;
	private Date           dataRil;
	
	  
	 
	public static enum TipoDatiLettura implements Serializable{		
		REGISTRO_INTERI,
		IPM,
		DECIMAL_GENERAL,
		DECIMAL_TARIFF;	
	}
	
	public static enum ModalitaLettura implements Serializable{
		FTP("FTP"),
		THOR("THOR"),
		REC_PUNT("RECUPERO_PUNTUALE"),
		ACQ_PUNT("ACQUISIZIONE_PUNTUALE"),
		CRZ("CRZ"),
		STORICO("STO");
		
		private String extendedDesc = null;

		private ModalitaLettura(String extendedDesc) {
			this.extendedDesc = extendedDesc;
		}
		
		public static ModalitaLettura parse(String extendedDesc) {
			for(ModalitaLettura curr : ModalitaLettura.values()) {
				if(curr.extendedDesc.equalsIgnoreCase(extendedDesc)) {
					return curr;
				}
			}
			throw new IllegalArgumentException("Unknown 'ModalitaLettura' with extended description: "+extendedDesc+" .");
		}

		public String getExtendedDesc() {
			return extendedDesc;
		}
	}
	
	public static enum TipoLettura {
		TOTALIZZATORE("TOTALIZZATORE"),
		MENSILE("MENSILE"),
		CURVA_DI_CARICO("CURVA_DI_CARICO");
		
		private String description = null;

		private TipoLettura(String description) {
			this.description = description;
		}
		
		public static TipoLettura parse(String description) {
			for(TipoLettura curr : TipoLettura.values()) {
				if(curr.description.equalsIgnoreCase(description)) {
					return curr;
				}
			}
			throw new IllegalArgumentException("Unknown 'TipoLettura' with description: "+description+" .");
		}

		public String getDescription() {
			return description;
		}
	}	

	public InfoLetture() {
		super();
	}

	
	
	
	public InfoLetture(InfoLettureId id, Date dataExport, String nomeExportFile, Date dataAcqRegInt, Date dataAcqIpm,
			Date dataAcqDecimalGeneral, Date dataAcqDecimalTariff, String modLetturaRegInt, String modLetturaIpm,
			String modLetturaDecimalGeneral, String modLetturaDecimalTariff, String provenienza, Date dataRil) {
		super();
		this.id = id;
		this.dataExport = dataExport;
		this.nomeExportFile = nomeExportFile;
		this.dataAcqRegInt = dataAcqRegInt;
		this.dataAcqIpm = dataAcqIpm;
		this.dataAcqDecimalGeneral = dataAcqDecimalGeneral;
		this.dataAcqDecimalTariff = dataAcqDecimalTariff;
		this.modLetturaRegInt = modLetturaRegInt;
		this.modLetturaIpm = modLetturaIpm;
		this.modLetturaDecimalGeneral = modLetturaDecimalGeneral;
		this.modLetturaDecimalTariff = modLetturaDecimalTariff;
		this.provenienza = provenienza;
		this.dataRil  =dataRil;
	}




	public InfoLetture(InfoLettureId id, Date dataAcq, Date dataExport,
			String nomeExportFile, ModalitaLettura modLettura, TipoDatiLettura tipoDati, String provenienza, Date dataRil ) {
		super();
		this.id = id;		
		this.dataExport = dataExport;
		this.nomeExportFile = nomeExportFile;
		switch (tipoDati) { 
				case REGISTRO_INTERI: this.dataAcqRegInt = dataAcq; 
									  this.modLetturaRegInt = modLettura.extendedDesc;
									  this.dataRil = dataRil;
									  this.provenienza = provenienza;
									  break; 
				case IPM: 			  this.dataAcqIpm = dataAcq; 
						  			  this.modLetturaIpm = modLettura.extendedDesc;
									  break; 
				case DECIMAL_GENERAL: this.dataAcqDecimalGeneral = dataAcq; 
									  this.modLetturaDecimalGeneral = modLettura.extendedDesc;
									  break; 
				case DECIMAL_TARIFF:  this.dataAcqDecimalTariff = dataAcq;
								      this.modLetturaDecimalTariff = modLettura.extendedDesc;	
									  break;				
		}
}



	public InfoLettureId getId() {
		return id;
	}

	public void setId(InfoLettureId id) {
		this.id = id;
	}
	
	public Date getDataExport() {
		return dataExport;
	}

	public void setDataExport(Date dataExport) {
		this.dataExport = dataExport;
	}

	public String getNomeExportFile() {
		return nomeExportFile;
	}

	public void setNomeExportFile(String nomeExportFile) {
		this.nomeExportFile = nomeExportFile;
	}

	public Date getDataAcqRegInt() {
		return dataAcqRegInt;
	}

	public void setDataAcqRegInt(Date dataAcqRegInt) {
		this.dataAcqRegInt = dataAcqRegInt;
	}

	public Date getDataAcqIpm() {
		return dataAcqIpm;
	}

	public void setDataAcqIpm(Date dataAcqIpm) {
		this.dataAcqIpm = dataAcqIpm;
	}

	public Date getDataAcqDecimalGeneral() {
		return dataAcqDecimalGeneral;
	}

	public void setDataAcqDecimalGeneral(Date dataAcqDecimalGeneral) {
		this.dataAcqDecimalGeneral = dataAcqDecimalGeneral;
	}

	public Date getDataAcqDecimalTariff() {
		return dataAcqDecimalTariff;
	}

	public void setDataAcqDecimalTariff(Date dataAcqDecimalTariff) {
		this.dataAcqDecimalTariff = dataAcqDecimalTariff;
	}

	public String getModLetturaRegInt() {
		return modLetturaRegInt;
	}

	public void setModLetturaRegInt(String modLetturaRegInt) {
		this.modLetturaRegInt = modLetturaRegInt;
	}

	public String getModLetturaIpm() {
		return modLetturaIpm;
	}

	public void setModLetturaIpm(String modLetturaIpm) {
		this.modLetturaIpm = modLetturaIpm;
	}

	public String getModLetturaDecimalGeneral() {
		return modLetturaDecimalGeneral;
	}

	public void setModLetturaDecimalGeneral(String modLetturaDecimalGeneral) {
		this.modLetturaDecimalGeneral = modLetturaDecimalGeneral;
	}
	
	public String getModLetturaDecimalTariff() {
		return modLetturaDecimalTariff;
	}
	
	public void setModLetturaDecimalTariff(String modLetturaDecimalTariff) {
		this.modLetturaDecimalTariff = modLetturaDecimalTariff;
	}

	public String getProvenienza() {
		return provenienza;
	}

	public void setProvenienza(String provenienza) {
		this.provenienza = provenienza;
	}

	public Date getDataRil() {
		return dataRil;
	}

	public void setDataRil(Date dataRil) {
		this.dataRil = dataRil;
	}




	@Override
	public String toString() {
		return "InfoLetture [id=" + id + ", dataExport=" + dataExport + ", nomeExportFile=" + nomeExportFile
				+ ", dataAcqRegInt=" + dataAcqRegInt + ", dataAcqIpm=" + dataAcqIpm + ", dataAcqDecimalGeneral="
				+ dataAcqDecimalGeneral + ", dataAcqDecimalTariff=" + dataAcqDecimalTariff + ", modLetturaRegInt="
				+ modLetturaRegInt + ", modLetturaIpm=" + modLetturaIpm + ", modLetturaDecimalGeneral="
				+ modLetturaDecimalGeneral + ", modLetturaDecimalTariff=" + modLetturaDecimalTariff + ", provenienza="
				+ provenienza + ", dataRil=" + dataRil + "]";
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAcqDecimalGeneral == null) ? 0 : dataAcqDecimalGeneral.hashCode());
		result = prime * result + ((dataAcqDecimalTariff == null) ? 0 : dataAcqDecimalTariff.hashCode());
		result = prime * result + ((dataAcqIpm == null) ? 0 : dataAcqIpm.hashCode());
		result = prime * result + ((dataAcqRegInt == null) ? 0 : dataAcqRegInt.hashCode());
		result = prime * result + ((dataExport == null) ? 0 : dataExport.hashCode());
		result = prime * result + ((dataRil == null) ? 0 : dataRil.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modLetturaDecimalGeneral == null) ? 0 : modLetturaDecimalGeneral.hashCode());
		result = prime * result + ((modLetturaDecimalTariff == null) ? 0 : modLetturaDecimalTariff.hashCode());
		result = prime * result + ((modLetturaIpm == null) ? 0 : modLetturaIpm.hashCode());
		result = prime * result + ((modLetturaRegInt == null) ? 0 : modLetturaRegInt.hashCode());
		result = prime * result + ((nomeExportFile == null) ? 0 : nomeExportFile.hashCode());
		result = prime * result + ((provenienza == null) ? 0 : provenienza.hashCode());
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
		InfoLetture other = (InfoLetture) obj;
		if (dataAcqDecimalGeneral == null) {
			if (other.dataAcqDecimalGeneral != null)
				return false;
		} else if (!dataAcqDecimalGeneral.equals(other.dataAcqDecimalGeneral))
			return false;
		if (dataAcqDecimalTariff == null) {
			if (other.dataAcqDecimalTariff != null)
				return false;
		} else if (!dataAcqDecimalTariff.equals(other.dataAcqDecimalTariff))
			return false;
		if (dataAcqIpm == null) {
			if (other.dataAcqIpm != null)
				return false;
		} else if (!dataAcqIpm.equals(other.dataAcqIpm))
			return false;
		if (dataAcqRegInt == null) {
			if (other.dataAcqRegInt != null)
				return false;
		} else if (!dataAcqRegInt.equals(other.dataAcqRegInt))
			return false;
		if (dataExport == null) {
			if (other.dataExport != null)
				return false;
		} else if (!dataExport.equals(other.dataExport))
			return false;
		if (dataRil == null) {
			if (other.dataRil != null)
				return false;
		} else if (!dataRil.equals(other.dataRil))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (modLetturaDecimalGeneral == null) {
			if (other.modLetturaDecimalGeneral != null)
				return false;
		} else if (!modLetturaDecimalGeneral.equals(other.modLetturaDecimalGeneral))
			return false;
		if (modLetturaDecimalTariff == null) {
			if (other.modLetturaDecimalTariff != null)
				return false;
		} else if (!modLetturaDecimalTariff.equals(other.modLetturaDecimalTariff))
			return false;
		if (modLetturaIpm == null) {
			if (other.modLetturaIpm != null)
				return false;
		} else if (!modLetturaIpm.equals(other.modLetturaIpm))
			return false;
		if (modLetturaRegInt == null) {
			if (other.modLetturaRegInt != null)
				return false;
		} else if (!modLetturaRegInt.equals(other.modLetturaRegInt))
			return false;
		if (nomeExportFile == null) {
			if (other.nomeExportFile != null)
				return false;
		} else if (!nomeExportFile.equals(other.nomeExportFile))
			return false;
		if (provenienza == null) {
			if (other.provenienza != null)
				return false;
		} else if (!provenienza.equals(other.provenienza))
			return false;
		return true;
	}


}
