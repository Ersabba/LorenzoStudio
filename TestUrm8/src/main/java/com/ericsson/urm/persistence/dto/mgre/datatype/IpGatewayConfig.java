package com.ericsson.urm.persistence.dto.mgre.datatype;

import java.io.Serializable;

import com.ericsson.mgre.recipient.Recipient;

public class IpGatewayConfig implements Recipient, Serializable {
	
	private static final long serialVersionUID = -1L;
	private String gatewayCode;
	private int totAbilAttAss;
	private int totAbilAttEr;
	private int totAbilReattIndAss;
	private int totAbilReattIndEr;
	private int totAbilReattCapAss;
	private int totAbilReattCapEr;
	
	
	public String getGatewayCode() {
		return gatewayCode;
	}
	public void setGatewayCode(String gatewayCode) {
		this.gatewayCode = gatewayCode;
	}
	public int getTotAbilAttAss() {
		return totAbilAttAss;
	}
	public void setTotAbilAttAss(int totAbilAttAss) {
		this.totAbilAttAss = totAbilAttAss;
	}
	public int getTotAbilAttEr() {
		return totAbilAttEr;
	}
	public void setTotAbilAttEr(int totAbilAttEr) {
		this.totAbilAttEr = totAbilAttEr;
	}
	public int getTotAbilReattIndAss() {
		return totAbilReattIndAss;
	}
	public void setTotAbilReattIndAss(int totAbilReattIndAss) {
		this.totAbilReattIndAss = totAbilReattIndAss;
	}
	public int getTotAbilReattIndEr() {
		return totAbilReattIndEr;
	}
	public void setTotAbilReattIndEr(int totAbilReattIndEr) {
		this.totAbilReattIndEr = totAbilReattIndEr;
	}
	public int getTotAbilReattCapAss() {
		return totAbilReattCapAss;
	}
	public void setTotAbilReattCapAss(int totAbilReattCapAss) {
		this.totAbilReattCapAss = totAbilReattCapAss;
	}
	public int getTotAbilReattCapEr() {
		return totAbilReattCapEr;
	}
	public void setTotAbilReattCapEr(int totAbilReattCapEr) {
		this.totAbilReattCapEr = totAbilReattCapEr;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((gatewayCode == null) ? 0 : gatewayCode.hashCode());
		result = prime * result + totAbilAttAss;
		result = prime * result + totAbilAttEr;
		result = prime * result + totAbilReattCapAss;
		result = prime * result + totAbilReattCapEr;
		result = prime * result + totAbilReattIndAss;
		result = prime * result + totAbilReattIndEr;
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
		IpGatewayConfig other = (IpGatewayConfig) obj;
		if (gatewayCode == null) {
			if (other.gatewayCode != null)
				return false;
		} else if (!gatewayCode.equals(other.gatewayCode))
			return false;
		if (totAbilAttAss != other.totAbilAttAss)
			return false;
		if (totAbilAttEr != other.totAbilAttEr)
			return false;
		if (totAbilReattCapAss != other.totAbilReattCapAss)
			return false;
		if (totAbilReattCapEr != other.totAbilReattCapEr)
			return false;
		if (totAbilReattIndAss != other.totAbilReattIndAss)
			return false;
		if (totAbilReattIndEr != other.totAbilReattIndEr)
			return false;
		return true;
	}
	
	@Override
	public String getRecipientId() {
		
		return getGatewayCode();
	}
	
}
