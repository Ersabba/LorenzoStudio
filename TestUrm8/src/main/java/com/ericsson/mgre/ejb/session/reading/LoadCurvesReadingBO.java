package com.ericsson.mgre.ejb.session.reading;

import java.io.Serializable;
import java.util.Date;

public class LoadCurvesReadingBO extends ReadingSelectBO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String matricolaLenntCliente = null;
	private String periodoAcquisizione = null;
	private Date dataCurva = null;
	private Long numPeriodo = null;
	private Long periodoIntegrazione = null;
	private Long attAss = null;
	private Long attEr = null;
	private Long reattCapAss = null;
	private Long reattCapEr = null;
	private Long reattIndAss = null;
	private Long reattIndEr = null;
 
    
	public LoadCurvesReadingBO() {
		super();
	}

	public LoadCurvesReadingBO(String matricolaLenntCliente,
			String periodoAcquisizione, Date dataCurva, Long numPeriodo,
			Long periodoIntegrazione, Long attAss, Long attEr,
			Long reattCapAss, Long reattCapEr, Long reattIndAss,
			Long reattIndEr) {
		super();
		this.matricolaLenntCliente = matricolaLenntCliente;
		this.periodoAcquisizione = periodoAcquisizione;
		this.dataCurva = dataCurva;
		this.numPeriodo = numPeriodo;
		this.periodoIntegrazione = periodoIntegrazione;
		this.attAss = attAss;
		this.attEr = attEr;
		this.reattCapAss = reattCapAss;
		this.reattCapEr = reattCapEr;
		this.reattIndAss = reattIndAss;
		this.reattIndEr = reattIndEr;
	}

	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}

	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}

	public String getPeriodoAcquisizione() {
		return periodoAcquisizione;
	}

	public void setPeriodoAcquisizione(String periodoAcquisizione) {
		this.periodoAcquisizione = periodoAcquisizione;
	}

	public Date getDataCurva() {
		return dataCurva;
	}

	public void setDataCurva(Date dataCurva) {
		this.dataCurva = dataCurva;
	}

	public Long getNumPeriodo() {
		return numPeriodo;
	}

	public void setNumPeriodo(Long numPeriodo) {
		this.numPeriodo = numPeriodo;
	}

	public Long getPeriodoIntegrazione() {
		return periodoIntegrazione;
	}

	public void setPeriodoIntegrazione(Long periodoIntegrazione) {
		this.periodoIntegrazione = periodoIntegrazione;
	}

	public Long getAttAss() {
		return attAss;
	}

	public void setAttAss(Long attAss) {
		this.attAss = attAss;
	}

	public Long getAttEr() {
		return attEr;
	}

	public void setAttEr(Long attEr) {
		this.attEr = attEr;
	}

	public Long getReattCapAss() {
		return reattCapAss;
	}

	public void setReattCapAss(Long reattCapAss) {
		this.reattCapAss = reattCapAss;
	}

	public Long getReattCapEr() {
		return reattCapEr;
	}

	public void setReattCapEr(Long reattCapEr) {
		this.reattCapEr = reattCapEr;
	}

	public Long getReattIndAss() {
		return reattIndAss;
	}

	public void setReattIndAss(Long reattIndAss) {
		this.reattIndAss = reattIndAss;
	}

	public Long getReattIndEr() {
		return reattIndEr;
	}

	public void setReattIndEr(Long reattIndEr) {
		this.reattIndEr = reattIndEr;
	}
}
