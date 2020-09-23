package com.citi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citi.entity.Item;
import com.citi.entity.Order;
import com.citi.service.OrderService;

@RestController
@RequestMapping("/myapp")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	public String getAuthToken() {
		String uid = new java.rmi.server.UID().toString(); //alpha numeric
		String authToken = uid.substring(0, 20);
		return authToken;
	}
	/*
	@GetMapping(value="/order/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Order getOrderById(@PathVariable("id")String orderId) {
		return new Order(Integer.parseInt(orderId), "Sample title", new Item("Sample"));
	}	
	*/
/*
	@GetMapping(value="/order", produces=MediaType.APPLICATION_JSON_VALUE)
	public Order getOrderById(@RequestParam("id")String orderId,
			@RequestHeader("auth-token")String authToken) {
		System.out.println("authToken = " + authToken);
		return new Order(Integer.parseInt(orderId), "Sample title", new Item("Sample"));
	}
*/	
	
	@GetMapping(value="/order", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}
	
	@PostMapping(value="/order", consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Order createNewOrder(@RequestBody Order order) {
		System.out.println("Order created: " + order);
		return order;
	}
}









