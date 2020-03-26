package com.ericsson.urm.persistence.dto.mgre.datatype;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;

import com.ericsson.urm.util.ArgumentsCheckerUtil;


public class LoadCurvesCcsState implements Serializable {
	
	private static final long serialVersionUID = -1L;
	private String ccsId;
	private Hashtable mapStates = null;
	
	public LoadCurvesCcsState() {
		mapStates = new Hashtable();
	};
	
	public LoadCurvesCcsState(String ccsId) {
		ArgumentsCheckerUtil.checkString(ccsId);
		this.ccsId = ccsId;
		mapStates = new Hashtable();
	};
	
	public String getCcsId() {
		return ccsId;
	}

	public void setCcsId(String ccsId) {
		ArgumentsCheckerUtil.checkString(ccsId);
		this.ccsId = ccsId;
	}
	
	public Hashtable getMapStates() {
		return mapStates;
	}

	public void setMapStates(Hashtable mapStates) {
		ArgumentsCheckerUtil.checkNull(mapStates);
		this.mapStates = mapStates;
	}
	
	private String makeKey(Date referenceDate, EnergyComponentId energyComponentId, int integrationPeriod) {
		ArgumentsCheckerUtil.checkNull(referenceDate);
		ArgumentsCheckerUtil.checkNull(energyComponentId);
		
		if(ccsId==null) {
			throw new IllegalStateException("ccs id has not been defined");
		}
		
		DecimalFormat df = new DecimalFormat("#00");
		StringBuffer sb = new StringBuffer(ccsId);
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(referenceDate);
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		
		sb.append("_"+df.format(dayOfMonth));
		sb.append("_"+energyComponentId.getEnergyId());
		sb.append("_"+df.format(integrationPeriod));
		
		return sb.toString();
	}
	
	private String makeKey(LoadCurvesState loadCurvesState) {
		return makeKey(loadCurvesState.getReferenceDate(), loadCurvesState.getEnergyComponentId(), loadCurvesState.getIntegrationPeriod());
	}

	public void setState(Date referenceDate, EnergyComponentId energyComponentId, int integrationPeriod, StateAcqLoadCurve state) {
		ArgumentsCheckerUtil.checkNull(state);
		String key = makeKey(referenceDate, energyComponentId, integrationPeriod);
		
		LoadCurvesState loadCurvesState = (LoadCurvesState)mapStates.get(key);
		if(loadCurvesState == null) {
			loadCurvesState = new LoadCurvesState();
			loadCurvesState.setCcsId(ccsId);
			loadCurvesState.setReferenceDate(referenceDate);
			loadCurvesState.setEnergyComponentId(energyComponentId);
			loadCurvesState.setIntegrationPeriod(integrationPeriod);
			loadCurvesState.setState(state);
		} else {
			loadCurvesState.setReferenceDate(referenceDate);
			loadCurvesState.setState(state);
		}
		mapStates.put(key, loadCurvesState);
	}
	
	public StateAcqLoadCurve getState(Date referenceDate, EnergyComponentId energyComponentId, int integrationPeriod) {
		String key = makeKey(referenceDate, energyComponentId, integrationPeriod);
		
		LoadCurvesState loadCurvesState = (LoadCurvesState)mapStates.get(key);
		
		return loadCurvesState!=null ? loadCurvesState.getState() : null;
	}
	
	public LoadCurvesState getLoadCurvesStateInstance(Date referenceDate, EnergyComponentId energyComponentId, int integrationPeriod) {
		
		String key = makeKey(referenceDate, energyComponentId, integrationPeriod);
		
		return (LoadCurvesState)mapStates.get(key);
	}

    public void setLoadCurvesStateInstance(LoadCurvesState loadCurvesState) {
    	ArgumentsCheckerUtil.checkNull(loadCurvesState);
		
		String key = makeKey(loadCurvesState);
		
		mapStates.put(key,loadCurvesState);
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ccsId == null) ? 0 : ccsId.hashCode());
		result = prime * result
				+ ((mapStates == null) ? 0 : mapStates.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final LoadCurvesCcsState other = (LoadCurvesCcsState) obj;
		if (ccsId == null) {
			if (other.ccsId != null)
				return false;
		} else if (!ccsId.equals(other.ccsId))
			return false;
		if (mapStates == null) {
			if (other.mapStates != null)
				return false;
		} else if (!mapStates.equals(other.mapStates))
			return false;
		return true;
	}
    
    
}
