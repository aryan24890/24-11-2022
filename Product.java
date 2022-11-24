package com.spring.jdbcTemplate.model;

public class Product {
	
	private int id;
	private String name;
	private double price;
	private int unitInStock;
	private boolean discontinued;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(int id, String name, double price, int unitInStock, boolean discontinued) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.unitInStock = unitInStock;
		this.discontinued = discontinued;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getUnitInStock() {
		return unitInStock;
	}


	public void setUnitInStock(int unitInStock) {
		this.unitInStock = unitInStock;
	}


	public boolean isDiscontinued() {
		return discontinued;
	}


	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", unitInStock=" + unitInStock
				+ ", discontinued=" + discontinued + "]";
	}
	
	

}
