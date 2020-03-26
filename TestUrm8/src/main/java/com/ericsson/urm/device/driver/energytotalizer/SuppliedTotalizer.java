package com.ericsson.urm.device.driver.energytotalizer;



public class SuppliedTotalizer extends GenericTotalizer {

	private static final long serialVersionUID = 1L;
	
	private double eeGen = -1;
	private double recGen = -1;
	private double reiGen = -1;

	private double ee1 = -1;
	private double ee2 = -1;
	private double ee3 = -1;
	private double ee4 = -1;
	private boolean dataChiusuraValida;

	public SuppliedTotalizer() {
		super();
	}

	public double getEeGen() {
		return eeGen;
	}

	public double getRecGen() {
		return recGen;
	}

	public double getReiGen() {
		return reiGen;
	}

	public double getEe1() {
		return ee1;
	}

	public double getEe2() {
		return ee2;
	}

	public double getEe3() {
		return ee3;
	}

	public double getEe4() {
		return ee4;
	}

	public void setEeGen(double eeGen) {
		this.eeGen = eeGen;
	}

	public void setRecGen(double recGen) {
		this.recGen = recGen;
	}

	public void setReiGen(double reiGen) {
		this.reiGen = reiGen;
	}

	public void setEe1(double ee1) {
		this.ee1 = ee1;
	}

	public void setEe2(double ee2) {
		this.ee2 = ee2;
	}

	public void setEe3(double ee3) {
		this.ee3 = ee3;
	}

	public void setEe4(double ee4) {
		this.ee4 = ee4;
	}

	public boolean isDataChiusuraValida() {
		return dataChiusuraValida;
	}

	public void setDataChiusuraValida(boolean dataChiusuraValida) {
		this.dataChiusuraValida = dataChiusuraValida;
	}

}
