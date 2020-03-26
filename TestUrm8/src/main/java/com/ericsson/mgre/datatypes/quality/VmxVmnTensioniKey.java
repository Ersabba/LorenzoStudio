package com.ericsson.mgre.datatypes.quality;

import java.io.Serializable;
import java.util.Date;

public class VmxVmnTensioniKey implements Serializable {
	
	private String matrLennt;
	private Date dataRil;
	
	public VmxVmnTensioniKey() {
		super();
	}
	
	public VmxVmnTensioniKey(String m, Date d) {
		this.matrLennt = m;
		this.dataRil = d;
	}
	
	public String getMatrLennt() {
		return matrLennt;
	}
	public void setMatrLennt(String matrLennt) {
		this.matrLennt = matrLennt;
	}
	public Date getDataRil() {
		return dataRil;
	}
	public void setDataRil(Date dataRil) {
		this.dataRil = dataRil;
	}
	
	public String toString() {
		return "[" + matrLennt + " - " + dataRil.toString() + "]";
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataRil == null) ? 0 : dataRil.hashCode());
		result = prime * result
				+ ((matrLennt == null) ? 0 : matrLennt.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VmxVmnTensioniKey other = (VmxVmnTensioniKey) obj;
		if (dataRil == null) {
			if (other.dataRil != null)
				return false;
		} else if (!dataRil.equals(other.dataRil))
			return false;
		if (matrLennt == null) {
			if (other.matrLennt != null)
				return false;
		} else if (!matrLennt.equals(other.matrLennt))
			return false;
		return true;
	}
}
