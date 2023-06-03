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
import com.entity.Query;

@WebServlet("/categories")
public class CategorieServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String categories = req.getParameter("cat");


			QueryDAO dao = new QueryDAO(DBConnect.getConn());
			List<Query> list = dao.getQueriesByCategory(categories);

			if (list.isEmpty()) {
				HttpSession session=req.getSession();
				session.setAttribute("failedMsg", "Query Not Available");
				resp.sendRedirect("categories_post.jsp");

			} else {
				req.setAttribute("list", list);
				req.getRequestDispatcher("categories_post.jsp").forward(req, resp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
