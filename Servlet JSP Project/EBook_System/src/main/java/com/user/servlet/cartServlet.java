package com.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BookDAOImpl;
import com.DAO.CartDAOImpl;
import com.conn.ConnectionProvider;
import com.entity.bookDtls;
import com.entity.cart;

@WebServlet("/cartServlet")
public class cartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int bid = Integer.parseInt(req.getParameter("bid"));
			int uid = Integer.parseInt(req.getParameter("uid"));
			BookDAOImpl bdao=new BookDAOImpl(ConnectionProvider.getConnection());
			bookDtls book=bdao.getBookById(bid);
			
			cart c=new cart();
			c.setBid(bid);
			c.setUid(uid);
			c.setBookName(book.getBookName());
			c.setAuthor(book.getAuthorName());
			c.setPrice(book.getPrice());
			
			CartDAOImpl cart=new CartDAOImpl(ConnectionProvider.getConnection());
			boolean f=cart.addCart(c);
			HttpSession session=req.getSession();
			if(f)
			{
				session.setAttribute("addMsg","Book Added to Cart");
				resp.sendRedirect("new_book.jsp");
			}else {
				session.setAttribute("notaddMsg","Book Not Added to Cart");
				resp.sendRedirect("new_book.jsp");
			}
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
