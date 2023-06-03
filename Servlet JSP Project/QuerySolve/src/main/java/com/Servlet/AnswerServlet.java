package com.Servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.QueryDAO;
import com.Db.DBConnect;

@WebServlet("/add_answer")
public class AnswerServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int quesId = Integer.parseInt(req.getParameter("quesId"));
			String userName = req.getParameter("username");
			String query = req.getParameter("ques");
			String pdate = LocalDate.now().toString();

			QueryDAO dao = new QueryDAO(DBConnect.getConn());

			if (userName.length() == 0) {
				resp.sendRedirect("login.jsp");
			} else {

				boolean f = dao.addAnswer(quesId, query, pdate, userName);
				HttpSession session = req.getSession();

				if (f) {
					session.setAttribute("succMsg", "Answer Submitted");
					resp.sendRedirect("answer?qid="+quesId);
				} else {
					session.setAttribute("failedMsg", "Something wrong on server");
					resp.sendRedirect("answer?qid="+quesId);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
