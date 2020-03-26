package com.ericsson.mgre.interruzioni;


public enum Check {
	
	COD_INTERRUTTORE_DUPLICATO		("Codice interruttore duplicato sotto lo stesso CCS"),
	COD_INTERRUTTORE_NULL			("Codice interruttore null"),
	COD_CABINA_INCOERENTE			("Codice cabina non uguale in tutti i record"),
	COD_TR_MATR_TR_INCOERENTE		("Mancata corrispondenza tra codice trasformatore, matricola trasformatore e concentratore"),
	DURATA_INTERRUZIONE_INVALIDA	("Durata interruzione invalida o minore di 0 o maggiore di 300 secondi"),
	ORA_INTERRUZIONE_INVALIDA		("Ora interruzione non valida"),
	ORA_INTERRUZIONE_DUPLICATA		("Ora interruzione duplicata"),
	DATA_INTERRUZIONE_INVALIDA		("Data interruzione non valida o mancante. Formato valido: gg/mm/aaaa"),
	DATA_INTERRUZIONE_SCADUTA		("Data interruzione precedente alla finestra impostata"),
	DATA_INTERRUZIONE_INCOERENTE	("Data interruzione non uguale in tutti i record"),
	DATA_INTERRUZIONE_FUORI_RANGE	("Data interruzione fuori range (01/09/12 - sysdate]"),
	COD_CCS_INVALIDO				("Formato codice CCS invalido"),
	COD_CCS_INESISTENTE				("Codice CCS non presente in anagrafica"),
	TENSIONE_NON_VALIDA				("Valore di tensione non valido"),
	CABINA_DUPLICATA				("Codice cabina già presente in questa data interruzione");
	
	
	private String description;
	
	private Check(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static Check parse(String description)	{
		for (Check c : Check.values()) {
			if(c.description.equalsIgnoreCase(description)) { return c; }
		}
	
		throw new IllegalArgumentException ("Check: unsupported state: " + description);
	}

}
