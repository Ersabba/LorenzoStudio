package com.ericsson.urm.persistence.dto.mgre.datatype;

import java.io.Serializable;

public class StateAcqLoadCurve implements Serializable {
	private static final long serialVersionUID = -1;
	
	public static final StateAcqLoadCurve DC = new StateAcqLoadCurve("DC");
	public static final StateAcqLoadCurve AF = new StateAcqLoadCurve("AF");  //acquisizione fallita
	public static final StateAcqLoadCurve AS = new StateAcqLoadCurve("AS");  //acquisizione success
	public static final StateAcqLoadCurve AT = new StateAcqLoadCurve("AT"); //ACQUISIZIONE TERMINATA ( FILE_NOT_FOUND)
	public static final StateAcqLoadCurve ES = new StateAcqLoadCurve("ES"); //elaborazione effettuata
	public static final StateAcqLoadCurve EF = new StateAcqLoadCurve("EF"); //elaborazione fallita
	
	private String state;
	
	private StateAcqLoadCurve(String state) {
		this.state = state;
	}
	
	public static StateAcqLoadCurve parse(String state) {
		if (DC.toString().equalsIgnoreCase(state))
			return DC;
		if (AF.toString().equalsIgnoreCase(state))
			return AF;
		if (AS.toString().equalsIgnoreCase(state))
			return AS;
		if (AT.toString().equalsIgnoreCase(state))
			return AT;
		if (ES.toString().equalsIgnoreCase(state))
			return ES;
		if (EF.toString().equalsIgnoreCase(state))
			return EF;
		
		throw new IllegalArgumentException("Unsupported StateAcqLoadCurve: " + state);
	}

	public String getState() {
		return state;
	}
	
	public String toString() {
		return state;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StateAcqLoadCurve other = (StateAcqLoadCurve) obj;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
}
