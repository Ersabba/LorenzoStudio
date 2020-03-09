package com.ericsson.urm.persistence.dto.mgcf;

import java.io.Serializable;
import java.util.Date;

public class RequestAssociation implements Serializable, Cloneable{

	private static final long serialVersionUID = 1L;
    private ExternalSystem externalSystem = null;
	private long idRequest = -1;
	private String taskId = null;
	private Date timestampRequest = null;
	private int idRequestSource = -1;
	private RequestType requestType = null;
	private int subsystemId = -1;


	public RequestAssociation() {
		super();
	}

	public RequestAssociation(long idRequest, ExternalSystem externalSystem, String taskId, Date timestampRequest, int idRequestSource) {
		super();
		this.idRequest = idRequest;
		this.externalSystem = externalSystem;
		this.taskId = taskId;
		this.timestampRequest = timestampRequest;
		this.idRequestSource = idRequestSource;

	}


	public Object clone() {
		try {
			RequestAssociation requestAssociation = (RequestAssociation) super.clone();
			if (externalSystem != null)
				requestAssociation.externalSystem = (ExternalSystem) externalSystem.clone();
			if (requestType != null)
				requestAssociation.requestType = (RequestType) requestType.clone();
			if (timestampRequest != null)
				requestAssociation.timestampRequest = (Date) timestampRequest.clone();
			
			return requestAssociation;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	


	public long getIdRequest() {
		return idRequest;
	}

	public void setIdRequest(long idRequest) {
		this.idRequest = idRequest;
	}

	public ExternalSystem getExternalSystem() {
		return externalSystem;
	}

	public void setExternalSystem(ExternalSystem externalSystem) {
		this.externalSystem = externalSystem;
	}

	public Date getTimestampRequest() {
		return timestampRequest;
	}

	public void setTimestampRequest(Date timestampRequest) {
		this.timestampRequest = timestampRequest;
	}

	public int getIdRequestSource() {
		return idRequestSource;
	}

	public void setIdRequestSource(int idRequestSource) {
		this.idRequestSource = idRequestSource;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

	public int getSubsystemId() {
		return subsystemId;
	}

	public void setSubsystemId(int subsystemId) {
		this.subsystemId = subsystemId;
	}

    @Override
    public String toString() {
        return "RequestAssociation{" +
                "externalSystem=" + externalSystem +
                ", idRequest=" + idRequest +
                ", taskId='" + taskId + '\'' +
                ", timestampRequest=" + timestampRequest +
                ", idRequestSource=" + idRequestSource +
                ", requestType=" + requestType +
                ", subsystemId=" + subsystemId +
                '}';
    }
}
