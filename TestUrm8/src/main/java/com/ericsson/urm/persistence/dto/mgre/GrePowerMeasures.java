package com.ericsson.urm.persistence.dto.mgre;

public class GrePowerMeasures implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private Long taskid;
	private String device;
	private String active;
	private String inductive;
	private String capacitive;
	private Long activetimestamp;
	private Long inductivetimestamp;
	private Long capacitivetimestamp;
	private String type;
	private String qualification;
	private String period;
	private String integrationperiod;
	private String rate;
	private String measuretype;

	public GrePowerMeasures() {
	}

	public GrePowerMeasures(long id, String type, String qualification) {
		this.id = id;
		this.type = type;
		this.qualification = qualification;
	}

	public GrePowerMeasures(long id, Long taskid, String device, String active, String inductive, String capacitive,
			Long activetimestamp, Long inductivetimestamp, Long capacitivetimestamp, String type, String qualification,
			String period, String integrationperiod, String rate, String measuretype) {
		this.id = id;
		this.taskid = taskid;
		this.device = device;
		this.active = active;
		this.inductive = inductive;
		this.capacitive = capacitive;
		this.activetimestamp = activetimestamp;
		this.inductivetimestamp = inductivetimestamp;
		this.capacitivetimestamp = capacitivetimestamp;
		this.type = type;
		this.qualification = qualification;
		this.period = period;
		this.integrationperiod = integrationperiod;
		this.rate = rate;
		this.measuretype = measuretype;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getTaskid() {
		return this.taskid;
	}

	public void setTaskid(Long taskid) {
		this.taskid = taskid;
	}

	public String getDevice() {
		return this.device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getInductive() {
		return this.inductive;
	}

	public void setInductive(String inductive) {
		this.inductive = inductive;
	}

	public String getCapacitive() {
		return this.capacitive;
	}

	public void setCapacitive(String capacitive) {
		this.capacitive = capacitive;
	}

	public Long getActivetimestamp() {
		return this.activetimestamp;
	}

	public void setActivetimestamp(Long activetimestamp) {
		this.activetimestamp = activetimestamp;
	}

	public Long getInductivetimestamp() {
		return this.inductivetimestamp;
	}

	public void setInductivetimestamp(Long inductivetimestamp) {
		this.inductivetimestamp = inductivetimestamp;
	}

	public Long getCapacitivetimestamp() {
		return this.capacitivetimestamp;
	}

	public void setCapacitivetimestamp(Long capacitivetimestamp) {
		this.capacitivetimestamp = capacitivetimestamp;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getQualification() {
		return this.qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getPeriod() {
		return this.period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getIntegrationperiod() {
		return this.integrationperiod;
	}

	public void setIntegrationperiod(String integrationperiod) {
		this.integrationperiod = integrationperiod;
	}

	public String getRate() {
		return this.rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getMeasuretype() {
		return this.measuretype;
	}

	public void setMeasuretype(String measuretype) {
		this.measuretype = measuretype;
	}

	@Override
	public String toString() {
		return "GrePowerMeasures [id=" + id + ", taskid=" + taskid + ", device=" + device + ", active=" + active
				+ ", inductive=" + inductive + ", capacitive=" + capacitive + ", activetimestamp=" + activetimestamp
				+ ", inductivetimestamp=" + inductivetimestamp + ", capacitivetimestamp=" + capacitivetimestamp
				+ ", type=" + type + ", qualification=" + qualification + ", period=" + period + ", integrationperiod="
				+ integrationperiod + ", rate=" + rate + ", measuretype=" + measuretype + "]";
	}
}
