package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.ericsson.urm.db.MgdbDto;

public class Logletture implements Serializable, MgdbDto {
	
	private final static long serialVersionUID = -1;
		
	private static final Logger logger=Logger.getLogger(Logletture.class);
	
	public static enum TipoLettura implements Serializable{		
		INTERI,
		DECIMALI,
		INTERI_E_DECIMALI;
	}
	
	private LoglettureId id = null;
	
	private Long nuovaLettura;
	private Long letturaPresente;
	private String codConcentratore;
	private String dataNuovaRilevazione;
	private Long nuovaLetturaFraz;
	private Long letturaPresenteFraz; 
	private String provenienza;
	private String provenienzaOld;
	private Boolean overwrite = false;
	
	public Object clone() {
		try {
			Logletture ret = (Logletture) super.clone();
			if (id != null)
				ret.id = (LoglettureId) id.clone();
			return ret;
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	public void applyAllProperties(MgdbDto srcDto) {
		Logletture other = (Logletture)srcDto;
		if (other.id != null)
			this.id = (LoglettureId)other.id.clone();
		else
			this.id = null;
		this.nuovaLettura = other.nuovaLettura;
		this.letturaPresente = other.letturaPresente;
		this.codConcentratore = other.codConcentratore;
		this.dataNuovaRilevazione = other.dataNuovaRilevazione;
		this.nuovaLetturaFraz = other.nuovaLetturaFraz;
		this.letturaPresenteFraz = other.letturaPresenteFraz;
		this.provenienza = other.provenienza;
		this.overwrite = other.isOverwrite();
	}
	
	public Serializable retrievePrimaryKey() {
		return getId();
	}
	
	public Logletture() {}
	
	public Logletture(LoglettureId id) {
		this.id = id;
	}
	
	public String getCodConcentratore() {
		return codConcentratore;
	}
	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}
	public String getDataNuovaRilevazione() {
		return dataNuovaRilevazione;
	}
	public void setDataNuovaRilevazione(String dataNuovaRilevazione) {
		this.dataNuovaRilevazione = dataNuovaRilevazione;
	}
	public LoglettureId getId() {
		return id;
	}
	public void setId(LoglettureId id) {
		this.id = id;
	}
	public Long getLetturaPresente() {
		return letturaPresente;
	}
	public void setLetturaPresente(Long letturaPresente) {
		this.letturaPresente = letturaPresente;
	}
	public Long getNuovaLettura() {
		return nuovaLettura;
	}
	public void setNuovaLettura(Long nuovaLettura) {
		this.nuovaLettura = nuovaLettura;
	}

	public Long getNuovaLetturaFraz() {
		return nuovaLetturaFraz;
	}

	public void setNuovaLetturaFraz(Long nuovaLetturaFraz) {
		this.nuovaLetturaFraz = nuovaLetturaFraz;
	}

	public Long getLetturaPresenteFraz() {
		return letturaPresenteFraz;
	}

	public void setLetturaPresenteFraz(Long letturaPresenteFraz) {
		this.letturaPresenteFraz = letturaPresenteFraz;
	}

	public String getProvenienza() {
		return provenienza;
	}

	public void setProvenienza(String provenienza) {
		this.provenienza = provenienza;
	}

	public String getProvenienzaOld() {
		return provenienzaOld;
	}

	public void setProvenienzaOld(String provenienzaOld) {
		this.provenienzaOld = provenienzaOld;
	}

	public Boolean isOverwrite() {
		return overwrite;
	}

	public void setOverwrite(Boolean overwrite) {
		this.overwrite = overwrite;
	}

	@Override
	public String toString() {
		return "Logletture [id=" + id + ", nuovaLettura=" + nuovaLettura
				+ ", letturaPresente=" + letturaPresente
				+ ", codConcentratore=" + codConcentratore
				+ ", dataNuovaRilevazione=" + dataNuovaRilevazione
				+ ", nuovaLetturaFraz=" + nuovaLetturaFraz
				+ ", letturaPresenteFraz=" + letturaPresenteFraz
				+ ", provenienza=" + provenienza + ", provenienzaOld="
				+ provenienzaOld + ", overwrite=" + overwrite + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((codConcentratore == null) ? 0 : codConcentratore.hashCode());
		result = prime
				* result
				+ ((dataNuovaRilevazione == null) ? 0 : dataNuovaRilevazione
						.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((letturaPresente == null) ? 0 : letturaPresente.hashCode());
		result = prime
				* result
				+ ((letturaPresenteFraz == null) ? 0 : letturaPresenteFraz
						.hashCode());
		result = prime * result
				+ ((nuovaLettura == null) ? 0 : nuovaLettura.hashCode());
		result = prime
				* result
				+ ((nuovaLetturaFraz == null) ? 0 : nuovaLetturaFraz.hashCode());
		result = prime * result
				+ ((overwrite == null) ? 0 : overwrite.hashCode());
		result = prime * result
				+ ((provenienza == null) ? 0 : provenienza.hashCode());
		result = prime * result
				+ ((provenienzaOld == null) ? 0 : provenienzaOld.hashCode());
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
		Logletture other = (Logletture) obj;
		if (codConcentratore == null) {
			if (other.codConcentratore != null)
				return false;
		} else if (!codConcentratore.equals(other.codConcentratore))
			return false;
		if (dataNuovaRilevazione == null) {
			if (other.dataNuovaRilevazione != null)
				return false;
		} else if (!dataNuovaRilevazione.equals(other.dataNuovaRilevazione))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (letturaPresente == null) {
			if (other.letturaPresente != null)
				return false;
		} else if (!letturaPresente.equals(other.letturaPresente))
			return false;
		if (letturaPresenteFraz == null) {
			if (other.letturaPresenteFraz != null)
				return false;
		} else if (!letturaPresenteFraz.equals(other.letturaPresenteFraz))
			return false;
		if (nuovaLettura == null) {
			if (other.nuovaLettura != null)
				return false;
		} else if (!nuovaLettura.equals(other.nuovaLettura))
			return false;
		if (nuovaLetturaFraz == null) {
			if (other.nuovaLetturaFraz != null)
				return false;
		} else if (!nuovaLetturaFraz.equals(other.nuovaLetturaFraz))
			return false;
		if (overwrite == null) {
			if (other.overwrite != null)
				return false;
		} else if (!overwrite.equals(other.overwrite))
			return false;
		if (provenienza == null) {
			if (other.provenienza != null)
				return false;
		} else if (!provenienza.equals(other.provenienza))
			return false;
		if (provenienzaOld == null) {
			if (other.provenienzaOld != null)
				return false;
		} else if (!provenienzaOld.equals(other.provenienzaOld))
			return false;
		return true;
	}

	
	
}
