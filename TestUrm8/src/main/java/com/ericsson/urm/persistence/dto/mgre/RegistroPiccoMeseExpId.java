package com.ericsson.urm.persistence.dto.mgre;

import org.apache.log4j.Logger;

import com.ericsson.urm.persistence.dto.mgre.datatype.EnergyComponentId;
import com.ericsson.urm.persistence.dto.mgre.datatype.RegisterCode;
import com.ericsson.urm.util.ArgumentsCheckerUtil;

public class RegistroPiccoMeseExpId implements RegistroPiccoMeseId {
	private static final long serialVersionUID = -1L;
	private static Logger logger = Logger.getLogger(RegistroPiccoMeseExpId.class);

	private String matricolaLenntCliente;
	private String annoRilevazione;
	private String meseRilevazione;
	private String registro = null;
	private String componentId = null;
	
	

	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}

	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}

	public String getAnnoRilevazione() {
		return annoRilevazione;
	}

	public void setAnnoRilevazione(String annoRilevazione) {
		this.annoRilevazione = annoRilevazione;
	}

	public String getMeseRilevazione() {
		return meseRilevazione;
	}

	public void setMeseRilevazione(String meseRilevazione) {
		this.meseRilevazione = meseRilevazione;
	}

	public EnergyComponentId getComponentId() {
		return componentId != null ? EnergyComponentId.parse(componentId)
				: null;
	}

	public void setComponentId(EnergyComponentId energyComponentId) {
		ArgumentsCheckerUtil.checkNull(energyComponentId, "energyComponentId");
		this.componentId = energyComponentId.toString();
	}

	public RegisterCode getRegistro() {
		return registro != null ? RegisterCode.parse(registro) : null;
	}

	public void setRegistro(RegisterCode registerCode) {
		ArgumentsCheckerUtil.checkNull(registerCode, "registerCode");
		this.registro = registerCode.toString();
	}

	public RegistroPiccoMeseExpId() {
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((annoRilevazione == null) ? 0 : annoRilevazione.hashCode());
		result = prime * result
				+ ((componentId == null) ? 0 : componentId.hashCode());
		result = prime
				* result
				+ ((matricolaLenntCliente == null) ? 0 : matricolaLenntCliente
						.hashCode());
		result = prime * result
				+ ((meseRilevazione == null) ? 0 : meseRilevazione.hashCode());
		result = prime * result
				+ ((registro == null) ? 0 : registro.hashCode());
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
		RegistroPiccoMeseExpId other = (RegistroPiccoMeseExpId) obj;
		if (annoRilevazione == null) {
			if (other.annoRilevazione != null)
				return false;
		} else if (!annoRilevazione.equals(other.annoRilevazione))
			return false;
		if (componentId == null) {
			if (other.componentId != null)
				return false;
		} else if (!componentId.equals(other.componentId))
			return false;
		if (matricolaLenntCliente == null) {
			if (other.matricolaLenntCliente != null)
				return false;
		} else if (!matricolaLenntCliente.equals(other.matricolaLenntCliente))
			return false;
		if (meseRilevazione == null) {
			if (other.meseRilevazione != null)
				return false;
		} else if (!meseRilevazione.equals(other.meseRilevazione))
			return false;
		if (registro == null) {
			if (other.registro != null)
				return false;
		} else if (!registro.equals(other.registro))
			return false;
		return true;
	}

	public Object clone() {
		RegistroPiccoMeseExpId ret = null;
		try {
			ret = (RegistroPiccoMeseExpId)super.clone();	
		} 
		catch(CloneNotSupportedException e) {
			logger.error(e.getMessage(),e);
		}
		return ret;
	}
}
