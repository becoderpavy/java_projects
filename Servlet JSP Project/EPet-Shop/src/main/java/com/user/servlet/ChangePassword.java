package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAOImpl;
import com.DB.DBConnect;

@WebServlet("/change_password")
public class ChangePassword extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String op = req.getParameter("op");
			String np = req.getParameter("np");
			HttpSession session = req.getSession();
			UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());
			boolean f = dao.checkPassword(id, op);
			if (f) {
				boolean f2 = dao.passwordChange(id, np);
				if (f2) {
					session.setAttribute("succMsg", "Password Change Sucessfully.");
					resp.sendRedirect("change_password.jsp");
				} else {
					session.setAttribute("failedMsg", "Something wrong on server");
					resp.sendRedirect("change_password.jsp");
				}

			} else {
				session.setAttribute("failedMsg", "Your old Password is Incorrect");
				resp.sendRedirect("change_password.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
