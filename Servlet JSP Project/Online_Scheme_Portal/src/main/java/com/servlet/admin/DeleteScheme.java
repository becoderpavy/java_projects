package com.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SchemeDAO;
import com.db.DBConnect;

@WebServlet("/deleteScheme")
public class DeleteScheme extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));

			HttpSession session = req.getSession();
			SchemeDAO dao = new SchemeDAO(DBConnect.getConnection());

			if (dao.deleteScheme(id)) {
				session.setAttribute("succMsg", "Scheme Delete Sucessfully");
				resp.sendRedirect("admin/index.jsp");
			} else {
				session.setAttribute("errorMsg", "something wrong on server");
				resp.sendRedirect("admin/index.jsp");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
