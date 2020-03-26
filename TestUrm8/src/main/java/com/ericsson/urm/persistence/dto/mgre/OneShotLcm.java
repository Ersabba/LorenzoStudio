package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GRE_ONESHOT_LC_METER")
public class OneShotLcm implements Serializable {
	private static final long serialVersionUID = 1L;

	private String meterId;

	public OneShotLcm() {
		super();
	}
	
	@Id
	@Column(name="METER_ID")
	public String getMeterId() {
		return meterId;
	}

	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}

	@Override
	public String toString() {
		return "OneShotLcm [meterId=" + meterId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((meterId == null) ? 0 : meterId.hashCode());
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
		OneShotLcm other = (OneShotLcm) obj;
		if (meterId == null) {
			if (other.meterId != null)
				return false;
		} else if (!meterId.equals(other.meterId))
			return false;
		return true;
	}
}