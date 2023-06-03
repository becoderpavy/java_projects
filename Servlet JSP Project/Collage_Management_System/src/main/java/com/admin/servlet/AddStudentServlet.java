package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.dao.StudentDAO;
import com.conn.DBConnect;
import com.entity.Student;

@WebServlet("/add_student")
public class AddStudentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			String roll=req.getParameter("roll");
			String name=req.getParameter("name");
			String gen=req.getParameter("gender");
			String dob=req.getParameter("dob");
			String add=req.getParameter("address");
			String course=req.getParameter("course");
			String sem=req.getParameter("sem");
			String em=req.getParameter("email");
			String password=req.getParameter("password");
			
			Student s=new Student(roll, name, gen, dob, add, course, sem, em, password);
			
			StudentDAO d=new StudentDAO(DBConnect.getConn());
			boolean f=d.addStudent(s);
			
			HttpSession session=req.getSession();
			if(f)
			{
				session.setAttribute("succMsg","Student Add Sucessfully");
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
