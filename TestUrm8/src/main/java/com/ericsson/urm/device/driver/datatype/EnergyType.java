package com.ericsson.urm.device.driver.datatype;

import java.util.HashSet;
import java.util.Set;

public enum EnergyType {
	ACTIVE(0), INDUCTIVE(1), CAPACITIVE(2);
	
	private int index;
	
	private EnergyType(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}


	public static EnergyType valueOf(int index)	{
		for (EnergyType curr : EnergyType.values()) {
			if(curr.index == index) { return curr; }
		}	
		throw new IllegalArgumentException ("EnergyType: unsupported index " + index);
	}
	
	public static boolean isEnergyType(String typeName)	{	
		for (EnergyType curr : EnergyType.values()) {
			if(curr.toString().equalsIgnoreCase(typeName)) { return true; }
		}
		
		return false;
	}
	
	public static EnergyType parse(String typeName)	{	
		for (EnergyType curr : EnergyType.values()) {
			if(curr.toString().equalsIgnoreCase(typeName)) { return curr; }			
		}
		
		throw new IllegalArgumentException ("EnergyType: unsupported type name " + typeName);
	}

	public static Set<EnergyType> getAll() {
	   Set<EnergyType> comps = new HashSet<EnergyType>();
		for (EnergyType c : values())
			comps.add(c);
		return comps;
	}
	
}
