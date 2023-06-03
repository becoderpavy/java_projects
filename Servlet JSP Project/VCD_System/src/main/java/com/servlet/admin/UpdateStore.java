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

@WebServlet("/updateStore")
@MultipartConfig
public class UpdateStore extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String storeName = req.getParameter("storeName");
			String mobNo = req.getParameter("mobNo");
			String address = req.getParameter("address");

			Part p = req.getPart("img");
			String storeImg = "";
			int id = Integer.parseInt(req.getParameter("id"));

			StoreDAO dao = new StoreDAO(DBConnect.getConn());
			HttpSession session = req.getSession();

			if (p.getSubmittedFileName().isEmpty()) {
				Store st = dao.getStoreById(id);
				storeImg = st.getStoreImg();
			} else {
				storeImg = p.getSubmittedFileName();
			}

			Store s = new Store(id,storeName, mobNo, address, storeImg);
			if (dao.updateStore(s)) {
				if (!p.getSubmittedFileName().isEmpty()) {
					String path = req.getServletContext().getRealPath("") + "store_img" + File.separator + storeImg;
					//System.out.println(path);
					File file = new File(path);
					p.write(path);
				}

				session.setAttribute("succMsg", "Store update Sucessfully");
				resp.sendRedirect("admin/add_store.jsp");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
				resp.sendRedirect("admin/add_store.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
