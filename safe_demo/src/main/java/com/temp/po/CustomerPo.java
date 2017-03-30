package com.temp.po;

public class CustomerPo extends Po {
	
	private long customerId;
	
	private int customerType;
	
	private String customerName;
	
	private int customerSex; 
	
	private int certificateType;
	
	private String certificateNo;
	
	private String unitAddress;
	
	private String homeAddress;
	
	private String phone;
	
	private String mobile;
	
	private String post;
	
	private String remark;
	
	private String photo;
	
	// Card Details.
	private int cardType;
	
	private String cardRfid;
	
	private String cardNo;
	
	private int validateType;
	
	private String password;
	
	private String fingerPwd;
	
	private String reserveFingerPwd;
	
	public CustomerPo() {}
	
	// Construct CardPo.
	public CardPo buildCardPo() {
		CardPo retCardPo = new CardPo();
		retCardPo.setCardType(getCardType());
		retCardPo.setCardRfid(getCardRfid());
		retCardPo.setCardNo(getCardNo());
		retCardPo.setValidateType(getValidateType());
		retCardPo.setPassword(getPassword());
		retCardPo.setFingerPwd(getFingerPwd());
		retCardPo.setReserveFingerPwd(getReserveFingerPwd());
		return retCardPo;
	}
	
	@Override
	public String toString() {
		return "CustomerPo [customerId=" + customerId + ", customerType=" + customerType + ", customerName="
				+ customerName + ", customerSex=" + customerSex + ", certificateType=" + certificateType
				+ ", certificateNo=" + certificateNo + ", unitAddress=" + unitAddress + ", homeAddress=" + homeAddress
				+ ", phone=" + phone + ", mobile=" + mobile + ", post=" + post + ", remark=" + remark + ", photo="
				+ photo + ", cardType=" + cardType + ", cardRfid=" + cardRfid + ", cardNo=" + cardNo + ", validateType="
				+ validateType + ", password=" + password + ", fingerPwd=" + fingerPwd + ", reserveFingerPwd="
				+ reserveFingerPwd + "]";
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getCardType() {
		return cardType;
	}

	public void setCardType(int cardType) {
		this.cardType = cardType;
	}

	public String getCardRfid() {
		return cardRfid;
	}

	public void setCardRfid(String cardRfid) {
		this.cardRfid = cardRfid;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public int getValidateType() {
		return validateType;
	}

	public void setValidateType(int validateType) {
		this.validateType = validateType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFingerPwd() {
		return fingerPwd;
	}

	public void setFingerPwd(String fingerPwd) {
		this.fingerPwd = fingerPwd;
	}

	public String getReserveFingerPwd() {
		return reserveFingerPwd;
	}

	public void setReserveFingerPwd(String reserveFingerPwd) {
		this.reserveFingerPwd = reserveFingerPwd;
	}
	
}
