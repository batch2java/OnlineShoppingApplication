package com.cg.onlineshopping.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.service.ICartService;

class ICartServiceImplTest {

	@InjectMocks
    ICartServiceImpl cartServiceImpl;

 

     @Autowired
     ICartService service;
     
     @Test 
        public void removeProductFromCartUnitTest()
        {
            Cart cart =service.removeProductFromCart(3,1);
            assertNotNull(cart, "Product removed from cart !!");
        }
        
        @Test
        public void makeCartEmptyUnitTest()
        {
            Cart cart =service.makeCartEmpty(1);
            assertNotNull(cart, "Products removed from cart !!");
        }
        @Test
        public void viewAllProductsByIdUnitTest()
        {
            Map<Integer,Integer> cart =service.viewAllProducts(1);
            assertNotNull(cart, "Product removed from cart !!");
        }
        
        
}