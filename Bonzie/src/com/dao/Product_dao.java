package com.dao;

 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.model.Product;

public class Product_dao {
	

public   List<Product> getAllUser() {
		List<Product> products = new ArrayList<Product>();

		Connection connection =JDBC.getJDBCconnect();
		
		String sql = "SELECT * FROM ban_qa.product";
try {
	PreparedStatement preparedStatement = connection.prepareStatement(sql);
	ResultSet rs = preparedStatement.executeQuery();
 	 System.out.println("Ket noi thanh cong CSDL, da co my sql connector ");
	while (rs.next()) {
		Product product = new Product();
		 
		
	
		product.setId(rs.getInt("id"));
		product.setGia(rs.getInt("gia"));
		product.setName(rs.getString("name"));
		product.setMo_ta(rs.getString("mo_ta"));
		product.setNha_sx(rs.getInt("nha_sx"));
		product.setSo_luong(rs.getInt("so_luong"));
		product.setMuc_hang(rs.getInt("muc_hang"));
		product.setImage(rs.getString("image"));
		
		products.add(product);
 	 	
 		
		 
	//	System.out.println(user.getName());
	}
} catch (Exception e) {
	// TODO: handle exception
}
System.out.println("da goi tat ca Product");
	return products;
	
}
public Product getProductById(int id) {
	 
	Connection connection =JDBC.getJDBCconnect();
	String sql ="SELECT * FROM ban_qa.product WHERE id = ?";
	try {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet rs  = preparedStatement.executeQuery();
 		System.out.println("Da vao get id");
		while (rs.next()) {
			Product product = new Product();
			product.setId(rs.getInt("id"));
			product.setGia(rs.getInt("gia"));
			product.setName(rs.getString("name"));
			product.setMo_ta(rs.getString("mo_ta"));
			product.setNha_sx(rs.getInt("nha_sx"));
			product.setSo_luong(rs.getInt("so_luong"));
			product.setMuc_hang(rs.getInt("muc_hang"));
			product.setImage(rs.getString("image"));
 		//	 System.out.println("Gia sp la " + product.getGia());
			return product;
			
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	return null;
	 
	 
}

public List<Product> getProductBymh(int muc_hang) {
	List<Product> list1 = new ArrayList<Product>();
	Connection connection =JDBC.getJDBCconnect();
	String sql ="SELECT * FROM ban_qa.product WHERE muc_hang = ?";
	
	try {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, muc_hang);
		ResultSet rs  = preparedStatement.executeQuery();
 		System.out.println("get Product by MH ");
		
				
		while (rs.next()) {
			Product product = new Product();
			product.setId(rs.getInt("id"));
			product.setGia(rs.getInt("gia"));
			product.setName(rs.getString("name"));
			product.setMo_ta(rs.getString("mo_ta"));
			product.setNha_sx(rs.getInt("nha_sx"));
			product.setSo_luong(rs.getInt("so_luong"));
			product.setMuc_hang(rs.getInt("muc_hang"));
			product.setImage(rs.getString("image"));
 		 //	 System.out.println("Gia sp la " + product.getGia());
 			list1.add(product);
			
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	//System.out.println(list1);
	return list1;
	 
	 
	 
}
 public void addProduct(Product product) {
	 Connection connection =JDBC.getJDBCconnect();
		String sql ="INSERT INTO ban_qa.product(id,name,mo_ta,so_luong,gia,muc_hang,nha_sx,image)"
				+ " VALUE (?,?,?,?,?,?,?,?)";
	try {
		PreparedStatement preparedStatement =connection.prepareStatement(sql);
		preparedStatement.setInt(1, product.getId());
		preparedStatement.setString(2, product.getName());
		preparedStatement.setString(3, product.getMo_ta());
		preparedStatement.setInt(4, product.getSo_luong());
		preparedStatement.setInt(5, product.getGia());
		preparedStatement.setInt(6, product.getMuc_hang());
		preparedStatement.setInt(7, product.getNha_sx());
		preparedStatement.setString(8, product.getImage());
		int rs =preparedStatement.executeUpdate();
		
		System.out.println(rs);
	} catch (Exception e) {
		e.printStackTrace();
	}
	 
	
	}
 
	
public void updateUserimage(Product product) {
	Connection connection =JDBC.getJDBCconnect();
	String sql ="UPDATE ban_qa.product set image =?where id=?";
	try {
		PreparedStatement preparedStatement =connection.prepareStatement(sql);
		preparedStatement.setString(1, product.getImage());
		 
		preparedStatement.setInt(2, product.getId());
		 int rs =preparedStatement.executeUpdate();
		 System.out.println(rs);
	} catch (Exception e) {
		// TODO: handle exception
	}
	
}
			
	public void updateProduct(Product product) {
		Connection connection =JDBC.getJDBCconnect();
		String sql ="UPDATE ban_qa.product set name =?, mo_ta=?, so_luong=?,gia=?,muc_hang=?,nha_sx=?,image=?"
				+ "where id=?";
		try {
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getMo_ta());
			preparedStatement.setInt(3, product.getSo_luong());
			preparedStatement.setInt(4, product.getGia());
			preparedStatement.setInt(5, product.getMuc_hang());
			preparedStatement.setInt(6, product.getNha_sx());
		
			preparedStatement.setString(7, product.getImage());
			 preparedStatement.setInt(8, product.getId());
			 int rs =preparedStatement.executeUpdate();
			 System.out.println(rs);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
			
 public void deleteUser(int id) {
	 Connection connection =JDBC.getJDBCconnect();
		String sql ="delete from ban_qa.product where id=?";
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
public Product getProductByname(String name) {
	 Connection connection =JDBC.getJDBCconnect();
		String sql ="select * from ban_qa.product where name=?";
	try {
		PreparedStatement preparedStatement =connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		ResultSet rs  = preparedStatement.executeQuery();
		 
		while (rs.next()) {
			Product product = new Product();
			 
			product.setId(rs.getInt("id"));
			product.setGia(rs.getInt("gia"));
			product.setName(rs.getString("name"));
			product.setMo_ta(rs.getString("mo_ta"));
//			product.setNha_sx(rs.getInt("nha_sx"));
			product.setSo_luong(rs.getInt("so_luong"));
			product.setMuc_hang(rs.getInt("muc_hang"));
			product.setImage(rs.getString("image"));
			return product;
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	return null;
	
}
 
public static void main(String[] args) {
	//Product_dao product_dao = new Product_dao();
	 
	// List<Product> p1;
	// product_dao.getProductById(2);
	// p1=     product_dao.getProductBymh(1);
//	product_dao.getProductById(1);
 	//product_dao.getAllUser();
//	System.out.println("Lay cac phan tu");
//	List<Product> products = new ArrayList<Product>();
//	 for (Product user1 : p1) {
//			System.out.println("ten " +user1.getName());
//		}
}
 
}
