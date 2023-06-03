package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BookDAOImpl;
import com.conn.ConnectionProvider;
import com.entity.bookDtls;
import com.mysql.cj.Session;

@WebServlet("/editBookAdminServlet")
public class editBookAdminServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		BookDAOImpl dao=new BookDAOImpl(ConnectionProvider.getConnection());
		bookDtls b=dao.getBookById(id);
		if(b!=null) {
			HttpSession session=req.getSession();
			session.setAttribute("book", b);
			resp.sendRedirect("admin/edit_book.jsp");
		}
	}

}
