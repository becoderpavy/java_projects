package com.servlet.admin;

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

import com.dao.StoreDAO;
import com.db.DBConnect;
import com.entites.Store;

@WebServlet("/addStore")
@MultipartConfig
public class AddStore extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String storeName = req.getParameter("storeName");
		String mobNo = req.getParameter("mobNo");
		String address = req.getParameter("address");

		Part p = req.getPart("img");
		String storeImg = p.getSubmittedFileName();

		Store s = new Store(storeName, mobNo, address, storeImg);

		StoreDAO dao = new StoreDAO(DBConnect.getConn());
		HttpSession session = req.getSession();

		if (dao.addStore(s)) {
			String path = req.getServletContext().getRealPath("") + "store_img" + File.separator + storeImg;
			//System.out.println(path);
			File file = new File(path);
			p.write(path);

			session.setAttribute("succMsg", "Store Added Sucessfully");
			resp.sendRedirect("admin/add_store.jsp");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
			resp.sendRedirect("admin/add_store.jsp");
		}

	}

}
