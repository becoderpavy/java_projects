package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CheckDAO;
import com.db.DbConnect;
import com.entity.ApplyCheck;

@WebServlet("/applyCheck")
public class ApplyCheckServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String accountNo = req.getParameter("accountNo");

		ApplyCheck ap = new ApplyCheck(0, name, accountNo, "Pending");

		HttpSession session = req.getSession();
		CheckDAO dao = new CheckDAO(DbConnect.getConn());

		if (dao.ApplyCheck(ap)) {
			session.setAttribute("SucessMsg", "Check Apply Sucessfully");
			resp.sendRedirect("apply_check.jsp");
		} else {
			session.setAttribute("ErrorMsg", "Something wrong on server");
			resp.sendRedirect("apply_check.jsp");
		}

	}

}
