package com.ericsson.communication;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public abstract class CommandRequestType implements Serializable {


	private static final long serialVersionUID = -1L;
	private static Logger logger = Logger.getLogger(CommandRequestType.class);
    private RequestTypeBody myRequestTypeBody;
    private RetryInfo myRetryInfo;
    private Integer intCommandRequestTypeCode = null;
    private int indexCommand = -1; 
    
    private boolean postCreateBTCommand = false;

    private static String defaultCommandRequestTypeRegisterClass = "com.ericsson.communication.requesttype.CommandRequestTypeRegister";

    static {
        String commandRequestTypeRegisterClass = System.getProperty("CommandRequestTypeRegisterClass");
        if ((commandRequestTypeRegisterClass == null) || (commandRequestTypeRegisterClass.equals(""))) {
            commandRequestTypeRegisterClass = defaultCommandRequestTypeRegisterClass;
        }

        try {
            Class registerClass = Class.forName(commandRequestTypeRegisterClass);
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

    protected CommandRequestType()
    {
        myRequestTypeBody = new RequestTypeBody();
        myRetryInfo = new RetryInfo();
        
        CommandRequestTypeEnumeration crte = getCommandRequestType();
        if(crte!=null) {
        	intCommandRequestTypeCode = crte.getId();
        }
    }

    public static void registerType(Class requestTypeClass, CommandRequestTypeEnumeration type) {
        type.setImplementingClass(requestTypeClass);
    }

    public static CommandRequestType createRequestType(CommandRequestTypeEnumeration type)
            throws UrmCommunicationException
    {
        CommandRequestType retValue = null;
        try {
            Class implementingClass = type.getImplementingClass();
            if (implementingClass == null) {
                throw new UrmCommunicationException();
            }
            retValue = (CommandRequestType) implementingClass.newInstance();
            retValue.setCommandRequestTypeCode(type.getId());
        } catch (InstantiationException e) {
            logger.error(e);  //To change body of catch statement use Options | File Templates.
        } catch (IllegalAccessException e) {
            logger.error(e);  //To change body of catch statement use Options | File Templates.
        }

        return retValue;
    }

    protected void addRequestTypeBodyData(Object theDevice, Object theData) throws UrmCommunicationException
    {
        myRequestTypeBody.addRequestTypeBodyData(theDevice, theData);
    }

    public abstract CommandRequestTypeEnumeration getCommandRequestType();

    public RequestTypeBody getRequestTypeBody()
    {
        return myRequestTypeBody;
    }

    public void setRetryInfo(int timeoutSecs, int maxRetryNumber, int secondsBetweenRetry)
    {
        myRetryInfo.setRetryInfo(timeoutSecs,maxRetryNumber,secondsBetweenRetry);
    }

    public int getTimeoutSecs() throws UrmCommunicationException
    {
        return myRetryInfo.getTimeoutSecs();
    }

    public int getMaxRetryNumber() throws UrmCommunicationException
    {
        return myRetryInfo.getMaxRetryNumber();
    }

    public int getSecsBetweenRetry() throws UrmCommunicationException
    {
        return myRetryInfo.getSecsBetweenRetry();
    }
    
    public int getIndexCommand() {
		return indexCommand;
	}
    
    public void setIndexCommand(int indexCommand) {
		this.indexCommand = indexCommand;
	}
	
    public boolean isPostCreateBTCommand() {
		return postCreateBTCommand;
	}

	public void setPostCreateBTCommand(boolean postCreateBTCommand) {
		this.postCreateBTCommand = postCreateBTCommand;
	}

	public abstract boolean isValid();

    public String toString() {
        String lineSep = System.getProperty("line.separator");
        StringBuffer buffer = new StringBuffer();
        buffer.append("RequestType \t=\t ");
        buffer.append(this.getCommandRequestType());
        buffer.append(lineSep);
        Hashtable body = getRequestTypeBody().getBody();
        Set entrySet = body.entrySet();
        Iterator it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            buffer.append('\t');
            buffer.append(key.toString());
            buffer.append(" \t=\t ");
            buffer.append(value.toString());
            buffer.append(lineSep);
        }
        return buffer.toString();
    }

    private void setCommandRequestTypeCode (int i){
      this.intCommandRequestTypeCode = new Integer (i);
    }
    public Integer getCommandRequestTypeCode(){
      return this.intCommandRequestTypeCode;
    }

}