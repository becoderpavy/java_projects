package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			HttpSession session=req.getSession();
			session.removeAttribute("userobj");
			session.setAttribute("succMsg", "Logout sucessfully");
			resp.sendRedirect("index.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}
