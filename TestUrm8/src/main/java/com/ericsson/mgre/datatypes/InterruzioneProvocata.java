package com.ericsson.mgre.datatypes;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.persistence.dto.mgre.datatype.StatoClusterCabina;

public class InterruzioneProvocata implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codConcentratore;
	private String cabina;
	private Date dataCsv;
	private StatoClusterCabina stato;
	
	public InterruzioneProvocata() {
	}

	public InterruzioneProvocata(String codConcentratore, String cabina,
			Date dataCsv) {
		super();
		this.codConcentratore = codConcentratore;
		this.cabina = cabina;
		this.dataCsv = dataCsv;
	}

	public String getCodConcentratore() {
		return codConcentratore;
	}

	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}

	public String getCabina() {
		return cabina;
	}

	public void setCabina(String cabina) {
		this.cabina = cabina;
	}

	public Date getDataCsv() {
		return dataCsv;
	}

	public void setDataCsv(Date dataCsv) {
		this.dataCsv = dataCsv;
	}

	public StatoClusterCabina getStato() {
		return stato;
	}

	public void setStato(StatoClusterCabina stato) {
		this.stato = stato;
	}	

	
	
}
