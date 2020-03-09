package com.ericsson.urm.persistence.dto.mgcf;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.db.MgdbDto;

public class Activity implements Serializable, MgdbDto {

	private static final long serialVersionUID = 1L;
	
	private long idRequest = -1;
	private String taskStateId = null;
	private String taskTypeId = null;
	private Date expectedDate = null;
	private Date insertDate = null;
	private boolean customizeRequest = false;
	private boolean lenntcomFlag = false;
	private String errorCode = null;
	private String state = null;
	private Date executionTimestamp = null;
	private int priority = -1;
	private Date acquisitiontimestamp = null;
	private String notes = null;
	private String locationId = null;
	private RequestAssociation requestAssociation = null;
	private String zoneId = null;
	private boolean authorized = false;
	private Date authorizationDate = null;
	private String recoveryCode = null;
	
	public interface RECOVERY_CODES {
		public interface RESULTS {
			public final static String SUCCESS 	= "SUCCESS";
			public final static String FAILED 	= "FAILED";
		}
		
		public final static String MAKE_RESPONSE = "MAKE_RESPONSE";
	}

	public Activity() {
		super();
	}

	public Object clone() {
		try {
			Activity activity = (Activity) super.clone();
			if (requestAssociation != null)
				activity.requestAssociation = (RequestAssociation) requestAssociation.clone();
			if (acquisitiontimestamp != null)
				activity.acquisitiontimestamp = (Date) acquisitiontimestamp.clone();
			if (authorizationDate != null)
				activity.authorizationDate = (Date) authorizationDate.clone();
			if (executionTimestamp != null)
				activity.executionTimestamp = (Date) executionTimestamp.clone();
			if (expectedDate != null)
				activity.expectedDate = (Date) expectedDate.clone();
			if (insertDate != null)
				activity.insertDate = (Date) insertDate.clone();

			return activity;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	public Serializable retrievePrimaryKey() {
		return new Long(getIdRequest());
	}
	
	public void applyAllProperties(MgdbDto srcDto) {
		Activity other = (Activity)srcDto;

		this.idRequest = other.idRequest;
		this.taskStateId = other.taskStateId;
		this.taskTypeId = other.taskTypeId;
		this.expectedDate = other.expectedDate;
		this.insertDate = other.insertDate;
		this.customizeRequest = other.customizeRequest;
		this.lenntcomFlag = other.lenntcomFlag;
		this.errorCode = other.errorCode;
		this.state = other.state;
		this.executionTimestamp = other.executionTimestamp;
		this.priority = other.priority;
		this.acquisitiontimestamp = other.acquisitiontimestamp;
		this.notes = other.notes;
		this.locationId = other.locationId;
		if (other.requestAssociation != null)
			this.requestAssociation = (RequestAssociation)other.requestAssociation.clone();
		else
			this.requestAssociation = null;
		this.zoneId = other.zoneId;
		this.authorized = other.authorized;
		this.authorizationDate = other.authorizationDate;
		this.recoveryCode = other.recoveryCode;
	}
	
	public String getRecoveryCode() {
		return recoveryCode;
	}


	public void setRecoveryCode(String recoveryCode) {
		this.recoveryCode = recoveryCode;
	}


	public boolean isAuthorized() {
		return authorized;
	}

//	public String getAuthorized() {
//		return this.isAuthorized()==true?"Y":"N";
//	}

	public void setAuthorized(boolean authorized) {
		this.authorized = authorized;
	}

	public Date getAuthorizationDate() {
		return authorizationDate;
	}

	public void setAuthorizationDate(Date authorizationDate) {
		this.authorizationDate = authorizationDate;
	}


	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	public long getIdRequest() {
		return idRequest;
	}

	public void setIdRequest(long idRequest) {
		this.idRequest = idRequest;
	}

	public String getTaskStateId() {
		return taskStateId;
	}

	public void setTaskStateId(String taskStateId) {
		this.taskStateId = taskStateId;
	}

	public String getTaskTypeId() {
		return taskTypeId;
	}

	public void setTaskTypeId(String taskTypeId) {
		this.taskTypeId = taskTypeId;
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

	public boolean isCustomizeRequest() {
		return customizeRequest;
	}

//	public String getCustomizeRequest() {
//		return this.isCustomizeRequest()==true?"Y":"N";
//	}

	public void setCustomizeRequest(boolean customizeRequest) {
		this.customizeRequest = customizeRequest;
	}

	public boolean isLenntcomFlag() {
		return lenntcomFlag;
	}

//	public String getLenntcomFlag() {
//		return this.isLenntcomFlag()==true?"Y":"N";
//	}

	public void setLenntcomFlag(boolean lenntcomFlag) {
		this.lenntcomFlag = lenntcomFlag;
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

	public Date getExecutionTimestamp() {
		return executionTimestamp;
	}

	public void setExecutionTimestamp(Date executionTimestamp) {
		this.executionTimestamp = executionTimestamp;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Date getAcquisitiontimestamp() {
		return acquisitiontimestamp;
	}

	public void setAcquisitiontimestamp(Date acquisitiontimestamp) {
		this.acquisitiontimestamp = acquisitiontimestamp;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public RequestAssociation getRequestAssociation() {
		return requestAssociation;
	}

	public void setRequestAssociation(RequestAssociation requestAssociation) {
		this.requestAssociation = requestAssociation;
	}


	public String toString() {
		return "Activity [acquisitiontimestamp=" + acquisitiontimestamp + ", authorizationDate=" + authorizationDate
				+ ", authorized=" + authorized + ", customizeRequest=" + customizeRequest + ", errorCode=" + errorCode
				+ ", executionTimestamp=" + executionTimestamp + ", expectedDate=" + expectedDate + ", idRequest=" + idRequest
				+ ", insertDate=" + insertDate + ", lenntcomFlag=" + lenntcomFlag + ", locationId=" + locationId + ", notes="
				+ notes + ", priority=" + priority + ", recoveryCode=" + recoveryCode + ", requestAssociation="
				+ requestAssociation + ", state=" + state + ", taskStateId=" + taskStateId + ", taskTypeId=" + taskTypeId
				+ ", zoneId=" + zoneId + "]";
	}
	
}
