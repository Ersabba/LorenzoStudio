package com.ericsson.urm.device.driver.registersblockprogramming;


public class Block13 implements RegistersBlock {

	private static final long	serialVersionUID	= 1L;

	private short				indIpCentro_3, indIpCentro_2, indIpCentro_1, indIpCentro_0;
	private String				apnCentro;

	public short getIndIpCentro_3() {
		return indIpCentro_3;
	}

	public void setIndIpCentro_3(short indIpCentro_3) {
		this.indIpCentro_3 = indIpCentro_3;
	}

	public short getIndIpCentro_2() {
		return indIpCentro_2;
	}

	public void setIndIpCentro_2(short indIpCentro_2) {
		this.indIpCentro_2 = indIpCentro_2;
	}

	public short getIndIpCentro_1() {
		return indIpCentro_1;
	}

	public void setIndIpCentro_1(short indIpCentro_1) {
		this.indIpCentro_1 = indIpCentro_1;
	}

	public short getIndIpCentro_0() {
		return indIpCentro_0;
	}

	public void setIndIpCentro_0(short indIpCentro_0) {
		this.indIpCentro_0 = indIpCentro_0;
	}

	public String getApnCentro() {
		return apnCentro;
	}

	public void setApnCentro(String apnCentro) {
		this.apnCentro = apnCentro;
	}
}
