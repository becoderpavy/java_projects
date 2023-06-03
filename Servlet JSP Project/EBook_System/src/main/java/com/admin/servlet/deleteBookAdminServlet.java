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

@WebServlet("/deleteBookAdminServlet")
public class deleteBookAdminServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			Integer id=Integer.parseInt(req.getParameter("id"));
			
			BookDAOImpl dao=new BookDAOImpl(ConnectionProvider.getConnection());
			boolean f=dao.deleteBook(id);
			
			HttpSession session=req.getSession();
			if(f) {
				session.setAttribute("sucessMsg","Books Delete Sucessfully");
				resp.sendRedirect("admin/all_books.jsp");
			}
			else {
				session.setAttribute("errorMsg","Something Went Wrong on Server");
				resp.sendRedirect("admin/all_books.jsp");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
