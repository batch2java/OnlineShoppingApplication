package com.cg.onlineshopping.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entities.Address;
import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.entities.Customer;
import com.cg.onlineshopping.error.CustomerNotFoundException;
import com.cg.onlineshopping.pojo.InputCustomer;
import com.cg.onlineshopping.repository.IAddressRepository;
import com.cg.onlineshopping.repository.ICustomerRepository;
import com.cg.onlineshopping.service.IAddressService;
import com.cg.onlineshopping.service.ICustomerService;
@Service
public class ICustomerServiceimpl implements ICustomerService {

	
	@Autowired
	ICustomerRepository customerRepo;
	@Autowired
	IAddressRepository addressRepo;
	Logger logger = LoggerFactory.getLogger(ICustomerServiceimpl.class);
	
	@Override
	public InputCustomer addCustomer(InputCustomer cust) {
		
	logger.info("Customer addCustomer");
	       Customer cust1 = new Customer();
	        Address add = new Address();
	        Cart cart = new Cart();
	        
	        
	        cust1.setFirstName(cust.getFirstName());
	        cust1.setLastName(cust.getLastName());
	        cust1.setEmail(cust.getEmail());
	        cust1.setMobileNumber(cust.getMobileNumber());
	        
	        add.setBuildingName(cust.getBuildingName());
	        add.setCity(cust.getCity());
	        add.setStreetNo(cust.getStreetNo());
	        add.setState(cust.getState());
	        add.setPincode(cust.getPincode());
	        add.setCountry(cust.getCountry());
	        
	        add.setCustomer(cust1);
	        cust1.setAddress(add);
	        
	       
			cart.setCustomer(cust1);
			cust1.setCart(cart);
			cust1=customerRepo.save(cust1);
			cust.setCustomerId(cust1.getCustomerId());
			cust.setAddressId(cust1.getAddress().getAddressId());
			cust.setCartId(cust1.getCart().getCartId());
			
			
			return cust;
			
			
		}
	

	@Override
	public Customer updateCustomer(Customer cust) {
		logger.info("Customer updateCustomer");

	
		if(cust== null) {
			throw new CustomerNotFoundException();
		}
		else{
			customerRepo.save(cust);
			return cust;
		}
	}

    @Override
	public Customer removeCustomer(Customer cust) {
    	
    	logger.info("Customer removeCustomer");

		Optional<Customer> customer=customerRepo.findById(cust.getCustomerId());
		if(!customer.isPresent()) {
			throw new CustomerNotFoundException();
		}
		else {
			customerRepo.delete(cust);
			return customer.get();	
		}
	}

	@Override
	public Customer viewCustomer(Customer cust) {
		
		logger.info("Customer viewCustomer");

		Optional<Customer> customer = customerRepo.findById(cust.getCustomerId());
		if(!customer.isPresent()) {
			throw new CustomerNotFoundException();
		}
		else
		return customer.get();	
	}

	@Override
	public List<Customer> viewAllCustomers(String location) {
		
		logger.info("Customer viewAllCustomers");

		List<Customer> list = customerRepo.viewAllCustomer(location);
		if(list.isEmpty())
			throw new CustomerNotFoundException();
		else
		return list;
	}
}