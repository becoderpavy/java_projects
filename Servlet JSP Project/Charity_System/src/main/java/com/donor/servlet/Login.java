package com.donor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DonorDAOImpl;
import com.dao.OrganizationDAOImpl;
import com.db.DBConnect;
import com.entity.Donor;
import com.entity.Organization;

@WebServlet("/dlogin")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String em = req.getParameter("email");
			String ps = req.getParameter("password");

			DonorDAOImpl dao = new DonorDAOImpl(DBConnect.getConn());
			Donor d = dao.login(em, ps);

			HttpSession session = req.getSession();
			if ("admin@gmail.com".equals(em) && "admin".equals(ps)) {
				session.setAttribute("adobj", new Donor());
				resp.sendRedirect("admin/home.jsp");
			} else {
				if (d != null) {
					session.setAttribute("donobj", d);
					resp.sendRedirect("index.jsp");
				} else {
					session.setAttribute("failedMsg", "Invalid Email And Password");
					resp.sendRedirect("login.jsp");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
