<%@page import="com.model.User"%>
<%@page import="com.model.Item"%>
<%@page import="java.util.Map"%>
<%@page import="com.model.Cart"%>
 
<%@page import="com.model.Category"%>
<%@page import="com.dao.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Check out</title>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>shop</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>  
        <!-- Custom Theme files -->
        <!--theme-style-->
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
        <!--//theme-style-->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Bonfire Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!--fonts-->
        <link href='http://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
        <!--//fonts-->
        <script type="text/javascript" src="js/move-top.js"></script>
        <script type="text/javascript" src="js/easing.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function ($) {
                $(".scroll").click(function (event) {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
                });
            });
        </script>
        <!--slider-script-->
        <script src="js/responsiveslides.min.js"></script>
        <script>
            $(function () {
                $("#slider1").responsiveSlides({
                    auto: true,
                    speed: 500,
                    namespace: "callbacks",
                    pager: true,
                });
            });
        </script>
        <!--//slider-script-->
        <script>$(document).ready(function (c) {
                $('.alert-close').on('click', function (c) {
                    $('.message').fadeOut('slow', function (c) {
                        $('.message').remove();
                    });
                });
            });
        </script>
        <script>$(document).ready(function (c) {
                $('.alert-close1').on('click', function (c) {
                    $('.message1').fadeOut('slow', function (c) {
                        $('.message1').remove();
                    });
                });
            });
        </script>


</head>
<body>
 
	   <%
            CategoryDAO categoryDAO = new CategoryDAO();
        User user =null;
        if (session.getAttribute("user") !=null){
        		user = (User) session.getAttribute("user");
        }
        Cart cart = (Cart) session.getAttribute("cart");
         
        if  (cart==null){
        	cart = new Cart();
        	session.setAttribute("cart", cart);
        }
        
			 
			//if (user == null) {
				System.out.println("Khoi tao user");
			//	response.sendRedirect("/Bonzie/index.jsp");
		//	}
		%>
 
     <jsp:include page="header.jsp"></jsp:include>

      	   <div class="container">
                <div class="account">
                    <h2 class="account-in">Checkout</h2>
                   
                    
                         <% 
                         double tong_tien=0;
                         for (Map.Entry<Integer,Item > list: cart.getCartItems().entrySet()) {
                          int tien =list.getValue().getQuantity()*list.getValue().getProduct().getGia();
                         	tong_tien +=tien;
                         %>
                                            <div class="cart_box">
                                                <div class="message">
                                                   
                                                    <div class="list_img"><img src="<%=list.getValue().getProduct().getImage() %>" class="img-responsive" alt=""></div>
                                                    <div class="list_desc"><h4> 
                                                    <span class="actual"><%=list.getValue().getProduct().getName() %> : </span>
                                                    <%=list.getValue().getQuantity() %> x  $<%=list.getValue().getProduct().getGia() %>
                                                    = <%=tien %> đ
                                                    
                                                    </h4>
                                                    
                                                           
                                                           
                                                           
                                                           </div>
                                                    <div class="clearfix"></div>
                                                </div>
                                            </div>
                                             
                                         <%} %>
                                         <div class="list_desc"><h4> Tong tien = <%=tong_tien %></h4>
                                          <br/>
                                         <form action="checkServlet" method="POST">
						                        <div class="list_desc">Địa chỉ</span>
						                            <input type="text" name="address">
						                 		</div> 
						                 		<br/>	
						                         <div> 
						                            <span >Thanh toán </span>
						                            <select name="payment">
						                            	<option value="chuyen_khoan ">Chuyển khoản</option>
						                            	<option value="tien_mat">Tiền mặt</option>
						                            </select>
						                            
						                        </div>
						                        <input type="hidden" value="Đăng nhập" name="command">				
						                        <input type="submit" value="Thanh toán"> 
						                    </form>
                                         </div>
                                        
                                         
                </div>
                
            </div>
				 
        <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>