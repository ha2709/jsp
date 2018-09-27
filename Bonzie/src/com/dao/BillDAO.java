package com.dao;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.model.Bill;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
 



public class BillDAO {
	public void addUser1(Bill user) {
		 Connection connection =JDBC.getJDBCconnect();
	 	 String sql = "INSERT INTO ban_qa.bill VALUE(?,?,?,?,?,?)";
		try {
		
			PreparedStatement ps = connection.prepareStatement(sql);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			java.util.Date date = new java.util.Date();
			 
			ps.setInt(1, user.getBillid());
			 
			ps.setInt(2, user.getUserID());
			 
			ps.setString(3, user.getAddress());//dateFormat.format(date)
			
		
			ps.setDouble(4, user.getTotal());
			ps.setString(5, user.getPayment()); 
			
			ps.setDate(6, new java.sql.Date(System.currentTimeMillis()));
		 	 ps.executeUpdate();
		 
		 	
		} catch (Exception e) {
			System.out.println("khong them duoc billDAO");
			e.printStackTrace();
		}
		 
		
		 
	}
//	public static void main(String[] args) {
//		BillDAO billDAO = new BillDAO();
 	
//		new BillDAO().addUser1(new Bill(1, 1,"a",0,"tien_mat" ));
//	}
}
