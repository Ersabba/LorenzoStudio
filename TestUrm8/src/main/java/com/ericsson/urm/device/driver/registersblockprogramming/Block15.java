package com.ericsson.urm.device.driver.registersblockprogramming;


public class Block15 implements RegistersBlock {

	private static final long	serialVersionUID	= 1L;

	private String	password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
