package com.model;

public class BillDetail {
	
	
public BillDetail(int billDetailID, int billID, int productID, int price, int quantity) {
		super();
		this.billDetailID = billDetailID;
		this.billID = billID;
		this.productID = productID;
		this.price = price;
		this.quantity = quantity;
	}


public BillDetail() {
	 
}


public int getBillDetailID() {
	return billDetailID;
}


public void setBillDetailID(int billDetailID) {
	this.billDetailID = billDetailID;
}


public int getBillID() {
	return billID;
}


public void setBillID(int billID) {
	this.billID = billID;
}


public int getProductID() {
	return productID;
}


public void setProductID(int productID) {
	this.productID = productID;
}


public int getPrice() {
	return price;
}


public void setPrice(int price) {
	this.price = price;
}


public int getQuantity() {
	return quantity;
}


public void setQuantity(int quantity) {
	this.quantity = quantity;
}


private int billDetailID;
private int billID;
private int productID;
private int price;
private int quantity;


}
