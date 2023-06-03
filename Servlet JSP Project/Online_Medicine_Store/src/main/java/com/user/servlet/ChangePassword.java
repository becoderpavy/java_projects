package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.entity.User;
import com.util.DBConnect;

@WebServlet("/chngps")
public class ChangePassword extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String newPass = req.getParameter("newpassword");
			String oldPass = req.getParameter("oldpassword");
			int id = Integer.parseInt(req.getParameter("id"));

			UserDAO dao = new UserDAO(DBConnect.getConnection());
			HttpSession session = req.getSession();

			if (dao.checkOldPasssword(id, oldPass)) {
				if (dao.updateNewPasssword(id, newPass)) {
					User user1 = dao.getUser(id);
					session.setAttribute("userObj", user1);
					session.setAttribute("succMsg", "Password change successfully");
					resp.sendRedirect("edit_profile.jsp");
				} else {
					session.setAttribute("errorMsg", "something wrong on server");
					resp.sendRedirect("edit_profile.jsp");
				}
			} else {
				session.setAttribute("errorMsg", "wrong old password");
				resp.sendRedirect("edit_profile.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
