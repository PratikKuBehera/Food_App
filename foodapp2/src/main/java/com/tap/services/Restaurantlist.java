package com.tap.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.classes.Restaurant;
import com.tap.manager.RestaurantsImpl;

@SuppressWarnings("serial")
@WebServlet("/Restaurantlist")
public class Restaurantlist extends HttpServlet {
	
    private HttpSession session;

	@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	RestaurantsImpl rs = new RestaurantsImpl();
    	
    	List<Restaurant> reslist = rs.fetchAllRestaurant();
    	
    	System.out.println("res Servelt" +"" + reslist);

         PrintWriter writer =resp.getWriter();
         writer.println(reslist);
         
    	
    	session = req.getSession();
    	
    	session.setAttribute("restaurant", reslist);
    	
    	resp.sendRedirect("Home.jsp");
    	
    }
	
	
}
