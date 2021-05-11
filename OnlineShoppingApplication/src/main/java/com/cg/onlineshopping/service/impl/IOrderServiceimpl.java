package com.cg.onlineshopping.service.impl;

import java.time.LocalDate;
import java.util.Arrays;
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
import com.cg.onlineshopping.error.ProductNotFoundException;
import com.cg.onlineshopping.pojo.InputOrder;
import com.cg.onlineshopping.pojo.OutputCart;
import com.cg.onlineshopping.pojo.OutputOrder;
import com.cg.onlineshopping.repository.IAddressRepository;
import com.cg.onlineshopping.repository.ICustomerRepository;
import com.cg.onlineshopping.repository.IOrderRepository;
import com.cg.onlineshopping.repository.IProductRepository;
import com.cg.onlineshopping.service.IOrderService;
@Service
public class IOrderServiceimpl implements IOrderService {

	@Autowired
	IOrderRepository orderRepo;
	@Autowired
	ICustomerRepository customerRepo;
	@Autowired
	IAddressRepository addressRepo;
	@Autowired
	IProductRepository productRepo;
	Logger logger = LoggerFactory.getLogger(IOrderServiceimpl.class);


	/*@Override
	@Transactional
	public List<Order> addOrder(Order[] order) {
		logger.info("Order addOrder" );
		List<Order> orderList = Arrays.asList(order);
		if(orderList.isEmpty())
			throw new OrderNotFoundException();
		else {
			orderRepo.saveAll(orderList);
			return orderList;
		}
	}*/

	@Override
	@Transactional
	public Order updateOrder(Order order) {
		logger.info("Order updateOrder" );
		if(order == null)
			throw new OrderNotFoundException();
		else {
			orderRepo.save(order);
			return order;
		}
	}
	
	@Override
	@Transactional
	public Order removeOrder(Integer orderId) {
		logger.info("Order removeOrder()" );
		Optional<Order> order = orderRepo.findById(orderId);
		if(order.isPresent()) {
			orderRepo.deleteById(orderId);
			return order.get();
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
		if(order.isEmpty())
			throw new OrderNotFoundException();
		else
			return order;
	}

	@Override
	@Transactional
	public List<Order> viewAllOrderByCustomerId(Integer CustomerId) {
		logger.info("Order viewAllOrderByCustomerId" );
		List<Order> order = orderRepo.viewAllOrdersByCustomer(CustomerId);
		if(order.isEmpty())
			throw new OrderNotFoundException();
		else
			return order;
	}

	@Override
	public InputOrder addOrder1(InputOrder order) {
		logger.info("Order addOrder1()");
		Order order1 = new Order();
		
		Customer cust = customerRepo.findById(order.getCustomerId()).orElse(null);
		Address add = addressRepo.findById(order.getAddressId()).orElse(null);
		/*Address add = new Address();
		add.setAddressId(cust.getAddress().getAddressId());
		add.setCustomer(cust);
		cust.setAddress(add);*/
		
		
		order1.setOrderStatus(order.getOrderStatus());
		order1.setOrderDate(order.getOrderDate());
		order1.setCustomer(cust);
		order1.setAddress(add);
		cust.setOrder(order1);
		
		order1= orderRepo.save(order1);
		
		order.setOrderId(order1.getOrderId());
		order.setCustomerId(order1.getCustomer().getCustomerId());
		order.setAddressId(order1.getAddress().getAddressId());
		
		
		return order;
		
		
		
		
		
		
		
		
		
		
		
		
		
}
}