package com.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.dao.*;
import com.db.DBConnect;
import com.entites.*;

@WebServlet("/registerUser")
public class RegisterUser extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String fn = req.getParameter("fullname");
			String em = req.getParameter("email");
			String mb = req.getParameter("mobno");
			String ps = req.getParameter("password");
			String ad = req.getParameter("address");
			String ci = req.getParameter("city");
			String st = req.getParameter("state");
			String pin = req.getParameter("pincode");

			User user = new User(fn, em, mb, ps, ad, ci, st, pin);
			System.out.println(user);

			UserDAO dao = new UserDAO(DBConnect.getConn());
			HttpSession session = req.getSession();

			if (dao.checkEmail(em)) {

				if (dao.addUser(user)) {
					session.setAttribute("succMsg", "Register successfully");
					resp.sendRedirect("signup.jsp");
				} else {
					session.setAttribute("errorMsg", "something wrong on server");
					resp.sendRedirect("signup.jsp");
				}

			} else {
				session.setAttribute("errorMsg", "Email id already exist");
				resp.sendRedirect("signup.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
