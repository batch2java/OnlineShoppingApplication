package com.cg.onlineshopping.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineshopping.entities.Address;

public interface IAddressRepository extends JpaRepository<Address,Integer> {  
	/*public Address AddAddress(Address add);
	public Address updateAddress(Address add);
	public Address removeAddress(Address add);
	public List<Address> viewAllAddress(String id);
	public Address viewAddress(Address add);*/
	


//Address viewAddressByCustomerId(int customerId);


}
