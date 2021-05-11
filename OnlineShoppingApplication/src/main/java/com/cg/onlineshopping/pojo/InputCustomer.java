package com.cg.onlineshopping.pojo;

import javax.validation.constraints.NotEmpty;

public class InputCustomer {
	private Integer customerId;
	@NotEmpty(message= "First Name can not be null")
	private String firstName;
	@NotEmpty(message= "Last Name can not be null")
	private String lastName;
	@NotEmpty(message= "mobileNumber can not be null")
	private String mobileNumber;
	@NotEmpty(message= "email can not be null")
	private String email;
	private int addressId;
	@NotEmpty(message= "strretNo can not be null")
	private String streetNo;
	@NotEmpty(message= "buildingName can not be null")
	private String buildingName;
	@NotEmpty(message= "city can not be null")
	private String  city;
	@NotEmpty(message= "state can not be null")
	private String state;
	@NotEmpty(message= "country can not be null")
	private String country;	
	@NotEmpty(message= "pincode can not be null")
	private String pincode;
	private Integer cartId;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getStreetNo() {
		return streetNo;
	}
	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}


}
