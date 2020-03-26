package com.ericsson.urm.util;

import java.io.Serializable;

public class KeyValuePair<K extends Serializable,T extends Serializable> implements Serializable {
	
	private static final long serialVersionUID = -1L;
	
	public K key = null;
	public T value = null;
	
	
	public KeyValuePair() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public KeyValuePair(K key, T value) {
		super();
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
