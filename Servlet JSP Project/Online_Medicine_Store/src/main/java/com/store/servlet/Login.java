package com.store.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.StoreDAO;
import com.entity.MedicineStore;
import com.util.DBConnect;

@WebServlet("/alogin")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String em = req.getParameter("email");
			String ps = req.getParameter("password");
			StoreDAO dao = new StoreDAO(DBConnect.getConnection());
			HttpSession session = req.getSession();
			
			MedicineStore art=dao.login(em, ps);
			
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
