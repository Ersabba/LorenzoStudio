package com.ericsson.urm.device.driver.ftp.parser.ccs;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.device.driver.ftp.datatype.StatusWordBits;


public interface VoltageProfile extends Serializable {
	
	public static enum TipoFase {
		R,S,T, UNKNOWN;		
	}
	
	public static enum TipoProfilo {
		V, I, UNKNOWN;	
	}
	
	public static interface StatoMisura extends Serializable {
		public boolean isPowerFAilIP();
		public boolean isPartialProcessing();
		public boolean isPresent();
		public int getValue();
		public byte asByte();
	}
	
	public static interface ProfiloMisura extends Serializable {
		public StatoMisura getStatoMisura();
		public int getValoreInDecimi();
	}
	
	public String getMatrLennt();
	
	
	public int getStatoDati();


	public String getCmd();
	

	public StatusWordBits getStatusWordBits();
	

	public Date getDataProfilo();


	public TipoProfilo getTipoProfilo();
	
	
	public TipoFase getTipoFase();


	public int getPeriodo();


	public ProfiloMisura[] getProfiliMisure();
	
	
	public String getErrorCode();


	public boolean isValidMeter();
}
