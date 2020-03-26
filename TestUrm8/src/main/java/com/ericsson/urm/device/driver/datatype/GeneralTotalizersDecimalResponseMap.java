package com.ericsson.urm.device.driver.datatype;

import java.io.Serializable;
import java.util.Date;
import java.util.EnumMap;
import java.util.Map;

public class GeneralTotalizersDecimalResponseMap extends EnumMap<ComponentId,Integer> implements Serializable{

	private static final long serialVersionUID = -1L;
	
	private Date day = null;
	private boolean currentReadings = false;
	
	private boolean dataChiusuraValida = false;
	
	public GeneralTotalizersDecimalResponseMap() {
		super(ComponentId.class);
	}
	
	public GeneralTotalizersDecimalResponseMap(Class<ComponentId> keyType) {
		super(keyType);
	}
	
	public GeneralTotalizersDecimalResponseMap(EnumMap<ComponentId, ? extends Integer> m) {
		super(m);
	}
	
	public GeneralTotalizersDecimalResponseMap(Map<ComponentId, ? extends Integer> m) {
		super(m);
	}
	
	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public boolean isDataChiusuraValida() {
		return dataChiusuraValida;
	}
	
	public boolean isCurrentReadings() {
		return currentReadings;
	}

	public void setCurrentReadings(boolean currentReadings) {
		this.currentReadings = currentReadings;
	}

	public void setDataChiusuraValida(boolean dataChiusuraValida) {
		this.dataChiusuraValida = dataChiusuraValida;
	}
	
	public Double getValueInKWh(ComponentId componentId) {
		Integer value = this.get(componentId);
		return  (value != null) ? value/10000.0 : null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (currentReadings ? 1231 : 1237);
		result = prime * result + (dataChiusuraValida ? 1231 : 1237);
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		GeneralTotalizersDecimalResponseMap other = (GeneralTotalizersDecimalResponseMap) obj;
		if (currentReadings != other.currentReadings)
			return false;
		if (dataChiusuraValida != other.dataChiusuraValida)
			return false;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		return true;
	}
}
