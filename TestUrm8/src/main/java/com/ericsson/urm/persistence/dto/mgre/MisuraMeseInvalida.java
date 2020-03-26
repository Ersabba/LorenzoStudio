package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="GRE_MISURA_MESE_INVALIDA")
public class MisuraMeseInvalida implements Serializable {

	private static final long serialVersionUID = -1L;
	
	@EmbeddedId
	private MisuraMeseInvalidaId id;
	
	@Column(name="DATA_ACQ")
	private Date dataAcq = null;
	
	@Column(name="DATA_EXPORT")
	private Date dataExport;
	
	@Column(name="DATA_RIL")
	private Date dataRil;
	
	@Column(name="VALORE_MISURA")
	private String valoreMisura;
	
	
	public MisuraMeseInvalida() {
	}
	
	public MisuraMeseInvalida(MisuraMeseInvalidaId id, Date dataAcq, Date dataRil, String valoreMisura) {
		super();
		this.id = id;
		this.dataExport = null;
		this.dataAcq = dataAcq;
		this.dataRil = dataRil;
		this.valoreMisura = valoreMisura;
	}
	
	public MisuraMeseInvalida(MisuraMeseInvalidaId id, Date dataExport, Date dataAcq, Date dataRil, String valoreMisura) {
		super();
		this.id = id;
		this.dataExport = dataExport;
		this.dataAcq = dataAcq;
		this.dataRil = dataRil;
		this.valoreMisura = valoreMisura;
	}

	public MisuraMeseInvalidaId getId() {
		return id;
	}
	public void setId(MisuraMeseInvalidaId id) {
		this.id = id;
	}
	public Date getDataExport() {
		return dataExport;
	}
	public void setDataExport(Date dataExport) {
		this.dataExport = dataExport;
	}
	public Date getDataAcq() {
		return dataAcq;
	}
	public void setDataAcq(Date dataAcq) {
		this.dataAcq = dataAcq;
	}
	public Date getDataRil() {
		return dataRil;
	}
	public void setDataRil(Date dataRil) {
		this.dataRil = dataRil;
	}
	public String getValoreMisura() {
		return valoreMisura;
	}
	public void setValoreMisura(String valoreMisura) {
		this.valoreMisura = valoreMisura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAcq == null) ? 0 : dataAcq.hashCode());
		result = prime * result
				+ ((dataExport == null) ? 0 : dataExport.hashCode());
		result = prime * result + ((dataRil == null) ? 0 : dataRil.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((valoreMisura == null) ? 0 : valoreMisura.hashCode());
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
		MisuraMeseInvalida other = (MisuraMeseInvalida) obj;
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
		if (valoreMisura == null) {
			if (other.valoreMisura != null)
				return false;
		} else if (!valoreMisura.equals(other.valoreMisura))
			return false;
		return true;
	}
	
}
