package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emp.dao.HelplineDAO;
import com.emp.db.DBConnect;

@WebServlet("/resp_ticket")
public class UpdateTicketStatus extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int tid = Integer.parseInt(req.getParameter("tid"));
			int uid = Integer.parseInt(req.getParameter("uid"));
			String st =req.getParameter("ms");

			
			HelplineDAO dao = new HelplineDAO(DBConnect.getConnection());
			boolean f = dao.updateStatus(tid, uid, st);
			HttpSession session = req.getSession();
			if (f) {
				session.setAttribute("succMsg", "Respond Sucessfully..");
				resp.sendRedirect("admin/view_ticket_status.jsp");
			} else {
				session.setAttribute("failedMsg", "Something error in server");
				resp.sendRedirect("admin/view_ticket_status.jsp");
			}

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
