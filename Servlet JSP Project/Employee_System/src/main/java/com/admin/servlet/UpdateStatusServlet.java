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
import com.emp.db.DBConnect;

@WebServlet("/updatestatus")
public class UpdateStatusServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			int uid=Integer.parseInt(req.getParameter("uid"));
			String st=req.getParameter("st");
			String ty=req.getParameter("ty");
			int tyno=Integer.parseInt(req.getParameter("tyno"));
			HttpSession session = req.getSession();
			
			if("at".equals(ty))
			{
				AttendanceDAO d1=new AttendanceDAO(DBConnect.getConnection());
				
				if("ap".equals(st))
				{
					d1.updateStatus(tyno, uid, "Approved");
					session.setAttribute("succMsg", "Attendance Approved Sucessfully");
					resp.sendRedirect("admin/admin_status.jsp");
				}else {
					d1.updateStatus(tyno, uid, "Rejected");
					session.setAttribute("failedMsg", "Attendance Rejected");
					resp.sendRedirect("admin/admin_status.jsp");
				}
					
				
			}else if("le".equals(ty))
			{
				LeaveDAO d2=new LeaveDAO(DBConnect.getConnection());
				if("ap".equals(st))
				{
					d2.updateStatus(tyno, uid, "Approved");
					session.setAttribute("succMsg", "Leave Approved Sucessfully");
					resp.sendRedirect("admin/admin_status.jsp");
				}else {
					d2.updateStatus(tyno, uid, "Rejected");
					session.setAttribute("failedMsg", "Leave Rejected");
					resp.sendRedirect("admin/admin_status.jsp");
				}
				
				
			}else if("ex".equals(ty))
			{
				ExpenseDAO d3=new ExpenseDAO(DBConnect.getConnection());
				if("ap".equals(st))
				{
					d3.updateStatus(tyno, uid, "Approved");
					session.setAttribute("succMsg", "Expense Approved Sucessfully");
					resp.sendRedirect("admin/admin_status.jsp");
				}else {
					d3.updateStatus(tyno, uid, "Rejected");
					session.setAttribute("failedMsg", "Expense Rejected");
					resp.sendRedirect("admin/admin_status.jsp");
				}
			}
			
			else if("he".equals(ty))
			{
				HelplineDAO d7=new HelplineDAO(DBConnect.getConnection());
				if("ap".equals(st))
				{
					d7.updateStatus(tyno, uid, "Approved");
					session.setAttribute("succMsg", "Expense Approved Sucessfully");
					resp.sendRedirect("admin/admin_status.jsp");
				}else {
					d7.updateStatus(tyno, uid, "Rejected");
					session.setAttribute("failedMsg", "Expense Rejected");
					resp.sendRedirect("admin/admin_status.jsp");
				}
			}
			
			
			else {
				ResignDAO d4=new ResignDAO(DBConnect.getConnection());
				
				if("ap".equals(st))
				{
					d4.updateStatus(tyno, uid, "Approved");
					session.setAttribute("succMsg", "Resign Approved Sucessfully");
					resp.sendRedirect("admin/admin_status.jsp");
				}else {
					d4.updateStatus(tyno, uid, "Rejected");
					session.setAttribute("failedMsg", "Resign Rejected");
					resp.sendRedirect("admin/admin_status.jsp");
				}
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
