package com.temp.vo;

import java.util.Date;

/**
 * @author HZY
 *
 */
public class CustomerDataVo extends Vo {

	private long customerId; 
	private String customerName; 
	private int customerSex; 
	private int certificateType;	
	private String certificateNo;
	private Date openAccountDate; 
	private String unitName;	
	private String homeAddress; 
	private String phone; 
	private String mobile;
	private String post;
	private String remark; 	
	
	public CustomerDataVo() {}

	@Override
	public String toString() {
		return "CustomerDataVo [customerId=" + customerId + ", customerName=" + customerName + ", customerSex="
				+ customerSex + ", certificateType=" + certificateType + ", certificateNo=" + certificateNo
				+ ", openAccountDate=" + openAccountDate + ", unitName=" + unitName + ", homeAddress="
				+ homeAddress + ", phone=" + phone + ", mobile=" + mobile + ", post=" + post + ", remark=" + remark
				+ "]";
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
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

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
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
