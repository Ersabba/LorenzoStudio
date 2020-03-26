package com.ericsson.mgre.recipient;

import java.io.Serializable;


public class GenericRecipientWrapper implements Recipient {
	
	private static final long serialVersionUID = -1L;
	private String recipientId=null;
    private Serializable data=null;
    
    public GenericRecipientWrapper() {
		
	}
	
	public GenericRecipientWrapper(String recipientId) {
		this.recipientId = recipientId;
	}
	public GenericRecipientWrapper(String recipientId, Serializable data) {
		this.recipientId = recipientId;
		this.data = data;
	}

	public String getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}

	public Serializable getData() {
		return data;
	}

	public void setData(Serializable data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((recipientId == null) ? 0 : recipientId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof GenericRecipientWrapper))
			return false;
		GenericRecipientWrapper other = (GenericRecipientWrapper) obj;
		if (recipientId == null) {
			if (other.recipientId != null)
				return false;
		} else if (!recipientId.equals(other.recipientId))
			return false;
		return true;
	}
}
