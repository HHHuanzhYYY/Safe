package com.temp.po;

import java.util.List;

public class MessagePo extends Po {

	private int messageId;
	
	private int messageType;
	
	private String messageTitle;
	
	private String messageContent;
	
	private List<String> messageReceivers;
	
	private String remark;
	
	public MessagePo() {}

	@Override
	public String toString() {
		return "MessagePo [messageId=" + messageId + ", messageType=" + messageType + ", messageTitle=" + messageTitle
				+ ", messageContent=" + messageContent + ", messageReceivers=" + messageReceivers + ", remark=" + remark
				+ "]";
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
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

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public List<String> getMessageReceivers() {
		return messageReceivers;
	}

	public void setMessageReceivers(List<String> messageReceivers) {
		this.messageReceivers = messageReceivers;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
