package com.art.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ArtistDAO;
import com.dao.UserDAO;
import com.entity.Artist;
import com.entity.User;
import com.util.DBConnect;

@WebServlet("/achangepassword")
public class AChangePassword extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String newPass = req.getParameter("newpassword");
			String oldPass = req.getParameter("oldpassword");
			int id = Integer.parseInt(req.getParameter("id"));

			ArtistDAO dao = new ArtistDAO(DBConnect.getConnection());
			HttpSession session = req.getSession();

			if (dao.checkOldPasssword(id, oldPass)) {
				if (dao.updateNewPasssword(id, newPass)) {
					Artist art = dao.getArtist(id);
					session.setAttribute("artObj", art);
					session.setAttribute("succMsg", "Password change successfully");
					resp.sendRedirect("artist/aedit_profile.jsp");
				} else {
					session.setAttribute("errorMsg", "something wrong on server");
					resp.sendRedirect("artist/aedit_profile.jsp");
				}
			} else {
				session.setAttribute("errorMsg", "wrong old password");
				resp.sendRedirect("artist/aedit_profile.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
