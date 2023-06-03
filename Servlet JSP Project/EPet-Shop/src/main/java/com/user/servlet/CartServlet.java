package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CartDAOImpl;
import com.DAO.PetDAOImpl;
import com.DB.DBConnect;
import com.entity.CartDtls;
import com.entity.PetDtls;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			int pid = Integer.parseInt(req.getParameter("pid"));
			int uid = Integer.parseInt(req.getParameter("uid"));
			int sid = Integer.parseInt(req.getParameter("sid"));
			String ca = req.getParameter("ca");

			PetDAOImpl d1 = new PetDAOImpl(DBConnect.getConn());
			PetDtls p = d1.getPetsById(pid);

			CartDtls c = new CartDtls();
			c.setUserId(uid);
			c.setShopId(sid);
			c.setPetsId(pid);
			c.setPetsName(p.getPetName());
			c.setPrice(p.getPrice());
			c.setCategorie(p.getCategory());

			CartDAOImpl dao2 = new CartDAOImpl(DBConnect.getConn());
			boolean f = dao2.addCart(c);

			HttpSession session = req.getSession();

			if (f) {
				session.setAttribute("addCart", "Added to cart");
				resp.sendRedirect("animals.jsp?ca=" + ca);

			} else {
				session.setAttribute("failed", "Something Wrong on server");
				resp.sendRedirect("index.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
