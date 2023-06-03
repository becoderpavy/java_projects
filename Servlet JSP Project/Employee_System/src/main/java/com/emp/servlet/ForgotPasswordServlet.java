package com.emp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emp.dao.UserDAO;
import com.emp.db.DBConnect;

@WebServlet("/getpass")
public class ForgotPasswordServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String un=req.getParameter("un");
			String em=req.getParameter("em");
			HttpSession session = req.getSession();
			UserDAO dao=new UserDAO(DBConnect.getConnection());
			String psw=dao.forgotPassword(un, em);
			if (psw!=null) {
				session.setAttribute("succMsg", psw);
				resp.sendRedirect("forgot_password.jsp");
			} else {
				session.setAttribute("failedMsg", "Invalid Username and Email");
				resp.sendRedirect("forgot_password.jsp");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
