package com.ericsson.urm.persistence.dto.mgcf;

import java.io.Serializable;

public class RequestClass implements Serializable, Cloneable{

	private static final long serialVersionUID = 1L;
	
	private int idRequestClass=-1;
	private String requestClass=null;
	
	
	
	public RequestClass(int idRequestClass, String requestClass) {
		super();
		this.idRequestClass = idRequestClass;
		this.requestClass = requestClass;
	}



	public Object clone() {
		try {
			RequestClass requestClass = (RequestClass) super.clone();
			return requestClass;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	



	public int getIdRequestClass() {
		return idRequestClass;
	}



	public void setIdRequestClass(int idRequestClass) {
		this.idRequestClass = idRequestClass;
	}



	public String getRequestClass() {
		return requestClass;
	}



	public void setRequestClass(String requestClass) {
		this.requestClass = requestClass;
	}



	public RequestClass() {
		super();
	}
	
}
