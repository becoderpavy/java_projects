package com.store.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.dao.StoreDAO;
import com.entity.Medicine;
import com.util.DBConnect;

@WebServlet("/update_paint")
public class UpdateMedicine extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String nm = req.getParameter("name");
			String de = req.getParameter("description");
			String pr = req.getParameter("price");
			String ca = req.getParameter("category");
			
			int id=Integer.parseInt(req.getParameter("id"));

			Medicine pain = new Medicine(nm, de, pr, ca, "",id);
			pain.setId(id);
			
			StoreDAO dao = new StoreDAO(DBConnect.getConnection());
			HttpSession session = req.getSession();

			if (dao.updatePaintings(pain)) {
				session.setAttribute("succMsg", "Update successfully");
				resp.sendRedirect("artist/painting.jsp");

			} else {
				session.setAttribute("errorMsg", "something wrong on server");
				resp.sendRedirect("artist/painting.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
