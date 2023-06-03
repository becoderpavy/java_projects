package com.store.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.StoreDAO;
import com.util.DBConnect;

@WebServlet("/delete_paint")
public class DeleteMedicine extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int pid=Integer.parseInt(req.getParameter("id"));
			int artid=Integer.parseInt(req.getParameter("artid"));
			
			StoreDAO dao = new StoreDAO(DBConnect.getConnection());
			HttpSession session = req.getSession();

			if (dao.deletePaintings(pid, artid)) {
				session.setAttribute("DeMsg", "Delete successfully");
				resp.sendRedirect("artist/painting.jsp");

			} else {
				session.setAttribute("DeMsg", "something wrong on server");
				resp.sendRedirect("artist/painting.jsp");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
