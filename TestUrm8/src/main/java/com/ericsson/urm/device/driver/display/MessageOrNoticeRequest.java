package com.ericsson.urm.device.driver.display;

import java.io.Serializable;

public class MessageOrNoticeRequest implements Serializable {

	private static final long serialVersionUID = -1L;
	
	public static enum ModeMessageManagement {
		VIEW(0),
		VIEW_AND_BUZZER(1),
		VIEW_AND_BUZZER_SAVES(2),
		SETS_PARAMETERS(3);
		
		private int mode;

		private ModeMessageManagement(int mode) {
			this.mode = mode;
		}

		public int getMode() {
			return mode;
		}
		
		public static ModeMessageManagement valueOf(int mode) {
			for(ModeMessageManagement curr : ModeMessageManagement.values()) {
				if(curr.mode == mode) {
					return curr;
				}
			}
			throw new IllegalArgumentException("Unknown ModeMessageManagement mode:"+mode+", valid values: 0-3");
		}
	}
	
	public static enum TargetMessage {
		LENNT(1),
		ACEALINK(2),
		LENNT_AND_ACEALINK(3);
		
		private int code;

		private TargetMessage(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}
		
		public static TargetMessage valueOf(int code) {
			for(TargetMessage curr : TargetMessage.values()) {
				if(curr.code == code) {
					return curr;
				}
			}
			throw new IllegalArgumentException("Unknown TargetMessage code: "+code+", valid codes are: 1-3");
		}
	}
	
	private boolean viewDisabled;
	private boolean notice;
	private int numberMissingFrame;
	private int progressiveMessage;
	private ModeMessageManagement modeMessageManagement = ModeMessageManagement.VIEW;
	private TargetMessage targetMessage = TargetMessage.LENNT;
	private String message;
	
	
	public MessageOrNoticeRequest() {
	}

	
	public MessageOrNoticeRequest(boolean viewDisabled, boolean notice,
			int numberMissingFrame, int progressiveMessage,
			ModeMessageManagement modeMessageManagement,
			TargetMessage targetMessage, String message) {
		
		this.viewDisabled = viewDisabled;
		this.notice = notice;
		this.numberMissingFrame = numberMissingFrame;
		this.progressiveMessage = progressiveMessage;
		this.modeMessageManagement = modeMessageManagement;
		this.targetMessage = targetMessage;
		this.message = message;
	}

	public boolean isViewDisabled() {
		return viewDisabled;
	}
	public void setViewDisabled(boolean viewDisabled) {
		this.viewDisabled = viewDisabled;
	}
	public boolean isNotice() {
		return notice;
	}
	public void setNotice(boolean notice) {
		this.notice = notice;
	}
	public int getNumberMissingFrame() {
		return numberMissingFrame;
	}
	public void setNumberMissingFrame(int numberMissingFrame) {
		if(numberMissingFrame<0 || numberMissingFrame>3) {
			throw new IllegalArgumentException("Number missing frame out of range 0-3");
		}
		this.numberMissingFrame = numberMissingFrame;
	}
	public int getProgressiveMessage() {
		return progressiveMessage;
	}
	public void setProgressiveMessage(int progressiveMessage) {
		this.progressiveMessage = progressiveMessage;
	}
	public ModeMessageManagement getModeMessageManagement() {
		return modeMessageManagement;
	}
	public void setModeMessageManagement(ModeMessageManagement modeMessageManagement) {
		this.modeMessageManagement = modeMessageManagement;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public TargetMessage getTargetMessage() {
		return targetMessage;
	}
	public void setTargetMessage(TargetMessage targetMessage) {
		this.targetMessage = targetMessage;
	}

	public void setAttributeMessage(int attributeMessage) {
		viewDisabled = ((attributeMessage & 0x80)==1);
		modeMessageManagement = ModeMessageManagement.valueOf((attributeMessage >> 5) & 0x03);
		numberMissingFrame = ((attributeMessage >> 3) & 0x03);
		targetMessage = TargetMessage.valueOf((attributeMessage >> 1) & 0x03);
		notice = ((attributeMessage & 0x01)==1);
	}
	
	public int setAttributeMessage() {
		int attr = 0;
		attr |= notice ? 0x01 : 0x00;
		attr |= (targetMessage!=null ? targetMessage.getCode() : TargetMessage.LENNT.getCode()) << 1;
		attr |= numberMissingFrame << 3;
		attr |= (modeMessageManagement!=null ? modeMessageManagement.getMode() : ModeMessageManagement.VIEW.getMode()) << 5;
		attr |= viewDisabled ? 0x80 : 0x00;
		
		return attr;
	}
}
