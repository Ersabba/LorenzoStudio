package com.ericsson.communication;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.apache.log4j.Logger;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public abstract class CommandResponseType implements Serializable
{
	private static final long serialVersionUID = -1;
	
	private static Logger logger = Logger.getLogger(CommandResponseType.class);
	
    private ResponseTypeBody myResponseTypeBody;
    private int createdBTCommands;
    private int sentBTCommandsSuccess;

    private static String defaultCommandResponseTypeRegisterClass = "com.ericsson.communication.responsetype.CommandResponseTypeRegister";

    static {
        String commandResponseTypeRegisterClass = System.getProperty("CommandResponseTypeRegisterClass");
        if ((commandResponseTypeRegisterClass == null) || (commandResponseTypeRegisterClass.equals(""))) {
            commandResponseTypeRegisterClass = defaultCommandResponseTypeRegisterClass;
        }

        try {
            Class registerClass = Class.forName(commandResponseTypeRegisterClass);
            Method registerMethod = registerClass.getMethod("registerTypes", new Class[0]);
            Object register = registerClass.newInstance();
            registerMethod.invoke(register, new Object[0]);
        } catch (ClassNotFoundException e) {
            logger.error(e);  //To change body of catch statement use Options | File Templates.
        } catch (NoSuchMethodException e) {
            logger.error(e);  //To change body of catch statement use Options | File Templates.
        } catch (SecurityException e) {
            logger.error(e);  //To change body of catch statement use Options | File Templates.
        } catch (InstantiationException e) {
            logger.error(e);  //To change body of catch statement use Options | File Templates.
        } catch (IllegalAccessException e) {
            logger.error(e);  //To change body of catch statement use Options | File Templates.
        } catch (IllegalArgumentException e) {
            logger.error(e);  //To change body of catch statement use Options | File Templates.
        } catch (InvocationTargetException e) {
            logger.error(e);  //To change body of catch statement use Options | File Templates.
        }
    }


    public CommandResponseType()
    {
        myResponseTypeBody = new ResponseTypeBody();
    }

    public static void registerType(Class requestTypeClass, CommandResponseTypeEnumeration type) {
        type.setImplementingClass(requestTypeClass);
    }

    public static CommandResponseType createResponseType(CommandResponseTypeEnumeration type)
            throws UrmCommunicationException
    {
        CommandResponseType retValue = null;
        try {
            Class implementingClass = type.getImplementingClass();
            if (implementingClass == null) {
                throw new UrmCommunicationException();
            }
            retValue = (CommandResponseType) implementingClass.newInstance();
        } catch (InstantiationException e) {
            logger.error(e);  //To change body of catch statement use Options | File Templates.
        } catch (IllegalAccessException e) {
            logger.error(e);  //To change body of catch statement use Options | File Templates.
        }

        return retValue;
    }


    public abstract CommandResponseTypeEnumeration getCommandResponseType();

    protected void addResponseTypeBodyData(String device, Object data, Object result) throws UrmCommunicationException
    {
        myResponseTypeBody.addResponseTypeBodyData(device, data, result);
    }

    public ResponseTypeBody getResponseTypeBody()
    {
        return myResponseTypeBody;
    }
    
    public abstract boolean isValid();
    
    
    public int getCreatedBTCommands() {
		return createdBTCommands;
	}

	public void setCreatedBTCommands(int createdBTCommands) {
		this.createdBTCommands = createdBTCommands;
	}

	public int getSentBTCommandsSuccess() {
		return sentBTCommandsSuccess;
	}

	public void setSentBTCommandsSuccess(int sentBTCommandsSuccess) {
		this.sentBTCommandsSuccess = sentBTCommandsSuccess;
	}

	public String toString() {
        String lineSep = System.getProperty("line.separator");
        StringBuffer buffer = new StringBuffer();
        buffer.append("ResponseType \t=\t ");
        buffer.append(this.getCommandResponseType());
        buffer.append(lineSep);
        Hashtable body = getResponseTypeBody().getBody();
        Set entrySet = body.entrySet();
        Iterator it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = ((Vector)entry.getValue()).get(1);
            buffer.append('\t');
            buffer.append(key!=null ? key.toString() : "null");
            buffer.append(" \t=\t ");
            buffer.append(value!=null ? value.toString(): "null");
            buffer.append(lineSep);
        }
        return buffer.toString();
    }

}