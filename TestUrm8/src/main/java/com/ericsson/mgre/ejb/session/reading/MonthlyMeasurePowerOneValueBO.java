package com.ericsson.mgre.ejb.session.reading;

import java.io.Serializable;
import java.util.Date;

public class MonthlyMeasurePowerOneValueBO implements Serializable {

	public static final int TYPE_T1 = 1;
	public static final int TYPE_T2 = 2;
	public static final int TYPE_T3 = 3;
	public static final int TYPE_T4 = 4;

	private String value = null;
	private Date dataRil = null;

	private int type = -1;

	public MonthlyMeasurePowerOneValueBO(String value, Date dataRil, int type) {
		super();
		this.value = value;
		this.dataRil = dataRil;
		this.type = type;
	}

	public MonthlyMeasurePowerOneValueBO() {
		super();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getDataRil() {
		return dataRil;
	}

	public void setDataRil(Date dataRil) {
		this.dataRil = dataRil;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
