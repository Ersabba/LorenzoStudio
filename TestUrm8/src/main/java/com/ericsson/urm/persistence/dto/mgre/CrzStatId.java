package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the GRE_CRZ_STAT database table.
 *
 */
@Embeddable
public class CrzStatId implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="MATRICOLA_CRZ", unique=true, nullable=false, length=13)
	private String matricolaCrz;

	@Temporal(TemporalType.DATE)
	@Column(unique=true, nullable=false)
	private java.util.Date urmdate;

	public CrzStatId() {
	}
	public String getMatricolaCrz() {
		return this.matricolaCrz;
	}
	public void setMatricolaCrz(String matricolaCrz) {
		this.matricolaCrz = matricolaCrz;
	}
	public java.util.Date getUrmdate() {
		return this.urmdate;
	}
	public void setUrmdate(java.util.Date urmdate) {
		this.urmdate = urmdate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CrzStatId)) {
			return false;
		}
		CrzStatId castOther = (CrzStatId)other;
		return
			this.matricolaCrz.equals(castOther.matricolaCrz)
			&& this.urmdate.equals(castOther.urmdate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.matricolaCrz.hashCode();
		hash = hash * prime + this.urmdate.hashCode();

		return hash;
	}
	@Override
	public String toString() {
		return "CrzStatId [matricolaCrz=" + matricolaCrz + ", urmdate="
				+ urmdate + "]";
	}
	
	
}