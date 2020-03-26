package com.ericsson.urm.device.driver.registersblockprogramming;


public class Block22 implements RegistersBlock {

	private static final long	serialVersionUID	= 1L;

	private String	sitoNotifica;

	public String getSitoNotifica() {
		return sitoNotifica;
	}

	public void setSitoNotifica(String sitoNotifica) {
		this.sitoNotifica = sitoNotifica;
	}
}
