package com.ericsson.mgre.biz.taskMgmt.flow.dto;

import java.io.Serializable;

public class GreTaskGenericFlowDto  implements Serializable {

	private static final long serialVersionUID = -1L;

	private Long id = null;
	private String name = null;
	private String sqlString = null; 
	private String fileExtension = null;	
	private String fileNamePrefix = null;	
	private String externalSystem = null; 
	private String externalPath = null;
	private String externalPathTmp = null;
	private Integer	fileMaxRecordNum = 0;
	private boolean header = true;
	private String fieldsSeparator = null; 
	private boolean fieldsContainer = false;
	private boolean zip = false;
	private String referencePeriod = null;
	private String periodicity = null;	

	public GreTaskGenericFlowDto() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSqlString() {
		return sqlString;
	}

	public void setSqlString(String sqlString) {
		this.sqlString = sqlString;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public String getFileNamePrefix() {
		return fileNamePrefix;
	}

	public void setFileNamePrefix(String fileNamePrefix) {
		this.fileNamePrefix = fileNamePrefix;
	}

	public String getExternalSystem() {
		return externalSystem;
	}

	public void setExternalSystem(String externalSystem) {
		this.externalSystem = externalSystem;
	}

	public String getExternalPath() {
		return externalPath;
	}

	public void setExternalPath(String externalPath) {
		this.externalPath = externalPath;
	}

	public Integer getFileMaxRecordNum() {
		return fileMaxRecordNum;
	}

	public void setFileMaxRecordNum(Integer fileMaxRecordNum) {
		this.fileMaxRecordNum = fileMaxRecordNum;
	}

	public String getFieldsSeparator() {
		return fieldsSeparator;
	}

	public void setFieldsSeparator(String fieldsSeparator) {
		this.fieldsSeparator = fieldsSeparator;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReferencePeriod() {
		return referencePeriod;
	}

	public void setReferencePeriod(String referencePeriod) {
		this.referencePeriod = referencePeriod;
	}

	public String getExternalPathTmp() {
		return externalPathTmp;
	}

	public void setExternalPathTmp(String externalPathTmp) {
		this.externalPathTmp = externalPathTmp;
	}
	
	public boolean isHeader() {
		return header;
	}

	public void setHeader(boolean header) {
		this.header = header;
	}

	public boolean isFieldsContainer() {
		return fieldsContainer;
	}

	public void setFieldsContainer(boolean fieldsContainer) {
		this.fieldsContainer = fieldsContainer;
	}
	
	public boolean isZip() {
		return zip;
	}

	public void setZip(boolean zip) {
		this.zip = zip;
	}

	public String getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(String periodicity) {
		this.periodicity = periodicity;
	}
	
}
