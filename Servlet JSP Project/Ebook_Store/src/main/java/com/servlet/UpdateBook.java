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

@WebServlet("/updatebook")
@MultipartConfig
public class UpdateBook extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String bn = req.getParameter("bn");
			String au = req.getParameter("au");
			String de = req.getParameter("de");

			Part p = req.getPart("img");

			String imgName = p.getSubmittedFileName();

			Part p2 = req.getPart("pdf");
			String pdfName = p2.getSubmittedFileName();

			String st = req.getParameter("st");

			String desc = req.getParameter("desc");
			
			Book b = new Book();
			b.setId(id);
			b.setBookName(bn);
			b.setAuthor(au);
			b.setDepartment(de);
			b.setStatus(st);
			b.setDescription(desc);

			HttpSession session = req.getSession();
			BookDao dao = new BookDao(DbConnect.getConn());
			

			Book bk = dao.getBookById(id);
			String oldimgFile = bk.getImageName();
			String oldpdfFile = bk.getPdfName();
			File files;
			
			if(imgName.length()>0 && pdfName.length()>0) 
			{
				b.setImageName(imgName);
				b.setPdfName(pdfName);
				
				boolean f = dao.updateBook(b);
				
				if(f)
				{
					//delete img
					String oldimg = req.getServletContext().getRealPath("") + "book_img" + File.separator + oldimgFile;
					files = new File(oldimg);
					files.delete();

					//update new img
					String newImg = req.getServletContext().getRealPath("") + "book_img" + File.separator + imgName;
					files = new File(newImg);
					p.write(newImg);
					
					//delete pdf 
					String oldpdfpath = req.getServletContext().getRealPath("") + "book_pdf" + File.separator
							+ oldpdfFile;
					 files = new File(oldpdfpath);
					files.delete();

					//upload pdf
					String newPdf = req.getServletContext().getRealPath("") + "book_pdf" + File.separator + pdfName;
					files = new File(newPdf);
					p2.write(newPdf);
					
					//System.out.println("update with img & pdf");
					session.setAttribute("succMsg", "Books Update Sucessfully");
					resp.sendRedirect("admin/edit_book.jsp?id="+id);
				
				} else {
					session.setAttribute("errorMsg", "Something Went Wrong on Server");
					resp.sendRedirect("admin/edit_book.jsp?id="+id);
				}
				
			}else {
				
			//update with image
				if(imgName.length()>0)
				{
					b.setImageName(imgName);
					boolean f=dao.updateBookWithImg(b);
					if(f)
					{
						//delete img
						String oldimg = req.getServletContext().getRealPath("") + "book_img" + File.separator + oldimgFile;
						files = new File(oldimg);
						files.delete();

						//update new img
						String newImg = req.getServletContext().getRealPath("") + "book_img" + File.separator + imgName;
						files = new File(newImg);
						p.write(newImg);
						
						//System.out.println("update only img");
						session.setAttribute("succMsg", "Books Update Sucessfully");
						resp.sendRedirect("admin/edit_book.jsp?id="+id);
					} else {
						session.setAttribute("errorMsg", "Something Went Wrong on Server");
						resp.sendRedirect("admin/edit_book.jsp?id="+id);
					}
					
				// update with pdf	
				}else if(pdfName.length()>0)
				{
					b.setPdfName(pdfName);
					boolean f=dao.updateBookWithPdf(b);
					
					if(f)
					{
						//delete pdf 
						String oldpdfpath = req.getServletContext().getRealPath("") + "book_pdf" + File.separator
								+ oldpdfFile;
						 files = new File(oldpdfpath);
						files.delete();

						//upload pdf
						String newPdf = req.getServletContext().getRealPath("") + "book_pdf" + File.separator + pdfName;
						files = new File(newPdf);
						p2.write(newPdf);
						
						//System.out.println("update only pdf");
						session.setAttribute("succMsg", "Books Update Sucessfully");
						resp.sendRedirect("admin/edit_book.jsp?id="+id);
					} else {
						session.setAttribute("errorMsg", "Something Went Wrong on Server");
						resp.sendRedirect("admin/edit_book.jsp?id="+id);
					}	
					
				}
				//update without img & pdf
				else 
				{
					boolean f=dao.updateBook(b);
					if(f)
					{
						//System.out.println("update without img & pdf");
						session.setAttribute("succMsg", "Books Update Sucessfully");
						resp.sendRedirect("admin/edit_book.jsp?id="+id);
					} else {
						session.setAttribute("errorMsg", "Something Went Wrong on Server");
						resp.sendRedirect("admin/edit_book.jsp?id="+id);
					}
				}
				
			}
			
			/*
			 * if (f) {
			 * 
			 * if (imgName.length() > 0) { String oldimg =
			 * req.getServletContext().getRealPath("") + "book_img" + File.separator +
			 * oldimgFile; File file = new File(oldimg); file.deleteOnExit();
			 * 
			 * String newImg = req.getServletContext().getRealPath("") + "book_img" +
			 * File.separator + imgName; File file2 = new File(newImg); p.write(newImg); }
			 * 
			 * // System.out.println(imgpath);
			 * 
			 * if (pdfName.length() > 0) { String oldpdfpath =
			 * req.getServletContext().getRealPath("") + "book_pdf" + File.separator +
			 * oldpdfFile; File file3 = new File(oldpdfpath); file3.deleteOnExit();
			 * 
			 * String newPdf = req.getServletContext().getRealPath("") + "book_pdf" +
			 * File.separator + pdfName; file3 = new File(newPdf); p2.write(newPdf); }
			 * 
			 * session.setAttribute("succMsg", "Books Add Sucessfully");
			 * resp.sendRedirect("admin/edit_book.jsp?id="+id); } else {
			 * session.setAttribute("errorMsg", "Something Went Wrong on Server");
			 * resp.sendRedirect("admin/edit_book.jsp?id="+id); }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
