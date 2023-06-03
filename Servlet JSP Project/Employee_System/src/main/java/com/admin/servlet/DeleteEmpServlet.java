package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emp.dao.AttendanceDAO;
import com.emp.dao.ExpenseDAO;
import com.emp.dao.HelplineDAO;
import com.emp.dao.LeaveDAO;
import com.emp.dao.ResignDAO;
import com.emp.dao.UserDAO;
import com.emp.db.DBConnect;

@WebServlet("/deleteemp")
public class DeleteEmpServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		HttpSession session = req.getSession();
		UserDAO dao = new UserDAO(DBConnect.getConnection());
		ResignDAO r = new ResignDAO(DBConnect.getConnection());
		LeaveDAO l = new LeaveDAO(DBConnect.getConnection());
		HelplineDAO h = new HelplineDAO(DBConnect.getConnection());
		ExpenseDAO e = new ExpenseDAO(DBConnect.getConnection());
		AttendanceDAO a = new AttendanceDAO(DBConnect.getConnection());
		boolean f = dao.deleteEmp(id);
		r.deleteData(id);
		l.deleteData(id);
		h.deleteData(id);
		e.deleteData(id);
		a.deleteData(id);

		if (f) {
			session.setAttribute("succMsg", "Employee Delete Sucessfully");
			resp.sendRedirect("admin/view_emp.jsp");
		} else {
			session.setAttribute("failedMsg", "Something error in server");
			resp.sendRedirect("admin/view_emp.jsp");
		}
	}

}
