package com.ericsson.urm.device.driver;

import java.io.Serializable;


import com.ericsson.urm.device.driver.exceptions.ParseException;
import com.ericsson.urm.device.driver.ftp.datatype.ccs.FileType;


public interface IDriverFtpInfo extends IDriverInstance {
	public <T extends Serializable> T parseFile(String fileName, byte[] data, Class<T> clsRes) throws UnsupportedOperationException, ParseException;
	
	public String getPrefixPath(FileType fileType) throws UnsupportedOperationException;
	
	public String getPathFile(FileType fileType, Object... args) throws UnsupportedOperationException;
}
