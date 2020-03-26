package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.db.MgdbDto;
import com.ericsson.urm.persistence.dto.mgre.datatype.PeriodoCurve;
import com.ericsson.urm.util.ArgumentsCheckerUtil;

public class CurvaDiCarico implements Serializable, MgdbDto {
	private static final long serialVersionUID = -1;
	
	private CurvaDiCaricoId id;
	
	private Long attAss;	               
	private Long reattIndAss;	         
	private Long reattCapAss;	         
	private Long attEr;	               
	private Long reattIndEr;	         
	private Long reattCapEr;	         
	private Integer	periodoIntegrazione;	 
	private String 	periodoAcquisizione;
	private Date dataAcquisizione=null;
	
	public CurvaDiCarico() {
		
	}

	public Object clone() {
		try {
			CurvaDiCarico ret = (CurvaDiCarico) super.clone();
			if (id != null)
				ret.id = (CurvaDiCaricoId) id.clone();
			if (dataAcquisizione != null)
				ret.dataAcquisizione = (Date) dataAcquisizione.clone();
			return ret;
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	public void applyAllProperties(MgdbDto srcDto) {
		CurvaDiCarico other = (CurvaDiCarico)srcDto;
		if (other.id != null)
			this.id = (CurvaDiCaricoId)other.id.clone();
		else
			this.id = null;
		this.attAss = other.attAss;
		this.reattIndAss = other.reattIndAss;
		this.reattCapAss = other.reattCapAss;
		this.attEr = other.attEr;
		this.reattIndEr = other.reattIndEr;
		this.reattCapEr = other.reattCapEr;
		this.periodoIntegrazione = other.periodoIntegrazione;
		this.periodoAcquisizione = other.periodoAcquisizione;
		this.dataAcquisizione = other.dataAcquisizione;
	}
	
	public Serializable retrievePrimaryKey() {
		return getId();
	}

	public CurvaDiCaricoId getId() {
		return id;
	}



	public void setId(CurvaDiCaricoId id) {
		this.id = id;
	}



	public Long getAttAss() {
		return attAss;
	}

	public void setAttAss(Long attAss) {
		this.attAss = attAss;
	}

	public Long getReattIndAss() {
		return reattIndAss;
	}

	public void setReattIndAss(Long reattIndAss) {
		this.reattIndAss = reattIndAss;
	}

	public Long getReattCapAss() {
		return reattCapAss;
	}

	public void setReattCapAss(Long reattCapAss) {
		this.reattCapAss = reattCapAss;
	}

	public Long getAttEr() {
		return attEr;
	}

	public void setAttEr(Long attEr) {
		this.attEr = attEr;
	}

	public Long getReattIndEr() {
		return reattIndEr;
	}

	public void setReattIndEr(Long reattIndEr) {
		this.reattIndEr = reattIndEr;
	}

	public Long getReattCapEr() {
		return reattCapEr;
	}

	public void setReattCapEr(Long reattCapEr) {
		this.reattCapEr = reattCapEr;
	}

	public PeriodoCurve getPeriodoIntegrazione() {
		PeriodoCurve ret= null;
		if(periodoIntegrazione!=null){
			ret=PeriodoCurve.parse(periodoIntegrazione.intValue());
		}
		return ret;
	}

	public void setPeriodoIntegrazione(PeriodoCurve periodoCurve) {
		if(periodoCurve==null){
			periodoIntegrazione=null;
		}else{
			periodoIntegrazione=new Integer(periodoCurve.getValue());
		}
		
	}
	
	public Integer getPeriodoIntegrazioneInteger() {
		return periodoIntegrazione;
	}

	public void setPeriodoIntegrazioneInteger(Integer periodoCurve) {
		periodoIntegrazione=periodoCurve;
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

	public String getPeriodoAcquisizioneString() {
		return this.periodoAcquisizione;
	}

	public void setPeriodoAcquisizioneString(String periodoCurve) {
		ArgumentsCheckerUtil.checkNull(periodoCurve, "periodoCurve");
		
		this.periodoAcquisizione = periodoCurve;
	}


	public Date getDataAcquisizione() {
		return dataAcquisizione;
	}



	public void setDataAcquisizione(Date dataAcquisizione) {
		this.dataAcquisizione = dataAcquisizione;
	}


	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attAss == null) ? 0 : attAss.hashCode());
		result = prime * result + ((attEr == null) ? 0 : attEr.hashCode());
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
		result = prime * result
				+ ((reattCapAss == null) ? 0 : reattCapAss.hashCode());
		result = prime * result
				+ ((reattCapEr == null) ? 0 : reattCapEr.hashCode());
		result = prime * result
				+ ((reattIndAss == null) ? 0 : reattIndAss.hashCode());
		result = prime * result
				+ ((reattIndEr == null) ? 0 : reattIndEr.hashCode());
		return result;
	}



	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final CurvaDiCarico other = (CurvaDiCarico) obj;
		if (attAss == null) {
			if (other.attAss != null)
				return false;
		} else if (!attAss.equals(other.attAss))
			return false;
		if (attEr == null) {
			if (other.attEr != null)
				return false;
		} else if (!attEr.equals(other.attEr))
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
		if (reattCapAss == null) {
			if (other.reattCapAss != null)
				return false;
		} else if (!reattCapAss.equals(other.reattCapAss))
			return false;
		if (reattCapEr == null) {
			if (other.reattCapEr != null)
				return false;
		} else if (!reattCapEr.equals(other.reattCapEr))
			return false;
		if (reattIndAss == null) {
			if (other.reattIndAss != null)
				return false;
		} else if (!reattIndAss.equals(other.reattIndAss))
			return false;
		if (reattIndEr == null) {
			if (other.reattIndEr != null)
				return false;
		} else if (!reattIndEr.equals(other.reattIndEr))
			return false;
		return true;
	}

	public String toString() {
		return "CurvaDiCarico [attAss=" + attAss + ", attEr=" + attEr
				+ ", dataAcquisizione=" + dataAcquisizione + ", id=" + id
				+ ", periodoAcquisizione=" + periodoAcquisizione
				+ ", periodoIntegrazione=" + periodoIntegrazione
				+ ", reattCapAss=" + reattCapAss + ", reattCapEr=" + reattCapEr
				+ ", reattIndAss=" + reattIndAss + ", reattIndEr=" + reattIndEr
				+ "]";
	}
    
}
