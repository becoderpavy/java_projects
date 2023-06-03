package com.emp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emp.dao.LeaveDAO;
import com.emp.db.DBConnect;
import com.emp.entity.Leave;

@WebServlet("/leave")
public class AddLeaveServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String lt = req.getParameter("lt");
			String df = req.getParameter("df");
			String dt = req.getParameter("dt");
			String nd = req.getParameter("nd");
			String cn = req.getParameter("cn");
			String re = req.getParameter("re");
			int uid = Integer.parseInt(req.getParameter("uid"));
			String st = "Pending";

			Leave l = new Leave(lt, df, dt, nd, cn, re, uid, st);

			LeaveDAO dao = new LeaveDAO(DBConnect.getConnection());
			boolean f = dao.Addleave(l);
			HttpSession session = req.getSession();
			if (f) {
				session.setAttribute("succMsg", "Leave Apply Sucessfully.. Wait for Approval");
				resp.sendRedirect("leave.jsp");
			} else {
				session.setAttribute("failedMsg", "Something error in server");
				resp.sendRedirect("leave.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
