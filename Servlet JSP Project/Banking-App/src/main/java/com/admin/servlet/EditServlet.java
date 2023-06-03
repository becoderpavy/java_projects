package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDAOImpl;
import com.db.DbConnect;
import com.entity.User;

@WebServlet("/update")
public class EditServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String accno=req.getParameter("accno");
			String uname = req.getParameter("uname");
			String fn = req.getParameter("fname");
			String ln = req.getParameter("lname");
			String em = req.getParameter("email");
			String ph = req.getParameter("phno");

			String dob = req.getParameter("dob");
			String adh = req.getParameter("adhno");
			String add = req.getParameter("address");
			String city = req.getParameter("city");
			String st = req.getParameter("state");
			String status = req.getParameter("sts");
			
			User us=new User();
			us.setAccountNo(accno);
			us.setUserid(uname);
			us.setFirstName(fn);
			us.setLastName(ln);
			us.setEmail(em);
			us.setNumber(ph);
			us.setDob(dob);
			us.setAdhar(adh);
			us.setAddress(add);
			us.setCity(city);
			us.setState(st);
			us.setStatus(status);
			
			AdminDAOImpl dao=new AdminDAOImpl(DbConnect.getConn());
			boolean f=dao.editUserAccount(us);
			
			HttpSession session=req.getSession();
			
			if(f)
			{
				session.setAttribute("succmsg", "Account update Sucessfully");
				resp.sendRedirect("admin/all_user.jsp");
			}else {
				session.setAttribute("failedmsg", "Something wrong on server ");
				resp.sendRedirect("admin/all_user.jsp");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
