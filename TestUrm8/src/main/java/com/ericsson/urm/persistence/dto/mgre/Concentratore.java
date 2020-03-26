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

	@Override
	public String toString() {
		return "Concentratore [codConcentratore=" + codConcentratore + ", codCabinaSecondaria=" + codCabinaSecondaria
				+ ", statoConcentratore=" + statoConcentratore + ", codPadre=" + codPadre + ", tipoModem=" + tipoModem
				+ ", numTelModem=" + numTelModem + ", imsiModem=" + imsiModem + ", ipVpn=" + ipVpn + ", pstnModem="
				+ pstnModem + ", accessUser=" + accessUser + ", ftprUser=" + ftprUser + ", ftpwUser=" + ftpwUser
				+ ", accessPwd=" + accessPwd + ", ftprPwd=" + ftprPwd + ", ftpwPwd=" + ftpwPwd + ", statoGuasto="
				+ statoGuasto + ", codTrasformatore=" + codTrasformatore + ", ultimoContattoAdd=" + ultimoContattoAdd
				+ ", modelloModem=" + modelloModem + ", costruttoreModem=" + costruttoreModem
				+ ", dataVariazioneDatiModem=" + dataVariazioneDatiModem + ", radiusUser=" + radiusUser
				+ ", dataVariazioneUtenteRadius=" + dataVariazioneUtenteRadius + ", stato=" + stato
				+ ", dataVariazioneStato=" + dataVariazioneStato + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessPwd == null) ? 0 : accessPwd.hashCode());
		result = prime * result + ((accessUser == null) ? 0 : accessUser.hashCode());
		result = prime * result + ((codCabinaSecondaria == null) ? 0 : codCabinaSecondaria.hashCode());
		result = prime * result + ((codConcentratore == null) ? 0 : codConcentratore.hashCode());
		result = prime * result + ((codPadre == null) ? 0 : codPadre.hashCode());
		result = prime * result + ((codTrasformatore == null) ? 0 : codTrasformatore.hashCode());
		result = prime * result + ((costruttoreModem == null) ? 0 : costruttoreModem.hashCode());
		result = prime * result + ((dataVariazioneDatiModem == null) ? 0 : dataVariazioneDatiModem.hashCode());
		result = prime * result + ((dataVariazioneStato == null) ? 0 : dataVariazioneStato.hashCode());
		result = prime * result + ((dataVariazioneUtenteRadius == null) ? 0 : dataVariazioneUtenteRadius.hashCode());
		result = prime * result + ((ftprPwd == null) ? 0 : ftprPwd.hashCode());
		result = prime * result + ((ftprUser == null) ? 0 : ftprUser.hashCode());
		result = prime * result + ((ftpwPwd == null) ? 0 : ftpwPwd.hashCode());
		result = prime * result + ((ftpwUser == null) ? 0 : ftpwUser.hashCode());
		result = prime * result + ((imsiModem == null) ? 0 : imsiModem.hashCode());
		result = prime * result + ((ipVpn == null) ? 0 : ipVpn.hashCode());
		result = prime * result + ((modelloModem == null) ? 0 : modelloModem.hashCode());
		result = prime * result + ((numTelModem == null) ? 0 : numTelModem.hashCode());
		result = prime * result + ((pstnModem == null) ? 0 : pstnModem.hashCode());
		result = prime * result + ((radiusUser == null) ? 0 : radiusUser.hashCode());
		result = prime * result + ((stato == null) ? 0 : stato.hashCode());
		result = prime * result + ((statoConcentratore == null) ? 0 : statoConcentratore.hashCode());
		result = prime * result + ((statoGuasto == null) ? 0 : statoGuasto.hashCode());
		result = prime * result + ((tipoModem == null) ? 0 : tipoModem.hashCode());
		result = prime * result + ((ultimoContattoAdd == null) ? 0 : ultimoContattoAdd.hashCode());
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
		Concentratore other = (Concentratore) obj;
		if (accessPwd == null) {
			if (other.accessPwd != null)
				return false;
		} else if (!accessPwd.equals(other.accessPwd))
			return false;
		if (accessUser == null) {
			if (other.accessUser != null)
				return false;
		} else if (!accessUser.equals(other.accessUser))
			return false;
		if (codCabinaSecondaria == null) {
			if (other.codCabinaSecondaria != null)
				return false;
		} else if (!codCabinaSecondaria.equals(other.codCabinaSecondaria))
			return false;
		if (codConcentratore == null) {
			if (other.codConcentratore != null)
				return false;
		} else if (!codConcentratore.equals(other.codConcentratore))
			return false;
		if (codPadre == null) {
			if (other.codPadre != null)
				return false;
		} else if (!codPadre.equals(other.codPadre))
			return false;
		if (codTrasformatore == null) {
			if (other.codTrasformatore != null)
				return false;
		} else if (!codTrasformatore.equals(other.codTrasformatore))
			return false;
		if (costruttoreModem == null) {
			if (other.costruttoreModem != null)
				return false;
		} else if (!costruttoreModem.equals(other.costruttoreModem))
			return false;
		if (dataVariazioneDatiModem == null) {
			if (other.dataVariazioneDatiModem != null)
				return false;
		} else if (!dataVariazioneDatiModem.equals(other.dataVariazioneDatiModem))
			return false;
		if (dataVariazioneStato == null) {
			if (other.dataVariazioneStato != null)
				return false;
		} else if (!dataVariazioneStato.equals(other.dataVariazioneStato))
			return false;
		if (dataVariazioneUtenteRadius == null) {
			if (other.dataVariazioneUtenteRadius != null)
				return false;
		} else if (!dataVariazioneUtenteRadius.equals(other.dataVariazioneUtenteRadius))
			return false;
		if (ftprPwd == null) {
			if (other.ftprPwd != null)
				return false;
		} else if (!ftprPwd.equals(other.ftprPwd))
			return false;
		if (ftprUser == null) {
			if (other.ftprUser != null)
				return false;
		} else if (!ftprUser.equals(other.ftprUser))
			return false;
		if (ftpwPwd == null) {
			if (other.ftpwPwd != null)
				return false;
		} else if (!ftpwPwd.equals(other.ftpwPwd))
			return false;
		if (ftpwUser == null) {
			if (other.ftpwUser != null)
				return false;
		} else if (!ftpwUser.equals(other.ftpwUser))
			return false;
		if (imsiModem == null) {
			if (other.imsiModem != null)
				return false;
		} else if (!imsiModem.equals(other.imsiModem))
			return false;
		if (ipVpn == null) {
			if (other.ipVpn != null)
				return false;
		} else if (!ipVpn.equals(other.ipVpn))
			return false;
		if (modelloModem == null) {
			if (other.modelloModem != null)
				return false;
		} else if (!modelloModem.equals(other.modelloModem))
			return false;
		if (numTelModem == null) {
			if (other.numTelModem != null)
				return false;
		} else if (!numTelModem.equals(other.numTelModem))
			return false;
		if (pstnModem == null) {
			if (other.pstnModem != null)
				return false;
		} else if (!pstnModem.equals(other.pstnModem))
			return false;
		if (radiusUser == null) {
			if (other.radiusUser != null)
				return false;
		} else if (!radiusUser.equals(other.radiusUser))
			return false;
		if (stato == null) {
			if (other.stato != null)
				return false;
		} else if (!stato.equals(other.stato))
			return false;
		if (statoConcentratore == null) {
			if (other.statoConcentratore != null)
				return false;
		} else if (!statoConcentratore.equals(other.statoConcentratore))
			return false;
		if (statoGuasto == null) {
			if (other.statoGuasto != null)
				return false;
		} else if (!statoGuasto.equals(other.statoGuasto))
			return false;
		if (tipoModem == null) {
			if (other.tipoModem != null)
				return false;
		} else if (!tipoModem.equals(other.tipoModem))
			return false;
		if (ultimoContattoAdd == null) {
			if (other.ultimoContattoAdd != null)
				return false;
		} else if (!ultimoContattoAdd.equals(other.ultimoContattoAdd))
			return false;
		return true;
	}

	
	
	
}
