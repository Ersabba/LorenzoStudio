package com.ericsson.urm.persistence.dto.mgre;

import java.util.Date;

public class FrazStorTotReattAssId implements java.io.Serializable, Cloneable {
	
	private static final long serialVersionUID = 1L;
	
	private String matricolaLenntCliente;
	private Date dataRil;
		
	public Object clone() {
		try {
			FrazStorTotReattAssId ret = (FrazStorTotReattAssId) super.clone();
			if (dataRil != null)
				ret.dataRil = (Date) dataRil.clone();
			return ret;
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	public FrazStorTotReattAssId(){
		
	}
	
	

	public FrazStorTotReattAssId(String matricolaLenntCliente, Date dataRil) {
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
		return "FrazStorTotReattAssId [dataRil=" + dataRil + ", matricolaLenntCliente="
				+ matricolaLenntCliente + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		FrazStorTotReattAssId that = (FrazStorTotReattAssId) o;

		if (!getMatricolaLenntCliente().equals(that.getMatricolaLenntCliente())) return false;
		return getDataRil().equals(that.getDataRil());
	}

	@Override
	public int hashCode() {
		int result = getMatricolaLenntCliente().hashCode();
		result = 31 * result + getDataRil().hashCode();
		return result;
	}
}