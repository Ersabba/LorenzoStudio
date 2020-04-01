package com.ericsson.urm.persistence.dto;

import java.io.Serializable;
import java.util.Date;


public class ProfiloTensioneCorrente implements Serializable {

	private static final long	serialVersionUID	= 1L;

	// ENUMERATIONS
	public static enum AcquisitionMode {
		DA_FILE,
		DA_LENNT;

		public static AcquisitionMode parse(String acquisitionMode) {
			if(acquisitionMode!=null) {
				for (AcquisitionMode am : AcquisitionMode.values()) {
					if (am.toString().equalsIgnoreCase(acquisitionMode)) {
						return am;
					}
				}
			}
			throw new IllegalArgumentException("Invalid acquisition mode: "+acquisitionMode);
		}
	}

	private ProfiloTensioneCorrenteId	id;
	private String						codConcentratore;
	private Date						acquisitionDate;
	private String						acquisitionMode;
	private String						fileName;
	private Integer						profiloPeriodo_01;
	private Integer						profiloPeriodo_02;
	private Integer						profiloPeriodo_03;
	private Integer						profiloPeriodo_04;
	private Integer						profiloPeriodo_05;
	private Integer						profiloPeriodo_06;
	private Integer						profiloPeriodo_07;
	private Integer						profiloPeriodo_08;
	private Integer						profiloPeriodo_09;
	private Integer						profiloPeriodo_10;
	private Integer						profiloPeriodo_11;
	private Integer						profiloPeriodo_12;
	private Date						timestampExport;



	public ProfiloTensioneCorrenteId getId() {
		return id;
	}

	public void setId(ProfiloTensioneCorrenteId id) {
		this.id = id;
	}

	public String getCodConcentratore() {
		return codConcentratore;
	}

	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}

	public Date getAcquisitionDate() {
		return acquisitionDate;
	}

	public void setAcquisitionDate(Date acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}

	public AcquisitionMode getAcquisitionMode() {
		return (acquisitionMode != null) ? AcquisitionMode.parse(acquisitionMode) : null;
	}

	public void setAcquisitionMode(AcquisitionMode acquisitionMode) {

		this.acquisitionMode = acquisitionMode!=null ? acquisitionMode.toString() : null;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getProfiloPeriodo_01() {
		return profiloPeriodo_01;
	}

	public void setProfiloPeriodo_01(Integer profiloPeriodo_01) {
		this.profiloPeriodo_01 = profiloPeriodo_01;
	}

	public Integer getProfiloPeriodo_02() {
		return profiloPeriodo_02;
	}

	public void setProfiloPeriodo_02(Integer profiloPeriodo_02) {
		this.profiloPeriodo_02 = profiloPeriodo_02;
	}

	public Integer getProfiloPeriodo_03() {
		return profiloPeriodo_03;
	}

	public void setProfiloPeriodo_03(Integer profiloPeriodo_03) {
		this.profiloPeriodo_03 = profiloPeriodo_03;
	}

	public Integer getProfiloPeriodo_04() {
		return profiloPeriodo_04;
	}

	public void setProfiloPeriodo_04(Integer profiloPeriodo_04) {
		this.profiloPeriodo_04 = profiloPeriodo_04;
	}

	public Integer getProfiloPeriodo_05() {
		return profiloPeriodo_05;
	}

	public void setProfiloPeriodo_05(Integer profiloPeriodo_05) {
		this.profiloPeriodo_05 = profiloPeriodo_05;
	}

	public Integer getProfiloPeriodo_06() {
		return profiloPeriodo_06;
	}

	public void setProfiloPeriodo_06(Integer profiloPeriodo_06) {
		this.profiloPeriodo_06 = profiloPeriodo_06;
	}

	public Integer getProfiloPeriodo_07() {
		return profiloPeriodo_07;
	}

	public void setProfiloPeriodo_07(Integer profiloPeriodo_07) {
		this.profiloPeriodo_07 = profiloPeriodo_07;
	}

	public Integer getProfiloPeriodo_08() {
		return profiloPeriodo_08;
	}

	public void setProfiloPeriodo_08(Integer profiloPeriodo_08) {
		this.profiloPeriodo_08 = profiloPeriodo_08;
	}

	public Integer getProfiloPeriodo_09() {
		return profiloPeriodo_09;
	}

	public void setProfiloPeriodo_09(Integer profiloPeriodo_09) {
		this.profiloPeriodo_09 = profiloPeriodo_09;
	}

	public Integer getProfiloPeriodo_10() {
		return profiloPeriodo_10;
	}

	public void setProfiloPeriodo_10(Integer profiloPeriodo_10) {
		this.profiloPeriodo_10 = profiloPeriodo_10;
	}

	public Integer getProfiloPeriodo_11() {
		return profiloPeriodo_11;
	}

	public void setProfiloPeriodo_11(Integer profiloPeriodo_11) {
		this.profiloPeriodo_11 = profiloPeriodo_11;
	}

	public Integer getProfiloPeriodo_12() {
		return profiloPeriodo_12;
	}

	public void setProfiloPeriodo_12(Integer profiloPeriodo_12) {
		this.profiloPeriodo_12 = profiloPeriodo_12;
	}

	public Date getTimestampExport() {
		return timestampExport;
	}

	public void setTimestampExport(Date timestampExport) {
		this.timestampExport = timestampExport;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((acquisitionDate == null) ? 0 : acquisitionDate.hashCode());
		result = prime * result
				+ ((acquisitionMode == null) ? 0 : acquisitionMode.hashCode());
		result = prime
				* result
				+ ((codConcentratore == null) ? 0 : codConcentratore.hashCode());
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((profiloPeriodo_01 == null) ? 0 : profiloPeriodo_01
						.hashCode());
		result = prime
				* result
				+ ((profiloPeriodo_02 == null) ? 0 : profiloPeriodo_02
						.hashCode());
		result = prime
				* result
				+ ((profiloPeriodo_03 == null) ? 0 : profiloPeriodo_03
						.hashCode());
		result = prime
				* result
				+ ((profiloPeriodo_04 == null) ? 0 : profiloPeriodo_04
						.hashCode());
		result = prime
				* result
				+ ((profiloPeriodo_05 == null) ? 0 : profiloPeriodo_05
						.hashCode());
		result = prime
				* result
				+ ((profiloPeriodo_06 == null) ? 0 : profiloPeriodo_06
						.hashCode());
		result = prime
				* result
				+ ((profiloPeriodo_07 == null) ? 0 : profiloPeriodo_07
						.hashCode());
		result = prime
				* result
				+ ((profiloPeriodo_08 == null) ? 0 : profiloPeriodo_08
						.hashCode());
		result = prime
				* result
				+ ((profiloPeriodo_09 == null) ? 0 : profiloPeriodo_09
						.hashCode());
		result = prime
				* result
				+ ((profiloPeriodo_10 == null) ? 0 : profiloPeriodo_10
						.hashCode());
		result = prime
				* result
				+ ((profiloPeriodo_11 == null) ? 0 : profiloPeriodo_11
						.hashCode());
		result = prime
				* result
				+ ((profiloPeriodo_12 == null) ? 0 : profiloPeriodo_12
						.hashCode());
		result = prime * result
				+ ((timestampExport == null) ? 0 : timestampExport.hashCode());
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
		ProfiloTensioneCorrente other = (ProfiloTensioneCorrente) obj;
		if (acquisitionDate == null) {
			if (other.acquisitionDate != null)
				return false;
		} else if (!acquisitionDate.equals(other.acquisitionDate))
			return false;
		if (acquisitionMode == null) {
			if (other.acquisitionMode != null)
				return false;
		} else if (!acquisitionMode.equals(other.acquisitionMode))
			return false;
		if (codConcentratore == null) {
			if (other.codConcentratore != null)
				return false;
		} else if (!codConcentratore.equals(other.codConcentratore))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (profiloPeriodo_01 == null) {
			if (other.profiloPeriodo_01 != null)
				return false;
		} else if (!profiloPeriodo_01.equals(other.profiloPeriodo_01))
			return false;
		if (profiloPeriodo_02 == null) {
			if (other.profiloPeriodo_02 != null)
				return false;
		} else if (!profiloPeriodo_02.equals(other.profiloPeriodo_02))
			return false;
		if (profiloPeriodo_03 == null) {
			if (other.profiloPeriodo_03 != null)
				return false;
		} else if (!profiloPeriodo_03.equals(other.profiloPeriodo_03))
			return false;
		if (profiloPeriodo_04 == null) {
			if (other.profiloPeriodo_04 != null)
				return false;
		} else if (!profiloPeriodo_04.equals(other.profiloPeriodo_04))
			return false;
		if (profiloPeriodo_05 == null) {
			if (other.profiloPeriodo_05 != null)
				return false;
		} else if (!profiloPeriodo_05.equals(other.profiloPeriodo_05))
			return false;
		if (profiloPeriodo_06 == null) {
			if (other.profiloPeriodo_06 != null)
				return false;
		} else if (!profiloPeriodo_06.equals(other.profiloPeriodo_06))
			return false;
		if (profiloPeriodo_07 == null) {
			if (other.profiloPeriodo_07 != null)
				return false;
		} else if (!profiloPeriodo_07.equals(other.profiloPeriodo_07))
			return false;
		if (profiloPeriodo_08 == null) {
			if (other.profiloPeriodo_08 != null)
				return false;
		} else if (!profiloPeriodo_08.equals(other.profiloPeriodo_08))
			return false;
		if (profiloPeriodo_09 == null) {
			if (other.profiloPeriodo_09 != null)
				return false;
		} else if (!profiloPeriodo_09.equals(other.profiloPeriodo_09))
			return false;
		if (profiloPeriodo_10 == null) {
			if (other.profiloPeriodo_10 != null)
				return false;
		} else if (!profiloPeriodo_10.equals(other.profiloPeriodo_10))
			return false;
		if (profiloPeriodo_11 == null) {
			if (other.profiloPeriodo_11 != null)
				return false;
		} else if (!profiloPeriodo_11.equals(other.profiloPeriodo_11))
			return false;
		if (profiloPeriodo_12 == null) {
			if (other.profiloPeriodo_12 != null)
				return false;
		} else if (!profiloPeriodo_12.equals(other.profiloPeriodo_12))
			return false;
		if (timestampExport == null) {
			if (other.timestampExport != null)
				return false;
		} else if (!timestampExport.equals(other.timestampExport))
			return false;
		return true;
	}	
}
