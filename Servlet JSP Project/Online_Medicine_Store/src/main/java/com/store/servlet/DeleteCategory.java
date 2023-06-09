package com.store.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.StoreDAO;
import com.util.DBConnect;

@WebServlet("/deleteCategory")
public class DeleteCategory extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		StoreDAO dao = new StoreDAO(DBConnect.getConnection());

		HttpSession session = req.getSession();

		if (dao.deleteCategory(id)) {

			session.setAttribute("succMsg", "Delete sucesfully");
			resp.sendRedirect("artist/category.jsp");

		} else {
			session.setAttribute("errorMsg", "something wrong on server");
			resp.sendRedirect("artist/category.jsp");
		}

	}

}
