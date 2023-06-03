package com.staff.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.dao.StudentDAO;
import com.conn.DBConnect;

@WebServlet("/tdelete_student")
public class DeleteStudentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String course = req.getParameter("co");
			String sem = req.getParameter("sem");
			
			StudentDAO dao = new StudentDAO(DBConnect.getConn());
			boolean f = dao.deleteStudent(id);
			HttpSession session = req.getSession();
			if (f) {
				session.setAttribute("succMsg", "Student Delete Sucessfully");
				resp.sendRedirect("teacher/view_student.jsp?co="+course+"&&sem="+sem+"&&type="+"view");
			} else {
				session.setAttribute("succMsg", "Something wrong on server");
				resp.sendRedirect("teacher/view_student.jsp?co="+course+"&&sem="+sem+"&&type="+"view");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
