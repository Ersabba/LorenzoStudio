package com.ericsson.urm.device.driver.registersreading;

public interface ICommOnZVEILineResponse extends IReadingRegisterResponse {
	public boolean isInfraMonthlyEnabled();

	public int getDayOfAcquisitionInfraMonthly();

	public int getNumberOfRetryConnectionFailed();
}
