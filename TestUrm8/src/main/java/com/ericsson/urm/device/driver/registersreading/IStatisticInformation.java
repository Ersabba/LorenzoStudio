/**
 * 
 */
package com.ericsson.urm.device.driver.registersreading;

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
 * @Time : 12:39:22
 * 
 * @Project : DEVICE_DRIVER_INTERFACE
 * 
 * @Class : com.ericsson.urm.device.driver.registersreading.IStatisticInformation
 * 
 */
public interface IStatisticInformation extends IReadingRegisterParameterResponse{

	
	public int getNoPrimitiveLentConnectionCount();
	
	public int getTotMobileConnectionCount();
	
	public int getFaultMobileConnectionCount();
	
	public int getTotZVEIConnectionCount();
	
	public int getFaultZVEIConnectionCount();
	
	public int getTotUSBConnectionCount();
	
	public int getFaultUSBConnectionCount();
	
	public int getPushButtonCount();
	
}
