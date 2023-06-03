package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.AdminDAOImpl;
import com.db.DbConnect;
import com.entity.User;

@WebServlet("/create_accnt")
public class CreateAccnt extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String fn = req.getParameter("fn");
			String ln = req.getParameter("ln");
			String em = req.getParameter("em");
			String ph = req.getParameter("ph");
			String dob = req.getParameter("dob");
			String adh = req.getParameter("adh");
			String add = req.getParameter("add");
			String city = req.getParameter("city");
			String st = req.getParameter("st");
			String zip = req.getParameter("zip");

			String check = req.getParameter("check");

			User us = new User(fn, ln, em, ph, dob, adh, add, city, st, zip);
			

			HttpSession session = req.getSession();;
			if (check == null) {
				session.setAttribute("ErrorMsg", "Please check Agree Terms & Condition");
				resp.sendRedirect("admin/open_acc.jsp");
			} else {
				AdminDAOImpl dao = new AdminDAOImpl(DbConnect.getConn());
				boolean f = dao.createAccnt(us);
				if (f) {
					session = req.getSession();
					session.setAttribute("SucessMsg", "Account Open Sucessfully..");
					resp.sendRedirect("admin/open_acc.jsp");
				}else {
					session.setAttribute("ErrorMsg", "Something wrong on Server.");
					resp.sendRedirect("admin/open_acc.jsp");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
