package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;

public class ActivitiesExtraParamsId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String code;
	private String paramName;
	private long recordNumber;
	
	public ActivitiesExtraParamsId() {
		
	}
	
	public ActivitiesExtraParamsId(String code, String paramName) {
		super();
		this.code = code;
		this.paramName = paramName;
		this.recordNumber = 0;
	}
		
	public ActivitiesExtraParamsId(String code, String paramName, long recordNumber) {
		super();
		this.code = code;
		this.paramName = paramName;
		this.recordNumber = recordNumber;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public long getRecordNumber() {
		return recordNumber;
	}
	public void setRecordNumber(long recordNumber) {
		this.recordNumber = recordNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ActivitiesExtraParamsId that = (ActivitiesExtraParamsId) o;

		if (getRecordNumber() != that.getRecordNumber()) return false;
		if (!getCode().equals(that.getCode())) return false;
		return getParamName().equals(that.getParamName());
	}

	@Override
	public int hashCode() {
		int result = getCode().hashCode();
		result = 31 * result + getParamName().hashCode();
		result = 31 * result + (int) (getRecordNumber() ^ (getRecordNumber() >>> 32));
		return result;
	}
}