package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.NewsDAO;
import com.conn.DBConnect;
import com.entity.Comment;
import com.entity.News;

@WebServlet("/oneNews")
public class SingleNewsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("nid"));
		NewsDAO dao = new NewsDAO(DBConnect.getConn());
		News n = dao.getOneNews(id);
		List<Comment> commentList = dao.getComment(id);

		if (n != null) {
			req.setAttribute("singleNews", n);
			req.setAttribute("comntList", commentList);
			req.getRequestDispatcher("/oneNews.jsp").forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
