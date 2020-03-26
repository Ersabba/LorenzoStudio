package com.ericsson.urm.persistence.dto.mgre;

import java.util.Date;

import org.apache.log4j.Logger;


public class RegistroPiccoMeseExp implements RegistroPiccoMese {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(RegistroPiccoMeseExp.class);

	private RegistroPiccoMeseExpId id = null;
	private Long valoreRegistro;
	private Long valorePicco;
	private Date istantePicco;
	private String tipo;
	private Date dataRilevazione;
	

	public RegistroPiccoMeseExpId getId() {
		return id;
	}

	public void setId(RegistroPiccoMeseExpId id) {
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
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}	

	public Date getDataRilevazione() {
		return dataRilevazione;
	}

	public void setDataRilevazione(Date dataRilevazione) {
		this.dataRilevazione = dataRilevazione;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataRilevazione == null) ? 0 : dataRilevazione.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((istantePicco == null) ? 0 : istantePicco.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result
				+ ((valorePicco == null) ? 0 : valorePicco.hashCode());
		result = prime * result
				+ ((valoreRegistro == null) ? 0 : valoreRegistro.hashCode());
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
		RegistroPiccoMeseExp other = (RegistroPiccoMeseExp) obj;
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
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
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
		return true;
	}

	public Object clone() {
		RegistroPiccoMeseExp ret = null;
		try {
			ret = (RegistroPiccoMeseExp)super.clone();
			if(id != null) {
				ret.id = (RegistroPiccoMeseExpId)id.clone();
			}
			if(istantePicco != null) {
				ret.istantePicco = (Date)istantePicco.clone();
			}
			if(dataRilevazione != null) {
				ret.dataRilevazione = (Date)dataRilevazione.clone();
			}
		} catch (CloneNotSupportedException e) {
			logger.error(e.getMessage(),e);
		}

		return ret;
	}
}
