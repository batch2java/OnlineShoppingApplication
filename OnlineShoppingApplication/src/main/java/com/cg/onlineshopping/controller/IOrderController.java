package com.cg.onlineshopping.controller;

import java.time.LocalDate;
import java.util.List;

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



	@PostMapping("/addorder")
	public InputOrder addOrder(@RequestBody InputOrder order) 
	{
	
		logger.info("order addOrder()");
		
		return orderService.addOrder(order);

	}


	@PutMapping("/updateorder")
	public InputOrder updateOrder( @RequestBody InputOrder order) {
		logger.info("Order updateOrder");
		return order;

	}
	@DeleteMapping("/orderbyid/{orderId}")
	public Order removeOrder(@PathVariable Integer orderId) {
		logger.info(" Order removeOrder()");
		return orderService.removeOrder(orderId);
	}
	
	
	@GetMapping("/getorder")
	public List<Order> viewAllOrder(){
		logger.info("Order viewAllorder ");
		return orderRepo.findAll();
	}
	
	@GetMapping("/orderbycustomerid/{customerId}")
	public List<Order> viewAllOderByCustomerId(@PathVariable("customerId") Integer customerId){
		return orderService.viewAllOrderByCustomerId(customerId);
	}
	  
   @GetMapping("/orderbydate/{date}")
   public List<Order> viewAllOrders(@PathVariable LocalDate date) {
	   logger.info("Order viewAllOrders");
    return orderService.viewAllOrderByDate(date);
}


   @GetMapping("/orderbylocation/{location}")
   public List<Order> viewOrdersByLocation(@PathVariable String location) {
   logger.info("Order viewOrdersByLocation");
	return orderService.viewAllOrdersByLocation(location);

   }
	

	


}