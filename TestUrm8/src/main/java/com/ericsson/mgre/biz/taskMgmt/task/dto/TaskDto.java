package com.ericsson.mgre.biz.taskMgmt.task.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ericsson.mgre.biz.taskMgmt.activity.dto.ActivityDto;

/**
 * The Task bean data transfer object.
 * It encapsulates the Task bean fields allowing them to be
 * transferred across the session facade layer.
 */
public class TaskDto implements Serializable
{
	private long id;
	private ActivityDto activity;
	private State state;
	private Date expectedStartTime;
	private Date startTime;
	private Date lastStateUpdateTime;
	private Object additionalInfos;
	private List targets;
	private TargetType targetType;
	private boolean onDemand;
	
	public boolean isOnDemand() {
		return onDemand;
	}

	public void setOnDemand(boolean onDemand) {
		this.onDemand = onDemand;
	}

	public long getId () {
		return id;
	}
	
	public void setId (long id) {
		this.id = id;
	}
	
	public ActivityDto getActivity () {
		return activity;
	}
	
	public void setActivity (ActivityDto activity) {
		this.activity = activity;
	}
	
	public State getState () {
		return state;
	}
	
	public void setState (State state) {
		this.state = state;
	}
	
	public Date getExpectedStartTime () {
		return expectedStartTime;
	}
	
	public void setExpectedStartTime (Date expectedStartTime) {
		this.expectedStartTime = expectedStartTime;
	}
	
	public Date getStartTime () {
		return startTime;
	}
	
	public void setStartTime (Date startTime) {
		this.startTime = startTime;
	}
	
	public Date getLastStateUpdateTime () {
		return lastStateUpdateTime;
	}
	
	public void setLastStateUpdateTime (Date lastStateUpdateTime) {
		this.lastStateUpdateTime = lastStateUpdateTime;
	}
	
	public Object getAdditionalInfos () {
		return additionalInfos;
	}
	
	public void setAdditionalInfos (Object additionalInfos) {
		this.additionalInfos = additionalInfos;
	}
	
	public List getTargets () {
		return targets;
	}
	
	public void setTargets (List targets) {
		this.targets = targets;
	}
	
	public TargetType getTargetType () {
		return targetType;
	}
	
	public void setTargetType (TargetType targetType) {
		this.targetType = targetType;
	}
	
	public boolean equals (Object other)
	{
		if (this == other) return true;
		if (other == null) return false;
		if (other instanceof TaskDto) {
			TaskDto dto = (TaskDto) other;
			return (
				                 (id == dto.getId ()) &&
				              (state == dto.getState ()               || state != null               && state.equals (dto.getState ())) &&
				  (expectedStartTime == dto.getExpectedStartTime ()   || expectedStartTime != null   && expectedStartTime.equals (dto.getExpectedStartTime ())) &&
				          (startTime == dto.getStartTime ()           || startTime != null           && startTime.equals (dto.getStartTime ())) &&
				(lastStateUpdateTime == dto.getLastStateUpdateTime () || lastStateUpdateTime != null && lastStateUpdateTime.equals (dto.getLastStateUpdateTime ())) &&
				    (additionalInfos == dto.getAdditionalInfos ()     || additionalInfos != null     && additionalInfos.equals (dto.getAdditionalInfos ())) &&
				           (activity == dto.getActivity ()            || activity != null            && activity.equals (dto.getActivity ())) &&
				         (targetType == dto.getTargetType ()          || targetType != null          && targetType.equals (dto.getTargetType ()) &&
				            onDemand == dto.isOnDemand())
				);
		}
		return false;
	}
	
	public int hashCode ()
	{
		return (
				new Long (id).toString ()
					+ state
					+ expectedStartTime
					+ startTime
					+ lastStateUpdateTime
					+ additionalInfos
			).hashCode ();
	}
	
	public String toString ()
	{
		return
			new Long (id).toString ()
				+ ", " + state
				+ ", " + expectedStartTime
				+ ", " + startTime
				+ ", " + lastStateUpdateTime;
	}
	
	/**
	 * Typed enumeration class whose purpose is to abstract
	 * the task current phase (state).
	 */
	public static final class State implements Serializable
	{
		/** The task has been created for the first time. */
		public static final State IDLE = new State ("IDLE");
		
		/** The task has been scheduled for execution. */
		public static final State SCHEDULED = new State ("SCHEDULED");
		
		/** The task has been delayed for execution. */
		public static final State WAITING = new State ("WAITING");
		
		/** The task is being executed. */
		public static final State RUNNING = new State ("RUNNING");
		
		/** The stuck task */
		public static final State STUCK = new State ("STUCK");
		
		/** The task has been successfully completed. */
		public static final State COMPLETED = new State ("COMPLETED");
		
		/** The task has been completed but some errors showed up. */
		public static final State COMPLETED_WITH_ERRORS = new State ("COMPLETED_WITH_ERRORS");
		
		/** The task is failed and its execution has terminated. */
		public static final State FAILED = new State ("FAILED");
		
		/**
		 * The task has been cancelled. It had the SCHEDULED state and the operator
		 * has modified the task starting time.
		 */
		public static final State CANCELLED = new State ("CANCELLED");
		
		/**
		 * The operator or the system supervisor has abruptly terminated execution
		 * without waiting for the task to complete its work.
		 */
		public static final State ABORTED = new State ("ABORTED");
		
		private final String literal;
		
		private State (String literal) {
			this.literal = literal;
		}
		
		public static State parse (String literal)
		{
	        if (IDLE.literal.equals (literal))      return IDLE;
	        if (SCHEDULED.literal.equals (literal)) return SCHEDULED;
	        if (WAITING.literal.equals (literal))   return WAITING;
	        if (RUNNING.literal.equals (literal))   return RUNNING;
	        if (COMPLETED.literal.equals (literal)) return COMPLETED;
	        if (COMPLETED_WITH_ERRORS.literal.equals (literal)) return COMPLETED_WITH_ERRORS;
	        if (FAILED.literal.equals (literal))    return FAILED;
	        if (CANCELLED.literal.equals (literal)) return CANCELLED;
	        if (ABORTED.literal.equals (literal))   return ABORTED;
	        if (STUCK.literal.equals (literal))     return STUCK;
	
	        throw new IllegalArgumentException (
					"TaskDto.State.parse: unsupported literal value " + literal
				);
		}
		
		public String toString () {
			return literal;
		}
		
		public boolean equals (Object other)
		{
			if (this == other) return true;
			if (other == null) return false;
			if (other instanceof State) {
				return ((State) other).literal.equals (literal);
			}
			return false;
		}
		
		public int hashCode () {
			return literal.hashCode ();
		}
	}
	
	/**
	 * Typed enumeration class whose purpose is to abstract
	 * the task target type.
	 */
	public static final class TargetType implements Serializable
	{
		public static final TargetType DEFAULT = new TargetType ("DEFAULT");
		public static final TargetType ALINK   = new TargetType ("ALINK");
		public static final TargetType LENNT   = new TargetType ("LENNT");
		public static final TargetType CCS     = new TargetType ("CCS");
		public static final TargetType CS      = new TargetType ("CS");
		public static final TargetType GROUP   = new TargetType ("GROUP");
		
		private final String literal;
		
		private TargetType (String literal) {
			this.literal = literal;
		}
		
		public static TargetType parse (String literal)
		{
	        if (DEFAULT.literal.equals (literal)) return DEFAULT;
	        if (ALINK.literal.equals (literal))   return ALINK;
	        if (LENNT.literal.equals (literal))   return LENNT;
	        if (CCS.literal.equals (literal))     return CCS;
	        if (CS.literal.equals (literal))      return CS;
	        if (GROUP.literal.equals (literal))   return GROUP;

	        throw new IllegalArgumentException (
					"TaskDto.TargetType.parse: unsupported literal value " + literal
				);
		}
		
		public String toString () {
			return literal;
		}
		
		public boolean equals (Object other)
		{
			if (this == other) return true;
			if (other == null) return false;
			if (other instanceof TargetType) {
				return ((TargetType) other).literal.equals (literal);
			}
			return false;
		}
		
		public int hashCode () {
			return literal.hashCode ();
		}
	}
}
