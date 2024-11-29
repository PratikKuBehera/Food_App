package com.tap.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.classes.OrderItems;
import com.tap.manager.OrdersImpl;


@SuppressWarnings("serial")
@WebServlet("/viewOrder")
public class viewOrder extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		int orderId= Integer.parseInt(req.getParameter("orderId"));
		
		OrdersImpl orderItems = new OrdersImpl();
		
		List<OrderItems> oditems =orderItems.fetchOrderItems(orderId);
		
		System.out.println("OrderItems ::::::::::::::"+ oditems);
		
		HttpSession session = req.getSession();
		
		session.setAttribute("oditems", oditems);
		
		
		resp.sendRedirect("viewOrder.jsp");
		
		
		
	}
	
}
