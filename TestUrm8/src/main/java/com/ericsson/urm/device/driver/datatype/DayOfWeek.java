package com.ericsson.urm.device.driver.datatype;

import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public enum DayOfWeek {
	
	Sunday(Calendar.SUNDAY), // start with 1
	Monday(Calendar.MONDAY),
	Tuesday(Calendar.TUESDAY),
	Wednesday(Calendar.WEDNESDAY),
	Thuersday(Calendar.THURSDAY),
	Friday(Calendar.FRIDAY),
	Saturday(Calendar.SATURDAY);
	
	private int value;
	private static HashMap<String, DayOfWeek> map;
	private static HashSet<DayOfWeek> dayOfWeekSet;
	
	static
    {
		dayOfWeekSet = new HashSet<DayOfWeek>();
		
		map = new HashMap<String, DayOfWeek>();
        for (DayOfWeek dow : DayOfWeek.values())
        {
            map.put(String.valueOf(dow.value), dow);
            map.put(dow.toString().toUpperCase(), dow);
            dayOfWeekSet.add(dow);
        }
    }

	private DayOfWeek(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	public static DayOfWeek valueOf(int value) {	
		DayOfWeek curr = map.get(String.valueOf(value));
		if(curr == null) {
			throw new IllegalArgumentException("Unknown value:"+value+"; valid values:"+Calendar.SUNDAY+"-"+Calendar.SATURDAY);
		}
		return curr;
	}
	
	public static DayOfWeek parse(String name) {	
		DayOfWeek curr = map.get(name);
		if(curr == null) {
			throw new IllegalArgumentException("Unknown name:"+name);
		}
		return curr;
	}
	
	public static Set<DayOfWeek> asSet() {
		 return Collections.unmodifiableSet(dayOfWeekSet);
	}
}
