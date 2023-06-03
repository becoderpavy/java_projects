package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAOImpl;
import com.conn.ConnectionProvider;
import com.entity.userDtls;

@WebServlet("/editProfile")
public class editProfile extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String phno = req.getParameter("phno");
			String password = req.getParameter("password");

			userDtls us = new userDtls();
			us.setId(id);
			us.setName(name);
			us.setEmail(email);
			us.setPhno(phno);
			us.setPassword(password);

			HttpSession session = req.getSession();
			UserDAOImpl dao=new UserDAOImpl(ConnectionProvider.getConnection());
			boolean f=dao.editProfile(us);
				if (f) {
					session.setAttribute("updateSucessMsg", "Profile Update Sucessfully..Login Again");
					session.setMaxInactiveInterval(1000);
					resp.sendRedirect("login.jsp");
				} else {
					session.setAttribute("errorMsg", "Your Password Wrong..");
					resp.sendRedirect("edit_profile.jsp");
				}

			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
