package com.ericsson.urm.device.driver.ftp.datatype.ccs;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum FileType {
	CURRENT_VOLTAGE_PROFILE("G_VI"),
	DAILY_LENNT_STATUSWORD("G_PDS"),
	DAILY_REGISTER_EEA("G_EEA"),
	DAILY_REGISTER_E23("G_E23"),
	DAILY_REGISTER_Q14("G_Q14"),
	MONTHLY_REGISTER_EEA("M_EEA"),
	MONTHLY_REGISTER_E23("M_E23"),
	MONTHLY_REGISTER_Q14("M_Q14"),
	MONTHLY_POWER_EEA("M_PAX"),
	FILE_ADDRESS("ADD_CFG"),
	LOADCURVES_ECC("O_ECC"),
	LOADCURVES_EE("O_EE"),
	LOADCURVES_RAI("O_RAI"),
	LOADCURVES_REI("O_REI"),
	LOADCURVES_RAC("O_RAC"),
	LOADCURVES_REC("O_REC"),
	VERIF_CONGR_GEST_FORN("A_027"),
	FILENEW("NW_CFG"),
	FILE_ROUTING("ROU_CFG"),
	FILE_COM("COM_NEW"),
	FILE_DEM("DEM_DAT");
	
	private String code;
	
	private FileType(String code) {
		this.code = code;
	}

	
	public String getCode() {
		return code;
	}


	public static FileType parser(String name) {
		if(name==null || name.trim().length()==0) {
			throw new IllegalArgumentException("Passed undefined argument: name");
		}
		
		for(FileType fileType : FileType.values()) {
			if(fileType.code.equalsIgnoreCase(name)) {
				return fileType;
			}
		}
		
		File file = new File(name);
		String fname = file.getName();
		Pattern p = Pattern.compile("^([a-zA-Z]{3}|\\w)\\w+\\.([a-zA-Z0-9]+)$");
		Matcher m = p.matcher(fname);
		
		if(!m.find()) {
			throw new IllegalArgumentException("Unknown FileType or fileName: "+name);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(m.group(1));
		if(m.groupCount()>1 && m.group(2)!=null) {
			sb.append("_");
			sb.append(m.group(2));
		}
		
		String code = sb.toString().toUpperCase();
		
		for(FileType fileType : FileType.values()) {
			if(fileType.code.equalsIgnoreCase(code)) {
				return fileType;
			}
		}
		throw new IllegalArgumentException("Unknown FileType or FileType: "+name);
	}
	
}

