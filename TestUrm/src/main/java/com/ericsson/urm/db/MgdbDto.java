package com.ericsson.urm.db;

import java.io.Serializable;


public interface MgdbDto extends Cloneable {

	public Serializable retrievePrimaryKey();

	public void applyAllProperties(MgdbDto srcDto);
	
	public Object clone();
}
