package com.tap.services;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.classes.CartItems;
import com.tap.classes.Menu;
import com.tap.manager.CartImp;
import com.tap.manager.MenuImp;


@SuppressWarnings("serial")
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 HttpSession session = req.getSession();
		
		 CartImp c =(CartImp) session.getAttribute("cart");
		 
		 if(c == null ) {
			 
		   c =new CartImp();
		   
		    session.setAttribute("cart", c);

		 }
		 
		 
	
		String str = req.getParameter("menuId");
		int menuId=Integer.parseInt(str);
		int quantity = Integer.parseInt( req.getParameter("quantity"));

		
		MenuImp mI =new MenuImp();
		Menu m = mI.fetchByMenuId(menuId);		
		
		CartItems ci = new CartItems(menuId,m.getItemsName(),quantity,m.getPrice(),m.getRestaurant());
		
		
		
		Map<Integer, CartItems> cart = c.addItems(ci);
		
		req.getSession().setAttribute("cart",c);
		
		resp.sendRedirect("Cart.jsp");
		
		
		
	}
	
	
}
