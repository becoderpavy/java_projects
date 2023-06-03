package com.staff.servlet;

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

@WebServlet("/tattend")
public class AttendanceServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int sid=Integer.parseInt(req.getParameter("sid"));
			String name=req.getParameter("sname");
			String course=req.getParameter("course");
			String sem=req.getParameter("sem");
			String year=req.getParameter("year");
			String month=req.getParameter("month");
			String days=req.getParameter("days");
			
			Attendance a=new Attendance(sid,name, course, sem, year, month, days);
			
			AttendanceDAO dao=new AttendanceDAO(DBConnect.getConn());
			boolean f=dao.addAttend(a);
			HttpSession session=req.getSession();
			if (f) {
				session.setAttribute("succMsg", "Attendance Take Sucessfully");
				resp.sendRedirect("teacher/view_student.jsp?co="+course+"&&sem="+sem+"&&type="+"attend");
			} else {
				session.setAttribute("succMsg", "Something wrong on server");
				resp.sendRedirect("teacher/view_student.jsp?co="+course+"&&sem="+sem+"&&type="+"attend");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
