package com.ericsson.urm.persistence.dto.mgre;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.ericsson.urm.persistence.dto.mgre.datatype.LoadCurvesCcsState;



@Entity
@Table(name="GRE_STATUS_ACQ_LOADCURVE")
public class StatusAcqLoadCurve implements Serializable {
	private static final long serialVersionUID = -1;

	@Id
	@Column(name = "CONCENTRATOR_ID")
	private String ccsId;
	
	@Lob
	@Access( AccessType.FIELD )
	@Column(name = "STATUS_DATA")
	private byte[] loadCurvesCcsState;
	//private LoadCurvesCcsState loadCurvesCcsState = null;

	public StatusAcqLoadCurve() {

	}

	public StatusAcqLoadCurve(String ccsId, LoadCurvesCcsState loadCurvesCcsState) throws IOException {

		this.ccsId = ccsId;
		setLoadCurvesCcsState(loadCurvesCcsState);
	}

	public String getCcsId() {
		return ccsId;
	}

	public void setCcsId(String ccsId) {
		this.ccsId = ccsId;
	}

	public LoadCurvesCcsState getLoadCurvesCcsState() {
		try {
			return BlobUtil.toObject(loadCurvesCcsState, LoadCurvesCcsState.class);
		} catch (ClassNotFoundException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void setLoadCurvesCcsState(LoadCurvesCcsState loadCurvesCcsState) {
		try {
			this.loadCurvesCcsState = BlobUtil.toByteArray(loadCurvesCcsState);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ccsId == null) ? 0 : ccsId.hashCode());
		result = prime * result + Arrays.hashCode(loadCurvesCcsState);
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
		StatusAcqLoadCurve other = (StatusAcqLoadCurve) obj;
		if (ccsId == null) {
			if (other.ccsId != null)
				return false;
		} else if (!ccsId.equals(other.ccsId))
			return false;
		if (!Arrays.equals(loadCurvesCcsState, other.loadCurvesCcsState))
			return false;
		return true;
	}

}
