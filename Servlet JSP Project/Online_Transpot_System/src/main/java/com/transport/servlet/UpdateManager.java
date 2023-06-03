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

@WebServlet("/updateManager")
public class UpdateManager extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String fullName = req.getParameter("fullName");
			String userName = req.getParameter("userName");
			String email = req.getParameter("email");
			String location = req.getParameter("location");
			int id = Integer.parseInt(req.getParameter("id"));

			User user = new User(id,fullName, userName, email, "", location, "");

			UserDAO dao = new UserDAO(DbConnect.getConnection());

			HttpSession session = req.getSession();

			boolean f = dao.updateUser(user);
			//System.out.println(f);
			if (f) {
				session.setAttribute("succMsg", "Update Success");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
			}

			resp.sendRedirect("admin/view_manager.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
