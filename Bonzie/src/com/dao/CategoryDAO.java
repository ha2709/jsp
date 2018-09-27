package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.model.Category;
 
 
public class CategoryDAO {
	public List<Category> getAllUser() {
		List<Category> users = new ArrayList<Category>();

		Connection connection =JDBC.getJDBCconnect();
		 
		String sql = "SELECT * FROM ban_qa.category";
try {
	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	ResultSet rs = preparedStatement.executeQuery();
 	 System.out.println("Chay Cart get All ");
	while (rs.next()) {
		Category user = new Category();
		 
		user.setCategoryID(rs.getInt("category_id"));
	  
		user.setCategoryName(rs.getString("category_name"));
		 
	 
		 
		users.add(user);
// 		System.out.println("add duoc 1 user");
// 		for (Category user1 :users) {
// 			System.out.println(user1.getCategoryName());
// 		}
		 
	//	System.out.println(user.getName());
	}
} catch (Exception e) {
	// TODO: handle exception
}
	return users;
		
	} 
public static void main(String[] args) {
//	CategoryDAO categoryDAO = new CategoryDAO();
//	 
//	for (Category ds: categoryDAO.getAllUser()) {
//		System.out.println(ds.getCategoryID() + " " +ds.getCategoryName());
//	}
}
}
