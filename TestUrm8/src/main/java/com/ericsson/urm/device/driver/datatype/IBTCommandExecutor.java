package com.ericsson.urm.device.driver.datatype;

import java.util.List;

import com.ericsson.urm.device.driver.DeviceDriverException;

public interface IBTCommandExecutor {
	
	public List<String> initCommandsToBeExecuted() throws DeviceDriverException;
	
	public void execute();
	
	public <T> T execute(Class<T> clsReturned);
	
	public <T> T getResponse(Class<T> clsReturned);
}
