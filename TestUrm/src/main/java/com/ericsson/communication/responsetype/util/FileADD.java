package com.ericsson.communication.responsetype.util;

import java.io.Serializable;

public class FileADD implements Serializable {

	private static final long serialVersionUID = -1L;
	
	private String mtr;
    private String gruppo;
    private String progressivo;
    private String fase;
    private String nomefile;
    private String mtrtut;
    private String dataAssociazioneLennt;
    private String oraAssociazioneLennt;

    public FileADD() {
    }

// Metodo per registrare i parametri del file

    public void setMtr(String par) {
        this.mtr = par;
    }

    public void setGruppo(String par) {
        this.gruppo = par;
    }

    public void setProgressivo(String par) {
        this.progressivo = par;
    }

    public void setfase(String par) {
        this.fase = par;
    }

    public void setNomeFile(String par) {
        this.nomefile = par;
    }

    public void setMtrTut(String par) {
        this.mtrtut = par;
    }

    public String getGruppo() {
        return this.gruppo;
    }

    public String getProgressivo() {
        return this.progressivo;
    }

    public String getfase() {
        return this.fase;
    }

    public String getNomeFile() {
        return this.nomefile;
    }

    public String getMtrTut() {
        return this.mtrtut;
    }

    public String getMtr() {
        return this.mtr;
    }

	public String getDataAssociazioneLennt() {
		return dataAssociazioneLennt;
	}

	public void setDataAssociazioneLennt(String dataAssociazioneLennt) {
		this.dataAssociazioneLennt = dataAssociazioneLennt;
	}

	public String getOraAssociazioneLennt() {
		return oraAssociazioneLennt;
	}

	public void setOraAssociazioneLennt(String oraAssociazioneLennt) {
		this.oraAssociazioneLennt = oraAssociazioneLennt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((dataAssociazioneLennt == null) ? 0 : dataAssociazioneLennt
						.hashCode());
		result = prime * result + ((fase == null) ? 0 : fase.hashCode());
		result = prime * result + ((gruppo == null) ? 0 : gruppo.hashCode());
		result = prime * result + ((mtr == null) ? 0 : mtr.hashCode());
		result = prime * result + ((mtrtut == null) ? 0 : mtrtut.hashCode());
		result = prime * result
				+ ((nomefile == null) ? 0 : nomefile.hashCode());
		result = prime
				* result
				+ ((oraAssociazioneLennt == null) ? 0 : oraAssociazioneLennt
						.hashCode());
		result = prime * result
				+ ((progressivo == null) ? 0 : progressivo.hashCode());
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
		FileADD other = (FileADD) obj;
		if (dataAssociazioneLennt == null) {
			if (other.dataAssociazioneLennt != null)
				return false;
		} else if (!dataAssociazioneLennt.equals(other.dataAssociazioneLennt))
			return false;
		if (fase == null) {
			if (other.fase != null)
				return false;
		} else if (!fase.equals(other.fase))
			return false;
		if (gruppo == null) {
			if (other.gruppo != null)
				return false;
		} else if (!gruppo.equals(other.gruppo))
			return false;
		if (mtr == null) {
			if (other.mtr != null)
				return false;
		} else if (!mtr.equals(other.mtr))
			return false;
		if (mtrtut == null) {
			if (other.mtrtut != null)
				return false;
		} else if (!mtrtut.equals(other.mtrtut))
			return false;
		if (nomefile == null) {
			if (other.nomefile != null)
				return false;
		} else if (!nomefile.equals(other.nomefile))
			return false;
		if (oraAssociazioneLennt == null) {
			if (other.oraAssociazioneLennt != null)
				return false;
		} else if (!oraAssociazioneLennt.equals(other.oraAssociazioneLennt))
			return false;
		if (progressivo == null) {
			if (other.progressivo != null)
				return false;
		} else if (!progressivo.equals(other.progressivo))
			return false;
		return true;
	}
    
    
}
