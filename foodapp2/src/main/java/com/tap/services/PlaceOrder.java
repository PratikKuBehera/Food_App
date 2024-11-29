package com.tap.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.classes.User;

/**
 * Servlet implementation class PlaceOrder
 */
@SuppressWarnings("serial")
@WebServlet("/PlaceOrder")
public class PlaceOrder extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
        User u =(User) session.getAttribute("LoggedInUser");
        
        
        float totalPrice = Float.parseFloat(req.getParameter("totalPrice"));
        
        System.out.println(totalPrice);

        
        session.setAttribute("totalPrice", totalPrice);
        
        resp.sendRedirect("Checkout.jsp");
		
	}
}
