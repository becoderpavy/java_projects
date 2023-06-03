package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.NewsDAO;
import com.conn.DBConnect;
import com.entity.Comment;

@WebServlet("/comment")
public class CommentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			int newsid = Integer.parseInt(req.getParameter("nid"));
			String username = req.getParameter("username");
			String comment = req.getParameter("comment");

			Comment cm = new Comment();
			cm.setUserName(username);
			cm.setComment(comment);
			cm.setNewsId(newsid);

			NewsDAO dao = new NewsDAO(DBConnect.getConn());
			boolean f = dao.addComment(cm);
			HttpSession session = req.getSession();
			if (f) {
				session.setAttribute("msg", "Comment Posted");
				resp.sendRedirect("/News/viewServlet");

			} else {
				session.setAttribute("errormsg", "Something went wrong on server..");
				resp.sendRedirect("/News/viewServlet");
			}

		} catch (Exception e) {

		}
	}

}
