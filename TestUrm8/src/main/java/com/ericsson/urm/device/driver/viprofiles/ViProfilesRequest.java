package com.ericsson.urm.device.driver.viprofiles;


public class ViProfilesRequest {
	
	private int giorno = -1;
	private ProfilePeriod period = null;
	private ProfileType type = null;
	private ProfilePhase phase = null;
	private ProfileMonth month = null;
	
	public int getGiorno() {
		return giorno;
	}
	public void setGiorno(int giorno) {
		this.giorno = giorno;
	}
	public ProfilePeriod getPeriod() {
		return period;
	}
	public void setPeriod(ProfilePeriod period) {
		this.period = period;
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
	public ProfileMonth getMonth() {
		return month;
	}
	public void setMonth(ProfileMonth month) {
		this.month = month;
	}

}
