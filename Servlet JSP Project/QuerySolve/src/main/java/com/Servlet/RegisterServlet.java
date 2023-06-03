package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.Db.DBConnect;
import com.entity.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String cid = request.getParameter("cid");
		String category = request.getParameter("category");
		String password = request.getParameter("password");

		User u = new User(name, email, gender, cid, category, password);
		UserDAO dao = new UserDAO(DBConnect.getConn());
		boolean f = dao.addUser(u);
		HttpSession session = request.getSession();

		if (f) {
			session.setAttribute("succMsg", "Registration Sucessfully");
			response.sendRedirect("register.jsp");

		} else {
			session.setAttribute("failedMsg", "Something went wrong on server");
			response.sendRedirect("register.jsp");
		}

	}

}
