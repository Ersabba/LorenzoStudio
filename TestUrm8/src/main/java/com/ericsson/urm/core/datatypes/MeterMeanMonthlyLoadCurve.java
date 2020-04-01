package com.ericsson.urm.core.datatypes;

import java.io.Serializable;
import java.util.Date;
import java.util.EnumMap;
import java.util.Map;

import com.ericsson.urm.core.enumeration.Power;


public class MeterMeanMonthlyLoadCurve implements Serializable {


	private static final long serialVersionUID = -1L;
	
	private String					matricolaLennt;
	private Date					dataCurva;
	private Map<Power, Integer[]>	potenzeMedieOrarie;

	public void setPotenzaMediaOraria(Power tipoPotenza, Integer ora_1_24, Integer potenza) {
		if (potenzeMedieOrarie == null)
			potenzeMedieOrarie = new EnumMap<Power, Integer[]>(Power.class);
		if (!potenzeMedieOrarie.containsKey(tipoPotenza))
			potenzeMedieOrarie.put(tipoPotenza, new Integer[24]);
		potenzeMedieOrarie.get(tipoPotenza)[ora_1_24 - 1] = potenza;
	}

	public Map<Power, Integer[]> getPotenzeMedieOrarie() {
		return potenzeMedieOrarie;
	}

	public String getMatricolaLennt() {
		return matricolaLennt;
	}

	public void setMatricolaLennt(String matricolaLennt) {
		this.matricolaLennt = matricolaLennt;
	}

	public Date getDataCurva() {
		return dataCurva;
	}

	public void setDataCurva(Date dataCurva) {
		this.dataCurva = dataCurva;
	}
}
