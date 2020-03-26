package com.ericsson.mgre.biz.taskMgmt.addinfo;

import java.util.Set;

public interface AddInfo {
	public static interface Keys {
		public final static String DATE_ACQ="DATE_ACQ";

		public static interface StatusWordCCS {
			public final static String EXPORT_ENABLED="export_enabled";
		}
		public static interface MetersRegistry {
			public final static String OBJ_METER_REGISTRY_PARAMETERS="MetersRegistryParameters";
		}
		public static interface UpdateDisplayMeter {
			public final static String OBJ_DISPLAY_METER_PARAMETERS="DisplayMeterParameters";
		}
		public static interface LoadCurvesAddInfo {
			public final static String OBJ_LOADCURVES_ADDINFO="LoadCurvesAddInfo";
		}
		public static interface MonthlyMeasureAddInfo {
			public final static String OBJ_EXTRA_PARAMS="MonthlyMeasuresExtraParams";
		}
		public static interface MissingLoadCurvesAddInfo {
			public final static String OBJ_MISSING_LOADCURVES_ADDINFO="MissingLoadCurvesAddInfo";
		}
		public static interface SubdailyActivityAddInfo {
			public final static String OBJ_SUBDAILY_ACTIVITY_ADDINFO="SubdailyActivityAddInfo";
		}
		public static interface TaskOnDemandAddInfo {
			public final static String OBJ_RETRIEVE_READINGS_ADDINFO="RetrieveReadingsAddInfo";
		}
		public static interface ThorAddInfo {
			public final static String OBJ_THOR_ADDINFO="ThorAddInfo";
		}
		

		public static interface LoadUtenzeCMAddInfo {
			public final static String OBJ_UTENZECM_LIST_ADDINFO="ListaUtenzeCM";
			public final static String OBJ_UTENZECM_OPERATOR_ADDINFO="OperatoreUtenzeCM";
			public final static String OBJ_UTENZECM_FILENAME_ADDINFO="FileNameUtenzeCM";
			public final static String OBJ_UTENZECM_LOCAL_DONE_DIR = "LocalDoneDirUtenzeCM";
			public final static String OBJ_UTENZECM_LOCAL_ERROR_DIR = "LocalErrorDirUtenzeCM";
		}
		public static interface LoadCdcAddInfo {
			public final static String OBJ_LOADCDC_LIST_ADDINFO="ListaCdcAbilDiretta";
			public final static String OBJ_LOADCDC_OPERATOR_ADDINFO="OperatoreCdcAbilDiretta";
			public final static String OBJ_LOADCDC_FILENAME_ADDINFO="FileNameCdcAbilDiretta";
			public final static String OBJ_LOADCDC_LOCAL_DONE_DIR = "LocalDoneDirCdcAbilDiretta";
			public final static String OBJ_LOADCDC_LOCAL_ERROR_DIR = "LocalErrorDirCdcAbilDiretta";
		}
	}

	public int size();

	public Set entrySet();

	public Set keySet();

	public boolean containsKey(Object key);

	public Object getProperty(Object key);
}
