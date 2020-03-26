package com.ericsson.urm.persistence.dto.mgre.datatype;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public enum CrzCodeGlobalParameter {
	INFRAMESE_DATA,
	INFRAMESE_RETRY,
	GESTIONE_RADIOMOBILE_NUMERO_RETRY,
	GESTIONE_RADIOMOBILE_PERIODICITA_RETRY,
	TEMPO_INIBIZIONE_PULSANTE,
	GESTIONE_RADIOMOBILE_PERIODICITA_INVIO_CG,
	GESTIONE_RADIOMOBILE_ORA_INVIO_CG,
	GESTIONE_RADIOMOBILE_MINUTO_INVIO_CG,
	GESTIONE_RADIOMOBILE_TIMEOUT_CG,
	SITO_NOTIFICA,
	TCPIP_INDIRIZZO,
	TCPIP_PORTA,
	APN_NAME, APN_USER, APN_PASSWORD;

	private static List<String> codes = new ArrayList<String>() {
		private static final long serialVersionUID = -1L;
	{
		for(CrzCodeGlobalParameter codes : CrzCodeGlobalParameter.values()) {
			add(codes.toString());
		}
	}};
	
	public static CrzCodeGlobalParameter fromString(String code) {
		return parser(code, true);
	}
	
	public static CrzCodeGlobalParameter parser(String code) {
		return parser(code, false);
	}
	
	private static CrzCodeGlobalParameter parser(String code, boolean forced) {
		for(CrzCodeGlobalParameter curr : CrzCodeGlobalParameter.values()) {
			if(curr.toString().equalsIgnoreCase(code)) {
				return curr;
			}
		}
		if(!forced) {
			throw new IllegalArgumentException("Unknown CrzCodeGlobalParameter with code: "+code);
		}
		return null;
	}
	
	public static List<String> getCodes(Set<CrzCodeGlobalParameter> codeSet) {
		
		List<String> codes = new ArrayList<String>();
		
		if(codeSet!=null) {
			for(CrzCodeGlobalParameter cf : codeSet) {
				codes.add(cf.toString());
			}
		}
		
		return Collections.unmodifiableList(codes);
	}
	
	public static List<String> getCodes() {
		
		return Collections.unmodifiableList(codes);
	}
}