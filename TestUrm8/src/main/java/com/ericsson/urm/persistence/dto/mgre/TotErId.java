package com.ericsson.urm.persistence.dto.mgre;

import java.util.Date;

public class TotErId implements java.io.Serializable, Cloneable {
	
	private static final long serialVersionUID = 1L;
	
	private String matricolaLenntCliente;
	private Date dataRil;
		
	public TotErId(){
		
	}
	
	public Object clone() {
		try {
			TotErId ret = (TotErId) super.clone();
			if (dataRil != null)
				ret.dataRil = (Date) dataRil.clone();
			return ret;
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}

	public TotErId(String matricolaLenntCliente, Date dataRil) {
		super();
		this.matricolaLenntCliente = matricolaLenntCliente;
		this.dataRil = dataRil;
	}



	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}

	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}

	public Date getDataRil() {
		return dataRil;
	}

	public void setDataRil(Date dataRil) {
		this.dataRil = dataRil;
	}

	public String toString() {
		return "TotErId [dataRil=" + dataRil + ", matricolaLenntCliente="
				+ matricolaLenntCliente + "]";
	}
	
		
}