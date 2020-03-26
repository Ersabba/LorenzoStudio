package com.ericsson.mgre.ejb.session.reading;

import java.io.Serializable;
import java.util.Map;

import com.ericsson.urm.persistence.dto.mgre.Concentratore;
import com.ericsson.urm.persistence.dto.mgre.StoricoTotAttAssCompleto;

public class LastActiveReadingBO implements Serializable {

	private Concentratore concentratore=null;
	private StoricoTotAttAssCompleto[] readings=null;
	private Map matrFaseMap=null;
	
	
	
	
	public LastActiveReadingBO() {
		super();
	}
	public Concentratore getConcentratore() {
		return concentratore;
	}
	public void setConcentratore(Concentratore concentratore) {
		this.concentratore = concentratore;
	}
	public StoricoTotAttAssCompleto[] getReadings() {
		return readings;
	}
	public void setReadings(StoricoTotAttAssCompleto[] readings) {
		this.readings = readings;
	}
	
	public Map getMatrFaseMap() {
		return matrFaseMap;
	}
	public void setMatrFaseMap(Map matrFaseMap) {
		this.matrFaseMap = matrFaseMap;
	}
		
}
