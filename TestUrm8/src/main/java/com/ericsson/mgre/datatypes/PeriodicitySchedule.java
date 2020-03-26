package com.ericsson.mgre.datatypes;

public enum PeriodicitySchedule {
	HOURLY,DAILY,WEEKLY,MONTHLY,YEARLY;
	
	public static PeriodicitySchedule parse(String periodicity) {
		if(periodicity!=null && periodicity.trim().length()>0) {
			for(PeriodicitySchedule p : PeriodicitySchedule.values()) {
				if(p.toString().equalsIgnoreCase(periodicity)) {
					return p;
				}
			}
		}
		throw new IllegalArgumentException("Unknown periodicity type:"+periodicity);
	}
}
