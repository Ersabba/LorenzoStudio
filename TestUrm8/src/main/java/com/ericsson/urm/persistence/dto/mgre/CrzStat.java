package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the GRE_CRZ_STATISTICHE database table.
 * 
 */
@Entity
@Table(name="GRE_CRZ_STATISTICHE")
public class CrzStat implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CrzStatId id;

	@Column(name="AZIONAMENTO_PULSANTE")
	private Long azionamentoPulsante;

	@Column(name="CONNESSIONI_LENNT_ERRATO")
	private Long connessioniLenntErrato;

	@Column(name="CONNESSIONI_USB_FALLITE")
	private Long connessioniUsbFallite;

	@Column(name="CONNESSIONI_USB_TOTALI")
	private Long connessioniUsbTotali;

	@Column(name="CONNESSIONI_ZVEI_FALLITE")
	private Long connessioniZveiFallite;

	@Column(name="CONNESSIONI_ZVEI_TOTALI")
	private Long connessioniZveiTotali;

	@Column(name="CONNESSIONI_RADIOMOB_FALLITE")
	private Long connessioniRadioMobFallite;

	@Column(name="CONNESSIONI_RADIOMOB_TOTALI")
	private Long connessioniRadioMobTotali;

	public CrzStat() {
	}

	public CrzStatId getId() {
		return this.id;
	}

	public void setId(CrzStatId id) {
		this.id = id;
	}

	public Long getAzionamentoPulsante() {
		return this.azionamentoPulsante;
	}

	public void setAzionamentoPulsante(Long azionamentoPulsante) {
		this.azionamentoPulsante = azionamentoPulsante;
	}

	public Long getConnessioniLenntErrato() {
		return this.connessioniLenntErrato;
	}

	public void setConnessioniLenntErrato(Long connessioniLenntErrato) {
		this.connessioniLenntErrato = connessioniLenntErrato;
	}

	public Long getConnessioniUsbFallite() {
		return this.connessioniUsbFallite;
	}

	public void setConnessioniUsbFallite(Long connessioniUsbFallite) {
		this.connessioniUsbFallite = connessioniUsbFallite;
	}

	public Long getConnessioniUsbTotali() {
		return this.connessioniUsbTotali;
	}

	public void setConnessioniUsbTotali(Long connessioniUsbTotali) {
		this.connessioniUsbTotali = connessioniUsbTotali;
	}

	public Long getConnessioniZveiFallite() {
		return this.connessioniZveiFallite;
	}

	public void setConnessioniZveiFallite(Long connessioniZveiFallite) {
		this.connessioniZveiFallite = connessioniZveiFallite;
	}

	public Long getConnessioniZveiTotali() {
		return this.connessioniZveiTotali;
	}

	public void setConnessioniZveiTotali(Long connessioniZveiTotali) {
		this.connessioniZveiTotali = connessioniZveiTotali;
	}

	public Long getConnessioniRadioMobFallite() {
		return connessioniRadioMobFallite;
	}

	public void setConnessioniRadioMobFallite(Long connessioniRadioMobFallite) {
		this.connessioniRadioMobFallite = connessioniRadioMobFallite;
	}

	public Long getConnessioniRadioMobTotali() {
		return connessioniRadioMobTotali;
	}

	public void setConnessioniRadioMobTotali(Long connessioniRadioMobTotali) {
		this.connessioniRadioMobTotali = connessioniRadioMobTotali;
	}

	@Override
	public String toString() {
		return "CrzStat [id=" + id + ", azionamentoPulsante="
				+ azionamentoPulsante + ", connessioniLenntErrato="
				+ connessioniLenntErrato + ", connessioniUsbFallite="
				+ connessioniUsbFallite + ", connessioniUsbTotali="
				+ connessioniUsbTotali + ", connessioniZveiFallite="
				+ connessioniZveiFallite + ", connessioniZveiTotali="
				+ connessioniZveiTotali + ", connessioniRadioMobFallite="
				+ connessioniRadioMobFallite + ", connessioniRadioMobTotali="
				+ connessioniRadioMobTotali + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((azionamentoPulsante == null) ? 0 : azionamentoPulsante
						.hashCode());
		result = prime
				* result
				+ ((connessioniLenntErrato == null) ? 0
						: connessioniLenntErrato.hashCode());
		result = prime
				* result
				+ ((connessioniRadioMobFallite == null) ? 0
						: connessioniRadioMobFallite.hashCode());
		result = prime
				* result
				+ ((connessioniRadioMobTotali == null) ? 0
						: connessioniRadioMobTotali.hashCode());
		result = prime
				* result
				+ ((connessioniUsbFallite == null) ? 0 : connessioniUsbFallite
						.hashCode());
		result = prime
				* result
				+ ((connessioniUsbTotali == null) ? 0 : connessioniUsbTotali
						.hashCode());
		result = prime
				* result
				+ ((connessioniZveiFallite == null) ? 0
						: connessioniZveiFallite.hashCode());
		result = prime
				* result
				+ ((connessioniZveiTotali == null) ? 0 : connessioniZveiTotali
						.hashCode());
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
		CrzStat other = (CrzStat) obj;
		if (azionamentoPulsante == null) {
			if (other.azionamentoPulsante != null)
				return false;
		} else if (!azionamentoPulsante.equals(other.azionamentoPulsante))
			return false;
		if (connessioniLenntErrato == null) {
			if (other.connessioniLenntErrato != null)
				return false;
		} else if (!connessioniLenntErrato.equals(other.connessioniLenntErrato))
			return false;
		if (connessioniRadioMobFallite == null) {
			if (other.connessioniRadioMobFallite != null)
				return false;
		} else if (!connessioniRadioMobFallite
				.equals(other.connessioniRadioMobFallite))
			return false;
		if (connessioniRadioMobTotali == null) {
			if (other.connessioniRadioMobTotali != null)
				return false;
		} else if (!connessioniRadioMobTotali
				.equals(other.connessioniRadioMobTotali))
			return false;
		if (connessioniUsbFallite == null) {
			if (other.connessioniUsbFallite != null)
				return false;
		} else if (!connessioniUsbFallite.equals(other.connessioniUsbFallite))
			return false;
		if (connessioniUsbTotali == null) {
			if (other.connessioniUsbTotali != null)
				return false;
		} else if (!connessioniUsbTotali.equals(other.connessioniUsbTotali))
			return false;
		if (connessioniZveiFallite == null) {
			if (other.connessioniZveiFallite != null)
				return false;
		} else if (!connessioniZveiFallite.equals(other.connessioniZveiFallite))
			return false;
		if (connessioniZveiTotali == null) {
			if (other.connessioniZveiTotali != null)
				return false;
		} else if (!connessioniZveiTotali.equals(other.connessioniZveiTotali))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}