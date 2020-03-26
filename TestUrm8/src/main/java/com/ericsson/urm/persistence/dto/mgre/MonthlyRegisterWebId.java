package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;

import com.ericsson.urm.persistence.dto.mgre.datatype.EnergyComponentId;
import com.ericsson.urm.persistence.dto.mgre.datatype.RegisterCode;
import com.ericsson.urm.util.ArgumentsCheckerUtil;

public class MonthlyRegisterWebId implements Serializable, Cloneable {
	private static final long serialVersionUID = -1;

	private String matricolaLenntCliente = null;
	private String mese = null;
	private String anno = null;
	private String componentId = null;
	private String registro = null;

	public MonthlyRegisterWebId() {}
	
	
	public MonthlyRegisterWebId(String matricolaLenntCliente, String mese,
							 String anno, EnergyComponentId energyComponentId, 
							 RegisterCode registerCode) {

		ArgumentsCheckerUtil.checkString(matricolaLenntCliente, "matricolaLenntCliente");
		ArgumentsCheckerUtil.checkString(mese, "mese");
		ArgumentsCheckerUtil.checkString(anno, "anno");
		ArgumentsCheckerUtil.checkNull(energyComponentId, "energyComponentId");
		ArgumentsCheckerUtil.checkNull(registerCode, "registerCode");
		
		this.matricolaLenntCliente = matricolaLenntCliente;
		this.mese = mese;
		this.anno = anno;
		this.componentId = energyComponentId.toString();
		this.registro = registerCode.toString();
	}
	
	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}
	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}
	public String getMese() {
		return mese;
	}
	public void setMese(String mese) {
		this.mese = mese;
	}
	public String getAnno() {
		return anno;
	}
	public void setAnno(String anno) {
		this.anno = anno;
	}
	public EnergyComponentId getComponentId() {
		return componentId != null ? EnergyComponentId.parse(componentId) : null;
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
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anno == null) ? 0 : anno.hashCode());
		result = prime * result
				+ ((componentId == null) ? 0 : componentId.hashCode());
		result = prime
				* result
				+ ((matricolaLenntCliente == null) ? 0 : matricolaLenntCliente
						.hashCode());
		result = prime * result + ((mese == null) ? 0 : mese.hashCode());
		result = prime * result
				+ ((registro == null) ? 0 : registro.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final MonthlyRegisterWebId other = (MonthlyRegisterWebId) obj;
		if (anno == null) {
			if (other.anno != null)
				return false;
		} else if (!anno.equals(other.anno))
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
		if (mese == null) {
			if (other.mese != null)
				return false;
		} else if (!mese.equals(other.mese))
			return false;
		if (registro == null) {
			if (other.registro != null)
				return false;
		} else if (!registro.equals(other.registro))
			return false;
		return true;
	}
	
	public Object clone() {
		MonthlyRegisterWebId ret = new MonthlyRegisterWebId();
	 
		ret.matricolaLenntCliente = matricolaLenntCliente;
		ret.mese = mese;
		ret.anno = anno;
		ret.componentId = componentId;
		ret.registro = registro;
		
		return ret;
	}

}
