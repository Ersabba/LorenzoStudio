package com.ericsson.urm.device.driver.ftp.datatype;

import java.util.Date;


public interface RawFileResponse extends IFtpResultCode {
	public String getPathFile();
	public byte[] getData();
	public Date getReferenceDate();
}
