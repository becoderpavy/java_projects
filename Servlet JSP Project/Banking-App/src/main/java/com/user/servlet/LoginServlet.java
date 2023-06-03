package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAOImpl;
import com.db.DbConnect;
import com.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("uname");
		String password = req.getParameter("pswd");

		UserDAOImpl dao = new UserDAOImpl(DbConnect.getConn());
		HttpSession session = req.getSession();

		if ("admin".equals(username) && "admin".equals(password)) {
			User us = new User();
			session.setAttribute("userobj", us);
			resp.sendRedirect("admin/index.jsp");
		} else {
			User u = dao.login(username, password);
			if (u != null) {
				boolean f = dao.checkStatus(username);
				if (f) {
					session.setAttribute("userobj", u);
					resp.sendRedirect("home.jsp");
				} else {
					session.setAttribute("failedmsg", "Your Account is not Active");
					resp.sendRedirect("login.jsp");
				}
			} else {
				session.setAttribute("failedmsg", "Username & Password invalid");
				resp.sendRedirect("login.jsp");
			}
		}

	}

}
