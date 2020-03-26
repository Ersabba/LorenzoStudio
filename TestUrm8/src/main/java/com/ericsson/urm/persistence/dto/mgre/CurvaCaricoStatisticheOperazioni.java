package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

public class CurvaCaricoStatisticheOperazioni implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Date dataAcq;
	private Long numLenntWfm;
	private Long numLenntOp;
	private Long numLenntExt;
	private Long numComandiBtWfm;
	private Long numComandiBtop;
	private Long numComandiBtExt;
	private Long numSuccessiWfm;
	private Long numSuccessiOp;
	private Long numSuccessiExt;
	
	
	public Date getDataAcq() {
		return dataAcq;
	}
	public void setDataAcq(Date dataAcq) {
		this.dataAcq = dataAcq;
	}
	public Long getNumLenntWfm() {
		return numLenntWfm;
	}
	public void setNumLenntWfm(Long numLenntWfm) {
		this.numLenntWfm = numLenntWfm;
	}
	public Long getNumLenntOp() {
		return numLenntOp;
	}
	public void setNumLenntOp(Long numLenntOp) {
		this.numLenntOp = numLenntOp;
	}
	public Long getNumLenntExt() {
		return numLenntExt;
	}
	public void setNumLenntExt(Long numLenntExt) {
		this.numLenntExt = numLenntExt;
	}
	public Long getNumComandiBtWfm() {
		return numComandiBtWfm;
	}
	public void setNumComandiBtWfm(Long numComandiBtWfm) {
		this.numComandiBtWfm = numComandiBtWfm;
	}
	public Long getNumComandiBtop() {
		return numComandiBtop;
	}
	public void setNumComandiBtop(Long numComandiBtop) {
		this.numComandiBtop = numComandiBtop;
	}
	public Long getNumComandiBtExt() {
		return numComandiBtExt;
	}
	public void setNumComandiBtExt(Long numComandiBtExt) {
		this.numComandiBtExt = numComandiBtExt;
	}
	public Long getNumSuccessiWfm() {
		return numSuccessiWfm;
	}
	public void setNumSuccessiWfm(Long numSuccessiWfm) {
		this.numSuccessiWfm = numSuccessiWfm;
	}
	public Long getNumSuccessiOp() {
		return numSuccessiOp;
	}
	public void setNumSuccessiOp(Long numSuccessiOp) {
		this.numSuccessiOp = numSuccessiOp;
	}
	public Long getNumSuccessiExt() {
		return numSuccessiExt;
	}
	public void setNumSuccessiExt(Long numSuccessiExt) {
		this.numSuccessiExt = numSuccessiExt;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAcq == null) ? 0 : dataAcq.hashCode());
		result = prime * result + ((numComandiBtExt == null) ? 0 : numComandiBtExt.hashCode());
		result = prime * result + ((numComandiBtWfm == null) ? 0 : numComandiBtWfm.hashCode());
		result = prime * result + ((numComandiBtop == null) ? 0 : numComandiBtop.hashCode());
		result = prime * result + ((numLenntExt == null) ? 0 : numLenntExt.hashCode());
		result = prime * result + ((numLenntOp == null) ? 0 : numLenntOp.hashCode());
		result = prime * result + ((numLenntWfm == null) ? 0 : numLenntWfm.hashCode());
		result = prime * result + ((numSuccessiExt == null) ? 0 : numSuccessiExt.hashCode());
		result = prime * result + ((numSuccessiOp == null) ? 0 : numSuccessiOp.hashCode());
		result = prime * result + ((numSuccessiWfm == null) ? 0 : numSuccessiWfm.hashCode());
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
		CurvaCaricoStatisticheOperazioni other = (CurvaCaricoStatisticheOperazioni) obj;
		if (dataAcq == null) {
			if (other.dataAcq != null)
				return false;
		} else if (!dataAcq.equals(other.dataAcq))
			return false;
		if (numComandiBtExt == null) {
			if (other.numComandiBtExt != null)
				return false;
		} else if (!numComandiBtExt.equals(other.numComandiBtExt))
			return false;
		if (numComandiBtWfm == null) {
			if (other.numComandiBtWfm != null)
				return false;
		} else if (!numComandiBtWfm.equals(other.numComandiBtWfm))
			return false;
		if (numComandiBtop == null) {
			if (other.numComandiBtop != null)
				return false;
		} else if (!numComandiBtop.equals(other.numComandiBtop))
			return false;
		if (numLenntExt == null) {
			if (other.numLenntExt != null)
				return false;
		} else if (!numLenntExt.equals(other.numLenntExt))
			return false;
		if (numLenntOp == null) {
			if (other.numLenntOp != null)
				return false;
		} else if (!numLenntOp.equals(other.numLenntOp))
			return false;
		if (numLenntWfm == null) {
			if (other.numLenntWfm != null)
				return false;
		} else if (!numLenntWfm.equals(other.numLenntWfm))
			return false;
		if (numSuccessiExt == null) {
			if (other.numSuccessiExt != null)
				return false;
		} else if (!numSuccessiExt.equals(other.numSuccessiExt))
			return false;
		if (numSuccessiOp == null) {
			if (other.numSuccessiOp != null)
				return false;
		} else if (!numSuccessiOp.equals(other.numSuccessiOp))
			return false;
		if (numSuccessiWfm == null) {
			if (other.numSuccessiWfm != null)
				return false;
		} else if (!numSuccessiWfm.equals(other.numSuccessiWfm))
			return false;
		return true;
	}
}
