package com.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.QueryDAO;
import com.Db.DBConnect;
import com.entity.Answer;
import com.entity.Query;

@WebServlet("/answer")
public class ViewQueriesServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int qid = Integer.parseInt(req.getParameter("qid"));
			QueryDAO dao = new QueryDAO(DBConnect.getConn());
			Query qu = dao.getQueryById(qid);
			List<Answer> ans = dao.getAnswerById(qid);

			if (qu != null) {
				req.setAttribute("query", qu);
				req.setAttribute("ans", ans);
				req.getRequestDispatcher("answer.jsp").forward(req, resp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
