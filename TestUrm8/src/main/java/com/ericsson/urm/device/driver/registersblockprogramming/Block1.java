package com.ericsson.urm.device.driver.registersblockprogramming;

import java.util.HashMap;
import java.util.Map;


public class Block1 implements RegistersBlock {

	private static final long	serialVersionUID	= 1L;

	private Map<DisplayParametersType, Boolean> displayParametersTypeMap = new HashMap<DisplayParametersType, Boolean>();
	
	public static enum DisplayParametersType {	

		
		//registro 1
		ABILITAZIONE_GLOBALE_VISUALIZZAZIONI_A_DISPLAY(1,0),
		DATA_ORA(1,1),
		MATRICOLA(1,2),
		POSIZIONE(1,3),
		MESSAGGI(1,4),
		PAROLA_DI_STATO(1,5),
		RELEASE_E_DATA_FIRMWARE(1,6),
		TUTTE_LE_GRANDEZZE_DEL_MESE_PRECEDENTE(1,7),
		
		//registro 2
		POTENZA_DISPONIBILE(2,0),
		TOTALIZZATORE_ENERGIA_ATTIVA_ASSORBITA(2,1),
		TOTALIZZATORE_ENERGIA_ATTIVA_EROGATA(2,2),
		TOTALIZZATORE_ENERGIA_REATTIVA_Q1(2,3),
		TOTALIZZATORE_ENERGIA_REATTIVA_Q2(2,4),
		TOTALIZZATORE_ENERGIA_REATTIVA_Q3(2,5),
		TOTALIZZATORE_ENERGIA_REATTIVA_Q4(2,6),
		R_PIU_R_MENO(2,7),
		
		//registro 3
		ENERGIA_ATTIVA_ASSORBITA_IN_T1(3,0),
		ENERGIA_ATTIVA_ASSORBITA_IN_T2(3,1),
		ENERGIA_ATTIVA_ASSORBITA_IN_T3(3,2),
		ENERGIA_ATTIVA_ASSORBITA_IN_T4(3,3),
		TOTALIZZATORE_ENERGIA_ATTIVA_EROGATA_IN_T1(3,4),
		TOTALIZZATORE_ENERGIA_ATTIVA_EROGATA_IN_T2(3,5),
		TOTALIZZATORE_ENERGIA_ATTIVA_EROGATA_IN_T3(3,6),
		TOTALIZZATORE_ENERGIA_ATTIVA_EROGATA_IN_T4(3,7),
		
		//registro 4
		ENERGIA_REATTIVA_IN_T1_QUADRANTE_Q1(4,0),
		ENERGIA_REATTIVA_IN_T2_QUADRANTE_Q1(4,1),
		ENERGIA_REATTIVA_IN_T3_QUADRANTE_Q1(4,2),
		ENERGIA_REATTIVA_IN_T4_QUADRANTE_Q1(4,3),
		ENERGIA_REATTIVA_IN_T1_QUADRANTE_Q3(4,4),
		ENERGIA_REATTIVA_IN_T2_QUADRANTE_Q3(4,5),
		ENERGIA_REATTIVA_IN_T3_QUADRANTE_Q3(4,6),
		ENERGIA_REATTIVA_IN_T4_QUADRANTE_Q3(4,7),
		
		//registro 5
		POTENZA_ATTIVA_MEDIA_AL_MINUTO(5,0),
		POTENZA_ATTIVA_MEDIA_MAX_NEL_PI(5,1),
		TENSIONE_MASSIMA(5,2),
		TENSIONE_MINIMA(5,3),
		FATTORE_DI_POTENZA_MASSIMO(5,4),
		FATTORE_DI_POTENZA_MINIMO(5,5),
		SQUILIBRIO_MEDIO_TENSIONI(5,6),
		SQUILIBRIO_MEDIO_TENSIONI_(5,7), // da verificare 
		
		//registro 6
		FASE_COLLEGAMENTO(6,0),
		CONCENTRATORE_COLLEGATO(6,1),
		POTENZA_MASSIMA_TARIFFA_1(6,2),
		POTENZA_MASSIMA_TARIFFA_2(6,3),
		POTENZA_MASSIMA_TARIFFA_3(6,4),
		POTENZA_MASSIMA_TARIFFA_4(6,5),
		NON_UTILIZZATO(6,6),
		NON_UTILIZZATO_(6,7),	// da verificare 
				
		//registro 7
		VALORE_PRECEDENTE_TOTALIZZATORE_ENERGIA_ATTIVA_ASSORBITA(7,0),
		VALORE_PRECEDENTE_TOTALIZZATORE_ENERGIA_ATTIVA_EROGATA(7,1),
		VALORE_PRECEDENTE_TOTALIZZATORI_ENERGIE_REATTIVE(7,2),
		VALORE_PRECEDENTE_ENERGIA_ATTIVA_ASSORBITA_PER_TARIFFA(7,3),
		VALORE_PRECEDENTE_ENERGIA_ATTIVA_EROGATA_PER_TARIFFA(7,4),
		VALORE_PRECEDENTE_REATTIVA_QUADRANTE_Q1_PER_TARIFFA(7,5),
		VALORE_PRECEDENTE_REATTIVA_QUADRANTE_Q3_PER_TARIFFA(7,6),
		VALORE_PRECEDENTE_POTENZE_MASSIME_PER_TARIFFA(7,7);
		
		private int index;
		private int pos;
		
		private DisplayParametersType (int index, int pos) {
			this.pos = pos;
			this.index = index;
		}
					
		public static DisplayParametersType parseIndexPos(int index, int pos)	{
			for(DisplayParametersType curr : DisplayParametersType.values()) {
				if(curr.index == index && curr.pos == pos) {
					return curr;
				}
			}
			throw new IllegalArgumentException ("RegisterCode.parse: unsupported index value " + index);
		}
		
		public static DisplayParametersType parser(String name) {
			for(DisplayParametersType ts: DisplayParametersType.values()) {
				if(ts.toString().equalsIgnoreCase(name)) {
					return ts;
				}
			}
			throw new IllegalArgumentException("Unknown source:"+name);
		}
		
		public int getIndex() {
			return index;
		}

		public int getPos() {
			return pos;
		}
		
	}

	public Map<DisplayParametersType, Boolean> getDisplayParametersTypeMap() {
		return displayParametersTypeMap;
	}

	public void setDisplayParametersTypeMap(
			Map<DisplayParametersType, Boolean> displayParametersTypeMap) {
		this.displayParametersTypeMap = displayParametersTypeMap;
	}
	
	public void setDisplayParameter(byte[] regValues) {
		
		if(regValues==null) {
			throw new IllegalArgumentException("Undefined argument values");
		}
		
		displayParametersTypeMap = new HashMap<DisplayParametersType, Boolean>();
	
		boolean bitValue;
		int register;
		int pos;
		int len = regValues.length;
		
		for(DisplayParametersType dpt: DisplayParametersType.values()) {
			register = dpt.getIndex();
			bitValue = false;
			if(register>0 && register<len) {
				pos = dpt.getPos();
				if(pos>=0 && pos<8) {
					bitValue = ((regValues[register-1] >>> pos) & 0x01) == 1;
				}
			}
			displayParametersTypeMap.put(dpt, bitValue);
		}
	}
	
	public byte getRegisterValue(int index) {
		if(displayParametersTypeMap == null || displayParametersTypeMap.isEmpty()) {
			throw new IllegalStateException("Object not initialized");
		}
		if(index<0 || index>=7) {
			throw new IllegalArgumentException("Valid index between 0 and 6");
		}
		
		int regValue = 0;
		for(DisplayParametersType dpt: DisplayParametersType.values()) {
			if(dpt.getIndex() == (index+1)) {
				int pos = dpt.getPos();
				boolean bitValue = displayParametersTypeMap.get(dpt);
				if(bitValue) {
					regValue |= (1<<pos);
				}
			}
		}
		return (byte)regValue;
	}
}
