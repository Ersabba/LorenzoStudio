package com.ericsson.urm.device.driver.datatype;

import java.util.HashSet;
import java.util.Set;

public enum EnergyFlowDirection {
	ABSORBED(0,"+"),
	SUPPLIED(1,"-");
	
	private int index;
	private String sign;
	
	private EnergyFlowDirection(int index, String sign) {
		this.index = index;
		this.sign = sign;
	}

	public int getIndex() {
		return index;
	}
	
	public String getSign() {
		return sign;
	}

	public static EnergyFlowDirection valueOf(int index)	{
		for (EnergyFlowDirection curr : EnergyFlowDirection.values()) {
			if(curr.index == index) { return curr; }
		}
	
		throw new IllegalArgumentException ("Unsupported index " + index);
	}
	
	public static EnergyFlowDirection parse(String typeName)	{	
		for (EnergyFlowDirection curr : EnergyFlowDirection.values()) {
			if(curr.toString().equalsIgnoreCase(typeName)) { return curr; }
			if(curr.sign.equalsIgnoreCase(typeName)) { return curr; }
		}
		try {
			return valueOf(Integer.parseInt(typeName));		
		} catch (NumberFormatException e) {
			
		}
		
		throw new IllegalArgumentException ("Unsupported type name " + typeName);
	}

	public static Set<EnergyFlowDirection> getAll() {
		Set<EnergyFlowDirection> elements = new HashSet<EnergyFlowDirection>();
		for (EnergyFlowDirection c : values())
			elements.add(c);
		return elements;
	}
}
