package com.ericsson.mgre.datatypes;

import java.io.Serializable;

public class ThorAdditionalInfo implements Serializable {
	
	public static enum ThorAdditionalInfoKeys {
		
		
		DIRECTORY("DIRECTORY"), 
		OBJ_THOR_IDSESSION("IdThorList"),
		PROVENIENZA("Provenienza");
		
		private String value;
		
		private ThorAdditionalInfoKeys(String value){
			this.value = value;
		}

		public String getValue() {
			return value;
		}
		
		public static ThorAdditionalInfoKeys parse (String value){
			for(ThorAdditionalInfoKeys curr : ThorAdditionalInfoKeys.values()){
				if(curr.toString().equalsIgnoreCase(value)){
					return curr;					
				}
			}
			
			throw new IllegalArgumentException ("ThorAdditionalInfoKeys: unsupported value " + value);
		}
		
	}

	private static final long serialVersionUID = 1L;
	
	private String directory;
	private String idSessione;
	private String provenienza;
	
	
	public ThorAdditionalInfo() {
		super();
	}
	


	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}



	public String getIdSessione() {
		return idSessione;
	}

	public void setIdSessione(String idSessione) {
		this.idSessione = idSessione;
	}



	public String getProvenienza() {
		return provenienza;
	}



	public void setProvenienza(String provenienza) {
		this.provenienza = provenienza;
	}



	@Override
	public String toString() {
		return "ThorAdditionalInfo [directory=" + directory + ", idSessione="
				+ idSessione + ", provenienza=" + provenienza + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((directory == null) ? 0 : directory.hashCode());
		result = prime * result
				+ ((idSessione == null) ? 0 : idSessione.hashCode());
		result = prime * result
				+ ((provenienza == null) ? 0 : provenienza.hashCode());
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
		ThorAdditionalInfo other = (ThorAdditionalInfo) obj;
		if (directory == null) {
			if (other.directory != null)
				return false;
		} else if (!directory.equals(other.directory))
			return false;
		if (idSessione == null) {
			if (other.idSessione != null)
				return false;
		} else if (!idSessione.equals(other.idSessione))
			return false;
		if (provenienza == null) {
			if (other.provenienza != null)
				return false;
		} else if (!provenienza.equals(other.provenienza))
			return false;
		return true;
	}

}
