package com.ericsson.mgre.datatypes;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

public class FileLedClusteringTaskInput implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Map<String, Set<String>> ccsLenntAssociation;
	
	public FileLedClusteringTaskInput() {
		super();
	}

	public Map<String, Set<String>> getCcsLenntAssociation() {
		return ccsLenntAssociation;
	}

	public void setCcsLenntAssociation(Map<String, Set<String>> ccsLenntAssociation) {
		this.ccsLenntAssociation = ccsLenntAssociation;
	}

	@Override
	public String toString() {
		return "FileLedClusteringAddInfo [ccsLenntAssociation=" + ccsLenntAssociation + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ccsLenntAssociation == null) ? 0 : ccsLenntAssociation.hashCode());
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
		FileLedClusteringTaskInput other = (FileLedClusteringTaskInput) obj;
		if (ccsLenntAssociation == null) {
			if (other.ccsLenntAssociation != null)
				return false;
		} else if (!ccsLenntAssociation.equals(other.ccsLenntAssociation))
			return false;
		return true;
	}
	

}
