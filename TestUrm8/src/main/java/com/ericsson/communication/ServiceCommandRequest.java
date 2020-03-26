package com.ericsson.communication;

import java.util.Date;
import java.util.Vector;

import com.ericsson.urm.communication.ICallbackResponse;

/**
 * <p>Title: ServiceCommandRequest</p>
 * <p>Description: Implementation of the Urm SC_REQ</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Ericsson</p>
 * @author not attributable
 * @version 1.0
 */

public class ServiceCommandRequest extends ServiceCommand
{
	private static final long serialVersionUID = -1L;
	private String responseJndiConnectionFactory;
	private String responseJndiDestination;
	private ICallbackResponse callbackResponse;
	private boolean forcedParentGatewayCommunication = false;
	
    private int priority;
    private Date expiry;
    private Vector commandRequestTypes;
    
    private Long delayTimeToDeliver = null;

    private String taskCode;

    public ServiceCommandRequest()
    {
        int clientId = 0;
        int priority = 1;
        commandRequestTypes = new Vector();
    }



    public Long getDelayTimeToDeliver() {
		return delayTimeToDeliver;
	}




	public void setDelayTimeToDeliver(Long delayTimeToDeliver) {
		this.delayTimeToDeliver = delayTimeToDeliver;
	}




	/**
     * @param priority
     * @exception UrmCommunicationException
     */
    public void setPriority(int priority) throws UrmCommunicationException
    {
        this.priority = priority;
    }



    /**
     * @return int
     * @exception UrmCommunicationException
     */
    public int getPriority() throws UrmCommunicationException
    {
        return priority;
    }

    /**
     * @param expiryDate
     * @exception UrmCommunicationException
     */
    public void setExpiry(Date expiryDate) throws UrmCommunicationException
    {
        expiry = expiryDate;
    }

    /**
     * @return Date
     * @exception UrmCommunicationException
     */
    public Date getExpiry() throws UrmCommunicationException
    {
        return expiry;
    }

    /**
     * @param cmdRequestType
     * @exception UrmCommunicationException
     */
    public void addCommand(CommandRequestType cmdRequestType) throws UrmCommunicationException
    {
        if (!cmdRequestType.isValid()) {
            throw new UrmCommunicationException();
        }

        try
        {
            commandRequestTypes.add(cmdRequestType);
        }
        catch (Exception e)
        {
            throw new UrmCommunicationException();
        }
    }

    /**
     * @return Vector
     * @exception UrmCommunicationException
     */
    public Vector getCommandRequestTypes() throws UrmCommunicationException
    {
        return commandRequestTypes;
    }

    
    public void addRequest(CommandRequestType cmdRequestType) throws UrmCommunicationException
    {
        if (!cmdRequestType.isValid()) {
            throw new UrmCommunicationException();
        }

        try
        {
            commandRequestTypes.add(cmdRequestType);
        }
        catch (Exception e)
        {
            throw new UrmCommunicationException();
        }
    }



	public String getResponseJndiConnectionFactory() {
		return responseJndiConnectionFactory;
	}



	public void setResponseJndiConnectionFactory(
			String responseJndiConnectionFactory) {
		this.responseJndiConnectionFactory = responseJndiConnectionFactory;
	}
	

	public ICallbackResponse getCallbackResponse() {
		return callbackResponse;
	}



	public void setCallbackResponse(ICallbackResponse callbackResponse) {
		this.callbackResponse = callbackResponse;
	}


	public String getResponseJndiDestination() {
		return responseJndiDestination;
	}


	public void setResponseJndiDestination(String responseJndiDestination) {
		this.responseJndiDestination = responseJndiDestination;
	}


	public boolean isForcedParentGatewayCommunication() {
		return forcedParentGatewayCommunication;
	}

	public void setForcedParentGatewayCommunication(
			boolean forcedParentGatewayCommunication) {
		this.forcedParentGatewayCommunication = forcedParentGatewayCommunication;
	}

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }
}