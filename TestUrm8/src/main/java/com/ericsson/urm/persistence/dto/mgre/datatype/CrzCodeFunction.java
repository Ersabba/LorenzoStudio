package com.ericsson.urm.persistence.dto.mgre.datatype;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public enum CrzCodeFunction {
	EEA,
	EEI,
	EEC,
	EUA,
	EUC,
	EUI,
	CDC_EEA,
	CDC_EEI,
	CDC_EEC,
	CDC_EUA,
	CDC_EUC,
	CDC_EUI,
	INFRAMESE,
	DATA_ORA_LENNT,
	PDS_ESTESA;

	private static List<String> codes = new ArrayList<String>() {
		private static final long serialVersionUID = -1L;
	{
		for(CrzCodeFunction codes : CrzCodeFunction.values()) {
			add(codes.toString());
		}
	}};
	
	public static CrzCodeFunction fromString(String code) {
		return parser(code, true);
	}
	
	public static CrzCodeFunction parser(String code) {
		return parser(code, false);
	}
	
	private static CrzCodeFunction parser(String code, boolean forced) {
		for(CrzCodeFunction curr : CrzCodeFunction.values()) {
			if(curr.toString().equalsIgnoreCase(code)) {
				return curr;
			}
		}
		if(!forced) {
			throw new IllegalArgumentException("Unknown CrzCodeFunction with code: "+code);
		}
		return null;
	}
	
	public static List<String> getCodes(Set<CrzCodeFunction> codeSet) {
		
		List<String> codes = new ArrayList<String>();
		
		if(codeSet!=null) {
			for(CrzCodeFunction cf : codeSet) {
				codes.add(cf.toString());
			}
		}
		
		return Collections.unmodifiableList(codes);
	}
	
	public static List<String> getCodes() {
		
		return Collections.unmodifiableList(codes);
	}
}