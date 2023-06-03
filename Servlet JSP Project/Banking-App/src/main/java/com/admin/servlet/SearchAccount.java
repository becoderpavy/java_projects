package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAOImpl;
import com.db.DbConnect;
import com.entity.User;

@WebServlet("/srchtrans")
public class SearchAccount extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String accno=req.getParameter("accno");
			
			UserDAOImpl dao=new UserDAOImpl(DbConnect.getConn());
			User us=dao.findUser(accno);
			HttpSession session=req.getSession();
			if(us!=null)
			{
				Double bal=dao.checkBalance(accno);
				session.setAttribute("usobj", us);
				session.setAttribute("balance", bal);
				resp.sendRedirect("admin/new_transaction.jsp");
			}
			else {
				session.setAttribute("msg", "Account is not Available");
				resp.sendRedirect("admin/new_transaction.jsp");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
