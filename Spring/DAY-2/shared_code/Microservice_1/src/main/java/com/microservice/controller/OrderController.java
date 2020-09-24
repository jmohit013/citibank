package com.microservice.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservice.entity.Item;
import com.microservice.entity.Order;

@RestController
@RequestMapping("/myapp")
public class OrderController {

	private static List<Order> orders = new ArrayList<Order>();
	static {
		orders.add(new Order(1, "Furniture"));
		orders.add(new Order(2, "IT Infrastructure"));
	}
	@GetMapping(value="/order/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Order getOrderById(@PathVariable("id")String orderId) throws Exception {
		Order order = null;
		for(Order orderTemp: orders) {
			if(orderTemp.getId()==Integer.parseInt(orderId))
				order = orderTemp;
		}
		List<Item> items = getOrderItems(orderId);
		order.setItems(items);
		return order;
	}
	
	private List<Item> getOrderItems(String orderId) throws Exception {
		String url = "http://localhost:9090/myapp/order/"+orderId+"/item";
		URI uri = new URI(url);	
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List> result = restTemplate.getForEntity(uri, List.class);
		List<Item> items = (List<Item>)result.getBody();
		return items;
	}
}
