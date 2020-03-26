package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;

public class ActivitiesExtraParams implements Serializable {
	private final static long serialVersionUID = -1;
	
	private ActivitiesExtraParamsId id = null;
	private String paramValue;

	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	public ActivitiesExtraParamsId getId() {
		return id;
	}

	public void setId(ActivitiesExtraParamsId id) {
		this.id = id;
	}
	
	
}
