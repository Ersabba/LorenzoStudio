package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the GRE_CRZ_PROFILI_FUNZIONE database table.
 * 
 */
@Entity
@Table(name="GRE_CRZ_PROFILI_FUNZIONE")
@NamedQuery(name="CrzProfiliFunzione.findAll", query="SELECT g FROM CrzProfiliFunzione g")
public class CrzProfiliFunzione implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CrzProfiliFunzionePK id;

	//bi-directional many-to-one association to CrzProfili
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_PROFILO", updatable=false, insertable=false)
	private CrzProfili crzProfili;

	//bi-directional many-to-one association to CrzFunzione
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CODE_FUNZIONE", updatable=false, insertable=false)
	private CrzFunzione crzFunzione;

	public CrzProfiliFunzione() {
	}
	
	/**
	 * @param id
	 */
	public CrzProfiliFunzione(CrzProfiliFunzionePK id) {
		super();
		this.id = id;
	}
	
	/**
	 * @param id
	 * @param crzProfili
	 * @param crzFunzione
	 */
	public CrzProfiliFunzione(CrzProfiliFunzionePK id, CrzProfili crzProfili,
			CrzFunzione crzFunzione) {
		super();
		this.id = id;
		this.crzProfili = crzProfili;
		this.crzFunzione = crzFunzione;
	}



	public CrzProfiliFunzionePK getId() {
		return this.id;
	}

	public void setId(CrzProfiliFunzionePK id) {
		this.id = id;
	}

	public CrzProfili getCrzProfili() {
		return this.crzProfili;
	}

	public void setCrzProfili(CrzProfili crzProfili) {
		this.crzProfili = crzProfili;
	}

	public CrzFunzione getCrzFunzione() {
		return this.crzFunzione;
	}

	public void setCrzFunzione(CrzFunzione crzFunzione) {
		this.crzFunzione = crzFunzione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((crzFunzione == null) ? 0 : crzFunzione.hashCode());
		result = prime * result + ((crzProfili == null) ? 0 : crzProfili.hashCode());
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
		CrzProfiliFunzione other = (CrzProfiliFunzione) obj;
		if (crzFunzione == null) {
			if (other.crzFunzione != null)
				return false;
		} else if (!crzFunzione.equals(other.crzFunzione))
			return false;
		if (crzProfili == null) {
			if (other.crzProfili != null)
				return false;
		} else if (!crzProfili.equals(other.crzProfili))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}