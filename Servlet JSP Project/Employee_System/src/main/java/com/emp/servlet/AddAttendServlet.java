package com.emp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emp.dao.AttendanceDAO;
import com.emp.db.DBConnect;
import com.emp.entity.Attendance;

@WebServlet("/add_attendance")
public class AddAttendServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String an = req.getParameter("an");
			String da = req.getParameter("da");
			String ho = req.getParameter("ho");
			String mi = req.getParameter("mi");
			String re = req.getParameter("re");
			String na = req.getParameter("na");

			int uid = Integer.parseInt(req.getParameter("uid"));
			String st = "Pending";

			Attendance a = new Attendance(an, da, ho, mi, re, na, uid, st);

			HttpSession session = req.getSession();

			AttendanceDAO dao = new AttendanceDAO(DBConnect.getConnection());
			boolean f = dao.attendance(a);

			if (f) {
				session.setAttribute("succMsg", "Attendance Apply Sucessfully.. Wait for Approval");
				resp.sendRedirect("timesheet.jsp");
			} else {		
				session.setAttribute("failedMsg", "Something error in server");
				resp.sendRedirect("timesheet.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
