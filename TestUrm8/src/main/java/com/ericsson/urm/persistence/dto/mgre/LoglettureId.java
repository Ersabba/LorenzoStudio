package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import com.ericsson.mgre.datatypes.TipoLettura;

public class LoglettureId implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	
	private String matricolaLenntCliente;
	private String registro;
	private String dataRilevazione;
	private String dataEstrazione;
	private String tipoLettura; //GIORNALIERA o MENSILE

	
	
	public LoglettureId() {}
	
	public Object clone() {
		try {
			return super.clone();
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}

	public String getDataEstrazione() {
		return dataEstrazione;
	}

	public void setDataEstrazione(String dataEstrazione) {
		this.dataEstrazione = dataEstrazione;
	}

	public String getDataRilevazione() {
		return dataRilevazione;
	}

	public void setDataRilevazione(String dataRilevazione) {
		this.dataRilevazione = dataRilevazione;
	}

	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}

	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getTipoLettura() {
		return tipoLettura;
	}

	public void setTipoLettura(String tipoLettura) {
		this.tipoLettura = tipoLettura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataEstrazione == null) ? 0 : dataEstrazione.hashCode());
		result = prime * result
				+ ((dataRilevazione == null) ? 0 : dataRilevazione.hashCode());
		result = prime
				* result
				+ ((matricolaLenntCliente == null) ? 0 : matricolaLenntCliente
						.hashCode());
		result = prime * result
				+ ((registro == null) ? 0 : registro.hashCode());
		result = prime * result
				+ ((tipoLettura == null) ? 0 : tipoLettura.hashCode());
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
		LoglettureId other = (LoglettureId) obj;
		if (dataEstrazione == null) {
			if (other.dataEstrazione != null)
				return false;
		} else if (!dataEstrazione.equals(other.dataEstrazione))
			return false;
		if (dataRilevazione == null) {
			if (other.dataRilevazione != null)
				return false;
		} else if (!dataRilevazione.equals(other.dataRilevazione))
			return false;
		if (matricolaLenntCliente == null) {
			if (other.matricolaLenntCliente != null)
				return false;
		} else if (!matricolaLenntCliente.equals(other.matricolaLenntCliente))
			return false;
		if (registro == null) {
			if (other.registro != null)
				return false;
		} else if (!registro.equals(other.registro))
			return false;
		if (tipoLettura != other.tipoLettura)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoglettureId [matricolaLenntCliente=" + matricolaLenntCliente
				+ ", registro=" + registro + ", dataRilevazione="
				+ dataRilevazione + ", dataEstrazione=" + dataEstrazione 
				+ ", tipoLettura=" + tipoLettura + "]";
	}
	
	
}