package com.ericsson.urm.persistence.dto.mgre.datatype;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public enum CrzConfigParamName {
	FLAG_AGGIORNAMENTO_PARAMETRI_GLOBALI,
	DATA_AGGIORNAMENTO_PARAMETRI_GLOBALI;

	private static List<String> codes = new ArrayList<String>() {
		private static final long serialVersionUID = -1L;
	{
		for(CrzConfigParamName codes : CrzConfigParamName.values()) {
			add(codes.toString());
		}
	}};
	
	public static CrzConfigParamName fromString(String code) {
		return parser(code, true);
	}
	
	public static CrzConfigParamName parser(String code) {
		return parser(code, false);
	}
	
	private static CrzConfigParamName parser(String code, boolean forced) {
		for(CrzConfigParamName curr : CrzConfigParamName.values()) {
			if(curr.toString().equalsIgnoreCase(code)) {
				return curr;
			}
		}
		if(!forced) {
			throw new IllegalArgumentException("Unknown CrzConfigParamName with code: "+code);
		}
		return null;
	}
	
	public static List<String> getCodes(Set<CrzConfigParamName> codeSet) {
		
		List<String> codes = new ArrayList<String>();
		
		if(codeSet!=null) {
			for(CrzConfigParamName cf : codeSet) {
				codes.add(cf.toString());
			}
		}
		
		return Collections.unmodifiableList(codes);
	}
	
	public static List<String> getCodes() {
		
		return Collections.unmodifiableList(codes);
	}
}