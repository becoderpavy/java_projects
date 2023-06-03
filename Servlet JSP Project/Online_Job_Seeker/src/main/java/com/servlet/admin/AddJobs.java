package com.servlet.admin;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.JobDAO;
import com.db.DBConnect;
import com.entites.Job;

@WebServlet("/addJob")
public class AddJobs extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String jobName = req.getParameter("jobName");
		String description = req.getParameter("description");
		String experience = req.getParameter("experience");
		String skill = req.getParameter("skill");
		String qualification = req.getParameter("qualification");
		String location = req.getParameter("location");
		String salary = req.getParameter("salary");
		String vacancies = req.getParameter("vacancies");
		String empName = req.getParameter("empName");
		String contactNumber = req.getParameter("contactNumber");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String publishDate = LocalDate.now() + "";

		Job j = new Job(jobName, description, experience, skill, qualification, location, salary, vacancies, empName,
				contactNumber, email, address, publishDate);

		JobDAO dao = new JobDAO(DBConnect.getConn());
		HttpSession session = req.getSession();

		if (dao.addJobs(j)) {
			session.setAttribute("succMsg", "Job Added Sucessfully");
			resp.sendRedirect("admin/add_jobs.jsp");
		} else {
			session.setAttribute("failedMsg", "Something wrong on server");
			resp.sendRedirect("admin/add_jobs.jsp");
		}

	}

}
