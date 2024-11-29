package com.tap.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.decode.Decode;
import com.tap.manager.UserImpl;


@SuppressWarnings("serial")
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email= req.getParameter("email");
		int mobile = Integer.parseInt(req.getParameter("mobile"));
		String address = req.getParameter("address");
		String password = req.getParameter("password");
		String confirmpassword =req.getParameter("confirmpassword");
		
		
		if(confirmpassword.equals(password)) {
						
			Decode de = new Decode();
			
			@SuppressWarnings("static-access")
			String pwd = de.encrypt(password);// encrepting the password
			
			UserImpl user = new UserImpl();

			
			user.insertUser(name, email, mobile, pwd , address);
			
			resp.sendRedirect("Login.jsp");
		
		}
		else {
			resp.sendRedirect("Registration.jsp");
		}

		
	}
	

}
