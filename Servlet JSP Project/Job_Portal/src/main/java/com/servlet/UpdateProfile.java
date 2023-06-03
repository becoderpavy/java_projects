package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.UserDAO;
import com.entity.User;

@WebServlet("/update_profile")
public class UpdateProfile extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String qua = req.getParameter("qua");
			String email = req.getParameter("email");
			String ps = req.getParameter("ps");
	

			UserDAO dao = new UserDAO(DBConnect.getConn());

			User u = new User(id, name, email, ps, qua);
			boolean f = dao.updateUser(u);
			HttpSession session = req.getSession();
			if (f) {
				session.setAttribute("userobj", dao.getUserById(id));
				session.setAttribute("succMsg", "Profile Update Sucessfully");
				resp.sendRedirect("user_view.jsp");
			} else {
				session.setAttribute("succMsg", "Something wrong on server");
				resp.sendRedirect("user_view.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
