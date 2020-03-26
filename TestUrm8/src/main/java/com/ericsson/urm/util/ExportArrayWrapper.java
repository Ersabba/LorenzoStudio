package com.ericsson.urm.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExportArrayWrapper<T>  implements Serializable {
	private static final long serialVersionUID = -1L;
	private T[] array = null;
	private List<T> exportedList = new ArrayList<T>();
	
	public ExportArrayWrapper() {
		super();
	}
	
	public ExportArrayWrapper(T[] array) {
		super();
		this.array = array;
	}
	
	public T[] getArray() {
		return array;
	}
	
	public List<T> getArrayAsList() {
		return Arrays.asList(array);
	}

	public void setArray(T[] elements) {
		this.array = elements;
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
		result = prime * result + Arrays.hashCode(array);
		result = prime * result + ((exportedList == null) ? 0 : exportedList.hashCode());
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
		ExportArrayWrapper<T> other = (ExportArrayWrapper<T>) obj;
		if (!Arrays.equals(array, other.array))
			return false;
		if (exportedList == null) {
			if (other.exportedList != null)
				return false;
		} else if (!exportedList.equals(other.exportedList))
			return false;
		return true;
	}
	
}
