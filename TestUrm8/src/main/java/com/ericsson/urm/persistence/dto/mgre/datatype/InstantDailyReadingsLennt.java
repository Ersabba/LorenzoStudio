package com.ericsson.urm.persistence.dto.mgre.datatype;

import java.io.Serializable;
/*contiene il lennt e il ccs da utilizzare nel driver: CCS0, CCS1 o CCS2 */
public class InstantDailyReadingsLennt implements Serializable{
	private static final long serialVersionUID = 1L;

	private String matricolaLennt;
	private String ccs;
	private String ccsEnum;
	
	public String getCcs() {
		return ccs;
	}
	public void setCcs(String ccs) {
		this.ccs = ccs;
	}
	public String getMatricolaLennt() {
		return matricolaLennt;
	}
	public void setMatricolaLennt(String matricolaLennt) {
		this.matricolaLennt = matricolaLennt;
	}

	public String getCcsEnum() {
		return ccsEnum;
	}
	public void setCcsEnum(String ccsEnum) {
		this.ccsEnum = ccsEnum;
	}
	@Override
	public String toString() {
		return "InstantDailyReadingsLennt [matricolaLennt=" + matricolaLennt + ", ccs=" + ccs
				+ ", ccsEnum=" + ccsEnum + "]";
	}
	
}
