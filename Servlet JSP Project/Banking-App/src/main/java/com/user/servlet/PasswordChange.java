package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAOImpl;
import com.db.DbConnect;

@WebServlet("/changepassword")
public class PasswordChange extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String oldPwd = req.getParameter("oldPwd");
			String newPwd = req.getParameter("psw");
			String accno = req.getParameter("accno");
			//System.out.println(oldPwd + " " + newPwd + " " + accno);

			UserDAOImpl dao = new UserDAOImpl(DbConnect.getConn());
			boolean f = dao.updatePassword(accno, oldPwd, newPwd);
			HttpSession session = req.getSession();
			if (f) {
				session.setAttribute("sucessmsg", "Password Change Sucessfully..");
				resp.sendRedirect("chngpswd.jsp");
			} else {
				session.setAttribute("failedmsg", "Old Password not correct..");
				resp.sendRedirect("chngpswd.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
