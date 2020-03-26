package com.ericsson.urm.device.driver.registersblockprogramming;


public class SettingLoadCurvesRequest implements RegistersBlock {

	private static final long	serialVersionUID	= 1L;
	
	public static enum CommandRequest {
		LOADCURVES_ENABLE,
		LOADCURVES_DISABLE,
		LOADCURVES_CANCEL;
	}

	private CommandRequest	commandRequest;
	

	public SettingLoadCurvesRequest() {
		super();
	}

	public SettingLoadCurvesRequest(CommandRequest commandRequest) {
		super();
		this.commandRequest = commandRequest;
	}

	public CommandRequest getCommandRequest() {
		return commandRequest;
	}

	public void setCommandRequest(CommandRequest commandRequest) {
		this.commandRequest = commandRequest;
	}
}
