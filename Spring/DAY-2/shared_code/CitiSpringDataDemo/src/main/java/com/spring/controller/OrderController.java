package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.json.Order;
import com.spring.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping(value = "/order", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}
}
