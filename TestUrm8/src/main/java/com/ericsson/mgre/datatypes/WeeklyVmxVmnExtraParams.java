package com.ericsson.mgre.datatypes;

import java.io.Serializable;
import java.util.Date;

public class WeeklyVmxVmnExtraParams implements Serializable{
	private static final long serialVersionUID = 1L;

	public static enum ExtraParamsKeys{
		MESE_RIFERIMENTO("MESE_RIFERIMENTO"),
		TIPO_MISURATORE("TIPO_MISURATORE"),
		COMPRESSIONE_FILE("COMPRESSIONE_FILE");
		
		private String value;
		
		private ExtraParamsKeys(String value){
			this.value = value;
		}

		public String getValue() {
			return value;
		}
		
		public static ExtraParamsKeys parse(String value){
			for(ExtraParamsKeys curr : ExtraParamsKeys.values()){
				if(curr.toString().equalsIgnoreCase(value)){
					return curr;					
				}
			}
			throw new IllegalArgumentException ("ExtraParamsKeys: unsupported value " + value);
		}
	}
	
	private Date dataStart = null;
	private int referenceMonth = 0;
	private String lenntType = null;
	private String compressFile = null;
	private Date referenceDate = null;
	
	public Date getDataStart() {
		return dataStart;
	}
	public void setDataStart(Date dataStart) {
		this.dataStart = dataStart;
	}
	public int getReferenceMonth() {
		return referenceMonth;
	}
	public void setReferenceMonth(int referenceMonth) {
		this.referenceMonth = referenceMonth;
	}
	public String getLenntType() {
		return lenntType;
	}
	public void setLenntType(String lenntType) {
		this.lenntType = lenntType;
	}
	public String getCompressFile() {
		return compressFile;
	}
	public void setCompressFile(String compressFile) {
		this.compressFile = compressFile;
	}
	public Date getReferenceDate() {
		return referenceDate;
	}
	public void setReferenceDate(Date referenceDate) {
		this.referenceDate = referenceDate;
	}
}