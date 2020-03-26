package com.ericsson.mgre.datatypes;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;

import com.ericsson.communication.datatype.SourceRequestType;
import com.ericsson.urm.util.DateUtil;

public class LoadCurvesExtraParams implements Serializable {
	
	public static enum LoadCurvesExtraParamsKeys{
		FROM, TO, DAYS_BACK_MIN, DAYS_BACK_MAX, COMPONENTS, PMIN, PMAX, DELAY_PLC, MOBILE_WINDOW, COMPONENT;
	}

	private static final long serialVersionUID = 1L;
	
	private Date from = null;
	private Date to = null;
	private String daysBackMin = null;
	private String daysBackMax = null;
	private LinkedHashSet<Componente> energyComponents = new LinkedHashSet<Componente>();
	private Componente component = null;
	private String pMin = null;
	private String pMax = null;
	private SourceRequestType source = null;
	private int index;
	private Boolean mobileWindow;
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		if (from != null)
			sb.append(new SimpleDateFormat("dd/MM/yyyy").format(from));
		else
			sb.append("null");
		sb.append(" - ");
		if (to != null)
			sb.append(new SimpleDateFormat("dd/MM/yyyy").format(to));
		else
			sb.append("null");
		sb.append("], ");
		sb.append(daysBackMin + " - " + daysBackMax + ", ");
		sb.append(energyComponents + ", ");
		sb.append(component + ", ");
		sb.append(mobileWindow==null?"":mobileWindow + ", ");
		sb.append(pMin + "% - " + pMax + "%");
		return sb.toString();
	}
	
	public LoadCurvesExtraParams() {
		super();
	}

	public LoadCurvesExtraParams(Date from, Date to, String daysBackMin, String daysBackMax, 
	                             LinkedHashSet<Componente> energyComponents, String pMin, String pMax,
	                             SourceRequestType source, int index) {
		super();
		this.from = DateUtil.azzeraHHMMSS(from);
		this.to = DateUtil.azzeraHHMMSS(to);
		this.daysBackMin = daysBackMin;
		this.daysBackMax = daysBackMax;
		this.energyComponents = energyComponents;
		this.pMin = pMin;
		this.pMax = pMax;
		this.source = source;
		this.index = index;
	}

	public LoadCurvesExtraParams(Date from, Date to, String daysBackMin, String daysBackMax, 
	                             LinkedHashSet<Componente> energyComponents, String pMin, String pMax,
	                             SourceRequestType source, int index, Boolean mobileWindow) {
		super();
		this.from = DateUtil.azzeraHHMMSS(from);
		this.to = DateUtil.azzeraHHMMSS(to);
		this.daysBackMin = daysBackMin;
		this.daysBackMax = daysBackMax;
		this.energyComponents = energyComponents;
		this.pMin = pMin;
		this.pMax = pMax;
		this.source = source;
		this.index = index;
		this.mobileWindow = mobileWindow;
	}

	public LoadCurvesExtraParams(Date from, Date to, String daysBackMin, String daysBackMax, 
	                             LinkedHashSet<Componente> energyComponents, Componente component, String pMin, String pMax,
	                             SourceRequestType source, int index, Boolean mobileWindow) {
		super();
		this.from = DateUtil.azzeraHHMMSS(from);
		this.to = DateUtil.azzeraHHMMSS(to);
		this.daysBackMin = daysBackMin;
		this.daysBackMax = daysBackMax;
		this.energyComponents = energyComponents;
		this.component = component;
		this.pMin = pMin;
		this.pMax = pMax;
		this.source = source;
		this.mobileWindow = mobileWindow;
	}

	public LoadCurvesExtraParams(Date from, Date to, String daysBackMin, String daysBackMax, 
	                             Componente component, String pMin, String pMax,
	                             SourceRequestType source, int index, Boolean mobileWindow) {
		super();
		this.from = DateUtil.azzeraHHMMSS(from);
		this.to = DateUtil.azzeraHHMMSS(to);
		this.daysBackMin = daysBackMin;
		this.daysBackMax = daysBackMax;
		this.component = component;
		this.pMin = pMin;
		this.pMax = pMax;
		this.source = source;
		this.mobileWindow = mobileWindow;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = DateUtil.azzeraHHMMSS(from);
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = DateUtil.azzeraHHMMSS(to);
	}

	public String getDaysBackMin() {
		return daysBackMin;
	}

	public void setDaysBackMin(String daysBackMin) {
		this.daysBackMin = daysBackMin;
	}

	public String getDaysBackMax() {
		return daysBackMax;
	}

	public void setDaysBackMax(String daysBackMax) {
		this.daysBackMax = daysBackMax;
	}

	public LinkedHashSet<Componente> getEnergyComponents() {
		return energyComponents;
	}

	public void setEnergyComponents(LinkedHashSet<Componente> energyComponents) {
		this.energyComponents = energyComponents;
	}

	public Componente getComponent() {
		return component;
	}

	public void setComponent(Componente component) {
		this.component = component;
	}

	public String getpMin() {
		return pMin;
	}

	public void setpMin(String pMin) {
		this.pMin = pMin;
	}

	public String getpMax() {
		return pMax;
	}

	public void setpMax(String pMax) {
		this.pMax = pMax;
	}

	public SourceRequestType getSource() {
		return source;
	}

	public void setSource(SourceRequestType source) {
		this.source = source;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Boolean getMobileWindow() {
		return mobileWindow;
	}

	public void setMobileWindow(Boolean mobileWindow) {
		this.mobileWindow = mobileWindow;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((component == null) ? 0 : component.hashCode());
		result = prime * result
				+ ((daysBackMax == null) ? 0 : daysBackMax.hashCode());
		result = prime * result
				+ ((daysBackMin == null) ? 0 : daysBackMin.hashCode());
		result = prime
				* result
				+ ((energyComponents == null) ? 0 : energyComponents.hashCode());
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + index;
		result = prime * result
				+ ((mobileWindow == null) ? 0 : mobileWindow.hashCode());
		result = prime * result + ((pMax == null) ? 0 : pMax.hashCode());
		result = prime * result + ((pMin == null) ? 0 : pMin.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoadCurvesExtraParams other = (LoadCurvesExtraParams) obj;
		if (component != other.component)
			return false;
		if (daysBackMax == null) {
			if (other.daysBackMax != null)
				return false;
		} else if (!daysBackMax.equals(other.daysBackMax))
			return false;
		if (daysBackMin == null) {
			if (other.daysBackMin != null)
				return false;
		} else if (!daysBackMin.equals(other.daysBackMin))
			return false;
		if (energyComponents == null) {
			if (other.energyComponents != null)
				return false;
		} else if (!energyComponents.equals(other.energyComponents))
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (index != other.index)
			return false;
		if (mobileWindow == null) {
			if (other.mobileWindow != null)
				return false;
		} else if (!mobileWindow.equals(other.mobileWindow))
			return false;
		if (pMax == null) {
			if (other.pMax != null)
				return false;
		} else if (!pMax.equals(other.pMax))
			return false;
		if (pMin == null) {
			if (other.pMin != null)
				return false;
		} else if (!pMin.equals(other.pMin))
			return false;
		if (source != other.source)
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}
	
	
}