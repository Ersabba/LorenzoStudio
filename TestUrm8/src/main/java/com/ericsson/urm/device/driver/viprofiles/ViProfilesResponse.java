package com.ericsson.urm.device.driver.viprofiles;

import java.io.Serializable;
import java.util.Date;


public class ViProfilesResponse implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private Byte[]				statusWord;
	private Date				date;
	private ProfileType			type;
	private ProfilePhase		phase;
	private ProfilePeriod		period;

	private ResponseStatus[]	responseStatus;
	private Integer[]			values;


	public Byte[] getStatusWord() {
		return statusWord;
	}

	public void setStatusWord(Byte[] statusWord) {
		this.statusWord = statusWord;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ProfileType getType() {
		return type;
	}

	public void setType(ProfileType type) {
		this.type = type;
	}

	public ProfilePhase getPhase() {
		return phase;
	}

	public void setPhase(ProfilePhase phase) {
		this.phase = phase;
	}

	public ProfilePeriod getPeriod() {
		return period;
	}

	public void setPeriod(ProfilePeriod period) {
		this.period = period;
	}

	public ResponseStatus[] getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(ResponseStatus[] responseStatus) {
		this.responseStatus = responseStatus;
	}

	public Integer[] getValues() {
		return values;
	}

	public void setValues(Integer[] values) {
		this.values = values;
	}
}
