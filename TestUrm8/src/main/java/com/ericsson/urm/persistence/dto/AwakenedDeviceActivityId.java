package com.ericsson.urm.persistence.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.AccessType;

import com.ericsson.urm.core.taskmanagement.TaskCode;
import com.ericsson.urm.util.ArgumentsCheckerUtil;

@Embeddable
public class AwakenedDeviceActivityId implements Serializable {
	private static final long serialVersionUID = -1L;

	@Column(name="activity_code", nullable=false)
	@AccessType("field")
	private String activityCode;
	
	@Column(name="device_type_name", nullable=false)
	private String deviceTypeName;
	
	public AwakenedDeviceActivityId() {
		super();
	}
	

	/**
	 * @param activityCode
	 * @param deviceType
	 */
	public AwakenedDeviceActivityId(TaskCode activityCode, String deviceTypeName) {
		super();
		setActivityCode(activityCode);
		this.deviceTypeName = deviceTypeName;
	}

	public TaskCode getActivityCode() {
		return TaskCode.fromCode(activityCode);
	}

	public void setActivityCode(TaskCode activityCode) {
		ArgumentsCheckerUtil.checkNull(activityCode, "activityCode");
		
		this.activityCode = activityCode.getCode();
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
		result = prime * result + ((deviceTypeName == null) ? 0 : deviceTypeName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AwakenedDeviceActivityId))
			return false;
		AwakenedDeviceActivityId other = (AwakenedDeviceActivityId) obj;
		if (activityCode == null) {
			if (other.activityCode != null)
				return false;
		} else if (!activityCode.equals(other.activityCode))
			return false;
		if (deviceTypeName == null) {
			if (other.deviceTypeName != null)
				return false;
		} else if (!deviceTypeName.equals(other.deviceTypeName))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "AwakenedDeviceActivityId [activityCode=" + activityCode + ", deviceTypeName=" + deviceTypeName + "]";
	}

}
