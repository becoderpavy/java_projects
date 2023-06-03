package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emp.dao.UserDAO;
import com.emp.db.DBConnect;
import com.emp.entity.UserDtls;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String un = req.getParameter("un");
			String ps = req.getParameter("ps");
			HttpSession session = req.getSession();
			if ("admin".equals(un) && "admin".equals(ps)) {
				session.setAttribute("userobj", new UserDtls());
				resp.sendRedirect("admin/admin_home.jsp");

			} else {
				UserDAO dao = new UserDAO(DBConnect.getConnection());
				UserDtls u = dao.login(un, ps);
				boolean st = dao.checkStatus(un);
				if (u != null) {
					if (st) {
						session.setAttribute("userobj", u);
						resp.sendRedirect("home.jsp");
					} else {
						session.setAttribute("failedmsg", "Your Userid Is Inactive");
						resp.sendRedirect("index.jsp");
					}
				} else {
					session.setAttribute("failedmsg", "Invalid userid or password");
					resp.sendRedirect("index.jsp");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
