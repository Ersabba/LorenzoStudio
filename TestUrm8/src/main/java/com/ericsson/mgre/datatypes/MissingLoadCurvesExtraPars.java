package com.ericsson.mgre.datatypes;

import java.io.Serializable;
import java.util.Set;

import com.ericsson.communication.datatype.SourceRequestType;
import com.ericsson.mgre.recipient.CurvaDiCaricoCampioniMancantiRecipient;

public class MissingLoadCurvesExtraPars implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Set<CurvaDiCaricoCampioniMancantiRecipient> recipients;
	private SourceRequestType source;
	
	
	
	public MissingLoadCurvesExtraPars(
			Set<CurvaDiCaricoCampioniMancantiRecipient> recipients,
			SourceRequestType source) {
		super();
		this.recipients = recipients;
		this.source = source;
	}
	
	
	public Set<CurvaDiCaricoCampioniMancantiRecipient> getRecipients() {
		return recipients;
	}
	public void setRecipients(
			Set<CurvaDiCaricoCampioniMancantiRecipient> recipients) {
		this.recipients = recipients;
	}
	public SourceRequestType getSource() {
		return source;
	}
	public void setSource(SourceRequestType source) {
		this.source = source;
	}
	
	

}
