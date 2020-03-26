package com.ericsson.urm.device.driver.registersblockprogramming;


public class Block16 implements RegistersBlock {

	private static final long	serialVersionUID	= 1L;

	private String	smtpServerName;

	public String getSmtpServerName() {
		return smtpServerName;
	}

	public void setSmtpServerName(String smtpServerName) {
		this.smtpServerName = smtpServerName;
	}
}
