package com.cg.onlineshopping.service.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entities.Address;
import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.entities.Customer;
import com.cg.onlineshopping.entities.Order;
import com.cg.onlineshopping.entities.Product;
import com.cg.onlineshopping.error.OrderNotFoundException;
import com.cg.onlineshopping.pojo.InputOrder;
import com.cg.onlineshopping.repository.IAddressRepository;
import com.cg.onlineshopping.repository.ICartRepository;
import com.cg.onlineshopping.repository.ICustomerRepository;
import com.cg.onlineshopping.repository.IOrderRepository;
import com.cg.onlineshopping.repository.IProductRepository;
import com.cg.onlineshopping.service.ICartService;
import com.cg.onlineshopping.service.IOrderService;
@Service
public class IOrderServiceImpl implements IOrderService {

	@Autowired
	IOrderRepository orderRepo;
	@Autowired
	ICustomerRepository customerRepo;
	@Autowired
	IAddressRepository addressRepo;
	@Autowired
	IProductRepository productRepo;
	@Autowired
	ICartService cartService;
	@Autowired
	ICartRepository cartRepo;
	Logger logger = LoggerFactory.getLogger(IOrderServiceImpl.class);


	@Override
	@Transactional
	public InputOrder updateOrder(InputOrder order) {
		logger.info("Order updateOrder" );
		
        Order order1 = new Order();
		
		Customer cust = customerRepo.findById(order.getCustomerId()).orElse(null);
		Address add = addressRepo.findById(order.getAddressId()).orElse(null);
		order1.setOrderId(order.getOrderId());
				
		
		order1.setOrderStatus(order.getOrderStatus());
		order1.setOrderDate(order.getOrderDate());
		order1.setCustomer(cust);
		order1.setAddress(add);
		cust.setOrder(order1);
		
		order1= orderRepo.save(order1);
		
		
		/*order.setCustomerId(order1.getCustomer().getCustomerId());
		order.setAddressId(order1.getAddress().getAddressId());*/
		return order;
		

	}
	
	@Override
	@Transactional
	public Order removeOrder(Integer orderId) {
		logger.info("Order removeOrder()" );
		Order order = orderRepo.findById(orderId).orElse(null);
		System.out.println("123");
		if(order!=null) {
			order.setProducts(new HashMap<Product,Integer>());
			order.setOrderStatus("cancel");
			orderRepo.save(order);
			//orderRepo.deleteById(orderId);
			return order;
		}
		else {
			throw new OrderNotFoundException();
		}
			
	}

	@Override
	@Transactional
	public Order viewOrder(Integer orderId) {
		logger.info("Order viewOrder" );
		Optional<Order> orders = orderRepo.findById(orderId);
		if(!orders.isPresent())
			throw new OrderNotFoundException();
		else
			return orders.get();
		
	}

	@Override
	@Transactional
	public List<Order> viewAllOrderByDate(LocalDate date) {
		logger.info("Order viewAllOrders" );
		List<Order> order = orderRepo.viewAllOrderByDate(date);
		if(order.isEmpty())
			throw new OrderNotFoundException();
		else
			return order;
		
	}

	
	@Override
	@Transactional
	public List<Order> viewAllOrdersByLocation(String location) {
		logger.info("Order viewAllOrdersByLocation()" );
		List<Order> order = orderRepo.viewAllOrdersByLocation(location);
		System.out.println(order);
		if(order.isEmpty())
			throw new OrderNotFoundException();
		else
			return order;
	}

	@Override
	@Transactional
	public List<Order> viewAllOrderByCustomerId(Integer customerId) {
		logger.info("Order viewAllOrderByCustomerId" );
		List<Order> order = orderRepo.viewAllOrdersByCustomer(customerId);
		if(order.isEmpty())
			throw new OrderNotFoundException();
		else
			return order;
	}

	@Override
	public InputOrder addOrder(InputOrder order) {
		logger.info("Order addOrder()");
		Order order1 = new Order();
		
		Customer cust = customerRepo.findById(order.getCustomerId()).orElse(null);
		Address add = addressRepo.findById(order.getAddressId()).orElse(null);
		Cart cart = cust.getCart();
		Map<Product,Integer>products=cart.getProducts();
		Map<Product,Integer>map = new HashMap<Product,Integer>();
		for(Product p: products.keySet()) {
			map.put(p, products.get(p));
		}
		System.out.println(products);
		System.out.println(map);
		
		order1.setOrderStatus(order.getOrderStatus());
		order1.setOrderDate(order.getOrderDate());
		order1.setCustomer(cust);
		order1.setProducts(map);
		order1.setAddress(add);
		cust.setOrder(order1);
		
		order1= orderRepo.save(order1);
		//Cart clean
		/*for(Product p: products.keySet()) {
			cartService.removeProductFromCart(cart.getCartId(), p.getProductId());
			
			
		}*/
		cart.setProducts(new HashMap<Product,Integer>());
		cartRepo.save(cart);
		
		
		order.setOrderId(order1.getOrderId());
		order.setCustomerId(order1.getCustomer().getCustomerId());
		order.setAddressId(order1.getAddress().getAddressId());
		
		
		return order;
		
		
		
		
		
		
		
		
		
		
		
		
		
}
}