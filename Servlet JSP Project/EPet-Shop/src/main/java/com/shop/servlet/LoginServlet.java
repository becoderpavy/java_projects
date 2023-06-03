
package com.shop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.ShopDAOImpl;
import com.DB.DBConnect;
import com.entity.ShopDtls;

@WebServlet("/slogin")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			ShopDAOImpl dao = new ShopDAOImpl(DBConnect.getConn());

			HttpSession session = req.getSession();

			String email = req.getParameter("email");
			String password = req.getParameter("password");

			ShopDtls sh = dao.login(email, password);

			if (sh != null) {
				session.setAttribute("shopobj", sh);
				resp.sendRedirect("shop/home.jsp");
			} else {
				session.setAttribute("failedMsg", "Email & Password Invalid");
				resp.sendRedirect("login.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
