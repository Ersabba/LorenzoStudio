package com.ericsson.urm.persistence.dto.mgcf;

import com.ericsson.mgcf.datatypes.ReachabilityState;
import org.hibernate.annotations.AccessType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="GCF_DEV_REACHABILITY_STATUS")
public class DeviceReachabilityStatus implements Serializable{

	private static final long serialVersionUID = -1L;

	@Id
	@SequenceGenerator(name = "reachabilityStatusIdGenerator", sequenceName = "SQN_ID_REACHABILITY_STATUS",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="reachabilityStatusIdGenerator")
	@Column(name="ID", unique=true, nullable=false)
	private Long id;

	
	@Column(name="USERNAME")
	private String username;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CHANGE_TIME")
	private Date changeTime;
	
	@Column(name="PSUCC")
	private Double pSucc;
	
	@Column(name="NUM_DEVICES")
	private Long numDevices;

	@Lob
	@Column(name="STATUS")
	@AccessType("field")
	private String status;
	
	
	public DeviceReachabilityStatus(){
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Date getChangeTime() {
		return changeTime;
	}


	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}


	public Double getpSucc() {
		return pSucc;
	}


	public void setpSucc(Double pSucc) {
		this.pSucc = pSucc;
	}


	public Long getNumDevices() {
		return numDevices;
	}


	public void setNumDevices(Long numDevices) {
		this.numDevices = numDevices;
	}


	
	public ReachabilityState getStatus() {
		return ReachabilityState.parse(this.status);
	}

	public void setStatus(ReachabilityState status) {
		this.status = status != null ? status.toString() : null;
	}


	@Override
	public String toString() {
		return "DeviceReachabilityStatus [id=" + id + ", username=" + username + ", changeTime=" + changeTime + ", pSucc="
				+ pSucc + ", numDevices=" + numDevices + ", status=" + status + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((changeTime == null) ? 0 : changeTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numDevices == null) ? 0 : numDevices.hashCode());
		result = prime * result + ((pSucc == null) ? 0 : pSucc.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		DeviceReachabilityStatus other = (DeviceReachabilityStatus) obj;
		if (changeTime == null) {
			if (other.changeTime != null)
				return false;
		} else if (!changeTime.equals(other.changeTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numDevices == null) {
			if (other.numDevices != null)
				return false;
		} else if (!numDevices.equals(other.numDevices))
			return false;
		if (pSucc == null) {
			if (other.pSucc != null)
				return false;
		} else if (!pSucc.equals(other.pSucc))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}



}
