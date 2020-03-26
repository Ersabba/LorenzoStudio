package com.ericsson.urm.device.driver.registersreading;

public interface IAccessPointCredentialsResponse extends IReadingRegisterResponse {

	public String getUserName();
	
	public String getPassword();

}
