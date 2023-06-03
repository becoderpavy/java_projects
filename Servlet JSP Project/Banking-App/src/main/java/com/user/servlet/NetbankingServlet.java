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

@WebServlet("/netbanking")
public class NetbankingServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String accno = req.getParameter("acno");
			String username = req.getParameter("usname");
			String password = req.getParameter("psw");

			UserDAOImpl dao = new UserDAOImpl(DbConnect.getConn());
			HttpSession session = req.getSession();
			boolean f2 = dao.findAccount(accno);
			if (f2) {
				boolean f3 = dao.findUsername(username);
				if (f3) {
					boolean f = dao.createNetbanking(username, password, accno);
					if (f) {
						session.setAttribute("sucessmsg", "Netbanking Registartion Sucessfully..");
						resp.sendRedirect("netbanking.jsp");
					} else {
						session.setAttribute("failedmsg", "Your Account is Not Active");
						resp.sendRedirect("netbanking.jsp");
					}
				} else {
					session.setAttribute("failedmsg", "Username Already Exist..");
					resp.sendRedirect("netbanking.jsp");
				}
			} else {
				session.setAttribute("failedmsg", "Account No Is not Correct..");
				resp.sendRedirect("netbanking.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
