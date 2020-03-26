package com.ericsson.urm.device.driver;

import com.ericsson.urm.device.driver.exceptions.FileNotFoundException;
import com.ericsson.urm.device.driver.ftp.datatype.IFileDetailResponse;
import com.ericsson.urm.device.driver.ftp.datatype.RawFileResponse;
import com.ericsson.urm.device.driver.ftp.datatype.ccs.FileType;



public interface IFtpRequest extends IDriverFtpInfo, IDriver {

	public RawFileResponse getCurrentVoltageProfile(int day, boolean endDST) throws DeviceDriverException, UnsupportedOperationException;
	
	public RawFileResponse getFileBinary(FileType fileType, Object... args) throws DeviceDriverException, UnsupportedOperationException;
	
	public RawFileResponse getFileBinary(String pathFile) throws DeviceDriverException, UnsupportedOperationException;
	
	public IFileDetailResponse getFileDetail(String pathFile) throws DeviceDriverException, UnsupportedOperationException, FileNotFoundException, CommunicationException;
	public IFileDetailResponse getFileDetail(FileType fileType, Object... args) throws DeviceDriverException, UnsupportedOperationException, FileNotFoundException, CommunicationException;
	
	public boolean existsFile(FileType fileType, Object... args) throws DeviceDriverException, CommunicationException, UnsupportedOperationException;
	
	public boolean putFileBinary(byte[] content, FileType fyleType, Object... args) throws DeviceDriverException, UnsupportedOperationException;
}
