package com.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CartDAO;
import com.db.DBConnect;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			int uid = Integer.parseInt(req.getParameter("uid"));
			int mid = Integer.parseInt(req.getParameter("mid"));
			String page = req.getParameter("pg");
			CartDAO dao = new CartDAO(DBConnect.getConn());
			HttpSession session = req.getSession();

			if ("stm".equals(page)) {
				int sid=Integer.parseInt(req.getParameter("sid"));
				if (dao.addCart(mid, uid)) {
					session.setAttribute("succMsg", "Movies Added to Cart");
				} else {
					session.setAttribute("errorMsg", "something wrong on server");
				}
				resp.sendRedirect("store_movies.jsp?id="+sid);
			}

			else if ("vm".equals(page)) {

				if (dao.addCart(mid, uid)) {
					session.setAttribute("succMsg", "Movies Added to Cart");
				} else {
					session.setAttribute("errorMsg", "something wrong on server");
				}
				resp.sendRedirect("view_movie.jsp?id="+mid);
			}

			else {
				if (dao.addCart(mid, uid)) {
					session.setAttribute("succMsg", "Movies Added to Cart");

				} else {
					session.setAttribute("errorMsg", "something wrong on server");

				}
				resp.sendRedirect("all_movies.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
