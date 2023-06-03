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

@WebServlet("/addOrphanage")
public class AddOrphanage extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String orgName = req.getParameter("on");
			String add = req.getParameter("ad");
			String em = req.getParameter("em");
			String phno = req.getParameter("ph");
			String ps = req.getParameter("psw");
			String st = "Approved";

			Orphanage o = new Orphanage(orgName, add, em, phno, ps, st);
			OrphanageDAO dao = new OrphanageDAO(DBConnect.getConn());
			HttpSession session = req.getSession();

			if (dao.checkUser(em)) {
				boolean f = dao.addOrg(o);
				if (f) {
					session.setAttribute("succMsg", "Registartion Sucessfully");
					resp.sendRedirect("orphans_register.jsp");
				} else {
					session.setAttribute("failedMsg", "Something wrong on server");
					resp.sendRedirect("orphans_register.jsp");
				}
			} else {
				session.setAttribute("failedMsg", "User Already Exit");
				resp.sendRedirect("orphans_register.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
