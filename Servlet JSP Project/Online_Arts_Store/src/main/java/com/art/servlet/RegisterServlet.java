package com.art.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ArtistDAO;
import com.entity.Artist;
import com.util.DBConnect;

@WebServlet("/asignup")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String fn = req.getParameter("fullname");
			String sn = req.getParameter("shopname");
			String em = req.getParameter("email");
			String mb = req.getParameter("mobno");
			String ps = req.getParameter("password");
			String ad = req.getParameter("address");
			String ci = req.getParameter("city");
			String st = req.getParameter("state");
			String pi = req.getParameter("pin");

			Artist artists = new Artist(fn, sn, em, mb, ps, ad, ci, st, pi);

			ArtistDAO dao = new ArtistDAO(DBConnect.getConnection());
			HttpSession session = req.getSession();

			if (dao.checkEmail(em)) {

				if (dao.saveArtist(artists)) {
					session.setAttribute("succMsg", "Register successfully");
					resp.sendRedirect("asignup.jsp");
				} else {
					session.setAttribute("errorMsg", "something wrong on server");
					resp.sendRedirect("asignup.jsp");
				}

			} else {
				session.setAttribute("errorMsg", "Email id already exist");
				resp.sendRedirect("asignup.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
