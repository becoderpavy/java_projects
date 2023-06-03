package com.org.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.OrganizationDAOImpl;
import com.db.DBConnect;
import com.entity.Organization;

@WebServlet("/ologin")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String em = req.getParameter("email");
			String ps = req.getParameter("password");

			OrganizationDAOImpl dao = new OrganizationDAOImpl(DBConnect.getConn());
			Organization o = dao.login(em, ps);

			HttpSession session = req.getSession();

			
				if (o != null) {
					session.setAttribute("orgobj", o);
					resp.sendRedirect("ngo/home.jsp");
				} else {
					session.setAttribute("failedMsg", "Invalid Email And Password");
					resp.sendRedirect("login.jsp");
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
