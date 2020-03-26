package com.ericsson.urm.persistence.dto.mgre.datatype;

import java.io.Serializable;

import com.ericsson.urm.persistence.dto.mgre.CrzLenntProfilo;

public class CrzAutoProfile implements Serializable {
	private static final long serialVersionUID = -1L;
	
	private CrzLenntProfilo profilo;
	private boolean aggiornato = false;
	public CrzLenntProfilo getProfilo() {
		return profilo;
	}
	public void setProfilo(CrzLenntProfilo profilo) {
		this.profilo = profilo;
	}
	public boolean isAggiornato() {
		return aggiornato;
	}
	public void setAggiornato(boolean aggiornato) {
		this.aggiornato = aggiornato;
	}

}
