package com.cg.onlineshopping.service;

import java.util.List;

import com.cg.onlineshopping.entities.Address;

public interface IAddressService {

	public Address addAddress(Address add);
	public Address updateAddress(Address add);
	public Address removeAddress(int addressId);
	public List<Address> viewAllAddress();
	public Address viewAddress(int addressId);
	//Address viewAddressByCustomerId(int customerId);
	
	
}
