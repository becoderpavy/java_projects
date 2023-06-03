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

@WebServlet("/alogin")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String em = req.getParameter("email");
			String ps = req.getParameter("password");
			ArtistDAO dao = new ArtistDAO(DBConnect.getConnection());
			HttpSession session = req.getSession();
			
			Artist art=dao.login(em, ps);
			
			if (art != null) {
				session.setAttribute("artObj", art);
				resp.sendRedirect("artist/home.jsp");
			} else {
				session.setAttribute("errorMsg", "invalid email and password");
				resp.sendRedirect("alogin.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
