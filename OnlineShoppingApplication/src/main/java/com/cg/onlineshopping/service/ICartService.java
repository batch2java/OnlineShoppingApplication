package com.cg.onlineshopping.service;

import java.util.List;

import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.entities.Product;
import com.cg.onlineshopping.pojo.InputCart;
import com.cg.onlineshopping.pojo.OutputCart;

public interface ICartService {

	//public Cart addProductToCart(Cart cart, Product p,int quantity);
	public  Cart removeProductFromCart(Integer cartId,Integer productId);
	public Cart updateProductQuantity(Cart cart, Product p,int quantity);
	//public Cart removeCartById(Integer cartId);
	public List <Product> viewAllProducts(Integer cartId);
	public OutputCart addProductToCart1(InputCart cart);
}
