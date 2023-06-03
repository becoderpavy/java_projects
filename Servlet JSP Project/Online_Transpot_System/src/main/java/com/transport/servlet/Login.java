package com.transport.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.transport.conn.DbConnect;
import com.transport.dao.UserDAO;
import com.transport.entites.User;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userName = req.getParameter("userName");
		String password = req.getParameter("password");

		UserDAO dao = new UserDAO(DbConnect.getConnection());

		HttpSession session = req.getSession();

		User user = dao.login(userName, password);
		
		System.out.println(user);
		
		if(user!=null)
		{
			if ("user".equals(user.getRole())) {
				session.setAttribute("userObj", user);
				resp.sendRedirect("user/index.jsp");
			}

			else if ("manager".equals(user.getRole())) {
				session.setAttribute("managerObj", user);
				resp.sendRedirect("manager/index.jsp");
			}

			else {
				session.setAttribute("adminObj", user);
				resp.sendRedirect("admin/index.jsp");

			}
		}
		
		else {
			session.setAttribute("errorMsg", "invalid username or password");
			resp.sendRedirect("login.jsp");
		}
		
		
		

	}

}
