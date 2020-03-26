package com.ericsson.mgre.datatypes;

import java.io.Serializable;
import java.util.Date;


public class OneShotCdCExtraParam implements Serializable {

	private static final long			serialVersionUID	= 1L;
	
	
	public static enum OneShotCdCExtraParamsKeys{
		DATE_INI, DATE_END, MAX_METER_XFILE;
	}

	private Integer						maxMeterPerFile;
	private Date						fromDate;
	private Date						toDate;
	
	public OneShotCdCExtraParam() {
		super();
	}
	
	public OneShotCdCExtraParam(Integer maxMeterPerFile, Date fromDate, Date toDate) {
		super();
		this.maxMeterPerFile = maxMeterPerFile;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public Integer getMaxMeterPerFile() {
		return maxMeterPerFile;
	}

	public void setMaxMeterPerFile(Integer maxMeterPerFile) {
		this.maxMeterPerFile = maxMeterPerFile;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	@Override
	public String toString() {
		return "OneShotCdCExtraParam [maxMeterPerFile=" + maxMeterPerFile + ", fromDate=" + fromDate + ", toDate="
				+ toDate + "]";
	}
	
	
}
