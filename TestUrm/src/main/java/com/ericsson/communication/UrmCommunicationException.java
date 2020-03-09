package com.ericsson.communication;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class UrmCommunicationException extends Exception
{
	private Boolean unreachable = null;
	
    public UrmCommunicationException() {
    }
    public UrmCommunicationException(String msg) {
      super(msg);
    }
    public UrmCommunicationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
    public UrmCommunicationException(String arg0, Throwable arg1, Boolean unreachable) {
		super(arg0, arg1);
		this.unreachable = unreachable;
	}
	public Boolean getUnreachable() {
		return unreachable;
	}
	public void setUnreachable(Boolean unreachable) {
		this.unreachable = unreachable;
	} 
}