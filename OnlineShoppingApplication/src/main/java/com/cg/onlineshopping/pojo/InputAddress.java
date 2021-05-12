package com.cg.onlineshopping.pojo;

import javax.validation.constraints.NotEmpty;

public class InputAddress {
private int addressId;
@NotEmpty(message="Street_no should not empty")
private String streetNo;
@NotEmpty(message="building name should not empty")
private String buildingName;
@NotEmpty(message="city should not empty")
private String  city;
@NotEmpty(message="State should not empty")
private String state;
@NotEmpty(message="country name  should not empty")
private String country;
@NotEmpty(message="pincode should not empty")
private String pincode;
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


}


