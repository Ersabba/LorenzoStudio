package com.ericsson.urm.device.driver.qltyvoltage;

import java.io.Serializable;

public class QualityParameterRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int periodoIntegrazione = 0; 
	private int sogliaMax = 0;
	private int sogliaMin = 0;
	
	public QualityParameterRequest(int periodoIntegrazione, int sogliaMax, int sogliaMin) {
		super();
//		if (periodoIntegrazione != 1 || periodoIntegrazione != 5)
//			throw new IllegalArgumentException("Parameter periodoIntegrazione must be 1 or 5");
		
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
