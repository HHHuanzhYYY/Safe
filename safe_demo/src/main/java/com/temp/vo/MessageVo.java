package com.temp.vo;

//import java.util.List;

public class MessageVo extends Vo {

	private long messageId;
	
	private int messageType;
	
	private String messageTitle;
	
	private String messageContent;
	
	private String remark;
	
	//private int messagereceiversType; // 0: all 
	
	//private List<MessageReceiverVo> messageReceivers;
	
	public MessageVo() {}

	@Override
	public String toString() {
		return "MessageVo [messageId=" + messageId + ", messageType=" + messageType + ", messageTitle=" + messageTitle
				+ ", messageContent=" + messageContent + ", remark=" + remark + "]";
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

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
