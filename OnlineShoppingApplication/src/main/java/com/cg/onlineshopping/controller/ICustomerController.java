package com.cg.onlineshopping.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping.entities.Customer;
import com.cg.onlineshopping.pojo.InputCustomer;
import com.cg.onlineshopping.service.ICustomerService;
import com.cg.onlineshopping.service.impl.ICustomerServiceimpl;

@RestController
@RequestMapping("/api/v2")
public class ICustomerController {

	@Autowired
	ICustomerService customerService;
	Logger logger = LoggerFactory.getLogger(ICustomerController.class);
	
	@PostMapping(path="/createCustomer")
    public InputCustomer addCustomer( @RequestBody InputCustomer customer) {
        logger.info("Customer addCustomer");
        return customerService.addCustomer(customer) ;
    }
	
	@PutMapping(path="/updateCustomer")
    public Customer updateCustomer( @RequestBody Customer customer) {
		logger.info("Customer addCustomer");
        return customerService.updateCustomer(customer);
    }
	
	@DeleteMapping(path="/deleteCustomerById/{customerId}")
    public Customer removeCustomer( @RequestBody Customer customer) {
		logger.info("Customer removeCustomer");
        return customerService.removeCustomer(customer) ;
    }
	
	@GetMapping(path = "/getallcustomer/{location}")
    public List<Customer> viewAllCustomers(@PathVariable String location){
		logger.info("Customer viewAllCustomer");
        return customerService.viewAllCustomers(location) ;
        
    }
	
	@GetMapping(path = "/getCustomerById/{customerId}")
    public Customer viewCustomer(Customer customerId){
		logger.info("Customer viewCustomer");
        return customerService.viewCustomer(customerId) ;
    }


}