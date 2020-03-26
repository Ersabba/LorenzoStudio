package com.ericsson.urm.device.driver.energytotalizer;

import java.io.Serializable;

public class InstantTotalizerRequest implements Serializable {

	private TotalizerRequestType requestType = null;

	public InstantTotalizerRequest(TotalizerRequestType requestType) {
		super();
		this.requestType = requestType;
	}

	public TotalizerRequestType getRequestType() {
		return requestType;
	}

}
