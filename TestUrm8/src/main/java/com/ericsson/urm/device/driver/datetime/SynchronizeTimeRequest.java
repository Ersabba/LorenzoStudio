package com.ericsson.urm.device.driver.datetime;

import java.util.Date;

public class SynchronizeTimeRequest implements ISynchronizeTimeRequest {
	
	private static final long serialVersionUID = -1L;
	
	private Date date = null;
	
	public SynchronizeTimeRequest() {
		super();
	}

	public SynchronizeTimeRequest(Date date) {
		super();
		this.date = date;
	}

	@Override
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
}
