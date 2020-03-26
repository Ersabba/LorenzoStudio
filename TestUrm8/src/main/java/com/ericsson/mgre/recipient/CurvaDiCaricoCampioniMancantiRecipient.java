package com.ericsson.mgre.recipient;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import com.ericsson.mgre.datatypes.Componente;


public class CurvaDiCaricoCampioniMancantiRecipient implements Recipient {

	private static final long								serialVersionUID	= 1L;
	private String											recipientId			= null;
	private HashMap<Date, HashMap<Componente, HashSet<Short>>>	periodiDaRichiedere	= new HashMap<Date, HashMap<Componente, HashSet<Short>>>();


	public HashMap<Date, HashMap<Componente, HashSet<Short>>> getPeriodiDaRichiedere() {
		return periodiDaRichiedere;
	}


	public void setPeriodiDaRichiedere(HashMap<Date, HashMap<Componente, HashSet<Short>>> periodiDaRichiedere) {
		this.periodiDaRichiedere = periodiDaRichiedere;
	}

	public CurvaDiCaricoCampioniMancantiRecipient(String recipientId) {
		this.recipientId = recipientId;
	}
	
	public void addPeriodo(Short periodo, Date data, Componente comp) {
		if ( ! periodiDaRichiedere.containsKey(data))
			periodiDaRichiedere.put(data, new HashMap<Componente, HashSet<Short>>());
		if ( ! periodiDaRichiedere.get(data).containsKey(comp))
			periodiDaRichiedere.get(data).put(comp, new HashSet<Short>());
		
		periodiDaRichiedere.get(data).get(comp).add(periodo);
	}

	@Override
	public String getRecipientId() {
		return this.recipientId;
	}

	@Override
	public String toString() {
		return "CurvaDiCaricoCampioniMancantiRecipient [recipientId=" + recipientId + ", periodiDaRichiedere=" + periodiDaRichiedere + "]";
	}
}
