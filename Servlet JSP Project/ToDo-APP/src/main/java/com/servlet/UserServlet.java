package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.DB.DBConnect;
import com.entity.UserDetails;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("fname");
		String email = request.getParameter("uemail");
		String password = request.getParameter("upassword");
		String mobno = request.getParameter("mobno");

		UserDetails us = new UserDetails();
		us.setName(name);
		us.setEmail(email);
		us.setPassword(password);
		us.setMobNo(mobno);

		UserDAO dao = new UserDAO(DBConnect.getConn());

		HttpSession session = request.getSession();

		if (dao.checkEmail(email)) {
			boolean f = dao.addUser(us);
			if (f) {
				session.setAttribute("reg-sucess", "Registration Sucessfully..");
				response.sendRedirect("register.jsp");
			} else {
				session.setAttribute("failed-msg", "Something went wrong on server");
				response.sendRedirect("register.jsp");
			}
		} else {
			session.setAttribute("failed-msg", "email id already exist");
			response.sendRedirect("register.jsp");
		}

	}
}
