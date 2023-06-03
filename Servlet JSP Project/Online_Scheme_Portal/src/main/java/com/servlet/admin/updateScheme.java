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

import com.dao.SchemeDAO;
import com.db.DBConnect;
import com.entites.Scheme;

@WebServlet("/updateScheme")
@MultipartConfig
public class updateScheme extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String schemeName = req.getParameter("schemeName");
			String description = req.getParameter("description");
			String siteLink = req.getParameter("siteLink");
			String publishDate = req.getParameter("publishDate");
			String category = req.getParameter("category");
			Part p = req.getPart("files");
			String fileName = "";

			int id = Integer.parseInt(req.getParameter("id"));
			SchemeDAO dao = new SchemeDAO(DBConnect.getConnection());
			if (p.getSubmittedFileName().isEmpty()) {
				fileName = dao.getSchemeById(id).getFileName();
			} else {
				fileName = p.getSubmittedFileName();
			}

			Scheme sc = new Scheme(id, schemeName, description, siteLink, publishDate, fileName, category);

			HttpSession session = req.getSession();

			if (dao.updateScheme(sc)) {
				if (!p.getSubmittedFileName().isEmpty()) {
					String path = req.getServletContext().getRealPath("") + "scheme_file" + File.separator + fileName;
					/* System.out.println(path); */
					File file = new File(path);
					p.write(path);
				}
				session.setAttribute("succMsg", "Scheme Update Sucessfully");
				resp.sendRedirect("admin/index.jsp");
			} else {

				session.setAttribute("errorMsg", "something wrong on server");
				resp.sendRedirect("admin/index.jsp");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}