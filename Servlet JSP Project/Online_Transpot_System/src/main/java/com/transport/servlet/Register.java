package com.transport.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.transport.conn.DbConnect;
import com.transport.dao.UserDAO;
import com.transport.entites.User;

@WebServlet("/registerUser")
public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String fullName = req.getParameter("fullName");
			String userName = req.getParameter("userName");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String location = req.getParameter("location");
			String role = "user";

			User user = new User(fullName, userName, email, password, location, role);

			UserDAO dao = new UserDAO(DbConnect.getConnection());

			HttpSession session = req.getSession();

			if (dao.checkUsername(userName)) {
				session.setAttribute("errorMsg", "username already exist");
			} else if (dao.checkEmail(email)) {
				session.setAttribute("errorMsg", "email already exist");
			} else {
				
				
				boolean f = dao.createUser(user);
				if (f) {
					session.setAttribute("succMsg", "Register Success");
				} else {
					session.setAttribute("errorMsg", "Something wrong on server");
				}

			}

			resp.sendRedirect("signup.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
