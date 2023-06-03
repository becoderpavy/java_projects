package com.user.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAOImpl;
import com.db.DbConnect;
import com.entity.User;

@WebServlet("/create_account")
public class create_account_servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String fn = req.getParameter("fn");
			String ln = req.getParameter("ln");
			String em = req.getParameter("em");
			String ph = req.getParameter("ph");

//			LocalDate dob = LocalDate.parse(req.getParameter("dob"));
			String dob = req.getParameter("dob");
			String adh = req.getParameter("adh");
			String add = req.getParameter("add");
			String city = req.getParameter("city");
			String st = req.getParameter("st");
			String zip = req.getParameter("zip");

			String check = req.getParameter("check");

			User us = new User(fn, ln, em, ph, dob, adh, add, city, st, zip);
			//System.out.println(us);

			HttpSession session = req.getSession();
			if (check == null) {
				session.setAttribute("ErrorMsg", "Please check Agree Terms & Condition");
				resp.sendRedirect("create_account.jsp");
			} else {
				UserDAOImpl dao = new UserDAOImpl(DbConnect.getConn());
				boolean f = dao.createAccount(us);
				if (f) {
					session.setAttribute("SucessMsg",
							"Please Wait..Get Account Creation Confirmation within 30 Minute");
					resp.sendRedirect("create_account.jsp");
				} else {
					session.setAttribute("ErrorMsg", "Something wrong on server");
					resp.sendRedirect("create_account.jsp");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
