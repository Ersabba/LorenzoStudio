package com.ericsson.mgre.datatypes;

import java.io.Serializable;

public class SubdailyActivityExtraParams implements Serializable {
	
	public static enum SubdailyActivityExtraKeys {
		
		ENDTIME("ENDTIME");
		
		private String value;
		
		private SubdailyActivityExtraKeys(String value){
			this.value = value;
		}

		public String getValue() {
			return value;
		}
		
		public static SubdailyActivityExtraKeys parse (String value){
			for(SubdailyActivityExtraKeys curr : SubdailyActivityExtraKeys.values()){
				if(curr.toString().equalsIgnoreCase(value)){
					return curr;					
				}
			}
			
			throw new IllegalArgumentException ("SubdailyActivityExtraParams: unsupported value " + value);
		}
		
	}

	private static final long serialVersionUID = 1L;
	
	private String endDate;
		
	public SubdailyActivityExtraParams() {
		super();
	}
	
	public SubdailyActivityExtraParams(String endDate) {
		super();
		this.endDate = endDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
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
		SubdailyActivityExtraParams other = (SubdailyActivityExtraParams) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "SubdailyActivityExtraParams [endDate=" + endDate + "]";
	}

			
}
