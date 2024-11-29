package com.tap.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.classes.Menu;
import com.tap.manager.MenuImp;

/**
 * Servlet implementation class Showmenu
 */
@SuppressWarnings("serial")
@WebServlet("/Showmenu")
public class Showmenu extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
        int restId = Integer.parseInt(req.getParameter("restId"));
        
        
        MenuImp menuImp = new MenuImp();
        List<Menu> menuList = menuImp.fetchByRestId(restId);
        
        HttpSession session = req.getSession();
        session.setAttribute("menuList", menuList);
        
        resp.sendRedirect("showmenu.jsp");

	}
	
}
