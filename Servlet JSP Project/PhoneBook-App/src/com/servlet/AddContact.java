package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DbConnect;
import com.dao.ContactDAO;
import com.entity.Contact;

@WebServlet("/addContact")
public class AddContact extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int userId = Integer.parseInt(req.getParameter("userid"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phno = req.getParameter("phno");
		String about = req.getParameter("about");
		HttpSession session = req.getSession();
		
		ContactDAO dao2=new ContactDAO(DbConnect.getConn());
		boolean f2=dao2.checkContact(name,phno);
		
		if(f2)
		{
			if(phno.length() == 10) {
				Contact c = new Contact(name, email, phno, about, userId);
				ContactDAO dao = new ContactDAO(DbConnect.getConn());

				boolean f = dao.saveContact(c);
				if (f) {
					session.setAttribute("succMsg", "Your Contact Saved..");
					resp.sendRedirect("addContact.jsp");
				} else {
					session.setAttribute("failedMsg", "Something wrong on server..");
					resp.sendRedirect("addContact.jsp");
				}
			} else {
				session.setAttribute("failedMsg", "Enter Valid Phone Number");
				resp.sendRedirect("addContact.jsp");
			}
		}else {
			session.setAttribute("failedMsg", "User Already Exist");
			resp.sendRedirect("addContact.jsp");
		}
		
	}

}
