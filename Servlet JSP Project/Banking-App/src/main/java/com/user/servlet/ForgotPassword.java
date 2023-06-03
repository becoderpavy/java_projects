package com.user.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.dao.UserDAOImpl;
import com.db.DbConnect;
import com.entity.User;

@WebServlet("/forgot")
public class ForgotPassword extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String accno = req.getParameter("accno");
			String username = req.getParameter("uname");

			UserDAO dao = new UserDAOImpl(DbConnect.getConn());
			User us = dao.checkUsernameAndAccno(accno, username);

			HttpSession session = req.getSession();

			if (us != null) {
				String msg = "Hi " + us.getFirstName() + " " + us.getLastName() + ",\n" + "Your Password="
						+ us.getPassword();
				String sub = "Netbanking Password";
				String to = us.getEmail();
				String from = "daspabitra55@gmail.com";

				session.setAttribute("succmsg", "Check your Email password is send");
				resp.sendRedirect("forgot.jsp");
			} else {
				session.setAttribute("failedmsg", "Account no or Username Invalid");
				resp.sendRedirect("forgot.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
