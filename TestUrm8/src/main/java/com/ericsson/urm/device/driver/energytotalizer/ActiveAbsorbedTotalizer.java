package com.ericsson.urm.device.driver.energytotalizer;



public class ActiveAbsorbedTotalizer extends GenericTotalizer {

	private static final long serialVersionUID = -1L;
	
	private double eagen = -1;
	private double ea1 = -1;
	private double ea2 = -1;
	private double ea3 = -1;
	private double ea4 = -1;
	private boolean dataChiusuraValida;
	

	public ActiveAbsorbedTotalizer() {
		super();
	}

	public double getEagen() {
		return eagen;
	}

	public double getEa1() {
		return ea1;
	}

	public double getEa2() {
		return ea2;
	}

	public double getEa3() {
		return ea3;
	}

	public double getEa4() {
		return ea4;
	}

	public void setEagen(double eagen) {
		this.eagen = eagen;
	}

	public void setEa1(double ea1) {
		this.ea1 = ea1;
	}

	public void setEa2(double ea2) {
		this.ea2 = ea2;
	}

	public void setEa3(double ea3) {
		this.ea3 = ea3;
	}

	public void setEa4(double ea4) {
		this.ea4 = ea4;
	}

	public boolean isDataChiusuraValida() {
		return dataChiusuraValida;
	}

	public void setDataChiusuraValida(boolean dataChiusuraValida) {
		this.dataChiusuraValida = dataChiusuraValida;
	}
	

}
