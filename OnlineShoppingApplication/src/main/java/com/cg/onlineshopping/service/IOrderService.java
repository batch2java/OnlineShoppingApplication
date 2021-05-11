package com.cg.onlineshopping.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.cg.onlineshopping.entities.Order;
import com.cg.onlineshopping.pojo.InputOrder;


public interface IOrderService {
	
	public InputOrder addOrder(InputOrder order);
	public InputOrder updateOrder(InputOrder order);
	public Order removeOrder(Integer orderId);
	public Order viewOrder(Integer orderId);
	public List<Order> viewAllOrdersByLocation(String location);
	public List<Order> viewAllOrderByCustomerId(Integer customerId);
	public List<Order> viewAllOrderByDate(@Param("orderDate")LocalDate localdate);
	

}
