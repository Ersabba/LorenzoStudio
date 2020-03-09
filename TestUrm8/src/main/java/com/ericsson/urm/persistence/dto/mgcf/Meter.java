package com.ericsson.urm.persistence.dto.mgcf;

import java.io.Serializable;

import com.ericsson.urm.db.MgdbDto;

public class Meter implements Serializable, MgdbDto{

	private static final long serialVersionUID = 1L;
	
	private long idRequest=-1;
	private String meterId=null;
	private String meterSet=null;
	private String consumerTerminalId=null;
	private Integer integrationPeriod=null;
	
	public Meter() {
		super();
	}

	public Meter(long idRequest) {
		super();
		this.idRequest = idRequest;
	}

	public Meter(long idRequest, String meterId, String meterSet,
			String consumerTerminalId, Integer integrationPeriod) {
		super();
		this.idRequest = idRequest;
		this.meterId = meterId;
		this.meterSet = meterSet;
		this.consumerTerminalId = consumerTerminalId;
		
		this.integrationPeriod = integrationPeriod;
	}
	
	public void applyAllProperties(MgdbDto srcDto) {
		Meter other = (Meter)srcDto;
		
		this.idRequest = other.idRequest;
		this.meterId = other.meterId;
		this.meterSet = other.meterSet;
		this.consumerTerminalId = other.consumerTerminalId;
		this.integrationPeriod = other.integrationPeriod;
	}

	public Object clone() {
		try {
			Meter meter = (Meter) super.clone();
			return meter;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	public Serializable retrievePrimaryKey() {
		return new Long(getIdRequest());
	}
	
	public long getIdRequest() {
		return idRequest;
	}

	public void setIdRequest(long idRequest) {
		this.idRequest = idRequest;
	}

	public String getMeterId() {
		return meterId;
	}

	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}

	public String getMeterSet() {
		return meterSet;
	}

	public void setMeterSet(String meterSet) {
		this.meterSet = meterSet;
	}

	public String getConsumerTerminalId() {
		return consumerTerminalId;
	}

	public void setConsumerTerminalId(String consumerTerminalId) {
		this.consumerTerminalId = consumerTerminalId;
	}

	

	public Integer getIntegrationPeriod() {
		return integrationPeriod;
	}

	public void setIntegrationPeriod(Integer integrationPeriod) {
		this.integrationPeriod = integrationPeriod;
	}

	public String toString() {
		return "Meter [consumerTerminalId=" + consumerTerminalId + ", idRequest=" + idRequest + ", integrationPeriod="
				+ integrationPeriod + ", meterId=" + meterId + ", meterSet=" + meterSet + "]";
	}
	
	
}
