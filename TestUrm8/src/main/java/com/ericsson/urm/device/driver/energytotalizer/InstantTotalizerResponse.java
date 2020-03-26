package com.ericsson.urm.device.driver.energytotalizer;

import java.io.Serializable;

public class InstantTotalizerResponse implements Serializable {

	private ActiveAbsorbedTotalizer absorbedTotalizer = null;
	private ReactiveAbsorbedTotalizer reactiveAbsorbedTotalizer = null;
	private SuppliedTotalizer suppliedTotalizer = null;

	private TotalizerRequestType requestType = null;

	public InstantTotalizerResponse(TotalizerRequestType requestType) {
		super();
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

}
