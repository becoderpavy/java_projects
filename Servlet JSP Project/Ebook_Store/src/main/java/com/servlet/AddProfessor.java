package com.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ProfessorDao;
import com.db.DbConnect;
import com.entity.Professor;

@WebServlet("/addprofessor")
public class AddProfessor extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String na=req.getParameter("na");
			String de=req.getParameter("de");
			String em=req.getParameter("em");
			String ps=req.getParameter("ps");
			
			Professor p=new Professor(na, de,"", em, ps);
			
			ProfessorDao dao=new ProfessorDao(DbConnect.getConn());
			HttpSession session = req.getSession();
			boolean f2=dao.checkEmail(em);
			
			if(f2)
			{
				boolean f=dao.addProfessor(p);
				if (f) {
					session.setAttribute("succMsg", "Professor Register Sucessfully");
					resp.sendRedirect("admin/add_professor.jsp");
				} else {
					session.setAttribute("errorMsg", "Something Went Wrong on Server");
					resp.sendRedirect("admin/add_professor.jsp");
				}
			}else {
				session.setAttribute("errorMsg", "Professor Email Already Exist");
				resp.sendRedirect("admin/add_professor.jsp");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
