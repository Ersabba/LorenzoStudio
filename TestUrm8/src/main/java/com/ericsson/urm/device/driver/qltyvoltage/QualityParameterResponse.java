package com.ericsson.urm.device.driver.qltyvoltage;

import java.io.Serializable;

public class QualityParameterResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int periodoIntegrazione = 0; 
	private int sogliaMax = 0;
	private int sogliaMin = 0;
	
	public QualityParameterResponse(int periodoIntegrazione, int sogliaMax, int sogliaMin) {
		super();
		
		this.periodoIntegrazione = periodoIntegrazione;
		this.sogliaMax = sogliaMax;
		this.sogliaMin = sogliaMin;
	}

	public int getPeriodoIntegrazione() {
		return periodoIntegrazione;
	}

	public void setPeriodoIntegrazione(int periodoIntegrazione) {
		this.periodoIntegrazione = periodoIntegrazione;
	}

	public int getSogliaMax() {
		return sogliaMax;
	}

	public void setSogliaMax(int sogliaMax) {
		this.sogliaMax = sogliaMax;
	}

	public int getSogliaMin() {
		return sogliaMin;
	}

	public void setSogliaMin(int sogliaMin) {
		this.sogliaMin = sogliaMin;
	}


}
