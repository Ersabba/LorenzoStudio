package com.ericsson.urm.exceptions;



/**
 * This exception could be thrown if an unrecoverable error occurs. Becaose of this excetion extends {@link EJBException}
 * it doesn't need to be declared and the container rollbacks all the active transactions of every CMT bean which throws this transaction. 
 * @author Davide
 *
 */
public class BusinessRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2810561718402883099L;

	public BusinessRuntimeException() {
		this(null,null);
	}

	public BusinessRuntimeException(String message) {
		this(message,null);
		// TODO Auto-generated constructor stub
	}

	public BusinessRuntimeException(Exception ex) {
		this(null,ex);
		// TODO Auto-generated constructor stub
	}

	public BusinessRuntimeException(String message, Exception ex) {
		super(message, ex);
		// TODO Auto-generated constructor stub
	}

}
