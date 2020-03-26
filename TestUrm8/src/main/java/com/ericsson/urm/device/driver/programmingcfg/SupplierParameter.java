package com.ericsson.urm.device.driver.programmingcfg;

import java.io.Serializable;
import java.util.Date;

public class SupplierParameter implements Serializable {

	private static final long serialVersionUID = -1L;

	public SupplierParameter() {
		super();
	}

	private ParameterLA parameterLa = null;
	private int cp1;
	private int cp2;
	private int cp3;
	private int cp4;
	private ParameterPAR parameterPar;
	private ParameterIP parameterIp;
	private int gu;
	private int k1;
	private int k2;
	private Date dataAttivazione;
	private Date dataScadenza;

	public int getCp1() {
		return cp1;
	}

	public void setCp1(int cp1) {
		this.cp1 = cp1;
	}

	public int getCp2() {
		return cp2;
	}

	public void setCp2(int cp2) {
		this.cp2 = cp2;
	}

	public int getCp3() {
		return cp3;
	}

	public void setCp3(int cp3) {
		this.cp3 = cp3;
	}

	public int getCp4() {
		return cp4;
	}

	public void setCp4(int cp4) {
		this.cp4 = cp4;
	}

	public int getGu() {
		return gu;
	}

	public void setGu(int gu) {
		this.gu = gu;
	}

	public int getK1() {
		return k1;
	}

	public void setK1(int k1) {
		this.k1 = k1;
	}

	public int getK2() {
		return k2;
	}

	public void setK2(int k2) {
		this.k2 = k2;
	}

	public Date getDataAttivazione() {
		return dataAttivazione;
	}

	public void setDataAttivazione(Date dataAttivazione) {
		this.dataAttivazione = dataAttivazione;
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public ParameterLA getParameterLa() {
		return parameterLa;
	}

	public void setParameterLa(ParameterLA parameterLa) {
		this.parameterLa = parameterLa;
	}

	public ParameterPAR getParameterPar() {
		return parameterPar;
	}

	public void setParameterPar(ParameterPAR parameterPar) {
		this.parameterPar = parameterPar;
	}

	public ParameterIP getParameterIp() {
		return parameterIp;
	}

	public void setParameterIp(ParameterIP parameterIp) {
		this.parameterIp = parameterIp;
	}

}
