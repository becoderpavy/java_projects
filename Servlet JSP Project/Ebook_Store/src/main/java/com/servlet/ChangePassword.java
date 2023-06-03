package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ProfessorDao;
import com.db.DbConnect;

@WebServlet("/chngpass")
public class ChangePassword extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			int id=Integer.parseInt(req.getParameter("id"));
			String op=req.getParameter("op");
			String np=req.getParameter("np");
			
			ProfessorDao dao=new ProfessorDao(DbConnect.getConn());
			HttpSession session=req.getSession();
			boolean f=dao.checkPassword(id, op);
			if(f)
			{
				boolean f2=dao.changePassword(id, np);
				if(f2)
				{
					session.setAttribute("succMsg", "Password Change Sucessfully");
					resp.sendRedirect("change_password.jsp");
				}else {
					session.setAttribute("errorMsg", "Something wrong on server");
					resp.sendRedirect("change_password.jsp");
				}
				
			}else {
				session.setAttribute("errorMsg", "Old Password Incorrect");
				resp.sendRedirect("change_password.jsp");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
