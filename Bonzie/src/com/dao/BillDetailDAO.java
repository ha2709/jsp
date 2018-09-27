package com.dao;

 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Bill;
import com.model.BillDetail;
import com.model.User;
import com.mysql.jdbc.PreparedStatement;

public class BillDetailDAO {
 public void insertBillDetail(BillDetail bill) throws SQLException {
	 Connection connection =JDBC.getJDBCconnect();
	 String sql = "INSERT INTO ban_qa.bill_detail VALUE(?,?,?,?,?)";
	 java.sql.PreparedStatement ps =connection.prepareStatement(sql);
	 System.out.println("Chay BIll Detail ");
	 ps.setInt(1, bill.getBillDetailID());
	 ps.setInt(2, bill.getBillID());
	 ps.setInt(3, bill.getProductID());
	 ps.setInt(4, bill.getPrice());
	 ps.setInt(5, bill.getQuantity());
	 ps.executeUpdate();
  }
 public List<BillDetail> getBillById(int id) {
	 	List<BillDetail> users = new ArrayList<BillDetail>();
		Connection connection =JDBC.getJDBCconnect();
		String sql ="SELECT * FROM ban_qa.bill_detail WHERE bill_id = ?";
		 System.out.println("Chay BIll Detail ");
		try {
			java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs  = preparedStatement.executeQuery();
			while (rs.next()) {
				BillDetail user = new BillDetail();
				user.setBillID(rs.getInt("id"));
				 user.setBillDetailID(rs.getInt("bill_id"));
				 user.setPrice(rs.getInt("price"));
				 user.setProductID(rs.getInt("product_id"));
				 user.setQuantity(rs.getInt("quantity"));
				 users.add(user);
				 
					 
				 
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		for (BillDetail user1 : users) {
			System.out.println(user1.getProductID());
		}
		return users;
		 
		 
	}
	public static void main(String[] args) throws SQLException {
		BillDetailDAO billDAO = new BillDetailDAO();
 	billDAO.getBillById(415);
 	
		 System.out.println("Da chay duoc");
	}
}
