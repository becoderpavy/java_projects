package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.dao.TeacherDAO;
import com.conn.DBConnect;

@WebServlet("/delete_teacher")
public class DeleteTeacherServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			
			int id=Integer.parseInt(req.getParameter("id"));
			TeacherDAO dao=new TeacherDAO(DBConnect.getConn());
			boolean f=dao.deleteTeacher(id);
			HttpSession session = req.getSession();
			if (f) {
				session.setAttribute("succMsg", "Teacher Details Delete Sucessfully");
				resp.sendRedirect("admin/teacher.jsp");
			} else {
				session.setAttribute("succMsg", "Something wrong on server");
				resp.sendRedirect("admin/teacher.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
