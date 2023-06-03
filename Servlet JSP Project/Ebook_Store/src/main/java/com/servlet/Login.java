package com.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ProfessorDao;
import com.db.DbConnect;
import com.entity.Professor;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String em = req.getParameter("em");
			String ps = req.getParameter("ps");

			HttpSession session = req.getSession();

			if ("admin@gmail.com".equals(em) && "admin@121".equals(ps)) {

				session.setAttribute("userobj", new Professor());
				resp.sendRedirect("admin/home.jsp");

			} else {
				ProfessorDao dao = new ProfessorDao(DbConnect.getConn());
				Professor p = dao.login(em, ps);

				if (p != null) {
					session.setAttribute("userobj", p);
					resp.sendRedirect("home.jsp");
				} else {
					session.setAttribute("errorMsg", "Invalid Email & Password");
					resp.sendRedirect("index.jsp");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
