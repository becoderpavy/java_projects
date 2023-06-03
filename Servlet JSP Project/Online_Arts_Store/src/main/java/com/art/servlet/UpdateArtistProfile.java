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

@WebServlet("/aeditProfile")
public class UpdateArtistProfile extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String fn = req.getParameter("fullname");
			String sn = req.getParameter("shopname");
			String em = req.getParameter("email");
			String mb = req.getParameter("mobno");
			
			String ad = req.getParameter("address");
			String ci = req.getParameter("city");
			String st = req.getParameter("state");
			String pi = req.getParameter("pin");
			int id =Integer.parseInt(req.getParameter("id"));
			Artist artists = new Artist(fn, sn, em, mb, "", ad, ci, st, pi);
			artists.setId(id);
			ArtistDAO dao = new ArtistDAO(DBConnect.getConnection());
			HttpSession session = req.getSession();


				if (dao.updateArtist(artists)) {
					Artist art=dao.getArtist(id);
					session.setAttribute("artObj", art);
					session.setAttribute("succMsgp", "Profile Update successfully");
					resp.sendRedirect("artist/aedit_profile.jsp");
				} else {
					session.setAttribute("errorMsgp", "something wrong on server");
					resp.sendRedirect("artist/aedit_profile.jsp");
				}

			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

}
