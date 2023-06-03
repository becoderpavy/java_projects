package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDAOImpl;
import com.db.DbConnect;

@WebServlet("/reject")
public class RejectServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accno = req.getParameter("accno");

		AdminDAOImpl dao = new AdminDAOImpl(DbConnect.getConn());
		boolean f = dao.deleteAcc(accno);
		HttpSession session = req.getSession();

		if (f) {
			session.setAttribute("sussMsg", "Account Rejected..");
			resp.sendRedirect("admin/acc_status.jsp");
		}
	}

}
