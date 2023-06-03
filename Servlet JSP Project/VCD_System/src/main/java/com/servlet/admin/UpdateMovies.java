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

@WebServlet("/updateMovies")
@MultipartConfig
public class UpdateMovies extends HttpServlet {

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
			int id = Integer.parseInt(req.getParameter("id"));
			Part p = req.getPart("img");
			String imgFileName = "";

			MoviesDAO dao = new MoviesDAO(DBConnect.getConn());

			if (p.getSubmittedFileName().isEmpty()) {
				imgFileName = dao.getMoviesById(id).getImg();
			} else {
				imgFileName = p.getSubmittedFileName();
			}

			Movies m = new Movies(id, moviesName, language, category, ratings, quantity, cost, description, storeId,
					imgFileName);

			HttpSession session = req.getSession();

			if (dao.updateMovies(m)) {

				if (!p.getSubmittedFileName().isEmpty()) {
					String path = req.getServletContext().getRealPath("") + "movies_img" + File.separator + imgFileName;
					// System.out.println(path);
					File file = new File(path);
					p.write(path);
				}

				session.setAttribute("succMsg", "Movies update Sucessfully");
				resp.sendRedirect("admin/view_vcd.jsp");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
				resp.sendRedirect("admin/view_vcd.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
