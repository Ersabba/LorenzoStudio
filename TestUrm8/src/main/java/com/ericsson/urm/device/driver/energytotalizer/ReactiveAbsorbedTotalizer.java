package com.ericsson.urm.device.driver.energytotalizer;



public class ReactiveAbsorbedTotalizer extends GenericTotalizer {

	private static final long serialVersionUID = -1L;
	
	private double racGen = -1;
	private double raiGen = -1;
	private double rai1 = -1;
	private double rai2 = -1;
	private double rai3 = -1;
	private double rai4 = -1;
	private boolean dataChiusuraValida;

	public ReactiveAbsorbedTotalizer() {
		super();
	}

	public double getRacGen() {
		return racGen;
	}

	public double getRaiGen() {
		return raiGen;
	}

	public double getRai1() {
		return rai1;
	}

	public double getRai2() {
		return rai2;
	}

	public double getRai3() {
		return rai3;
	}

	public double getRai4() {
		return rai4;
	}

	public void setRacGen(double racGen) {
		this.racGen = racGen;
	}

	public void setRaiGen(double raiGen) {
		this.raiGen = raiGen;
	}

	public void setRai1(double rai1) {
		this.rai1 = rai1;
	}

	public void setRai2(double rai2) {
		this.rai2 = rai2;
	}

	public void setRai3(double rai3) {
		this.rai3 = rai3;
	}

	public void setRai4(double rai4) {
		this.rai4 = rai4;
	}

	public boolean isDataChiusuraValida() {
		return dataChiusuraValida;
	}

	public void setDataChiusuraValida(boolean dataChiusuraValida) {
		this.dataChiusuraValida = dataChiusuraValida;
	}

}
