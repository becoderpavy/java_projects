package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAOImpl;
import com.conn.ConnectionProvider;

@WebServlet("/addAdress")
public class addAdress extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
			String address=req.getParameter("address");
			String landmark=req.getParameter("landmark");
			String city=req.getParameter("city");
			String state=req.getParameter("state");
			String zip=req.getParameter("pin");
			int id=Integer.parseInt(req.getParameter("id"));
			
			UserDAOImpl dao=new UserDAOImpl(ConnectionProvider.getConnection());
			boolean f=dao.addAdress(address, landmark, city, state, zip, id);
			
			HttpSession session = req.getSession();
			if (f) {
				session.setAttribute("sucessMsg", "Adress Update Sucessfully..");
				resp.sendRedirect("user_address.jsp");
			} else {
				session.setAttribute("errorMsg", "Something Went Wrong on Server..");
				resp.sendRedirect("user_address.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
