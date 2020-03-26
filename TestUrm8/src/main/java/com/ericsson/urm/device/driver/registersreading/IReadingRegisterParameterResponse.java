/**
 * 
 */
package com.ericsson.urm.device.driver.registersreading;

import com.ericsson.urm.util.ArgumentsCheckerUtil;

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
 * @Time : 13:12:32
 * 
 * @Project : DEVICE_DRIVER_INTERFACE
 * 
 * @Class : com.ericsson.urm.device.driver.registersreading.IReadingRegisterParameterResponse
 * 
 */
public interface IReadingRegisterParameterResponse extends IReadingRegisterResponse {
	
	public enum ParameterId {
		CRZ_INFORMATION,
		STATISTIC_INFORMATION,
		LOG_COMMUNICATION_MOBILE,
		LOG_COMMUNICATION_ZVEI,
		LENNT_INFORMATION,
		SIM_SERIALNUMBER;
		
		public static ParameterId getByOrdinal(int ordinal) {
			ArgumentsCheckerUtil.checkMinValue(0, ordinal);
			ArgumentsCheckerUtil.checkMaxValue(ParameterId.values().length, ordinal);
			return ParameterId.values()[ordinal];
		}

	}

	public ParameterId getParameterId();
}
