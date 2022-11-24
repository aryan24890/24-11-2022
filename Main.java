package com.spring.jdbcTemplate.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.spring.jdbcTemplate.dao.CategoryDAO;
import com.spring.jdbcTemplate.dao.ProductDAO;
import com.spring.jdbcTemplate.model.Category;
import com.spring.jdbcTemplate.model.Product;

public class Main {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = null;
		
		try {
			/***********************************************************
							Operation for Products
			 ***********************************************************/
			
			context = new ClassPathXmlApplicationContext("spring.xml");
			CategoryDAO categoryDAO = context.getBean(CategoryDAO.class);
			
			// creating object of Category class
			Category c1 = new Category();
			
			// set data in categories table
			c1.setId(1);					// set id
			c1.setName("Baverages");		// set name
			c1.setDescription("soft drinks, coffees, teas"); 	// set desc
			
			// second row
			c1.setId(2);					
			c1.setName("Condiments");		
			c1.setDescription("Sweet sauces");
			
			// third row
			c1.setId(3);					
			c1.setName("Confections");		
			c1.setDescription("Desserts, candies, and sweet breads");
			
			// fourth row
			c1.setId(4);					
			c1.setName("Dairy Products");		
			c1.setDescription("Cheeses");			
			
			
			
			categoryDAO.save(c1); 	// call save method
			
			System.out.println("Category saved successfully");
			
			
			
			/**********************getById()***************************/
			Category cat = null;
			cat = categoryDAO.getById(1);
			System.out.println("Category find Successfully");
			
			
			
			/***********************updateCategory()*************************/
			
			/*c1.setDescription("Teas, coffees");
			categoryDAO.update(c1);*/
			

			
			/***********************deleteCategory()*************************/
			
			// categoryDAO.deleteById(1);
			
			
			
			/***********************find AllCategory()*************************/
			List<Category> catList = categoryDAO.getAll();
			System.out.println(catList);
			
			
			/***********************find by name()*************************/
			Category cat1 = categoryDAO.getByName("Condiments");
			System.out.println("Category by name :" + cat1); 
			
			
			/***********************find by names()*************************/
			List<Category> List2 = categoryDAO.getByNames("Confections");
			System.out.println(List2);
			
			
			
			
			
			/***********************************************************
			 				Operation for Products
			 ***********************************************************/
			
			ProductDAO productDAO = context.getBean(ProductDAO.class);
			Product p1 = new Product();
			
			p1.setId(1);					
			p1.setName("Chai");	
			p1.setPrice(180);
			p1.setUnitInStock(30);
			p1.setDiscontinued(false);
			
			p1.setId(2);					
			p1.setName("Chang");	
			p1.setPrice(19);
			p1.setUnitInStock(17);
			p1.setDiscontinued(true);
			
			productDAO.save(p1);
			System.out.println("Category saved successfully");
			
			
			
			/**********************getById()***************************/
			Product prod = null;
			prod = productDAO.getById(1);
			System.out.println("Product find Successfully");
			
			
			
			
			/************************update Product********************************/
			p1.setPrice(200);
			productDAO.update(p1);
			
			
			
			/***********************deleteCategory()*************************/
			productDAO.deleteById(1);
			
			
			
			/***********************find AllCategory()*************************/
			List<Product> prodList = productDAO.getAll();
			System.out.println(prodList);
			
			
			/***********************find by name()*************************/
			Product prod1 = productDAO.getByName("chai");
			System.out.println("product by name :" + prod1); 
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(context != null)
				context.close();
		}

	}

}
