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
import com.entity.Expense;
import com.entity.User;

@WebServlet("/updateExpense")
public class UpdateExpenseServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String date = req.getParameter("date");
		String time = req.getParameter("time");
		String description = req.getParameter("description");
		String price = req.getParameter("price");

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("loginUser");

		Expense ex = new Expense(title, date, time, description, price, user);
		ex.setId(id);
		
		
		ExpenseDao dao = new ExpenseDao(HibernateUtil.getSessionFactory());
		boolean f = dao.updateExpense(ex);

		if (f) {
			session.setAttribute("msg", "Expense Update sucessfully");

			resp.sendRedirect("user/view_expense.jsp");
		} else {
			session.setAttribute("msg", "Something wrong on server");

			resp.sendRedirect("user/view_expense.jsp");
		}

	}
}
