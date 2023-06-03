package com.Servlet;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.Db.DBConnect;
import com.entity.UserDetails;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("fname");
		String email = request.getParameter("uemail");
		String password = request.getParameter("upassword");

		UserDetails us = new UserDetails();
		us.setName(name);
		us.setEmail(email);
		us.setPassword(password);

		UserDAO dao = new UserDAO(DBConnect.getConn());

		boolean f2 = dao.findEmail(email);
		HttpSession session;

		if (f2) {

			String msg = "Hello Dear " + name + ",Your Account Created Succesfully...";
			String subject = "Acccount Created Confirmation";
			String to = email;
			String from = "daspabitra55@gmail.com";
			SendEmail(msg, subject, to, from);

			boolean f = dao.addUser(us);
			if (f) {
				session = request.getSession();
				session.setAttribute("reg-sucess", "Registration Sucessfully..");
				response.sendRedirect("register.jsp");
			} else {
				session = request.getSession();
				session.setAttribute("failed-msg", "Something went wrong on server");
				response.sendRedirect("register.jsp");
			}
		} else {
			session = request.getSession();
			session.setAttribute("failed-msg", "User Already Exist..");
			response.sendRedirect("register.jsp");
		}
	}
	
	
	private static void SendEmail(String msg, String subject, String to, String from) {
		// TODO Auto-generated method stub

		// variable gmail host
		String host = "smtp.gmail.com";

		// get system properties
		Properties properties = System.getProperties();
		System.out.println(properties);

		// setting important information to properties object
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// step-1 get session
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("*****@gmail.com", "password");
			}
		});
		session.setDebug(true);

		// step-2 compose msg
		MimeMessage m = new MimeMessage(session);
		try {
			// from email
			m.setFrom(from);

			// add reciepnt
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// add subject
			m.setSubject(subject);
			m.setText(msg);

			// step-3 send messgae using transport class
			Transport.send(m);

			System.out.println("Send Success");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
