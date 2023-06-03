package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.UserDAO;
import com.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String em = req.getParameter("em");
			String ps = req.getParameter("ps");

			HttpSession session = req.getSession();

			UserDAO dao = new UserDAO(DBConnect.getConn());

			User u = new User();

			if ("admin@gmail.com".equals(em) && "admin".equals(ps)) {
				u.setName("admin");
				session.setAttribute("userobj", u);
				resp.sendRedirect("admin.jsp");
			}

			else {

				u = dao.login(em, ps);
				if (u != null) {
					session.setAttribute("userobj", u);
					resp.sendRedirect("user_view.jsp");
				} else {
					session.setAttribute("succMsg", "Invalid Email & Password");
					resp.sendRedirect("login.jsp");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
