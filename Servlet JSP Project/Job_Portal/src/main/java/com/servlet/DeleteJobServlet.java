package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.JobDAO;

@WebServlet("/delete")
public class DeleteJobServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(req.getParameter("id"));
			JobDAO dao=new JobDAO(DBConnect.getConn());
			boolean f=dao.deleteJob(id);
			
			HttpSession session = req.getSession();
			if (f) {
				session.setAttribute("succMsg", "Job Delete Sucessfully");
				resp.sendRedirect("view_jobs.jsp");
			} else {
				session.setAttribute("succMsg", "Something error in server");
				resp.sendRedirect("view_jobs.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
