package com.ericsson.urm.device.driver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StatisticsCommandsOutput implements Serializable {
	
	private static final long serialVersionUID = -1L;
	
	private List<String> requestsExecutedInPreviousSession = new ArrayList<String>();
	private List<String> commandsToBeExecuted = new ArrayList<String>();
	private List<String> commandsExecuted = new ArrayList<String>();

	public StatisticsCommandsOutput() {
	}

	public List<String> getCommandsExecuted() {
		
		return commandsExecuted;
	}
	
	public List<String> getRequestsExecutedInPreviousSession() {
		return requestsExecutedInPreviousSession;
	}

	public void setRequestsExecutedInPreviousSession(
			List<String> requestsExecutedInPreviousSession) {
		this.requestsExecutedInPreviousSession = requestsExecutedInPreviousSession;
	}

	public void setCommandsExecuted(List<String> commandsExecuted) {
		if( commandsExecuted == null ) {
			commandsExecuted = new ArrayList<String>();
		}
		this.commandsExecuted = commandsExecuted;
	}
	
	public void addAllCommandsExecuted(List<String> commandsExecuted) {
		if( commandsExecuted == null ) {
			commandsExecuted = new ArrayList<String>();
		}
		this.commandsExecuted.addAll(commandsExecuted);
	}

	public List<String> getCommandsToBeExecuted() {
		return commandsToBeExecuted;
	}

	public void setCommandsToBeExecuted(List<String> commandsToBeExecuted) {
		if( commandsToBeExecuted == null ) {
			commandsToBeExecuted = new ArrayList<String>();
		}
		this.commandsToBeExecuted = commandsToBeExecuted;
	}
	
	public void addAllCommandsToBeExecuted(List<String> commandsToBeExecuted) {
		if( commandsToBeExecuted == null ) {
			commandsToBeExecuted = new ArrayList<String>();
		}
		this.commandsToBeExecuted.addAll(commandsToBeExecuted);
	}
	
	public void addCommandsToBeExecuted(String commandToBeExecuted) {
		if( commandToBeExecuted != null && !commandToBeExecuted.trim().isEmpty() ) {
			this.commandsToBeExecuted.add(commandToBeExecuted);
		}
	}
}
