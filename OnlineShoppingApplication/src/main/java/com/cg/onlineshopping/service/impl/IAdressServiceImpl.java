package com.cg.onlineshopping.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entities.Address;
import com.cg.onlineshopping.error.AddressNotFoundException;
import com.cg.onlineshopping.repository.IAddressRepository;
import com.cg.onlineshopping.service.IAddressService;
@Service
public class IAdressServiceImpl implements IAddressService {
@Autowired
IAddressRepository addressRepo;
Logger logger = LoggerFactory.getLogger(IAdressServiceImpl.class);

	

@Override
public Address addAddress(Address add) {
	logger.info("Address AddAddress()");

	if(add == null)
		throw new AddressNotFoundException();

	else{
		addressRepo.save(add);

		return add;
	}
}


	@Override
	public Address updateAddress(Address add) {
		// TODO Auto-generated method stub
		logger.info("Address updateAddress()");
		if(add == null)
			throw new AddressNotFoundException();
		else {
			addressRepo.save(add);
			return add;
		}
	
	}

	@Override
	public Address removeAddress(int addressId) {
		// TODO Auto-generated method stub
		logger.info("Address removeAddress()");
		Optional<Address> add = addressRepo.findById(addressId);
		if(!add.isPresent())
			throw new AddressNotFoundException();
		else {
			addressRepo.deleteById(addressId);
			return add.get();
		}
		
	}

	@Override
	public List<Address> viewAllAddress() {
		// TODO Auto-generated method stub
		logger.info("Address viewAllAddress()");
		List<Address> list = addressRepo.findAll();
		if(list.isEmpty())
			throw new AddressNotFoundException();
		else
			return list;
	}

	@Override
	public Address viewAddress(int addressId) {
		// TODO Auto-generated method stub
		logger.info("Address viewAddress()");
		Optional<Address> viewAdd = addressRepo.findById(addressId);
		if(!viewAdd.isPresent())
			throw new AddressNotFoundException();
		else {
			return viewAdd.get();
		}
	}
	
	/*@Override
	public Address viewAddressByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		Address add = addRepo.viewAddressByCustomerId(customerId);
		return add ;
	}*/
}


