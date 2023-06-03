package com.servlet;

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

import com.dao.BookDao;
import com.db.DbConnect;
import com.entity.Book;

@WebServlet("/addbook")
@MultipartConfig
public class AddBooks extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String bn = req.getParameter("bn");
			String au = req.getParameter("au");
			String de = req.getParameter("de");

			Part p = req.getPart("img");
			String imgName = p.getSubmittedFileName();

			Part p2 = req.getPart("pdf");
			String pdfName = p2.getSubmittedFileName();

			String st = req.getParameter("st");

			String desc = req.getParameter("desc");
			Book b = new Book(bn, au, de, imgName, pdfName, st, desc);
			BookDao dao = new BookDao(DbConnect.getConn());
			boolean f = dao.addBook(b);

			HttpSession session = req.getSession();
			// redirect page
			if (f) {

				String imgpath = req.getServletContext().getRealPath("") + "book_img" + File.separator + imgName;
				File file = new File(imgpath);
				p.write(imgpath);
				//System.out.println(imgpath);
				String pdfpath = req.getServletContext().getRealPath("") + "book_pdf" + File.separator + pdfName;
				File file2 = new File(pdfpath);
				p2.write(pdfpath);

				session.setAttribute("succMsg", "Books Add Sucessfully");
				resp.sendRedirect("admin/add_book.jsp");
			} else {
				session.setAttribute("errorMsg", "Something Went Wrong on Server");
				resp.sendRedirect("admin/add_book.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
