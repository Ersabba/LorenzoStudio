package com.ericsson.urm.exceptions;

import javax.ejb.EJBException;

/**
 * This exception could be thrown if an unrecoverable error occurs. Becaose of this excetion extends {@link EJBException}
 * it doesn't need to be declared and the container rollbacks all the active transactions of every CMT bean which throws this transaction. 
 * @author Davide
 *
 */
public class URMBusinessRuntimeException extends EJBException {

	public URMBusinessRuntimeException() {
		// TODO Auto-generated constructor stub
	}

	public URMBusinessRuntimeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public URMBusinessRuntimeException(Exception ex) {
		super(ex);
		// TODO Auto-generated constructor stub
	}

	public URMBusinessRuntimeException(String message, Exception ex) {
		super(message, ex);
		// TODO Auto-generated constructor stub
	}

}
