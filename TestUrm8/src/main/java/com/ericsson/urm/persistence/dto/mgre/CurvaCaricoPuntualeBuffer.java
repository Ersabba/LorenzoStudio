package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.persistence.dto.mgre.datatype.PeriodoCurve;


public class CurvaCaricoPuntualeBuffer implements Serializable {

	private static final long			serialVersionUID	= 1L;

	private CurvaCaricoPuntualeBufferId	id					= null;
	private Integer						periodoIntegrazione	= null;
	private String						periodoAcquisizione	= null;
	private Date						dataAcquisizione	= null;
	private Long						componentValue		= null;

	public CurvaCaricoPuntualeBuffer() {
	}

	public CurvaCaricoPuntualeBuffer(CurvaCaricoPuntualeBufferId id, PeriodoCurve periodoCurve, Date dataAcquisizione, Long componentValue) {

		this.id = id;

		if (periodoCurve != null) {
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

	public CurvaCaricoPuntualeBufferId getId() {
		return id;
	}

	public void setId(CurvaCaricoPuntualeBufferId id) {
		this.id = id;
	}

	public PeriodoCurve getPeriodoIntegrazione() {
		PeriodoCurve ret = null;
		if (periodoIntegrazione != null) {
			ret = PeriodoCurve.parse(periodoIntegrazione.intValue());
		}
		return ret;
	}

	public void setPeriodoIntegrazione(PeriodoCurve periodoCurve) {
		if (periodoCurve != null) {
			periodoIntegrazione = new Integer(periodoCurve.getValue());
		}
		else {
			periodoIntegrazione = null;
		}
	}

	public PeriodoCurve getPeriodoAcquisizione() {
		PeriodoCurve ret = null;
		if (periodoAcquisizione != null) {
			ret = PeriodoCurve.parse(periodoAcquisizione);
		}
		return ret;
	}

	public void setPeriodoAcquisizione(PeriodoCurve periodoCurve) {
		if (periodoCurve == null)
			throw new IllegalArgumentException("Missing parameter");
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
}
