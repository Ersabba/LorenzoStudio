package com.ericsson.mgre.datatypes.monthlymeasures;

import java.util.Hashtable;

import com.ericsson.urm.persistence.dto.mgre.datatype.IntegrationPeriodType;

public class MonthlyMeasureTypeMap extends Hashtable<String,MonthlyMeasureRecord> {
	
	private static final long serialVersionUID = -1L;
	public final static String REGISTER   = "REGISTER";
	public final static String IPM        = IntegrationPeriodType.IPM.toString();;
	public final static String ONE_MINUTE = IntegrationPeriodType.ONE_MINUTE.toString();
	
	private boolean completed = false;

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
}
