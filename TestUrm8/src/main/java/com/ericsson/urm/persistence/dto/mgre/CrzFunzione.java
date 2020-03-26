package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;






/**
 * The persistent class for the GRE_CRZ_FUNZIONE database table.
 * 
 */
@Entity
@Table(name="GRE_CRZ_FUNZIONE")
@NamedQuery(name="CrzFunzione.findAll", query="SELECT g FROM CrzFunzione g")
public class CrzFunzione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CODE")
	private String code;

	@Column(name="ACQUISITION", nullable=false, length=1)
	private String acquisition;

	@Column(name="BIT_PAROLA_ABILITAZIONE")
	private Integer bitParolaAbilitazione;

	@Column(name="DESCRIPTION", nullable=false, length=100)
	private String description;

	@Column(name="PROGRAMMING", nullable=false, length=1)
	private String programming;

	//bi-directional many-to-one association to CrzProfiliFunzione
	@OneToMany(cascade=CascadeType.REMOVE, mappedBy="crzFunzione", fetch=FetchType.EAGER)
	private List<CrzProfiliFunzione> crzProfiliFunziones;

	public CrzFunzione() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAcquisition() {
		return this.acquisition;
	}

	public void setAcquisition(String acquisition) {
		this.acquisition = acquisition;
	}

	public Integer getBitParolaAbilitazione() {
		return this.bitParolaAbilitazione;
	}

	public void setBitParolaAbilitazione(Integer bitParolaAbilitazione) {
		this.bitParolaAbilitazione = bitParolaAbilitazione;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProgramming() {
		return this.programming;
	}

	public void setProgramming(String programming) {
		this.programming = programming;
	}

	public List<CrzProfiliFunzione> getCrzProfiliFunziones() {
		if(crzProfiliFunziones == null) {
			crzProfiliFunziones = new ArrayList<CrzProfiliFunzione>();
		}
		
		return this.crzProfiliFunziones;
	}

	public void setCrzProfiliFunziones(List<CrzProfiliFunzione> crzProfiliFunziones) {
		this.crzProfiliFunziones = crzProfiliFunziones;
	}

	public CrzProfiliFunzione addCrzProfiliFunzione(CrzProfiliFunzione crzProfiliFunzione) {
		getCrzProfiliFunziones().add(crzProfiliFunzione);
		crzProfiliFunzione.setCrzFunzione(this);

		return crzProfiliFunzione;
	}

	public CrzProfiliFunzione removeCrzProfiliFunzione(CrzProfiliFunzione crzProfiliFunzione) {
		getCrzProfiliFunziones().remove(crzProfiliFunzione);
		crzProfiliFunzione.setCrzFunzione(null);

		return crzProfiliFunzione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acquisition == null) ? 0 : acquisition.hashCode());
		result = prime * result + ((bitParolaAbilitazione == null) ? 0 : bitParolaAbilitazione.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((crzProfiliFunziones == null) ? 0 : crzProfiliFunziones.hashCode());
		result = prime * result + ((programming == null) ? 0 : programming.hashCode());
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
		CrzFunzione other = (CrzFunzione) obj;
		if (acquisition == null) {
			if (other.acquisition != null)
				return false;
		} else if (!acquisition.equals(other.acquisition))
			return false;
		if (bitParolaAbilitazione == null) {
			if (other.bitParolaAbilitazione != null)
				return false;
		} else if (!bitParolaAbilitazione.equals(other.bitParolaAbilitazione))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (crzProfiliFunziones == null) {
			if (other.crzProfiliFunziones != null)
				return false;
		} else if (!crzProfiliFunziones.equals(other.crzProfiliFunziones))
			return false;
		if (programming == null) {
			if (other.programming != null)
				return false;
		} else if (!programming.equals(other.programming))
			return false;
		return true;
	}

	
}