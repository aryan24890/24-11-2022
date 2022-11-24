package com.spring.jdbcTemplate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.sql.DataSource;


import com.spring.jdbcTemplate.model.Category;

public class CategoryDAOImpl implements CategoryDAO {
	
	private static final int id = 0;
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	@Override
	public void save(Category category) {
		String query = "insert Categories(id, name, description) values (?, ?, ?)";
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			
			ps.setInt(1, category.getId());
			ps.setString(2, category.getName());
			ps.setString(3, category.getDescription());
			
			int out = ps.executeUpdate();
			
			if(out != 0) {
				System.out.println("Category saved with id = " + category.getId());
			}
			else
				System.out.println("Category save failed with id =" + category.getId());
			
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
	

	
	// find category by id method
	@Override
	public Category getById(int id) {
		String query = "select * from Categories where id = ?";

		Category cat = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			con = dataSource.getConnection();
			
			ps = con.prepareStatement(query);
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				cat = new Category();
				
				cat.setId(id);
				cat.setName(rs.getString("name"));
				cat.setDescription(rs.getString("description"));
				
				System.out.println("Category Found::"+cat);
			}
			else
			{
				System.out.println("No Category found with id="+id);
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
		return cat;	// return category
	}
	
	
	
	// update category method
	@Override
	public void update(Category category) {
		String query = "update categories set name=?, description=? where id=?";
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try{
			con = dataSource.getConnection();
			
			ps = con.prepareStatement(query);
			
			ps.setString(1, category.getName());
			ps.setString(2, category.getDescription());
			ps.setInt(3, category.getId());
			
			int out = ps.executeUpdate();
			
			if(out !=0){
				System.out.println("Category updated with id="+category.getId());
			}
			else System.out.println("No found category with id="+category.getId());
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

	
	//delete category by id method
	@Override
	public void deleteById(int id) {
		String query = "delete from categories where id=?";
		
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			int out = ps.executeUpdate();
			
			if(out !=0){
				System.out.println("Category deleted with id="+id);
			}
			else 
				System.out.println("Not found Category with id="+id);
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

	
	
	// getAll method
	@Override
	public List<Category> getAll() {
		String query = "select * from Categories";
		
		List<Category> catList = new ArrayList<Category>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			con = dataSource.getConnection();
			
			ps = con.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				Category cat = new Category();
				cat.setId(rs.getInt("id"));
				cat.setName(rs.getString("name"));
				cat.setDescription(rs.getString("description"));
				catList.add(cat);
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
		return catList;
	}

	
	
	// find category by name method
	@Override
	public Category getByName(String name) {
		String query = "select * from Categories where name = ?";

		Category cat = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			con = dataSource.getConnection();
			
			ps = con.prepareStatement(query);
			
			ps.setString(1, name);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				cat = new Category();
				
				cat.setId(id);
				cat.setName(rs.getString("name"));
				cat.setDescription(rs.getString("description"));
				
				System.out.println("Category Found::"+cat);
			}
			else
			{
				System.out.println("No Category found with id="+name);
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
		return cat;	// return category
	}

	
	
	// find category by names method
	@Override
	public List<Category> getByNames(String subString) {
		String query = "select id, name, description from categories where name = ?";
		List<Category> catList = new ArrayList<Category>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			con = dataSource.getConnection();
			
			ps = con.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				Category cat = new Category();
				cat.setId(rs.getInt("id"));
				cat.setName(rs.getString("name"));
				cat.setDescription(rs.getString("description"));
				catList.add(cat);
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
		return catList;
		
	}

}
