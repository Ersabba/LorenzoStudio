package com.ericsson.mgre.ejb.session.reading;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.persistence.dto.mgre.datatype.PeriodoCurve;

public class CurvaDiCaricoBO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String	meterId;
	private long 	numPeriodo;	           
	private Date 	referenceDate;
	
	private Long attAss;	               
	private Long reattIndAss;	         
	private Long reattCapAss;	         
	private Long attEr;	               
	private Long reattIndEr;	         
	private Long reattCapEr;
	
	private PeriodoCurve	periodoIntegrazione;	 
	private PeriodoCurve 	periodoAcquisizione;
	public String getMeterId() {
		return meterId;
	}
	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}
	public long getNumPeriodo() {
		return numPeriodo;
	}
	public void setNumPeriodo(long numPeriodo) {
		this.numPeriodo = numPeriodo;
	}
	public Date getReferenceDate() {
		return referenceDate;
	}
	public void setReferenceDate(Date referenceDate) {
		this.referenceDate = referenceDate;
	}
	public Long getAttAss() {
		return attAss;
	}
	public void setAttAss(Long attAss) {
		this.attAss = attAss;
	}
	public Long getReattIndAss() {
		return reattIndAss;
	}
	public void setReattIndAss(Long reattIndAss) {
		this.reattIndAss = reattIndAss;
	}
	public Long getReattCapAss() {
		return reattCapAss;
	}
	public void setReattCapAss(Long reattCapAss) {
		this.reattCapAss = reattCapAss;
	}
	public Long getAttEr() {
		return attEr;
	}
	public void setAttEr(Long attEr) {
		this.attEr = attEr;
	}
	public Long getReattIndEr() {
		return reattIndEr;
	}
	public void setReattIndEr(Long reattIndEr) {
		this.reattIndEr = reattIndEr;
	}
	public Long getReattCapEr() {
		return reattCapEr;
	}
	public void setReattCapEr(Long reattCapEr) {
		this.reattCapEr = reattCapEr;
	}
	public PeriodoCurve getPeriodoIntegrazione() {
		return periodoIntegrazione;
	}
	public void setPeriodoIntegrazione(PeriodoCurve periodoIntegrazione) {
		this.periodoIntegrazione = periodoIntegrazione;
	}
	public PeriodoCurve getPeriodoAcquisizione() {
		return periodoAcquisizione;
	}
	public void setPeriodoAcquisizione(PeriodoCurve periodoAcquisizione) {
		this.periodoAcquisizione = periodoAcquisizione;
	}
	
	
}
