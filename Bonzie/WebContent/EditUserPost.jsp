<%@page import="com.model.User"%>
<%@page import="com.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%

String name= request.getParameter("name");
String idstr = request.getParameter("id");
System.out.println("ID str "+idstr);
int id1=Integer.valueOf(idstr);
System.out.println("ID dich int "+id1);
 
 

String password= request.getParameter("password");
String phone= request.getParameter("phone");
 String about = request.getParameter("about");
 String username= request.getParameter("username");
 String[] favourites= request.getParameterValues("favourites");
 String fav="";
 
 for (String f:favourites){
	 fav +=f+ " , ";
 }
 
 String role = request.getParameter("role");
 
 UserService userService = new UserService();
 User user = new User();
 user.setName(name);
 user.setPassword(password);
 user.setUsername(username);
 user.setFavourites(fav);
 user.setPhone(phone);
 user.setRole(role);
 
 user.setId(id1);
user.setAbout(about);
userService.updateUser(user);
response.sendRedirect("/Bonzie/account2.jsp");

 
%>