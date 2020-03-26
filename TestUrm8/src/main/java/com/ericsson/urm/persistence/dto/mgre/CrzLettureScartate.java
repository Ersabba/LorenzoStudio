package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the GRE_CRZ_LETTURE_SCARTATE database table.
 * 
 */
@Entity
@Table(name="GRE_CRZ_LETTURE_SCARTATE")
public class CrzLettureScartate implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CrzLettureScartateId id;


	
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date crzdate;

	@Column(length=13)
	private String lenntmat;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date lenntdate;

	@Column(name="MATRICOLA_LENNT_PRIMITIVO")
	private String matricolaLenntPrimitivo;

	@Column
	private String t1;

	@Column
	private String t2;

	@Column
	private String t3;

	@Column
	private String t4;
	
	@Column
	private String d1;

	@Column
	private String d2;

	@Column
	private String d3;

	@Column
	private String d4;

	@Column(name="TOT_GEN")
	private String totGen;


	public CrzLettureScartate() {
	}


	public CrzLettureScartateId getId() {
		return id;
	}


	public void setId(CrzLettureScartateId id) {
		this.id = id;
	}



	public Date getCrzdate() {
		return crzdate;
	}


	public void setCrzdate(Date crzdate) {
		this.crzdate = crzdate;
	}


	public String getLenntmat() {
		return lenntmat;
	}


	public void setLenntmat(String lenntmat) {
		this.lenntmat = lenntmat;
	}


	public String getMatricolaLenntPrimitivo() {
		return matricolaLenntPrimitivo;
	}


	public void setMatricolaLenntPrimitivo(String matricolaLenntPrimitivo) {
		this.matricolaLenntPrimitivo = matricolaLenntPrimitivo;
	}


	public String getT1() {
		return t1;
	}


	public void setT1(String t1) {
		this.t1 = t1;
	}


	public String getT2() {
		return t2;
	}


	public void setT2(String t2) {
		this.t2 = t2;
	}


	public String getT3() {
		return t3;
	}


	public void setT3(String t3) {
		this.t3 = t3;
	}


	public String getT4() {
		return t4;
	}


	public void setT4(String t4) {
		this.t4 = t4;
	}


	public String getD1() {
		return d1;
	}


	public void setD1(String d1) {
		this.d1 = d1;
	}


	public String getD2() {
		return d2;
	}


	public void setD2(String d2) {
		this.d2 = d2;
	}


	public String getD3() {
		return d3;
	}


	public void setD3(String d3) {
		this.d3 = d3;
	}


	public String getD4() {
		return d4;
	}


	public void setD4(String d4) {
		this.d4 = d4;
	}


	public String getTotGen() {
		return totGen;
	}


	public void setTotGen(String totGen) {
		this.totGen = totGen;
	}


	public Date getLenntdate() {
		return lenntdate;
	}


	public void setLenntdate(Date lenntdate) {
		this.lenntdate = lenntdate;
	}


	@Override
	public String toString() {
		return "CrzLettureScartate [id=" + id + ", crzdate=" + crzdate
				+ ", lenntmat=" + lenntmat + ", lenntdate=" + lenntdate
				+ ", matricolaLenntPrimitivo=" + matricolaLenntPrimitivo
				+ ", t1=" + t1 + ", t2=" + t2 + ", t3=" + t3 + ", t4=" + t4
				+ ", d1=" + d1 + ", d2=" + d2 + ", d3=" + d3 + ", d4=" + d4
				+ ", totGen=" + totGen + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((crzdate == null) ? 0 : crzdate.hashCode());
		result = prime * result + ((d1 == null) ? 0 : d1.hashCode());
		result = prime * result + ((d2 == null) ? 0 : d2.hashCode());
		result = prime * result + ((d3 == null) ? 0 : d3.hashCode());
		result = prime * result + ((d4 == null) ? 0 : d4.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lenntdate == null) ? 0 : lenntdate.hashCode());
		result = prime * result
				+ ((lenntmat == null) ? 0 : lenntmat.hashCode());
		result = prime
				* result
				+ ((matricolaLenntPrimitivo == null) ? 0
						: matricolaLenntPrimitivo.hashCode());
		result = prime * result + ((t1 == null) ? 0 : t1.hashCode());
		result = prime * result + ((t2 == null) ? 0 : t2.hashCode());
		result = prime * result + ((t3 == null) ? 0 : t3.hashCode());
		result = prime * result + ((t4 == null) ? 0 : t4.hashCode());
		result = prime * result + ((totGen == null) ? 0 : totGen.hashCode());
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
		CrzLettureScartate other = (CrzLettureScartate) obj;
		if (crzdate == null) {
			if (other.crzdate != null)
				return false;
		} else if (!crzdate.equals(other.crzdate))
			return false;
		if (d1 == null) {
			if (other.d1 != null)
				return false;
		} else if (!d1.equals(other.d1))
			return false;
		if (d2 == null) {
			if (other.d2 != null)
				return false;
		} else if (!d2.equals(other.d2))
			return false;
		if (d3 == null) {
			if (other.d3 != null)
				return false;
		} else if (!d3.equals(other.d3))
			return false;
		if (d4 == null) {
			if (other.d4 != null)
				return false;
		} else if (!d4.equals(other.d4))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lenntdate == null) {
			if (other.lenntdate != null)
				return false;
		} else if (!lenntdate.equals(other.lenntdate))
			return false;
		if (lenntmat == null) {
			if (other.lenntmat != null)
				return false;
		} else if (!lenntmat.equals(other.lenntmat))
			return false;
		if (matricolaLenntPrimitivo == null) {
			if (other.matricolaLenntPrimitivo != null)
				return false;
		} else if (!matricolaLenntPrimitivo
				.equals(other.matricolaLenntPrimitivo))
			return false;
		if (t1 == null) {
			if (other.t1 != null)
				return false;
		} else if (!t1.equals(other.t1))
			return false;
		if (t2 == null) {
			if (other.t2 != null)
				return false;
		} else if (!t2.equals(other.t2))
			return false;
		if (t3 == null) {
			if (other.t3 != null)
				return false;
		} else if (!t3.equals(other.t3))
			return false;
		if (t4 == null) {
			if (other.t4 != null)
				return false;
		} else if (!t4.equals(other.t4))
			return false;
		if (totGen == null) {
			if (other.totGen != null)
				return false;
		} else if (!totGen.equals(other.totGen))
			return false;
		return true;
	}


	
	
}