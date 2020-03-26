package com.ericsson.urm.device.driver;

import com.ericsson.urm.device.driver.exceptions.DeviceCommunicationException;
import com.ericsson.urm.device.driver.exceptions.DriverException;
import com.ericsson.urm.device.driver.exceptions.UnauthorizedException;

public interface IDriverSession extends IDriver {

	public void init() throws DriverException, DeviceCommunicationException, UnauthorizedException;
	public void close() throws DriverException, DeviceCommunicationException;
	
}
