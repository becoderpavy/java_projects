package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.dao.AttendanceDAO;
import com.conn.DBConnect;
import com.entity.Attendance;

@WebServlet("/update_attend")
public class UpdateAttendServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int sid = Integer.parseInt(req.getParameter("sid"));
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("sname");
			String course = req.getParameter("course");
			String sem = req.getParameter("sem");
			String year = req.getParameter("year");
			String month = req.getParameter("month");
			String days = req.getParameter("days");

			Attendance a = new Attendance();
			a.setId(id);
			a.setName(name);
			a.setCourse(course);
			a.setSemestar(sem);
			a.setYear(year);
			a.setMonth(month);
			a.setDays(days);

			AttendanceDAO dao = new AttendanceDAO(DBConnect.getConn());
			boolean f = dao.updateAttadence(a);
			HttpSession session = req.getSession();
			if (f) {
				session.setAttribute("succMsg", "Attendance Update Sucessfully");
				resp.sendRedirect("admin/view_attend.jsp?id=" + sid);
			} else {
				session.setAttribute("succMsg", "Something wrong on server");
				resp.sendRedirect("admin/view_attend.jsp?id=" + id);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
