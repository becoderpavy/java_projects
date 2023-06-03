package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CartDAOImpl;
import com.conn.ConnectionProvider;

@WebServlet("/removeCartServlet")
public class removeCartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bid=Integer.parseInt(req.getParameter("bid"));
		int uid=Integer.parseInt(req.getParameter("uid"));
		
		CartDAOImpl dao=new CartDAOImpl(ConnectionProvider.getConnection());
		boolean b=dao.removeCart(bid, uid);
		HttpSession session=req.getSession();
		if(b) {
			session.setAttribute("removeMsg","Your Item Is Removed");
			resp.sendRedirect("checkout.jsp");
		}
		else {
			session.setAttribute("errorMsg","Something went wrong on server");
			resp.sendRedirect("checkout.jsp");
		}
		
	}
	
	

}
