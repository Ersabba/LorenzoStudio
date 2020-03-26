package com.ericsson.mgre.interruzioni;

import java.io.Serializable;
import java.util.Date;


public class ClusterApprovatoExport implements Serializable {
	
	private static final long	serialVersionUID	= -1L;
	
	private String				codCabinaSecondaria;		// not null
	private String				codConcentratore;			// not null
	private String				interruttore;				// not null
	private String              statoInterruttore;
	private String				matricolaLenntCliente;		
	private Date				timestampInterruzione; 		// Data ispezione
	private String				oraInterruzione; 
	private Long                secondiDurataInterruzione;
	private String				pod;
	private String				codiceGeo;
//	private String				flagCertificazioneGeo;
	private Integer 			codiceConfidenzaAssociazione;
	private String              stato;     
	private String				codTop;
	private String				desVia;
	private String				codCiv;
	private String				codTrasformatore;
	private String				matricolaTrasformatore;
	private Integer             tensioneInVolt;
	private String				primoSportello;
	private String				formazioneCavo;
	private String				tipoEvento;
	private String				fase;



	public ClusterApprovatoExport() {}	
	
	public ClusterApprovatoExport(String matricolaLenntCliente, String oraInterruzione,
								  String codTop, String desVia, String codCiv) {
		super();
		this.matricolaLenntCliente = matricolaLenntCliente;
		this.oraInterruzione = oraInterruzione;
		this.codTop = codTop;
		this.desVia = desVia;
		this.codCiv = codCiv;
	}	
	
	public ClusterApprovatoExport(String codCabinaSecondaria,
			String codConcentratore, String interruttore,
			String statoInterruttore, String matricolaLenntCliente,
			Date timestampInterruzione, String oraInterruzione,
			Long secondiDurataInterruzione, String pod, String codiceGeo,
			/*String flagCertificazioneGeo,*/ Integer codiceConfidenzaAssociazione,
			String stato, String codTop, String desVia, String codCiv,
			String codTrasformatore, String matricolaTrasformatore,
			Integer tensioneInVolt, String primoSportello, String formazioneCavo, String tipoEvento, String fase) {
		super();
		this.codCabinaSecondaria = codCabinaSecondaria;
		this.codConcentratore = codConcentratore;
		this.interruttore = interruttore;
		this.statoInterruttore = statoInterruttore;
		this.matricolaLenntCliente = matricolaLenntCliente;
		this.timestampInterruzione = timestampInterruzione;
		this.oraInterruzione = oraInterruzione;
		this.secondiDurataInterruzione = secondiDurataInterruzione;
		this.pod = pod;
		this.codiceGeo = codiceGeo;
//		this.flagCertificazioneGeo = flagCertificazioneGeo;
		this.codiceConfidenzaAssociazione = codiceConfidenzaAssociazione;
		this.stato = stato;
		this.codTop = codTop;
		this.desVia = desVia;
		this.codCiv = codCiv;
		this.codTrasformatore = codTrasformatore;
		this.matricolaTrasformatore = matricolaTrasformatore;
		this.tensioneInVolt = tensioneInVolt;
		this.primoSportello = primoSportello;
		this.formazioneCavo = formazioneCavo;
		this.tipoEvento = tipoEvento;
		this.fase = fase;
	}

	public String getCodCabinaSecondaria() {
		return codCabinaSecondaria;
	}
	public void setCodCabinaSecondaria(String codCabinaSecondaria) {
		this.codCabinaSecondaria = codCabinaSecondaria;
	}
	public String getCodConcentratore() {
		return codConcentratore;
	}
	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}
	public String getInterruttore() {
		return interruttore;
	}
	public void setInterruttore(String interruttore) {
		this.interruttore = interruttore;
	}
	public String getMatricolaLenntCliente() {
		return matricolaLenntCliente;
	}
	public void setMatricolaLenntCliente(String matricolaLenntCliente) {
		this.matricolaLenntCliente = matricolaLenntCliente;
	}
	public Date getTimestampInterruzione() {
		return timestampInterruzione;
	}
	public void setTimestampInterruzione(Date timestampInterruzione) {
		this.timestampInterruzione = timestampInterruzione;
	}
	public String getPod() {
		return pod;
	}
	public void setPod(String pod) {
		this.pod = pod;
	}
	public String getCodiceGeo() {
		return codiceGeo;
	}
	public void setCodiceGeo(String codiceGeo) {
		this.codiceGeo = codiceGeo;
	}
//	public String getFlagCertificazioneGeo() {
//		return flagCertificazioneGeo;
//	}
//	public void setFlagCertificazioneGeo(String flagCertificazioneGeo) {
//		this.flagCertificazioneGeo = flagCertificazioneGeo;
//	}
	public Integer getCodiceConfidenzaAssociazione() {
		return codiceConfidenzaAssociazione;
	}
	public void setCodiceConfidenzaAssociazione(Integer codiceConfidenzaAssociazione) {
		this.codiceConfidenzaAssociazione = codiceConfidenzaAssociazione;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public String getCodTop() {
		return codTop;
	}
	public void setCodTop(String codTop) {
		this.codTop = codTop;
	}
	public String getDesVia() {
		return desVia;
	}
	public void setDesVia(String desVia) {
		this.desVia = desVia;
	}
	public String getCodCiv() {
		return codCiv;
	}
	public void setCodCiv(String codCiv) {
		this.codCiv = codCiv;
	}	
	public String getOraInterruzione() {
		return oraInterruzione;
	}
	public void setOraInterruzione(String oraInterruzione) {
		this.oraInterruzione = oraInterruzione;
	}
	public String getStatoInterruttore() {
		return statoInterruttore;
	}
	public void setStatoInterruttore(String statoInterruttore) {
		this.statoInterruttore = statoInterruttore;
	}
	public Long getSecondiDurataInterruzione() {
		return secondiDurataInterruzione;
	}
	public void setSecondiDurataInterruzione(Long secondiDurataInterruzione) {
		this.secondiDurataInterruzione = secondiDurataInterruzione;
	}
	public String getCodTrasformatore() {
		return codTrasformatore;
	}
	public void setCodTrasformatore(String codTrasformatore) {
		this.codTrasformatore = codTrasformatore;
	}
	public String getMatricolaTrasformatore() {
		return matricolaTrasformatore;
	}
	public void setMatricolaTrasformatore(String matricolaTrasformatore) {
		this.matricolaTrasformatore = matricolaTrasformatore;
	}
	public Integer getTensioneInVolt() {
		return tensioneInVolt;
	}
	public void setTensioneInVolt(Integer tensioneInVolt) {
		this.tensioneInVolt = tensioneInVolt;
	}
	public String getPrimoSportello() {
		return primoSportello;
	}
	public void setPrimoSportello(String primoSportello) {
		this.primoSportello = primoSportello;
	}
	public String getFormazioneCavo() {
		return formazioneCavo;
	}
	public void setFormazioneCavo(String formazioneCavo) {
		this.formazioneCavo = formazioneCavo;
	}
	public String getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public String getFase() {
		return fase;
	}
	public void setFase(String fase) {
		this.fase = fase;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((codCabinaSecondaria == null) ? 0 : codCabinaSecondaria
						.hashCode());
		result = prime * result + ((codCiv == null) ? 0 : codCiv.hashCode());
		result = prime
				* result
				+ ((codConcentratore == null) ? 0 : codConcentratore.hashCode());
		result = prime * result + ((codTop == null) ? 0 : codTop.hashCode());
		result = prime
				* result
				+ ((codTrasformatore == null) ? 0 : codTrasformatore.hashCode());
		result = prime
				* result
				+ ((codiceConfidenzaAssociazione == null) ? 0
						: codiceConfidenzaAssociazione.hashCode());
		result = prime * result
				+ ((codiceGeo == null) ? 0 : codiceGeo.hashCode());
		result = prime * result + ((desVia == null) ? 0 : desVia.hashCode());
//		result = prime
//				* result
//				+ ((flagCertificazioneGeo == null) ? 0 : flagCertificazioneGeo
//						.hashCode());
		result = prime * result
				+ ((formazioneCavo == null) ? 0 : formazioneCavo.hashCode());
		result = prime * result
				+ ((interruttore == null) ? 0 : interruttore.hashCode());
		result = prime
				* result
				+ ((matricolaLenntCliente == null) ? 0 : matricolaLenntCliente
						.hashCode());
		result = prime
				* result
				+ ((matricolaTrasformatore == null) ? 0
						: matricolaTrasformatore.hashCode());
		result = prime * result
				+ ((oraInterruzione == null) ? 0 : oraInterruzione.hashCode());
		result = prime * result + ((pod == null) ? 0 : pod.hashCode());
		result = prime * result
				+ ((primoSportello == null) ? 0 : primoSportello.hashCode());
		result = prime
				* result
				+ ((secondiDurataInterruzione == null) ? 0
						: secondiDurataInterruzione.hashCode());
		result = prime * result + ((stato == null) ? 0 : stato.hashCode());
		result = prime
				* result
				+ ((statoInterruttore == null) ? 0 : statoInterruttore
						.hashCode());
		result = prime * result
				+ ((tensioneInVolt == null) ? 0 : tensioneInVolt.hashCode());
		result = prime
				* result
				+ ((timestampInterruzione == null) ? 0 : timestampInterruzione
						.hashCode());
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
		ClusterApprovatoExport other = (ClusterApprovatoExport) obj;
		if (codCabinaSecondaria == null) {
			if (other.codCabinaSecondaria != null)
				return false;
		} else if (!codCabinaSecondaria.equals(other.codCabinaSecondaria))
			return false;
		if (codCiv == null) {
			if (other.codCiv != null)
				return false;
		} else if (!codCiv.equals(other.codCiv))
			return false;
		if (codConcentratore == null) {
			if (other.codConcentratore != null)
				return false;
		} else if (!codConcentratore.equals(other.codConcentratore))
			return false;
		if (codTop == null) {
			if (other.codTop != null)
				return false;
		} else if (!codTop.equals(other.codTop))
			return false;
		if (codTrasformatore == null) {
			if (other.codTrasformatore != null)
				return false;
		} else if (!codTrasformatore.equals(other.codTrasformatore))
			return false;
		if (codiceConfidenzaAssociazione == null) {
			if (other.codiceConfidenzaAssociazione != null)
				return false;
		} else if (!codiceConfidenzaAssociazione
				.equals(other.codiceConfidenzaAssociazione))
			return false;
		if (codiceGeo == null) {
			if (other.codiceGeo != null)
				return false;
		} else if (!codiceGeo.equals(other.codiceGeo))
			return false;
		if (desVia == null) {
			if (other.desVia != null)
				return false;
		} else if (!desVia.equals(other.desVia))
			return false;
//		if (flagCertificazioneGeo == null) {
//			if (other.flagCertificazioneGeo != null)
//				return false;
//		} else if (!flagCertificazioneGeo.equals(other.flagCertificazioneGeo))
//			return false;
		if (formazioneCavo == null) {
			if (other.formazioneCavo != null)
				return false;
		} else if (!formazioneCavo.equals(other.formazioneCavo))
			return false;
		if (interruttore == null) {
			if (other.interruttore != null)
				return false;
		} else if (!interruttore.equals(other.interruttore))
			return false;
		if (matricolaLenntCliente == null) {
			if (other.matricolaLenntCliente != null)
				return false;
		} else if (!matricolaLenntCliente.equals(other.matricolaLenntCliente))
			return false;
		if (matricolaTrasformatore == null) {
			if (other.matricolaTrasformatore != null)
				return false;
		} else if (!matricolaTrasformatore.equals(other.matricolaTrasformatore))
			return false;
		if (oraInterruzione == null) {
			if (other.oraInterruzione != null)
				return false;
		} else if (!oraInterruzione.equals(other.oraInterruzione))
			return false;
		if (pod == null) {
			if (other.pod != null)
				return false;
		} else if (!pod.equals(other.pod))
			return false;
		if (primoSportello == null) {
			if (other.primoSportello != null)
				return false;
		} else if (!primoSportello.equals(other.primoSportello))
			return false;
		if (secondiDurataInterruzione == null) {
			if (other.secondiDurataInterruzione != null)
				return false;
		} else if (!secondiDurataInterruzione
				.equals(other.secondiDurataInterruzione))
			return false;
		if (stato == null) {
			if (other.stato != null)
				return false;
		} else if (!stato.equals(other.stato))
			return false;
		if (statoInterruttore == null) {
			if (other.statoInterruttore != null)
				return false;
		} else if (!statoInterruttore.equals(other.statoInterruttore))
			return false;
		if (tensioneInVolt == null) {
			if (other.tensioneInVolt != null)
				return false;
		} else if (!tensioneInVolt.equals(other.tensioneInVolt))
			return false;
		if (timestampInterruzione == null) {
			if (other.timestampInterruzione != null)
				return false;
		} else if (!timestampInterruzione.equals(other.timestampInterruzione))
			return false;
		return true;
	}
	
	
			
}
