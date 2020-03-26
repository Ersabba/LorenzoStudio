package com.ericsson.mgre.datatypes;

import java.io.Serializable;


public class ThorFileNewTaskInput implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int durata_finestra_temporale = 0;
	private int maxVetustaLetture = 0;
	private String prefisso_nome_filenew = "NEW";
	
	public int getDurata_finestra_temporale() {
		return durata_finestra_temporale;
	}
	public void setDurata_finestra_temporale(int durata_finestra_temporale) {
		this.durata_finestra_temporale = durata_finestra_temporale;
	}
	public int getMaxVetustaLetture() {
		return maxVetustaLetture;
	}
	public void setMaxVetustaLetture(int maxVetustaLetture) {
		this.maxVetustaLetture = maxVetustaLetture;
	}
	public String getPrefisso_nome_filenew() {
		return prefisso_nome_filenew;
	}
	public void setPrefisso_nome_filenew(String prefisso_nome_filenew) {
		this.prefisso_nome_filenew = prefisso_nome_filenew;
	}

}
