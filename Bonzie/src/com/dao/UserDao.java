package com.dao;

 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

 

 

import com.model.User;

public class UserDao {
public List<User> getAllUser() {
		List<User> users = new ArrayList<User>();

		Connection connection =JDBC.getJDBCconnect();
		 
		String sql = "SELECT * FROM ban_qa.user";
try {
	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	ResultSet rs = preparedStatement.executeQuery();
	 System.out.println("Ket noi thanh cong CSDL ");
	while (rs.next()) {
		User user = new User();
		 
		user.setId(rs.getInt("id"));
	  
		user.setName(rs.getString("NAME"));
		user.setPhone(rs.getString("Phone"));
		System.out.println(rs.getString("Name").toString());
		System.out.println(rs.getString("username").toString());
		user.setPassword(rs.getString("password"));
		user.setUsername(rs.getString("username"));
		
	 user.setAbout(rs.getString("about"));
	 
		user.setRole(rs.getString("role"));
		user.setFavourites(rs.getString("favourites"));
		users.add(user);
		System.out.println("add duoc 1 user");
//		for (User user1 : users) {
//			System.out.println(user1.getName());
//		}
//		 
	//	System.out.println(user.getName());
	}
} catch (Exception e) {
	// TODO: handle exception
}
	return users;
	
}
public User getUserById(int id) {
	 
	Connection connection =JDBC.getJDBCconnect();
	String sql ="SELECT * FROM ban_qa.user WHERE ID = ?";
	try {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet rs  = preparedStatement.executeQuery();
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("NAME"));
			user.setPhone(rs.getString("Phone"));
			user.setPassword(rs.getString("password"));
			user.setUsername(rs.getString("username"));
			user.setAbout(rs.getString("about"));
			user.setRole(rs.getString("role"));
			user.setFavourites(rs.getString("favourites"));
			return user;
			 
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	return null;
	 
	 
}
 public void addUser(User user) {
	 Connection connection =JDBC.getJDBCconnect();
		String sql ="INSERT INTO ban_qa.user(NAME,Phone,username,password,about,role,favourites,id)"
				+ " VALUE (?,?,?,?,?,?,?,?)";
	try {
		PreparedStatement preparedStatement =connection.prepareStatement(sql);
		preparedStatement.setString(1, user.getName());
		preparedStatement.setString(2, user.getPhone());
		preparedStatement.setString(3, user.getUsername());
		preparedStatement.setString(4, user.getPassword());
		preparedStatement.setString(5, user.getAbout());
		preparedStatement.setString(6, user.getRole());
		preparedStatement.setString(7, user.getFavourites());
		preparedStatement.setInt(8, user.getId());
		int rs =preparedStatement.executeUpdate();
		
		System.out.println(rs);
	} catch (Exception e) {
		e.printStackTrace();
	}
	 
	
	}
 
	
public void updateUserAvatar(User user) {
	Connection connection =JDBC.getJDBCconnect();
	String sql ="UPDATE ban_qa.user set avatar =?where id=?";
	try {
		PreparedStatement preparedStatement =connection.prepareStatement(sql);
		preparedStatement.setString(1, user.getAvatar());
		 
		preparedStatement.setInt(2, user.getId());
		 int rs =preparedStatement.executeUpdate();
		 System.out.println(rs);
	} catch (Exception e) {
		// TODO: handle exception
	}
	
}
			
	public void updateUser(User user) {
		Connection connection =JDBC.getJDBCconnect();
		String sql ="UPDATE ban_qa.user set NAME =?, Phone=?, username=?,password=?,about=?,role=?,favourites=?"
				+ "where id=?";
		try {
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPhone());
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getAbout());
			preparedStatement.setString(6, user.getRole());
			preparedStatement.setString(7, user.getFavourites());
			 preparedStatement.setInt(8, user.getId());
			 int rs =preparedStatement.executeUpdate();
			 System.out.println(rs);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
			
 public void deleteUser(int id) {
	 Connection connection =JDBC.getJDBCconnect();
		String sql ="delete from ban_qa.user where id=?";
				try {
					PreparedStatement preparedStatement =connection.prepareStatement(sql);
				//User user= new User();
				//id =user.getId();
			 	preparedStatement.setInt(1,id );
					System.out.println("xoa thanh cong phan tu  "+ id);
					 int rs =preparedStatement.executeUpdate(); 
				} catch (Exception e) {
					// TODO: handle exception
				}
 }
public User getUserByUsername(String username) {
	 Connection connection =JDBC.getJDBCconnect();
		String sql ="select * from ban_qa.user where username=?";
	try {
		PreparedStatement preparedStatement =connection.prepareStatement(sql);
		preparedStatement.setString(1, username);
		ResultSet rs  = preparedStatement.executeQuery();
		 
		while (rs.next()) {
			User user = new User();
			 
			user.setId(rs.getInt("id"));
		//	System.out.println(rs.getInt("id"));
			user.setName(rs.getString("NAME"));
			user.setPhone(rs.getString("Phone"));
			 
			user.setPassword(rs.getString("password"));
			user.setUsername(rs.getString("username"));
			
		 user.setAbout(rs.getString("about"));
		 
			user.setRole(rs.getString("role"));
			user.setFavourites(rs.getString("favourites"));
			return user;
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	return null;
	
}
public static void main(String[] args) {
	UserDao userDao = new UserDao();
	userDao.getAllUser();
	System.out.println("Lay tat ca phan tu ");
}
}
