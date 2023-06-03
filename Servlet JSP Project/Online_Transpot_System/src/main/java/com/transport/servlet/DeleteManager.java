package com.transport.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.transport.conn.DbConnect;
import com.transport.dao.UserDAO;

@WebServlet("/deleteManager")
public class DeleteManager extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			int id = Integer.parseInt(req.getParameter("id"));

			UserDAO dao = new UserDAO(DbConnect.getConnection());

			HttpSession session = req.getSession();

			boolean f = dao.deleteUser(id);
			// System.out.println(f);
			if (f) {
				session.setAttribute("succMsg", "Delete Success");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
			}

			resp.sendRedirect("admin/view_manager.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
