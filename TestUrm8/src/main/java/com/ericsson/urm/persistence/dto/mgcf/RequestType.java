package com.ericsson.urm.persistence.dto.mgcf;

import java.io.Serializable;

public class RequestType implements Serializable, Cloneable{

	private static final long serialVersionUID = 1L;
	
	public static final int REQUEST_TYPE_SINGLEFILE=0;
	public static final int REQUEST_TYPE_MULTIFILE=1;
	

	private int idRequestType=-1;
	private String typeName=null;
	private RequestClass requestClass=null;

	
	public RequestType() {
		super();
	}



	public Object clone() {
		try {
			RequestType requestType = (RequestType) super.clone();
			if (requestClass != null)
				requestType.requestClass = (RequestClass) requestClass.clone();
			return requestType;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	
	public int getIdRequestType() {
		return idRequestType;
	}
	public void setIdRequestType(int idRequestType) {
		this.idRequestType = idRequestType;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public RequestClass getRequestClass() {
		return requestClass;
	}
	public void setRequestClass(RequestClass requestClass) {
		this.requestClass = requestClass;
	}
	
	
	

}
