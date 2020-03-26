package com.ericsson.urm.device.driver.registersblockprogramming;


public class Block20 implements RegistersBlock {

	private static final long	serialVersionUID	= 1L;

	private String	emailCentro;

	public String getEmailCentro() {
		return emailCentro;
	}

	public void setEmailCentro(String emailCentro) {
		this.emailCentro = emailCentro;
	}
}
