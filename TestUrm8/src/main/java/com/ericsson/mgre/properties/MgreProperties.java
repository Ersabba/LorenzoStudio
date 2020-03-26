package com.ericsson.mgre.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.ericsson.urm.config.UrmConfig;




public class MgreProperties {
	
	public final static String CFG_DIRNAME = "configurationsBaseDir";
	public final static String MGREMENU_CONFIG_FILE_PARSER = "fileinterface.mgremenu.configuration.file";	
	
	 private static Logger logger = Logger.getLogger(MgreProperties.class);

	 private static Properties properties = null;
	 private static long       filePropLastModified = 0;
	 private static long	   filePropLastModifiedMainCfg = 0;
	 
	 public static interface Keys {
		 
		 public static interface Database  {            
			 public final static String CMT_FILENAME    		= "hibernate.cmt.cfg.filename";
			 public final static String JTA_FILENAME    		= "hibernate.jta.cfg.filename";
			 public final static String CMT_HIST_FILENAME		= "hibernate.history.cmt.cfg.filename";
			 public final static String JTA_HIST_FILENAME		= "hibernate.history.jta.cfg.filename";
			 public final static String DATASOURCE      		= "mgre.datasource";
			 public final static String DATASOURCE_NOXA 		= "mgre.datasourceNoXA";
			 public final static String HISTORY_DATASOURCE      = "mgre.history.datasource";
			 public final static String HISTORY_DATASOURCE_NOXA = "mgre.history.datasourceNoXA";
		 }
		 
		 public static interface Providers {
			 public final static String URL_MANAGED1	= "server.managed1.provider_url";
			 public final static String URL_MANAGED2	= "server.managed2.provider_url";
		 }
		 
		 public static interface Activity {
			 public final static String GETFILE_CCS_RETRY	= "activity.getFileCCS.retry";
			 public final static String SYNC_CCS_INTERVAL_DAYS	= "activity.synchronizes.ccs.interval.days";
			 
			 public static interface MonthlyMeasure {
				 public final static String FORCED_LAST_DAY_BE = "activity.monthlyMeasures.forcedLastDayOfBE";
				 public final static String OFFSET_FINE_ULTIMO_CICLO = "readings.monthlymeasures.offsetFineUltimoCiclo";
				 public final static String DEFAULT_LAST_DAY_OF_MONTH = "readings.monthlymeasures.defaultLastDayOfMonth";
			 }
		 }
		 
		 public static interface GenericFlow {
			 public final static String maxNumFiles = "flussi_esportazione_dati.MAX_NUM_FILE";
		 }
		 
		 public static interface TimerManager {
			 public final static String TASKCLEAN_ENABLED = "timer.taskcleaner.enabled";
			 public final static String TASKCLEAN_TIMER_PERIOD_SEC = "timer.taskcleaner.period.seconds";
		 }
		 
		 public static interface Task {
			 public final static String RETRIEVE_READINGS_SINGLE_TASK_ENABLED = "task.retrieveReadings.singleTask.enabled";
			 public final static String TASK_LIST_DISABLED = "task.list.disabled";
			 public final static String MAX_TASK_RECIPIENT = "task.maxRecipient";
			 public final static String SUBTASK_NUMBER = "subtask.number";
		 }
		 
		 public static interface ExportToFile { 
			 public final static String EF_METERSREGISTRYVARIATION_DAYSBACK	= "export.file.metersregistryvariation.daysback";
			 public final static String EF_METERSREGISTRYVARIATION_NUMDAYS	= "export.file.metersregistryvariation.numdays";
			 
			 public final static String EF_PHASEMETERS		        = "export.file.phasemeters.enabled";
			 public final static String EF_METERSREGISTRYVARIATION	= "export.file.metersregistryvariation.enabled";
			 public final static String EF_LOADCURVES_ENABLED		= "export.file.loadcurves.enabled";
			 public final static String EF_LOADCURVES_SPEC_ENABLED  = "export.file.loadcurves.spec.enabled";
			 public final static String EF_PUNCTUAL_LOADCURVES_ENABLED  = "export.file.loadcurves.punctual.enabled";
			 public final static String EF_STATUSWORDS_ENABLED	    = "export.file.statuswords.enabled";
			 public final static String EF_MONTHLYMEASURES_ENABLED	= "export.file.monthlymeasures.enabled";
			 public final static String EF_MONTHLYMEASURES_PREVIOUS_DAYS = "export.file.monthlymeasures.previous_days";
			 public final static String EF_MONTHLYMEASURES_MAX_RECORDS = "export.file.monthlymeasures.max_records";
			 public final static String EF_MONTHLYMEASURES_METER_TYPES_USED_LIST = "export.file.monthlymeasures.meter.types.used.list";
			 public final static String EF_STATOCONCENTRATORE_PAGESIZE = "export.file.statoconcentratore.pagesize";
			 public final static String EF_VERIFICA_CONGRUENZA		   = "export.file.verificaCongruenza.enabled";
			 public final static String EF_GESTIONE_INTERRUZIONI	   = "export.file.gestioneInterruzioni.enabled";
			 public final static String EF_STATOLENNT_FILENAME		   = "export.file.statolennt.filename";
		 }
		 
		 public static interface Readings {
			 public final static String LOADCURVES_VALID_VALUE_BITMASK = "readings.loadcurves.validValue.bitMask";
			 public final static String MONTHLYMEASURE_CLEAN_TABLES = "readings.monthlymeasures.cleanTables";
			 
			 public final static String MONTHLYMEASURE_MULTI_COMPONENT_REQUEST_COMPLETENESS = "readings.monthlymeasures.multiComp.request_completeness";
			 public final static String MONTHLYMEASURE_SINGLE_COMPONENT_REQUEST_COMPLETENESS = "readings.monthlymeasures.singleComp.request_completeness";
			 public final static String MONTHLYMEASURE_COMPLETE_ENERGYCOMPONTENTS = "readings.monthlymeasures.completeEnergyComponents";
			 public final static String MONTHLYMEASURE_SAVING_RPM_FORCED = "readings.monthlymeasures.save_rpm_tables.forced";
			 
			 public final static String LOADCURVES_SEARCH_FILE_ONLY_ACQDATE  = "readings.loadcurves.searchFile.only.acqDate";
			 public final static String LOADCURVES_BACKWARD_DAYS  = "readings.loadcurves.backwarddays";
			 public final static String LOADCURVES_DIRECT_BACKWARD_DAYS = "readings.loadcurves.direct.backwarddays";
			 public final static String LOADCURVES_BACKWARD_DAYS_OFFSET_1  = "readings.loadcurves.backwarddays_offset1";
			 public final static String LOADCURVES_STATUS_IGNORED = "readings.loadcurves.status.ignored";
			 public final static String LOADCURVES_MAX_DOWNLOAD   = "readings.loadcurves.status.max_download";
			 public final static String LOADCURVES_DELAY_PLC      = "readings.loadcurves.delayPLC";
			 public final static String DEFAULT_STARTDATE_FORCED  = "readings.default.startdate_forced";
             public final static String DQN_MAX_VALID_DAYS        = "file.dqn.max_valid_days";
             public final static String DQN_MIN_VALID_DAYS        = "file.dqn.min_valid_days";
             public final static String DQN_MAX_INSERTED_RECORDS  = "file.dqn.max_inserted_records";
             //ACQUISIZIONI SETTIMANALE FILE 
    		 public final static String DEPTH_WEEKLY_QDS  = "readings.weekly.qds";
    		 public final static String WEEKLY_QDS_TRANSITORY_FIRMWARE = "readings.weekly.qds.transitory.firmware";
    		 public final static String PAGE_SIZE_WEEKLY_QDS  = "readings.weekly.pageSize";
    		 
    		//ACQUISIZIONI FILE DQD
    		 public final static String DQD_MAX_DAYS_K  = "readings.days.dqd";
             public final static String DQD_MAX_VALID_DAYS        = "file.dqd.max_valid_days";
             public final static String DQD_MIN_VALID_DAYS        = "file.dqd.min_valid_days";
    		 public final static String DQN_TYPE_INTERRUPTIONS  = "file.type.interruptions.dqn";
    		 public final static String DQD_TYPE_INTERRUPTIONS  = "file.type.interruptions.dqd";
    		 
    		 public final static String LOADCURVES_EXPORT_LENNT_SG = "readings.loadcurves.export.lennt.smartgrid";
    		 
    		 public final static String PUNCTUAL_MONTHLYREADINGS_CASCADED_CALL_ENABLED = "readings.punctual.monthlymeasures.cascaded.call.enabled";
		 }
		 
		 public static interface Synchronize {
			 public final static String DAYS_REQUIRED                    = "activity.synchronizes.ccs.interval.days";
			 public final static String SEND_CCS_GROUP_SIZE              = "activity.synchronizes.ccs.sendGroup.size";
			 public final static String SEND_DELAY_CCS_GROUP_TIME_MILLIS = "activity.synchronizes.ccs.sendGroup.delayTimeMillis";
		 }
		 
		 public final static String QUALITY_DOWNLOAD_FILE_DQN_TODAY_INCLUDED = "download.file.dqn.today_included";
		 public final static String DELAY_TASK_WAITNG_MILLISEC	= "delay.task.waiting.millisec";
		 public final static String MAX_TASKS_ON_DEMAND	= "max_tasks_on_demand";
		 public final static String MAX_ROWS_COMMITED	= "database.committed.rows.max";
		 public final static String DQF_MAX_ROWS_COMMITED	= "DQF.database.committed.rows.max";
		 public final static String PAGED_QUERY_MAX_ROWS_SELECTED	= "database.selected.maxrows";
		 public final static String START_DELAY_TASK_MSEC = "ondemand.startDelayTask.msec";
		 
		 // PER CLUSTERING INTERRUZIONI
		 public final static String SOGLIA_LINEE_ASSOCIATE = "cluster.interruzioni.cabinaApprovata.percentuale.sogliaLineeAssociate";
//		 public final static String SOGLIA_LENNT_SCARTATI = "cluster.interruzioni.cabinaApprovata.percentuale.sogliaLenntScartati";
		 public final static String DISALL_MAX_ORA_OPERATORE_LENNT_SEC = "cluster.interruzioni.orari.sec.disallineamentoMaxOperatoreLennt";
		 public final static String DISALL_MAX_DURATA_SEC = "cluster.interruzioni.durata.sec.disallineamentoMaxDurata";
		 public final static String DISTANZA_MIN_TRA_INTERRUZIONI_SEC = "cluster.interruzioni.distanza.sec.interruzioniSuccessive";
		 public final static String TOLLERANZA_REGISTRAZIONE_ORARI_SEC = "cluster.interruzioni.tolleranza.sec.registrazioneOrari";
		 public static final String	SOGLIA_DIFFER_CLUSTERS_PROVOCATE = "cluster.interruzioni.cabinaApprovata.intero.sogliaDifferenzaMaxTraClusterEProvocate";
		 public static final String MAX_NUM_EXPORT_CABINS = "cluster.interruzioni.export.maxCabins";
		 public static final String LENNT_TYPES_TO_EXCLUDE_LIST = "cluster.interruzioni.lennttype.exclude.list";
		 
		 public final static String LOADCURVES_BACKWARD_DAYS  = "readings.loadcurves.backwarddays";
		 
		 //per l'integrazione dei registri mensili con la lettura giornaliera dell'inframese piu' vicina al finemese
		 public final static String INTEGRATION_OFFSET_A_FOR_MONTHLY_READINGS_WITH_DAILY_READINGS  = "offset_mese_riferimento_integrazione_letture_mensili_con_letture_giornaliere";
		 public final static String INTEGRATION_OFFSET_B_FOR_MONTHLY_READINGS_WITH_DAILY_READINGS  = "offset_mese_corrente_integrazione_letture_mensili_con_letture_giornaliere";
		 
		 //CR23 per visualizzare/nascondere il checkbox IPM_EEA del task A130
		 public final static String VISUALIZZA_IMPEEA_REQUESTED  = "visualizza_ipm_eea_a130";

		 // CR046 Esportazione 'One-Shot' delle Curve di Carico //	 
		 public static interface OneShotExport { 
			 public final static String MAX_LENNT_XFILE ="loadcurves_export_oneshot_max_lennt_file";			 
		 }
	 }
	 
	 private final static String propFileName="startTaskMgre.properties";
	 
	 
	 private static String getPropFile() {
		 String home = System.getProperty("mgre.home");
		 String path = home + File.separator + "properties" +  File.separator + propFileName;
		 
		 return path;
	 }
	 
	 public static String makeKey(String key, Object ... parameters) {
		 String result = null;
		 if(parameters!=null && parameters.length>0) {
			 try {
				 return MessageFormat.format(key, parameters);
			 } catch (Exception e) {
				 String err = "Make key:"+key + " failed with parameters:"+parameters;
				 logger.error(err);
				 throw new RuntimeException(err,e);
			 }
		 }
		 else {
			 result = key;
		 }
		 return result;
	 }
	 
	 public synchronized static String getProperty(String key) {

		 FileInputStream fis = null;
		 File f = null;

		 try {
			 String path = getPropFile();
			 f = new File(path);
			 if(properties==null || filePropLastModified != f.lastModified() || 
				 filePropLastModifiedMainCfg != UrmConfig.getInstance().getFilePropLastModified()) {
				 fis = new FileInputStream(path);
				 properties = new Properties();
				 properties.load(fis);
				 
				 properties = UrmConfig.getInstance().replaceVariables(properties);
				 
				 filePropLastModifiedMainCfg = UrmConfig.getInstance().getFilePropLastModified();
				 
				 filePropLastModified = f.lastModified();
				 logger.debug("Loaded "+path);
			 }

			 return properties.getProperty(key);

		 } catch (Exception e) {
			 logger.warn("Property \""+key+"\" not found");
			 return null;
		 }
		 finally {
			 try{ if(fis!=null) fis.close(); } catch(IOException e) { logger.error(e.toString()); }
		 }
	 }
	 
	 public synchronized static String getProperty(String key, Object[] arguments) {

		 FileInputStream fis = null;
		 File f = null;

		 try {
			 String path = getPropFile();
			 f = new File(path);
			 if(properties==null || filePropLastModified != f.lastModified() || 
				 filePropLastModifiedMainCfg != UrmConfig.getInstance().getFilePropLastModified()) {
				 fis = new FileInputStream(path);
				 properties = new Properties();
				 properties.load(fis);
				 
				 properties = UrmConfig.getInstance().replaceVariables(properties);
				 
				 filePropLastModifiedMainCfg = UrmConfig.getInstance().getFilePropLastModified();
				 
				 filePropLastModified = f.lastModified();
				 logger.debug("Loaded "+path);
			 }
			 
			 String message=properties.getProperty(key);

			 return MessageFormat.format(message, arguments);

		 } catch (Exception e) {
			 logger.warn("Property \""+key+"\" not found");
			 return null;
		 }
		 finally {
			 try{ if(fis!=null) fis.close(); } catch(IOException e) { logger.error(e.toString()); }
		 }
	 }
	 
	 public synchronized static String getProperty(String key,String defaultValue) {
		 String value = getProperty(key);
		 return value != null && !value.equals("") ? value : defaultValue;
	 }


	 public synchronized static boolean getBooleanProperty(String key) {
		 return Boolean.valueOf(getProperty(key)).booleanValue();
	 }

	 public synchronized static boolean getBooleanProperty(String key,boolean defValue) {
			String value = getProperty(key);
			return value!=null && value.length()>0 ? Boolean.valueOf(value).booleanValue() : defValue;
	 }

	 public synchronized static int getIntProperty(String key,int defaultValue) {
		 String sValue = getProperty(key);
		 if(sValue==null || sValue.trim().length()==0 ) {
			 return defaultValue;
		 } 

		 if(sValue.toLowerCase().startsWith("0x")) {
			 return Integer.parseInt(sValue.substring(2), 16);
		 }
		 
		 return Integer.parseInt(sValue.trim());
	 }

	 public synchronized static long getLongProperty(String key,long defaultValue) {
		 String sValue = getProperty(key);
		 if(sValue==null || sValue.trim().length()==0 ) {
			 return defaultValue;
		 } 
		 
		 if(sValue.toLowerCase().startsWith("0x")) {
			 return Long.parseLong(sValue.substring(2), 16);
		 }

		 return Long.parseLong(sValue.trim());
	 }
	 
	 
	 public static boolean printDebug() {
	        if (getProperty("DEBUG_LOG").equals("ON")) {
	            return true;
	        } else {
	            return false;
	        }
	    }
}