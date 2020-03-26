package com.ericsson.urm.persistence.dto.mgre.datatype;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.persistence.dto.mgre.Tsiu.TipoLenntTsiu;


public class ClusterLenntInfo implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private String				matricolaLenntCliente;
	private Date				ultimaLetturaTotAttAss;
	private String				codTopTsiu;
	private String				codViaTsiu;
	private String				desViaTsiu;
	private String				codCivTsiu;
	private String				sncTsiu;
	private String				codGeoTsiu;
//	private String				validitaGeoTsiu;
	private String     			tipoLenntTsiu;
	
	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}

	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}

	public Date getUltimaLetturaTotAttAss() {
		return ultimaLetturaTotAttAss;
	}

	public void setUltimaLetturaTotAttAss(Date ultimaLetturaTotAttAss) {
		this.ultimaLetturaTotAttAss = ultimaLetturaTotAttAss;
	}

	public String getCodTopTsiu() {
		return codTopTsiu;
	}

	public void setCodTopTsiu(String codTopTsiu) {
		this.codTopTsiu = codTopTsiu;
	}

	public String getCodViaTsiu() {
		return codViaTsiu;
	}

	public void setCodViaTsiu(String codViaTsiu) {
		this.codViaTsiu = codViaTsiu;
	}

	public String getDesViaTsiu() {
		return desViaTsiu;
	}

	public void setDesViaTsiu(String desViaTsiu) {
		this.desViaTsiu = desViaTsiu;
	}

	public String getCodCivTsiu() {
		return codCivTsiu;
	}

	public void setCodCivTsiu(String codCivTsiu) {
		this.codCivTsiu = codCivTsiu;
	}

	public String getSncTsiu() {
		return sncTsiu;
	}

	public void setSncTsiu(String sncTsiu) {
		this.sncTsiu = sncTsiu;
	}

	public String getCodGeoTsiu() {
		return codGeoTsiu;
	}

	public void setCodGeoTsiu(String codGeoTsiu) {
		this.codGeoTsiu = codGeoTsiu;
	}

//	public String getValiditaGeoTsiu() {
//		return validitaGeoTsiu;
//	}
//
//	public void setValiditaGeoTsiu(String validitaGeoTsiu) {
//		this.validitaGeoTsiu = validitaGeoTsiu;
//	}
	
	public String getTipoLenntTsiu() {
		return this.tipoLenntTsiu;
	}
	
	public void setTipoLenntTsiu(String tipo) {
		this.tipoLenntTsiu = tipo;
	}

	public TipoLenntTsiu getTipoLenntTsiuEnum() {
		if (tipoLenntTsiu == null)
			return null;
		for (TipoLenntTsiu t : TipoLenntTsiu.values())
			if (tipoLenntTsiu.equals(t.value()))
				return t;
		throw new IllegalArgumentException("Nessun tipo lennt valido per " + tipoLenntTsiu);
	}

	public void setTipoLenntTsiuEnum(TipoLenntTsiu tipoLenntTsiu) {
		this.tipoLenntTsiu = tipoLenntTsiu!=null ? tipoLenntTsiu.value() : null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codCivTsiu == null) ? 0 : codCivTsiu.hashCode());
		result = prime * result
				+ ((codGeoTsiu == null) ? 0 : codGeoTsiu.hashCode());
		result = prime * result
				+ ((codTopTsiu == null) ? 0 : codTopTsiu.hashCode());
		result = prime * result
				+ ((codViaTsiu == null) ? 0 : codViaTsiu.hashCode());
		result = prime * result
				+ ((desViaTsiu == null) ? 0 : desViaTsiu.hashCode());
		result = prime
				* result
				+ ((matricolaLenntCliente == null) ? 0 : matricolaLenntCliente
						.hashCode());
		result = prime * result + ((sncTsiu == null) ? 0 : sncTsiu.hashCode());
		result = prime * result
				+ ((tipoLenntTsiu == null) ? 0 : tipoLenntTsiu.hashCode());
		result = prime
				* result
				+ ((ultimaLetturaTotAttAss == null) ? 0
						: ultimaLetturaTotAttAss.hashCode());
//		result = prime * result
//				+ ((validitaGeoTsiu == null) ? 0 : validitaGeoTsiu.hashCode());
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
		ClusterLenntInfo other = (ClusterLenntInfo) obj;
		if (codCivTsiu == null) {
			if (other.codCivTsiu != null)
				return false;
		} else if (!codCivTsiu.equals(other.codCivTsiu))
			return false;
		if (codGeoTsiu == null) {
			if (other.codGeoTsiu != null)
				return false;
		} else if (!codGeoTsiu.equals(other.codGeoTsiu))
			return false;
		if (codTopTsiu == null) {
			if (other.codTopTsiu != null)
				return false;
		} else if (!codTopTsiu.equals(other.codTopTsiu))
			return false;
		if (codViaTsiu == null) {
			if (other.codViaTsiu != null)
				return false;
		} else if (!codViaTsiu.equals(other.codViaTsiu))
			return false;
		if (desViaTsiu == null) {
			if (other.desViaTsiu != null)
				return false;
		} else if (!desViaTsiu.equals(other.desViaTsiu))
			return false;
		if (matricolaLenntCliente == null) {
			if (other.matricolaLenntCliente != null)
				return false;
		} else if (!matricolaLenntCliente.equals(other.matricolaLenntCliente))
			return false;
		if (sncTsiu == null) {
			if (other.sncTsiu != null)
				return false;
		} else if (!sncTsiu.equals(other.sncTsiu))
			return false;
		if (tipoLenntTsiu == null) {
			if (other.tipoLenntTsiu != null)
				return false;
		} else if (!tipoLenntTsiu.equals(other.tipoLenntTsiu))
			return false;
		if (ultimaLetturaTotAttAss == null) {
			if (other.ultimaLetturaTotAttAss != null)
				return false;
		} else if (!ultimaLetturaTotAttAss.equals(other.ultimaLetturaTotAttAss))
			return false;
//		if (validitaGeoTsiu == null) {
//			if (other.validitaGeoTsiu != null)
//				return false;
//		} else if (!validitaGeoTsiu.equals(other.validitaGeoTsiu))
//			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClusterLenntInfo [matricolaLenntCliente="
				+ matricolaLenntCliente + ", ultimaLetturaTotAttAss="
				+ ultimaLetturaTotAttAss + ", codTopTsiu=" + codTopTsiu
				+ ", codViaTsiu=" + codViaTsiu + ", desViaTsiu=" + desViaTsiu
				+ ", codCivTsiu=" + codCivTsiu + ", sncTsiu=" + sncTsiu
				+ ", codGeoTsiu=" + codGeoTsiu + /*", validitaGeoTsiu="
				+ validitaGeoTsiu +*/ ", tipoLenntTsiu=" + tipoLenntTsiu + "]";
	}
}
