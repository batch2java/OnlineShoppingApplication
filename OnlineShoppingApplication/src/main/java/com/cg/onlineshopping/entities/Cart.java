package com.cg.onlineshopping.entities;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
@Entity
public class Cart {
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cart_seq")
    @SequenceGenerator(sequenceName = "cart_seq", allocationSize = 1, name = "cart_seq")
	private Integer cartId;
	//private String userId;
	@ElementCollection
	private Map<Product,Integer>products= new HashMap<Product,Integer>(); // product and quantity 
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
    public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Map<Product, Integer> getProducts() {
		return products;
	}
	public void setProducts(Map<Product, Integer> products) {
		this.products = products;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	
			
	

}
