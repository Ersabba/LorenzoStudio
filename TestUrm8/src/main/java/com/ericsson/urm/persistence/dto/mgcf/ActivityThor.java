package com.ericsson.urm.persistence.dto.mgcf;

import java.io.Serializable;
import java.util.Date;

public class ActivityThor implements Serializable {
	private static final long serialVersionUID = 1L;

	private String thorCode = null;
	private String idMeter = null;
	private long idRequest = 0;
	private String taskStateID = null;
	private String taskTypeID = null;
	private Date expectedDate = null;
	private Date insertDate = null;
	private String locationID = null;
	private String errorCode = null;
	private String state = null;
	
	public String getThorCode() {
		return thorCode;
	}
	public void setThorCode(String thorCode) {
		this.thorCode = thorCode;
	}
	public String getIdMeter() {
		return idMeter;
	}
	public void setIdMeter(String idMeter) {
		this.idMeter = idMeter;
	}
	public long getIdRequest() {
		return idRequest;
	}
	public void setIdRequest(long idRequest) {
		this.idRequest = idRequest;
	}
	public String getTaskStateID() {
		return taskStateID;
	}
	public void setTaskStateID(String taskStateID) {
		this.taskStateID = taskStateID;
	}
	public String getTaskTypeID() {
		return taskTypeID;
	}
	public void setTaskTypeID(String taskTypeID) {
		this.taskTypeID = taskTypeID;
	}
	public Date getExpectedDate() {
		return expectedDate;
	}
	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public String getLocationID() {
		return locationID;
	}
	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}