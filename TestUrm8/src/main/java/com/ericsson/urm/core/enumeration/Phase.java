package com.ericsson.urm.core.enumeration;

public enum Phase {
	R,
	S,
	T;

	public static Phase parse(String phase) {
		if (phase != null) {
			for (Phase tf : Phase.values()) {
				if (tf.toString().equalsIgnoreCase(phase)) {
					return tf;
				}
			}
		}
		throw new IllegalArgumentException("Invalid phase: " + phase);
	}
}
