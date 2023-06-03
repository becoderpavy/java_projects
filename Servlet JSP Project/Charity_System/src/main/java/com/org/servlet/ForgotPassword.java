package com.org.servlet;

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

@WebServlet("/Orgaforgot")
public class ForgotPassword extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String email = req.getParameter("email");
			String phno = req.getParameter("phno");
			String password = req.getParameter("password");
			HttpSession session = req.getSession();
			OrganizationDAOImpl dao = new OrganizationDAOImpl(DBConnect.getConn());
			if (dao.forgotPassword(email, phno, password)) {
				session.setAttribute("succMsg", "Password change sucessfully");
				resp.sendRedirect("orga_forgot.jsp");
			} else {
				session.setAttribute("failedMsg", "something wrong on server ! try again");
				resp.sendRedirect("orga_forgot.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
