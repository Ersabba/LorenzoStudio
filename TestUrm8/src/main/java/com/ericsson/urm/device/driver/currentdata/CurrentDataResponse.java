package com.ericsson.urm.device.driver.currentdata;

import java.io.Serializable;

public class CurrentDataResponse implements Serializable {
	
	private Integer				VR;
	private Integer				VS;
	private Integer				VT;
	private Integer				PAplus;
	private Integer				PAminus;
	private Integer				PRplus;
	private Integer				PRminus;
	private Integer				IR;
	private Integer				IS;
	private Integer				IT;
	public Integer getVR() {
		return VR;
	}
	public void setVR(Integer vR) {
		VR = vR;
	}
	public Integer getVS() {
		return VS;
	}
	public void setVS(Integer vS) {
		VS = vS;
	}
	public Integer getVT() {
		return VT;
	}
	public void setVT(Integer vT) {
		VT = vT;
	}
	public Integer getPAplus() {
		return PAplus;
	}
	public void setPAplus(Integer pAplus) {
		PAplus = pAplus;
	}
	public Integer getPAminus() {
		return PAminus;
	}
	public void setPAminus(Integer pAminus) {
		PAminus = pAminus;
	}
	public Integer getPRplus() {
		return PRplus;
	}
	public void setPRplus(Integer pRplus) {
		PRplus = pRplus;
	}
	public Integer getPRminus() {
		return PRminus;
	}
	public void setPRminus(Integer pRminus) {
		PRminus = pRminus;
	}
	public Integer getIR() {
		return IR;
	}
	public void setIR(Integer iR) {
		IR = iR;
	}
	public Integer getIS() {
		return IS;
	}
	public void setIS(Integer iS) {
		IS = iS;
	}
	public Integer getIT() {
		return IT;
	}
	public void setIT(Integer iT) {
		IT = iT;
	}
	
	

}
