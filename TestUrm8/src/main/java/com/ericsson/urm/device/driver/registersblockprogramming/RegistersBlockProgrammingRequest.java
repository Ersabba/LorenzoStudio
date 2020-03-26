package com.ericsson.urm.device.driver.registersblockprogramming;


public class RegistersBlockProgrammingRequest {

	private RegistersBlock registersBlock;
	
	public RegistersBlockProgrammingRequest() {
		super();
	}

	public RegistersBlockProgrammingRequest(RegistersBlock registersBlock) {
		super();
		this.registersBlock = registersBlock;
	}

	public RegistersBlock getRegistersBlock() {
		return registersBlock;
	}

	public void setRegistersBlock(RegistersBlock registersBlock) {
		this.registersBlock = registersBlock;
	}
}
