package com.admin.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
import com.mysql.cj.Session;

@WebServlet("/AdminAddBookServlet")
@MultipartConfig
public class AdminAddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String bname = request.getParameter("bname");
			String author = request.getParameter("author");
			Integer price = Integer.parseInt(request.getParameter("price"));
			String btype = request.getParameter("btype");
			String bstatus = request.getParameter("bstatus");
			Part part = request.getPart("bimg");
			String fileName = part.getSubmittedFileName();

			bookDtls ob = new bookDtls(bname, author, price, btype, bstatus, fileName,"admin");

			// save book in database
			BookDAO dao = new BookDAOImpl(ConnectionProvider.getConnection());
			boolean f = dao.AddAdminBook(ob);
			HttpSession session=request.getSession();
			// redirect page
			if (f) {
				session.setAttribute("sucessMsg","Books Add Sucessfully");
				response.sendRedirect("admin/add_books.jsp");
			} else {
				session.setAttribute("errorMsg","Something Went Wrong on Server");
				response.sendRedirect("admin/add_books.jsp");
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
	
	

	/*
	 * String path=request.getRealPath("book")+File.separator+fname; InputStream is=
	 * part.getInputStream();
	 * 
	 * boolean f=fileUpload(is,path);
	 * 
	 * if(f) { System.out.println("file successd"); } else {
	 * System.out.println("please upload"); }
	 * 
	 * 
	 * System.out.println(path); System.out.println(part); }
	 * 
	 * public boolean fileUpload(InputStream is, String path) { boolean f=false; try
	 * { byte[] data=new byte[is.available()]; is.read(); FileOutputStream fos=new
	 * FileOutputStream(path); fos.write(data); fos.close(); f=true;
	 * 
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * return f;
	 * 
	 * }
	 */
}
