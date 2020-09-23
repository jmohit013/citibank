package com.citi.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.citi.entity.Order;

@Component
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/*
	public OrderDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	*/
	
	@Override
	public List<Order> getAllOrders() {
		List<Map<String,Object>> orderListFromDB = jdbcTemplate.queryForList(
				"SELECT * FROM ORDER_MASTER");
		List<Order> orders = new ArrayList<Order>();
		for(Map<String, Object> row: orderListFromDB) {
			Order order = 
				new Order((Integer)row.get("id"), (String)row.get("title"), (Double)row.get("price"), 
						(Integer)row.get("quantity"));
			orders.add(order);
		}
		return orders;
	}

}
