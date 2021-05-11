package com.cg.onlineshopping.service;

import java.util.List;

import com.cg.onlineshopping.entities.Customer;
import com.cg.onlineshopping.pojo.InputCustomer;

public interface ICustomerService {
	public InputCustomer addCustomer(InputCustomer cust);
	public Customer updateCustomer(Customer cust);
	public Customer removeCustomer(Customer cust);
	public Customer viewCustomer(Customer cust);
	public List<Customer> viewAllCustomers(String location);

}
