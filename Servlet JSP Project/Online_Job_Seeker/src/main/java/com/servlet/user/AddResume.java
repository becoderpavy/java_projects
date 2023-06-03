package com.servlet.user;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.dao.ResumeDAO;
import com.db.DBConnect;
import com.entites.Resume;

@WebServlet("/addResume")
@MultipartConfig
public class AddResume extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String firstName = req.getParameter("firstName");
			String middleName = req.getParameter("middleName");
			String lastName = req.getParameter("lastName");
			String address = req.getParameter("address");
			String dob = req.getParameter("dob");
			String gender = req.getParameter("gender");
			String maritalStatus = req.getParameter("maritalStatus");
			String phoneNumber = req.getParameter("phoneNumber");
			String email = req.getParameter("email");
			String qualification = req.getParameter("qualification");
			String institute = req.getParameter("institute");
			String yearOfGraduation = req.getParameter("yearOfGraduation");
			String previousEmployer = req.getParameter("previousEmployer");
			String previousDesignation = req.getParameter("previousDesignation");
			String currentEmployer = req.getParameter("currentEmployer");
			String currentDesignation = req.getParameter("currentDesignation");
			String totalExperience = req.getParameter("totalExperience");
			String skill = req.getParameter("skill");
			int userId = Integer.parseInt(req.getParameter("userId"));

			Part p = req.getPart("resume");

			String resumeFileName = p.getSubmittedFileName();

			Resume r = new Resume(firstName, middleName, lastName, address, dob, gender, maritalStatus, phoneNumber,
					email, qualification, institute, yearOfGraduation, previousEmployer, previousDesignation,
					currentEmployer, currentDesignation, totalExperience, skill, userId, resumeFileName);

			ResumeDAO dao = new ResumeDAO(DBConnect.getConn());
			HttpSession session = req.getSession();

			if (dao.addResume(r)) {
				String path = req.getServletContext().getRealPath("") + "resume" + File.separator + resumeFileName;
				//System.out.println(path);
				File file = new File(path);
				p.write(path);
				session.setAttribute("succMsg", "Resume Added Sucessfully");
				resp.sendRedirect("add_resume.jsp");
			} else {
				session.setAttribute("failedMsg", "Something wrong on server");
				resp.sendRedirect("add_resume.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
