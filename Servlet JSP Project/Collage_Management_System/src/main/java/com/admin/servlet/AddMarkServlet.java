package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.dao.MarkDAO;
import com.conn.DBConnect;
import com.entity.Mark;

@WebServlet("/add_mark")
public class AddMarkServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String roll = req.getParameter("roll");
			int stuid = Integer.parseInt(req.getParameter("sid"));
			String name = req.getParameter("sname");
			String course = req.getParameter("course");
			String sem = req.getParameter("sem");
			String sub = req.getParameter("subject");
			int mark = Integer.parseInt(req.getParameter("mark"));

			Mark m = new Mark(stuid, roll, name, course, sem, sub, mark);
			MarkDAO dao = new MarkDAO(DBConnect.getConn());
			HttpSession session = req.getSession();
			boolean f1 = dao.markAddCheck(stuid, sub);

			if (f1) {
				boolean f = dao.addMark(m);
				if (f) {
					session.setAttribute("succMsg", "Mark Add Sucessfully");
					resp.sendRedirect("admin/add_mark.jsp?id=" + stuid);
				} else {
					session.setAttribute("failedMsg", "Something wrong on server");
					resp.sendRedirect("admin/add_mark.jsp?id=" + stuid);
				}
			} else {
				session.setAttribute("failedMsg", "Already Mark Added");
				resp.sendRedirect("admin/add_mark.jsp?id=" + stuid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
