package com.ericsson.urm.persistence.dto.mgre.datatype;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.communication.responsetype.ReadResetLenntsListResponseType.ResetResult;

public class LenntStatusWordDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public String matricola; 
	public ResetResult stato;
	public Date lastDateReset; 
	
}
