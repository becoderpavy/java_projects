package com.user.servlet;

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

@WebServlet("/sendmoney")
public class SendMoneyServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String send_accno = req.getParameter("accno");
			String send_userName = req.getParameter("uname");

			// System.out.println(send_accno + " " + send_userName);

			String recv_accno = req.getParameter("sender_accno");
			String name = req.getParameter("name");
			Double amt = Double.parseDouble(req.getParameter("amt"));

			// System.out.println(recv_accno + " " + name + " " + amt);

			AdminDAOImpl dao = new AdminDAOImpl(DbConnect.getConn());
			UserDAOImpl dao2 = new UserDAOImpl(DbConnect.getConn());

			boolean f = dao.findSenderAccount(recv_accno);

			// System.out.println(f);

			Double sender_total_bal = dao2.checkBalance(send_accno);
			Double recv_total_bal = dao2.checkBalance(recv_accno);

			// System.out.println(sender_total_bal + " " + recv_total_bal);

			HttpSession session = req.getSession();

			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH.mm");
			AccountTransaction sender_trans = new AccountTransaction();
			sender_trans.setAccno(send_accno);
			sender_trans.setBalance(amt);
			sender_trans.setTransDate(LocalDate.now().toString());
			sender_trans.setTransTime(LocalTime.now().format(formatter).toString());
			sender_trans.setTransType("Debit");
			sender_trans.setTransDtls("Money transfer to " + name + ",Acc no: " + recv_accno);

			AccountTransaction recv_trans = new AccountTransaction();
			recv_trans.setAccno(recv_accno);
			recv_trans.setBalance(amt);
			recv_trans.setTransDate(LocalDate.now().toString());
			recv_trans.setTransTime(LocalTime.now().format(formatter).toString());
			recv_trans.setTransType("Credit");
			recv_trans.setTransDtls("Money recived from " + send_userName + ",Acc no: " + send_accno);

			if (!send_accno.equals(recv_accno)) {
				if (f) {

					if (amt <= sender_total_bal) {

						sender_total_bal -= amt;
						recv_total_bal += amt;

						dao.updateBalance(send_accno, sender_total_bal);
						dao.updateBalance(recv_accno, recv_total_bal);

						dao.addTransaction(sender_trans);
						dao.addTransaction(recv_trans);

						session.setAttribute("succmsg", "Money Transfer Sucessfully.");
						resp.sendRedirect("send_money.jsp");

					} else {
						session.setAttribute("failedmsg", "Insufficient Balance");
						resp.sendRedirect("send_money.jsp");
					}

				} else {
					session.setAttribute("failedmsg", "Account No is Incorrect");
					resp.sendRedirect("send_money.jsp");
				}

			} else {
				session.setAttribute("failedmsg", "Cant Send Money to Yourself");
				resp.sendRedirect("send_money.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
