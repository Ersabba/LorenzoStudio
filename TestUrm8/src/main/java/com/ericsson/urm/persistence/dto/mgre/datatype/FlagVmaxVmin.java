package com.ericsson.urm.persistence.dto.mgre.datatype;

import java.io.Serializable;

public class FlagVmaxVmin implements Serializable {
	private static final long serialVersionUID = -1;
	public final static FlagVmaxVmin VMX = new FlagVmaxVmin("VMX");
	public final static FlagVmaxVmin VMN = new FlagVmaxVmin("VMN");

	private String flagVmaxVmin;

	private FlagVmaxVmin(String flagVmaxVmin) {
		this.flagVmaxVmin = flagVmaxVmin;
	}

	public static FlagVmaxVmin parse(String flagVmaxVmin) {
		if (flagVmaxVmin == null || flagVmaxVmin.length() == 0)
			return null;
		
		if (VMX.flagVmaxVmin.equalsIgnoreCase(flagVmaxVmin))
			return VMX;
		if (VMN.flagVmaxVmin.equalsIgnoreCase(flagVmaxVmin))
			return VMN;

		throw new IllegalArgumentException("Unsupported flagVmaxVmin: " + flagVmaxVmin);
	}


	public String toString() {
		return flagVmaxVmin;
	}

	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((flagVmaxVmin == null) ? 0 : flagVmaxVmin.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlagVmaxVmin other = (FlagVmaxVmin) obj;
		if (flagVmaxVmin == null) {
			if (other.flagVmaxVmin != null)
				return false;
		} else if (!flagVmaxVmin.equals(other.flagVmaxVmin))
			return false;
		return true;
	}

	
}
