package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.mgre.enumeration.Provenienza;
import com.ericsson.urm.persistence.dto.mgre.datatype.PeriodoCurve;
import com.ericsson.urm.util.ArgumentsCheckerUtil;

public class StatoCampioneCdc implements Serializable {
	private static final long serialVersionUID = -1;
	
	private StatoCampioneCdcId id=null;	         
	private Integer	periodoIntegrazione=null;	 
	private String 	periodoAcquisizione=null;
	private Date dataAcquisizione=null;
	private String componentState=null;
	private String provenienza;
	
	public StatoCampioneCdc() {}
	
	public StatoCampioneCdc(StatoCampioneCdcId id, PeriodoCurve periodoCurve, Date dataAcquisizione, String componentState) {
		
		this(id, periodoCurve, dataAcquisizione, componentState, null);
	}

	public StatoCampioneCdc(StatoCampioneCdcId id, PeriodoCurve periodoCurve, Date dataAcquisizione, String componentState, Provenienza provenienza) {
		
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
		
		this.componentState = componentState;
		
		this.provenienza = provenienza!=null  ? provenienza.getProvenienza() : null;
	}
	
	
	public StatoCampioneCdcId getId() {
		return id;
	}
	public void setId(StatoCampioneCdcId id) {
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
	
	public String getComponentState() {
		return componentState;
	}

	public void setComponentState(String componentState) {
		this.componentState = componentState;
	}

	public Provenienza getProvenienza() {
		return Provenienza.parse(provenienza);
	}

	public void setProvenienza(Provenienza provenienza) {
		this.provenienza = provenienza != null ? provenienza.getProvenienza() : null;
	}

	
	
	
}
