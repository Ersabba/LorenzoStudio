package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


/**
 * The persistent class for the GRE_CRZ_PROFILI database table.
 * 
 */
@Entity
@Table(name="GRE_CRZ_PROFILI")
@NamedQuery(name="CrzProfili.findAll", query="SELECT g FROM CrzProfili g")
public class CrzProfili implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GRE_CRZ_PROFILI_IDPROFILO_GENERATOR", sequenceName="SQN_ID_PROFILO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GRE_CRZ_PROFILI_IDPROFILO_GENERATOR")
	@Column(name="ID_PROFILO")
	private long idProfilo = -1L;

	@Column(name="NOME_PROFILO", unique=true)
	private String nomeProfilo;

	@Column(name="PROFILO_DI_DEFAULT")
	@Type(type="yes_no")
	private boolean profiloDiDefault = false;

	//bi-directional many-to-one association to CrzProfiliFunzione
	@OneToMany(cascade=CascadeType.REMOVE, mappedBy="crzProfili", fetch=FetchType.EAGER)
	private List<CrzProfiliFunzione> crzProfiliFunziones;

	public CrzProfili() {
	}

	public long getIdProfilo() {
		return this.idProfilo;
	}

	public void setIdProfilo(long idProfilo) {
		this.idProfilo = idProfilo;
	}

	public String getNomeProfilo() {
		return this.nomeProfilo;
	}

	public void setNomeProfilo(String nomeProfilo) {
		this.nomeProfilo = nomeProfilo;
	}

	public boolean getProfiloDiDefault() {
		return this.profiloDiDefault;
	}

	public void setProfiloDiDefault(boolean profiloDiDefault) {
		this.profiloDiDefault = profiloDiDefault;
	}

	public List<CrzProfiliFunzione> getCrzProfiliFunziones() {
		if(crzProfiliFunziones == null) {
			crzProfiliFunziones = new ArrayList<CrzProfiliFunzione>();
		}
		
		return this.crzProfiliFunziones;
	}

	public void setCrzProfiliFunziones(List<CrzProfiliFunzione> crzProfiliFunziones) {
		this.crzProfiliFunziones = crzProfiliFunziones;
	}

	public CrzProfiliFunzione addCrzProfiliFunzione(CrzProfiliFunzione crzProfiliFunzione) {
		getCrzProfiliFunziones().add(crzProfiliFunzione);
		crzProfiliFunzione.setCrzProfili(this);

		return crzProfiliFunzione;
	}

	public CrzProfiliFunzione removeCrzProfiliFunzione(CrzProfiliFunzione crzProfiliFunzione) {
		getCrzProfiliFunziones().remove(crzProfiliFunzione);
		crzProfiliFunzione.setCrzProfili(null);

		return crzProfiliFunzione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((crzProfiliFunziones == null) ? 0 : crzProfiliFunziones.hashCode());
		result = prime * result + (int) (idProfilo ^ (idProfilo >>> 32));
		result = prime * result + ((nomeProfilo == null) ? 0 : nomeProfilo.hashCode());
		result = prime * result + (profiloDiDefault ? 1231 : 1237);
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
		CrzProfili other = (CrzProfili) obj;
		if (crzProfiliFunziones == null) {
			if (other.crzProfiliFunziones != null)
				return false;
		} else if (!crzProfiliFunziones.equals(other.crzProfiliFunziones))
			return false;
		if (idProfilo != other.idProfilo)
			return false;
		if (nomeProfilo == null) {
			if (other.nomeProfilo != null)
				return false;
		} else if (!nomeProfilo.equals(other.nomeProfilo))
			return false;
		if (profiloDiDefault != other.profiloDiDefault)
			return false;
		return true;
	}
	
	

}