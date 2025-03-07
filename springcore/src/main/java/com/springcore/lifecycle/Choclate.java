package com.springcore.lifecycle;

public class Choclate {
	private String name;
	private int price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Choclate(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public Choclate() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Choclate [name=" + name + ", Price=" + price + "]";
	}
	
	public void init() {
		System.out.println("init calling");
	}
	
	public void destroy() {
		System.out.println("destroy calling");
	}
}
