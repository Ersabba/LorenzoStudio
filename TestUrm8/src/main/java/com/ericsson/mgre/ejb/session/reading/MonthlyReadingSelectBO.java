package com.ericsson.mgre.ejb.session.reading;

import java.io.Serializable;

import com.ericsson.urm.persistence.dto.mgre.MensileAttAss;
import com.ericsson.urm.persistence.dto.mgre.MensileAttAssFraz;
import com.ericsson.urm.persistence.dto.mgre.MensileEr;
import com.ericsson.urm.persistence.dto.mgre.MensileErFraz;
import com.ericsson.urm.persistence.dto.mgre.MensileReattAss;
import com.ericsson.urm.persistence.dto.mgre.MensileReattAssFraz;

public class MonthlyReadingSelectBO  extends ReadingSelectBO implements Serializable {
	
	
	private static final long serialVersionUID = -1L;


	private short type=-1;
	
	
	// response data
	
	private MensileReattAss[] reactiveResponse=null;
	private MensileEr[] suppliedResponse=null;
	private MensileAttAss[] activeResponse=null;
	
	private MensileReattAssFraz[] reactiveFrazResponse=null;
	private MensileErFraz[] suppliedFrazResponse=null;
	private MensileAttAssFraz[] activeFrazResponse=null;

	
	
	
	public short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}
	
	public boolean isActiveType(){
		return type==TYPE_ACTIVE;
	}
	
	public boolean isReactiveType(){
		return type==TYPE_REACTIVE;
	}
	
	public boolean isSuppliedType(){
		return type==TYPE_SUPPLIED;
	}
	
	
// response methods
	
	/**
	 * Returns the response data in case of Reactive request
	 * @return
	 */
	public MensileReattAss[] getReactiveResponse(){
		return reactiveResponse;
	}
	/**
	 * Returns the response data in case of Supplied request
	 * @return
	 */
	public MensileEr[] getSuppliedResponse(){
		return suppliedResponse;
	}
	
	/**
	 * Returns the response data in case of Active request
	 * @return
	 */
	public MensileAttAss[] getActiveResponse(){
		return activeResponse;
	}

	public void setReactiveResponse(MensileReattAss[] reactiveResponse) {
		this.reactiveResponse = reactiveResponse;
	}

	public void setSuppliedResponse(MensileEr[] suppliedResponse) {
		this.suppliedResponse = suppliedResponse;
	}

	public void setActiveResponse(MensileAttAss[] activeResponse) {
		this.activeResponse = activeResponse;
	}

	public MensileReattAssFraz[] getReactiveFrazResponse() {
		return reactiveFrazResponse;
	}

	public void setReactiveFrazResponse(MensileReattAssFraz[] reactiveFrazResponse) {
		this.reactiveFrazResponse = reactiveFrazResponse;
	}

	public MensileErFraz[] getSuppliedFrazResponse() {
		return suppliedFrazResponse;
	}

	public void setSuppliedFrazResponse(MensileErFraz[] suppliedFrazResponse) {
		this.suppliedFrazResponse = suppliedFrazResponse;
	}

	public MensileAttAssFraz[] getActiveFrazResponse() {
		return activeFrazResponse;
	}

	public void setActiveFrazResponse(MensileAttAssFraz[] activeFrazResponse) {
		this.activeFrazResponse = activeFrazResponse;
	}	
	
	
	
	public void setReactiveResponse(MensileReattAss reactiveResponse) {
		if(activeResponse!=null) {
			MensileReattAss[] aTmp = new MensileReattAss[1];
			   aTmp[0]=reactiveResponse;
			   this.reactiveResponse = aTmp;
		}
	}
	
	public void setSuppliedResponse(MensileEr suppliedResponse) {
		if(suppliedResponse!=null) {
			MensileEr[] aTmp = new MensileEr[1];
			   aTmp[0]=suppliedResponse;
			   this.suppliedResponse = aTmp;
		}
	}
	
	public void setActiveResponse(MensileAttAss activeResponse) {
		if(activeResponse!=null) {
			MensileAttAss[] aTmp = new MensileAttAss[1];
			   aTmp[0]=activeResponse;
			   this.activeResponse = aTmp;
		}
	}
	
	
	public void setReactiveFrazResponse(MensileReattAssFraz reactiveFrazResponse) {
		if(reactiveFrazResponse!=null) {
			MensileReattAssFraz[] aTmp = new MensileReattAssFraz[1];
			   aTmp[0]=reactiveFrazResponse;
			   this.reactiveFrazResponse = aTmp;
		}
	}
	
	public void setSuppliedFrazResponse(MensileErFraz suppliedFrazResponse) {
		if(suppliedFrazResponse!=null) {
			MensileErFraz[] aTmp = new MensileErFraz[1];
			   aTmp[0]=suppliedFrazResponse;
			   this.suppliedFrazResponse = aTmp;
		}
	}


	public void setActiveFrazResponse(MensileAttAssFraz activeFrazResponse) {
		if(activeFrazResponse!=null) {
			MensileAttAssFraz[] aTmp = new MensileAttAssFraz[1];
			   aTmp[0]=activeFrazResponse;
			   this.activeFrazResponse = aTmp;
		}
	}
	
	
	

}
