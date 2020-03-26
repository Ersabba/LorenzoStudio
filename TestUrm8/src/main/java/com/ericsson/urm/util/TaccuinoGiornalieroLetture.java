package com.ericsson.urm.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TaccuinoGiornalieroLetture {
	
	/*
	 * La chiave è il numero di blocco (che va da 1 a 8 nei giorni di 23h e 24h e 9 nei 
	 * giorni di 25h).
	 * La mappa indica, per ogni blocco, quali e quanti campioni (GRE_CURVA_DI_CARICO.NUM_PERIODO)
	 * ci devono essere per essere considerato un blocco completo 
	 * */
	private Map<Short, Set<Short>> periodiAttesiPerBlocco;
	private OreInGiorno oreGiorno;
	private Periodo periodo;
	
	
	public TaccuinoGiornalieroLetture(OreInGiorno oreGiorno, Periodo periodoCurve) {
		this.oreGiorno = oreGiorno;
		this.periodo = periodoCurve;
		
		periodiAttesiPerBlocco = new HashMap<Short, Set<Short>>();
		if (periodoCurve.equals(Periodo.H)) {
			switch (oreGiorno) {
				case H23: 
					periodiAttesiPerBlocco.put((short)1, new HashSet<Short>(Arrays.asList((new Short[] { 1, 2}))));
					periodiAttesiPerBlocco.put((short)2, new HashSet<Short>(Arrays.asList((new Short[] { 3, 4, 5}))));
					periodiAttesiPerBlocco.put((short)3, new HashSet<Short>(Arrays.asList((new Short[] { 6, 7, 8}))));
					periodiAttesiPerBlocco.put((short)4, new HashSet<Short>(Arrays.asList((new Short[] { 9,10,11}))));
					periodiAttesiPerBlocco.put((short)5, new HashSet<Short>(Arrays.asList((new Short[] {12,13,14}))));
					periodiAttesiPerBlocco.put((short)6, new HashSet<Short>(Arrays.asList((new Short[] {15,16,17}))));
					periodiAttesiPerBlocco.put((short)7, new HashSet<Short>(Arrays.asList((new Short[] {18,19,20}))));
					periodiAttesiPerBlocco.put((short)8, new HashSet<Short>(Arrays.asList((new Short[] {21,22,23}))));
					break;
				case H24:
					periodiAttesiPerBlocco.put((short)1, new HashSet<Short>(Arrays.asList((new Short[] { 1, 2, 3}))));
					periodiAttesiPerBlocco.put((short)2, new HashSet<Short>(Arrays.asList((new Short[] { 4, 5, 6}))));
					periodiAttesiPerBlocco.put((short)3, new HashSet<Short>(Arrays.asList((new Short[] { 7, 8, 9}))));
					periodiAttesiPerBlocco.put((short)4, new HashSet<Short>(Arrays.asList((new Short[] {10,11,12}))));
					periodiAttesiPerBlocco.put((short)5, new HashSet<Short>(Arrays.asList((new Short[] {13,14,15}))));
					periodiAttesiPerBlocco.put((short)6, new HashSet<Short>(Arrays.asList((new Short[] {16,17,18}))));
					periodiAttesiPerBlocco.put((short)7, new HashSet<Short>(Arrays.asList((new Short[] {19,20,21}))));
					periodiAttesiPerBlocco.put((short)8, new HashSet<Short>(Arrays.asList((new Short[] {22,23,24}))));
					break;
				case H25:
					periodiAttesiPerBlocco.put((short)1, new HashSet<Short>(Arrays.asList((new Short[] { 1, 2, 3}))));
					periodiAttesiPerBlocco.put((short)2, new HashSet<Short>(Arrays.asList((new Short[] { 5, 6, 7}))));
					periodiAttesiPerBlocco.put((short)3, new HashSet<Short>(Arrays.asList((new Short[] { 8, 9,10}))));
					periodiAttesiPerBlocco.put((short)4, new HashSet<Short>(Arrays.asList((new Short[] {11,12,13}))));
					periodiAttesiPerBlocco.put((short)5, new HashSet<Short>(Arrays.asList((new Short[] {14,15,16}))));
					periodiAttesiPerBlocco.put((short)6, new HashSet<Short>(Arrays.asList((new Short[] {17,18,19}))));
					periodiAttesiPerBlocco.put((short)7, new HashSet<Short>(Arrays.asList((new Short[] {20,21,22}))));
					periodiAttesiPerBlocco.put((short)8, new HashSet<Short>(Arrays.asList((new Short[] {23,24,25}))));
					periodiAttesiPerBlocco.put((short)9, new HashSet<Short>(Arrays.asList((new Short[] { 4}))));
					break;
			}
		}
		if (periodoCurve.equals(Periodo.M)) {
			switch (oreGiorno) {
				case H23: 
					periodiAttesiPerBlocco.put((short)1, new HashSet<Short>(Arrays.asList((new Short[] { 1, 2, 3, 4}))));
					periodiAttesiPerBlocco.put((short)2, new HashSet<Short>(Arrays.asList((new Short[] { 5, 6, 7, 8, 9,10}))));
					periodiAttesiPerBlocco.put((short)3, new HashSet<Short>(Arrays.asList((new Short[] {11,12,13,14,15,16}))));
					periodiAttesiPerBlocco.put((short)4, new HashSet<Short>(Arrays.asList((new Short[] {17,18,19,20,21,22}))));
					periodiAttesiPerBlocco.put((short)5, new HashSet<Short>(Arrays.asList((new Short[] {23,24,25,26,27,28}))));
					periodiAttesiPerBlocco.put((short)6, new HashSet<Short>(Arrays.asList((new Short[] {29,30,31,32,33,34}))));
					periodiAttesiPerBlocco.put((short)7, new HashSet<Short>(Arrays.asList((new Short[] {35,36,37,38,39,40}))));
					periodiAttesiPerBlocco.put((short)8, new HashSet<Short>(Arrays.asList((new Short[] {41,42,43,44,45,46}))));
					break;
				case H24:
					periodiAttesiPerBlocco.put((short)1, new HashSet<Short>(Arrays.asList((new Short[] { 1, 2, 3, 4, 5, 6}))));
					periodiAttesiPerBlocco.put((short)2, new HashSet<Short>(Arrays.asList((new Short[] { 7, 8, 9,10,11,12}))));
					periodiAttesiPerBlocco.put((short)3, new HashSet<Short>(Arrays.asList((new Short[] {13,14,15,16,17,18}))));
					periodiAttesiPerBlocco.put((short)4, new HashSet<Short>(Arrays.asList((new Short[] {19,20,21,22,23,24}))));
					periodiAttesiPerBlocco.put((short)5, new HashSet<Short>(Arrays.asList((new Short[] {25,26,27,28,29,30}))));
					periodiAttesiPerBlocco.put((short)6, new HashSet<Short>(Arrays.asList((new Short[] {31,32,33,34,35,36}))));
					periodiAttesiPerBlocco.put((short)7, new HashSet<Short>(Arrays.asList((new Short[] {37,38,39,40,41,42}))));
					periodiAttesiPerBlocco.put((short)8, new HashSet<Short>(Arrays.asList((new Short[] {43,44,45,46,47,48}))));
					break;
				case H25:
					periodiAttesiPerBlocco.put((short)1, new HashSet<Short>(Arrays.asList((new Short[] { 1, 2, 3, 4, 5, 6}))));
					periodiAttesiPerBlocco.put((short)2, new HashSet<Short>(Arrays.asList((new Short[] { 9,10,11,12,13,14}))));
					periodiAttesiPerBlocco.put((short)3, new HashSet<Short>(Arrays.asList((new Short[] {15,16,17,18,19,20}))));
					periodiAttesiPerBlocco.put((short)4, new HashSet<Short>(Arrays.asList((new Short[] {21,22,23,24,25,26}))));
					periodiAttesiPerBlocco.put((short)5, new HashSet<Short>(Arrays.asList((new Short[] {27,28,29,30,31,32}))));
					periodiAttesiPerBlocco.put((short)6, new HashSet<Short>(Arrays.asList((new Short[] {33,34,35,36,37,38}))));
					periodiAttesiPerBlocco.put((short)7, new HashSet<Short>(Arrays.asList((new Short[] {39,40,41,42,43,44}))));
					periodiAttesiPerBlocco.put((short)8, new HashSet<Short>(Arrays.asList((new Short[] {45,46,47,48,49,50}))));
					periodiAttesiPerBlocco.put((short)9, new HashSet<Short>(Arrays.asList((new Short[] { 7, 8}))));
					break;
			}
		}
		if (periodoCurve.equals(Periodo.Q)) {
			switch (oreGiorno) {
				case H23: 
					periodiAttesiPerBlocco.put((short)1, new HashSet<Short>(Arrays.asList((new Short[] { 1, 2, 3, 4, 5, 6, 7, 8}))));
					periodiAttesiPerBlocco.put((short)2, new HashSet<Short>(Arrays.asList((new Short[] { 9,10,11,12,13,14,15,16,17,18,19,20}))));
					periodiAttesiPerBlocco.put((short)3, new HashSet<Short>(Arrays.asList((new Short[] {21,22,23,24,25,26,27,28,29,30,31,32}))));
					periodiAttesiPerBlocco.put((short)4, new HashSet<Short>(Arrays.asList((new Short[] {33,34,35,36,37,38,39,40,41,42,43,44}))));
					periodiAttesiPerBlocco.put((short)5, new HashSet<Short>(Arrays.asList((new Short[] {45,46,47,48,49,50,51,52,53,54,55,56}))));
					periodiAttesiPerBlocco.put((short)6, new HashSet<Short>(Arrays.asList((new Short[] {57,58,59,60,61,62,63,64,65,66,67,68}))));
					periodiAttesiPerBlocco.put((short)7, new HashSet<Short>(Arrays.asList((new Short[] {69,70,71,72,73,74,75,76,77,78,79,80}))));
					periodiAttesiPerBlocco.put((short)8, new HashSet<Short>(Arrays.asList((new Short[] {81,82,83,84,85,86,87,88,89,90,91,92}))));
					break;
				case H24:
					periodiAttesiPerBlocco.put((short)1, new HashSet<Short>(Arrays.asList((new Short[] { 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12}))));
					periodiAttesiPerBlocco.put((short)2, new HashSet<Short>(Arrays.asList((new Short[] {13,14,15,16,17,18,19,20,21,22,23,24}))));
					periodiAttesiPerBlocco.put((short)3, new HashSet<Short>(Arrays.asList((new Short[] {25,26,27,28,29,30,31,32,33,34,35,36}))));
					periodiAttesiPerBlocco.put((short)4, new HashSet<Short>(Arrays.asList((new Short[] {37,38,39,40,41,42,43,44,45,46,47,48}))));
					periodiAttesiPerBlocco.put((short)5, new HashSet<Short>(Arrays.asList((new Short[] {49,50,51,52,53,54,55,56,57,58,59,60}))));
					periodiAttesiPerBlocco.put((short)6, new HashSet<Short>(Arrays.asList((new Short[] {61,62,63,64,65,66,67,68,69,70,71,72}))));
					periodiAttesiPerBlocco.put((short)7, new HashSet<Short>(Arrays.asList((new Short[] {73,74,75,76,77,78,79,80,81,82,83,84}))));
					periodiAttesiPerBlocco.put((short)8, new HashSet<Short>(Arrays.asList((new Short[] {85,86,87,88,89,90,91,92,93,94,95,96}))));
					break;
				case H25:
					periodiAttesiPerBlocco.put((short)1, new HashSet<Short>(Arrays.asList((new Short[] { 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12}))));
					periodiAttesiPerBlocco.put((short)2, new HashSet<Short>(Arrays.asList((new Short[] {17,18,19,20,21,22,23,24,25,26,27,28}))));
					periodiAttesiPerBlocco.put((short)3, new HashSet<Short>(Arrays.asList((new Short[] {29,30,31,32,33,34,35,36,37,38,39,40}))));
					periodiAttesiPerBlocco.put((short)4, new HashSet<Short>(Arrays.asList((new Short[] {41,42,43,44,45,46,47,48,49,50,51,52}))));
					periodiAttesiPerBlocco.put((short)5, new HashSet<Short>(Arrays.asList((new Short[] {53,54,55,56,57,58,59,60,61,62,63,64}))));
					periodiAttesiPerBlocco.put((short)6, new HashSet<Short>(Arrays.asList((new Short[] {65,66,67,68,69,70,71,72,73,74,75,76}))));
					periodiAttesiPerBlocco.put((short)7, new HashSet<Short>(Arrays.asList((new Short[] {77,78,79,80,81,82,83,84,85,86,87,88}))));
					periodiAttesiPerBlocco.put((short)8, new HashSet<Short>(Arrays.asList((new Short[] {89,90,91,92,93,94,95,96,97,98,99,100}))));
					periodiAttesiPerBlocco.put((short)9, new HashSet<Short>(Arrays.asList((new Short[] {13,14,15,16}))));
					break;
			}
		}
	}
	
	public Short getBlockByPeriod(Short period) {
		for (Map.Entry<Short, Set<Short>> entry : periodiAttesiPerBlocco.entrySet())
			if (entry.getValue().contains(period))
				return entry.getKey();
		throw new IllegalArgumentException("Invalid period value for this day: " + period);
	}
	
	public List<Short> getAllOrderedPeriods() {
		ArrayList<Short> list = new ArrayList<Short>(23);
		for (Set<Short> periods : periodiAttesiPerBlocco.values())
			list.addAll(periods);
		Collections.sort(list);
		return list;
	}
	
	// millisFromMidnight corrisponde ai millisecondi che intercorrono tra le ore 00:00 e l'ora in corrispondenza della quali si vuole il periodo
	// ritorna il periodo, valori possibili da 1 a 100 a seconda del giorno
	public Short getCorrespondingPeriod(long millisFromMidnight) {
		long millisInPeriod; // un periodo non ha sempre gli stessi millis perchè può essere di un'ora, mezzora o 3/4 d'ora
		switch (periodo) {
			case H: millisInPeriod = 60000 * 60;
			break;
			case M: millisInPeriod = 60000 * 60;
			break;
			default: millisInPeriod = 60000 * 60;
		}
		long millisInDay;
		switch (oreGiorno) {
			case H23: millisInDay = 23 * 3600000;
			break;
			case H24: millisInDay = 24 * 3600000;
			break;
			default: millisInDay = 25 * 3600000;
		}
		for (long period = 0; period < millisInDay; ) {
			if (millisFromMidnight < (period + millisInPeriod))
				return (short) (period + 1);
			period += millisInPeriod;
		}
		// qui non ci deve arrivare. 
		// se ci arriva, il parametro è stato calcolato male o non è del giorno su cui si basa il taccuino
		throw new IllegalArgumentException("Invalid value of millisFromMidnight: " + millisFromMidnight);
	}
	
	public Set<Short> calcolaBlocchiScoperti(Set<Short> periodiPervenuti) {
		Set<Short> blocchiScoperti = new HashSet<Short>();
		
		if( periodiPervenuti == null ) {
			periodiPervenuti = new HashSet<Short>();
		}
		
		for (Short blocco : periodiAttesiPerBlocco.keySet()) {
			if ( ! periodiPervenuti.containsAll(periodiAttesiPerBlocco.get(blocco)))
				blocchiScoperti.add(blocco);
		}
		
		return blocchiScoperti;
	}
	
	public static enum OreInGiorno {
		H23, // giorno in cui c'è un'ora in meno per cambio ora
		H24, 
		H25 // giorno in cui c'è un'ora in più per cambio ora
	}
	
	public static enum Periodo {
		Q, M, H
	}
}
