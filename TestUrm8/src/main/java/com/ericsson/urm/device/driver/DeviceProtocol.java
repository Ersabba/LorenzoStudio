package com.ericsson.urm.device.driver;


public enum DeviceProtocol {
	LANDIS_BT_CCS_MEDIATED, // usato per comunicare con un lennt passando tramite ccs
	LANDIS_BT_LENNT_DIRECT, // usato per comunicare direttamente con un lennt
	LANDIS_BT_CCS,  // usato per comunicare con un ccs
	LANDIS_BT_LENNT_MIXED, // usato per comunicare direttamente con un lennt in caso di fallimento tramite CCS
	LANDIS_BT_CRZ;  // usato per comunicare con un crz
	
	public static DeviceProtocol parse(String s) {
		if (s == null)
			return null;
		for (DeviceProtocol dp : DeviceProtocol.values())
			if (dp.toString().equalsIgnoreCase(s))
				return dp;
		throw new IllegalArgumentException("Unknown device protocol: " + s);
	}
}
