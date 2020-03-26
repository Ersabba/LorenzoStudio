package com.ericsson.urm.device.driver;

import java.io.Serializable;

public class PowerData implements Serializable {

	private int attivaAssorbita = -1;
	private int reattivaCapacitivaAssorbita = -1;
	private int reattivaInduttivaAssorbita = -1;
	private int attivaErogata = -1;
	private int reattivaCapacitivaErogata = -1;
	private int reattivaInduttivaErogata = -1;

	public void setAttivaAssorbita(int attivaAssorbita) {
		this.attivaAssorbita = attivaAssorbita;
	}

	public void setReattivaCapacitivaAssorbita(int reattivaCapacitivaAssorbita) {
		this.reattivaCapacitivaAssorbita = reattivaCapacitivaAssorbita;
	}

	public void setReattivaInduttivaAssorbita(int reattivaInduttivaAssorbita) {
		this.reattivaInduttivaAssorbita = reattivaInduttivaAssorbita;
	}

	public void setAttivaErogata(int attivaErogata) {
		this.attivaErogata = attivaErogata;
	}

	public void setReattivaCapacitivaErogata(int reattivaCapacitivaErogata) {
		this.reattivaCapacitivaErogata = reattivaCapacitivaErogata;
	}

	public void setReattivaInduttivaErogata(int reattivaInduttivaErogata) {
		this.reattivaInduttivaErogata = reattivaInduttivaErogata;
	}

	public int getAttivaAssorbita() {
		return attivaAssorbita;
	}

	public int getReattivaCapacitivaAssorbita() {
		return reattivaCapacitivaAssorbita;
	}

	public int getReattivaInduttivaAssorbita() {
		return reattivaInduttivaAssorbita;
	}

	public int getAttivaErogata() {
		return attivaErogata;
	}

	public int getReattivaCapacitivaErogata() {
		return reattivaCapacitivaErogata;
	}

	public int getReattivaInduttivaErogata() {
		return reattivaInduttivaErogata;
	}

}
