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
import com.entity.News;

@WebServlet("/AddNewsServlet")
public class AddNewsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String title = req.getParameter("title");
			String desc = req.getParameter("description");
			String username = req.getParameter("name");

			News n = new News();
			n.setTitle(title);
			n.setDescription(desc);
			n.setUserName(username);

			NewsDAO dao = new NewsDAO(DBConnect.getConn());
			boolean f = dao.saveNews(n);
			HttpSession session = req.getSession();
			if (f) {
				session.setAttribute("msg", "News added Sucessfully");
				resp.sendRedirect("AddNews.jsp");
			} else {
				session.setAttribute("msg", "Something went wrong on server");
				resp.sendRedirect("AddNews.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
