package com.microservice.entity;

import java.util.List;

public class Order {

	private int id;
	private String title;
	List<Item> items;
	public Order(int id, String title, List<Item> items) {
		super();
		this.id = id;
		this.title = title;
		this.items = items;
	}
	public Order(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	public Order(String title, List<Item> items) {
		super();
		this.title = title;
		this.items = items;
	}
	public Order() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", title=" + title + ", items=" + items + "]";
	}
}
