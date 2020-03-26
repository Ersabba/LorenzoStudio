package com.ericsson.urm.device.driver.registersreading;

import java.util.Date;
import java.util.List;

public interface ILogsMobileRadioCommResponse extends IReadingRegisterResponse {
	
	public static enum StatusCommunication {
		UNDEFINED(0x01FF),
		COMMUNICATION_OK(0x00),
		SERIAL_MODEM_ERROR(0x41),
		TIMEOUT_MODEM_COMMUNICATION(0x42),
		MODEM_PROTOCOL_ERROR(0x43),
		NO_SIM(0x44),
		NETWORK_ISSUES(0x45),
		SOCKET_ERROR(0x46),
		CM_PROTOCOL_ERROR(0x47),
		CM_CONNECTION_ABORTED(0x48),
		TIMEOUT_MESSAGE_CM(0x49);
		
		private int valueStatus;

		private StatusCommunication(int valueStatus) {
			this.valueStatus = valueStatus;
		}

		public int getValueStatus() {
			return valueStatus;
		}
		
		public static StatusCommunication fromValue(int valueStatus) {
			for(StatusCommunication curr : StatusCommunication.values()) {
				if(curr.valueStatus == valueStatus) {
					return curr;
				}
			}
			return StatusCommunication.UNDEFINED;
		}
	}
	
	public static interface ILogStateCommunication {
		public int getSignalPower();
		public int getBerValue();
		public StatusCommunication getStatusCommunication();
	}
	
	public static interface ILogMobileRadioCommunication {
		public Date getDateLog();
		public ILogStateCommunication getLogStateCommunication();
	}
	
	public List<ILogMobileRadioCommunication> getLogs();

}
