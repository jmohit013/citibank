package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.OrderEntity;
import com.spring.json.Order;
import com.spring.repo.OrderRepository;
import com.spring.utils.OrderUtil;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public List<Order> getAllOrders() {
		List<OrderEntity> orders = orderRepository.findAll();
		return OrderUtil.convertOrderEntityListIntoOrderList(orders);
	}

}
