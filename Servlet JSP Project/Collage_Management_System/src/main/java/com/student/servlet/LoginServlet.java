package com.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.dao.StudentDAO;
import com.admin.dao.TeacherDAO;
import com.conn.DBConnect;
import com.entity.Student;
import com.entity.Teacher;

@WebServlet("/student_login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String email = req.getParameter("email");
			String password = req.getParameter("password");
			HttpSession session = req.getSession();

			StudentDAO dao = new StudentDAO(DBConnect.getConn());
			Student stu = dao.slogin(email, password);

			if (stu != null) {
				session.setAttribute("sobj", stu);
				resp.sendRedirect("student/home.jsp");
			} else {
				session.setAttribute("failedMsg", "Invalid Email & Password");
				resp.sendRedirect("slogin.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
