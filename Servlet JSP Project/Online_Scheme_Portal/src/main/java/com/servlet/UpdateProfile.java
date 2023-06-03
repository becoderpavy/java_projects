package com.servlet;

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

@WebServlet("/updateprofile")
public class UpdateProfile extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String fn = req.getParameter("fullname");
			String em = req.getParameter("email");
			String mb = req.getParameter("mobno");
			String ad = req.getParameter("address");
			String ci = req.getParameter("city");
			String st = req.getParameter("state");
			String pin = req.getParameter("pincode");
			int id = Integer.parseInt(req.getParameter("id"));

			User user = new User(fn, em, mb, "", ad, ci, st, pin);
			user.setId(id);

			UserDAO dao = new UserDAO(DBConnect.getConnection());
			HttpSession session = req.getSession();

			if (dao.updateUser(user)) {
				User user1 = dao.getUser(id);
				session.setAttribute("userObj", user1);
				session.setAttribute("succMsgp", "Profile Update successfully");
				resp.sendRedirect("edit_profile.jsp");
			} else {
				session.setAttribute("errorMsgp", "something wrong on server");
				resp.sendRedirect("edit_profile.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
