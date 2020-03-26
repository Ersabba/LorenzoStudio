package com.ericsson.urm.persistence.dto.mgre;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="GRE_LENNT_ASS_FILE_INVIATI")
public class LenntAssociatiCcs implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private LenntAssociatiCcsId id;
	
	public LenntAssociatiCcs() {
		super();
	}

	@Column(name="DATA_FILENEW")
	private Date dataFileNew;

	public LenntAssociatiCcs(LenntAssociatiCcsId id, Date dataFileNew) {
		super();
		this.id = id;
		this.dataFileNew = dataFileNew;
	}

	public LenntAssociatiCcsId getId() {
		return id;
	}

	public void setId(LenntAssociatiCcsId id) {
		this.id = id;
	}

	public Date getDataFileNew() {
		return dataFileNew;
	}

	public void setDataFileNew(Date dataFileNew) {
		this.dataFileNew = dataFileNew;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataFileNew == null) ? 0 : dataFileNew.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		LenntAssociatiCcs other = (LenntAssociatiCcs) obj;
		if (dataFileNew == null) {
			if (other.dataFileNew != null)
				return false;
		} else if (!dataFileNew.equals(other.dataFileNew))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LenntAssociatiCcs [id=" + id + ", dataFileNew=" + dataFileNew + "]";
	}
}