package com.temp.po;

public class CustomerDataPo extends Po {

	private int customerId; // �ͻ�ID	
	private String unitAddress; // ��λ��ַ	
	private String homeAddress; // ��ͥ��ַ	
	private String phone; // ��ϵ��ʽ	
	private String mobile; // �ֻ���	
	private String post; // �ʱ�	
	private String remark; // ��ע
	
	public CustomerDataPo() {}

	@Override
	public String toString() {
		return "CustomerDataPo [customerId=" + customerId + ", unitAddress=" + unitAddress + ", homeAddress="
				+ homeAddress + ", phone=" + phone + ", mobile=" + mobile + ", post=" + post + ", remark=" + remark
				+ "]";
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getUnitAddress() {
		return unitAddress;
	}

	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
