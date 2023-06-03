package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ExpenseDao;
import com.db.HibernateUtil;

@WebServlet("/deleteExepnse")
public class DeleteExpenseServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		ExpenseDao dao = new ExpenseDao(HibernateUtil.getSessionFactory());
		boolean f = dao.deleteExpense(id);

		HttpSession session = req.getSession();

		if (f) {
			session.setAttribute("msg", "Delete Sucessfully");
			resp.sendRedirect("user/view_expense.jsp");
		} else {
			session.setAttribute("msg", "something wrong on server");
			resp.sendRedirect("user/view_expense.jsp");
		}

	}

}
