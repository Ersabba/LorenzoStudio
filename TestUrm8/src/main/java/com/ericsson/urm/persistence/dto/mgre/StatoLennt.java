package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

public class StatoLennt implements Serializable {
	private static final long serialVersionUID = -1;

	private String matricolaLenntCliente;
	private Date dataRil;
	private String letturaStato;
	private Date dataReset;
	private Date dataAntitamperOn;
	private Date dataAntitamperOff;
	
	public StatoLennt() {}
	
	

	public StatoLennt(String matricolaLenntCliente, String letturaStato, Date dataRil) {
		super();
		this.matricolaLenntCliente = matricolaLenntCliente;
		this.letturaStato = letturaStato;
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



	public String getLetturaStato() {
		return letturaStato;
	}



	public void setLetturaStato(String letturaStato) {
		this.letturaStato = letturaStato;
	}



	public Date getDataReset() {
		return dataReset;
	}



	public void setDataReset(Date dataReset) {
		this.dataReset = dataReset;
	}



	public Date getDataAntitamperOn() {
		return dataAntitamperOn;
	}



	public void setDataAntitamperOn(Date dataAntitamperOn) {
		this.dataAntitamperOn = dataAntitamperOn;
	}



	public Date getDataAntitamperOff() {
		return dataAntitamperOff;
	}



	public void setDataAntitamperOff(Date dataAntitamperOff) {
		this.dataAntitamperOff = dataAntitamperOff;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((dataAntitamperOff == null) ? 0 : dataAntitamperOff
						.hashCode());
		result = prime
				* result
				+ ((dataAntitamperOn == null) ? 0 : dataAntitamperOn.hashCode());
		result = prime * result
				+ ((dataReset == null) ? 0 : dataReset.hashCode());
		result = prime * result + ((dataRil == null) ? 0 : dataRil.hashCode());
		result = prime * result
				+ ((letturaStato == null) ? 0 : letturaStato.hashCode());
		result = prime
				* result
				+ ((matricolaLenntCliente == null) ? 0 : matricolaLenntCliente
						.hashCode());
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
		StatoLennt other = (StatoLennt) obj;
		if (dataAntitamperOff == null) {
			if (other.dataAntitamperOff != null)
				return false;
		} else if (!dataAntitamperOff.equals(other.dataAntitamperOff))
			return false;
		if (dataAntitamperOn == null) {
			if (other.dataAntitamperOn != null)
				return false;
		} else if (!dataAntitamperOn.equals(other.dataAntitamperOn))
			return false;
		if (dataReset == null) {
			if (other.dataReset != null)
				return false;
		} else if (!dataReset.equals(other.dataReset))
			return false;
		if (dataRil == null) {
			if (other.dataRil != null)
				return false;
		} else if (!dataRil.equals(other.dataRil))
			return false;
		if (letturaStato == null) {
			if (other.letturaStato != null)
				return false;
		} else if (!letturaStato.equals(other.letturaStato))
			return false;
		if (matricolaLenntCliente == null) {
			if (other.matricolaLenntCliente != null)
				return false;
		} else if (!matricolaLenntCliente.equals(other.matricolaLenntCliente))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "StatoLennt [matricolaLenntCliente=" + matricolaLenntCliente
				+ ", dataRil=" + dataRil + ", letturaStato=" + letturaStato
				+ ", dataReset=" + dataReset + ", dataAntitamperOn="
				+ dataAntitamperOn + ", dataAntitamperOff=" + dataAntitamperOff
				+ "]";
	}
	
	



	

	
}
