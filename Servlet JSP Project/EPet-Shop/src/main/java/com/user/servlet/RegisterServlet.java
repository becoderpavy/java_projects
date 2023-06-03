
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
import com.entity.UserDtls;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String na = req.getParameter("na");
			String em = req.getParameter("em");
			String phno = req.getParameter("phno");
			String pwd = req.getParameter("pwd");
			String st = "Active";
			String role = "user";

			// System.out.println(name+" "+email+" "+phno+" "+password+" "+check);

			UserDtls us = new UserDtls(na, em, phno, pwd, st, role);

			HttpSession session = req.getSession();

			UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());

			boolean f2 = dao.checkUser(em);
			
			if (f2) {

				boolean f = dao.userRegister(us);

				if (f) { // System.out.println("User Register Success..");

					session.setAttribute("succMsg", "Registration Successfully..");
					resp.sendRedirect("register.jsp");

				} else { // System.out.println("Something wrong on server..");
					session.setAttribute("failedMsg", "Something wrong on server..");
					resp.sendRedirect("register.jsp");
				}

			} else {
				session.setAttribute("failedMsg", "User Already Exist Try Another Email id");
				resp.sendRedirect("register.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
