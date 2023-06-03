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
import com.transport.entites.Feedback;

@WebServlet("/send")
public class AddFeedback extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String message = req.getParameter("message");
		String response = "Pending";

		Feedback fe = new Feedback(username, message, response);
		HttpSession session = req.getSession();

		FeedbackDao dao = new FeedbackDao(DbConnect.getConnection());
		boolean f = dao.createFeedback(fe);

		if (f) {
			session.setAttribute("succMsg", "Send Success");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}
		resp.sendRedirect("user/contact.jsp");

	}

}
