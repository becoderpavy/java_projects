package com.servlet.admin;

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

import com.dao.CategoryDao;
import com.db.DBConnect;
import com.entites.Category;

@MultipartConfig
@WebServlet("/addCategory")
public class AddCategory extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String title = req.getParameter("title");
		Part p = req.getPart("img");
		String fileName = p.getSubmittedFileName();

		Category cat = new Category(title, fileName);

		CategoryDao dao = new CategoryDao(DBConnect.getConnection());
		HttpSession session = req.getSession();

		if (dao.addCategory(title, fileName)) {
			String path = req.getServletContext().getRealPath("") + "img/category_img" + File.separator + fileName;
			/* System.out.println(path); */
			File file = new File(path);
			p.write(path);
			session.setAttribute("succMsg", "Added successfully");
			resp.sendRedirect("admin/category.jsp");

		} else {
			session.setAttribute("errorMsg", "something wrong on server");
			resp.sendRedirect("admin/category.jsp");
		}

	}

}
