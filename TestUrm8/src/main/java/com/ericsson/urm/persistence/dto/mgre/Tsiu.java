package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;


public class Tsiu implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private String				codApp;					// codice apparato
	private String				codTop;
	private String				codVia;
	private String				desVia;
	private String				codCiv;
	private Boolean				snc;
	private String				codGeo;
	private Boolean				validitaGeo;
	private String				tipoLennt;

	public static enum TipoLenntTsiu {
		ELETTRICO("E"), O("O"), T("T"), ZERO("0");

		private String	value;

		private TipoLenntTsiu(String value) {
			this.value = value;
		}

		public String value() {
			return this.value;
		}
	}

	public String getCodApp() {
		return codApp;
	}

	public void setCodApp(String codApp) {
		this.codApp = codApp;
	}

	public String getCodTop() {
		return codTop;
	}

	public void setCodTop(String codTop) {
		this.codTop = codTop;
	}

	public String getCodVia() {
		return codVia;
	}

	public void setCodVia(String codVia) {
		this.codVia = codVia;
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

	public Boolean getSnc() {
		return snc;
	}

	public void setSnc(Boolean snc) {
		this.snc = snc;
	}

	public String getCodGeo() {
		return codGeo;
	}

	public void setCodGeo(String codGeo) {
		this.codGeo = codGeo;
	}

	public Boolean getValiditaGeo() {
		return validitaGeo;
	}

	public void setValiditaGeo(Boolean validitaGeo) {
		this.validitaGeo = validitaGeo;
	}

	public TipoLenntTsiu getTipoLennt() {
		if (tipoLennt == null)
			return null;
		for (TipoLenntTsiu t : TipoLenntTsiu.values())
			if (tipoLennt.equals(t.value()))
				return t;
		throw new IllegalArgumentException("Nessun tipo lennt valido per " + tipoLennt);
	}

	public void setTipoLennt(TipoLenntTsiu tipoLennt) {
		if (tipoLennt == null)
			this.tipoLennt = null;
		else
			this.tipoLennt = tipoLennt.value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codApp == null) ? 0 : codApp.hashCode());
		result = prime * result + ((codCiv == null) ? 0 : codCiv.hashCode());
		result = prime * result + ((codGeo == null) ? 0 : codGeo.hashCode());
		result = prime * result + ((codTop == null) ? 0 : codTop.hashCode());
		result = prime * result + ((codVia == null) ? 0 : codVia.hashCode());
		result = prime * result + ((desVia == null) ? 0 : desVia.hashCode());
		result = prime * result + ((snc == null) ? 0 : snc.hashCode());
		result = prime * result + ((tipoLennt == null) ? 0 : tipoLennt.hashCode());
		result = prime * result + ((validitaGeo == null) ? 0 : validitaGeo.hashCode());
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
		Tsiu other = (Tsiu) obj;
		if (codApp == null) {
			if (other.codApp != null)
				return false;
		}
		else if (!codApp.equals(other.codApp))
			return false;
		if (codCiv == null) {
			if (other.codCiv != null)
				return false;
		}
		else if (!codCiv.equals(other.codCiv))
			return false;
		if (codGeo == null) {
			if (other.codGeo != null)
				return false;
		}
		else if (!codGeo.equals(other.codGeo))
			return false;
		if (codTop == null) {
			if (other.codTop != null)
				return false;
		}
		else if (!codTop.equals(other.codTop))
			return false;
		if (codVia == null) {
			if (other.codVia != null)
				return false;
		}
		else if (!codVia.equals(other.codVia))
			return false;
		if (desVia == null) {
			if (other.desVia != null)
				return false;
		}
		else if (!desVia.equals(other.desVia))
			return false;
		if (snc == null) {
			if (other.snc != null)
				return false;
		}
		else if (!snc.equals(other.snc))
			return false;
		if (tipoLennt == null) {
			if (other.tipoLennt != null)
				return false;
		}
		else if (!tipoLennt.equals(other.tipoLennt))
			return false;
		if (validitaGeo == null) {
			if (other.validitaGeo != null)
				return false;
		}
		else if (!validitaGeo.equals(other.validitaGeo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tsiu [codApp=" + codApp + ", codTop=" + codTop + ", codVia=" + codVia + ", desVia=" + desVia + ", codCiv=" + codCiv + ", snc=" + snc
				+ ", codGeo=" + codGeo + ", validitaGeo=" + validitaGeo + ", tipoLennt=" + tipoLennt + "]";
	}
}
