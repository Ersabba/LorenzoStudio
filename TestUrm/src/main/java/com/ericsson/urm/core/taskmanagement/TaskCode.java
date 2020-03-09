package com.ericsson.urm.core.taskmanagement;

import java.util.HashMap;
import java.util.Map;

import com.ericsson.urm.util.ArgumentsCheckerUtil;

public enum TaskCode {
	
	AGGIORNAMENTO_STATISTICHE("A100"),
	INVIO_PARAMETRI_QUALITA_TENSIONE("A101"),
	LETTURA_PARAMETRI_QUALITA_TENSIONE("A102"),
	LETTURA_DATI_QUALITA_TENSIONE("A103"),
	LETTURA_DATI_CORRENTI_CABINA("A104"),
	ACQ_PROFILI_TENSIONE_CORRENTE("A105"),
	PROCESSOR_PROFILI_TENSIONE_CORRENTE("A106"),
	LETTURE_UTENZA("A107"),
	LETTURE_MISURE_MENSILI("A108"), // A108 - OBSOLETO
	LETTURA_TOTALIZZATORI_GIORNALIERI_EAA("A109"),
	LETTURA_TOTALIZZATORI_GIORNALIERI_EAE("A110"),
	ACQ_PUNTUALE_PROFILI_TENSIONE_CORRENTE("A111"),
	CURVE_CARICO_UTENZE_SPECIALI_LUS("A112"),
	VARIAZIONE_PIANI_TARIFFARI("A113"),
	PROGRAMMAZIONE_DISPLAY("A114"),
	INSTALLAZIONE_LENNT("A115"),
	DATI_GESTIONE_FORNITURA("A116"),
	LETTURA_DATA_ORA_LENNT("A117"),
	ABILITAZIONE_CURVE_CARICO("A118"),
	LETTURA_PAROLA_STATO_MASSIVA("A119"),
	LETTURA_PAROLA_STATO_SINGOLO_LENNT("A120"),
	LETTURA_TOTALIZZATORI_SINGOLO_LENNT("A121"),
	ACQ_ELAB_CURVE_CARICO_PUNTUALI("A122"),
	EXPORT_CURVE_CARICO_PUNTUALI("A123"),
	ACQ_CURVE_DI_CARICO_MEDIE_MENSILI("A124"),
	READ_LENNT_DATA("A125"),
	EXPORT_PROFILI_TENSIONE_CORRENTE("A126"),
	STANDBY_CCS("A127"),
	READ_DISPLAY("A128"),
    EXPORT_FLOW_DATA("A129"),
	LETTURE_MISURE_MENSILI_PUNTUALI_MANCANTI("A130"),
	CLUSTERING_FILENEW("A131"),
	EXPORT_PAROLA_STATO_MASSIVA("A132"),
	CURVE_CARICO_PUNTUALI_GPRS("A133"),
	ATTIVAZIONE_PRODUZIONE_FILE_EEA("A134"),
	ATTIVAZIONE_PRODUZIONE_FILE_Q14("A135"),
	ATTIVAZIONE_PRODUZIONE_FILE_E23("A136"),
	ATTIVAZIONE_PRODUZIONE_FILE_IPM("A137"),
	PROGRAMMER_CCS_MODE("A138"),
	ALLACCIO_UTENZA("A139"),
	DISTACCO_UTENZA("A140"),
	VARIAZIONE_DI_POTENZA("A141"),
	RIATTIVAZIONE("A142"),
	ANNULLAMENTO_DEI_DISTACCHI("A143"),
	DISATTIVAZIONE_PORTA("A144"),
	ATTIVAZIONE_STAGIONALE("A145"),
	THOR_FILENEW("A146"),
	DISATTIVAZIONE_STAGIONALE("A147"),
	ACQUISIZIONE_FILE_MULTIPLA_PERIODICA("A148"),
	ACQUISIZIONE_FILE_MULTIPLA("A149"),
	LETTURE_MISURE_MENSILI_PUNTUALI("A150"),
	PROGRAMMAZIONE_CALENDARIO_CCS("A151"),
	ACQ_ELAB_CURVE_CARICO_PUNTUALI_ONE_SHOT("A152"),
	EXPORT_DATI_TENSIONE_MENSILE("A153"),
	RESET_LENNT_STATE_PERIODICO("A154"),
	RESET_LENNT_STATE_DA_FILE("A155"),
	RESET_LENNT_STATE_SINGLE("A156"), 
	// CR 32
	DWHFINEMESEG2("A157"),
	DWHFINEMESEG3("A158"),
	DWHLENNTLETTI("A159"),
	DWHPRIMELETTG1("A160"),
	DWHPRIMELETTG16("A161"),
	ORBTULTIMELETT("A162"),
	SGIACQFILES("A163"),
	SGIFASI("A164"),
	SGILETTGIOR("A165"),
	SGISTATOCCS("A166"),
	SGISTATOCONC("A167"),
	// nuovi settimanali
	SAPStatoConc("A168"),
	SAPStatoCCS("A169"),
	SAPLenntLetti("A170"),
	//end CR 32
	DAILY_INSTANT_READINGS_EEA("A171"),
	//Misure potenze massime mensili //in sostituzione del task A23 che punta al vecchio driver
	MISURE_POTENZE_MASSIME_MENSILI("A172"), 
	BONIFICA_ANAGRAFICA_CCS("A173"),
	UPGRADE_FIRMWARE("upgrade.firmware"),
	EXPORT_ONESHOT_CDC("A174"),   //dormiente???
	RECUPERO_REGISTRI_STORICI_LENNT("A175"),
	//RECOVERY_CCS_FILES("A176"),  
	//A176 riservato per CR047(Integrazione URM-Concentratore multiservizio)
    //A177 riservato per export statistiche lennt trattamento orari vedi cr050
	ACQ_FILE_COM("A178"),
	ELAB_FILE_COM("A179"),
	EXPORT_FILE_COM("A180"),
	ACQ_FILE_DEM("A181"),
	ELAB_FILE_DEM("A182"),
	EXPORT_FILE_DEM("A183"),
	ACQ_FILE_ROU("A184"),
	ELAB_FILE_ROU("A185"),
	EXPORT_FILE_ROU("A186"),
	ACQ_FILE_ADD("A187"),
	ELAB_FILE_ADD("A188"),
	EXPORT_FILE_ADD("A189"),
	FILE_LED_CLUSTERING("A190");
	
	
	
	private final static Map<TaskCode,TaskCode> associatedTaskCodeMap = new HashMap<TaskCode,TaskCode>() {
		private static final long serialVersionUID = -1L;

		{
			put(ACQ_PROFILI_TENSIONE_CORRENTE, PROCESSOR_PROFILI_TENSIONE_CORRENTE);
			put(PROCESSOR_PROFILI_TENSIONE_CORRENTE, ACQ_PROFILI_TENSIONE_CORRENTE);
		}
	};
	
	private final static Map<String,TaskCode> codeMap = new HashMap<String,TaskCode>() {
		private static final long serialVersionUID = -1L;

		{
			for(TaskCode t : TaskCode.values()) {
				put(t.code.trim().toUpperCase(), t);
			}
		}
	};
	
	private String code;
	
	private TaskCode(String code) {
		ArgumentsCheckerUtil.checkNull(code,"code");
		this.code = code.toUpperCase();
	}

	public String getCode() {
		return code;
	}
	
	public static boolean isTaskCode(String code) {
		
		return (code!=null) ? codeMap.containsKey(code.trim().toUpperCase()) : false;
	}
	
	public static TaskCode fromCode(String code) {
		
		if(code==null) {
			return null;
		}
		
		// searching by code
		TaskCode taskCode = codeMap.get(code.trim().toUpperCase());
		if(taskCode==null) {
			// searching by name
			for(TaskCode t : TaskCode.values()) {
				if(t.toString().equalsIgnoreCase(code)) {
					return t;
				}
			}
			
			throw new IllegalArgumentException("Unknown task code:"+code);
		}
		
		return taskCode;
		
	}

	
	public static TaskCode getAssociatedTaskCode(TaskCode taskCode) {
		return associatedTaskCodeMap.get(taskCode);
	}
	
}
