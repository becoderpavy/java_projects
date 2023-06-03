package com.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BookDAOImpl;
import com.conn.ConnectionProvider;
import com.entity.bookDtls;


@WebServlet("/serchServlet")
public class serchServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ch=req.getParameter("ch");
		
		BookDAOImpl dao=new BookDAOImpl(ConnectionProvider.getConnection());
		List<bookDtls> blist=dao.getBookBySearch(ch);
		
		HttpSession session=req.getSession();
		if(blist!=null)
		{
			session.setAttribute("bookList", blist);
			resp.sendRedirect("search_book.jsp");
		}
		else {
			session.setAttribute("msg", "Item is not available");
			resp.sendRedirect("search_book.jsp");
		}
		
	}
	

}
