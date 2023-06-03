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
import com.entity.Jobs;

@WebServlet("/addJob")
public class AddJobsServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String title=req.getParameter("title");
			String location=req.getParameter("location");		
			String category=req.getParameter("category");
			String status=req.getParameter("status");
			String desc=req.getParameter("desc");
			
			Jobs j=new Jobs(title, desc, category, status, location);
			
			JobDAO dao=new JobDAO(DBConnect.getConn());
			
			boolean f=dao.addJobs(j);
			
			HttpSession session=req.getSession();
			if(f)
			{
				session.setAttribute("succMsg", "Job Added Sucessfully");
				resp.sendRedirect("add_job.jsp");
			}else {
				session.setAttribute("succMsg", "Something error in server");
				resp.sendRedirect("add_job.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
