package com.ericsson.gestionesw.persistence.dto;

import com.ericsson.gestionesw.persistence.dto.datatype.TipoUsoRel;


public class TrpsId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String code;
	private String tipoUsoRelease = null;
	private long rangeMinValue = 1;
	private String typeInstallUff = null;

	public TrpsId() {

	}

	public TrpsId(String code, TipoUsoRel tipoUsoRelease,String typeInstallUff, long rangeMinValue) {
		super();
		this.code = code;
		this.tipoUsoRelease = tipoUsoRelease.toString();
		this.rangeMinValue = rangeMinValue;
		this.typeInstallUff=typeInstallUff;
	}


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTipoUsoRelease() {
		return tipoUsoRelease;
	}

	public void setTipoUsoRelease(String tipoUsoRelease) {
		this.tipoUsoRelease = tipoUsoRelease;
	}

	public long getRangeMinValue() {
		return rangeMinValue;
	}

	public void setRangeMinValue(long rangeMinValue) {
		this.rangeMinValue = rangeMinValue;
	}

	public String getTypeInstallUff() {
		return typeInstallUff;
	}

	public void setTypeInstallUff(String typeInstallUff) {
		this.typeInstallUff = typeInstallUff;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TrpsId trpsId = (TrpsId) o;

		if (getRangeMinValue() != trpsId.getRangeMinValue()) return false;
		if (!getCode().equals(trpsId.getCode())) return false;
		if (!getTipoUsoRelease().equals(trpsId.getTipoUsoRelease())) return false;
		return getTypeInstallUff().equals(trpsId.getTypeInstallUff());
	}

	@Override
	public int hashCode() {
		int result = getCode().hashCode();
		result = 31 * result + getTipoUsoRelease().hashCode();
		result = 31 * result + (int) (getRangeMinValue() ^ (getRangeMinValue() >>> 32));
		result = 31 * result + getTypeInstallUff().hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "TrpsId{" +
				"code='" + code + '\'' +
				", tipoUsoRelease='" + tipoUsoRelease + '\'' +
				", rangeMinValue=" + rangeMinValue +
				", typeInstallUff='" + typeInstallUff + '\'' +
				'}';
	}
}