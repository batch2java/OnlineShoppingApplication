package com.cg.onlineshopping.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.controller.IAddressController;
import com.cg.onlineshopping.entities.Address;
import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.entities.Customer;
import com.cg.onlineshopping.entities.Product;
import com.cg.onlineshopping.error.AddressNotFoundException;
import com.cg.onlineshopping.error.CartNotFoundException;
import com.cg.onlineshopping.error.CustomerNotFoundException;
import com.cg.onlineshopping.error.ProductNotFoundException;
import com.cg.onlineshopping.pojo.InputCart;
import com.cg.onlineshopping.pojo.OutputCart;
import com.cg.onlineshopping.repository.ICartRepository;
import com.cg.onlineshopping.repository.ICustomerRepository;
import com.cg.onlineshopping.repository.IProductRepository;
import com.cg.onlineshopping.service.ICartService;
@Service
public class ICartServiceimpl implements ICartService{
	@Autowired
	ICartRepository  cartRepo;
	@Autowired
	IProductRepository productRepo;
	Logger logger = LoggerFactory.getLogger(ICartServiceimpl.class);
	@Autowired
	ICustomerRepository custRepo;

	
	/*public Cart addProductToCart(Cart cart, Product p, int quantity) {
		// TODO Auto-generated method stub
		 logger.info("Cart addProductToCart()");
		
		p.setQuantity(quantity);
		productRepo.save(p);
		cartRepo.save(cart);
		return cart;
	}*/

	@Override
	public Cart removeProductFromCart(Integer cartId, Integer productId ) {
		// TODO Auto-generated method stub
		 logger.info("Cart removeProductFromCart()");
		  Cart cart=cartRepo.findById(cartId).orElse(null);
	        Map<Product,Integer> productmap=cart.getProducts();
	        for(Product p:productmap.keySet()) {
	            if(p.getProductId().equals(productId)) {
	                productmap.remove(p);
	                cart.setProducts(productmap);
	               
	            }
	        }
	        
	       cart = cartRepo.save(cart);
	       return cart;
	        }
	       
	        
	    
	


	@Override
	public Cart updateProductQuantity(Cart cart, Product p, int quantity) {
		// TODO Auto-generated method stub
		 logger.info("Cart updateProductToCart()");
			
			p.setQuantity(quantity);
			productRepo.save(p);
			cartRepo.save(cart);
			return cart;
	}
	

	/*@Override
    public Cart removeCartById(Integer cartId) {
        // TODO Auto-generated method stub 
        logger.info("Cart removeCartById()");
         Optional<Cart> cart =cartRepo.findById(cartId);
        if(!cart.isPresent()) {
        	throw new CartNotFoundException();
             
        }
        else {
        	cartRepo.deleteById(cartId);
            return cart.get(); 
        }
    }*/	

	@Override
	public List<Product> viewAllProducts(Integer cartId) {
		// TODO Auto-generated method stub
		logger.info("Cart viewAllProducts()");
		Map<Product,Integer> map = new HashMap<>(cartId);
		List<Product> list = new ArrayList<Product>();
		for(Product p:map.keySet()) {
			list.add(p);
		}
		return list;
		 
	    }
	

	@Override
	public OutputCart addProductToCart1(InputCart cart) {
		// TODO Auto-generated method stub
		logger.info("Cart addProductToCart1()");
		Cart cart1 = cartRepo.findById(cart.getCartId()).orElse(null);
		if(cart1==null) {
			cart1= new Cart();
		}
		//cart1.setCartId(cart.getCartId());
		Product product = productRepo.findById(cart.getProductId()).orElse(null);
		
		Map<Product,Integer> map = cart1.getProducts();
		
		
		map.put(product, cart.getQuantity());
		Customer cust = custRepo.findById(cart.getCustomerId()).orElse(null);
		cart1.setCustomer(cust);
		
		cart1= cartRepo.save(cart1);
		OutputCart c = new OutputCart();
		c.setCartId(cart1.getCartId());
		map= cart1.getProducts();
		for(Product p : map.keySet()) {
			c.getMap().put(p.getProductId(), map.get(p));
		}
		return c;
			
		
		
	}



}