package com.ericsson.communication;

import java.util.Vector;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ServiceCommandResponse extends ServiceCommand
{
	private static final long serialVersionUID = 1L;
    private Vector  commandResponseTypes;
    private boolean isLatest;
    

    public ServiceCommandResponse()
    {
        commandResponseTypes = new Vector();
        isLatest = true;
    }

    public void addResponse(CommandResponseType cmdResponseType) throws UrmCommunicationException
    {
        if (!cmdResponseType.isValid()) {
            throw new UrmCommunicationException();
        }

        try
        {
            commandResponseTypes.add(cmdResponseType);
        }
        catch (Exception e)
        {
            throw new UrmCommunicationException();
        }
    }

    public Vector getCommandResponseTypes()
    {
        return commandResponseTypes;
    }

    public void setIsLatest(boolean isLatest) {
    	this.isLatest = isLatest;
    }

    public boolean getIsLatest() {
    	return isLatest;
    }
}