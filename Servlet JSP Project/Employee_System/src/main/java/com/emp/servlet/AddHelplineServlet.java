package com.emp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emp.dao.HelplineDAO;
import com.emp.db.DBConnect;
import com.emp.entity.Helpline;

@WebServlet("/add_helpline")
public class AddHelplineServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String ti = req.getParameter("ti");
			String re = req.getParameter("re");
			int uid = Integer.parseInt(req.getParameter("uid"));
			String st = "Pending";

			Helpline h = new Helpline(ti, re, uid, st);
			HelplineDAO dao = new HelplineDAO(DBConnect.getConnection());
			boolean f = dao.addHelpline(h);
			HttpSession session = req.getSession();
			if (f) {
				session.setAttribute("succMsg", "Your Ticket Apply Sucessfully.. As soon As Our team contact you.");
				resp.sendRedirect("helpline.jsp");
			} else {
				session.setAttribute("failedMsg", "Something error in server");
				resp.sendRedirect("helpline.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
