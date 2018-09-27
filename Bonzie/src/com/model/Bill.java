package com.model;

import java.security.Timestamp;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Bill {
	


public Bill() {
		super();
	}


public Bill(int billid, int userID,   String address, java.util.Date ngaymua, double total, String payment) {
		super();
		Billid = billid;
		this.userID = userID;
		this.ngaymua = ngaymua;
		this.address = address;
		this.total = total;
		this.payment = payment;
	}


public int getBillid() {
	return Billid;
}
public void setBillid(int billid) {
	Billid = billid;
}
public int getUserID() {
	return userID;
}
public void setUserID(int userID) {
	this.userID = userID;
}
 
 
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
public String getPayment() {
	return payment;
}
public void setPayment(String payment) {
	this.payment = payment;
}


private int Billid;
private int userID;
 private java.util.Date ngaymua;
public java.util.Date getNgaymua() {
	return ngaymua;
}


public void setNgaymua(java.util.Date ngaymua) {
	this.ngaymua = ngaymua;
}


private String address;
private double total;
private String payment;

public static void main(String[] args) {
//	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//	 
//	java.util.Date date = new java.util.Date();
	 
}
}



