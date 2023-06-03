package com.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.db.DBConnect;
import com.entites.User;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String em = req.getParameter("email");
			String ps = req.getParameter("password");

			UserDAO dao = new UserDAO(DBConnect.getConn());
			HttpSession session = req.getSession();

			
			if("admin@gmail.com".equals(em) && "admin".equals("admin"))
			{
				session.setAttribute("adminObj", new User());
				resp.sendRedirect("admin/index.jsp");
			}else {
				User user = dao.login(em, ps);
				if (user != null) {
					session.setAttribute("userObj", user);
					resp.sendRedirect("index.jsp");
				} else {
					session.setAttribute("failedMsg", "invalid email and password");
					resp.sendRedirect("login.jsp");
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
