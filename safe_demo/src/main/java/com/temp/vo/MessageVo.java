package com.temp.vo;

public class MessageVo extends Vo {

	private long messageId;
	
	private int messageType;
	
	private String messageTitle;
	
	public MessageVo() {}

	@Override
	public String toString() {
		return "MessageVo [messageId=" + messageId + ", messageType=" + messageType + ", messageTitle=" + messageTitle
				+ "]";
	}

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public int getMessageType() {
		return messageType;
	}

	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	
}
