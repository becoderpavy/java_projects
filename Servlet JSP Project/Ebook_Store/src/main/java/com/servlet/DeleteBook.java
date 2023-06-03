package com.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BookDao;
import com.db.DbConnect;

@WebServlet("/delete")
public class DeleteBook extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			int id = Integer.parseInt(req.getParameter("id"));
			BookDao dao = new BookDao(DbConnect.getConn());
			Boolean f = dao.deleteBook(id);

			HttpSession session = req.getSession();

			if (f) {

				session.setAttribute("succMsg", "Books Delete Sucessfully");
				resp.sendRedirect("admin/view_book.jsp");
			} else {
				session.setAttribute("errorMsg", "Something Went Wrong on Server");
				resp.sendRedirect("admin/view_book.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
