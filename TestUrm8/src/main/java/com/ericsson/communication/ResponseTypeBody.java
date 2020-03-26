package com.ericsson.communication;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ResponseTypeBody implements Serializable
{
    private Hashtable body;
    private Vector values;

    public ResponseTypeBody()
    {
        body = new Hashtable();
    }

    public void addResponseTypeBodyData(Object device, Object data, Object result) throws UrmCommunicationException
    {
        values= new Vector();
        values.add(data);
        values.add(result);
        body.put(device, values);
    }

    public int getResponseTypeBodyDataSize() throws UrmCommunicationException
    {
        return body.size();
    }

    public Object getDevice(int idx) throws UrmCommunicationException
    {
        int theIdx = idx + 1;
        int i = 1;
        Object theDevice = new Object();
        Enumeration ks = body.keys();
        while (ks.hasMoreElements())
        {
            if (theIdx == i)
            {
                theDevice = ks.nextElement();
                break;
            }
            else
            {
                ks.nextElement();
                i++;
            }
        }
        return theDevice;
    }

    public Object getData(int idx) throws UrmCommunicationException
    {
        int theIdx = idx + 1;
        int i = 1;
        String theDevice = "";
        Vector theVectData = new Vector();
        Object theData = new Object();
        Enumeration ks = body.keys();
        while (ks.hasMoreElements())
        {
            if (theIdx == i)
            {
                theDevice = (String) ks.nextElement();
                theVectData = (Vector) body.get(theDevice);
                theData = (Object) theVectData.elementAt(0);
                break;
            }
            else
            {
                ks.nextElement();
                i++;
            }

        }
        return theData;
    }

    public Object getResult(int idx) throws UrmCommunicationException
    {
        int theIdx = idx + 1;
        int i = 1;
        String theDevice = "";
        Vector theVectResult = new Vector();
        Object theResult = new Object();
        Enumeration ks = body.keys();
        while (ks.hasMoreElements())
        {
            if (theIdx == i)
            {
                theDevice = (String) ks.nextElement();
                theVectResult = (Vector) body.get(theDevice);
                theResult = (Object) theVectResult.elementAt(1);
                break;
            }
            else
            {
                ks.nextElement();
                i++;
            }

        }
        return theResult;
    }

    public Object getResult(String device) {
    	Vector vect = (Vector)body.get(device);
        Object result = (vect!=null ? vect.get(1) : null);
        return result;
    }

    public Hashtable getBody() {
        return body;//to do eliminare! non si deve avere accesso alla struttura interna
    }

    
    public Object getData(String device) {
    	Vector vect = (Vector)body.get(device);
        Object data = (vect!=null ? vect.get(0) : null);
        return data;
    }
}