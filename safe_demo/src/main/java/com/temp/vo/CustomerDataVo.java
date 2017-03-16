package com.temp.vo;

import java.util.Date;

/**
 * @author HZY
 *
 */
public class CustomerDataVo extends Vo {

	private int customerId; // 客户ID	
	private String customerName;  // 姓名	
	private int customerSex; // 性别	
	private int certificateType; // 证件类型	
	private String certificateNo; // 证件号	
	private Date openAccountDate; // 开户日期	
	private String unitAddress; // 单位地址	
	private String homeAddress; // 家庭地址	
	private String phone; // 联系方式	
	private String mobile; // 手机号	
	private String post; // 邮编	
	private String remark; // 备注	
	
	public CustomerDataVo() {}

	@Override
	public String toString() {
		return "CustomerDataVo [customerId=" + customerId + ", customerName=" + customerName + ", customerSex="
				+ customerSex + ", certificateType=" + certificateType + ", certificateNo=" + certificateNo
				+ ", openAccountDate=" + openAccountDate + ", unitAddress=" + unitAddress + ", homeAddress="
				+ homeAddress + ", phone=" + phone + ", mobile=" + mobile + ", post=" + post + ", remark=" + remark
				+ "]";
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public Date getOpenAccountDate() {
		return openAccountDate;
	}

	public void setOpenAccountDate(Date openAccountDate) {
		this.openAccountDate = openAccountDate;
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
