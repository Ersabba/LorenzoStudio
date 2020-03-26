package com.ericsson.urm.persistence.dto.mgre.datatype;

import java.io.Serializable;
import java.util.Arrays;

public class XMLChunk implements Serializable {
	private static final long serialVersionUID = 1L;

	int idEs;
	int idSubSystem = -1;
	int lenght;
	char[] cbuf;
	boolean isLast;
	String filename = null;

	public int getIdEs() {
		return idEs;
	}

	public void setIdEs(int idEs) {
		this.idEs = idEs;
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	public char[] getCbuf() {
		return cbuf;
	}

	public void setCbuf(char[] cbuf) {
		this.cbuf = cbuf;
	}

	public boolean isLast() {
		return isLast;
	}

	public void setLast(boolean isLast) {
		this.isLast = isLast;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getIdSubSystem() {
		return idSubSystem;
	}

	public void setIdSubSystem(int idSubSystem) {
		this.idSubSystem = idSubSystem;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + ((filename == null) ? 0 : filename.hashCode());
		result = prime * result + idEs;
		result = prime * result + idSubSystem;
		result = prime * result + (isLast ? 1231 : 1237);
		result = prime * result + lenght;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final XMLChunk other = (XMLChunk) obj;
		if (!Arrays.equals(cbuf, other.cbuf))
			return false;
		if (filename == null) {
			if (other.filename != null)
				return false;
		} else if (!filename.equals(other.filename))
			return false;
		if (idEs != other.idEs)
			return false;
		if (idSubSystem != other.idSubSystem)
			return false;
		if (isLast != other.isLast)
			return false;
		if (lenght != other.lenght)
			return false;
		return true;
	}

}
