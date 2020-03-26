package com.ericsson.urm.device.driver.datatype;


public enum ActivityCommandName {
	AnnulmentDetachments("ANNULLAMENTO_DISTACCO"),
	DisablingPort("DISATTIVAZIONE_PORT_LENNT"),
	customerDeactivation("DISTACCO_UTENZA"),
	customerReactivation("RIATTIVAZIONE"),
	ActivationAndTimePlan("ATTIVAZIONE_CON_PIANO_TARIFFARIO"),
	ContractAndTimePlan("INSTALLAZIONE"),
	TimePlan("PIANO_TARIFFARIO"),
	activateCC("ABILITAZIONE_CURVE_DI_CARICO"),
	deactivateCC("DISABILITAZIONE_CURVE_DI_CARICO"),
	activateCC_light("ABILITAZIONE_CURVE_DI_CARICO SEMPLICE"),
	deactivateCC_light("DISABILITAZIONE_CURVE_DI_CARICO SEMPLICE"),
	InstantTotalizer("TOTALIZZATORI"),
	DecimalGeneralCurrentTotalizer("TOT_DECIMALI_GENERALI_CORRENTI"),
	DecimalTariffCurrentTotalizer("TOT_DECIMALI_TARIFFE_CORRENTI"),
	//DecimalGeneralDailyTotalizer("TOT_DECIMALI_GENERALI_GIORNALIERI"),
	//DecimalTariffDailyTotalizer("TOT_DECIMALI_TARIFFE_GIORNALIERI"),
	MonthlyMaxPower("IPM");
	
	private String actionName;

	private ActivityCommandName(String actionName) {
		if(actionName == null) {
			actionName = toString();
		}
		
		this.actionName = actionName.toUpperCase();
	}

	public String getActionName() {
		return actionName;
	}
	
};
