package com.ericsson.urm.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExportListWrapper<T> implements Serializable {
	private static final long serialVersionUID = -1L;
	private List<T> list = null;
	private List<T> exportedList = new ArrayList<T>();
	
	public ExportListWrapper() {
		super();
	}
	
	public ExportListWrapper(List<T> elements) {
		super();
		this.list = elements;
	}
	
	public List<T> getList() {
		if(list==null) {
			list = new ArrayList<T>();
		}
		
		return list;
	}

	public void setList(List<T> list) {
		if(list==null) {
			list = new ArrayList<T>();
		}
		
		if(this.list != list) {
			exportedList.clear();
		}
		
		this.list = list;
	}

	public void addElemExported(T elem) {
		synchronized(exportedList) {
			exportedList.add(elem);
		}
	}
	
	public void removeElemExported(T elem) {
		synchronized(exportedList) {
			exportedList.remove(elem);
		}
	}
	
	public boolean isElemExported(T elem) {
		synchronized(exportedList) {
			return exportedList.contains(elem);
		}
	}

	public List<T> getUnmodifiableExportedList() {
		
		List<T> list = null;
		synchronized(exportedList) {
			list = Collections.unmodifiableList(exportedList);
		}
		return list;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exportedList == null) ? 0 : exportedList.hashCode());
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ExportListWrapper))
			return false;
		ExportListWrapper<T> other = (ExportListWrapper<T>) obj;
		if (exportedList == null) {
			if (other.exportedList != null)
				return false;
		} else if (!exportedList.equals(other.exportedList))
			return false;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		return true;
	}
}
