package com.store.servlet;

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

import com.dao.StoreDAO;
import com.entity.Category;
import com.util.DBConnect;

@WebServlet("/updateCategory")
@MultipartConfig
public class UpdateCategory extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String title = req.getParameter("title");
		Part p = req.getPart("img");
		int id = Integer.parseInt(req.getParameter("id"));
		String fileName = "";

		StoreDAO dao = new StoreDAO(DBConnect.getConnection());

		if (p.getSubmittedFileName().isEmpty()) {
			fileName = dao.getCategoryById(id).getImageName();
		} else {
			fileName = p.getSubmittedFileName();
		}

		Category cat = new Category(id, title, fileName);

		HttpSession session = req.getSession();

		if (dao.updateCategory(title, fileName, id)) {

			if (!p.getSubmittedFileName().isEmpty()) {
				String path = req.getServletContext().getRealPath("") + "category_img" + File.separator + fileName;
				/* System.out.println(path); */
				File file = new File(path);
				p.write(path);
			}

			session.setAttribute("succMsg", "Update sucesfully");
			resp.sendRedirect("artist/category.jsp");

		} else {
			session.setAttribute("errorMsg", "something wrong on server");
			resp.sendRedirect("artist/category.jsp");
		}

	}

}
