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

@WebServlet("/bookUpdateServlet")
public class bookUpdateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(req.getParameter("bookId"));
			String bname = req.getParameter("bname");
			String author = req.getParameter("author");
			Integer price = Integer.parseInt(req.getParameter("price"));
			String categorie = req.getParameter("btype");
			String status = req.getParameter("bstatus");
			
			bookDtls b=new bookDtls();
			b.setId(id);
			b.setBookName(bname);
			b.setAuthorName(author);
			b.setPrice(price);
			b.setCategories(categorie);
			b.setBookStatus(status);
			
			
			BookDAOImpl dao=new BookDAOImpl(ConnectionProvider.getConnection());
			boolean f=dao.editBookUpdate(b);
			HttpSession session=req.getSession();
			if(f) {
				session.setAttribute("sucessMsg","Books Update Sucessfully");
				resp.sendRedirect("admin/all_books.jsp");
			}
			else {
				session.setAttribute("errorMsg","Something Went Wrong on Server");
				resp.sendRedirect("admin/all_books.jsp");
			}
				
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
