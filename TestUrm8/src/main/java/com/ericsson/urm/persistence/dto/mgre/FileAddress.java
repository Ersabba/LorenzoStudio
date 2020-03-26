package com.ericsson.urm.persistence.dto.mgre;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="GRE_FILE_ADD")
public class FileAddress  implements Serializable {
	private static final long serialVersionUID = 1L;

    @EmbeddedId
    private FileAddressId fileAddressId;

    @Column(name="GRUPPO")
    private String gruppo;

    @Column(name="PROGRESSIVO")
    private String progressivo;

    @Column(name="FASE")
    private String fase;

    @Column(name="INDIRIZZO_HDLC")
    private String indirizzoHDLC;

    @Column(name="DATA_ASSOCIAZIONELENNT")
    private String dataAssociazioneLentt;

    @Column(name="ORA_ASSOCIAZIONELENNT")
    private String oraAssociazioneLentt;

    @Temporal(TemporalType.DATE)
    @Column(name="EXPORT_DATE")
    private Date exportDate;
    
    @Column(name="CARRIER")
    private String carrier;

    public FileAddress(){};

    public FileAddress(FileAddressId fileAddressId, String gruppo, String progressivo, String fase, String indirizzoHDLC, 
    		String dataAssociazioneLentt, String oraAssociazioneLentt, Date exportDate, String carrier) {
        this.fileAddressId = fileAddressId;
        this.gruppo = gruppo;
        this.progressivo = progressivo;
        this.fase = fase;
        this.indirizzoHDLC = indirizzoHDLC;
        this.dataAssociazioneLentt = dataAssociazioneLentt;
        this.oraAssociazioneLentt = oraAssociazioneLentt;
        this.exportDate = exportDate;
        this.carrier = carrier;
    }

    public FileAddressId getFileAddressId() {
        return fileAddressId;
    }

    public void setFileAddressId(FileAddressId fileAddressId) {
        this.fileAddressId = fileAddressId;
    }

    public String getGruppo() {
        return gruppo;
    }

    public void setGruppo(String gruppo) {
        this.gruppo = gruppo;
    }

    public String getProgressivo() {
        return progressivo;
    }

    public void setProgressivo(String progressivo) {
        this.progressivo = progressivo;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public String getIndirizzoHDLC() {
        return indirizzoHDLC;
    }

    public void setIndirizzoHDLC(String indirizzoHDLC) {
        this.indirizzoHDLC = indirizzoHDLC;
    }

    public String getDataAssociazioneLentt() {
        return dataAssociazioneLentt;
    }

    public void setDataAssociazioneLentt(String dataAssociazioneLentt) {
        this.dataAssociazioneLentt = dataAssociazioneLentt;
    }

    public String getOraAssociazioneLentt() {
        return oraAssociazioneLentt;
    }

    public void setOraAssociazioneLentt(String oraAssociazioneLentt) {
        this.oraAssociazioneLentt = oraAssociazioneLentt;
    }

    public Date getExportDate() {
        return exportDate;
    }

    public void setExportDate(Date exportDate) {
        this.exportDate = exportDate;
    }

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	@Override
	public String toString() {
		return "FileAddress [fileAddressId=" + fileAddressId + ", gruppo=" + gruppo + ", progressivo=" + progressivo
				+ ", fase=" + fase + ", indirizzoHDLC=" + indirizzoHDLC + ", dataAssociazioneLentt="
				+ dataAssociazioneLentt + ", oraAssociazioneLentt=" + oraAssociazioneLentt + ", exportDate="
				+ exportDate + ", carrier=" + carrier + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carrier == null) ? 0 : carrier.hashCode());
		result = prime * result + ((dataAssociazioneLentt == null) ? 0 : dataAssociazioneLentt.hashCode());
		result = prime * result + ((exportDate == null) ? 0 : exportDate.hashCode());
		result = prime * result + ((fase == null) ? 0 : fase.hashCode());
		result = prime * result + ((fileAddressId == null) ? 0 : fileAddressId.hashCode());
		result = prime * result + ((gruppo == null) ? 0 : gruppo.hashCode());
		result = prime * result + ((indirizzoHDLC == null) ? 0 : indirizzoHDLC.hashCode());
		result = prime * result + ((oraAssociazioneLentt == null) ? 0 : oraAssociazioneLentt.hashCode());
		result = prime * result + ((progressivo == null) ? 0 : progressivo.hashCode());
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
		FileAddress other = (FileAddress) obj;
		if (carrier == null) {
			if (other.carrier != null)
				return false;
		} else if (!carrier.equals(other.carrier))
			return false;
		if (dataAssociazioneLentt == null) {
			if (other.dataAssociazioneLentt != null)
				return false;
		} else if (!dataAssociazioneLentt.equals(other.dataAssociazioneLentt))
			return false;
		if (exportDate == null) {
			if (other.exportDate != null)
				return false;
		} else if (!exportDate.equals(other.exportDate))
			return false;
		if (fase == null) {
			if (other.fase != null)
				return false;
		} else if (!fase.equals(other.fase))
			return false;
		if (fileAddressId == null) {
			if (other.fileAddressId != null)
				return false;
		} else if (!fileAddressId.equals(other.fileAddressId))
			return false;
		if (gruppo == null) {
			if (other.gruppo != null)
				return false;
		} else if (!gruppo.equals(other.gruppo))
			return false;
		if (indirizzoHDLC == null) {
			if (other.indirizzoHDLC != null)
				return false;
		} else if (!indirizzoHDLC.equals(other.indirizzoHDLC))
			return false;
		if (oraAssociazioneLentt == null) {
			if (other.oraAssociazioneLentt != null)
				return false;
		} else if (!oraAssociazioneLentt.equals(other.oraAssociazioneLentt))
			return false;
		if (progressivo == null) {
			if (other.progressivo != null)
				return false;
		} else if (!progressivo.equals(other.progressivo))
			return false;
		return true;
	}

   
}
