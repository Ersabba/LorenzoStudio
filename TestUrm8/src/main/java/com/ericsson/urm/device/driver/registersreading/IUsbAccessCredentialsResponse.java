package com.ericsson.urm.device.driver.registersreading;

public interface IUsbAccessCredentialsResponse extends IReadingRegisterResponse {

	public String getUserId();

	public String getPassword();	

}
