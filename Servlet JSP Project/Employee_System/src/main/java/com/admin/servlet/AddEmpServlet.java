package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emp.dao.UserDAO;
import com.emp.db.DBConnect;
import com.emp.entity.UserDtls;

@WebServlet("/add_emp")
public class AddEmpServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String fn = req.getParameter("fn");
			String ln = req.getParameter("ln");
			String un = req.getParameter("un");
			String ps = req.getParameter("ps");
			String em = req.getParameter("em");
			String cn = req.getParameter("cn");
			String ad = req.getParameter("ad");
			Double sa = Double.parseDouble(req.getParameter("sa"));
			String qu = req.getParameter("qu");
			String st = req.getParameter("st");

			UserDtls u = new UserDtls(fn, ln, un, ps, em, cn, ad, sa, qu, st);
			// System.out.println(u);
			HttpSession session = req.getSession();
			UserDAO dao = new UserDAO(DBConnect.getConnection());
			boolean f2 = dao.checkUser(em, un);
			if (f2) {
				boolean f = dao.addEmp(u);

				if (f) {
					session.setAttribute("succMsg", "Employee Added Sucessfully");
					resp.sendRedirect("admin/addemp.jsp");
				} else {
					session.setAttribute("failedMsg", "Something error in server");
					resp.sendRedirect("admin/addemp.jsp");
				}

			} else {
				session.setAttribute("failedMsg", "Username or Email Already Exist");
				resp.sendRedirect("admin/addemp.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
