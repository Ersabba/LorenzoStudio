package com.ericsson.urm.core.taskmanagement;

import java.io.Serializable;

import com.ericsson.urm.core.datatypes.IdClient;

public class TaskExecutorParameter implements Serializable {
	
	private static final long serialVersionUID = -1L;
	
	private IdClient idClient = null;
	private String	 idClientRequest = null;
	private TaskSource taskSource = null;
	private TaskCode taskCode = null; 
	private Long delayMsg = null; 
	private Boolean singletask = null;
	private Boolean keepold = null;
	private Integer numRetry = null;
	private Long retriesDelay = null;
	private Serializable inputParameter = null;
	private String notOverlappingTasks = null;
	private String runByTask = null;
	
	private Boolean uniqueReference = null;
	
	public TaskExecutorParameter() {
		
	}

	public TaskExecutorParameter(IdClient idClient, String idClientRequest,
			TaskSource taskSource, TaskCode taskCode, Serializable inputParameter, String runByTask) {
		super();
		this.idClient = idClient;
		this.idClientRequest = idClientRequest;
		this.taskSource = taskSource;
		this.taskCode = taskCode;
		this.inputParameter = inputParameter;
		this.runByTask = runByTask;
	}

	public TaskExecutorParameter(IdClient idClient, String idClientRequest,
			TaskSource taskSource, TaskCode taskCode, Long delayMsg, 
			Boolean singletask, Boolean keepold, Integer numRetry, Long retriesDelay,
			Serializable inputParameter, String notOverlappingTasks, String runByTask) {
		super();
		this.idClient = idClient;
		this.idClientRequest = idClientRequest;
		this.taskSource = taskSource;
		this.taskCode = taskCode;
		this.delayMsg = delayMsg;
		this.singletask = singletask;
		this.keepold = keepold;
		this.numRetry = numRetry;
		this.retriesDelay = retriesDelay;
		this.inputParameter = inputParameter;
		this.notOverlappingTasks = notOverlappingTasks;
		this.runByTask = runByTask;
	}


	public IdClient getIdClient() {
		return idClient;
	}
	public void setIdClient(IdClient idClient) {
		this.idClient = idClient;
	}
	public String getIdClientRequest() {
		return idClientRequest;
	}
	public void setIdClientRequest(String idClientRequest) {
		this.idClientRequest = idClientRequest;
	}
	public TaskSource getTaskSource() {
		return taskSource;
	}
	public void setTaskSource(TaskSource taskSource) {
		this.taskSource = taskSource;
	}
	public TaskCode getTaskCode() {
		return taskCode;
	}		
	public void setTaskCode(TaskCode taskCode) {
		this.taskCode = taskCode;
	}
	public Long getDelayMsg() {
		return delayMsg;
	}
	public void setDelayMsg(Long delayMsg) {
		this.delayMsg = delayMsg;
	}
	public Boolean getSingletask() {
		return singletask;
	}
	public void setSingletask(Boolean singletask) {
		this.singletask = singletask;
	}
	public Boolean getKeepold() {
		return keepold;
	}
	public void setKeepold(Boolean keepold) {
		this.keepold = keepold;
	}
	public Integer getNumRetry() {
		return numRetry;
	}
	public void setNumRetry(Integer numRetry) {
		this.numRetry = numRetry;
	}
	public Long getRetriesDelay() {
		return retriesDelay;
	}

	public void setRetriesDelay(Long retriesDelay) {
		this.retriesDelay = retriesDelay;
	}

	public Serializable getInputParameter() {
		return inputParameter;
	}
	public void setInputParameter(Serializable inputParameter) {
		this.inputParameter = inputParameter;
	}
	

	public Boolean getUniqueReference() {
		return uniqueReference;
	}

	public void setUniqueReference(Boolean uniqueReference) {
		this.uniqueReference = uniqueReference;
	}

	public String getNotOverlappingTasks() {
		return notOverlappingTasks;
	}

	public void setNotOverlappingTasks(String notOverlappingTasks) {
		this.notOverlappingTasks = notOverlappingTasks;
	}

	public String getRunByTask() {
		return runByTask;
	}

	public void setRunByTask(String runByTask) {
		this.runByTask = runByTask;
	}

	public void validate() {
		
		if( idClient==null ) {
			throw new IllegalArgumentException("Undefined mandatory idClient argument");
		}
		if( taskSource==null ) {
			throw new IllegalArgumentException("Undefined mandatory taskSource argument");
		}	
		if( taskCode==null ) {
			throw new IllegalArgumentException("Undefined mandatory taskCode argument");
		}
	}
}
