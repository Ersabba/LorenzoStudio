package com.ericsson.urm.communication;

import java.io.Serializable;

import com.ericsson.urm.exceptions.URMBusinessException;

public interface ICallbackResponse extends Serializable {
	public void sendResponse(Serializable serializableData) throws URMBusinessException;
}
