package com.ericsson.urm.persistence.dto.mgre;

import java.util.Date;

public class StorTotAttAssId implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String matricolaLenntCliente;
	private Date dataRil;
		
	public StorTotAttAssId(){
		
	}
	
	

	public StorTotAttAssId(String matricolaLenntCliente, Date dataRil) {
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
		return "StorTotAttAssId [dataRil=" + dataRil
				+ ", matricolaLenntCliente=" + matricolaLenntCliente + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		StorTotAttAssId that = (StorTotAttAssId) o;

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