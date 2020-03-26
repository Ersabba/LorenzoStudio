package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

public class QdsTensioneMaxMinWeek implements Serializable {
	private static final long serialVersionUID = -1;
	
	private QdsTensioneMaxMinWeekId id;
	
	private String matricolaCcs = null;
	private Date weekAcq=null;
	private Integer	tensioneMaxR;
	private Integer	tensioneMaxS;
	private Integer	tensioneMaxT;
	private Integer	tensioneMinR;
	private Integer	tensioneMinS;
	private Integer	tensioneMinT;
	private Integer	durataFuoriRange;
	private Integer	intRange;
	private Integer	intInf;
	private Integer	week;
	private String tipoContatore = null;
	private Date dataAcq=null;
		
	public QdsTensioneMaxMinWeek() {
		
	}		
		
	public QdsTensioneMaxMinWeek(QdsTensioneMaxMinWeekId id, String matricolaCcs, Date weekAcq, Integer tensioneMaxR, Integer tensioneMaxS, 
			                     Integer tensioneMaxT, Integer tensioneMinR, Integer tensioneMinS, Integer tensioneMinT, Integer durataFuoriRange, 
			                     Integer intRange, Integer intInf, Integer week, String tipoContatore, Date dataAcq) {
		super();
		this.id = id;
		this.matricolaCcs = matricolaCcs;
		this.weekAcq = weekAcq;
		this.tensioneMaxR = tensioneMaxR;
		this.tensioneMaxS = tensioneMaxS;
		this.tensioneMaxT = tensioneMaxT;
		this.tensioneMinR = tensioneMinR;
		this.tensioneMinS = tensioneMinS;
		this.tensioneMinT = tensioneMinT;
		this.durataFuoriRange = durataFuoriRange;
		this.intRange = intRange;
		this.intInf = intInf;
		this.week = week;
		this.tipoContatore = tipoContatore;
		this.dataAcq = dataAcq;
	}

	public QdsTensioneMaxMinWeekId getId() {
		return id;
	}

	public void setId(QdsTensioneMaxMinWeekId id) {
		this.id = id;
	}

	public String getMatricolaCcs() {
		return matricolaCcs;
	}

	public void setMatricolaCcs(String matricolaCcs) {
		this.matricolaCcs = matricolaCcs;
	}

	public Date getWeekAcq() {
		return weekAcq;
	}

	public void setWeekAcq(Date weekAcq) {
		this.weekAcq = weekAcq;
	}

	public Integer getTensioneMaxR() {
		return tensioneMaxR;
	}

	public void setTensioneMaxR(Integer tensioneMaxR) {
		this.tensioneMaxR = tensioneMaxR;
	}

	public Integer getTensioneMaxS() {
		return tensioneMaxS;
	}

	public void setTensioneMaxS(Integer tensioneMaxS) {
		this.tensioneMaxS = tensioneMaxS;
	}

	public Integer getTensioneMaxT() {
		return tensioneMaxT;
	}

	public void setTensioneMaxT(Integer tensioneMaxT) {
		this.tensioneMaxT = tensioneMaxT;
	}

	public Integer getTensioneMinR() {
		return tensioneMinR;
	}

	public void setTensioneMinR(Integer tensioneMinR) {
		this.tensioneMinR = tensioneMinR;
	}

	public Integer getTensioneMinS() {
		return tensioneMinS;
	}

	public void setTensioneMinS(Integer tensioneMinS) {
		this.tensioneMinS = tensioneMinS;
	}

	public Integer getTensioneMinT() {
		return tensioneMinT;
	}

	public void setTensioneMinT(Integer tensioneMinT) {
		this.tensioneMinT = tensioneMinT;
	}

	public Integer getDurataFuoriRange() {
		return durataFuoriRange;
	}

	public void setDurataFuoriRange(Integer durataFuoriRange) {
		this.durataFuoriRange = durataFuoriRange;
	}

	public Integer getIntRange() {
		return intRange;
	}

	public void setIntRange(Integer intRange) {
		this.intRange = intRange;
	}

	public Integer getIntInf() {
		return intInf;
	}

	public void setIntInf(Integer intInf) {
		this.intInf = intInf;
	}

	public Integer getWeek() {
		return week;
	}

	public void setWeek(Integer week) {
		this.week = week;
	}

	public String getTipoContatore() {
		return tipoContatore;
	}

	public void setTipoContatore(String tipoContatore) {
		this.tipoContatore = tipoContatore;
	}
	
	public Date getDataAcq() {
		return dataAcq;
	}

	public void setDataAcq(Date dataAcq) {
		this.dataAcq = dataAcq;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAcq == null) ? 0 : dataAcq.hashCode());
		result = prime * result + ((durataFuoriRange == null) ? 0 : durataFuoriRange.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((intInf == null) ? 0 : intInf.hashCode());
		result = prime * result + ((intRange == null) ? 0 : intRange.hashCode());
		result = prime * result + ((matricolaCcs == null) ? 0 : matricolaCcs.hashCode());
		result = prime * result + ((tensioneMaxR == null) ? 0 : tensioneMaxR.hashCode());
		result = prime * result + ((tensioneMaxS == null) ? 0 : tensioneMaxS.hashCode());
		result = prime * result + ((tensioneMaxT == null) ? 0 : tensioneMaxT.hashCode());
		result = prime * result + ((tensioneMinR == null) ? 0 : tensioneMinR.hashCode());
		result = prime * result + ((tensioneMinS == null) ? 0 : tensioneMinS.hashCode());
		result = prime * result + ((tensioneMinT == null) ? 0 : tensioneMinT.hashCode());
		result = prime * result + ((tipoContatore == null) ? 0 : tipoContatore.hashCode());
		result = prime * result + ((week == null) ? 0 : week.hashCode());
		result = prime * result + ((weekAcq == null) ? 0 : weekAcq.hashCode());
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
		QdsTensioneMaxMinWeek other = (QdsTensioneMaxMinWeek) obj;
		if (dataAcq == null) {
			if (other.dataAcq != null)
				return false;
		} else if (!dataAcq.equals(other.dataAcq))
			return false;
		if (durataFuoriRange == null) {
			if (other.durataFuoriRange != null)
				return false;
		} else if (!durataFuoriRange.equals(other.durataFuoriRange))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (intInf == null) {
			if (other.intInf != null)
				return false;
		} else if (!intInf.equals(other.intInf))
			return false;
		if (intRange == null) {
			if (other.intRange != null)
				return false;
		} else if (!intRange.equals(other.intRange))
			return false;
		if (matricolaCcs == null) {
			if (other.matricolaCcs != null)
				return false;
		} else if (!matricolaCcs.equals(other.matricolaCcs))
			return false;
		if (tensioneMaxR == null) {
			if (other.tensioneMaxR != null)
				return false;
		} else if (!tensioneMaxR.equals(other.tensioneMaxR))
			return false;
		if (tensioneMaxS == null) {
			if (other.tensioneMaxS != null)
				return false;
		} else if (!tensioneMaxS.equals(other.tensioneMaxS))
			return false;
		if (tensioneMaxT == null) {
			if (other.tensioneMaxT != null)
				return false;
		} else if (!tensioneMaxT.equals(other.tensioneMaxT))
			return false;
		if (tensioneMinR == null) {
			if (other.tensioneMinR != null)
				return false;
		} else if (!tensioneMinR.equals(other.tensioneMinR))
			return false;
		if (tensioneMinS == null) {
			if (other.tensioneMinS != null)
				return false;
		} else if (!tensioneMinS.equals(other.tensioneMinS))
			return false;
		if (tensioneMinT == null) {
			if (other.tensioneMinT != null)
				return false;
		} else if (!tensioneMinT.equals(other.tensioneMinT))
			return false;
		if (tipoContatore == null) {
			if (other.tipoContatore != null)
				return false;
		} else if (!tipoContatore.equals(other.tipoContatore))
			return false;
		if (week == null) {
			if (other.week != null)
				return false;
		} else if (!week.equals(other.week))
			return false;
		if (weekAcq == null) {
			if (other.weekAcq != null)
				return false;
		} else if (!weekAcq.equals(other.weekAcq))
			return false;
		return true;
	}
	
}
