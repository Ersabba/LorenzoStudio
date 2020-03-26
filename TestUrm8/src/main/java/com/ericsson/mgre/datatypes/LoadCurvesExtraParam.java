package com.ericsson.mgre.datatypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class LoadCurvesExtraParam implements Serializable {

	private static final long			serialVersionUID	= 1L;

	private Integer						ritardoPLC;
	private boolean						mobileWindow;
	private List<LoadCurvesExtraParams>	extraParams			= new ArrayList<LoadCurvesExtraParams>();

	public Integer getRitardoPLC() {
		return ritardoPLC;
	}

	public void setRitardoPLC(Integer ritardoPLC) {
		this.ritardoPLC = ritardoPLC;
	}

	public boolean isMobileWindow() {
		return mobileWindow;
	}

	public void setMobileWindow(boolean mobileWindow) {
		this.mobileWindow = mobileWindow;
	}

	public List<LoadCurvesExtraParams> getExtraParams() {
		return extraParams;
	}

	public void setExtraParams(List<LoadCurvesExtraParams> extraParams) {
		this.extraParams = extraParams;
	}
}
