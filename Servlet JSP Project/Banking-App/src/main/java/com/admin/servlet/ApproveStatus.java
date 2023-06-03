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
import com.db.DbConnect;
import com.entity.AccountTransaction;

@WebServlet("/admin/approve")
public class ApproveStatus extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String accno = req.getParameter("accno");
			String email = req.getParameter("email");
			String name = req.getParameter("uname");

			AccountTransaction actrns = new AccountTransaction();
			actrns.setAccno(accno);
			actrns.setTransType("Credit");
			actrns.setTransDtls("Account Opening");
			actrns.setBalance(0.00);
			actrns.setTransDate(LocalDate.now().toString());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH.mm");
			actrns.setTransTime(LocalTime.now().format(formatter));

			String msg = "Hello " + name + ",\n Your Account Open Sucssfully. Your Account No:" + accno
					+ ".\n Now You Can Create Netbanking.";
			String sub = "Account Opening Confirmation";
			String to = "techlife246@gmail.com";
			String from = "daspabitra55@gmail.com";

			AdminDAOImpl dao = new AdminDAOImpl(DbConnect.getConn());
			boolean f = dao.updateStatus(accno);
			HttpSession session = req.getSession();
			if (f) {
				dao.setBalance(accno, 0.00);
				dao.addTransaction(actrns);

				//SendEmail(msg, sub, email, from);
				session.setAttribute("sussMsg", "Account Opening Sucessfully");
				resp.sendRedirect("acc_status.jsp");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * private static void SendEmail(String msg, String subject, String to, String
	 * from) { // TODO Auto-generated method stub
	 * 
	 * // variable gmail host String host = "smtp.gmail.com";
	 * 
	 * // get system properties Properties properties = System.getProperties();
	 * 
	 * // setting important information to properties object
	 * properties.put("mail.smtp.host", host); properties.put("mail.smtp.port",
	 * "465"); properties.put("mail.smtp.ssl.enable", "true");
	 * properties.put("mail.smtp.auth", "true");
	 * 
	 * // step-1 get session Session session = Session.getInstance(properties, new
	 * Authenticator() {
	 * 
	 * @Override protected PasswordAuthentication getPasswordAuthentication() { //
	 * TODO Auto-generated method stub return new
	 * PasswordAuthentication("*****@gmail.com", "****@123"); } });
	 * 
	 * // step-2 compose msg MimeMessage m = new MimeMessage(session); try { // from
	 * email m.setFrom(from);
	 * 
	 * // add reciepnt m.addRecipient(Message.RecipientType.TO, new
	 * InternetAddress(to));
	 * 
	 * // add subject m.setSubject(subject); m.setText(msg);
	 * 
	 * // step-3 send messgae using transport class Transport.send(m);
	 * 
	 * } catch (MessagingException e) { e.printStackTrace(); }
	 * 
	 * }
	 */


}
