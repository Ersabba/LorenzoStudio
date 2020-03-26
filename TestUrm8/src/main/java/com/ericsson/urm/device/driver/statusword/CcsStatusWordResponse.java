package com.ericsson.urm.device.driver.statusword;

import java.io.Serializable;

public class CcsStatusWordResponse implements Serializable {
	
	private static final long serialVersionUID = -1L;
	private StatoOperativo statoOperativo = null;
	private DiagnosticaFunzionale diagnosticaFunzionale = null;
	private DiagnosticaRisorseHardware diagnosticaRisorseHardware = null;
	
	public CcsStatusWordResponse() {
		super();
		
	}
	
	public CcsStatusWordResponse(StatoOperativo statoOperativo,
			DiagnosticaFunzionale diagnosticaFunzionale,
			DiagnosticaRisorseHardware diagnosticaRisorseHardware) {
		super();
		this.statoOperativo = statoOperativo;
		this.diagnosticaFunzionale = diagnosticaFunzionale;
		this.diagnosticaRisorseHardware = diagnosticaRisorseHardware;
	}

	public StatoOperativo getStatoOperativo() {
		return statoOperativo;
	}

	public void setStatoOperativo(StatoOperativo statoOperativo) {
		this.statoOperativo = statoOperativo;
	}

	public DiagnosticaFunzionale getDiagnosticaFunzionale() {
		return diagnosticaFunzionale;
	}

	public void setDiagnosticaFunzionale(DiagnosticaFunzionale diagnosticaFunzionale) {
		this.diagnosticaFunzionale = diagnosticaFunzionale;
	}

	public DiagnosticaRisorseHardware getDiagnosticaRisorseHardware() {
		return diagnosticaRisorseHardware;
	}

	public void setDiagnosticaRisorseHardware(
			DiagnosticaRisorseHardware diagnosticaRisorseHardware) {
		this.diagnosticaRisorseHardware = diagnosticaRisorseHardware;
	}
}
