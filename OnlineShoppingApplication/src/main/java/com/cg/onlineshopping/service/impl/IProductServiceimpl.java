package com.cg.onlineshopping.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entities.Product;
import com.cg.onlineshopping.error.ProductNotFoundException;
import com.cg.onlineshopping.repository.IProductRepository;
import com.cg.onlineshopping.service.IProductService;

@Service
public class IProductServiceimpl implements IProductService{
	@Autowired
	IProductRepository proRepo;
	Logger logger = LoggerFactory.getLogger(IProductServiceimpl.class);


	@Override
	public List<Product> viewAllProducts() {
		logger.info("Product ProductviewAllProducts");
		List<Product> list = proRepo.findAll();
		if(list.isEmpty())
			throw new ProductNotFoundException();
		else
		return list;
	}

	@Override
	public Product addProduct(Product product) {
		logger.info("Product addProduct");
		if(product == null)
			throw new ProductNotFoundException();
		else
			proRepo.save(product);
		return product;
	}

	@Override
	public Product updateProduct(Product product) {
		logger.info("Product updateProduct");
		if(product == null)
			throw new ProductNotFoundException();
		else
			proRepo.save(product);
		return product;
	}

	@Override
	public Product viewProduct(Integer productId) {
		logger.info("Product viewProduct");
		Optional<Product> viewproduct = proRepo.findById(productId);
		if(viewproduct.isPresent())
			return viewproduct.get();
		else
			throw new ProductNotFoundException();
	}

	@Override
	public List<Product> viewProductsByCategory(String category) {
		logger.info("Product viewProduct");
		List<Product> viewproduct = proRepo.viewAllProductsByCategory(category);
		if(viewproduct.isEmpty())
			 throw new ProductNotFoundException();
		else
			return viewproduct;
			
	}



	@Override
	public Product removeProduct(Integer productId) {
		logger.info("Product removeProduct");
		Optional<Product> pro = proRepo.findById(productId);
		if(pro.isPresent()) {
			proRepo.deleteById(productId);
			return pro.get();
		}
		else {
			throw new ProductNotFoundException();
		}
			
	}
	

}