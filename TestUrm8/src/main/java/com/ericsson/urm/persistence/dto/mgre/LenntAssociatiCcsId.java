package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LenntAssociatiCcsId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "MATRICOLA_LENNT_CLIENTE")
	private String lennt;
	
	@Column(name = "COD_CONCENTRATORE")
	private String concentratore;

	public LenntAssociatiCcsId(String lennt, String concentratore) {
		super();
		this.lennt = lennt;
		this.concentratore = concentratore;
	}

	public LenntAssociatiCcsId() {
		// TODO Auto-generated constructor stub
	}

	public String getLennt() {
		return lennt;
	}

	public void setLennt(String lennt) {
		this.lennt = lennt;
	}

	public String getConcentratore() {
		return concentratore;
	}

	public void setConcentratore(String concentratore) {
		this.concentratore = concentratore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((concentratore == null) ? 0 : concentratore.hashCode());
		result = prime * result + ((lennt == null) ? 0 : lennt.hashCode());
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
		LenntAssociatiCcsId other = (LenntAssociatiCcsId) obj;
		if (concentratore == null) {
			if (other.concentratore != null)
				return false;
		} else if (!concentratore.equals(other.concentratore))
			return false;
		if (lennt == null) {
			if (other.lennt != null)
				return false;
		} else if (!lennt.equals(other.lennt))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LenntAssociatiCcsId [lennt=" + lennt + ", concentratore=" + concentratore + "]";
	}
}