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

@WebServlet("/add_don")
public class AddDonor extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name = req.getParameter("na");
			String em = req.getParameter("em");
			String ps = req.getParameter("ps");
			String phno = req.getParameter("ph");

			Donor d = new Donor(name, em, phno, ps);
			DonorDAOImpl dao = new DonorDAOImpl(DBConnect.getConn());
			HttpSession session = req.getSession();

			if (dao.checkUser(em)) {
				boolean f = dao.addDonor(d);
				if (f) {
					session.setAttribute("succMsg", "Registartion Sucessfully");
					resp.sendRedirect("register.jsp");
				} else {
					session.setAttribute("failedMsg", "Something wrong on server");
					resp.sendRedirect("register.jsp");
				}
			} else {
				session.setAttribute("failedMsg", "User Already Exit");
				resp.sendRedirect("register.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
