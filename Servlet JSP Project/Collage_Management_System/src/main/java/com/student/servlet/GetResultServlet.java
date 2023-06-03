package com.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.dao.MarkDAO;
import com.conn.DBConnect;
import com.entity.Mark;

@WebServlet("/getresult")
public class GetResultServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String stuid = request.getParameter("id");
			String sem = request.getParameter("semestar");

			MarkDAO dao = new MarkDAO(DBConnect.getConn());
			Mark m = dao.getMarkByID(stuid, sem);
			HttpSession session = request.getSession();

			if (m != null) {
				request.setAttribute("resu", m);
				resp.sendRedirect("student/one_result.jsp?id=" + stuid + "&&semestar=" + sem);
			} else {
				session.setAttribute("msg", "Result Not Available");
				resp.sendRedirect("student/one_result.jsp?id=" + stuid + "&&semestar=" + sem);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
