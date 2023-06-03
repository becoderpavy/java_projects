package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CartDAO;
import com.util.DBConnect;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			int uid = Integer.parseInt(req.getParameter("uid"));
			int pid = Integer.parseInt(req.getParameter("pid"));

			CartDAO dao = new CartDAO(DBConnect.getConnection());
			HttpSession session = req.getSession();

			if (dao.addCart(pid, uid)) {
				session.setAttribute("succMsg", "Medicine Added to Cart");
				resp.sendRedirect("all_paints.jsp?cat=all");
			} else {
				session.setAttribute("errorMsg", "something wrong on server");
				resp.sendRedirect("all_paints.jsp?cat=all");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
