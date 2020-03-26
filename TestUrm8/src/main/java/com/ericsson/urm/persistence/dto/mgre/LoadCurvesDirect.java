package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.persistence.dto.mgre.datatype.PeriodoCurve;
import com.ericsson.urm.util.ArgumentsCheckerUtil;

public class LoadCurvesDirect implements Serializable {
	private static final long serialVersionUID = -1;
	
	private LoadCurvesDirectId id=null;	         
	private Integer	periodoIntegrazione=null;	 
	private String 	periodoAcquisizione=null;
	private Date dataAcquisizione=null;
	private Long componentValue=null;
	
	public LoadCurvesDirect() {}

	public LoadCurvesDirect(LoadCurvesDirectId id, PeriodoCurve periodoCurve, Date dataAcquisizione,Long componentValue) {
		
		this.id = id;
		
		if(periodoCurve!=null) {
			this.periodoIntegrazione = new Integer(periodoCurve.getValue());
			this.periodoAcquisizione = periodoCurve.toString();
		} 
		else {
			this.periodoIntegrazione = null;
			this.periodoAcquisizione = null;
		}
		
		this.dataAcquisizione = dataAcquisizione;
		
		this.componentValue = componentValue;
	}
	
	
	public LoadCurvesDirectId getId() {
		return id;
	}
	public void setId(LoadCurvesDirectId id) {
		this.id = id;
	}
	
	public PeriodoCurve getPeriodoIntegrazione() {
		PeriodoCurve ret= null;
		if(periodoIntegrazione!=null){
			ret=PeriodoCurve.parse(periodoIntegrazione.intValue());
		}
		return ret;
	}
	public void setPeriodoIntegrazione(PeriodoCurve periodoCurve) {
		if(periodoCurve!=null){
			periodoIntegrazione=new Integer(periodoCurve.getValue());
		}else{
			periodoIntegrazione=null;
		}
	}
	public PeriodoCurve getPeriodoAcquisizione() {
		PeriodoCurve ret=null;
		if(periodoAcquisizione!=null){
			ret=PeriodoCurve.parse(periodoAcquisizione);
		}
		return ret;
	}
	public void setPeriodoAcquisizione(PeriodoCurve periodoCurve) {
		ArgumentsCheckerUtil.checkNull(periodoCurve, "periodoCurve");
		
		this.periodoAcquisizione = periodoCurve.toString();
	}
	public Date getDataAcquisizione() {
		return dataAcquisizione;
	}
	public void setDataAcquisizione(Date dataAcquisizione) {
		this.dataAcquisizione = dataAcquisizione;
	}
	
	public Long getComponentValue() {
		return componentValue;
	}

	public void setComponentValue(Long componentValue) {
		this.componentValue = componentValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((componentValue == null) ? 0 : componentValue.hashCode());
		result = prime
				* result
				+ ((dataAcquisizione == null) ? 0 : dataAcquisizione.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((periodoAcquisizione == null) ? 0 : periodoAcquisizione
						.hashCode());
		result = prime
				* result
				+ ((periodoIntegrazione == null) ? 0 : periodoIntegrazione
						.hashCode());
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
		LoadCurvesDirect other = (LoadCurvesDirect) obj;
		if (componentValue == null) {
			if (other.componentValue != null)
				return false;
		} else if (!componentValue.equals(other.componentValue))
			return false;
		if (dataAcquisizione == null) {
			if (other.dataAcquisizione != null)
				return false;
		} else if (!dataAcquisizione.equals(other.dataAcquisizione))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (periodoAcquisizione == null) {
			if (other.periodoAcquisizione != null)
				return false;
		} else if (!periodoAcquisizione.equals(other.periodoAcquisizione))
			return false;
		if (periodoIntegrazione == null) {
			if (other.periodoIntegrazione != null)
				return false;
		} else if (!periodoIntegrazione.equals(other.periodoIntegrazione))
			return false;
		return true;
	}
	
}
