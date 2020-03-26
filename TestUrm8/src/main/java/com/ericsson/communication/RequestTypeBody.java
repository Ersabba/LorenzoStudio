package com.ericsson.communication;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class RequestTypeBody implements Serializable
{
    private Hashtable body;

    public RequestTypeBody()
    {
        body = new Hashtable();
    }

    public void addRequestTypeBodyData(Object device, Object data) throws UrmCommunicationException
    {
        body.put(device, data);
    }

    public int getRequestTypeBodyDataSize() throws UrmCommunicationException
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
        Object theDevice = new Object();
        Object theData = new Object();
        Enumeration ks = body.keys();
        while (ks.hasMoreElements())
        {
            if (theIdx == i)
            {
                theDevice = ks.nextElement();
                theData = body.get(theDevice);
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

    public Object getData(String device) {
        Object data = body.get(device);
        return data;
    }

    public Hashtable getBody() {
        return body;
    }


}