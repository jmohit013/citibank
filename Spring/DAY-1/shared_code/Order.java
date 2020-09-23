package com.citi.entity;

import java.util.List;

public class Order {

	private int id;
	private String title;
	Item item;
	public Order(int id, String title, Item item) {
		super();
		this.id = id;
		this.title = title;
		this.item = item;
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
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", title=" + title + ", item=" + item + "]";
	}
	
	
}
