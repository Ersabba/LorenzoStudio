package com.ericsson.mgre.webapp.taskAdmin.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

import com.ericsson.mgre.biz.taskMgmt.task.dto.TaskDto;


/**
 * The form consists of a TaskDetails instance list, each wrapping information
 * about a task that was runned by the system in the past or that is actually
 * running.
 */
public class TaskDetailsForm extends ActionForm
{
	private List taskDetails;
	private List searchActivityInfos;
	private List searchStateInfos;
	private String searchActivity;
	private String searchState;
	private String start;
	private String range;
	private String results;


	public List getTaskDetails ()
	{
		return taskDetails;
	}

	public void setTaskDetails (List taskDetails)
	{
		this.taskDetails = taskDetails;
	}
	
	public String getSearchActivity ()
	{
		return searchActivity;
	}
	
	public void setSearchActivity (String searchActivity)
	{
		this.searchActivity = searchActivity;
	}
	
	public String getSearchState ()
	{
		return searchState;
	}
	
	public void setSearchState (String searchState)
	{
		this.searchState = searchState;
	}
	
	public List getSearchActivityInfos ()
	{
		return searchActivityInfos;
	}
	
	public void setSearchActivityInfos (List searchActivityInfos)
	{
		this.searchActivityInfos = searchActivityInfos;
	}

	public List getSearchStateInfos ()
	{
		/*if (searchStateInfos == null) {
			MessageResources resources = getServlet ().getResources ();
			
			List states = new ArrayList ();
			states.add (new TaskDetailsForm.SmartEntry (TaskDto.State.IDLE.toString (), "TaskState.literal.", resources));
			states.add (new TaskDetailsForm.SmartEntry (TaskDto.State.SCHEDULED.toString (), "TaskState.literal.", resources));
			states.add (new TaskDetailsForm.SmartEntry (TaskDto.State.RUNNING.toString (), "TaskState.literal.", resources));
			states.add (new TaskDetailsForm.SmartEntry (TaskDto.State.COMPLETED.toString (), "TaskState.literal.", resources));
			states.add (new TaskDetailsForm.SmartEntry (TaskDto.State.COMPLETED_WITH_ERRORS.toString (), "TaskState.literal.", resources));
			states.add (new TaskDetailsForm.SmartEntry (TaskDto.State.FAILED.toString (), "TaskState.literal.", resources));
			states.add (new TaskDetailsForm.SmartEntry (TaskDto.State.CANCELLED.toString (), "TaskState.literal.", resources));
			states.add (new TaskDetailsForm.SmartEntry (TaskDto.State.ABORTED.toString (), "TaskState.literal.", resources));
			
			searchStateInfos = states;
		}*/
		
		return searchStateInfos;
	}

	/**
	 * Wraps detailed information about a task.
	 */
	public static class TaskDetails implements Serializable
	{
		private final String id;
		private final String activityCode;
		private String activity;
		private final String targetType;
		private final String target;
		private final String expectedTime;
		private final String startTime;
		private final String endTime;
		private final String state;
		private final String result;
		private final boolean canClick;
		private String esitoOp;
		
		public TaskDetails (String id, String activityCode, String activity, String targetType, String target,
			String expectedTime, String startTime, String endTime, String state, String result, boolean canClick)
		{
			this.id = id;
			this.activityCode = activityCode;
			this.activity = activity;
			this.targetType = targetType;
			this.target = target;
			this.expectedTime = expectedTime;
			this.startTime = startTime;
			this.endTime = endTime;
			this.state = state;
			this.result = result;
			this.canClick = canClick;
		}
		
		/**
		 * Returns the task ID.
		 */
		public String getId () {
			return id;
		}
		
		/**
		 * Returns the activity code.
		 */
		public String getActivityCode () {
			return activityCode;
		}
		
		/**
		 * Returns the task underlying activity description.
		 */
		public String getActivity () {
			return activity;
		}
		
		public void setActivity (String activity) {
			this.activity = activity;
		}
		
		/**
		 * Returns the task target type (eg. LENNT, CCS or GROUP).
		 */
		public String getTargetType () {
			return targetType;
		}
		
		/**
		 * Returns the task target.
		 */
		public String getTarget () {
			return target;
		}
		
		/**
		 * Returns the time when the scheduled task is expected to start.
		 */
		public String getExpectedTime () {
			return expectedTime;
		}
		
		/**
		 * Returns the time when the task was started.
		 */
		public String getStartTime () {
			return startTime;
		}
		
		/**
		 * Returns the time when the task completed its execution,
		 * either if it succeeded or failed.
		 */
		public String getEndTime () {
			return endTime;
		}
		
		/**
		 * Returns the actual task execution state.
		 */
		public String getState () {
			return state;
		}
		
		/**
		 * Returns the final result of task execution, success or failure.
		 */
		public String getResult () {
			return result;
		}
		
		/**
		 * Indicates where the task can be clicked to navigate to the details page.
		 */
		public String getCanClick () {
			return new Boolean (canClick).toString ();
		}
		
		public String getEsitoOp () {
	    	return esitoOp;
	    }
	
	    public void setEsitoOp (String esitoOp) {
		   this.esitoOp = esitoOp;
	    }

        @Override
        public String toString() {
            return "TaskDetails{" +
                    "id='" + id + '\'' +
                    ", activityCode='" + activityCode + '\'' +
                    ", activity='" + activity + '\'' +
                    ", targetType='" + targetType + '\'' +
                    ", target='" + target + '\'' +
                    ", expectedTime='" + expectedTime + '\'' +
                    ", startTime='" + startTime + '\'' +
                    ", endTime='" + endTime + '\'' +
                    ", state='" + state + '\'' +
                    ", result='" + result + '\'' +
                    ", canClick=" + canClick +
                    ", esitoOp='" + esitoOp + '\'' +
                    '}';
        }
    }
	
	/**
	 * Wraps a form entry that must retain a value and its associated value
	 * to be used by struts html tags.
	 */
	public static final class SmartEntry implements Serializable
	{
		private final String value;
		private final String label;
		
		public SmartEntry (String value, String label)
		{
			this.value = value;
			this.label = label;
		}
		
		public SmartEntry (String value, String labelPrefix, MessageResources resources)
		{
			this (value, resources != null ? resources.getMessage (labelPrefix + value) : null);
		}
		
		public String getValue () {
			return value;
		}
		
		public String getLabel () {
			return label;
		}
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}
}