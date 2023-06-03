package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.OrphansDAO;
import com.db.DBConnect;

@WebServlet("/Oapprove")
public class OrphanStatus extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String ty = req.getParameter("ty");
			int id = Integer.parseInt(req.getParameter("id"));
			HttpSession session = req.getSession();
			OrphansDAO dao = new OrphansDAO(DBConnect.getConn());
			boolean f;
			if ("ap".equals(ty)) {
				f = dao.updatePatient("Approved", id);

				if (f) {
					session.setAttribute("succMsg", "Orphans Approved Sucessfully");
					resp.sendRedirect("admin/orphans.jsp");
				} else {
					session.setAttribute("failedMsg", "Something wrong on server");
					resp.sendRedirect("admin/view_orphans.jsp");
				}

			} else if ("re".equals(ty)) {
				f = dao.updatePatient("Rejected", id);
				if (f) {
					session.setAttribute("failedMsg", "Orphans Rejected Sucessfully");
					resp.sendRedirect("admin/orphans.jsp");
				} else {
					session.setAttribute("failedMsg", "Something wrong on server");
					resp.sendRedirect("admin/orphans.jsp");
				}
			} else {
				f = dao.deletePatient(id);
				if (f) {
					session.setAttribute("succMsg", "Orphans Delete Sucessfully");
					resp.sendRedirect("admin/orphans.jsp");
				} else {
					session.setAttribute("failedMsg", "Something wrong on server");
					resp.sendRedirect("admin/orphans.jsp");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
