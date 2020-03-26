package com.ericsson.urm.device.driver.ftp.datatype;

import java.util.Date;


public interface IFileDetailResponse extends IFtpResultCode {
	public String getPathFile();
	public Date getReferenceDate();
	public Date getLastModified();
	public Date getCreated();
}
