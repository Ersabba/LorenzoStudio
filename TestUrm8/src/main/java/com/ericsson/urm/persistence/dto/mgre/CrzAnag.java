package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.Type;

import com.ericsson.urm.persistence.dto.mgre.datatype.CrzAllineamentoDatiStatus;
/**
 * The persistent class for the GRE_CRZ_ANAG database table.
 * 
 */
@Entity
@Table(name="GRE_CRZ_ANAG")
public class CrzAnag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MATRICOLA_CRZ", unique=true, nullable=false)
	private String matricolaCrz;

	@Column(name="MATRICOLA_LENNT_PRIMITIVO")
	private String matricolaLenntPrimitivo;

	@Column(name="MATRICOLA_LENNT_ERRATO")
	private String matricolaLenntErrato;

	@Column(name="STATO_COM_LENNT")
	private String statoComLennt;

	@Column(name="PAROLA_DI_STATO_CRZ")
	private String parolaDiStatoCrz;

	@Column(name="LIVELLO_BATTERIA")
	private String livelloBatteria;

	@Column(name="QUALITA_SEGNALE")
	private Integer qualitaSegnale;

	@Column(name="VALORE_BER")
	private Integer valoreBer;

	@Column(name="AREA_CODE")
	private Integer areaCode;
	
	@Column(name="CELL_IDENTIFICATION")
	private Integer cellIdentification;
	
	@Column(name="TENSIONE_BATTERIA")
	private Integer tensioneBatteria;
	
	@Column(name="TEMPERATURA")
	private Integer temperatura;

	@Column(name="PASSWORD_USB")
	private String passwordUsb;

	@Column(name="USER_USB")
	private String userUsb;

	@Column(name="ALLINEAMENTO_DATI")
	@AccessType("field")
	private String allineamentoDati;
	
	@Column(name="MONITORAGGIO")
	private String monitoraggio = "N";	

	@Column(name="AGGIORNAMENTO_BASE_TEMPI")
	private String aggiornamentoBaseTempi;

	@Column(name="UPDATE_GLOBAL_PARAMS")
	@Type(type="yes_no")
	private boolean updateGlobalParams = false;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATION_TIME")
	private Date creationTime = new Date();
	
	@Column(name="RELEASE")
	private String release;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_CONNECTION_DATE")
	private Date lastConnectionDate;
	
	@Column(name="PAROLA_ABILITAZIONE")
	private String parolaAbilitazione;
	
	@Column(name="CRZ_DATE")
	private String crzDate;
	
	@Column(name="LENNT_DATE")
	private String lenntDate;
	
	@Column(name="CONN_DATE")
	private String connDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_UPDATE_GLOBAL_PARAMS")
	private Date lastUpdateGlobalParams=new Date(); 
	
	public CrzAnag(){
		super();
	}

	public String getMatricolaCrz() {
		return matricolaCrz;
	}

	public void setMatricolaCrz(String matricolaCrz) {
		this.matricolaCrz = matricolaCrz;
	}

	public String getMatricolaLenntPrimitivo() {
		return matricolaLenntPrimitivo;
	}

	public void setMatricolaLenntPrimitivo(String matricolaLenntPrimitivo) {
		this.matricolaLenntPrimitivo = matricolaLenntPrimitivo;
	}

	public String getMatricolaLenntErrato() {
		return matricolaLenntErrato;
	}

	public void setMatricolaLenntErrato(String matricolaLenntErrato) {
		this.matricolaLenntErrato = matricolaLenntErrato;
	}

	public String getStatoComLennt() {
		return statoComLennt;
	}

	public void setStatoComLennt(String statoComLennt) {
		this.statoComLennt = statoComLennt;
	}

	public String getParolaDiStatoCrz() {
		return parolaDiStatoCrz;
	}

	public void setParolaDiStatoCrz(String parolaDiStatoCrz) {
		this.parolaDiStatoCrz = parolaDiStatoCrz;
	}

	public String getLivelloBatteria() {
		return livelloBatteria;
	}

	public void setLivelloBatteria(String livelloBatteria) {
		this.livelloBatteria = livelloBatteria;
	}

	public Integer getQualitaSegnale() {
		return qualitaSegnale;
	}

	public void setQualitaSegnale(Integer qualitaSegnale) {
		this.qualitaSegnale = qualitaSegnale;
	}

	public Integer getValoreBer() {
		return valoreBer;
	}

	public void setValoreBer(Integer valoreBer) {
		this.valoreBer = valoreBer;
	}

	public Integer getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(Integer areaCode) {
		this.areaCode = areaCode;
	}

	public Integer getCellIdentification() {
		return cellIdentification;
	}

	public void setCellIdentification(Integer cellIdentification) {
		this.cellIdentification = cellIdentification;
	}

	public String getPasswordUsb() {
		return passwordUsb;
	}

	public void setPasswordUsb(String passwordUsb) {
		this.passwordUsb = passwordUsb;
	}

	public String getUserUsb() {
		return userUsb;
	}

	public void setUserUsb(String userUsb) {
		this.userUsb = userUsb;
	}

	public String getAllineamentoDati() {
		return allineamentoDati;
	}

	public void setAllineamentoDati(String allineamentoDati) {
		this.allineamentoDati = allineamentoDati;
	}
	
	public CrzAllineamentoDatiStatus getAllineamentoDatiStatus() {
		return CrzAllineamentoDatiStatus.fromString(allineamentoDati);
	}

	public void setAllineamentoDatiStatus(CrzAllineamentoDatiStatus allineamentoDati) {
		this.allineamentoDati = allineamentoDati!=null ? allineamentoDati.toString() : null;
	}

	public String getMonitoraggio() {
		return monitoraggio;
	}

	public void setMonitoraggio(String monitoraggio) {
		this.monitoraggio = monitoraggio;
	}

	public String getAggiornamentoBaseTempi() {
		return aggiornamentoBaseTempi;
	}

	public void setAggiornamentoBaseTempi(String aggiornamentoBaseTempi) {
		this.aggiornamentoBaseTempi = aggiornamentoBaseTempi;
	}

	public boolean getUpdateGlobalParams() {
		return updateGlobalParams;
	}

	public void setUpdateGlobalParams(boolean updateGlobalParams) {
		this.updateGlobalParams = updateGlobalParams;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	public Date getLastConnectionDate() {
		return lastConnectionDate;
	}

	public void setLastConnectionDate(Date lastConnectionDate) {
		this.lastConnectionDate = lastConnectionDate;
	}

	public String getParolaAbilitazione() {
		return parolaAbilitazione;
	}

	public void setParolaAbilitazione(String parolaAbilitazione) {
		this.parolaAbilitazione = parolaAbilitazione;
	}

	public String getCrzDate() {
		return crzDate;
	}

	public void setCrzDate(String crzDate) {
		this.crzDate = crzDate;
	}

	public String getLenntDate() {
		return lenntDate;
	}

	public void setLenntDate(String lenntDate) {
		this.lenntDate = lenntDate;
	}

	public String getConnDate() {
		return connDate;
	}

	public void setConnDate(String connDate) {
		this.connDate = connDate;
	}

	public Date getLastUpdateGlobalParams() {
		return lastUpdateGlobalParams;
	}

	public void setLastUpdateGlobalParams(Date lastUpdateGlobalParams) {
		this.lastUpdateGlobalParams = lastUpdateGlobalParams;
	}

	@Override
	public String toString() {
		return "CrzAnag [matricolaCrz=" + matricolaCrz
				+ ", matricolaLenntPrimitivo=" + matricolaLenntPrimitivo
				+ ", matricolaLenntErrato=" + matricolaLenntErrato
				+ ", statoComLennt=" + statoComLennt + ", parolaDiStatoCrz="
				+ parolaDiStatoCrz + ", livelloBatteria=" + livelloBatteria
				+ ", qualitaSegnale=" + qualitaSegnale + ", valoreBer="
				+ valoreBer + ", areaCode=" + areaCode
				+ ", cellIdentification=" + cellIdentification
				+ ", passwordUsb=" + passwordUsb + ", userUsb=" + userUsb
			    + ", allineamentoDati="
				+ allineamentoDati + ", monitoraggio=" + monitoraggio
				+ ", aggiornamentoBaseTempi=" + aggiornamentoBaseTempi
				+ ", updateGlobalParams=" + updateGlobalParams
				+ ", creationTime=" + creationTime + ", release=" + release
				+ ", lastConnectionDate=" + lastConnectionDate
				+ ", parolaAbilitazione=" + parolaAbilitazione + ", crzDate="
				+ crzDate + ", lenntDate=" + lenntDate + ", connDate="
				+ connDate + ", lastUpdateGlobalParams="
				+ lastUpdateGlobalParams + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aggiornamentoBaseTempi == null) ? 0 : aggiornamentoBaseTempi.hashCode());
		result = prime * result + ((allineamentoDati == null) ? 0 : allineamentoDati.hashCode());
		result = prime * result + ((areaCode == null) ? 0 : areaCode.hashCode());
		result = prime * result + ((cellIdentification == null) ? 0 : cellIdentification.hashCode());
		result = prime * result + ((connDate == null) ? 0 : connDate.hashCode());
		result = prime * result + ((creationTime == null) ? 0 : creationTime.hashCode());
		result = prime * result + ((crzDate == null) ? 0 : crzDate.hashCode());
		result = prime * result + ((lastConnectionDate == null) ? 0 : lastConnectionDate.hashCode());
		result = prime * result + ((lastUpdateGlobalParams == null) ? 0 : lastUpdateGlobalParams.hashCode());
		result = prime * result + ((lenntDate == null) ? 0 : lenntDate.hashCode());
		result = prime * result + ((livelloBatteria == null) ? 0 : livelloBatteria.hashCode());
		result = prime * result + ((matricolaCrz == null) ? 0 : matricolaCrz.hashCode());
		result = prime * result + ((matricolaLenntErrato == null) ? 0 : matricolaLenntErrato.hashCode());
		result = prime * result + ((matricolaLenntPrimitivo == null) ? 0 : matricolaLenntPrimitivo.hashCode());
		result = prime * result + ((monitoraggio == null) ? 0 : monitoraggio.hashCode());
		result = prime * result + ((parolaAbilitazione == null) ? 0 : parolaAbilitazione.hashCode());
		result = prime * result + ((parolaDiStatoCrz == null) ? 0 : parolaDiStatoCrz.hashCode());
		result = prime * result + ((passwordUsb == null) ? 0 : passwordUsb.hashCode());
		result = prime * result + ((qualitaSegnale == null) ? 0 : qualitaSegnale.hashCode());
		result = prime * result + ((release == null) ? 0 : release.hashCode());
		result = prime * result + ((statoComLennt == null) ? 0 : statoComLennt.hashCode());
		result = prime * result + (updateGlobalParams ? 1231 : 1237);
		result = prime * result + ((userUsb == null) ? 0 : userUsb.hashCode());
		result = prime * result + ((valoreBer == null) ? 0 : valoreBer.hashCode());
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
		CrzAnag other = (CrzAnag) obj;
		if (aggiornamentoBaseTempi == null) {
			if (other.aggiornamentoBaseTempi != null)
				return false;
		} else if (!aggiornamentoBaseTempi.equals(other.aggiornamentoBaseTempi))
			return false;
		if (allineamentoDati == null) {
			if (other.allineamentoDati != null)
				return false;
		} else if (!allineamentoDati.equals(other.allineamentoDati))
			return false;
		if (areaCode == null) {
			if (other.areaCode != null)
				return false;
		} else if (!areaCode.equals(other.areaCode))
			return false;
		if (cellIdentification == null) {
			if (other.cellIdentification != null)
				return false;
		} else if (!cellIdentification.equals(other.cellIdentification))
			return false;
		if (connDate == null) {
			if (other.connDate != null)
				return false;
		} else if (!connDate.equals(other.connDate))
			return false;
		if (creationTime == null) {
			if (other.creationTime != null)
				return false;
		} else if (!creationTime.equals(other.creationTime))
			return false;
		if (crzDate == null) {
			if (other.crzDate != null)
				return false;
		} else if (!crzDate.equals(other.crzDate))
			return false;
		if (lastConnectionDate == null) {
			if (other.lastConnectionDate != null)
				return false;
		} else if (!lastConnectionDate.equals(other.lastConnectionDate))
			return false;
		if (lastUpdateGlobalParams == null) {
			if (other.lastUpdateGlobalParams != null)
				return false;
		} else if (!lastUpdateGlobalParams.equals(other.lastUpdateGlobalParams))
			return false;
		if (lenntDate == null) {
			if (other.lenntDate != null)
				return false;
		} else if (!lenntDate.equals(other.lenntDate))
			return false;
		if (livelloBatteria == null) {
			if (other.livelloBatteria != null)
				return false;
		} else if (!livelloBatteria.equals(other.livelloBatteria))
			return false;
		if (matricolaCrz == null) {
			if (other.matricolaCrz != null)
				return false;
		} else if (!matricolaCrz.equals(other.matricolaCrz))
			return false;
		if (matricolaLenntErrato == null) {
			if (other.matricolaLenntErrato != null)
				return false;
		} else if (!matricolaLenntErrato.equals(other.matricolaLenntErrato))
			return false;
		if (matricolaLenntPrimitivo == null) {
			if (other.matricolaLenntPrimitivo != null)
				return false;
		} else if (!matricolaLenntPrimitivo.equals(other.matricolaLenntPrimitivo))
			return false;
		if (monitoraggio == null) {
			if (other.monitoraggio != null)
				return false;
		} else if (!monitoraggio.equals(other.monitoraggio))
			return false;
		if (parolaAbilitazione == null) {
			if (other.parolaAbilitazione != null)
				return false;
		} else if (!parolaAbilitazione.equals(other.parolaAbilitazione))
			return false;
		if (parolaDiStatoCrz == null) {
			if (other.parolaDiStatoCrz != null)
				return false;
		} else if (!parolaDiStatoCrz.equals(other.parolaDiStatoCrz))
			return false;
		if (passwordUsb == null) {
			if (other.passwordUsb != null)
				return false;
		} else if (!passwordUsb.equals(other.passwordUsb))
			return false;
		if (qualitaSegnale == null) {
			if (other.qualitaSegnale != null)
				return false;
		} else if (!qualitaSegnale.equals(other.qualitaSegnale))
			return false;
		if (release == null) {
			if (other.release != null)
				return false;
		} else if (!release.equals(other.release))
			return false;
		if (statoComLennt == null) {
			if (other.statoComLennt != null)
				return false;
		} else if (!statoComLennt.equals(other.statoComLennt))
			return false;
		if (updateGlobalParams != other.updateGlobalParams)
			return false;
		if (userUsb == null) {
			if (other.userUsb != null)
				return false;
		} else if (!userUsb.equals(other.userUsb))
			return false;
		if (valoreBer == null) {
			if (other.valoreBer != null)
				return false;
		} else if (!valoreBer.equals(other.valoreBer))
			return false;
		return true;
	}

	/**
	 * @return the tensioneBatteria
	 */
	public final Integer getTensioneBatteria() {
		return tensioneBatteria;
	}

	/**
	 * @param tensioneBatteria the tensioneBatteria to set
	 */
	public final void setTensioneBatteria(Integer tensioneBatteria) {
		this.tensioneBatteria = tensioneBatteria;
	}

	/**
	 * @return the temperatura
	 */
	public final Integer getTemperatura() {
		return temperatura;
	}

	/**
	 * @param temperatura the temperatura to set
	 */
	public final void setTemperatura(Integer temperatura) {
		this.temperatura = temperatura;
	}

	

	
}