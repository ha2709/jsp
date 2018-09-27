package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC {
public static Connection getJDBCconnect() {
final String url ="jdbc:mysql://localhost:3306/ban_qa";
//	final String url ="jdbc:mysql://localhost:3306/hello";
	String user ="root";
	String password="";

	
	try {  
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(url, user, password);
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return null;
		
}
 
}
