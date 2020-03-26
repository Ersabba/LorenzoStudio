package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.ericsson.urm.device.driver.datatype.ComponentId;
import com.ericsson.urm.device.driver.datatype.RegisterId;
import com.ericsson.urm.util.ArgumentsCheckerUtil;


@Embeddable
public class MisuraMeseInvalidaId implements Serializable {

	private static final long serialVersionUID = -1L;
	
	public static enum TipoMisura {
		REGISTRO, IPM;
		
		public static TipoMisura parse(String typeName)	{	
			for (TipoMisura curr : TipoMisura.values()) {
				if(curr.toString().equalsIgnoreCase(typeName)) { return curr; }
			}
			
			throw new IllegalArgumentException ("TipoMisura: unsupported type name " + typeName);
		}
	}
	
	@Column(name="MATRICOLA_LENNT_CLIENTE")
	private String matricolaLenntCliente;
	
	@Column(name="ANNO_RIFERIMENTO")
	private int annoRiferimento;
	
	@Column(name="MESE_RIFERIMENTO")
	private int meseRiferimento;
	
	@Column(name="TIPO_MISURA")
	private String tipoMisura = null;
	
	@Column(name="COMPONENT_ID")
	private String componentId = null;
	
	@Column(name="REGISTRO")
	private String registro = null;
	
	
	
	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}


	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}


	public int getAnnoRiferimento() {
		return annoRiferimento;
	}


	public void setAnnoRiferimento(int annoRiferimento) {
		this.annoRiferimento = annoRiferimento;
	}


	public int getMeseRiferimento() {
		return meseRiferimento;
	}


	public void setMeseRiferimento(int meseRiferimento) {
		this.meseRiferimento = meseRiferimento;
	}

	public TipoMisura getTipoMisura() {
		return tipoMisura!=null ? TipoMisura.parse(tipoMisura) : null;
	}


	public void setTipoMisura(TipoMisura tipoMisura) {
		ArgumentsCheckerUtil.checkNull(tipoMisura,"tipoMisura");
		
		this.tipoMisura = tipoMisura.toString();
	}


	public ComponentId getComponentId() {
		return componentId!=null ? ComponentId.parse(componentId) : null;
	}


	public void setComponentId(ComponentId component) {
		ArgumentsCheckerUtil.checkNull(component,"component");
		
		this.componentId = component.getAcronym();
	}


	public RegisterId getRegistro() {
		return registro != null ? RegisterId.parse(registro) : null;
	}


	public void setRegistro(RegisterId registro) {
		ArgumentsCheckerUtil.checkNull(registro,"registro");
		this.registro = registro.toString();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + annoRiferimento;
		result = prime * result
				+ ((componentId == null) ? 0 : componentId.hashCode());
		result = prime
				* result
				+ ((matricolaLenntCliente == null) ? 0 : matricolaLenntCliente
						.hashCode());
		result = prime * result + meseRiferimento;
		result = prime * result
				+ ((registro == null) ? 0 : registro.hashCode());
		result = prime * result
				+ ((tipoMisura == null) ? 0 : tipoMisura.hashCode());
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
		MisuraMeseInvalidaId other = (MisuraMeseInvalidaId) obj;
		if (annoRiferimento != other.annoRiferimento)
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
		if (meseRiferimento != other.meseRiferimento)
			return false;
		if (registro == null) {
			if (other.registro != null)
				return false;
		} else if (!registro.equals(other.registro))
			return false;
		if (tipoMisura == null) {
			if (other.tipoMisura != null)
				return false;
		} else if (!tipoMisura.equals(other.tipoMisura))
			return false;
		return true;
	}

}
