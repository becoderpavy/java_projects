package com.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.DBConnect;
import com.entites.User;

@WebServlet("/register")
public class RegisterUser extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		String city = req.getParameter("city");
		String state = req.getParameter("state");
		String pincode = req.getParameter("pincode");
		String role = req.getParameter("role");
		String mobno = req.getParameter("mobno");

		User user = new User(name, email, password, address, city, state, pincode, role,mobno);

		UserDao dao = new UserDao(DBConnect.getConnection());

		HttpSession session = req.getSession();

		if (dao.checkEmail(email)) {
			session.setAttribute("errorMsg", "Email id already exists");
			resp.sendRedirect("signup.jsp");
		}

		else if (dao.createUser(user)) {
			session.setAttribute("succMsg", "Register Sucessfully");
			resp.sendRedirect("signup.jsp");
		}

		else {
			session.setAttribute("errorMsg", "Something wrong on server");
			resp.sendRedirect("signup.jsp");
		}

	}

}
