package com.ericsson.mgre.recipient;

import java.util.ArrayList;
import java.util.List;

import com.ericsson.urm.persistence.dto.mgre.QdsTensioneMaxMinWeek;


public class ExportWeeklyVmxVmnRecipient implements Recipient {

	private static final long					serialVersionUID	= 1L;	
	
	private String								week				= null;
	private int									anno				= -1;
	private int									idxSubfile			= -1;
	private int									totSubfile			= -1;
	List<QdsTensioneMaxMinWeek> 				qdsList =  new ArrayList<QdsTensioneMaxMinWeek>();
	
	@Override
	public String getRecipientId() {
		// TODO Auto-generated method stub
		return  String.valueOf(idxSubfile);
	}
		
	public ExportWeeklyVmxVmnRecipient(String week, int anno, int idxSubfile,
			int totSubfile, List<QdsTensioneMaxMinWeek> qdsList) {
		super();
		this.week = week;
		this.anno = anno;
		this.idxSubfile = idxSubfile;
		this.totSubfile = totSubfile;
		this.qdsList = qdsList;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public int getIdxSubfile() {
		return idxSubfile;
	}

	public void setIdxSubfile(int idxSubfile) {
		this.idxSubfile = idxSubfile;
	}

	public int getTotSubfile() {
		return totSubfile;
	}

	public void setTotSubfile(int totSubfile) {
		this.totSubfile = totSubfile;
	}

	public List<QdsTensioneMaxMinWeek> getQdsList() {
		return qdsList;
	}

	public void setQdsList(List<QdsTensioneMaxMinWeek> qdsList) {
		this.qdsList = qdsList;
	}
}
