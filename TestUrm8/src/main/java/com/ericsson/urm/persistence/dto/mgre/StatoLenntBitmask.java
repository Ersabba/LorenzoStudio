package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;

import com.ericsson.urm.device.driver.DeviceProtocol;


public class StatoLenntBitmask implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private Id					id;
	private String				descrInterna		= null;

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public String getDescrInterna() {
		return descrInterna;
	}

	public void setDescrInterna(String descrInterna) {
		this.descrInterna = descrInterna;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descrInterna == null) ? 0 : descrInterna.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		StatoLenntBitmask other = (StatoLenntBitmask) obj;
		if (descrInterna == null) {
			if (other.descrInterna != null)
				return false;
		}
		else if (!descrInterna.equals(other.descrInterna))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}

	public static class Id implements Serializable {

		private static final long	serialVersionUID	= 1L;

		private Integer				bit					= null;
		private String				protocollo;

		public Id() {

		}

		public Id(Integer bit, String protocollo) {
			this.bit = bit;
			this.protocollo = protocollo;
		}
		
		public Id(Integer bit, DeviceProtocol protocollo) {
			this.bit = bit;
			setProtocollo(protocollo);
		}

		public Integer getBit() {
			return bit;
		}

		public void setBit(Integer bit) {
			this.bit = bit;
		}

		public DeviceProtocol getProtocollo() {
			return DeviceProtocol.parse(this.protocollo);
		}

		public void setProtocollo(DeviceProtocol protocollo) {
			if (protocollo != null)
				this.protocollo = protocollo.toString();
			else
				this.protocollo = null;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((bit == null) ? 0 : bit.hashCode());
			result = prime * result + ((protocollo == null) ? 0 : protocollo.hashCode());
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
			Id other = (Id) obj;
			if (bit == null) {
				if (other.bit != null)
					return false;
			}
			else if (!bit.equals(other.bit))
				return false;
			if (protocollo == null) {
				if (other.protocollo != null)
					return false;
			}
			else if (!protocollo.equals(other.protocollo))
				return false;
			return true;
		}
	}
}
