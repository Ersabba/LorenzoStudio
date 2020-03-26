package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;


public class InfoLettureId implements Serializable {

	private static final long	serialVersionUID	= -1L;

	private String				matricolaLenntCliente;
	private Date				dataRiferimento;
	private String				componente;
	
	public InfoLettureId() {
		super();
	}

	public InfoLettureId(String matricolaLenntCliente, Date dataRiferimento,
			String componente) {
		super();
		this.matricolaLenntCliente = matricolaLenntCliente;
		this.dataRiferimento = dataRiferimento;
		this.componente = componente;
	}

	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}

	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}

	public Date getDataRiferimento() {
		return dataRiferimento;
	}

	public void setDataRiferimento(Date dataRiferimento) {
		this.dataRiferimento = dataRiferimento;
	}

	public String getComponente() {
		return componente;
	}

	public void setComponente(String componente) {
		this.componente = componente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((componente == null) ? 0 : componente.hashCode());
		result = prime * result
				+ ((dataRiferimento == null) ? 0 : dataRiferimento.hashCode());
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
		InfoLettureId other = (InfoLettureId) obj;
		if (componente == null) {
			if (other.componente != null)
				return false;
		} else if (!componente.equals(other.componente))
			return false;
		if (dataRiferimento == null) {
			if (other.dataRiferimento != null)
				return false;
		} else if (!dataRiferimento.equals(other.dataRiferimento))
			return false;
		if (matricolaLenntCliente == null) {
			if (other.matricolaLenntCliente != null)
				return false;
		} else if (!matricolaLenntCliente.equals(other.matricolaLenntCliente))
			return false;
		return true;
	}
	
	
}
