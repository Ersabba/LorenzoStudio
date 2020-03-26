package com.ericsson.urm.device.driver;

import java.util.Date;


public interface IConfigureRequest extends IDriver {

	
	/**
	 * Invio dell'orario al Lennt
	 * @param date
	 * @throws DeviceDriverException
	 * @throws CommunicationException
	 */
	public void synchronizeTime(Date date) throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
}
