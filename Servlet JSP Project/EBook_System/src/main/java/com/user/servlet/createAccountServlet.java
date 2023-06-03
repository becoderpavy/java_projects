package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.DAO.UserDAOImpl;
import com.conn.ConnectionProvider;
import com.entity.userDtls;

@WebServlet("/createAcntServlet")
public class createAccountServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String phno = req.getParameter("phno");
			String password = req.getParameter("password");
			String check = req.getParameter("check");

			userDtls us = new userDtls(name, email, phno, password, "", "", "", "", "");

			if (check != null) {
				HttpSession session = req.getSession();
				UserDAOImpl dao = new UserDAOImpl(ConnectionProvider.getConnection());
				boolean f = dao.createAccount(us);
				if (f) {
					session.setAttribute("sucessMsg", "Account Create Sucessfully..");
					resp.sendRedirect("create_account.jsp");
				} else {
					session.setAttribute("errorMsg", "Something Went Wrong on Server..");
					resp.sendRedirect("create_account.jsp");
				}

			} else {
				HttpSession session = req.getSession();
				session.setAttribute("errorMsg", "Please Agree Tearms and Conditions..");
				resp.sendRedirect("create_account.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
