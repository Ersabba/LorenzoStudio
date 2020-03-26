package com.ericsson.urm.persistence.dto.mgre;

import java.util.Date;

import org.apache.log4j.Logger;


public class RegistroPiccoMeseCompl implements RegistroPiccoMese {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(RegistroPiccoMeseCompl.class);

	private RegistroPiccoMeseComplId id = null;
	private Long valoreRegistro;
	private Long valorePicco;
	private Date istantePicco;
	private Date dataAcq;
	private Date dataExport;
	private Date dataRilevazione;
	private Long valoreRegistroFraz;

	public RegistroPiccoMeseComplId getId() {
		return id;
	}

	public void setId(RegistroPiccoMeseComplId id) {
		this.id = id;
	}

	public Long getValoreRegistro() {
		return valoreRegistro;
	}

	public void setValoreRegistro(Long valoreRegistro) {
		this.valoreRegistro = valoreRegistro;
	}

	public Long getValorePicco() {
		return valorePicco;
	}

	public void setValorePicco(Long valorePicco) {
		this.valorePicco = valorePicco;
	}

	public Date getIstantePicco() {
		return istantePicco;
	}

	public void setIstantePicco(Date istantePicco) {
		this.istantePicco = istantePicco;
	}
	
	public Date getDataAcq() {
		return dataAcq;
	}

	public void setDataAcq(Date dataAcq) {
		this.dataAcq = dataAcq;
	}	

	public Date getDataExport() {
		return dataExport;
	}

	public void setDataExport(Date dataExport) {
		this.dataExport = dataExport;
	}

	public Date getDataRilevazione() {
		return dataRilevazione;
	}

	public void setDataRilevazione(Date dataRilevazione) {
		this.dataRilevazione = dataRilevazione;
	}
	
	public Long getValoreRegistroFraz() {
		return valoreRegistroFraz;
	}

	public void setValoreRegistroFraz(Long valoreRegistroFraz) {
		this.valoreRegistroFraz = valoreRegistroFraz;
	}


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAcq == null) ? 0 : dataAcq.hashCode());
		result = prime * result
				+ ((dataExport == null) ? 0 : dataExport.hashCode());
		result = prime * result
				+ ((dataRilevazione == null) ? 0 : dataRilevazione.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((istantePicco == null) ? 0 : istantePicco.hashCode());
		result = prime * result
				+ ((valorePicco == null) ? 0 : valorePicco.hashCode());
		result = prime * result
				+ ((valoreRegistro == null) ? 0 : valoreRegistro.hashCode());
		result = prime * result
				+ ((valoreRegistroFraz == null) ? 0 : valoreRegistroFraz.hashCode());
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
		RegistroPiccoMeseCompl other = (RegistroPiccoMeseCompl) obj;
		if (dataAcq == null) {
			if (other.dataAcq != null)
				return false;
		} else if (!dataAcq.equals(other.dataAcq))
			return false;
		if (dataExport == null) {
			if (other.dataExport != null)
				return false;
		} else if (!dataExport.equals(other.dataExport))
			return false;
		if (dataRilevazione == null) {
			if (other.dataRilevazione != null)
				return false;
		} else if (!dataRilevazione.equals(other.dataRilevazione))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (istantePicco == null) {
			if (other.istantePicco != null)
				return false;
		} else if (!istantePicco.equals(other.istantePicco))
			return false;
		if (valorePicco == null) {
			if (other.valorePicco != null)
				return false;
		} else if (!valorePicco.equals(other.valorePicco))
			return false;
		if (valoreRegistro == null) {
			if (other.valoreRegistro != null)
				return false;
		} else if (!valoreRegistro.equals(other.valoreRegistro))
			return false;
		if (valoreRegistroFraz == null) {
			if (other.valoreRegistroFraz != null)
				return false;
		} else if (!valoreRegistroFraz.equals(other.valoreRegistroFraz))
			return false;
		return true;
	}

	public Object clone() {
		RegistroPiccoMeseCompl ret = null;
		try {
			ret = (RegistroPiccoMeseCompl)super.clone();
			if(id != null) {
				ret.id = (RegistroPiccoMeseComplId)id.clone();
			}
			if(istantePicco != null) {
				ret.istantePicco = (Date)istantePicco.clone();
			}
			if(dataAcq != null) {
				ret.dataAcq = (Date)dataAcq.clone();
			}
			if(dataExport!=null) {
				ret.dataExport = (Date)dataExport.clone();
			}
			if(dataRilevazione!=null) {
				ret.dataRilevazione = (Date)dataRilevazione.clone();
			}
		} catch (CloneNotSupportedException e) {
			logger.error(e.getMessage(),e);
		}

		return ret;
	}
	
}
