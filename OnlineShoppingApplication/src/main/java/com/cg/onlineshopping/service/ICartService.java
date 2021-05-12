package com.cg.onlineshopping.service;


import java.util.Map;

import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.entities.Product;
import com.cg.onlineshopping.pojo.InputCart;
import com.cg.onlineshopping.pojo.OutputCart;

public interface ICartService {

	
	public  Cart removeProductFromCart(Integer cartId,Integer productId);
	public  Cart makeCartEmpty(Integer cartId);
	public Map<Integer,Integer>  viewAllProducts(Integer cartId);
	public OutputCart addProductToCart(InputCart cart);
}
