package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 

import com.dao.BillDAO;
import com.dao.BillDetailDAO;
import com.model.Bill;
import com.model.BillDetail;
import com.model.Cart;
import com.model.Item;
import com.model.User;
import java.util.Random;
/**
 * Servlet implementation class checkServlet
 */
@WebServlet("/checkServlet")
public class checkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     private BillDAO billDAO = new BillDAO();
     private final BillDetailDAO billDetailDAO = new BillDetailDAO();
    public checkServlet() {
      
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String payment =request.getParameter("payment");// lay bien payment tu request gui len
	 String address=request.getParameter("address");
	 HttpSession session = request.getSession(); // dung session de lay cac bien tap hop
	 Cart cart =(Cart) session.getAttribute("cart");
	 User user = (User) session.getAttribute("user");
	 System.out.println("Lay address " + address);
	  {Random rand = new Random();

	  	int  id = rand.nextInt(500) + 1;
	  	int idt=id;
		 // int id =Math.random();
// 		long ID= new Date().getTime();
// 		String idString = String.valueOf(ID);
// 		 
// 		int id = Integer.valueOf(idString);
		System.out.println(" CheckServlet ID  la "+ id);
		 Bill bill = new Bill();
		 bill.setBillid(id);
		bill.setAddress(address);
		bill.setNgaymua(java.sql.Date.valueOf(java.time.LocalDate.now()));
		bill.setPayment(payment);
		//bill.setUserID(user.getId());
		bill.setUserID(id);
	
		bill.setTotal(cart.sumToCart());
		billDAO.addUser1(bill);
		System.out.println("Khoi tao bill ");
		for(Map.Entry<Integer, Item> list: cart.getCartItems().entrySet() ) {
			try { 	int  id1 = rand.nextInt(500) + 1;
				billDetailDAO.insertBillDetail(new BillDetail(id1, id,	list.getValue().getProduct().getId()
						, list.getValue().getProduct().getGia(),
						list.getValue().getQuantity()));
			} catch (SQLException e) {
				System.out.println("ngoai le k tao duoc bill detail ");
				e.printStackTrace();
			}
 
			
		}
		cart = new Cart(); // cho gio hang moi
        session.setAttribute("cart", cart);
      
	} 
	  // session.setAttribute("idt", idt);
	System.out.println("Quay ve index");
	  response.sendRedirect("/Bonzie/account3.jsp");
	}

}
