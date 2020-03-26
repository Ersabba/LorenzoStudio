package com.ericsson.urm.device.driver.programmingcfg;

import java.io.Serializable;

public class ProgrammingConfiguration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SupplierParameter supplierParameter;
	private PowerParameter powerParameter;

	public SupplierParameter getSupplierParameter() {
		return supplierParameter != null ? supplierParameter : new SupplierParameter();
	}

	public void setSupplierParameter(SupplierParameter supplierParameter) {
		this.supplierParameter = supplierParameter;
	}

	public PowerParameter getPowerParameter() {
		return powerParameter != null ? powerParameter : new PowerParameter();
	}

	public void setPowerParameter(PowerParameter powerParameter) {
		this.powerParameter = powerParameter;
	}

}
