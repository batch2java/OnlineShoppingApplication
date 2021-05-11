package com.cg.onlineshopping.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.cg.onlineshopping.entities.Order;
import com.cg.onlineshopping.pojo.InputOrder;
import com.cg.onlineshopping.pojo.OutputOrder;

public interface IOrderService {
	//public List <Order> addOrder(Order[] order);
	public InputOrder addOrder1(InputOrder order);
	public Order updateOrder(Order order);
	public Order removeOrder(Integer orderId);
	public Order viewOrder(Integer orderId);
	//public List<Order> viewAllOrders(LocalDate date);
	public List<Order> viewAllOrdersByLocation(String location);
	public List<Order> viewAllOrderByCustomerId(Integer customerId);
	public List<Order> viewAllOrderByDate(@Param("orderDate")LocalDate localdate);
	//public List<Order> viewAllCustomersByLocation(@Param("address")String address);

}
