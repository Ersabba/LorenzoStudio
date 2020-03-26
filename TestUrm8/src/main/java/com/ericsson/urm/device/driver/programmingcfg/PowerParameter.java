package com.ericsson.urm.device.driver.programmingcfg;

import java.io.Serializable;

public class PowerParameter implements Serializable {

	public PowerParameter() {
		super();
	}

	private int potenzaSupero1 = -1;
	private int potenzaSupero2 = -1;
	private int potenzaSupero3 = -1;
	private int potenzaSupero4 = -1;
	private int potenzaLimite = -1;
	private int tempoAvviso = -1;
	private int periodoTolleranza = -1;

	public int getPotenzaSupero1() {
		return potenzaSupero1;
	}

	public void setPotenzaSupero1(int potenzaSupero1) {
		this.potenzaSupero1 = potenzaSupero1;
	}

	public int getPotenzaSupero2() {
		return potenzaSupero2;
	}

	public void setPotenzaSupero2(int potenzaSupero2) {
		this.potenzaSupero2 = potenzaSupero2;
	}

	public int getPotenzaSupero3() {
		return potenzaSupero3;
	}

	public void setPotenzaSupero3(int potenzaSupero3) {
		this.potenzaSupero3 = potenzaSupero3;
	}

	public int getPotenzaSupero4() {
		return potenzaSupero4;
	}

	public void setPotenzaSupero4(int potenzaSupero4) {
		this.potenzaSupero4 = potenzaSupero4;
	}

	public int getPotenzaLimite() {
		return potenzaLimite;
	}

	public void setPotenzaLimite(int potenzaLimite) {
		this.potenzaLimite = potenzaLimite;
	}

	public int getTempoAvviso() {
		return tempoAvviso;
	}

	public void setTempoAvviso(int tempoAvviso) {
		this.tempoAvviso = tempoAvviso;
	}

	public int getPeriodoTolleranza() {
		return periodoTolleranza;
	}

	public void setPeriodoTolleranza(int periodoTolleranza) {
		this.periodoTolleranza = periodoTolleranza;
	}

}
