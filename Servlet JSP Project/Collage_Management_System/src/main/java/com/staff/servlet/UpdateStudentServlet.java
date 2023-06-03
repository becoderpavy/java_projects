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
import com.entity.Student;

@WebServlet("/tupdate_student")
public class UpdateStudentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(req.getParameter("id"));
			String roll = req.getParameter("roll");
			String name = req.getParameter("name");
			String gen = req.getParameter("gender");
			String dob = req.getParameter("dob");
			String add = req.getParameter("address");
			String course = req.getParameter("course");
			String sem = req.getParameter("sem");
			String em = req.getParameter("email");
			String password = req.getParameter("password");

			Student s = new Student(id,roll, name, gen, dob, add, course, sem, em, password);
			//System.out.println(s);

			StudentDAO d = new StudentDAO(DBConnect.getConn());
			boolean f = d.updateStudent(s);

			HttpSession session = req.getSession();
			if (f) {
				session.setAttribute("succMsg", "Student Update Sucessfully");
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
