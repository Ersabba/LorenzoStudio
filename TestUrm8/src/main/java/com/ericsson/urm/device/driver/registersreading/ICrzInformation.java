/**
 * 
 */
package com.ericsson.urm.device.driver.registersreading;

import java.util.Date;

/**
 * 
 * @Organization : Ericsson
 * 
 * @Organization_Unit: ACEA
 * 
 * @Author : Giampiero
 *
 * @Copyright : 2017
 * 
 * @Date : 28 set 2017
 * 
 * @Time : 12:25:47
 * 
 * @Project : DEVICE_DRIVER_INTERFACE
 * 
 * @Class : com.ericsson.urm.device.driver.registersreading.ICrzInformation
 * 
 */
public interface ICrzInformation extends IReadingRegisterParameterResponse {
	
	public String getCrzId();
	
	public byte[] getCrzStatusWord();
	
	public Date getDateTime();
	
	public int getBatteryChargeLevel();
	
	public int getLocationId();
	
	public String getCellId();
}
