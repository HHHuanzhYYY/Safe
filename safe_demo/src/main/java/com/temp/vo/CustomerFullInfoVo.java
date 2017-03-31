package com.temp.vo;

public class CustomerFullInfoVo extends Vo {

	private long customerId; //(客户 ID)	
	
	private int customerType; //(客户类型)	
	
	private String customerName; //(姓名)	
	
	private String customerPwd; //(密码)	
	
	private int customerSex; //(性别)	
	
	private int certificateType; //(证件类型)	
	
	private String certificateNo; //(证件号)	
	
	private String homeAddress; //(家庭地址)	
	
	private String unitAddress; //(公司地址)	
	
	private String phone; //(电话号码)	
	
	private String mobile; //(手机号)	
	
	private String post; //(邮编)	
	
	private String photo; //(照片)	
	
	private String remark; //(备注)	

	public CustomerFullInfoVo() {}

	@Override
	public String toString() {
		return "CustomerFullInfoVo [customerId=" + customerId + ", customerType=" + customerType + ", customerName="
				+ customerName + ", customerPwd=" + customerPwd + ", customerSex=" + customerSex + ", certificateType="
				+ certificateType + ", certificateNo=" + certificateNo + ", homeAddress=" + homeAddress
				+ ", unitAddress=" + unitAddress + ", phone=" + phone + ", mobile=" + mobile + ", post=" + post
				+ ", photo=" + photo + ", remark=" + remark + "]";
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public int getCustomerType() {
		return customerType;
	}

	public void setCustomerType(int customerType) {
		this.customerType = customerType;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPwd() {
		return customerPwd;
	}

	public void setCustomerPwd(String customerPwd) {
		this.customerPwd = customerPwd;
	}

	public int getCustomerSex() {
		return customerSex;
	}

	public void setCustomerSex(int customerSex) {
		this.customerSex = customerSex;
	}

	public int getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(int certificateType) {
		this.certificateType = certificateType;
	}

	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getUnitAddress() {
		return unitAddress;
	}

	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
