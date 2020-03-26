package com.ericsson.mgre.biz.taskMgmt.addinfo.impl;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Set;

import com.ericsson.mgre.biz.taskMgmt.addinfo.AddInfo;

public class AddInfoImpl implements AddInfo, Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private Hashtable hashtable = new Hashtable();
	
	public synchronized Object getProperty(Object key) {
		return hashtable.get(key);
	}
	
	public synchronized boolean containsKey(Object key) {
		return hashtable.containsKey(key);
	}
	
	public synchronized void setProperty(Object key, Object value) {
		hashtable.put(key, value);
	}
	
	public synchronized int size() {
		return hashtable.size();
	}

	public synchronized Set entrySet() {
		Set set = hashtable.entrySet();
		return set;
	}
	
	public synchronized Set keySet() {
		Set set = hashtable.keySet();
		return set;
	}
	
	public Object clone() {
		try {
			AddInfoImpl ret = (AddInfoImpl)super.clone();
			if (hashtable != null) {
				ret.hashtable = (Hashtable) hashtable.clone();
			}
			return ret;
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
