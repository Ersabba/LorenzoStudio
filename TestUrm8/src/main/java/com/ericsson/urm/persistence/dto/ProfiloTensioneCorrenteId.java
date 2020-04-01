package com.ericsson.urm.persistence.dto;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.core.enumeration.HourlyTimeSlot;
import com.ericsson.urm.core.enumeration.Phase;
import com.ericsson.urm.core.enumeration.VoltageCurrent;


public class ProfiloTensioneCorrenteId implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private String				matricolaLenntCliente;
	private Date				dataProfilo;
	private String				tipoProfilo;
	private Integer				fasciaOraria;
	private String             	fase;
	
	public ProfiloTensioneCorrenteId() {
		super();
	}

	public ProfiloTensioneCorrenteId(String matricolaLenntCliente,
			Date dataProfilo, String tipoProfilo, Integer fasciaOraria, Phase fase) {
		super();
		this.matricolaLenntCliente = matricolaLenntCliente;
		this.dataProfilo = dataProfilo;
		this.tipoProfilo = tipoProfilo;
		this.fasciaOraria = fasciaOraria;
		this.fase = (fase != null ? fase.toString() : null);
	}

	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}

	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}

	public Date getDataProfilo() {
		return dataProfilo;
	}

	public void setDataProfilo(Date dataProfilo) {
		this.dataProfilo = dataProfilo;
	}

	public VoltageCurrent getTipoProfilo() {
		return (tipoProfilo != null) ? VoltageCurrent.parse(tipoProfilo) : null;
	}

	public void setTipoProfilo(VoltageCurrent tipoProfilo) {
		this.tipoProfilo = tipoProfilo!=null ? tipoProfilo.toString() : null;
	}

	public HourlyTimeSlot getFasciaOraria() {
		return fasciaOraria!=null ? HourlyTimeSlot.fromValue(fasciaOraria) : null;
	}

	public void setFasciaOraria(HourlyTimeSlot fasciaOraria) {
		this.fasciaOraria = fasciaOraria!=null ? fasciaOraria.dbValue() : null;
	}
	
	public Phase getFase() {
		return fase!=null ? Phase.parse(fase) : null;
	}

	public void setFase(Phase fase) {
		this.fase = fase != null ? fase.toString() : null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataProfilo == null) ? 0 : dataProfilo.hashCode());
		result = prime * result
				+ ((fasciaOraria == null) ? 0 : fasciaOraria.hashCode());
		result = prime * result + ((fase == null) ? 0 : fase.hashCode());
		result = prime
				* result
				+ ((matricolaLenntCliente == null) ? 0 : matricolaLenntCliente
						.hashCode());
		result = prime * result
				+ ((tipoProfilo == null) ? 0 : tipoProfilo.hashCode());
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
		ProfiloTensioneCorrenteId other = (ProfiloTensioneCorrenteId) obj;
		if (dataProfilo == null) {
			if (other.dataProfilo != null)
				return false;
		} else if (!dataProfilo.equals(other.dataProfilo))
			return false;
		if (fasciaOraria == null) {
			if (other.fasciaOraria != null)
				return false;
		} else if (!fasciaOraria.equals(other.fasciaOraria))
			return false;
		if (fase == null) {
			if (other.fase != null)
				return false;
		} else if (!fase.equals(other.fase))
			return false;
		if (matricolaLenntCliente == null) {
			if (other.matricolaLenntCliente != null)
				return false;
		} else if (!matricolaLenntCliente.equals(other.matricolaLenntCliente))
			return false;
		if (tipoProfilo == null) {
			if (other.tipoProfilo != null)
				return false;
		} else if (!tipoProfilo.equals(other.tipoProfilo))
			return false;
		return true;
	}
}
