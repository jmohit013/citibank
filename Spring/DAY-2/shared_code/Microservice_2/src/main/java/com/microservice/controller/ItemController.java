package com.microservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.entity.Item;
import com.microservice.entity.Order;

@RestController
@RequestMapping("/myapp")
public class ItemController {

	private static List<Order> orders = new ArrayList<Order>();
	static {
		Item item_1_1 = new Item("Tables");
		Item item_1_2 = new Item("Chairs");
		Item item_2_1 = new Item("Computers");
		Item item_2_2 = new Item("Laptops");
		List<Item> items_1 = new ArrayList<Item>();
		items_1.add(item_1_1);
		items_1.add(item_1_2);
		List<Item> items_2 = new ArrayList<Item>();
		items_2.add(item_2_1);
		items_2.add(item_2_2);
		Order order_1 = new Order();
		order_1.setId(1);
		order_1.setItems(items_1);
		Order order_2 = new Order();
		order_2.setId(2);
		order_2.setItems(items_2);
		orders.add(order_1);
		orders.add(order_2);
	}

	@GetMapping(value="/order/{id}/item", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Item> getItemsByOrderId(@PathVariable("id")String orderId) {
		Order orderOutput = orders.stream().filter((Order order)->order.getId()==Integer.parseInt(orderId)).findAny().get();
		return orderOutput.getItems();
	}
}
