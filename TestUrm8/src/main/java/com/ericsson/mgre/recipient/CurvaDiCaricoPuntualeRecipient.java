package com.ericsson.mgre.recipient;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import com.ericsson.mgre.datatypes.Componente;


public class CurvaDiCaricoPuntualeRecipient implements Recipient {

	private static final long					serialVersionUID		= 1L;
	private String								recipientId				= null;
	private HashMap<Date, HashSet<Componente>>	componentiNecessarie	= new HashMap<Date, HashSet<Componente>>();
	private Date								periodoRichDa;
	private Date								periodoRichA;


	public String toString() {
		if (recipientId == null)
			return null;
		StringBuffer sb = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sb.append(recipientId + "->[");
		if (componentiNecessarie != null)
			for (Date d : componentiNecessarie.keySet())
				sb.append(sdf.format(d) + "," + componentiNecessarie.get(d) + "; ");
		sb.append("]");
		return sb.toString();
	}

	public HashMap<Date, HashSet<Componente>> getComponentiNecessarie() {
		return componentiNecessarie;
	}

	public void setComponentiNecessarie(HashMap<Date, HashSet<Componente>> componentiNecessarie) {
		this.componentiNecessarie = componentiNecessarie;
	}

	public CurvaDiCaricoPuntualeRecipient() {
		super();
	}

	public CurvaDiCaricoPuntualeRecipient(String recipientId) {
		this.recipientId = recipientId;
	}

	public String getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}
	
	public Date getPeriodoRichDa() {
		return periodoRichDa;
	}

	public void setPeriodoRichDa(Date periodoRichDa) {
		this.periodoRichDa = periodoRichDa;
	}

	public Date getPeriodoRichA() {
		return periodoRichA;
	}

	public void setPeriodoRichA(Date periodoRichA) {
		this.periodoRichA = periodoRichA;
	}
}
