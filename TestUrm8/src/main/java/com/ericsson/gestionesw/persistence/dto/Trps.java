package com.ericsson.gestionesw.persistence.dto;

public class Trps implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	private TrpsId trpsId         = null;
	private String fileName       = null;
	private String checkSum       = null;
	private long   rangeMaxValue;

	public Trps(){
		super();
	}

	public Trps(TrpsId trpsId,  String fileName,
				String checkSum, long rangeMaxValue) {
		super();
		this.trpsId = trpsId;
		this.fileName = fileName;
		this.checkSum = checkSum;
		this.rangeMaxValue=rangeMaxValue;
	}

	public TrpsId getTrpsId() {
		return trpsId;
	}

	public void setTrpsId(TrpsId trpsId) {
		this.trpsId = trpsId;
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

		Trps trps = (Trps) o;

		if (rangeMaxValue != trps.rangeMaxValue) return false;
		if (!trpsId.equals(trps.trpsId)) return false;
		if (!fileName.equals(trps.fileName)) return false;
		return checkSum.equals(trps.checkSum);
	}

	@Override
	public int hashCode() {
		int result = trpsId.hashCode();
		result = 31 * result + fileName.hashCode();
		result = 31 * result + checkSum.hashCode();
		result = 31 * result + (int) (rangeMaxValue ^ (rangeMaxValue >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "Trps{" +
				"trpsId=" + trpsId +
				", fileName='" + fileName + '\'' +
				", checkSum='" + checkSum + '\'' +
				", rangeMaxValue=" + rangeMaxValue +
				'}';
	}
}