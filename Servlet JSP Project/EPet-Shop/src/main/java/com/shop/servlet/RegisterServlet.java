package com.shop.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DAO.ShopDAOImpl;
import com.DB.DBConnect;
import com.entity.ShopDtls;

@WebServlet("/shop_register")
@MultipartConfig
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String on = req.getParameter("on");
			String sn = req.getParameter("sn");
			String phno = req.getParameter("phno");
			String ad = req.getParameter("ad");
			String ci = req.getParameter("ci");
			String sta = req.getParameter("sta");
			String em = req.getParameter("em");
			String psw = req.getParameter("psw");
			Part p = req.getPart("img");
			String im = p.getSubmittedFileName();
			String ro = "Shop";
			String stu = "Active";

			// System.out.println(name+" "+email+" "+phno+" "+password+" "+check);

			ShopDtls shop = new ShopDtls(on, sn, phno, ad, ci, sta, em, psw, im, ro, stu);

			HttpSession session = req.getSession();

			ShopDAOImpl dao = new ShopDAOImpl(DBConnect.getConn());

			boolean f2 = dao.checkUser(em);
			if (f2) {

				boolean f = dao.shopRegister(shop);

				if (f) {
					String path=req.getServletContext().getRealPath("")+"shop_img"+File.separator+im;
					//System.out.println(path);
					File file=new File(path);
					p.write(path);
					session.setAttribute("succMsg", "Registration Successfully..");
					resp.sendRedirect("register.jsp");

				} else {
					// System.out.println("Something wrong on server..");
					session.setAttribute("failedMsg", "Something wrong on server..");
					resp.sendRedirect("register.jsp");
				}

			} else {
				session.setAttribute("failedMsg", "User Already Exist Try Another Email id");
				resp.sendRedirect("register.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
