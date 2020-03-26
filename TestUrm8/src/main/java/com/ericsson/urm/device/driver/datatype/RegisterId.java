package com.ericsson.urm.device.driver.datatype;

import java.util.HashSet;
import java.util.Set;

public enum RegisterId {
	TG(0),
	T1(1), 
	T2(2),
	T3(3),
	T4(4);
	
	private int index;
	
	private RegisterId(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
	
	public static RegisterId valueOf(int index)	{
		for (RegisterId curr : RegisterId.values()) {
			if(curr.index == index) { return curr; }
		}
	
		throw new IllegalArgumentException ("Register: unsupported index " + index);
	}
	
	public static RegisterId parse(String typeName)	{	
		for (RegisterId curr : RegisterId.values()) {
			if(curr.toString().equalsIgnoreCase(typeName)) { return curr; }
		}
		
		throw new IllegalArgumentException ("RegisterId: unsupported type name " + typeName);
	}
	
	public static Set<RegisterId> getAll() {
		Set<RegisterId> comps = new HashSet<RegisterId>();
		for (RegisterId c : values())
			comps.add(c);
		return comps;
	}
}
