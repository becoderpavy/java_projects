package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.PatientDAO;
import com.dao.PatientDAOImpl;
import com.db.DBConnect;

@WebServlet("/approve")
public class PatientStatus extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String ty = req.getParameter("ty");
			int id = Integer.parseInt(req.getParameter("id"));
			HttpSession session = req.getSession();
			PatientDAO dao = new PatientDAOImpl(DBConnect.getConn());
			boolean f;
			if ("ap".equals(ty)) {
				f = dao.updatePatient("Approved", id);

				if (f) {
					session.setAttribute("succMsg", "User Approved Sucessfully");
					resp.sendRedirect("admin/help_seeker.jsp");
				} else {
					session.setAttribute("failedMsg", "Something wrong on server");
					resp.sendRedirect("ngo/add_user.jsp");
				}

			} else if ("re".equals(ty)) {
				f = dao.updatePatient("Rejected", id);
				if (f) {
					session.setAttribute("failedMsg", "User Rejected Sucessfully");
					resp.sendRedirect("admin/help_seeker.jsp");
				} else {
					session.setAttribute("failedMsg", "Something wrong on server");
					resp.sendRedirect("ngo/add_user.jsp");
				}
			} else {
				f = dao.deletePatient(id);
				if (f) {
					session.setAttribute("succMsg", "User Delete Sucessfully");
					resp.sendRedirect("admin/help_seeker.jsp");
				} else {
					session.setAttribute("failedMsg", "Something wrong on server");
					resp.sendRedirect("ngo/add_user.jsp");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
