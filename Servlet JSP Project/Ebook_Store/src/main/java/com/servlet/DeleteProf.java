package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BookDao;
import com.dao.ProfessorDao;
import com.db.DbConnect;

@WebServlet("/deleteprof")
public class DeleteProf extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {

			int id = Integer.parseInt(req.getParameter("id"));
			ProfessorDao dao = new ProfessorDao(DbConnect.getConn());
			Boolean f = dao.delteProf(id);

			HttpSession session = req.getSession();

			if (f) {

				session.setAttribute("succMsg", "Professor Details Delete Sucessfully");
				resp.sendRedirect("admin/professor.jsp");
			} else {
				session.setAttribute("errorMsg", "Something Went Wrong on Server");
				resp.sendRedirect("admin/professor.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}
