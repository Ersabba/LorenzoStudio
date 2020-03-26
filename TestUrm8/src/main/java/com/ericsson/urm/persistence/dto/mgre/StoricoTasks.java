package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;

public class StoricoTasks implements Serializable {

	private static final long	serialVersionUID	= 1L;
	
	private long id;
	private String activityCode;
	private String state;
	private long expectedStartTime;
	private long startTime;
	private long lastStateUpdateTime;
	private Serializable additionalInfos;
	private Serializable targets;
	private String targetType;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getActivityCode() {
		return activityCode;
	}
	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getExpectedStartTime() {
		return expectedStartTime;
	}
	public void setExpectedStartTime(long expectedStartTime) {
		this.expectedStartTime = expectedStartTime;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getLastStateUpdateTime() {
		return lastStateUpdateTime;
	}
	public void setLastStateUpdateTime(long lastStateUpdateTime) {
		this.lastStateUpdateTime = lastStateUpdateTime;
	}
	public Serializable getAdditionalInfos() {
		return additionalInfos;
	}
	public void setAdditionalInfos(Serializable additionalInfos) {
		this.additionalInfos = additionalInfos;
	}
	public Serializable getTargets() {
		return targets;
	}
	public void setTargets(Serializable targets) {
		this.targets = targets;
	}
	public String getTargetType() {
		return targetType;
	}
	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}
	
}
