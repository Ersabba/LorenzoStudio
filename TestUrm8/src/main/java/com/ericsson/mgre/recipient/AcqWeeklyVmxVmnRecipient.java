package com.ericsson.mgre.recipient;

import java.util.ArrayList;
import java.util.List;


public class AcqWeeklyVmxVmnRecipient implements Recipient {

	private static final long					serialVersionUID	= 1L;	
	private String								ccsId				= null;
	List<Integer> weeksList =  new ArrayList<Integer>();
	
	@Override
	public String getRecipientId() {
		// TODO Auto-generated method stub
		return ccsId;
	}


	public void setRecipientId(String ccsId) {
		this.ccsId = ccsId;
	}

	public List<Integer> getWeeksList() {
		return weeksList;
	}


	public void setWeeksList(List<Integer> weeksList) {
		this.weeksList = weeksList;
	}

	
	
}
