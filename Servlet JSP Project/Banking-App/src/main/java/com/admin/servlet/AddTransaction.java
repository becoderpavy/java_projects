package com.admin.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDAOImpl;
import com.dao.UserDAOImpl;
import com.db.DbConnect;
import com.entity.AccountTransaction;

@WebServlet("/add_transaction")
public class AddTransaction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String accno = req.getParameter("accno");
			Double amt = Double.parseDouble(req.getParameter("amt"));
			String transType = req.getParameter("transtype");

			UserDAOImpl dao = new UserDAOImpl(DbConnect.getConn());
			Double totalBal = dao.checkBalance(accno);

			AdminDAOImpl dao2 = new AdminDAOImpl(DbConnect.getConn());

			AccountTransaction trans = new AccountTransaction();
			trans.setAccno(accno);
			trans.setTransType(transType);
			trans.setBalance(amt);
			trans.setTransDate(LocalDate.now().toString());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH.mm");
			trans.setTransTime(LocalTime.now().format(formatter));

			HttpSession session = req.getSession();

			if ("Credit".equals(transType)) {
				totalBal += amt;
				boolean f = dao2.updateBalance(accno, totalBal);
				trans.setTransDtls("Cash Deposit");
				dao2.addTransaction(trans);

				session.setAttribute("msg", "Cash Deposit Sucessfully");
				resp.sendRedirect("admin/new_transaction.jsp");
			} else if ("Debit".equals(transType)) {
				
				if(totalBal>=amt)
				{
					totalBal -= amt;
					dao2.updateBalance(accno, totalBal);
					trans.setTransDtls("Cash withdraw from bank");
					dao2.addTransaction(trans);

					session.setAttribute("msg", "Cash Withdraw Sucessfully");
					resp.sendRedirect("admin/new_transaction.jsp");
				}else {
					session.setAttribute("failedMsg", "Insufficent Balance");
					resp.sendRedirect("admin/new_transaction.jsp");
				}	
			} else {
				session.setAttribute("failedMsg", "Select transaction type..");
				resp.sendRedirect("admin/new_transaction.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
