package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;

import com.ericsson.urm.core.enumeration.LenntTypeCode;
import com.ericsson.urm.device.driver.DeviceProtocol;

public class LenntType implements Serializable {

	private static final long serialVersionUID = -1L;
	
	private String lenntTypeId=null;
	private String type=null;
	private String loadProgressionEnabled=null;
	private String description=null;
	private String internalCode;
	private String protocol;
	
	public static final String TYPE_TRIFASE="TRIFASE";
	public static final String TYPE_MONOFASE="MONOFASE";
	
	
	public LenntType() {
		super();
	}
	public LenntType(String lenntTypeId) {
		super();
		this.lenntTypeId = lenntTypeId;
	}
	public String getLenntTypeId() {
		return lenntTypeId;
	}
	public void setLenntTypeId(String lenntTypeId) {
		this.lenntTypeId = lenntTypeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLoadProgressionEnabled() {
		return loadProgressionEnabled;
	}
	public void setLoadProgressionEnabled(String loadProgressionEnabled) {
		this.loadProgressionEnabled = loadProgressionEnabled;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public LenntTypeCode getInternalCode() {
		return LenntTypeCode.parse(internalCode);
	}
	
	public void setInternalCode(LenntTypeCode internalCode) {
		this.internalCode = internalCode!=null ? internalCode.getDbCode() 
				                               : LenntTypeCode.UNTYPED.getDbCode();
	}
	public DeviceProtocol getProtocol() {
		return protocol != null ? DeviceProtocol.parse(protocol) : null;
	}
	public void setProtocol(DeviceProtocol protocol) {
		if(protocol==null) {
			throw new IllegalArgumentException("Undefined device protocol");
		}
		this.protocol = protocol.toString();
	}
	
}
