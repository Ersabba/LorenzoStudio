package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the GRE_CRZ_PROFILI_FUNZIONE database table.
 * 
 */
@Embeddable
public class CrzProfiliFunzionePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_PROFILO")
	private long idProfilo;

	@Column(name="CODE_FUNZIONE")
	private String codeFunzione;

	public CrzProfiliFunzionePK() {
	}
	
	
	/**
	 * @param idProfilo
	 * @param codeFunzione
	 */
	public CrzProfiliFunzionePK(long idProfilo, String codeFunzione) {
		super();
		this.idProfilo = idProfilo;
		this.codeFunzione = codeFunzione;
	}


	public long getIdProfilo() {
		return this.idProfilo;
	}
	public void setIdProfilo(long idProfilo) {
		this.idProfilo = idProfilo;
	}
	public String getCodeFunzione() {
		return this.codeFunzione;
	}
	public void setCodeFunzione(String codeFunzione) {
		this.codeFunzione = codeFunzione;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CrzProfiliFunzionePK)) {
			return false;
		}
		CrzProfiliFunzionePK castOther = (CrzProfiliFunzionePK)other;
		return 
			(this.idProfilo == castOther.idProfilo)
			&& this.codeFunzione.equals(castOther.codeFunzione);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idProfilo ^ (this.idProfilo >>> 32)));
		hash = hash * prime + this.codeFunzione.hashCode();
		
		return hash;
	}
}