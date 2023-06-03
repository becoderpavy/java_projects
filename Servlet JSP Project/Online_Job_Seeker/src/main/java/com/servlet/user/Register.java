package com.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.db.DBConnect;
import com.entites.User;

@WebServlet("/register")
public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			String age = req.getParameter("age");
			String gender = req.getParameter("gender");
			String mobileNumber = req.getParameter("mobileNumber");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String address = req.getParameter("address");

			User user = new User(firstName, lastName, age, gender, mobileNumber, email, password, address);

			UserDAO dao = new UserDAO(DBConnect.getConn());
			
			HttpSession session = req.getSession();

			if (dao.checkEmail(email)) {
				
				
				if (dao.registerUser(user)) {
					session.setAttribute("succMsg", "Register Sucessfully");
					resp.sendRedirect("register.jsp");
				} else {
					session.setAttribute("failedMsg", "Something wrong on server");
					resp.sendRedirect("register.jsp");
				}
		
			
			
			} else {
				session.setAttribute("failedMsg", "email id alreday exist");
				resp.sendRedirect("register.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
