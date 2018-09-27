package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Product_dao;
import com.model.Cart;
import com.model.Item;
import com.model.Product;

/**
 * Servlet implementation class CartServlet
 */

// sai co ban, da dung xml cau hinh roi. Lai dung them Annotation cau hinh servlet nuâ
// 2 
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Product_dao product_dao= new Product_dao(); 
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 HttpSession session = request.getSession();
	 String command = request.getParameter("command");
	
	 String id = request.getParameter("id");
	 System.out.println("command nhan duoc la "+ command);
	 Cart cart =(Cart) session.getAttribute("cart");
	 try {
		 int id1= Integer.parseInt(id);
		 System.out.println("Id cua sp la " + id1);
		Product product = product_dao.getProductById(id1);
		switch (command) {
		case "plus":
			System.out.println("Them duoc 1 san pham");
			if (cart.getCartItems().containsKey(id1)) {
				
				cart.plusToCart(id1	, new Item(product, cart.getCartItems().get(id1).getQuantity()));
			} else {
				cart.plusToCart(id1, new Item(product, 1));
			}
			break;
		case "remove":
			System.out.println("bot di 1 san pham ");
			cart.removeToCart(id1);
			break;
		default:
			System.out.println("Mac dinh");
			break;
		}
	} catch (Exception e) {
		e.printStackTrace();
		response.sendRedirect("/Bonzie/index.jsp");
	}
	 session.setAttribute("cart", cart);
	 response.sendRedirect("/Bonzie/index.jsp");
   }

}
