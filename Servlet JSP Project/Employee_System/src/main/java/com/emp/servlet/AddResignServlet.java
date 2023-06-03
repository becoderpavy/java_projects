package com.emp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emp.dao.ResignDAO;
import com.emp.db.DBConnect;
import com.emp.entity.Resign;

@WebServlet("/add_resign")
public class AddResignServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String rt = req.getParameter("rt");
			String rd = req.getParameter("rd");
			String lw = req.getParameter("lw");
			String ns = req.getParameter("ns");
			String cn = req.getParameter("cn");
			String re = req.getParameter("re");
			int ui = Integer.parseInt(req.getParameter("ui"));
			String st = "Pending";

			Resign r = new Resign(rt, rd, lw, ns, cn, re, ui, st);

			HttpSession session = req.getSession();

			ResignDAO dao = new ResignDAO(DBConnect.getConnection());
			boolean f = dao.AddResign(r);

			if (f) {
				session.setAttribute("succMsg", "Resign Apply Sucessfully.. Wait for Approval");
				resp.sendRedirect("resign.jsp");
			} else {
				session.setAttribute("failedMsg", "Something error in server");
				resp.sendRedirect("resign.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
