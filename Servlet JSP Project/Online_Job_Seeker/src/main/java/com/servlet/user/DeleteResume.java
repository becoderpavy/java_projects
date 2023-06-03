package com.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ResumeDAO;
import com.db.DBConnect;

@WebServlet("/deleteResume")
public class DeleteResume extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		ResumeDAO dao = new ResumeDAO(DBConnect.getConn());
		HttpSession session = req.getSession();

		if (dao.deleteResume(id)) {
			session.setAttribute("succMsg", "Resume Delete Sucessfully");
			resp.sendRedirect("add_resume.jsp");
		} else {
			session.setAttribute("failedMsg", "Something wrong on server");
			resp.sendRedirect("add_resume.jsp");
		}
	}

}
