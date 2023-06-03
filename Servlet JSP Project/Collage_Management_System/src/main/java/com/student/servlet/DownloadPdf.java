package com.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.dao.MarkDAO;
import com.admin.dao.StudentDAO;
import com.conn.DBConnect;
import com.entity.GeneratePdf;
import com.entity.Mark;
import com.entity.Student;

@WebServlet("/download_pdf")
public class DownloadPdf extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		try {

			int id = Integer.parseInt(request.getParameter("sid"));
			String semestar = request.getParameter("sem");

			StudentDAO d1 = new StudentDAO(DBConnect.getConn());
			Student s = d1.getStudentById(id);
			MarkDAO d2 = new MarkDAO(DBConnect.getConn());
			List<Mark> m = d2.getMark(id, semestar);

			boolean f = GeneratePdf.getPdf(s, m);
			HttpSession session = request.getSession();
			if (m != null) {
				session.setAttribute("dmsg", "Mark sheet Downloaded..Check Your Download Folder");
				resp.sendRedirect("student/one_result.jsp?id=" + id + "&&semestar=" + semestar);
			} else {
				session.setAttribute("dmsg", "Something error..");
				resp.sendRedirect("student/one_result.jsp?id="+id+ "&&semestar=" + semestar);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
