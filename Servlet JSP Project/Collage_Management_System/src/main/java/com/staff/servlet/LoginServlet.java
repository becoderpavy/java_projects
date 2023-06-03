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

@WebServlet("/staff_login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String email = req.getParameter("email");
			String password = req.getParameter("password");
			HttpSession session = req.getSession();

			TeacherDAO dao = new TeacherDAO(DBConnect.getConn());
			Teacher t = dao.tlogin(email, password);

			if (t != null) {
				session.setAttribute("tobj", t);
				resp.sendRedirect("teacher/home.jsp");
			} else {
				session.setAttribute("failedMsg", "Invalid Email & Password");
				resp.sendRedirect("tlogin.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
