package com.ericsson.urm.persistence.dto.mgre.datatype;

import java.io.Serializable;
import java.util.Date;

import org.apache.log4j.Logger;

import com.ericsson.mgre.enumeration.Provenienza;
import com.ericsson.urm.device.driver.datatype.ComponentId;

public class CrzCurvaDiCarico implements Serializable {
	
	private static Logger logger = Logger.getLogger(CrzCurvaDiCarico.class);
	
	private static final long serialVersionUID = 1L;

	private String crz;
	private String lenntMat;
	private Date dataRil;
	private String numPeriodo;
	private int periodoIntegrazione=15;
	private String periodoAcquisizione="Q";
	private String eea;
	private String er;
	private String capAss;
	private String capEr;
	private String indAss;
	private String indEr;
	private Date acqDate;
	private Provenienza provenienza;
	private String esito = "0";
	
	public CrzCurvaDiCarico(String crz,
			String lenntMat, Date dataRil, String numPeriodo,
			int periodoIntegrazione, String periodoAcquisizione, String eea,
			String er, String capAss, String capEr, String indAss,
			String indEr, Date acqDate, Provenienza provenienza, String esito) {
		super();
		this.crz = crz;
		this.lenntMat = lenntMat;
		this.dataRil = dataRil;
		this.numPeriodo = numPeriodo;
		this.periodoIntegrazione = periodoIntegrazione;
		this.periodoAcquisizione = periodoAcquisizione;
		this.eea = eea;
		this.er = er;
		this.capAss = capAss;
		this.capEr = capEr;
		this.indAss = indAss;
		this.indEr = indEr;
		this.acqDate = acqDate;
		this.provenienza = provenienza;
		this.esito = esito;
	}
	
	public String getCrz() {
		return crz;
	}
	public void setCrz(String crz) {
		this.crz = crz;
	}
	public String getLenntMat() {
		return lenntMat;
	}
	public void setLenntMat(String lenntMat) {
		this.lenntMat = lenntMat;
	}
	public Date getDataRil() {
		return dataRil;
	}
	public void setDataRil(Date dataRil) {
		this.dataRil = dataRil;
	}
	public String getNumPeriodo() {
		return numPeriodo;
	}
	public void setNumPeriodo(String numPeriodo) {
		this.numPeriodo = numPeriodo;
	}
	public int getPeriodoIntegrazione() {
		return periodoIntegrazione;
	}
	public void setPeriodoIntegrazione(int periodoIntegrazione) {
		this.periodoIntegrazione = periodoIntegrazione;
	}
	public String getPeriodoAcquisizione() {
		return periodoAcquisizione;
	}
	public void setPeriodoAcquisizione(String periodoAcquisizione) {
		this.periodoAcquisizione = periodoAcquisizione;
	}
	public String getEea() {
		return eea;
	}
	public void setEea(String eea) {
		this.eea = eea;
	}
	public String getEr() {
		return er;
	}
	public void setEr(String er) {
		this.er = er;
	}
	public String getCapAss() {
		return capAss;
	}
	public void setCapAss(String capAss) {
		this.capAss = capAss;
	}
	public String getCapEr() {
		return capEr;
	}
	public void setCapEr(String capEr) {
		this.capEr = capEr;
	}
	public String getIndAss() {
		return indAss;
	}
	public void setIndAss(String indAss) {
		this.indAss = indAss;
	}
	public String getIndEr() {
		return indEr;
	}
	public void setIndEr(String indEr) {
		this.indEr = indEr;
	}
	public Date getAcqDate() {
		return acqDate;
	}
	public void setAcqDate(Date acqDate) {
		this.acqDate = acqDate;
	}
	public Provenienza getProvenienza() {
		return provenienza;
	}
	public void setProvenienza(Provenienza provenienza) {
		this.provenienza = provenienza;
	}
	public String getEsito() {
		return esito;
	}
	public void setEsito(String esito) {
		this.esito = esito;
	}
	@Override
	public String toString() {
		return "CrzCurvaDiCarico [crz=" + crz
				+ ", lenntMat=" + lenntMat + ", dataRil=" + dataRil
				+ ", numPeriodo=" + numPeriodo + ", periodoIntegrazione="
				+ periodoIntegrazione + ", periodoAcquisizione="
				+ periodoAcquisizione + ", eea=" + eea + ", er=" + er
				+ ", capAss=" + capAss + ", capEr=" + capEr + ", indAss="
				+ indAss + ", indEr=" + indEr + ", acqDate=" + acqDate
				+ ", provenienza=" + provenienza + ", esito=" + esito + "]";
	}


}
