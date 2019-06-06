package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

public class Concentratore implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String codConcentratore        	= null;
	private String codCabinaSecondaria		= null;
	private String statoConcentratore		= null;
	private String codPadre					= null;
	private String tipoModem				= null;
	private String numTelModem				= null;
	private String imsiModem				= null;
	private String ipVpn					= null;
	private String pstnModem				= null;
	private String accessUser				= null;
	private String ftprUser					= null;
	private String ftpwUser					= null;
	private String accessPwd				= null;
	private String ftprPwd					= null;
	private String ftpwPwd					= null;
	private String statoGuasto				= null;
	private Long codTrasformatore			= null;
	private Date ultimoContattoAdd			= null;
	private String modelloModem				= null;
	private String costruttoreModem			= null;
	private Date dataVariazioneDatiModem	= null;
	private String radiusUser			    = null;
	private Date dataVariazioneUtenteRadius	= null;
	private String stato 					= null;
	private Date dataVariazioneStato	    = null;
	
	public Concentratore() {
		super();
	}	

	public Concentratore(String codConcentratore, String codCabinaSecondaria,
                         String statoConcentratore, String codPadre, String tipoModem,
                         String numTelModem, String imsiModem, String ipVpn,
                         String pstnModem, String accessUser, String ftprUser,
                         String ftpwUser, String accessPwd, String ftprPwd, String ftpwPwd,
                         String statoGuasto, Long codTrasformatore, Date ultimoContattoAdd,
                         String modelloModem, String costruttoreModem,
                         Date dataVariazioneDatiModem, String radiusUser,
                         Date dataVariazioneUtenteRadius, String stato, Date dataVariazioneStato) {
		super();
		this.codConcentratore = codConcentratore;
		this.codCabinaSecondaria = codCabinaSecondaria;
		this.statoConcentratore = statoConcentratore;
		this.codPadre = codPadre;
		this.tipoModem = tipoModem;
		this.numTelModem = numTelModem;
		this.imsiModem = imsiModem;
		this.ipVpn = ipVpn;
		this.pstnModem = pstnModem;
		this.accessUser = accessUser;
		this.ftprUser = ftprUser;
		this.ftpwUser = ftpwUser;
		this.accessPwd = accessPwd;
		this.ftprPwd = ftprPwd;
		this.ftpwPwd = ftpwPwd;
		this.statoGuasto = statoGuasto;
		this.codTrasformatore = codTrasformatore;
		this.ultimoContattoAdd = ultimoContattoAdd;
		this.modelloModem = modelloModem;
		this.costruttoreModem = costruttoreModem;
		this.dataVariazioneDatiModem = dataVariazioneDatiModem;
		this.radiusUser = radiusUser;
		this.dataVariazioneUtenteRadius = dataVariazioneUtenteRadius;
		this.stato = stato;
		this.dataVariazioneStato = dataVariazioneStato;
	}

	public String getCodConcentratore() {
		return codConcentratore;
	}


	public void setCodConcentratore(String codConcentratore) {
		this.codConcentratore = codConcentratore;
	}


	public String getCodCabinaSecondaria() {
		return codCabinaSecondaria;
	}


	public void setCodCabinaSecondaria(String codCabinaSecondaria) {
		this.codCabinaSecondaria = codCabinaSecondaria;
	}


	public String getStatoConcentratore() {
		return statoConcentratore;
	}


	public void setStatoConcentratore(String statoConcentratore) {
		this.statoConcentratore = statoConcentratore;
	}


	public String getCodPadre() {
		return codPadre;
	}


	public void setCodPadre(String codPadre) {
		this.codPadre = codPadre;
	}


	public String getTipoModem() {
		return tipoModem;
	}


	public void setTipoModem(String tipoModem) {
		this.tipoModem = tipoModem;
	}


	public String getNumTelModem() {
		return numTelModem;
	}


	public void setNumTelModem(String numTelModem) {
		this.numTelModem = numTelModem;
	}


	public String getImsiModem() {
		return imsiModem;
	}


	public void setImsiModem(String imsiModem) {
		this.imsiModem = imsiModem;
	}


	public String getIpVpn() {
		return ipVpn;
	}


	public void setIpVpn(String ipVpn) {
		this.ipVpn = ipVpn;
	}


	public String getPstnModem() {
		return pstnModem;
	}


	public void setPstnModem(String pstnModem) {
		this.pstnModem = pstnModem;
	}


	public String getAccessUser() {
		return accessUser;
	}


	public void setAccessUser(String accessUser) {
		this.accessUser = accessUser;
	}


	public String getFtprUser() {
		return ftprUser;
	}


	public void setFtprUser(String ftprUser) {
		this.ftprUser = ftprUser;
	}


	public String getFtpwUser() {
		return ftpwUser;
	}


	public void setFtpwUser(String ftpwUser) {
		this.ftpwUser = ftpwUser;
	}


	public String getAccessPwd() {
		return accessPwd;
	}


	public void setAccessPwd(String accessPwd) {
		this.accessPwd = accessPwd;
	}


	public String getFtprPwd() {
		return ftprPwd;
	}


	public void setFtprPwd(String ftprPwd) {
		this.ftprPwd = ftprPwd;
	}


	public String getFtpwPwd() {
		return ftpwPwd;
	}


	public void setFtpwPwd(String ftpwPwd) {
		this.ftpwPwd = ftpwPwd;
	}


	public String getStatoGuasto() {
		return statoGuasto;
	}


	public void setStatoGuasto(String statoGuasto) {
		this.statoGuasto = statoGuasto;
	}


	public Long getCodTrasformatore() {
		return codTrasformatore;
	}


	public void setCodTrasformatore(Long codTrasformatore) {
		this.codTrasformatore = codTrasformatore;
	}


	public Date getUltimoContattoAdd() {
		return ultimoContattoAdd;
	}


	public void setUltimoContattoAdd(Date ultimoContattoAdd) {
		this.ultimoContattoAdd = ultimoContattoAdd;
	}

	public String getModelloModem() {
		return modelloModem;
	}

	public void setModelloModem(String modelloModem) {
		this.modelloModem = modelloModem;
	}

	public String getCostruttoreModem() {
		return costruttoreModem;
	}

	public void setCostruttoreModem(String costruttoreModem) {
		this.costruttoreModem = costruttoreModem;
	}

	public Date getDataVariazioneDatiModem() {
		return dataVariazioneDatiModem;
	}

	public void setDataVariazioneDatiModem(Date dataVariazioneDatiModem) {
		this.dataVariazioneDatiModem = dataVariazioneDatiModem;
	}	

	public String getRadiusUser() {
		return radiusUser;
	}

	public void setRadiusUser(String radiusUser) {
		this.radiusUser = radiusUser;
	}

	public Date getDataVariazioneUtenteRadius() {
		return dataVariazioneUtenteRadius;
	}

	public void setDataVariazioneUtenteRadius(Date dataVariazioneUtenteRadius) {
		this.dataVariazioneUtenteRadius = dataVariazioneUtenteRadius;
	}
	
	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Date getDataVariazioneStato() {
		return dataVariazioneStato;
	}

	public void setDataVariazioneStato(Date dataVariazioneStato) {
		this.dataVariazioneStato = dataVariazioneStato;
	}

	
	
	
}
