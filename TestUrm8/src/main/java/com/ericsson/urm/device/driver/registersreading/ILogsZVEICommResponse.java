package com.ericsson.urm.device.driver.registersreading;

import java.util.Date;
import java.util.List;

public interface ILogsZVEICommResponse extends IReadingRegisterResponse {
	
	public static enum StatusZVEICommunication {
		UNDEFINED(0x01FF),
		COMMUNICATION_OK(0x00),
		TIMEOUT_ERROR(0x01),
		PROTOCOL_ERROR(0x02);
		
		private int valueStatus;

		private StatusZVEICommunication(int valueStatus) {
			this.valueStatus = valueStatus;
		}

		public int getValueStatus() {
			return valueStatus;
		}
		
		public static StatusZVEICommunication fromValue(int valueStatus) {
			for(StatusZVEICommunication curr : StatusZVEICommunication.values()) {
				if(curr.valueStatus == valueStatus) {
					return curr;
				}
			}
			return StatusZVEICommunication.UNDEFINED;
		}
	}
	
	public static interface ILogZVEICommunication {
		public Date getDateLog();
		public StatusZVEICommunication getStatusCommunication();
	}
	
	public List<ILogZVEICommunication> getLogs();

}
