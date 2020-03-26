package com.ericsson.urm.device.driver.energytotalizer;

import java.io.Serializable;
import java.util.Date;

public class DailyTotalizerResponse implements Serializable {

	private Date day = null;
	private TotalizerRequestType requestType = null;

	private ActiveAbsorbedTotalizer absorbedTotalizer = null;
	private ReactiveAbsorbedTotalizer reactiveAbsorbedTotalizer = null;
	private SuppliedTotalizer suppliedTotalizer = null;

	public DailyTotalizerResponse(Date day, TotalizerRequestType requestType) {
		super();
		this.day = day;
		this.requestType = requestType;
	}

	public ActiveAbsorbedTotalizer getAbsorbedTotalizer() {
		return absorbedTotalizer;
	}

	public ReactiveAbsorbedTotalizer getReactiveAbsorbedTotalizer() {
		return reactiveAbsorbedTotalizer;
	}

	public SuppliedTotalizer getSuppliedTotalizer() {
		return suppliedTotalizer;
	}

	public void setAbsorbedTotalizer(ActiveAbsorbedTotalizer absorbedTotalizer) {
		this.absorbedTotalizer = absorbedTotalizer;
	}

	public void setReactiveAbsorbedTotalizer(ReactiveAbsorbedTotalizer reactiveAbsorbedTotalizer) {
		this.reactiveAbsorbedTotalizer = reactiveAbsorbedTotalizer;
	}

	public void setSuppliedTotalizer(SuppliedTotalizer suppliedTotalizer) {
		this.suppliedTotalizer = suppliedTotalizer;
	}

	public void setRequestType(TotalizerRequestType requestType) {
		this.requestType = requestType;
	}

	public TotalizerRequestType getRequestType() {
		return requestType;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

}
