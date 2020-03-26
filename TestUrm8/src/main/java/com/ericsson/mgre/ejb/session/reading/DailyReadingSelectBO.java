package com.ericsson.mgre.ejb.session.reading;

import java.io.Serializable;

import com.ericsson.urm.persistence.dto.mgre.FrazStorTotAttAss;
import com.ericsson.urm.persistence.dto.mgre.FrazStorTotAttAssId;
import com.ericsson.urm.persistence.dto.mgre.FrazStorTotEr;
import com.ericsson.urm.persistence.dto.mgre.FrazStorTotErId;
import com.ericsson.urm.persistence.dto.mgre.FrazStorTotReattAss;
import com.ericsson.urm.persistence.dto.mgre.FrazStorTotReattAssId;
import com.ericsson.urm.persistence.dto.mgre.FrazTotAttAss;
import com.ericsson.urm.persistence.dto.mgre.FrazTotEr;
import com.ericsson.urm.persistence.dto.mgre.FrazTotReattAss;
import com.ericsson.urm.persistence.dto.mgre.StorTotAttAss;
import com.ericsson.urm.persistence.dto.mgre.StorTotAttAssId;
import com.ericsson.urm.persistence.dto.mgre.StorTotEr;
import com.ericsson.urm.persistence.dto.mgre.StorTotErId;
import com.ericsson.urm.persistence.dto.mgre.StorTotReattAss;
import com.ericsson.urm.persistence.dto.mgre.StorTotReattAssId;
import com.ericsson.urm.persistence.dto.mgre.TotAttAss;
import com.ericsson.urm.persistence.dto.mgre.TotEr;
import com.ericsson.urm.persistence.dto.mgre.TotReattAss;

public class DailyReadingSelectBO   extends ReadingSelectBO implements Serializable {
	
	private static final long serialVersionUID = -1L;

	private short type=-1;
	
	//response data
	
	private StorTotReattAss[] reactiveResponse=null;
	private StorTotEr[] suppliedResponse=null;
	private StorTotAttAss[] activeResponse=null;

	private FrazStorTotReattAss[] reactiveFrazResponse=null;
	private FrazStorTotEr[] suppliedFrazResponse=null;
	private FrazStorTotAttAss[] activeFrazResponse=null;

	
	
	
	public short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}
	
	public boolean isActiveType(){
		return type==ReadingSelectBO.TYPE_ACTIVE;
	}
	
	public boolean isReactiveType(){
		return type==ReadingSelectBO.TYPE_REACTIVE;
	}
	
	public boolean isSuppliedType(){
		return type==ReadingSelectBO.TYPE_SUPPLIED;
	}
	

	// response methods
	
	

	public StorTotReattAss[] getReactiveResponse() {
		return reactiveResponse;
	}

	public void setReactiveResponse(StorTotReattAss[] reactiveResponse) {
		this.reactiveResponse = reactiveResponse;
	}

	public StorTotEr[] getSuppliedResponse() {
		return suppliedResponse;
	}

	public void setSuppliedResponse(StorTotEr[] suppliedResponse) {
		this.suppliedResponse = suppliedResponse;
	}

	public StorTotAttAss[] getActiveResponse() {
		return activeResponse;
	}

	public void setActiveResponse(StorTotAttAss[] activeResponse) {
		this.activeResponse = activeResponse;
	}

	public FrazStorTotReattAss[] getReactiveFrazResponse() {
		return reactiveFrazResponse;
	}

	public void setReactiveFrazResponse(FrazStorTotReattAss[] reactiveFrazResponse) {
		this.reactiveFrazResponse = reactiveFrazResponse;
	}

	public FrazStorTotEr[] getSuppliedFrazResponse() {
		return suppliedFrazResponse;
	}

	public void setSuppliedFrazResponse(FrazStorTotEr[] suppliedFrazResponse) {
		this.suppliedFrazResponse = suppliedFrazResponse;
	}

	public FrazStorTotAttAss[] getActiveFrazResponse() {
		return activeFrazResponse;
	}

	public void setActiveFrazResponse(FrazStorTotAttAss[] activeFrazResponse) {
		this.activeFrazResponse = activeFrazResponse;
	}
	
	public void setActiveFrazResponse(FrazTotAttAss[] activeFrazResponse) {
		 if(activeFrazResponse!=null && activeFrazResponse.length>0) {
			 FrazStorTotAttAss[] aTmp = new FrazStorTotAttAss[activeFrazResponse.length];
			   
			   for(int j=0; j<activeFrazResponse.length; j++ ) {
			    aTmp[j] = convertToStor(activeFrazResponse[j]);
			   }
			   
			   this.activeFrazResponse = aTmp;
			  }
			  else {
			   this.activeFrazResponse = null;
			  }
	}
	
	public void setReactiveFrazResponse(FrazTotReattAss[] reactiveFrazResponse) {
		 if(reactiveFrazResponse!=null && reactiveFrazResponse.length>0) {
			 FrazStorTotReattAss[] aTmp = new FrazStorTotReattAss[reactiveFrazResponse.length];
			   
			   for(int j=0; j<reactiveFrazResponse.length; j++ ) {
			    aTmp[j] = convertToStor(reactiveFrazResponse[j]);
			   }
			   
			   this.reactiveFrazResponse = aTmp;
			  }
			  else {
			   this.reactiveFrazResponse = null;
			  }
	}
	
	public void setSuppliedFrazResponse(FrazTotEr[] suppliedFrazResponse) {
		 if(suppliedFrazResponse!=null && suppliedFrazResponse.length>0) {
			 FrazStorTotEr[] aTmp = new FrazStorTotEr[suppliedFrazResponse.length];
			   
			   for(int j=0; j<suppliedFrazResponse.length; j++ ) {
			    aTmp[j] = convertToStor(suppliedFrazResponse[j]);
			   }
			   
			   this.suppliedFrazResponse = aTmp;
			  }
			  else {
			   this.suppliedFrazResponse = null;
			  }
	}
	public void setActiveResponse(StorTotAttAss activeResponse) {
		if(activeResponse!=null) {
			   StorTotAttAss[] aTmp = new StorTotAttAss[1];
			   aTmp[0]=activeResponse;
			   this.activeResponse = aTmp;
		}
	}
	
	public void setSuppliedResponse(StorTotEr suppliedResponse) {
		if(activeResponse!=null) {
			StorTotEr[] aTmp = new StorTotEr[1];
			   aTmp[0]=suppliedResponse;
			   this.suppliedResponse = aTmp;
		}
	}
	
	public void setReactiveResponse(StorTotReattAss reactiveResponse) {
		if(reactiveResponse!=null) {
			StorTotReattAss[] aTmp = new StorTotReattAss[1];
			   aTmp[0]=reactiveResponse;
			   this.reactiveResponse = aTmp;
		}
	}
	
	public void setActiveResponse(TotAttAss activeResponse) {
		  if(activeResponse!=null) {
		   StorTotAttAss[] aTmp = new StorTotAttAss[1];
		 
		   aTmp[0] = convertToStor(activeResponse);
		   
		   this.activeResponse = aTmp;
		  }
		  else {
		   this.activeResponse = null;
		  }
		 }
		 
		 public void setActiveResponse(TotAttAss[] activeResponses) {
		  if(activeResponses!=null && activeResponses.length>0) {
		   StorTotAttAss[] aTmp = new StorTotAttAss[activeResponses.length];
		   
		   for(int j=0; j<activeResponses.length; j++ ) {
		    aTmp[j] = convertToStor(activeResponses[j]);
		   }
		   
		   this.activeResponse = aTmp;
		  }
		  else {
		   this.activeResponse = null;
		  }
		 }
		 
		 
		 private StorTotAttAss convertToStor(TotAttAss totAttAss) {
		  StorTotAttAss dto = null;
		  if(totAttAss!=null) {
		   StorTotAttAssId dtoId = new StorTotAttAssId(
		   totAttAss.getMatricolaLenntCliente(), 
		   totAttAss.getDataRil());
		   dto = new StorTotAttAss(dtoId);
		   
		   dto.setAttAss(totAttAss.getAttAss());
		   dto.setAttAssT1(totAttAss.getAttAssT1());
		   dto.setAttAssT2(totAttAss.getAttAssT2());
		   dto.setAttAssT3(totAttAss.getAttAssT3());
		   dto.setAttAssT4(totAttAss.getAttAssT4());
		   dto.setCodConcentratore(totAttAss.getCodConcentratore());
		   dto.setEsito(totAttAss.getEsito());
		  }
		  return dto;
		 }
		 
		 private FrazStorTotAttAss convertToStor(FrazTotAttAss totAttAss) {
			 FrazStorTotAttAss dto = null;
			  if(totAttAss!=null) {
			   FrazStorTotAttAssId dtoId = new FrazStorTotAttAssId(totAttAss.getMatricolaLenntCliente(), totAttAss.getDataRil());
			   dto = new FrazStorTotAttAss();
			   dto.setId(dtoId);
			   dto.setAttAssFraz(totAttAss.getAttAssFraz());
			   dto.setAttAssT1Fraz(totAttAss.getAttAssT1Fraz());
			   dto.setAttAssT2Fraz(totAttAss.getAttAssT2Fraz());
			   dto.setAttAssT3Fraz(totAttAss.getAttAssT3Fraz());
			   dto.setAttAssT4Fraz(totAttAss.getAttAssT4Fraz());
			   dto.setCodConcentratore(totAttAss.getCodConcentratore());
			  }
			  return dto;
			 }
		 
		 private FrazStorTotReattAss convertToStor(FrazTotReattAss reattAss) {
			 FrazStorTotReattAss dto = null;
			  if(reattAss!=null) {
			   FrazStorTotReattAssId dtoId = new FrazStorTotReattAssId(reattAss.getMatricolaLenntCliente(), reattAss.getDataRil());
			   dto = new FrazStorTotReattAss();
			   dto.setId(dtoId);
			   dto.setReattIndAssFraz(reattAss.getReattIndAssFraz());
			   dto.setReattIndAssT1Fraz(reattAss.getReattIndAssT1Fraz());
			   dto.setReattIndAssT2Fraz(reattAss.getReattIndAssT2Fraz());
			   dto.setReattIndAssT3Fraz(reattAss.getReattIndAssT3Fraz());
			   dto.setReattIndAssT4Fraz(reattAss.getReattIndAssT4Fraz());
			   dto.setReattCapAssFraz(reattAss.getReattCapAssFraz());
			  }
			  return dto;
			 }

		 private FrazStorTotEr convertToStor(FrazTotEr totEr) {
			 FrazStorTotEr dto = null;
			  if(totEr!=null) {
			   FrazStorTotErId dtoId = new FrazStorTotErId(totEr.getMatricolaLenntCliente(), totEr.getDataRil());
			   dto = new FrazStorTotEr();
			   dto.setId(dtoId);
			   dto.setAttErFraz(totEr.getAttErFraz());
			   dto.setAttErT1Fraz(totEr.getAttErT1Fraz());
			   dto.setAttErT2Fraz(totEr.getAttErT2Fraz());
			   dto.setAttErT3Fraz(totEr.getAttErT3Fraz());
			   dto.setAttErT4Fraz(totEr.getAttErT4Fraz());
			   dto.setReattCapErFraz(totEr.getReattCapErFraz());
			   dto.setReattIndErFraz(totEr.getReattIndErFraz());
			  }
			  return dto;
			 }
		 
		 
		 public void setSuppliedResponse(TotEr suppliedResponses) {
			  if(suppliedResponses!=null) {
				  StorTotEr[] aTmp = new StorTotEr[1];
			 
			   aTmp[0] = convertToStor(suppliedResponses);
			   
			   this.suppliedResponse = aTmp;
			  }
			  else {
			   this.suppliedResponse = null;
			  }
			 }
			 
			 public void setSuppliedResponse(TotEr[] suppliedResponses) {
			  if(suppliedResponses!=null && suppliedResponses.length>0) {
			   StorTotEr[] aTmp = new StorTotEr[suppliedResponses.length];
			   
			   for(int j=0; j<suppliedResponses.length; j++ ) {
			    aTmp[j] = convertToStor(suppliedResponses[j]);
			   }
			   
			   this.suppliedResponse = aTmp;
			  }
			  else {
			   this.suppliedResponse = null;
			  }
			 }
			 
			 
			 private StorTotEr convertToStor(TotEr totEr) {
			   StorTotEr dto = null;
			  if(totEr!=null) {
			   StorTotErId dtoId = new StorTotErId(
					   totEr.getMatricolaLenntCliente(), 
					   totEr.getDataRil());
			   dto = new StorTotEr(dtoId);
			   
			   dto.setAttEr(totEr.getAttEr());
			   dto.setAttErT1(totEr.getAttErT1());
			   dto.setAttErT2(totEr.getAttErT2());
			   dto.setAttErT3(totEr.getAttErT3());
			   dto.setAttErT4(totEr.getAttErT4());
			   dto.setReattCapEr(totEr.getReattCapEr());
			   dto.setReattIndEr(totEr.getReattIndEr());
			   dto.setEsito(totEr.getEsito());
			  }
			  return dto;
			 }
			 
			 
			 
			 public void setReactiveResponse(TotReattAss reactiveResponse) {
				  if(reactiveResponse!=null) {
				   StorTotReattAss[] aTmp = new StorTotReattAss[1];
				 
				   aTmp[0] = convertToStor(reactiveResponse);
				   
				   this.reactiveResponse = aTmp;
				  }
				  else {
				   this.reactiveResponse = null;
				  }
				 }
				 
				 public void reactiveResponse(TotAttAss[] reactiveResponse) {
				  if(reactiveResponse!=null && reactiveResponse.length>0) {
				   StorTotAttAss[] aTmp = new StorTotAttAss[reactiveResponse.length];
				   
				   for(int j=0; j<reactiveResponse.length; j++ ) {
				    aTmp[j] = convertToStor(reactiveResponse[j]);
				   }
				   
				   this.activeResponse = aTmp;
				  }
				  else {
				   this.activeResponse = null;
				  }
				 }
				 
				 
				 private StorTotReattAss convertToStor(TotReattAss totReattAss) {
				StorTotReattAss dto = null;
				  if(totReattAss!=null) {
				   StorTotReattAssId dtoId = new StorTotReattAssId(
				   totReattAss.getMatricolaLenntCliente(), 
				   totReattAss.getDataRil());
				   dto = new StorTotReattAss(dtoId);
				   
				   dto.setReattIndAss(totReattAss.getReattIndAss());
				   dto.setReattIndAssT1(totReattAss.getReattIndAssT1());
				   dto.setReattIndAssT2(totReattAss.getReattIndAssT2());
				   dto.setReattIndAssT3(totReattAss.getReattIndAssT3());
				   dto.setReattIndAssT4(totReattAss.getReattIndAssT4());
				   dto.setReattCapAss(totReattAss.getReattCapAss());
				   dto.setEsito(totReattAss.getEsito());
				  }
				  return dto;
				 }


}
