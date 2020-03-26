package com.ericsson.urm.device.driver.datatype;


public enum DeviceTypeName {
	CCS("CCS"),
	P1("P1"),
	P2("P2"),
	P2_IP("P2-IP"),
	P2_SG("P2-SG"),
	CRZ_GENERIC("CRZ_GENERIC", true),
	UNTYPED("UNTYPED");

	private String	internalName;
	private boolean withAwakeningPlan = false;

	private DeviceTypeName(String internalName) {
		this.internalName = internalName;
	}
	
	private DeviceTypeName(String internalName, boolean withAwakeningPlan) {
		this.internalName = internalName;
		this.withAwakeningPlan = withAwakeningPlan;
	}

	public String getInternalName() {
		return this.internalName;
	}
	
	protected boolean isWithAwakeningPlan() {
		return withAwakeningPlan;
	}

	public static DeviceTypeName parse(String internalName) {
		if (internalName == null)
			return null;
		for (DeviceTypeName tu : DeviceTypeName.values())
			if (tu.internalName.equalsIgnoreCase(internalName))
				return tu;
		throw new IllegalArgumentException("Invalid DeviceTypeName, input argument:" + internalName);
	}
}
