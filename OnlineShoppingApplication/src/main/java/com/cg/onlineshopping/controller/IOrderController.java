package com.cg.onlineshopping.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping.entities.Order;
import com.cg.onlineshopping.pojo.InputOrder;
import com.cg.onlineshopping.repository.IOrderRepository;
import com.cg.onlineshopping.service.IOrderService;

@RestController
@RequestMapping("/api/v1")
public class IOrderController {
	
	@Autowired
	IOrderService orderService;
	@Autowired
	IOrderRepository orderRepo;
	Logger logger = LoggerFactory.getLogger(IOrderController.class);


     //To add order
	@PostMapping("/addorder")
	public InputOrder addOrder(@Valid @RequestBody InputOrder order) 
	{
	
		logger.info("order addOrder()");
		
		return orderService.addOrder(order);

	}
    //To delete order by id
	@DeleteMapping("/orderbyid/{orderId}")
	public InputOrder removeOrder(@PathVariable Integer orderId) {
		logger.info(" Order removeOrder()");
		return orderService.removeOrder(orderId);
	}
	
	
	//To get order details by customer id
	@GetMapping("/orderbycustomerid/{customerId}")
	public List<InputOrder> viewAllOderByCustomerId(@PathVariable("customerId") Integer customerId){
		return orderService.viewAllOrderByCustomerId(customerId);
	}
	//To get order details by order date  
   @GetMapping("/orderbydate/{date}")
   public List<InputOrder> viewAllOrders(@PathVariable LocalDate date) {
	   logger.info("Order viewAllOrders");
    return orderService.viewAllOrderByDate(date);
}

   //To get order details by customer location
   @GetMapping("/orderbylocation/{location}")
   public List<InputOrder> viewOrdersByLocation(@PathVariable String location) {
   logger.info("Order viewOrdersByLocation");
	return orderService.viewAllOrdersByLocation(location);

   }
	

	


}