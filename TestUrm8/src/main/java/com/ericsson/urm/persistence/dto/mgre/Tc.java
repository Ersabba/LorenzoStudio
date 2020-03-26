package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import com.ericsson.urm.db.MgdbDto;

public class Tc implements Serializable, MgdbDto {
	
	private static final long serialVersionUID = 1L;
	
	private String codConcentratore = null;
	private String ipConcentratore = null;
	private String dateLastConnection = null;
	private String typeInstallUff = null;
	private String typeInstallCorr = null;
	private String dateInstallCorr = null;
	private String dateParCorr = null;
	private String dateSetCorr = null;
	private String fileOpz = null;
	private String configurazioneApn = null;
	private String preNewLennt = null;
	private String dateConfigurazioneApn = null;
	private String radiusPassword = null;
	private Long   test = null;
	private Boolean flagReboot = null;	
	private Date    timestampInvioReboot = null;
	private String  esitoInvioReboot = null;
	private String  parCkSum = null;
	private String  setCkSum = null;
	private String lastNlenntUsed = null;
	
	public Tc() {
		super();
	}	
	
	public Tc(String codConcentratore, String ipConcentratore,
			String dateLastConnection, String typeInstallUff,
			String typeInstallCorr, String dateInstallCorr,
			String dateParCorr,
			String dateSetCorr, String fileOpz, String configurazioneApn,
			String preNewLennt, String dateConfigurazioneApn,
			String radiusPassword, Long test, Boolean flagReboot,
			String parCkSum, String setCkSum, String lastRangeUsed) {
		super();
		this.codConcentratore = codConcentratore;
		this.ipConcentratore = ipConcentratore;
		this.dateLastConnection = dateLastConnection;
		this.typeInstallUff = typeInstallUff;
		this.typeInstallCorr = typeInstallCorr;
		this.dateInstallCorr = dateInstallCorr;
		this.dateParCorr = dateParCorr;
		this.dateSetCorr = dateSetCorr;
		this.fileOpz = fileOpz;
		this.configurazioneApn = configurazioneApn;
		this.preNewLennt = preNewLennt;
		this.dateConfigurazioneApn = dateConfigurazioneApn;
		this.radiusPassword = radiusPassword;
		this.test = test;
		this.flagReboot = flagReboot;
		this.parCkSum = parCkSum;
		this.setCkSum = setCkSum;
		this.lastNlenntUsed = lastRangeUsed;
	}
	
	public Object clone() {
		try {
			return super.clone();
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	public void applyAllProperties(MgdbDto srcDto) {
		Tc other = (Tc)srcDto;

		this.codConcentratore = other.codConcentratore;
		this.ipConcentratore = other.ipConcentratore;
		this.dateLastConnection = other.dateLastConnection;
		this.typeInstallUff = other.typeInstallUff;
		this.typeInstallCorr = other.typeInstallCorr;
		this.dateInstallCorr = other.dateInstallCorr;
		this.dateParCorr = other.dateParCorr;
		this.dateSetCorr = other.dateSetCorr;
		this.fileOpz = other.fileOpz;
		this.configurazioneApn = other.configurazioneApn;
		this.preNewLennt = other.preNewLennt;
		this.dateConfigurazioneApn = other.dateConfigurazioneApn;
		this.radiusPassword = other.radiusPassword;
		this.test = other.test;
		this.flagReboot = other.flagReboot;
		this.parCkSum = other.parCkSum;
		this.setCkSum = other.setCkSum;
		this.lastNlenntUsed = other.lastNlenntUsed;
	}
	
	public Serializable retrievePrimaryKey() {
		return getCodConcentratore();
	}

	public String getCodConcentratore() {
		return codConcentratore;
	}

	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}

	public String getIpConcentratore() {
		return ipConcentratore;
	}

	public void setIpConcentratore(String ipConcentratore) {
		this.ipConcentratore = ipConcentratore;
	}

	public String getDateLastConnection() {
		return dateLastConnection;
	}

	public void setDateLastConnection(String dateLastConnection) {
		this.dateLastConnection = dateLastConnection;
	}

	public String getTypeInstallUff() {
		return typeInstallUff;
	}

	public void setTypeInstallUff(String typeInstallUff) {
		this.typeInstallUff = typeInstallUff;
	}

	public String getTypeInstallCorr() {
		return typeInstallCorr;
	}

	public void setTypeInstallCorr(String typeInstallCorr) {
		this.typeInstallCorr = typeInstallCorr;
	}

	public String getDateInstallCorr() {
		return dateInstallCorr;
	}

	public void setDateInstallCorr(String dateInstallCorr) {
		this.dateInstallCorr = dateInstallCorr;
	}

	public String getDateParCorr() {
		return dateParCorr;
	}

	public void setDateParCorr(String dateParCorr) {
		this.dateParCorr = dateParCorr;
	}

	public String getDateSetCorr() {
		return dateSetCorr;
	}

	public void setDateSetCorr(String dateSetCorr) {
		this.dateSetCorr = dateSetCorr;
	}

	public String getFileOpz() {
		return fileOpz;
	}

	public void setFileOpz(String fileOpz) {
		this.fileOpz = fileOpz;
	}

	public String getConfigurazioneApn() {
		return configurazioneApn;
	}

	public void setConfigurazioneApn(String configurazioneApn) {
		this.configurazioneApn = configurazioneApn;
	}

	public String getPreNewLennt() {
		return preNewLennt;
	}

	public void setPreNewLennt(String preNewLennt) {
		this.preNewLennt = preNewLennt;
	}

	public String getDateConfigurazioneApn() {
		return dateConfigurazioneApn;
	}

	public void setDateConfigurazioneApn(String dateConfigurazioneApn) {
		this.dateConfigurazioneApn = dateConfigurazioneApn;
	}

	public String getRadiusPassword() {
		return radiusPassword;
	}

	public void setRadiusPassword(String radiusPassword) {
		this.radiusPassword = radiusPassword;
	}

	public Long getTest() {
		return test;
	}

	public void setTest(Long test) {
		this.test = test;
	}

	public Boolean getFlagReboot() {
		return flagReboot;
	}

	public void setFlagReboot(Boolean flagReboot) {
		this.flagReboot = flagReboot;
	}
	
	public Date getTimestampInvioReboot() {
		return timestampInvioReboot;
	}

	public void setTimestampInvioReboot(Date timestampInvioReboot) {
		this.timestampInvioReboot = timestampInvioReboot;
	}

	public String getEsitoInvioReboot() {
		return esitoInvioReboot;
	}

	public void setEsitoInvioReboot(String esitoInvioReboot) {
		this.esitoInvioReboot = esitoInvioReboot;
	}

	public String getParCkSum() {
		return parCkSum;
	}

	public void setParCkSum(String parCkSum) {
		this.parCkSum = parCkSum;
	}

	public String getSetCkSum() {
		return setCkSum;
	}

	public void setSetCkSum(String setCkSum) {
		this.setCkSum = setCkSum;
	}

	public String getLastNlenntUsed() {
		return lastNlenntUsed;
	}

	public void setLastNlenntUsed(String lastNlenntUsed) {
		this.lastNlenntUsed = lastNlenntUsed;
	}
	@Override
	public String toString() {
		return "Tc [codConcentratore=" + codConcentratore + ", ipConcentratore=" + ipConcentratore
				+ ", dateLastConnection=" + dateLastConnection + ", typeInstallUff=" + typeInstallUff
				+ ", typeInstallCorr=" + typeInstallCorr + ", dateInstallCorr=" + dateInstallCorr + ", dateParCorr="
				+ dateParCorr + ", dateSetCorr=" + dateSetCorr + ", fileOpz=" + fileOpz + ", configurazioneApn="
				+ configurazioneApn + ", preNewLennt=" + preNewLennt + ", dateConfigurazioneApn="
				+ dateConfigurazioneApn + ", radiusPassword=" + radiusPassword + ", test=" + test + ", flagReboot="
				+ flagReboot + ", timestampInvioReboot=" + timestampInvioReboot + ", esitoInvioReboot="
				+ esitoInvioReboot + ", parCkSum=" + parCkSum + ", setCkSum=" + setCkSum + ", lastNlenntUsed="
				+ lastNlenntUsed + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((codConcentratore == null) ? 0 : codConcentratore.hashCode());
		result = prime
				* result
				+ ((configurazioneApn == null) ? 0 : configurazioneApn
						.hashCode());
		result = prime
				* result
				+ ((dateConfigurazioneApn == null) ? 0 : dateConfigurazioneApn
						.hashCode());
		result = prime * result
				+ ((dateInstallCorr == null) ? 0 : dateInstallCorr.hashCode());
		result = prime
				* result
				+ ((dateLastConnection == null) ? 0 : dateLastConnection
						.hashCode());
		result = prime * result
				+ ((dateParCorr == null) ? 0 : dateParCorr.hashCode());
		result = prime * result
				+ ((dateSetCorr == null) ? 0 : dateSetCorr.hashCode());
		result = prime
				* result
				+ ((esitoInvioReboot == null) ? 0 : esitoInvioReboot.hashCode());
		result = prime * result + ((fileOpz == null) ? 0 : fileOpz.hashCode());
		result = prime * result
				+ ((flagReboot == null) ? 0 : flagReboot.hashCode());
		result = prime * result
				+ ((ipConcentratore == null) ? 0 : ipConcentratore.hashCode());
		result = prime * result
				+ ((parCkSum == null) ? 0 : parCkSum.hashCode());
		result = prime * result
				+ ((preNewLennt == null) ? 0 : preNewLennt.hashCode());
		result = prime * result
				+ ((radiusPassword == null) ? 0 : radiusPassword.hashCode());
		result = prime * result
				+ ((setCkSum == null) ? 0 : setCkSum.hashCode());
		result = prime * result + ((test == null) ? 0 : test.hashCode());
		result = prime
				* result
				+ ((timestampInvioReboot == null) ? 0 : timestampInvioReboot
						.hashCode());
		result = prime * result
				+ ((typeInstallCorr == null) ? 0 : typeInstallCorr.hashCode());
		result = prime * result
				+ ((typeInstallUff == null) ? 0 : typeInstallUff.hashCode());
		result = prime * result
				+ ((lastNlenntUsed == null) ? 0 : lastNlenntUsed.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tc other = (Tc) obj;
		if (codConcentratore == null) {
			if (other.codConcentratore != null)
				return false;
		} else if (!codConcentratore.equals(other.codConcentratore))
			return false;
		if (configurazioneApn == null) {
			if (other.configurazioneApn != null)
				return false;
		} else if (!configurazioneApn.equals(other.configurazioneApn))
			return false;
		if (dateConfigurazioneApn == null) {
			if (other.dateConfigurazioneApn != null)
				return false;
		} else if (!dateConfigurazioneApn.equals(other.dateConfigurazioneApn))
			return false;
		if (dateInstallCorr == null) {
			if (other.dateInstallCorr != null)
				return false;
		} else if (!dateInstallCorr.equals(other.dateInstallCorr))
			return false;
		if (dateLastConnection == null) {
			if (other.dateLastConnection != null)
				return false;
		} else if (!dateLastConnection.equals(other.dateLastConnection))
			return false;
		if (dateParCorr == null) {
			if (other.dateParCorr != null)
				return false;
		} else if (!dateParCorr.equals(other.dateParCorr))
			return false;
		if (dateSetCorr == null) {
			if (other.dateSetCorr != null)
				return false;
		} else if (!dateSetCorr.equals(other.dateSetCorr))
			return false;
		if (esitoInvioReboot == null) {
			if (other.esitoInvioReboot != null)
				return false;
		} else if (!esitoInvioReboot.equals(other.esitoInvioReboot))
			return false;
		if (fileOpz == null) {
			if (other.fileOpz != null)
				return false;
		} else if (!fileOpz.equals(other.fileOpz))
			return false;
		if (flagReboot == null) {
			if (other.flagReboot != null)
				return false;
		} else if (!flagReboot.equals(other.flagReboot))
			return false;
		if (ipConcentratore == null) {
			if (other.ipConcentratore != null)
				return false;
		} else if (!ipConcentratore.equals(other.ipConcentratore))
			return false;
		if (parCkSum == null) {
			if (other.parCkSum != null)
				return false;
		} else if (!parCkSum.equals(other.parCkSum))
			return false;
		if (preNewLennt == null) {
			if (other.preNewLennt != null)
				return false;
		} else if (!preNewLennt.equals(other.preNewLennt))
			return false;
		if (radiusPassword == null) {
			if (other.radiusPassword != null)
				return false;
		} else if (!radiusPassword.equals(other.radiusPassword))
			return false;
		if (setCkSum == null) {
			if (other.setCkSum != null)
				return false;
		} else if (!setCkSum.equals(other.setCkSum))
			return false;
		if (test == null) {
			if (other.test != null)
				return false;
		} else if (!test.equals(other.test))
			return false;
		if (timestampInvioReboot == null) {
			if (other.timestampInvioReboot != null)
				return false;
		} else if (!timestampInvioReboot.equals(other.timestampInvioReboot))
			return false;
		if (typeInstallCorr == null) {
			if (other.typeInstallCorr != null)
				return false;
		} else if (!typeInstallCorr.equals(other.typeInstallCorr))
			return false;
		if (typeInstallUff == null) {
			if (other.typeInstallUff != null)
				return false;
		} else if (!typeInstallUff.equals(other.typeInstallUff))
			return false;
		if (lastNlenntUsed == null) {
				if (other.lastNlenntUsed != null)
					return false;
		}else if (!lastNlenntUsed.equals(other.lastNlenntUsed)) 
			return false;
		
		
		return true;
	}
	
	
}
