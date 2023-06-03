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

@WebServlet("/changepassword")
public class ChangePasswordServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			String op=req.getParameter("op");
			String np=req.getParameter("np");
			int uid=Integer.parseInt(req.getParameter("uid"));
			
			UserDAO d=new UserDAO(DBConnect.getConnection());
			boolean f=d.changeOldPassword(uid, op);
			HttpSession session = req.getSession();
			if(f)
			{
				boolean f2=d.changePassword(uid, np);
				if(f2)
				{
					session.setAttribute("succMsg", "Password Changes Successfully..");
					resp.sendRedirect("change_password.jsp");
				}else {
					session.setAttribute("failedMsg", "Something error in server");
					resp.sendRedirect("change_password.jsp");
				}	
			}else {
				session.setAttribute("failedMsg", "Your Old Password is incorrect");
				resp.sendRedirect("change_password.jsp");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
