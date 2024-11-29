package com.tap.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.classes.User;
import com.tap.manager.UserImpl;


@SuppressWarnings("serial")
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email =req.getParameter("Email");
		String password =req.getParameter("password");
		UserImpl u = new UserImpl();
		u.connection();
		User user = u.userLogin(email, password);
		
		//System.out.println("Login .java "+user);
		
	
        	Cookie ck = new Cookie("email" , email );		
     		resp.addCookie(ck);
		
		
		
		if(user!=null) {
			HttpSession session = req.getSession();
			session.setAttribute("LoggedInUser",user);
			resp.sendRedirect("Restaurantlist");	
		}
		else {	
			resp.sendRedirect("Login.jsp");	
		}
		
		
		
	}
}