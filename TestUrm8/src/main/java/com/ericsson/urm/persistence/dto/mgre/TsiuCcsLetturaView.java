package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.core.enumeration.LenntTypeCode;
import com.ericsson.urm.persistence.dto.mgre.Tsiu.TipoLenntTsiu;


public class TsiuCcsLetturaView implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private String				matricolaLenntCliente;		// not null
	private String				codConcentratore;
	private Date				dataUltimaLettura;
	private String				codGeo;					// not null
	private String				tipoLenntTsiu;
	private String				tipoLennt;

	
	public LenntTypeCode getTipoLennt() {
		return LenntTypeCode.parse(tipoLennt);
	}
	
	public void setTipoLennt(LenntTypeCode tipoLennt) {
		if (tipoLennt == null)
			this.tipoLennt = null;
		else
			this.tipoLennt = tipoLennt.getDbCode();
	}


	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}

	
	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}

	
	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}

	
	public void setDataUltimaLettura(Date dataUltimaLettura) {
		this.dataUltimaLettura = dataUltimaLettura;
	}

	
	public void setCodGeo(String codGeo) {
		this.codGeo = codGeo;
	}

	
	public void setTipoLenntTsiu(String tipoLenntTsiu) {
		this.tipoLenntTsiu = tipoLenntTsiu;
	}

	public String getCodConcentratore() {
		return codConcentratore;
	}

	public Date getDataUltimaLettura() {
		return dataUltimaLettura;
	}

	public String getCodGeo() {
		return codGeo;
	}

	public TipoLenntTsiu getTipoLenntTsiu() {
		if (tipoLenntTsiu == null)
			return null;
		for (TipoLenntTsiu t : TipoLenntTsiu.values())
			if (tipoLenntTsiu.equals(t.value()))
				return t;
		throw new IllegalArgumentException("Nessun tipoLenntTsiu valido per " + tipoLenntTsiu);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codConcentratore == null) ? 0 : codConcentratore.hashCode());
		result = prime * result + ((codGeo == null) ? 0 : codGeo.hashCode());
		result = prime * result + ((dataUltimaLettura == null) ? 0 : dataUltimaLettura.hashCode());
		result = prime * result + ((matricolaLenntCliente == null) ? 0 : matricolaLenntCliente.hashCode());
		result = prime * result + ((tipoLennt == null) ? 0 : tipoLennt.hashCode());
		result = prime * result + ((tipoLenntTsiu == null) ? 0 : tipoLenntTsiu.hashCode());
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
		TsiuCcsLetturaView other = (TsiuCcsLetturaView) obj;
		if (codConcentratore == null) {
			if (other.codConcentratore != null)
				return false;
		}
		else if (!codConcentratore.equals(other.codConcentratore))
			return false;
		if (codGeo == null) {
			if (other.codGeo != null)
				return false;
		}
		else if (!codGeo.equals(other.codGeo))
			return false;
		if (dataUltimaLettura == null) {
			if (other.dataUltimaLettura != null)
				return false;
		}
		else if (!dataUltimaLettura.equals(other.dataUltimaLettura))
			return false;
		if (matricolaLenntCliente == null) {
			if (other.matricolaLenntCliente != null)
				return false;
		}
		else if (!matricolaLenntCliente.equals(other.matricolaLenntCliente))
			return false;
		if (tipoLennt == null) {
			if (other.tipoLennt != null)
				return false;
		}
		else if (!tipoLennt.equals(other.tipoLennt))
			return false;
		if (tipoLenntTsiu == null) {
			if (other.tipoLenntTsiu != null)
				return false;
		}
		else if (!tipoLenntTsiu.equals(other.tipoLenntTsiu))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TsiuCcsLetturaView [matricolaLenntCliente=" + matricolaLenntCliente + ", codConcentratore=" + codConcentratore
				+ ", dataUltimaLettura=" + dataUltimaLettura + ", codGeo=" + codGeo + ", tipoLenntTsiu=" + tipoLenntTsiu + ", tipoLennt=" + tipoLennt
				+ "]";
	}
}
