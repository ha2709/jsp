 package com.model;

public class Product {
public Product() {
		 
	}
public Product(int id, String name, String mo_ta, int so_luong, int gia, int muc_hang, String image) {
		super();
		this.id = id;
		this.name = name;
		this.mo_ta = mo_ta;
		this.so_luong = so_luong;
		this.gia = gia;
		this.muc_hang = muc_hang;
		this.image = image;
	}
private int id;
private  String name;
private  String mo_ta;
private  int so_luong;
private  int gia;
private  int muc_hang;
private  int nha_sx;
private String image;

 
 public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMo_ta() {
	return mo_ta;
}
public void setMo_ta(String mo_ta) {
	this.mo_ta = mo_ta;
}
public int getSo_luong() {
	return so_luong;
}
public void setSo_luong(int so_luong) {
	this.so_luong = so_luong;
}
public int getGia() {
	return gia;
}
public void setGia(int gia) {
	this.gia = gia;
}
public int getMuc_hang() {
	return muc_hang;
}
public void setMuc_hang(int muc_hang) {
	this.muc_hang = muc_hang;
}
public int getNha_sx() {
	return nha_sx;
}
public void setNha_sx(int nha_sx) {
	this.nha_sx = nha_sx;
}
 

 
 
}
