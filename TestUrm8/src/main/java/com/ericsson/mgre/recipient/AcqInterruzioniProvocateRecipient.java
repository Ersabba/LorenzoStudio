package com.ericsson.mgre.recipient;

import java.util.LinkedHashSet;


public class AcqInterruzioniProvocateRecipient implements Recipient {

	private static final long	serialVersionUID	= 1L;	
	
	private String				ccsId		= null;
	private String				daysDQN 	= null;
	LinkedHashSet<String> 		daysListDQD = new LinkedHashSet<String>();
	
	
	public AcqInterruzioniProvocateRecipient() {
	}

	public AcqInterruzioniProvocateRecipient(String ccsId) {
		super();
		this.ccsId = ccsId;
	}

	@Override
	public String getRecipientId() {
		return ccsId;
	}

	public void setRecipientId(String ccsId) {
		this.ccsId = ccsId;
	}

	public String getDaysDQN() {
		return daysDQN;
	}

	public void setDaysDQN(String daysDQN) {
		this.daysDQN = daysDQN;
	}

	public LinkedHashSet<String> getDaysListDQD() {
		return daysListDQD;
	}

	public void setDaysListDQD(LinkedHashSet<String> daysListDQD) {
		this.daysListDQD = daysListDQD;
	}
	
	
}
