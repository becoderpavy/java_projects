package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.dao.CourseDAO;
import com.conn.DBConnect;

@WebServlet("/add_course")
public class CourseAddServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String course=req.getParameter("course");
			CourseDAO dao=new CourseDAO(DBConnect.getConn());
			boolean f=dao.addCourse(course);
			HttpSession session=req.getSession();
			if(f)
			{
				session.setAttribute("succMsg","Course Add Sucessfully");
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
