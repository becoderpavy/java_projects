package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DepartmentDAO;
import com.db.DbConnect;

@WebServlet("/adddepart")
public class AddDepartment extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String dtype = req.getParameter("de");
			String nm = req.getParameter("nm");

			DepartmentDAO dao = new DepartmentDAO(DbConnect.getConn());
			boolean f2 = dao.checkDepart(id, dtype);

			HttpSession session = req.getSession();

			if (f2) {
				boolean f = dao.addDepart(id, dtype);
				if (f) {
					session.setAttribute("succMsg", "Department Added Sucessfully");
					resp.sendRedirect("admin/deprt.jsp?id=" + id + "&&nm=" + nm);
				} else {
					session.setAttribute("errorMsg", "Something Went Wrong on Server");
					resp.sendRedirect("admin/deprt.jsp?id=" + id + "&&nm=" + nm);
				}
			} else {
				session.setAttribute("errorMsg", "Department Already Added");
				resp.sendRedirect("admin/deprt.jsp?id=" + id +"&&nm=" + nm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
