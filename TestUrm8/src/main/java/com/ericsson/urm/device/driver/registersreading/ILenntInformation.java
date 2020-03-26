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
 * @Time : 12:45:58
 * 
 * @Project : DEVICE_DRIVER_INTERFACE
 * 
 * @Class : com.ericsson.urm.device.driver.registersreading.ILenntInformation
 * 
 */
public interface ILenntInformation extends IReadingRegisterParameterResponse {
	
	public String getPrimitiveMeterId();
	
	public String getCurrentMeterId();
	
	public String getCurrentStatusWord();

}
