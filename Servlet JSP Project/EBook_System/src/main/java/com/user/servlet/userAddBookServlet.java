package com.user.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DAO.BookDAO;
import com.DAO.BookDAOImpl;
import com.conn.ConnectionProvider;
import com.entity.bookDtls;

@WebServlet("/userAddBookServlet")
@MultipartConfig
public class userAddBookServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String bname = request.getParameter("bname");
			String author = request.getParameter("author");
			Integer price = Integer.parseInt(request.getParameter("price"));
			Part part = request.getPart("bimg");
			String fileName = part.getSubmittedFileName();
			String userEmail=request.getParameter("email");
			bookDtls ob = new bookDtls(bname, author, price, "Old", "Active", fileName,userEmail);

			// save book in database
			BookDAO dao = new BookDAOImpl(ConnectionProvider.getConnection());
			boolean f = dao.AddAdminBook(ob);
			HttpSession session=request.getSession();
			// redirect page
			if (f) {
				session.setAttribute("sucessMsg","Books Add Sucessfully");
				response.sendRedirect("sell_book.jsp");
			} else {
				session.setAttribute("errorMsg","Something Went Wrong on Server");
				response.sendRedirect("sell_book.jsp");
			}

			//book store into folder
			String uploadPath = getServletContext().getRealPath("") + "book";
			File uploadDir = new File(uploadPath);
			part.write(uploadPath + File.separator + fileName);
			System.out.println(uploadPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
