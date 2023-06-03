package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDAOImpl;
import com.dao.UserDAOImpl;
import com.db.DbConnect;
import com.entity.User;

@WebServlet("/view")
public class ViewAccnt extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String accno = req.getParameter("accno");

			AdminDAOImpl dao = new AdminDAOImpl(DbConnect.getConn());
			UserDAOImpl dao2=new UserDAOImpl(DbConnect.getConn());
			Double b=dao2.checkBalance(accno);
			
			User us = dao.getUserByAccont(accno);

			HttpSession session=req.getSession();
			
			if (us != null) {
				session.setAttribute("user", us);
				session.setAttribute("bal",b );
				resp.sendRedirect("admin/view_profile.jsp");
			} 

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
