package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CartDAOImpl;
import com.DAO.OrderDAOImpl;
import com.DAO.PetDAOImpl;
import com.DAO.ShopDAOImpl;
import com.DAO.UserDAOImpl;
import com.DB.DBConnect;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String ty = req.getParameter("ty");
			int id = Integer.parseInt(req.getParameter("id"));
			
			UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());
			ShopDAOImpl dao2 = new ShopDAOImpl(DBConnect.getConn());
			CartDAOImpl dao3=new CartDAOImpl(DBConnect.getConn());
			OrderDAOImpl dao4=new OrderDAOImpl(DBConnect.getConn());
			PetDAOImpl dao5=new PetDAOImpl(DBConnect.getConn());
			
			HttpSession session = req.getSession();
			if ("us".equals(ty)) {
				boolean f = dao.deleteUser(id);
				if (f) {
					
					dao3.deleteuser(id);
					dao4.deleteuser(id);
					
					session.setAttribute("succMsg", "User Delete Sucessfully.");
					resp.sendRedirect("admin/view_user.jsp");
				} else {
					session.setAttribute("failedMsg", "Something wrong on server");
					resp.sendRedirect("admin/view_user.jsp");
				}
			} else {
				boolean f2 = dao2.deleteShop(id);
				if (f2) {
					dao5.deleteshop(id);
					session.setAttribute("succMsg", "Shop Delete Sucessfully.");
					resp.sendRedirect("admin/view_shop.jsp");
				} else {
					session.setAttribute("failedMsg", "Something wrong on server");
					resp.sendRedirect("admin/view_shop.jsp");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
