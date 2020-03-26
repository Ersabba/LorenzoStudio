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

public class RetryInfo implements Serializable
{

    private int timeoutSecs;
    private int maxRetryNumber;
    private int secsBetweenRetry;

    public RetryInfo()
    {
    }

    public void setRetryInfo(int timeoutSecs, int maxRetryNumber, int secsBetweenRetry)
    {
        this.timeoutSecs = timeoutSecs;
        this.maxRetryNumber = maxRetryNumber;
        this.secsBetweenRetry = secsBetweenRetry;
    }

    public int getTimeoutSecs()
    {
        return timeoutSecs;
    }

    public int getMaxRetryNumber()
    {
        return maxRetryNumber;
    }

    public int getSecsBetweenRetry()
    {
        return secsBetweenRetry;
    }
}