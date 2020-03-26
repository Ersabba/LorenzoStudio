package com.ericsson.urm.device.driver.registersblockprogramming;


public class Block21 implements RegistersBlock {

	private static final long	serialVersionUID	= 1L;

	private int					frequenzaPing;				// in minuti
	private int					portaRemota;

	public int getFrequenzaPing() {
		return frequenzaPing;
	}

	public void setFrequenzaPing(int frequenzaPing) {
		this.frequenzaPing = frequenzaPing;
	}

	public int getPortaRemota() {
		return portaRemota;
	}

	public void setPortaRemota(int portaRemota) {
		this.portaRemota = portaRemota;
	}
}
