package com.prog.Send_Mail_App_2;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Mail Send Application");
		System.out.println("----------------------");

		String msg = "Account Created Sucessfully..";
		String sub = "Account Opening";
		String to = "daspabitra55@gmail.com";
		String from = "techlife246@gmail.com";

		//App.sendMail(msg, sub, to, from);
		App.sendFileWithMail(msg, sub, to, from);

	}

	public static void sendMail(String msg, String sub, String to, String from) {
		Properties prop = System.getProperties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("techlife246@gmail.com", "pabitradas1");
			}
		});

		MimeMessage m = new MimeMessage(session);
		try {

			m.setFrom(from);
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setSubject(sub);
			m.setText(msg);

			Transport.send(m);
			System.out.println("Email Send Sucessfully..");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void sendFileWithMail(String msg, String sub, String to, String from) {

		Properties prop = System.getProperties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("techlife246@gmail.com", "pabitradas1");
			}
		});

		MimeMessage m = new MimeMessage(session);

		try {
			m.setFrom(from);
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setSubject(sub);

			MimeMultipart mpart = new MimeMultipart();

			MimeBodyPart mbody = new MimeBodyPart();
			MimeBodyPart textMime=new MimeBodyPart();
			
			
			textMime.setText(msg);

			String path = "D:\\p1.jpg";
			File f = new File(path);
			try {

				mbody.attachFile(f);
				mpart.addBodyPart(mbody);
				mpart.addBodyPart(textMime);

			} catch (Exception e) {
				e.printStackTrace();
			}

			m.setContent(mpart);
			Transport.send(m);
			System.out.println("Mail send with File Sucess..");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
