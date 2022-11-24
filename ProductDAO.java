package com.spring.jdbcTemplate.dao;

import java.util.List;

import com.spring.jdbcTemplate.model.Product;

public interface ProductDAO {
	
	public void save(Product product);
	
	public Product getById(int id);
	
	public void update(Product product);
	
	public void deleteById(int id);
	
	public List<Product> getAll();
	
	public Product getByName(String name);
	
	public List<Product> getByNames(String subString);

	public List<Product> getByBetweenPrice(double iPrice , double oPrice);
	
	public List<Product> getDiscontinuedProduct();
	
}
