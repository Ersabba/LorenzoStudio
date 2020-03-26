package com.ericsson.mgre.datatypes;

import java.io.Serializable;

public class NumeroCampioniReperiti implements Serializable {
	
	private static final long	serialVersionUID	= -1L;
	
	int countAttAss;
	int countReattIndAss;
	int countReattCapAss;
	int countAttEr;
	int countReattIndEr;
	int countReattCapEr;
	String periodoAcquisizione = null;
	
	public NumeroCampioniReperiti() {
	}	
	
	public NumeroCampioniReperiti(int countAttAss, int countReattIndAss,
			int countReattCapAss, int countAttEr, int countReattIndEr,
			int countReattCapEr, String periodoAcquisizione) {
		super();
		this.countAttAss = countAttAss;
		this.countReattIndAss = countReattIndAss;
		this.countReattCapAss = countReattCapAss;
		this.countAttEr = countAttEr;
		this.countReattIndEr = countReattIndEr;
		this.countReattCapEr = countReattCapEr;
		this.periodoAcquisizione = periodoAcquisizione;
	}

	public int getCountAttAss() {
		return countAttAss;
	}
	public void setCountAttAss(int countAttAss) {
		this.countAttAss = countAttAss;
	}
	public int getCountReattIndAss() {
		return countReattIndAss;
	}
	public void setCountReattIndAss(int countReattIndAss) {
		this.countReattIndAss = countReattIndAss;
	}
	public int getCountReattCapAss() {
		return countReattCapAss;
	}
	public void setCountReattCapAss(int countReattCapAss) {
		this.countReattCapAss = countReattCapAss;
	}
	public int getCountAttEr() {
		return countAttEr;
	}
	public void setCountAttEr(int countAttEr) {
		this.countAttEr = countAttEr;
	}
	public int getCountReattIndEr() {
		return countReattIndEr;
	}
	public void setCountReattIndEr(int countReattIndEr) {
		this.countReattIndEr = countReattIndEr;
	}
	public int getCountReattCapEr() {
		return countReattCapEr;
	}
	public void setCountReattCapEr(int countReattCapEr) {
		this.countReattCapEr = countReattCapEr;
	}
	public String getPeriodoAcquisizione() {
		return periodoAcquisizione;
	}
	public void setPeriodoAcquisizione(String periodoAcquisizione) {
		this.periodoAcquisizione = periodoAcquisizione;
	}
		
}
