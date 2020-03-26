package com.ericsson.urm.device.driver.executionchecking;

import com.ericsson.urm.device.driver.CommunicationException;
import com.ericsson.urm.device.driver.DeviceDriverException;

public interface LenntSessionExecutionChecker {

	public void setOperationName(String operationName);

	public void checkPreExecution() throws DeviceDriverException, ExecutionCheckingException, CommunicationException,UnsupportedOperationException;
	public void checkPostExecution() throws DeviceDriverException, ExecutionCheckingException, CommunicationException,UnsupportedOperationException;

	public void manageException(Exception ex) throws DeviceDriverException, ExecutionCheckingException, CommunicationException,UnsupportedOperationException;

}
