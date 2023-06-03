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
import com.entity.User;

@WebServlet("/accsearch")
public class SerchAccnt extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String accno = req.getParameter("accno");
			AdminDAOImpl dao = new AdminDAOImpl(DbConnect.getConn());
			User srchUser = dao.findByAccount(accno);
			HttpSession session = req.getSession();
			if (srchUser == null) {
				session.setAttribute("failedMsg","Account Is Not Available");
				resp.sendRedirect("admin/all_user.jsp");
			} else {
				session.setAttribute("accUser", srchUser);
				resp.sendRedirect("admin/all_user.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
