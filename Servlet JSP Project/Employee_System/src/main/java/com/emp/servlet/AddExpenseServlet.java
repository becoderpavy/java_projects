package com.emp.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.emp.dao.ExpenseDAO;
import com.emp.db.DBConnect;
import com.emp.entity.Expenses;

@WebServlet("/add_expense")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 30, maxRequestSize = 1024 * 1024
		* 50)
public class AddExpenseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String an = req.getParameter("an");
			String et = req.getParameter("et");
			String de = req.getParameter("de");
			String mi = req.getParameter("mi");
			String ed = req.getParameter("ed");
			Double ca = Double.parseDouble(req.getParameter("ca"));

			Part p = req.getPart("dn");

			String dn = p.getSubmittedFileName();

			int uid = Integer.parseInt(req.getParameter("uid"));
			String st = "Pending";
			Expenses e = new Expenses(an, et, de, mi, ed, ca, dn, uid, st);

			ExpenseDAO dao = new ExpenseDAO(DBConnect.getConnection());

			boolean f = dao.addExpense(e);
			HttpSession session = req.getSession();

			if (f) {
				String path = req.getServletContext().getRealPath("") + "exp_document" + File.separator + dn;
				File file = new File(path);
				p.write(path);
				session.setAttribute("succMsg", "Expense Claim Sucessfully.. Wait for Approval");
				resp.sendRedirect("expense.jsp");
			} else {
				session.setAttribute("failedMsg", "Something error in server");
				resp.sendRedirect("expense.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
