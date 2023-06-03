package com.staff.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.dao.StudentDAO;
import com.conn.DBConnect;
import com.entity.Student;

@WebServlet("/tserch_student")
public class SerchStudentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String course = req.getParameter("course");
			String sem = req.getParameter("semestar");
			String viewtype = req.getParameter("viewtype");

			if (course != null && sem != null && viewtype != null) {
				resp.sendRedirect("teacher/view_student.jsp?co=" + course + "&&sem=" + sem + "&&type=" + viewtype);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
