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

@WebServlet("/updateemp")
public class UpdateEmpServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(req.getParameter("id"));
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
			u.setId(id);
			// System.out.println(u);
			HttpSession session = req.getSession();
			UserDAO dao = new UserDAO(DBConnect.getConnection());
			
			boolean f = dao.updateEmp(u);

				if (f) {
					session.setAttribute("succMsg", "Employee Update Sucessfully");
					resp.sendRedirect("admin/view_emp.jsp");
				} else {
					session.setAttribute("failedMsg", "Something error in server");
					resp.sendRedirect("admin/view_emp.jsp");
				}

			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
