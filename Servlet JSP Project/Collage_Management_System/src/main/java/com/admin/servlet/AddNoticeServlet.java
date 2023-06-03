package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.dao.NoticeDAO;
import com.conn.DBConnect;

@WebServlet("/add_notice")
public class AddNoticeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String name = req.getParameter("name");
			String message = req.getParameter("message");
			NoticeDAO dao = new NoticeDAO(DBConnect.getConn());
			boolean f = dao.addNotice(name, message);
			HttpSession session = req.getSession();
			if (f) {
				session.setAttribute("succMsg", "Notice Add Sucessfully");
				resp.sendRedirect("admin/home.jsp");
			} else {
				session.setAttribute("succMsg", "Something wrong on server");
				resp.sendRedirect("admin/home.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
