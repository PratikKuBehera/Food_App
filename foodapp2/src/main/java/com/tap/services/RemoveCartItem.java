package com.tap.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.manager.CartImp;

/**
 * Servlet implementation class RemoveCartItem
 */
@SuppressWarnings("serial")
@WebServlet("/RemoveCartItem")
public class RemoveCartItem extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int itemId = Integer.parseInt(req.getParameter("itemsId") );    // here itemsid mean MenuId
		
				CartImp cart = (CartImp) req.getSession().getAttribute("cart");

				if (cart != null) {
					cart.remove(itemId);
					
					req.getSession().setAttribute("cart", cart);
				}
				
				resp.sendRedirect("Cart.jsp");
	}
	

}
