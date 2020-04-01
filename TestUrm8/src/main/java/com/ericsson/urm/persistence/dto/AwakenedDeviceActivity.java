package com.ericsson.urm.persistence.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="URM_AWAKENED_DEVICE_ACTIVITY")
public class AwakenedDeviceActivity implements Serializable {
	private static final long serialVersionUID = -1L;
	
	@EmbeddedId
	private AwakenedDeviceActivityId id;
	
	@Column(name = "workorder_id", nullable=false)
	private long workOrderId;
	
	@Lob
	@Column(name = "parameters")
	public String parameters;
	
	@Lob
	@Column(name = "targets")
	public String deviceTargets;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Date startDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "expiration_date")
	private Date expirationDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update")
	private Date lastUpdate;
	
	public AwakenedDeviceActivity() {
		super();
	}
	
	/**
	 * @param id
	 * @param workOrderId
	 * @param parameters
	 * @param deviceTargets
	 */
	public AwakenedDeviceActivity(AwakenedDeviceActivityId id, long workOrderId, String parameters, String deviceTargets, Date expirationDate) {
		super();
		this.id = id;
		this.workOrderId = workOrderId;
		this.parameters = parameters;
		this.deviceTargets = deviceTargets;
		this.expirationDate = expirationDate;
		this.lastUpdate = new Date();
	}
	

	/**
	 * @param id
	 * @param workOrderId
	 * @param parameters
	 * @param deviceTargets
	 * @param startDate
	 * @param expirationDate
	 * @param lastUpdate
	 */
	public AwakenedDeviceActivity(AwakenedDeviceActivityId id, long workOrderId, String parameters,
			String deviceTargets, Date startDate, Date expirationDate, Date lastUpdate) {
		super();
		this.id = id;
		this.workOrderId = workOrderId;
		this.parameters = parameters;
		this.deviceTargets = deviceTargets;
		this.startDate = startDate;
		this.expirationDate = expirationDate;
		this.lastUpdate = lastUpdate;
	}



	public AwakenedDeviceActivityId getId() {
		return id;
	}

	public void setId(AwakenedDeviceActivityId id) {
		this.id = id;
	}
	
	public long getWorkOrderId() {
		return workOrderId;
	}

	public void setWorkOrderId(long workOrderId) {
		this.workOrderId = workOrderId;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public String getDeviceTargets() {
		return deviceTargets;
	}

	public void setDeviceTargets(String deviceTargets) {
		this.deviceTargets = deviceTargets;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deviceTargets == null) ? 0 : deviceTargets.hashCode());
		result = prime * result + ((expirationDate == null) ? 0 : expirationDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + ((parameters == null) ? 0 : parameters.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + (int) (workOrderId ^ (workOrderId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AwakenedDeviceActivity))
			return false;
		AwakenedDeviceActivity other = (AwakenedDeviceActivity) obj;
		if (deviceTargets == null) {
			if (other.deviceTargets != null)
				return false;
		} else if (!deviceTargets.equals(other.deviceTargets))
			return false;
		if (expirationDate == null) {
			if (other.expirationDate != null)
				return false;
		} else if (!expirationDate.equals(other.expirationDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		if (parameters == null) {
			if (other.parameters != null)
				return false;
		} else if (!parameters.equals(other.parameters))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (workOrderId != other.workOrderId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AwakenedDeviceActivity [id=" + id + ", workOrderId=" + workOrderId + ", parameters=" + parameters
				+ ", deviceTargets=" + deviceTargets + ", startDate=" + startDate + ", expirationDate=" + expirationDate
				+ ", lastUpdate=" + lastUpdate + "]";
	}

}
