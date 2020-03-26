package com.ericsson.urm.device.driver;


public interface IDeviceLocker {
	
	public boolean tryLock();
	
	public boolean releaseLock();

	public String getGatewayCode();

	public boolean isLockEnabled();

	public int getRetryForLock();

	public void setRetryForLock(int retryForLock);

	public int getDelayRetry();

	public void setDelayRetry(int delayRetry);

	public long getTimeLockExpired();

	public void setTimeLockExpired(long timeLockExpired);

	public String getLockOwner();

}
