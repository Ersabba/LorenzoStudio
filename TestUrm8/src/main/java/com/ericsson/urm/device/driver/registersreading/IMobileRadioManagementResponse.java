package com.ericsson.urm.device.driver.registersreading;

public interface IMobileRadioManagementResponse extends IReadingRegisterResponse {
	
	public int getNumberOfRetryForFailedConnection();

	public int getPeriodicityOfRetryInHours();

	public int getPeriodicityOfSendingDataInDays();

	public int getHourToSendData();

	public int getMinuteToSendData();

	public int getWaitingTimeoutRequestInseconds();

}
