package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.Db.DBConnect;
import com.entity.User;

@WebServlet("/login")
public class loginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserDAO dao = new UserDAO(DBConnect.getConn());
		User us = dao.loginUser(email, password);
		HttpSession session = request.getSession();
		if (us != null) {
			session.setAttribute("userobj", us);
			response.sendRedirect("index.jsp");

		} else {
			session.setAttribute("failedMsg", "Invalid Email & Password");
			response.sendRedirect("login.jsp");
		}

	}

}
