package com.cg.onlineshopping.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping.entities.Address;
import com.cg.onlineshopping.service.IAddressService;


@RestController
@RequestMapping("/api/v2")


public class IAddressController {
	@Autowired(required=true)
	IAddressService addressService;
	Logger logger = LoggerFactory.getLogger(IAddressController.class);

	
	@PostMapping(path="/create")
	public Address addAddress(@RequestBody Address add)
	{
		logger.info("Address addAddress()");
		return addressService.addAddress(add);
	}

	@PutMapping("/update")
	public Address updateAddress(@RequestBody Address add)
	{
		logger.info("Address updateAddress()");
		return addressService.updateAddress(add);
	}

	@DeleteMapping("/deleteById/{addressId}")
	public Address removeCustomer(@PathVariable int addressId)
	{
		logger.info("Address removeAddress()");
		return addressService.removeAddress(addressId);
	}
	@GetMapping(path = "/getall")
	public List<Address> viewAllAddress()
	{
		logger.info("Address viewAllAddress()");
		return addressService.viewAllAddress();
	}
	@GetMapping(path = "/getall/{addressId}")
	public Address viewAddress(@PathVariable int addressId)
	{
		logger.info("Address viewAddress(addressId)");
		return addressService.viewAddress(addressId);
	}
	
   

}
