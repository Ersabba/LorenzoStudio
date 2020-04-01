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

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.Type;

import com.ericsson.urm.core.taskmanagement.AwakenedDeviceTaskStatus;




@Entity
@Table(name="URM_AWAKENED_DEVICE_TASK")
public class AwakenedDeviceTask implements Serializable {
	private static final long serialVersionUID = -1L;
	
	@EmbeddedId
	private AwakenedDeviceTaskId id;
	
	@Lob
	@Column(name = "parameters")
	public String parameters;
	
	@Column(name = "start_execution")
	@Temporal(TemporalType.DATE)
	private Date startExecution;

	@Column(name = "end_execution")
	@Temporal(TemporalType.DATE)
	private Date endExecution;
	
	@Column(name = "last_update" )
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;
	
	@Column(name = "status" )
	@AccessType("field")
	private String status;

	
	public AwakenedDeviceTaskId getId() {
		return id;
	}

	public void setId(AwakenedDeviceTaskId id) {
		this.id = id;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public Date getStartExecution() {
		return startExecution;
	}

	public void setStartExecution(Date startExecution) {
		this.startExecution = startExecution;
	}

	public Date getEndExecution() {
		return endExecution;
	}

	public void setEndExecution(Date endExecution) {
		this.endExecution = endExecution;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public AwakenedDeviceTaskStatus getStatus() {
		return AwakenedDeviceTaskStatus.fromString(status);
	}

	public void setStatus(AwakenedDeviceTaskStatus status) {
		this.status = status!=null ? status.toString() : null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endExecution == null) ? 0 : endExecution.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + ((parameters == null) ? 0 : parameters.hashCode());
		result = prime * result + ((startExecution == null) ? 0 : startExecution.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AwakenedDeviceTask other = (AwakenedDeviceTask) obj;
		if (endExecution == null) {
			if (other.endExecution != null)
				return false;
		} else if (!endExecution.equals(other.endExecution))
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
		if (startExecution == null) {
			if (other.startExecution != null)
				return false;
		} else if (!startExecution.equals(other.startExecution))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AwakenedDeviceTask [id=" + id + ", parameters=" + parameters + ", startExecution=" + startExecution
				+ ", endExecution=" + endExecution + ", lastUpdate=" + lastUpdate + ", status=" + status + "]";
	}

}
