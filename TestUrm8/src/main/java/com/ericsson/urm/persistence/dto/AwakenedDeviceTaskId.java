package com.ericsson.urm.persistence.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.AccessType;

import com.ericsson.urm.core.taskmanagement.TaskCode;
import com.ericsson.urm.util.ArgumentsCheckerUtil;

@Embeddable
public class AwakenedDeviceTaskId implements Serializable {
	private static final long serialVersionUID = -1L;
	
	@Column(name="device_id", nullable=false)
	private String deviceId;
	
	@Column(name="device_type_name", nullable=false)
	private String deviceTypeName;
	
	@Column(name="activity_code", nullable=false)
	@AccessType("field")
	private String activityCode;
	
	@Column(name="workorder_id", nullable=false)
	private long workOrderId;
	
	
	public AwakenedDeviceTaskId() {
		super();
	}
	
	/**
	 * @param deviceId
	 * @param deviceTypeName
	 * @param activityCode
	 * @param workOrderId
	 */
	public AwakenedDeviceTaskId(String deviceId, String deviceTypeName, TaskCode activityCode, long workOrderId) {
		super();
		this.deviceId = deviceId;
		this.deviceTypeName = deviceTypeName;
		setActivityCode(activityCode);
		this.workOrderId = workOrderId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public long getWorkOrderId() {
		return workOrderId;
	}


	public void setWorkOrderId(long workOrderId) {
		this.workOrderId = workOrderId;
	}


	public TaskCode getActivityCode() {
		return TaskCode.fromCode(activityCode);
	}

	public void setActivityCode(TaskCode activityCode) {
		ArgumentsCheckerUtil.checkNull(activityCode, "activityCode");
		
		this.activityCode = activityCode.toString();
	}

	
	public String getDeviceTypeName() {
		return deviceTypeName;
	}


	public void setDeviceTypeName(String deviceTypeName) {
		this.deviceTypeName = deviceTypeName;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activityCode == null) ? 0 : activityCode.hashCode());
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + ((deviceTypeName == null) ? 0 : deviceTypeName.hashCode());
		result = prime * result + (int) (workOrderId ^ (workOrderId >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AwakenedDeviceTaskId))
			return false;
		AwakenedDeviceTaskId other = (AwakenedDeviceTaskId) obj;
		if (activityCode == null) {
			if (other.activityCode != null)
				return false;
		} else if (!activityCode.equals(other.activityCode))
			return false;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		if (deviceTypeName == null) {
			if (other.deviceTypeName != null)
				return false;
		} else if (!deviceTypeName.equals(other.deviceTypeName))
			return false;
		if (workOrderId != other.workOrderId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "AwakenedDeviceTaskId [deviceId=" + deviceId + ", workOrderId=" + workOrderId + ", activityCode="
				+ activityCode + ", deviceTypeName=" + deviceTypeName + "]";
	}

}
