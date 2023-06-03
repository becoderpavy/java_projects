package com.transport.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.transport.conn.DbConnect;
import com.transport.dao.FeedbackDao;

@WebServlet("/updateFb")
public class UpdateFeedback extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String response = req.getParameter("response");
		// System.out.println(id);

		FeedbackDao dao = new FeedbackDao(DbConnect.getConnection());
		boolean f = dao.updateFeedback(response, id);
		HttpSession session = req.getSession();
		if (f) {
			session.setAttribute("succMsg", "Send Success");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}
		resp.sendRedirect("admin/view_queries.jsp");

	}

}
