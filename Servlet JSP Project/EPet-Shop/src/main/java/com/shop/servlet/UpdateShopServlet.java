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

@WebServlet("/update_shop")
public class UpdateShopServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(req.getParameter("id"));
			String on = req.getParameter("on");
			String sn = req.getParameter("sn");
			String phno = req.getParameter("phno");
			String ad = req.getParameter("ad");
			String ci = req.getParameter("ci");
			String sta = req.getParameter("sta");
			String em = req.getParameter("em");
			String psw = req.getParameter("psw");
			
			ShopDtls s=new ShopDtls(id, on, sn, phno, ad, ci, sta, em, psw);
			
			HttpSession session = req.getSession();

			ShopDAOImpl dao = new ShopDAOImpl(DBConnect.getConn());
			
			boolean f=dao.update(s);
			if (f) {
				session.setAttribute("succMsg", "Shop Details Update Successfully..");
				resp.sendRedirect("shop/shop_details.jsp");

			} else {
				// System.out.println("Something wrong on server..");
				session.setAttribute("failedMsg", "Something wrong on server..");
				resp.sendRedirect("shop/shop_details.jsp");
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 

}
