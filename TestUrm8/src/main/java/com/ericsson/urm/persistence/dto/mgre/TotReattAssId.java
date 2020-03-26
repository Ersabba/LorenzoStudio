package com.ericsson.urm.persistence.dto.mgre;

import java.util.Date;

public class TotReattAssId implements java.io.Serializable, Cloneable {
	
	private static final long serialVersionUID = 1L;
	
	private String matricolaLenntCliente;
	private Date dataRil;
		
	public Object clone() {
		try {
			TotReattAssId ret = (TotReattAssId) super.clone();
			if (dataRil != null)
				ret.dataRil = (Date) dataRil.clone();
			return ret;
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	public TotReattAssId(){
		
	}
	
	

	public TotReattAssId(String matricolaLenntCliente, Date dataRil) {
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
		return "TotReattAssId [dataRil=" + dataRil + ", matricolaLenntCliente="
				+ matricolaLenntCliente + "]";
	}
	
		
}