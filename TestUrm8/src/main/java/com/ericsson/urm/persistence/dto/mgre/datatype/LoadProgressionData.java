package com.ericsson.urm.persistence.dto.mgre.datatype;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.mgre.enumeration.Provenienza;
import com.ericsson.urm.device.driver.loadcurves.LoadCurveReadingResponse.Curve.FlagStatoCampione;

public class LoadProgressionData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public enum TypeReadings {
		BY_FTP, // Letture da concentratore 
		BY_TCP,  // Letture dirette sul dispositivo
		BY_TCP_PUNCTUAL, // Sottotipo di BY_TCP (usato per distinguere le puntuali da mancanti che vanno in buffer diversi)
		BY_CRZ,  //curve di carico che arrivato tramite i crz
		BY_HSO;  //curve di carico che arrivato tramite i crz
	}
	
	public static class PeriodValue implements Serializable {
		private static final long serialVersionUID = 1L;
		public Long numPeriodo;
		public Long value;
		public FlagStatoCampione[] flagsStatoCampione;
	};
	
	private Date dataAcq;
	private Date requestDate;
	private Date dataCurva;
	private String matricolaLennt;
	private PeriodValue[] periodValues;
	private PeriodoCurve periodoCurve;
	private EnergyComponentId energyComponentId;
	
	private TypeReadings typeReadings = TypeReadings.BY_FTP;
	
	private int saved = 0;
	
	private Provenienza provenienza = null;
	
	public TypeReadings getTypeReadings() {
		return typeReadings;
	}
	public void setTypeReadings(TypeReadings typeReadings) {
		this.typeReadings = typeReadings;
	}
	public Date getDataAcq() {
		return dataAcq;
	}
	public void setDataAcq(Date dataAcq) {
		this.dataAcq = dataAcq;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public Date getDataCurva() {
		return dataCurva;
	}
	public void setDataCurva(Date dataCurva) {
		this.dataCurva = dataCurva;
	}
	public String getMatricolaLennt() {
		return matricolaLennt;
	}
	public void setMatricolaLennt(String matricolaLennt) {
		this.matricolaLennt = matricolaLennt;
	}
	
	public PeriodoCurve getPeriodoCurve() {
		return periodoCurve;
	}
	public void setPeriodoCurve(PeriodoCurve periodoCurve) {
		this.periodoCurve = periodoCurve;
	}
	public EnergyComponentId getEnergyComponentId() {
		return energyComponentId;
	}
	public void setEnergyComponentId(EnergyComponentId energyComponentId) {
		this.energyComponentId = energyComponentId;
	}
	
	public PeriodValue[] getPeriodValues() {
		return periodValues;
	}
	public void setPeriodValues(PeriodValue[] periodValues) {
		this.periodValues = periodValues;
	}
	public int getSaved() {
		return saved;
	}
	public void setSaved(int saved) {
		this.saved = saved;
	}
	public Provenienza getProvenienza() {
		return provenienza;
	}
	public void setProvenienza(Provenienza provenienza) {
		this.provenienza = provenienza;
	}

	
	
}
