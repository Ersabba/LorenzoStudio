package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import com.ericsson.urm.persistence.dto.mgre.datatype.StatoClusterCabina;

public class ClusterCabina implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	
	private Long idClusterCabina;
	private String codCabinaSecondaria;
	private Date dataInterruzione;
	private Date dataAcqFile;
	private Date timestampApprovazione;
	private Date timestampExport;
	private String stato;
	private String fileName;
	private Set<ClusterCcs> concentratori = new LinkedHashSet<ClusterCcs>(0);	
	
	public ClusterCabina() {}

	public ClusterCabina(Long idClusterCabina, String codCabinaSecondaria,
			Date dataInterruzione, Date dataAcqFile,
			Date timestampApprovazione, Date timestampExport, StatoClusterCabina stato,
			Set<ClusterCcs> concentratori) {
		super();
		this.idClusterCabina = idClusterCabina;
		this.codCabinaSecondaria = codCabinaSecondaria;
		this.dataInterruzione = dataInterruzione;
		this.dataAcqFile = dataAcqFile;
		this.timestampApprovazione = timestampApprovazione;
		this.timestampExport = timestampExport;
		this.stato = stato.getState();
		this.concentratori = concentratori;
	}	
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getIdClusterCabina() {
		return idClusterCabina;
	}

	public void setIdClusterCabina(Long idClusterCabina) {
		this.idClusterCabina = idClusterCabina;
	}

	public String getCodCabinaSecondaria() {
		return codCabinaSecondaria;
	}

	public void setCodCabinaSecondaria(String codCabinaSecondaria) {
		this.codCabinaSecondaria = codCabinaSecondaria;
	}

	public Date getDataInterruzione() {
		return dataInterruzione;
	}

	public void setDataInterruzione(Date dataInterruzione) {
		this.dataInterruzione = dataInterruzione;
	}

	public Date getDataAcqFile() {
		return dataAcqFile;
	}

	public void setDataAcqFile(Date dataAcqFile) {
		this.dataAcqFile = dataAcqFile;
	}

	public Date getTimestampApprovazione() {
		return timestampApprovazione;
	}

	public void setTimestampApprovazione(Date timestampApprovazione) {
		this.timestampApprovazione = timestampApprovazione;
	}

	public Date getTimestampExport() {
		return timestampExport;
	}

	public void setTimestampExport(Date timestampExport) {
		this.timestampExport = timestampExport;
	}

	public StatoClusterCabina getStato() {
		return stato!=null ? StatoClusterCabina.parse(stato) : null;
	}

	public void setStato(StatoClusterCabina stato) {
		this.stato = stato!=null ? stato.getState() : null;
	}

	public Set<ClusterCcs> getConcentratori() {
		return concentratori;
	}

	public void setConcentratori(Set<ClusterCcs> concentratori) {
		this.concentratori = concentratori;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codCabinaSecondaria == null) ? 0 : codCabinaSecondaria.hashCode());
		result = prime * result + ((dataAcqFile == null) ? 0 : dataAcqFile.hashCode());
		result = prime * result + ((dataInterruzione == null) ? 0 : dataInterruzione.hashCode());
//		result = prime * result + ((idClusterCabina == null) ? 0 : idClusterCabina.hashCode());
		result = prime * result + ((stato == null) ? 0 : stato.hashCode());
		result = prime * result + ((timestampApprovazione == null) ? 0 : timestampApprovazione.hashCode());
		result = prime * result + ((timestampExport == null) ? 0 : timestampExport.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
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
		ClusterCabina other = (ClusterCabina) obj;
		if (codCabinaSecondaria == null) {
			if (other.codCabinaSecondaria != null)
				return false;
		}
		else if (!codCabinaSecondaria.equals(other.codCabinaSecondaria))
			return false;
		if (dataAcqFile == null) {
			if (other.dataAcqFile != null)
				return false;
		}
		else if (!dataAcqFile.equals(other.dataAcqFile))
			return false;
		if (dataInterruzione == null) {
			if (other.dataInterruzione != null)
				return false;
		}
		else if (!dataInterruzione.equals(other.dataInterruzione))
			return false;
//		if (idClusterCabina == null) {
//			if (other.idClusterCabina != null)
//				return false;
//		}
//		else if (!idClusterCabina.equals(other.idClusterCabina))
//			return false;
		if (stato == null) {
			if (other.stato != null)
				return false;
		}
		else if (!stato.equals(other.stato))
			return false;
		if (timestampApprovazione == null) {
			if (other.timestampApprovazione != null)
				return false;
		}
		else if (!timestampApprovazione.equals(other.timestampApprovazione))
			return false;
		if (timestampExport == null) {
			if (other.timestampExport != null)
				return false;
		}
		else if (!timestampExport.equals(other.timestampExport))
			return false;
		if (fileName == null) {
			if (other.fileName != null) {
				return false;
				
			}
		}
		else if (!fileName.equals(other.fileName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClusterCabina [idClusterCabina=" + idClusterCabina
				+ ", codCabinaSecondaria=" + codCabinaSecondaria
				+ ", dataInterruzione=" + dataInterruzione + ", dataAcqFile="
				+ dataAcqFile + ", timestampApprovazione="
				+ timestampApprovazione + ", timestampExport="
				+ timestampExport + ", stato=" + stato + ", fileName="
				+ fileName + ", concentratori=" + concentratori + "]";
	}
	
}
