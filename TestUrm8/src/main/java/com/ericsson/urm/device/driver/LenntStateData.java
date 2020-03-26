package com.ericsson.urm.device.driver;

import java.io.Serializable;

public interface LenntStateData extends Serializable {
	
	public static class IpStatusConstants implements Serializable{
		public static final int AUTOMATIC_ON=1;
		public static final int AUTOMATIC_ON_WITH_REGULATOR=2;
		public static final int AUTOMATIC_OFF=4;
		public static final int FORCED_ON=5;
		public static final int FORCED_OFF=6;
		public static final int IP_ON_WITH_NO_PLAN=7;
		public static final int IP_OFF_DEACTIVATED=8;
		public static final int IP_OFF_LIGHT_POWER=9;
		public static final int IP_OFF_NO_POWER=10;
		
	}
	
	
	public byte[] getStatusWord();
	
	public Integer getIpStatus() throws UnsupportedOperationException;
	
	public Byte getIOStatus() throws UnsupportedOperationException;
	
	public PowerData getPowerData();
	

}
