package com.temp.po;

import java.util.List;

public class MessagePo extends Po {

	private int messageId;
	
	private int messageType;
	
	private String messageTitle;
	
	private String messageContent;
	
	private int messageReceiverType; // 0-部分员工, 1-全部员工(消息收件人为NULL)
	
	private List<Integer> messageReceivers;
	
	private String remark;
	
	public MessagePo() {}

	@Override
	public String toString() {
		return "MessagePo [messageId=" + messageId + ", messageType=" + messageType + ", messageTitle=" + messageTitle
				+ ", messageContent=" + messageContent + ", messageReceiverType=" + messageReceiverType
				+ ", messageReceivers=" + messageReceivers + ", remark=" + remark + "]";
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

	public int getMessageReceiverType() {
		return messageReceiverType;
	}

	public void setMessageReceiverType(int messageReceiverType) {
		this.messageReceiverType = messageReceiverType;
	}

	public List<Integer> getMessageReceivers() {
		return messageReceivers;
	}

	public void setMessageReceivers(List<Integer> messageReceivers) {
		this.messageReceivers = messageReceivers;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
