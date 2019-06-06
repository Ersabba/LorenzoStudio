package com.ericsson.gestionesw.persistence.dto;

public class TrpsView implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	private TrpsId trpsId         = null;
	private String typeInstallUff = null;
	private String fileName       = null;
	private String checkSum       = null;
	private long   rangeMaxValue;

	public TrpsView(){
		super();
	}

	public TrpsView(TrpsId trpsId, String typeInstallUff, String fileName,
                    String checkSum, long rangeMaxValue) {
		super();
		this.trpsId = trpsId;
		this.typeInstallUff = typeInstallUff;
		this.fileName = fileName;
		this.checkSum = checkSum;
		this.rangeMaxValue=rangeMaxValue;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public TrpsId getTrpsId() {
		return trpsId;
	}

	public void setTrpsId(TrpsId trpsId) {
		this.trpsId = trpsId;
	}

	public String getTypeInstallUff() {
		return typeInstallUff;
	}

	public void setTypeInstallUff(String typeInstallUff) {
		this.typeInstallUff = typeInstallUff;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCheckSum() {
		return checkSum;
	}

	public void setCheckSum(String checkSum) {
		this.checkSum = checkSum;
	}

	public long getRangeMaxValue() {
		return rangeMaxValue;
	}

	public void setRangeMaxValue(long rangeMaxValue) {
		this.rangeMaxValue = rangeMaxValue;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TrpsView trps = (TrpsView) o;

		if (getRangeMaxValue() != trps.getRangeMaxValue()) return false;
		if (!getTrpsId().equals(trps.getTrpsId())) return false;
		if (!getTypeInstallUff().equals(trps.getTypeInstallUff())) return false;
		if (!getFileName().equals(trps.getFileName())) return false;
		return getCheckSum().equals(trps.getCheckSum());
	}

	@Override
	public int hashCode() {
		int result = getTrpsId().hashCode();
		result = 31 * result + getTypeInstallUff().hashCode();
		result = 31 * result + getFileName().hashCode();
		result = 31 * result + getCheckSum().hashCode();
		result = 31 * result + (int) (getRangeMaxValue() ^ (getRangeMaxValue() >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "Trps{" +
				"trpsId=" + trpsId +
				", typeInstallUff='" + typeInstallUff + '\'' +
				", fileName='" + fileName + '\'' +
				", checkSum='" + checkSum + '\'' +
				", rangeMaxValue=" + rangeMaxValue +
				'}';
	}
}