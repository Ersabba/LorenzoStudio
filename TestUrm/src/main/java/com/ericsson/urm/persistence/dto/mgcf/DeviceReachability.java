package com.ericsson.urm.persistence.dto.mgcf;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="GCF_DEVICE_REACHABILITY")
public class DeviceReachability implements Serializable{

	private static final long serialVersionUID = -1L;
	
	@Id
	@Column(name = "ID_REQUEST")
	private Long idRequest;
	
	@Column(name="ID_DEVICE")
	private String idDevice;
	
	@Column(name="STATUS_UNREACHABILITY")
	private int statusUnreachability;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CHANGE_STATUS_TIME")
	private Date changeStatusTime;
	
	
	public DeviceReachability(){
		super();
	}


	public Long getIdRequest() {
		return idRequest;
	}


	public void setIdRequest(Long idRequest) {
		this.idRequest = idRequest;
	}


	public String getIdDevice() {
		return idDevice;
	}


	public void setIdDevice(String idDevice) {
		this.idDevice = idDevice;
	}


	public int getStatusUnreachability() {
		return statusUnreachability;
	}


	public void setStatusUnreachability(int statusUnreachability) {
		this.statusUnreachability = statusUnreachability;
	}


	public Date getChangeStatusTime() {
		return changeStatusTime;
	}


	public void setChangeStatusTime(Date changeStatusTime) {
		this.changeStatusTime = changeStatusTime;
	}


	@Override
	public String toString() {
		return "DeviceReachability [idRequest=" + idRequest + ", idDevice=" + idDevice + ", statusUnreachability="
				+ statusUnreachability + ", changeStatusTime=" + changeStatusTime + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((changeStatusTime == null) ? 0 : changeStatusTime.hashCode());
		result = prime * result + ((idDevice == null) ? 0 : idDevice.hashCode());
		result = prime * result + ((idRequest == null) ? 0 : idRequest.hashCode());
		result = prime * result + statusUnreachability;
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
		DeviceReachability other = (DeviceReachability) obj;
		if (changeStatusTime == null) {
			if (other.changeStatusTime != null)
				return false;
		} else if (!changeStatusTime.equals(other.changeStatusTime))
			return false;
		if (idDevice == null) {
			if (other.idDevice != null)
				return false;
		} else if (!idDevice.equals(other.idDevice))
			return false;
		if (idRequest == null) {
			if (other.idRequest != null)
				return false;
		} else if (!idRequest.equals(other.idRequest))
			return false;
		if (statusUnreachability != other.statusUnreachability)
			return false;
		return true;
	}

}
