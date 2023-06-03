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
import com.entity.Professor;

@WebServlet("/updateprof")
public class UpdateProf extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			int id=Integer.parseInt(req.getParameter("id"));
			String na=req.getParameter("na");
			String de=req.getParameter("de");
			String em=req.getParameter("em");
			String ps=req.getParameter("ps");
			
			Professor p=new Professor(id,na, de, "", em, ps);
			
			ProfessorDao dao=new ProfessorDao(DbConnect.getConn());
			boolean f=dao.updateProfessor(p);
			HttpSession session = req.getSession();
			// redirect page
			if (f) {
				session.setAttribute("succMsg", "Professor Details Update Sucessfully");
				resp.sendRedirect("admin/edit_prof.jsp?id="+id);
			} else {
				session.setAttribute("errorMsg", "Something Went Wrong on Server");
				resp.sendRedirect("admin/edit_prof.jsp?id="+id);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
