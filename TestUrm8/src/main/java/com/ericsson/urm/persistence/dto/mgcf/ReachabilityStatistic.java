package com.ericsson.urm.persistence.dto.mgcf;

import java.io.Serializable;

public class ReachabilityStatistic implements Serializable {
	private static final long serialVersionUID = 1L;


	private long ncurr = 0;
	private long nfail = 0;
	
	public ReachabilityStatistic(){}

	public long getncurr() {
		return ncurr;
	}

	public void setncurr(long ncurr) {
		this.ncurr = ncurr;
	}

	public long getnfail() {
		return nfail;
	}

	public void setnfail(long nFail) {
		this.nfail = nFail;
	}

	@Override
	public String toString() {
		return "ReachabilityStatistic [nCurr=" + ncurr + ", nFail=" + nfail + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (ncurr ^ (ncurr >>> 32));
		result = prime * result + (int) (nfail ^ (nfail >>> 32));
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
		ReachabilityStatistic other = (ReachabilityStatistic) obj;
		if (ncurr != other.ncurr)
			return false;
		if (nfail != other.nfail)
			return false;
		return true;
	}
	
}