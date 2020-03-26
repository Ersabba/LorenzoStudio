package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

public class XmlExportTuple implements Serializable {
	private static final long serialVersionUID = -1L;
	
	private String matricolaLenntCliente;
	private String annoRilevazione;
	private String meseRilevazione;
	private String componentId;
	private String registro;
	private Long valoreRegistro = null;
	private Long valorePicco = null;
	private Date istantePicco = null;
	private Date dataRilevazione = null;
	private Long valoreDecimaleRegistro = null;
	
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
	public String getComponentId() {
		return componentId;
	}
	public void setComponentId(String componentId) {
		this.componentId = componentId;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public Long getValoreRegistro() {
		return valoreRegistro;
	}
	public void setValoreRegistro(Long valoreRegistro) {
		this.valoreRegistro = valoreRegistro;
	}
	public Long getValorePicco() {
		return valorePicco;
	}
	public void setValorePicco(Long valorePicco) {
		this.valorePicco = valorePicco;
	}
	public Date getIstantePicco() {
		return istantePicco;
	}
	public void setIstantePicco(Date istantePicco) {
		this.istantePicco = istantePicco;
	}
	public Date getDataRilevazione() {
		return dataRilevazione;
	}
	public void setDataRilevazione(Date dataRilevazione) {
		this.dataRilevazione = dataRilevazione;
	}
	public Long getValoreDecimaleRegistro() {
		return valoreDecimaleRegistro;
	}
	public void setValoreDecimaleRegistro(Long valoreDecimaleRegistro) {
		this.valoreDecimaleRegistro = valoreDecimaleRegistro;
	}
	
}
