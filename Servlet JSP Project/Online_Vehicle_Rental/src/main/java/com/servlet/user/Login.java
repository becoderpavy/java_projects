package com.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.DBConnect;
import com.entites.User;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		UserDao dao = new UserDao(DBConnect.getConnection());

		User user = dao.login(email, password);

		HttpSession session = req.getSession();

		if (user != null) {

			if ("ADMIN".equals(user.getRole())) {
				session.setAttribute("adminObj", user);
				resp.sendRedirect("admin/home.jsp");
			}

			else {
				session.setAttribute("userObj", user);
				resp.sendRedirect("index.jsp");
			}

		} else {
			session.setAttribute("errorMsg", "Inavalid email & password");
			resp.sendRedirect("login.jsp");
		}

	}

}
