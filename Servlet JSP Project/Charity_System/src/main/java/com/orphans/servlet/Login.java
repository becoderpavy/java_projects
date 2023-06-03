package com.orphans.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.OrganizationDAOImpl;
import com.dao.OrphanageDAO;
import com.db.DBConnect;
import com.entity.Organization;
import com.entity.Orphanage;
import com.entity.Orphans;

@WebServlet("/orphanLogin")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String em = req.getParameter("email");
			String ps = req.getParameter("password");

			OrphanageDAO dao = new OrphanageDAO(DBConnect.getConn());
			Orphanage o = dao.login(em, ps);  

			HttpSession session = req.getSession();

			
				if (o != null) {
					session.setAttribute("orphanObj", o);
					resp.sendRedirect("orphange/home.jsp");
				} else {
					session.setAttribute("failedMsg", "Invalid Email And Password");
					resp.sendRedirect("orphans_login.jsp");
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
