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

import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.entities.Product;
import com.cg.onlineshopping.pojo.InputCart;
import com.cg.onlineshopping.pojo.OutputCart;
import com.cg.onlineshopping.service.ICartService;


@RestController
@RequestMapping("/api/v2")


public class ICartController {
	@Autowired(required=true)
	ICartService cartService;
	Logger logger = LoggerFactory.getLogger(ICartController.class);

	

	/*@PostMapping("/addcart")
	public Cart addProductToCart(@RequestBody Cart cart, @RequestBody Product product, @RequestBody int quantity)
	{
		logger.info("Cart addProductToCart()");
		return cartService.addProductToCart(cart, product, quantity);
	}*/
	@PostMapping("/addcart1")
	public OutputCart addProductToCart1(@RequestBody InputCart cart)
	{
		logger.info("Cart addProductToCart1()");
		return cartService.addProductToCart1(cart);
	}


	@DeleteMapping("/deletecart/{productId}/{cartId}")
	public Cart removeProductFromCart(@PathVariable Integer cartId,@PathVariable Integer productId)
	{
		logger.info("Cart removeProductFromCart()");
		return cartService.removeProductFromCart(cartId, productId);
	}

	/*@DeleteMapping("/deletebycartid/{cartId}")
    public Cart removeAllProductsById(@PathVariable Integer cartId)
    {
        logger.info("Cart removeCartById()");
        return cartService.removeCartById(cartId);
    }*/
	@PutMapping("/updatecart")
	public Cart updateProductQuantity(@RequestBody Cart cart, @RequestBody Product p, @RequestBody int quantity)
	{
		logger.info("Cart updateProductToCart()");
		return cartService.updateProductQuantity(cart, p, quantity);
	}



	@GetMapping("/getcartproducts/{cartId}")
	public List<Product> viewAllProducts( @PathVariable Integer cartId)
	{
		logger.info("Cart viewAllProducts()");
		return cartService.viewAllProducts(cartId);
		
	}

}

   


