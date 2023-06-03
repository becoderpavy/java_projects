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

import com.dao.MoviesDAO;
import com.db.DBConnect;
import com.entites.Movies;

@WebServlet("/addMovies")
@MultipartConfig
public class AddMovies extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String moviesName = req.getParameter("moviesName");
			String language = req.getParameter("language");
			String category = req.getParameter("category");
			String ratings = req.getParameter("ratings");
			String quantity = req.getParameter("quantity");
			String cost = req.getParameter("cost");
			String description = req.getParameter("description");
			int storeId = Integer.parseInt(req.getParameter("storeId"));

			Part p = req.getPart("img");
			String imgFileName = p.getSubmittedFileName();

			Movies m = new Movies(moviesName, language, category, ratings, quantity, cost, description, storeId,
					imgFileName);

			MoviesDAO dao = new MoviesDAO(DBConnect.getConn());
			HttpSession session = req.getSession();

			if (dao.addMovies(m)) {
				String path = req.getServletContext().getRealPath("") + "movies_img" + File.separator + imgFileName;
				// System.out.println(path);
				File file = new File(path);
				p.write(path);

				session.setAttribute("succMsg", "Movies Added Sucessfully");
				resp.sendRedirect("admin/add_vcd.jsp");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
				resp.sendRedirect("admin/add_vcd.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
