package com.ericsson.urm.core.datatypes;

import java.io.Serializable;
import java.util.Date;

public class VoltageCurrentProfileNaturalId implements Serializable {

	private static final long serialVersionUID = -1L;

	private String				matricolaLenntCliente;
	private Date				dataProfilo;
	private String				tipoProfilo;
	private Integer				fasciaOraria;
	private String              fase;
	
	public VoltageCurrentProfileNaturalId() {
		super();
	}
	
	public VoltageCurrentProfileNaturalId(String matricolaLenntCliente,
			Date dataProfilo, String tipoProfilo, Integer fasciaOraria,
			String fase) {
		super();
		this.matricolaLenntCliente = matricolaLenntCliente;
		this.dataProfilo = dataProfilo;
		this.tipoProfilo = tipoProfilo;
		this.fasciaOraria = fasciaOraria;
		this.fase = fase;
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
	public String getTipoProfilo() {
		return tipoProfilo;
	}
	public void setTipoProfilo(String tipoProfilo) {
		this.tipoProfilo = tipoProfilo;
	}
	public Integer getFasciaOraria() {
		return fasciaOraria;
	}
	public void setFasciaOraria(Integer fasciaOraria) {
		this.fasciaOraria = fasciaOraria;
	}
	public String getFase() {
		return fase;
	}
	public void setFase(String fase) {
		this.fase = fase;
	}	
	
}
