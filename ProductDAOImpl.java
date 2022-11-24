package com.spring.jdbcTemplate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.spring.jdbcTemplate.model.Category;
import com.spring.jdbcTemplate.model.Product;

public class ProductDAOImpl implements ProductDAO {
		
		private DataSource dataSource;
		
		public void setDataSource(DataSource dataSource) {
			this.dataSource = dataSource;
		}
	
	
	@Override
	public void save(Product product) {
String query = "insert products(id, name, price, UnitsInStock, Discontinued) values (?, ?, ?, ?, ?)";
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			
			ps.setInt(1, product.getId());
			ps.setString(2, product.getName());
			ps.setDouble(3, product.getPrice());
			ps.setInt(4,product.getUnitInStock());
			ps.setBoolean(5, product.isDiscontinued());
			
			int out = ps.executeUpdate();
			
			if(out != 0) {
				System.out.println("Category saved with id = " + product.getId());
			}
			else
				System.out.println("Category save failed with id =" + product.getId());
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(ps != null)
					ps.close();
				
				if(con != null)
					con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	
	// getById method
	@Override
	public Product getById(int id) {
		String query = "select * from Products where id = ?";

		Product prod = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			con = dataSource.getConnection();
			
			ps = con.prepareStatement(query);
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				prod = new Product();
				
				prod.setId(id);
				prod.setName(rs.getString("name"));
				prod.setPrice(rs.getDouble("price"));
				prod.setUnitInStock(rs.getInt("unitInStock"));
				prod.setDiscontinued(true);
				
				System.out.println("Product Found::"+prod);
			}
			else
			{
				System.out.println("No Product found with id="+id);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return prod;	// return product
	}
	
	
	
	// update product
	@Override
	public void update(Product product) {
		String query = "update products set name=?, price=? where id=?";
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try{
			con = dataSource.getConnection();
			
			ps = con.prepareStatement(query);
			
			ps.setString(1, product.getName());
			ps.setDouble(2, product.getPrice());
			ps.setInt(3, product.getId());
			
			int out = ps.executeUpdate();
			
			if(out !=0){
				System.out.println("Product updated with id="+product.getId());
			}
			else System.out.println("No found Product with id="+product.getId());
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try {
				ps.close();
				con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	
	
	// delete product by id
	@Override
	public void deleteById(int id) {
		String query = "delete from products where id=?";
		
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			int out = ps.executeUpdate();
			
			if(out !=0){
				System.out.println("Products deleted with id="+id);
			}
			else 
				System.out.println("Not found Products with id="+id);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	
	
	//getAll product
	@Override
	public List<Product> getAll() {
		String query = "select * from products";
		
		List<Product> prodList = new ArrayList<Product>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			con = dataSource.getConnection();
			
			ps = con.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				Product prod = new Product();
				prod.setId(rs.getInt("id"));
				prod.setName(rs.getString("name"));
				prod.setPrice(rs.getDouble("price"));
				prod.setUnitInStock(rs.getInt("unitsinstock"));
				prod.setDiscontinued(false);
				prodList.add(prod);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return prodList;
	}

	
	
	// find product by name
	@Override
	public Product getByName(String name) {
		String query = "select * from Products where name = ?";

		Product prod = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			con = dataSource.getConnection();
			
			ps = con.prepareStatement(query);
			
			ps.setString(1, name);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				prod = new Product();
				
				prod.setId(id);
				prod.setName(rs.getString("name"));
				prod.setPrice(rs.getDouble("price"));
				prod.setUnitInStock(rs.getInt("unitInStock"));
				prod.setDiscontinued(true);
				
				System.out.println("Product Found::"+prod);
			}
			else
			{
				System.out.println("No Product found with id="+name);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return prod;	// return product
	}

}
