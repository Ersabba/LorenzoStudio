package com.ericsson.urm.device.driver.registersreading;

public interface ITcpIpParameterResponse extends IReadingRegisterResponse {

	public String getIpAddress();

	public int getPort();


}
