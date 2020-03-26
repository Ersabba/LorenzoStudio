package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;

public class UtenzeCM implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String matricolaLenntCliente=null;
	private int eea=1;
	private int eua=0;
	private int eei=0;
	private int eui=0;
	private int eec=0;
	private int euc=0;
	private int ipmEea=0;
		
	public UtenzeCM() {
		super();
	}

	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}

	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}

	public int getEea() {
		return eea;
	}

	public void setEea(int eea) {
		this.eea = eea;
	}

	public int getEua() {
		return eua;
	}

	public void setEua(int eua) {
		this.eua = eua;
	}

	public int getEei() {
		return eei;
	}

	public void setEei(int eei) {
		this.eei = eei;
	}

	public int getEui() {
		return eui;
	}

	public void setEui(int eui) {
		this.eui = eui;
	}

	public int getEec() {
		return eec;
	}

	public void setEec(int eec) {
		this.eec = eec;
	}

	public int getEuc() {
		return euc;
	}

	public void setEuc(int euc) {
		this.euc = euc;
	}

	public int getIpmEea() {
		return ipmEea;
	}

	public void setIpmEea(int ipmEea) {
		this.ipmEea = ipmEea;
	}

	@Override
	public String toString() {
		return "UtenzeCM [matricolaLenntCliente=" + matricolaLenntCliente + ", eea=" + eea + ", eua=" + eua + ", eei="
				+ eei + ", eui=" + eui + ", eec=" + eec + ", euc=" + euc + ", ipmEea=" + ipmEea + "]";
	}
}