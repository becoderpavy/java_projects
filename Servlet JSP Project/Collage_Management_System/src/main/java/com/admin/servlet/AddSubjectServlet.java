package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.dao.SubjectDAO;
import com.conn.DBConnect;

@WebServlet("/add_subject")
public class AddSubjectServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			                                                                                                                                                                               
			String c=req.getParameter("course");
			String sem=req.getParameter("sem");
			String s=req.getParameter("subject");
			
			SubjectDAO dao=new SubjectDAO(DBConnect.getConn());
			boolean f=dao.addSubject(c, sem, s);			
			HttpSession session=req.getSession();
			if(f)
			{
				session.setAttribute("succMsg","Subject Add Sucessfully");
				resp.sendRedirect("admin/add_info.jsp");
			}else {
				session.setAttribute("succMsg", "Something wrong on server");
				resp.sendRedirect("admin/add_info.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
