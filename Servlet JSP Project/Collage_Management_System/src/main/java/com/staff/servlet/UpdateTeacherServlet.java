package com.staff.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.dao.TeacherDAO;
import com.conn.DBConnect;
import com.entity.Teacher;

@WebServlet("/tupdate_teacher")
public class UpdateTeacherServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String n = req.getParameter("name");
			String g = req.getParameter("gender");
			String d = req.getParameter("dob");
			String q = req.getParameter("qua");
			String e = req.getParameter("email");
			String p = req.getParameter("password");

			Teacher t = new Teacher(id, n, g, d, q, e, p);

			TeacherDAO dao = new TeacherDAO(DBConnect.getConn());
			boolean f = dao.updateTeacher(t);

			HttpSession session = req.getSession();
			if (f) {
				session.setAttribute("succMsg", "Teacher Details Update Sucessfully");
				resp.sendRedirect("teacher/home.jsp");
			} else {
				session.setAttribute("succMsg", "Something wrong on server");
				resp.sendRedirect("teacher/home.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
