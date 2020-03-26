package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;

public class PowerCut implements Serializable {
	
	public static final String PHASE_R="R";
	public static final String PHASE_S="S";
	public static final String PHASE_T="T";
	
	
	private PowerCutId id=null;
	private String concetratorId=null;
	private String start=null;
	private String end=null;
	private String phase=null;
	
	public PowerCut() {
		super();
	}

	public PowerCutId getId() {
		return id;
	}

	public void setId(PowerCutId id) {
		this.id = id;
	}

	public String getConcetratorId() {
		return concetratorId;
	}

	public void setConcetratorId(String concetratorId) {
		this.concetratorId = concetratorId;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}
	
	
	
	

}
