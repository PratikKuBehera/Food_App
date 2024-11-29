package com.tap.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.tap.classes.User;
import com.tap.manager.OrdersImpl;
import com.tap.manager.UserImpl;


/**
 * Servlet implementation class OrderHistory
 */
@SuppressWarnings("serial")
@WebServlet("/OrderHistory")
public class OrderHistory extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		User u =(User) session.getAttribute("LoggedInUser");
		
		int userId = u.getUserId();
		System.out.println("Order history : "+userId);
		
		
		OrdersImpl ordersImpl = new OrdersImpl();
        List<com.tap.classes.OrderHistory> userHistory = ordersImpl.fetchOrderHistoryByUserId(userId);
       
        
        //adding to the session:
        session.setAttribute("userHistory", userHistory);
        
        //redirecting to the order history page:
        resp.sendRedirect("OrderHistory.jsp");
		
		
			
	}

}
