package com.ericsson.communication;

import java.io.Serializable;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ServiceCommand implements Serializable {

    private String senderId;
    private String recipientId;
    private String referenceId;
    private String strMessage;
    private String strMessageId;
    private String strIpAddress;
    private String strUser;
    private String strPassword;

    private static boolean ipAddress_set = false;
    private static boolean user_set = false;

    /**
     * @param theClientId
     */
    public void setSenderId(String theClientId) throws UrmCommunicationException
    {
        senderId = theClientId;
    }


    /**
     * @param theReferenceId
     */
    public void setReferenceId(String theReferenceId) throws UrmCommunicationException
    {
        referenceId = theReferenceId;
    }
    /**
     * @return int
     * @exception UrmCommunicationException
     */
    public String getSenderId() throws UrmCommunicationException
    {
        return senderId;
    }
    /**
     * @return String
     * @exception UrmCommunicationException
     */
    public String getReferenceId() throws UrmCommunicationException
    {
        return referenceId;
    }

    public void setRecipientId(String theRecipientId) throws UrmCommunicationException
    {
        this.recipientId = theRecipientId;
    }

    public String getRecipientId() throws UrmCommunicationException
    {
        return this.recipientId;
    }

    public String getMessage(){
        return strMessage;
    }

    public void setMessage(String msg)
    {
        this.strMessage = msg;
    }

    public String getIpAddress(){
        return strIpAddress;
    }

/**
 * Metodo per l'inserimento dell'indirizzo ip da cui ? partito il comando
  * @param msg
 */

    public void setIpAddress(String msg)
    {
        this.strIpAddress = msg;
        ipAddress_set = true;
    }

    public String getMessageId(){
        return strMessageId;
    }

    public void setMessageId(String id)
    {
        this.strMessageId = id;
    }

    public String getUser(){
        return strUser;
    }

/**
 * Metodo per l'inserimento dell'utente che ha inviato il service Command
 *
  * @param id
 */

    public void setUser(String id)
    {
        this.strUser = id;
        user_set = true;
    }
    
 
    public String getPassword() {
	return strPassword;
}


public void setPassword(String strPassword) {
	this.strPassword = strPassword;
}


	public boolean isValid(){
      //return ipAddress_set && user_set;
        return true;
    }

}