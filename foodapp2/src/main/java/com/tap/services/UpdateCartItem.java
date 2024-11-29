package com.tap.services;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.classes.CartItems;
import com.tap.interfaces.CartDao;
import com.tap.manager.CartImp;


@SuppressWarnings("serial")
@WebServlet("/UpdateCartItem")
public class UpdateCartItem extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int  itemId = Integer.parseInt(req.getParameter("itemId"));
		
		int quantity = Integer.parseInt( req.getParameter("quantity"));
		
	    CartImp cart = (CartImp) req.getSession().getAttribute("cart");

				if (cart != null) {
					cart.update(itemId, quantity);

					req.getSession().setAttribute("cart", cart);
				}

				resp.sendRedirect("Cart.jsp");
		 
		
		
		
		
	}

}
