package com.ericsson.mgre.ejb.session.reading;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.persistence.dto.mgre.FrazStorTotAttAss;
import com.ericsson.urm.persistence.dto.mgre.FrazStorTotEr;
import com.ericsson.urm.persistence.dto.mgre.FrazStorTotReattAss;
import com.ericsson.urm.persistence.dto.mgre.StorTotAttAss;
import com.ericsson.urm.persistence.dto.mgre.StorTotEr;
import com.ericsson.urm.persistence.dto.mgre.StorTotReattAss;

public class OneReadingSelectBO implements Serializable {

	private static final long serialVersionUID = -1L;
	private String meterId = null;
	private Date dataRil = null;

	private short type = -1;

	// response data

	private StorTotReattAss reactiveResponse = null;
	private StorTotEr suppliedResponse = null;
	private StorTotAttAss activeResponse = null;
	

	private FrazStorTotReattAss reactiveFrazResponse = null;
	private FrazStorTotEr suppliedFrazResponse = null;
	private FrazStorTotAttAss activeFrazResponse = null;

	public short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}

	public boolean isActiveType() {
		return type == ReadingSelectBO.TYPE_ACTIVE;
	}

	public boolean isReactiveType() {
		return type == ReadingSelectBO.TYPE_REACTIVE;
	}

	public boolean isSuppliedType() {
		return type == ReadingSelectBO.TYPE_SUPPLIED;
	}

	// response methods

	/**
	 * Returns the response data in case of Reactive request
	 * 
	 * @return
	 */
	public StorTotReattAss getReactiveResponse() {
		return reactiveResponse;
	}

	/**
	 * Returns the response data in case of Supplied request
	 * 
	 * @return
	 */
	public StorTotEr getSuppliedResponse() {
		return suppliedResponse;
	}

	/**
	 * Returns the response data in case of Active request
	 * 
	 * @return
	 */
	public StorTotAttAss getActiveResponse() {
		return activeResponse;
	}

	public void setReactiveResponse(StorTotReattAss reactiveResponse) {
		this.reactiveResponse = reactiveResponse;
	}

	public void setSuppliedResponse(StorTotEr suppliedResponse) {
		this.suppliedResponse = suppliedResponse;
	}

	public void setActiveResponse(StorTotAttAss activeResponse) {
		this.activeResponse = activeResponse;
	}

	public String getMeterId() {
		return meterId;
	}

	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}

	public Date getDataRil() {
		return dataRil;
	}

	public void setDataRil(Date dataRil) {
		this.dataRil = dataRil;
	}

	public FrazStorTotReattAss getReactiveFrazResponse() {
		return reactiveFrazResponse;
	}

	public void setReactiveFrazResponse(FrazStorTotReattAss reactiveFrazResponse) {
		this.reactiveFrazResponse = reactiveFrazResponse;
	}

	public FrazStorTotEr getSuppliedFrazResponse() {
		return suppliedFrazResponse;
	}

	public void setSuppliedFrazResponse(FrazStorTotEr suppliedFrazResponse) {
		this.suppliedFrazResponse = suppliedFrazResponse;
	}

	public FrazStorTotAttAss getActiveFrazResponse() {
		return activeFrazResponse;
	}

	public void setActiveFrazResponse(FrazStorTotAttAss activeFrazResponse) {
		this.activeFrazResponse = activeFrazResponse;
	}
	
/*	
	public double scaleAndSumIntegerAndDecimal(Long integerPart, Long decimalPart){		
		double val = 0.0;
        	 val = Double.parseDouble(integerPart!=null?integerPart.toString():"0") + ((Double.parseDouble(decimalPart!=null?decimalPart.toString():"0")) / 10000.00);       	
  
             return val;
	}
	*/
	
}
