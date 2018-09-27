<%@page import="com.service.UserService"%>
<%@page import="com.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%
String idstr = request.getParameter("id");
UserService userService = new UserService();
 userService.deleteUser(Integer.valueOf(idstr));
 response.sendRedirect("/BH/login1.jsp");
 %>

 