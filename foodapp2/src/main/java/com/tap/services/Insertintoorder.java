package com.tap.services;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.classes.CartItems;
import com.tap.classes.Menu;
import com.tap.classes.OrderHistory;
import com.tap.classes.OrderItems;
import com.tap.classes.Orders;
import com.tap.classes.Restaurant;
import com.tap.classes.User;
import com.tap.manager.CartImp;
import com.tap.manager.OrdersImpl;
import com.tap.manager.RestaurantsImpl;


@SuppressWarnings("serial")
@WebServlet("/Insertintoorder")
public class Insertintoorder extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		String paymentMode = req.getParameter("paymentMode");
		int  RestaurantID = Integer.parseInt(req.getParameter("RestaurantID"));
		

        HttpSession session = req.getSession();
		
		User u= (User) session.getAttribute("LoggedInUser");
		
		System.out.println(u);

		Menu m = new Menu();
	
		Float totalpriceFloat = (Float) session.getAttribute("totalPrice");
		Integer totalprice = totalpriceFloat.intValue();
		
		CartImp cart = (CartImp) session.getAttribute("cart");
		 

		OrdersImpl  orimp = new OrdersImpl();
		
		//int userId, int restaurentId, int totalamount, boolean status, String paymentoption
		
		orimp.insertOrder(u.getUserId(),RestaurantID,totalprice ,true, paymentMode );
		
		
		int oid = orimp.getOrderId();
		
		
		
		Orders order =orimp.fetchOnOrderId(oid);
		
		
		
		OrderItems orderItems = null ;
		
		Map<Integer, CartItems> item = cart.getItems();
		
		Collection<CartItems> values = item.values();
		Iterator<CartItems> itr = values.iterator();
		while(itr.hasNext()) {
		    CartItems currentItem = itr.next(); 
		    
		    orderItems = orimp.insertOrderItems(currentItem.getMenuId(), currentItem.getQuantity(), totalprice, order);
		}
			
		
		//int userId, int orderId, int totalamount, String status:
		OrderHistory orderHistory =orimp.insertOrderHistory(u.getUserId(),order,totalprice,"Sucessfully Delivered");
		
		
		
		orderHistory.getOrderId().getRestaurentId();
		
		RestaurantsImpl rid =new RestaurantsImpl();
		
		Restaurant orid=rid.fetchByRestId(oid);

		
		//setting to session
		session.setAttribute("restaurentName", orid);		
		session.setAttribute("OrderItems", orderItems);		
		session.setAttribute("OrderHistory", orderHistory);

	    
		
        resp.sendRedirect("Success.jsp");
        
        
		
		
	}
	

}
