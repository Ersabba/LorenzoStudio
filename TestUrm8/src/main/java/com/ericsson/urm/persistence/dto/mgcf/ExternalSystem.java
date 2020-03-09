package com.ericsson.urm.persistence.dto.mgcf;

import java.io.Serializable;

public class ExternalSystem implements Serializable, Cloneable {

	private int idEs=-1;
	private String esName=null;
	
	
	
	public ExternalSystem() {
		super();
	}
	public ExternalSystem(int idEs, String esName) {
		super();
		this.idEs = idEs;
		this.esName = esName;
	}
	public Object clone() {
		try {
			return super.clone();
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
	public int getIdEs() {
		return idEs;
	}
	public void setIdEs(int idEs) {
		this.idEs = idEs;
	}
	public String getEsName() {
		return esName;
	}
	public void setEsName(String esName) {
		this.esName = esName;
	}

    @Override
    public String toString() {
        return "ExternalSystem{" +
                "idEs=" + idEs +
                ", esName='" + esName + '\'' +
                '}';
    }
}
